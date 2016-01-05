import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
  
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;
 
	/** Tutorial 1 creating a simple model
	 */
	public class Sparql_Reader {
	    
		static void exo1() throws FileNotFoundException {
			Model m = ModelFactory.createDefaultModel();
			m.read("peinture.rdfs");
			String request = new Scanner(new File("/comptes/E104607D/Desktop/M1/Web Semantique/TP3/request1.rq")).useDelimiter("\\Z").next();
			UpdateAction.parseExecute(request, m);
			m.write(System.out, "TURTLE");
			
		}
		
	    //UPDATE DU GRAPHE
	    static void updateGraphe() throws FileNotFoundException {
	    	Model m = ModelFactory.createDefaultModel();
	    	m.read("graph.rdf");	    	
	    	String request = new Scanner(new File("/comptes/E104607D/workspace/TP1_SEMANTIQUE/request.rq")).useDelimiter("\\Z").next();
	    	
	    	UpdateAction.parseExecute(request, m);
	    	m.write(System.out, "TURTLE");
	    }
	    

	    public static void main (String args[]) throws FileNotFoundException {
	    	Sparql_Reader.exo1();
	     }
	}

