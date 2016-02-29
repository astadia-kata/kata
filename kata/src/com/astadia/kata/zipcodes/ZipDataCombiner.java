package com.astadia.kata.zipcodes;

import java.io.InputStream;

/**
 * Combines sources of cell phone service providers based on the zip code supported.
 */
public interface ZipDataCombiner {
	
	/**
	 * Used to build and combine data.
	 * @param key represents a cell phone service provider
	 * @param data a stream of data containing zip codes.
	 */
	void load(String carrierName, InputStream data);
	
	/**
	 * Used to retrieve all of the providers (key) that support a given zip
	 * code.
	 * @param zipCode the zip code to query
	 * @return the providers supporting it.
	 */
	String[] search(String zipCode);
	
	
	
}
