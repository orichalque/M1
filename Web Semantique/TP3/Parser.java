import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.core.DatasetImpl;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;



public class Parser {

		private static Model model = ModelFactory.createDefaultModel();
		private static Scanner input;
 
		public static void exo1() {		
			doRequest("request1.rq");			 
		}
		
		public static void exo2() {			
			doRequest("request2.rq"); 
		}
		
		public static void exo3() {			
			doRequestUpdate("request3.rq");
		}
		
		public static void exo4() {
			doRequest("request4_1.rq");
			doRequest("request4_2.rq");
		}
		
		public static void exo5() {
			InfModel infModel = null;
			infModel = ModelFactory.createRDFSModel(this.dataset.getNamedModel(uri));
            dataset.replaceNamedModel(uri, infModel);
            //AJOUTER LOADNAMEDGRAPH POUR AVOIR SON URI
		}
		

		public static void readingRDF(String filename){

			// Open RDF file
			InputStream in = FileManager.get().open(filename);
			if (in == null) {
			    throw new IllegalArgumentException("File not found");
			}
			// Load file content
			model.read(in, null);
			//model.write(System.out, "Turtle");
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
	            return null;
	        }
		}
		
		public static void doRequestUpdate(String filename) {
			String request = readQuery(filename);
			System.out.println("\n-> Request on file: \"" + filename + "\"");
			System.out.println(request);
			System.out.println("-> Perform request...\n");
			Dataset dataset = new DatasetImpl(model);
			UpdateRequest query = UpdateFactory.create(request);
			UpdateProcessor qexec = UpdateExecutionFactory.create(query, dataset);
			qexec.execute();
		}
		
		public static void doRequest(String filename) {
			String request = readQuery(filename);
			System.out.println("\n-> Request on file: \"" + filename + "\"");
			System.out.println(request);
			System.out.println("-> Perform request...\n");
			Query query = QueryFactory.create(request);
			QueryExecution qexec = QueryExecutionFactory.create(query, model);
			ResultSet results =  qexec.execSelect();
			// Output query results	
			ResultSetFormatter.out(System.out, results, query);
			// Important - free up resources used running the query
			qexec.close();
		}
		
		public static void main(String[] args) {
			readingRDF("peinture.rdfs");
			exo1();
			exo2();
			exo3();
			exo4();
		}
}

