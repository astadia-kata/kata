package com.astadia.kata.weather;

import java.io.InputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherDataParserImplTest {

    protected WeatherDataParser parser;

    @Before
	public void setUp() throws Exception {
		this.parser = new WeatherDataParserImpl();
	}
    
    @After
    public void tearDown() throws Exception {
        parser = null;
    }

    @Test
    public void testGetDayWithMinTempSpread() throws Exception {
        InputStream dataIn = this.getClass().getResourceAsStream("weather.dat");
        Assert.assertNotNull(dataIn);
        Assert.assertEquals(14, parser.getDayWithMinTempSpread(dataIn));
        dataIn.close();
    }

    @Test
    public void testGetDayWithMinTempSpreadWithNeg() throws Exception {
        InputStream dataIn = this.getClass()
                .getResourceAsStream("weather2.dat");
        Assert.assertNotNull(dataIn);
        Assert.assertEquals(17, parser.getDayWithMinTempSpread(dataIn));
        dataIn.close();
    }
}
