package com.astadia.kata.weather;

import java.io.InputStream;

public interface WeatherDataParser {

	int getDayWithMinTempSpread(InputStream in) throws Exception;
}