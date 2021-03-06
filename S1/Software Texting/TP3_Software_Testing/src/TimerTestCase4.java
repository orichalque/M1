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
@RunWith ( Parameterized.class ) public class TimerTestCase4 {
	private Timer t;
	private boolean arg1;

	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 */
	public TimerTestCase4(boolean arg1) {
		this.arg1= arg1;
		
	}
	
	/**
	 * 
	 * @return Collection
	 */
	@Parameters public static Collection data() {
		Object[][] data = {
				{true}, {false}
		};
		
		return Arrays.asList(data);
	}
	
	/*
	 * Actually Working !
	 */
	@Test
	public void testSetActive() throws TimerException {
		
		Calendar calendar = new GregorianCalendar();
		Timer t = new Timer(5, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE));
		t.setActive(arg1);
		System.out.println("Args:"+arg1);
	}
	 
	@Test
	public void test() {
		
	}

}
