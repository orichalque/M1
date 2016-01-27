package vv.spoon.logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Thibault Béziers La Fosse
 *
 */
public class MyLogWriter {

    private static PrintWriter fileWriter;
    private static Map<String, Integer> methodsAndCalls;
    
    public static void writeLog() {
    	try {
			fileWriter = getWriter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (Map.Entry<String, Integer> call : methodsAndCalls.entrySet()){
    		fileWriter.write(call.getKey() + ":"+call.getValue()+ "\n");
    	}
        fileWriter.close();
    }

    public static void out(String string) {
    	if (methodsAndCalls == null) {
    		methodsAndCalls = new HashMap<String, Integer>();
    	}
    	Integer calls = methodsAndCalls.get(string);
    	if (calls == null) {
    		//cette method n'a pas encore été appelee
    		calls = 1;
    	} else {
    		calls ++;
    	}
    	methodsAndCalls.put(string, calls);
    	
        try {
            PrintWriter writer = getWriter();
            writer.write(string + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static PrintWriter getWriter() throws FileNotFoundException {
        if(fileWriter == null) {
            ShutdownHookLog shutdownHook = new ShutdownHookLog();
            Runtime.getRuntime().addShutdownHook(shutdownHook);
            fileWriter = new PrintWriter("log");
        }
        return fileWriter;
    }
}

