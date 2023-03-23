public class SayNumber {
    // English names for numbers from 0 to 19 and multiples of ten up to 90
    private static final String[] ones = {
            "", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    // Suffixes for larger numbers
    private static final String[] suffixes = {
            "", "thousand", "million", "billion", "trillion"
    };

    // Converts a long number into its English name
    public static String sayNumber(long num) {
        // Handle the special case of zero
        if (num == 0) {
            return "Zero.";
        }

        // The index of the current suffix in the array of suffixes
        int suffixIndex = 0;

        // The English name for the number so far
        String words = "";

        // Extract digits from the number in groups of three
        while (num > 0) {
            int hundreds = (int) (num % 1000);
            String hundredsStr = "";

            // Convert the hundreds digits to English words
            if (hundreds != 0) {
                int onesDigit = hundreds % 10;
                int tensDigit = (hundreds % 100) / 10;
                int hundredsDigit = hundreds / 100;

                // Handle the special case of "teen" numbers
                if (tensDigit == 1) {
                    onesDigit += 10;
                }

                // Add the ones digit to the hundreds string
                if (onesDigit != 0) {
                    hundredsStr = ones[onesDigit] + " ";
                }

                // Add the tens digit to the hundreds string
                if (tensDigit != 0) {
                    hundredsStr = tens[tensDigit] + " " + hundredsStr;
                }

                // Add the hundreds digit to the hundreds string
                if (hundredsDigit != 0) {
                    hundredsStr = ones[hundredsDigit] + " hundred " + hundredsStr;
                }

                // Add the suffix for the current group of three digits to the hundreds string
                if (suffixIndex != 0) {
                    hundredsStr += suffixes[suffixIndex] + ", ";
                }
            }

            // Add the English name for the current group of three digits to the words string
            words = hundredsStr + words;

            // Move to the next group of three digits
            num /= 1000;
            suffixIndex++;
        }

        // Remove the trailing comma and space, and add a period
        return words.substring(0, words.length() - 2) + ".";
    }
}

