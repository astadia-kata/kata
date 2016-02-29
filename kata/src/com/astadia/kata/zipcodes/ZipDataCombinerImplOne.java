
package com.astadia.kata.zipcodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ZipDataCombinerImplOne
 *
 * Implementation of IZipDataCombiner. Reads in information from several providers regarding which zipcodes they serve.
 *
 */
public class ZipDataCombinerImplOne implements IZipDataCombiner {

    private final Map<Integer, Set<String>> dataProviders;

    public ZipDataCombinerImplOne() {
        dataProviders = new HashMap<Integer, Set<String>>();
    }

    /**
     * Add the zip code data for a given provider.
     *
     * @see com.idea.exercise.zipcodes.IZipDataCombiner#addData(java.lang.String, java.io.InputStream)
     *
     * @param carrierName - the name of the provider.
     * @param data - the InputStream containing the zipcode data
     */
    @Override
    public void addData(String carrierName, InputStream data) {
        BufferedReader bufferedReader = null;
        try {
            int lineNumber = 1;
            bufferedReader = new BufferedReader(new InputStreamReader(data));
            for (String lineFromFile = bufferedReader.readLine(); lineFromFile != null; lineFromFile = bufferedReader.readLine()) {
                processLine(carrierName, lineFromFile, lineNumber++);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    /**
     * Return an array of the providers that service the specified zip code.
     *
     * @see com.idea.exercise.zipcodes.IZipDataCombiner#getProviders(java.lang.String)
     *
     * @param zipCode - the zip code to find.
     * @return - an array of names of providers that service the give zip code.
     */
    @Override
    public String[] getProviders(String zipCode) {
        Integer zip = Integer.parseInt(zipCode);
        String[] providers;
        synchronized (dataProviders) {
            Set<String> carriersAtZip = dataProviders.get(zip);
            providers = carriersAtZip.toArray(new String[0]);
        }
        return providers;
    }

    private void processLine(String carrierName, String lineFromFile, int lineNumber) {
        try {
            Integer zipCode = Integer.parseInt(lineFromFile);
            synchronized (dataProviders) {
                Set<String> carriersAtZip = dataProviders.get(zipCode);
                if (carriersAtZip != null) {
                    carriersAtZip.add(carrierName);
                } else {
                    carriersAtZip = new HashSet<String>();
                    carriersAtZip.add(carrierName);
                    dataProviders.put(zipCode, carriersAtZip);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(lineNumber + ":" + lineFromFile);
        }
    }

}
