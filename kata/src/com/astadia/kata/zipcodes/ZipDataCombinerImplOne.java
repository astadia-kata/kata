package com.astadia.kata.zipcodes;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ZipDataCombinerImplOne
 *
 * Implementation of IZipDataCombiner. Reads in information from several providers regarding which zipcodes they serve.
 *
 */
public class ZipDataCombinerImplOne implements ZipDataCombiner {

 
    public ZipDataCombinerImplOne() {
       
    }

    /* (non-Javadoc)
     * @see com.astadia.kata.zipcodes.ZipDataCombiner#load(java.lang.String, java.io.InputStream)
     */
    @Override
    public void load(String carrierName, InputStream data) {
    	throw new UnsupportedOperationException("implement me");
    }

    /* (non-Javadoc)
     * @see com.astadia.kata.zipcodes.ZipDataCombiner#search(java.lang.String)
     */
    @Override
    public String[] search(String zipCode) {
    	throw new UnsupportedOperationException("implement me");
    }
}