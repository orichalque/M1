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

		private Model model;
		private static Scanner input;
		private Dataset dataset;
		
		
		public Parser() {
			model = ModelFactory.createDefaultModel();
			dataset = new DatasetImpl(model);
			readingRDF("peinture.rdfs");
			dataset.setDefaultModel(model);
		}
		
		public void exo1() {		
			doRequest("request1.rq");			 
		}
		
		public void exo2() {			
			doRequest("request2.rq"); 
		}
		
		public void exo3() {			
			doRequestUpdate("request3.rq");
			
		}
		
		public void exo4() {
			doRequest("request4_1.rq");
			doRequest("request4_2.rq");
		}
		
		public void exo5() {
			dataset.setDefaultModel(readingInf());
			System.out.println("Modele Inféré");
			doRequestOnDataset("request4_1.rq");
			doRequestOnDataset("request4_2.rq");	
		}
		
		public Model readingInf(){
			InfModel mod = ModelFactory.createRDFSModel(dataset.getDefaultModel());
			System.out.println("Ecriture du modele inféré");
			mod.write(System.out, "TURTLE");
			return mod;
		}
		
		public void readingRDF(String filename){
			
			// Open RDF file
			InputStream in = FileManager.get().open(filename);
			if (in == null) {
			    throw new IllegalArgumentException("File not found");
			}
			// Load file content
			dataset.setDefaultModel(model.read(in, null));	
			//model.write(System.out, "Turtle");
		}
		
		public void doRequestOnDataset(String filename) {
			String request = readQuery(filename);
			System.out.println("\n-> Request on file: \"" + filename + "\"");
			System.out.println(request);
			System.out.println("-> Perform request...\n");
			Query query = QueryFactory.create(request);
			QueryExecution qexec = QueryExecutionFactory.create(query, this.dataset);
			ResultSet results =  qexec.execSelect();
			// Output query results	
			ResultSetFormatter.out(System.out, results, query);
			// Important - free up resources used running the query
			qexec.close();
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
		
		public void doRequestUpdate(String filename) {
			String request = readQuery(filename);
			System.out.println("\n-> Request on file: \"" + filename + "\"");
			System.out.println(request);
			System.out.println("-> Perform request...\n");
			UpdateRequest query = UpdateFactory.create(request);
			UpdateProcessor qexec = UpdateExecutionFactory.create(query, dataset);
			qexec.execute();
		}
		 
		public void doRequest(String filename) {
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
			Parser p = new Parser();
			p.exo1();
			p.exo2();
			p.exo3();
			p.exo4();
			p.exo5();
		}
}
