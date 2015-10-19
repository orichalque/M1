package tp4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

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
@RunWith ( Parameterized.class ) public class TimerTestCase6 {
	private Timer t;
	private Object arg1;
	private boolean arg2;
	private boolean arg3;

	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 * @throws TimerException 
	 */
	public TimerTestCase6(Object arg1, boolean arg2, boolean arg3) throws TimerException {
		this.arg1= arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		t = new Timer(5,5,5);
	}
	
	/**
	 * 
	 * @return Collection
	 * @throws TimerException 
	 */
	@Parameters public static Collection data() throws TimerException {
		Object[][] data = {
				{new Timer(5,5,5), true, true},
				{new Timer(5,5,4), true, true},
				{new Timer(5,4,5), true, true},
				{new Timer(5,4,4), true, true},
				{new Timer(4,5,5), true, true},
				{new Timer(4,5,4), true, true},
				{new Timer(4,4,5), true, true},
				{new Timer(4,4,4), true, true},
				{new Timer(5,5,5), false, true},
				{new Timer(5,5,4), false, true},
				{new Timer(5,4,5), false, true},
				{new Timer(5,4,4), false, true},
				{new Timer(4,5,5), false, true},
				{new Timer(4,5,4), false, true},
				{new Timer(4,4,5), false, true},
				{new Timer(4,4,4), false, true},
				{new Timer(5,5,5), true, false},
				{new Timer(5,5,4), true, false},
				{new Timer(5,4,5), true, false},
				{new Timer(5,4,4), true, false},
				{new Timer(4,5,5), true, false},
				{new Timer(4,5,4), true, false},
				{new Timer(4,4,5), true, false},
				{new Timer(4,4,4), true, false},
				{new Timer(5,5,5), false, false},
				{new Timer(5,5,4), false, false},
				{new Timer(5,4,5), false, false},
				{new Timer(5,4,4), false, false},
				{new Timer(4,5,5), false, false},
				{new Timer(4,5,4), false, false},
				{new Timer(4,4,5), false, false},
				{new Timer(4,4,4), false, false},
				{new GregorianCalendar(), false, false}
		};
		return Arrays.asList(data);
	}

	@Test
	public void testEquals() throws TimerException {
		t.ringing = arg2;
		t.active = arg3;
		assertTrue(t.equals(arg1));
		
	}
	
	@Test
	public void test() {
		
	}
}
