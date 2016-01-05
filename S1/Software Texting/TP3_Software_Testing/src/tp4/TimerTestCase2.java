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
@RunWith ( Parameterized.class ) public class TimerTestCase2 {
	private Timer t;
	private int arg1;
	private int arg2;
	private int arg3;
	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 */
	public TimerTestCase2(int arg1, int arg2, int arg3) {
		this.arg1= arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}
	
	/**
	 * 
	 * @return Collection
	 */
	@Parameters public static Collection data() {
		Object[][] data = {
				{1, -1, 1},
				{1, 24, 1},
				{1, 1, -1},
				{1, 1, 60},
				{51, 1, 1},
				{1, 1, 1}
		};
		
		return Arrays.asList(data);
	}
	
	/*
	 * Actually Working !
	 */
	@Test(expected=(TimerException.class))
	public void testTimer() throws TimerException {
		Timer t = new Timer(arg1, arg2, arg3);
		
	}
	
	@Test
	public void test() {
		
	}

}
