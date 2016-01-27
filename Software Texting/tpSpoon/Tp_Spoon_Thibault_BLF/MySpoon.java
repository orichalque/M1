package vv.spoon;

import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtExecutable;

/**
 * 
 * @author Thibault Béziers la Fosse
 *
 */
public class MySpoon {

	public static String get(CtExecutable<?> exec) {
		StringBuilder builder = new StringBuilder();
		String name = exec.getParent(CtClass.class).getSimpleName();
		builder.append(name)
				.append(" -> ")
				.append(exec.getSimpleName())
				.append(" -> executions: ");
				
		return builder.toString();
	}
	
	public static void main(String[] args) throws Exception {
		spoon.Launcher.main(args);
	}

}
