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
	private int arg1;

	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 */
	public TimerTestCase6(int arg1) {
		this.arg1= arg1;

	}
	
	/**
	 * 
	 * @return Collection
	 * @throws TimerException 
	 */
	@Parameters public static Collection data() throws TimerException {
		Object[][] data = {
				{new Timer(5,5,5)},
				{new Timer(5,5,4)},
				{new Timer(5,4,5)},
				{new Timer(5,4,4)},
				{new Timer(4,5,5)},
				{new Timer(4,5,4)},
				{new Timer(4,4,5)},
				{new Timer(4,4,4)},
				{new GregorianCalendar()}
				
		};
		
		return Arrays.asList(data);
	}
	 
	/*
	 * Actually Working !
	 */
	@Test
	public void testTimer() throws TimerException {
		Timer t = new Timer(5,5,5);
		t.equals(arg1);
	}

}
