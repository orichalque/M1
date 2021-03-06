/**
 * 
 */
package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.univnantes.cta.Airplane;
import fr.univnantes.cta.impl.AirplaneImpl;

/**
 * @author E104607D
 *
 */
@RunWith ( Parameterized.class ) public class AirplaneImplTest {
	protected double arg1;
	protected int arg2, arg3, arg4;
	
	public AirplaneImplTest(double a, int b, int c, int d) {	
		arg1 = a;
		arg2 = b;
		arg3 = c;
		arg4 = d;
	}
	
	/**
	 * 
	 * @return Collection
	 */
	@Parameters public static Collection data() {
		Object[][] data = {
				{0.0, 0, 0, 0},
				{55225.0, -1, 1, 1},
				{-0.0, 1, -1, 1},
				{-5000.0, -1, 1, -1},
				{-1.0, 1, 1, 1}
				
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		Airplane airplane = new AirplaneImpl(arg1, arg2, arg3, arg4);
		airplane.getAutonomy();
		airplane.getLoading();
		airplane.weight();
	}

}
