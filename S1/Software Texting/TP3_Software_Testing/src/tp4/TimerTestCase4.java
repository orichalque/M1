package tp4;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
	private int arg2;
	private int arg3;
 
	
	/**
	 * Constructor
	 * @param arg1
	 * @param arg2
	 */
	public TimerTestCase4(boolean arg1, int arg2, int arg3) {
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
				{true, 5, 5}, {false, 5, 5}, {true, 5, 4}, {true, 4, 5}
		};
		
		return Arrays.asList(data);
	}
	
	/*
	 * Actually Working !
	 */
	@Test
	public void testSetActive() throws TimerException {
		 
		Calendar calendar = mock(GregorianCalendar.class);
		when(calendar.get(anyInt())).thenReturn(arg2, arg3);
		Timer t = new Timer(5, 5, 5, calendar);
		t.setActive(arg1);
		verify(calendar, times(2)).get(anyInt());
	}
	 
	@Test
	public void test() {
		
	}

}
