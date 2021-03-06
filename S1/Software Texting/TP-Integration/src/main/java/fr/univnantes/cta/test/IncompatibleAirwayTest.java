package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.univnantes.cta.IncompatibleAirway;

@RunWith ( Parameterized.class ) public class IncompatibleAirwayTest {
	protected double arg1;
	protected double arg2;
	
	public IncompatibleAirwayTest(double a1, double a2) {
		arg1=a1;
		arg2=a2;
	}
	
	/**
	 * 
	 * @return Collection
	 */
	@Parameters (name= "{index}: {0}, {1}")
	public static Collection data() {
		Object[][] data = {
				{0.1, 0.1},
				{-10.1, 10.1},
				{10.1, -10.1},
				{-10.1, -10.1}
		};
		return Arrays.asList(data);
	}
	
	@Test(expected = Exception.class)
	public void test() throws Exception {
		throw new IncompatibleAirway(arg1, arg2);
	}
	
	@Test(expected = Exception.class)
	public void test2() throws Exception {
		throw new IncompatibleAirway();
	}

}
