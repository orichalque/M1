package fr.univnantes.cta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.univnantes.cta.Angle;
import fr.univnantes.cta.CompassDirection;
import fr.univnantes.cta.Coordinate;
import fr.univnantes.cta.impl.AngleImpl;
import fr.univnantes.cta.impl.CoordinateImpl;

@RunWith ( Parameterized.class ) public class CoordinateImplTest {
	protected int arg1;
	protected int arg2;
	protected int arg3;
	protected CompassDirection arg4;
	
	public CoordinateImplTest(int arg1, int arg2, int arg3,
			CompassDirection arg4) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
	}
	 
	/**
	 * 
	 * @return Collection
	 */
	@Parameters (name= "{index}: {0}, {1}, {3}, {4}")
	public static Collection data() {
		Object[][] data = {
				{0, 0, 0, CompassDirection.NORTH},
				{1, 2, 3, CompassDirection.SOUTH },
				{-1, 2, 3, CompassDirection.EAST},
				{1, -2, 3, CompassDirection.WEST },
				{1, 2, -3, CompassDirection.WEST },
				{-1, -2, 3, CompassDirection.WEST },
				{1, -2, -3, CompassDirection.WEST },
				{-1, 2, -3, CompassDirection.WEST },
				{-1, -1, -1, CompassDirection.WEST}
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void testConstructor() {
		Coordinate c = new CoordinateImpl(arg1, arg2, arg3, arg4);	
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testCos() throws Exception{
		Coordinate c = new CoordinateImpl(arg1, arg2, arg3, arg4);
		c.cos();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testSin() {
		CoordinateImpl c = new CoordinateImpl(arg1, arg2, arg3, arg4);
		c.sin();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testCD() {
		CoordinateImpl c = new CoordinateImpl(arg1, arg2, arg3, arg4);
		c.direction();
	}
	
	
}
