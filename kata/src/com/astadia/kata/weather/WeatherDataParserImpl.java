
package com.astadia.kata.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class WeatherDataParserImpl implements WeatherDataParser {

    private final int MINIMUM_USEFUL_COLUMN_COUNT = 14;
    private final int MAX_COLUMN_INDEX = 2;
    private final int MIN_COLUMN_INDEX = 3;
    private final int DAY_NUMBER_COLUMN_INDEX = 1;

    @Override
    public int getDayWithMinTempSpread(InputStream in) throws IOException {
        BufferedReader bufferedReader = null;

        // We use the computed temperature spread as the key to our tree map, and the value as the day number, so that the lowest element in the map
        // will be the day with the minimum temperature spread.
        Map<Integer, Integer> sortedResults = new TreeMap<Integer, Integer>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            for (String lineFromFile = bufferedReader.readLine(); lineFromFile != null; lineFromFile = bufferedReader.readLine()) {
                processLine(lineFromFile, sortedResults);
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        // Return the value, which will be the day number of the minimum temperature range.
        Iterator<Integer> it = sortedResults.values().iterator();
        int returnValue = it.next();
        return returnValue;
    }

    private void processLine(String lineFromFile, Map<Integer, Integer> sortedResults) {
        String[] splitLine = lineFromFile.split("\\s+");
        try {
            if ((splitLine.length >= MINIMUM_USEFUL_COLUMN_COUNT) && isUsefulValue(splitLine[DAY_NUMBER_COLUMN_INDEX])) {
                Integer dayNumber = Integer.parseInt(splitLine[DAY_NUMBER_COLUMN_INDEX]);
                Integer maxTemperature = Integer.parseInt(stripTrailingJunk(splitLine[MAX_COLUMN_INDEX]));
                Integer minTemperature = Integer.parseInt(stripTrailingJunk(splitLine[MIN_COLUMN_INDEX]));
                Integer temperatureRange = maxTemperature - minTemperature;
                sortedResults.put(temperatureRange, dayNumber);
            }
        } catch (NumberFormatException e) {
            System.out.println(lineFromFile);
        }
    }

    private boolean isUsefulValue(String string) {
        boolean retVal = true;
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            retVal = false;
        }
        return retVal;
    }

    private String stripTrailingJunk(String string) {
        char lastCharacter = string.charAt(string.length() - 1);
        if (lastCharacter == '*') {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }
}
