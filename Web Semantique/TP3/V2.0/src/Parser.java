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
		displayResult(p.doRequest("request2.rq"));
		p.doUpdateOrInsertRequest("request3.rq");
		
	}
	

	public static void displayResult(ResultSet result) {
		QuerySolution solution = null;
		
		for (; result.hasNext() ;){
			solution = result.nextSolution();
			System.out.println(solution.toString());
		}
	}

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

	
	public void doUpdateOrInsertRequest(String request) {
		//Récupération de la requete
		UpdateRequest query = UpdateFactory.create(readQuery(request));
		
		//Execution de la requete sur le dataset actuel
		UpdateProcessor qexec = UpdateExecutionFactory.create(query, this.dataset);
		qexec.execute();
		dataset.getDefaultModel().write(System.out, "TURTLE");
	}
	
	public ResultSet doRequest(String request) {
		String rq = readQuery(request);
		System.out.println("Requete en cours: ");
		System.out.println(rq);
		//On crée la requete
		Query query = QueryFactory.create(rq);
		
		QueryExecution qexec = QueryExecutionFactory.create(query, this.dataset);
		//On lance l'execution de la rq sur le dataset
		ResultSet results = qexec.execSelect();
		
		return results;
	}
	
	/**
	 * @return the dataset
	 */
	public Dataset getDataset() {
		return dataset;
	}
	
	public void loadGraphName(String uri) {
		dataset.addNamedModel(uri, dataset.getDefaultModel());
	}

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
	 * @param dataset the dataset to set
	 */
	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}

}
