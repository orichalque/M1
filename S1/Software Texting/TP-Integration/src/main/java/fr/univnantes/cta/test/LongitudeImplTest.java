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
import fr.univnantes.cta.impl.LongitudeImpl;

@RunWith (Parameterized.class) public class LongitudeImplTest {

	protected int a1;
	protected int a3;
	protected int a2;
	protected CompassDirection cd;
	protected String result;
	
	public LongitudeImplTest(int a1, int a3, int a2, CompassDirection cd,
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
				{0, 0, 0, CompassDirection.EAST, "works"},
				{0, 2, 3, CompassDirection.WEST, "works" },
				{-1, 0, 0, CompassDirection.EAST, "fail"},
				{-1, 0, 0, CompassDirection.WEST, "fail" },
				{181, 0, 0, CompassDirection.EAST, "fail"},
				{181, 0, 0, CompassDirection.WEST, "fail" },
				{0, 0, 0, CompassDirection.NORTH, "fail"},
				{0, 2, 3, CompassDirection.SOUTH, "fail"}
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		Angle a = new LongitudeImpl(a1, a2, a3, cd);
	}

}