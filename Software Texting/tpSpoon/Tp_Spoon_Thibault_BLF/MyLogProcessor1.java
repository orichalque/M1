package vv.spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtMethod;

/**
 * @brief count the functions callings
 * @author Thibault Béziers la Fosse
 *
 */
public class MyLogProcessor1 extends AbstractProcessor<CtExecutable<?>>{
	
	@Override
	public boolean isToBeProcessed(spoon.reflect.declaration.CtExecutable<?> candidate) {
		return candidate instanceof CtMethod;		
	};
	
	@Override
	public void process(CtExecutable<?> exec) {
		// TODO Auto-generated method stub
		String snippet = "vv.spoon.logger.LogWriter.out(\""+ vv.spoon.MySpoon.get(exec) + "\")";
        CtStatement snippetToBeInsered = getFactory().Code().createCodeSnippetStatement(snippet);

        exec.getBody().insertEnd(snippetToBeInsered);
	}

}
