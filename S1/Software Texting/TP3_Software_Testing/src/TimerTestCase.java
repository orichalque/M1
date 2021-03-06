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
@RunWith ( Parameterized.class ) public class TimerTestCase {
	private Timer t;
	private boolean arg1;
	private int arg2;
	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 */
	public TimerTestCase(boolean arg1, int arg2) {
		this.arg1=arg1;
		this.arg2 = arg2;
	}
	
	/**
	 * 
	 * @return Collection
	 */
	@Parameters public static Collection data() {
		Object[][] data = {
				{true, 5},
				{true, 0},
				{false, 1}
		};
		
		return Arrays.asList(data);
	}
	
	/*
	 * Actually Working !
	 */
	@Test
	public void testSelectRing() throws TimerException {
		Timer t = new Timer(5, 5, 5);
		t.ringing = (arg1);
		t.selectRing(arg2);
		System.out.println("Args:"+arg1+":"+arg2);
	}
	
	@Test
	public void test() {
		
	}

}
