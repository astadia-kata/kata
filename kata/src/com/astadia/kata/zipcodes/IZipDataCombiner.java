package com.astadia.kata.zipcodes;

import java.io.InputStream;

/**
 * Combines sources of Broadband providers based on the zip code supported.
 */
public interface IZipDataCombiner {
	
	/**
	 * Used to build and combine data.
	 * @param key represents a broadband providers
	 * @param data a stream of data containing zip codes.
	 */
	void addData(String key, InputStream data);
	
	/**
	 * Used to retrieve all of the providers (key) that support a given zip
	 * code.
	 * @param zipCode the zip code to query
	 * @return the providers supporting it.
	 */
	String[] getProviders(String zipCode);
	
}
