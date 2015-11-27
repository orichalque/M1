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
import fr.univnantes.cta.impl.LatitudeImpl;

@RunWith (Parameterized.class) public class LatitudeImplTest {

	protected int a1;
	protected int a3;
	protected int a2;
	protected CompassDirection cd;
	protected String result;
	
	public LatitudeImplTest(int a1, int a3, int a2, CompassDirection cd,
			String result) {
		super();
		this.a1 = a1;
		this.a3 = a3;
		this.a2 = a2;
		this.cd = cd;
		this.result = result;
	}
	
	@Parameters (name= "{index}: {0}, {1}, {3}, {4}, {5}")
	public static Collection data() {
		Object[][] data = {
				{0, 0, 0, CompassDirection.NORTH, "works"},
				{0, 2, 3, CompassDirection.SOUTH, "works" },
				{-1, 0, 0, CompassDirection.NORTH, "fail"},
				{-1, 2, 3, CompassDirection.SOUTH, "fail" },
				{91, 0, 0, CompassDirection.NORTH, "fail"},
				{91, 2, 3, CompassDirection.SOUTH, "fail" },
				{0, 0, 0, CompassDirection.EAST, "fail"},
				{0, 2, 3, CompassDirection.WEST, "fail"}
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		Angle a = new LatitudeImpl(a1, a2, a3, cd);
	}

}
