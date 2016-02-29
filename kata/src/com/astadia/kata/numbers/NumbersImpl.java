package com.astadia.kata.numbers;

/**
 * TODO: Implement Me. Pass the tests
 */
public class NumbersImpl implements Numbers {

    /* (non-Javadoc)
	 * @see com.astadia.kata.numbers.Numbers#add(java.lang.String, java.lang.String)
	 */
    @Override
	public String add(String string, String string2) {
        String result;
        try {
            Integer value1 = Integer.parseInt(string);
            Integer value2 = Integer.parseInt(string2);
            int sum = value1.intValue() + value2.intValue();
            result = Integer.toString(sum);
        } catch (NumberFormatException e) {
            result = "Not a number.";
        }
        return result;
    }

    /* (non-Javadoc)
	 * @see com.astadia.kata.numbers.Numbers#multiply(java.lang.String, java.lang.String)
	 */
    @Override
	public String multiply(String string, String string2) {
        String result;
        if (string.contains(".") || string2.contains(".")) {
            try {
                Double value1 = Double.parseDouble(string);
                Double value2 = Double.parseDouble(string2);
                double product = value1.doubleValue() * value2.doubleValue();
                result = String.format("%3.3f", product);
            } catch (NumberFormatException e) {
                result = "Not a number.";
            }
        } else {
            try {
                Integer value1 = Integer.parseInt(string);
                Integer value2 = Integer.parseInt(string2);
                int product = value1.intValue() * value2.intValue();
                result = Integer.toString(product);
            } catch (NumberFormatException e) {
                result = "Not a number.";
            }
        }
        return result;
    }
}
