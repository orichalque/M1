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

import fr.univnantes.cta.Airport;
import fr.univnantes.cta.impl.AirportImpl;

/**
 * @author E104607D
 *
 */
@RunWith ( Parameterized.class ) public class AirportImplTest {
	protected String arg;
	
	public AirportImplTest(String arg1) {
		arg = arg1;
	}

	/**
	 * 
	 * @return Collection
	 */
	@Parameters (name= "{index}: {0}")
	public static Collection data() {
		Object[][] data = {
				{""},
				{"Nom"}
		};
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		Airport ap = new AirportImpl(arg);
	}

}
