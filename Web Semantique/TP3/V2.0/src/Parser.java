import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.core.DatasetImpl;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;

public class Parser {
	
	protected Dataset dataset;
	
	public Parser() {	
		dataset = new DatasetImpl(ModelFactory.createDefaultModel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		p.readRDF("peinture.rdfs");
		p.loadGraphName("graph1");
		System.out.println("~~ Question 1: Affichage des instances de Flemish");
		displayResult(p.doRequest("request1.rq"));
		System.out.println("~~ Question 2: Affichage des noms des instances de Flemish");
		displayResult(p.doRequest("request2.rq"));
		System.out.println("~~ Question 3 ajout d'un cubiste, puis affichage du résultat via la question 4:");
		p.doUpdateOrInsertRequest("request3.rq");
		displayResult(p.doRequest("request4_1.rq"));
		System.out.println("~~ Affichage des instances de la classe Painter sans modèle inféré:");
		displayResult(p.doRequest("request4_2.rq"));
		System.out.println("~~ Passage au modèle inféré");
		p.enableInference();
		System.out.println("~~ Affichage des instances de la classe Painter avec modèle inféré:");
		displayResult(p.doRequest("request4_2.rq"));
		System.out.println("-> On remarque que cette fois ci en utilisant un graphe inféré, Jena est capable de déduire qu'un objet est une instance de la classe painter car il est le domaine de la propriété 'paints'. ");
	}
	
	/**
	 * Transform the current default model in a inferred model and replace it.
	 */
	public void enableInference(){
		InfModel infmodel = null;
		//We create an inferred model FROM our current model
		infmodel = ModelFactory.createRDFSModel(dataset.getDefaultModel());
		//Replacement of our model by the inferred one
		dataset.setDefaultModel(infmodel);
	}
	
	/**
	 * display a resultset in the standard output
	 * @param result
	 */
	public static void displayResult(ResultSet result) {
		QuerySolution solution = null;
		int resultCpt = 0;
		while (result.hasNext()){
			solution = result.nextSolution();
			System.out.println(solution.toString());
			resultCpt++;
		}
		if (resultCpt == 0) {
			System.out.println("Pas de résultat correspondant à la requête");
		}

	}
	
	/**
	 * Read the file containing the query
	 * @param filename
	 * @return String containing the query
	 */
	public static String readQuery(String filename){
		try {
			File file = new File(filename);
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder data = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				data.append(line + "\n");
			}
			inputStream.close();
			return data.toString();
		}
		catch(Exception ex){
			System.out.println("File not found");
			return null;
		}
	}

	/**
	 * Insert or update the default model of the dataset
	 * @param request
	 */
	public void doUpdateOrInsertRequest(String request) {
		//Get the query from the file
		UpdateRequest query = UpdateFactory.create(readQuery(request));
		
		//Execute the request on the default dataset's model
		UpdateProcessor qexec = UpdateExecutionFactory.create(query, this.dataset);
		qexec.execute();
		//Display the dataset default model as a TURTLE
		//dataset.getDefaultModel().write(System.out, "TURTLE");
	}
	
	/**
	 * Do a select request on the default model of the dataset, and return the results as a ResultSet
	 * @param request
	 * @return results, ResultSet answered by the request
	 */
	public ResultSet doRequest(String request) {
		String rq = readQuery(request);
		
		//On crée la requete
		Query query = QueryFactory.create(rq);
		
		QueryExecution qexec = QueryExecutionFactory.create(query, this.dataset);
		//On lance l'execution de la rq sur le dataset
		ResultSet results = qexec.execSelect();
		
		return results;
	}
	
	
	/**
	 * Add a uri to the dataset default graph, easier to get the model afterward
	 * @param uri
	 */
	public void loadGraphName(String uri) {
		dataset.addNamedModel(uri, dataset.getDefaultModel());
	}
	
	/**
	 * Reads the RDF file and set it as a default model for the dataset
	 * @param filename: Name of the file
	 */
	public void readRDF(String filename){	
		// Open RDF file
		InputStream in = FileManager.get().open(filename);
		if (in == null) {
		    throw new IllegalArgumentException("File not found");
		}
		// Load file content in the main model of our dataset
		dataset.getDefaultModel().read(in, null);
		// Write the model of the Dataset
		//dataset.getDefaultModel().write(System.out, "TURTLE");
	}
	
	/**
	 * @return the dataset
	 */
	public Dataset getDataset() {
		return dataset;
	}
	
	/**
	 * @param dataset the dataset to set
	 */
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
}

/*
 * Here are the logs I obtain on my Eclipse, I hope you will have the same !
 * 

~~ Question 1: Affichage des instances de Flemish
( ?s = <http://example.org/r1> ) -> [Root]
~~ Question 2: Affichage des noms des instances de Flemish
( ?name = "Rembrandt" ) ( ?surname = "Smith" )
~~ Question 3 ajout d'un cubiste, puis affichage du résultat via la question 4:
( ?b = "Georges" ) ( ?c = "Braque" )
~~ Affichage des instances de la classe Painter sans modèle inféré:
Pas de résultat correspondant à la requête
~~ Passage au modèle inféré
~~ Affichage des instances de la classe Painter avec modèle inféré:
( ?b = <http://example.org/r1> ) ( ?c = "Rembrandt" ) ( ?d = "Smith" )
( ?b = <http://example.org/r3> ) ( ?c = "Georges" ) ( ?d = "Braque" )
-> On remarque que cette fois ci en utilisant un graphe inféré, Jena est capable de déduire qu'un objet est une instance de la classe painter car il est le domaine de la propriété 'paints'. 

* 
*/

