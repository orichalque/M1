package tp4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.sun.media.jfxmedia.logging.Logger;
/**
 * @author E104607D
 *
 */
@RunWith ( Parameterized.class ) public class TimerTestCase3 {
	private Timer t;
	private int arg1;
	private int arg2;
	private int arg3;
	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 */
	public TimerTestCase3(int arg1) {
		this.arg1= arg1;
		
	}
	
	/**
	 * 
	 * @return Collection
	 */
	@Parameters public static Collection data() {
		Object[][] data = {
				{1},{-1}, {61}, {250}, {2000}
		};
		
		return Arrays.asList(data);
	}
	
	/*
	 * Actually Working !
	 */
	@Test
	public void testAddMin() throws TimerException {
		Timer t = new Timer(5, 21, 59);
		t.addMin(arg1);
		System.out.println("Args:"+arg1);
	}
	
	@Test
	public void test() {
		
	}

}
