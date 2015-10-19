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
@RunWith ( Parameterized.class ) public class TimerTestCase7 {
	private Timer t;
	private boolean arg;
	private boolean arg3;

	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 * @throws TimerException 
	 */
	public TimerTestCase7(boolean arg, boolean arg3) throws TimerException {
		this.arg= arg;
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
				{true, false},
				{true, true},
				{false, true},
				{false, false},
		};
		return Arrays.asList(data);
	}

	@Test
	public void testToString() throws TimerException {
		t.active = arg;
		t.ringing = arg3;
		t.toString();
	}
	
	@Test
	public void test() {
		
	}
}
