package fr.univnantes.cta.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import fr.univnantes.cta.Angle;
import fr.univnantes.cta.impl.AngleImpl;
import junit.framework.TestCase;

@RunWith ( Parameterized.class ) public class AngleImplTest {
	protected int arg1;
	protected int arg3;
	protected int arg2;
	
	public AngleImplTest(int arg_1, int arg_2, int arg_3) {
		arg1 = arg_1;
		arg2 = arg_2;
		arg3 = arg_3;
	}
	 
	/**
	 * 
	 * @return Collection
	 */
	@Parameters public static Collection data() {
		Object[][] data = {
				{0, 0, 0},
				{1, 2, 3 },
				{-1, 2, 3},
				{1, -2, 3 },
				{1, 2, -3 },
				{-1, -2, 3 },
				{1, -2, -3 },
				{-1, 2, -3 },
				{-1, -1, -1}
				
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void testConstructor() throws Exception {
		Angle a = new AngleImpl(arg1, arg2, arg3);
		System.out.println(arg1+" "+arg2+" "+arg3);
		a.cos();
		a.sin();
		a.degrees();
		a.radians();
	}
}
