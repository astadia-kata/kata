package com.astadia.kata.zipcodes;

import java.io.InputStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZipDataCombinerTest {

	protected ZipDataCombiner dataCombiner;
	
	@Before
	public void setUp() throws Exception {
		dataCombiner = new ZipDataCombinerImplOne();
		InputStream att = this.getClass().getResourceAsStream("att.dat");
		InputStream sprint = this.getClass().getResourceAsStream("sprint.dat");
		InputStream tmobile = this.getClass().getResourceAsStream("tmobile.dat");
		InputStream verizon = this.getClass().getResourceAsStream("verizon.dat");
		dataCombiner.load("att", att);
		dataCombiner.load("sprint", sprint);
		dataCombiner.load("tmobile", tmobile);
		dataCombiner.load("verizon", verizon);
	}

	@After
	public void tearDown() throws Exception {
		dataCombiner = null;
	}
	
	
	@Test
	public void testGetProviders() {
		
		Assert.assertTrue(Arrays.equals(new String[]{"sprint"}, dataCombiner.search("32656")));
		Assert.assertTrue(Arrays.equals(new String[]{"att"}, dataCombiner.search("90210")));

		String[] result = dataCombiner.search("06793");
		Arrays.sort(result);
		Assert.assertTrue(Arrays.binarySearch(result, "att")>=0);
		Assert.assertTrue(Arrays.binarySearch(result, "verizon")>=0);
		
		result = dataCombiner.search("32256");
		Arrays.sort(result);
		Assert.assertTrue(Arrays.binarySearch(result, "sprint")>=0);
		Assert.assertTrue(Arrays.binarySearch(result, "att")>=0);
		
		result = dataCombiner.search("95569");
		Arrays.sort(result);
		Assert.assertTrue(Arrays.binarySearch(result, "sprint")>=0);
		Assert.assertTrue(Arrays.binarySearch(result, "tmobile")>=0); 
	}

}
