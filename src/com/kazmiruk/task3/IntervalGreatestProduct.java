package com.kazmiruk.task3;

/**
 * Find the NUM_OF_ADJACENT_DIGIT adjacent digits
 * in the 1000-digit number that have the
 * greatest product.
 */
public class IntervalGreatestProduct {

    private static final String ONE_THOUSAND_DIGIT_NUM =
                    "73167176531330624919225119674426574742355349194934" +
                    "96983520312774506326239578318016984801869478851843" +
                    "85861560789112949495459501737958331952853208805511" +
                    "12540698747158523863050715693290963295227443043557" +
                    "66896648950445244523161731856403098711121722383113" +
                    "62229893423380308135336276614282806444486645238749" +
                    "30358907296290491560440772390713810515859307960866" +
                    "70172427121883998797908792274921901699720888093776" +
                    "65727333001053367881220235421809751254540594752243" +
                    "52584907711670556013604839586446706324415722155397" +
                    "53697817977846174064955149290862569321978468622482" +
                    "83972241375657056057490261407972968652414535100474" +
                    "82166370484403199890008895243450658541227588666881" +
                    "16427171479924442928230863465674813919123162824586" +
                    "17866458359124566529476545682848912883142607690042" +
                    "24219022671055626321111109370544217506941658960408" +
                    "07198403850962455444362981230987879927244284909188" +
                    "84580156166097919133875499200524063689912560717606" +
                    "05886116467109405077541002256983155200055935729725" +
                    "71636269561882670428252483600823257530420752963450";

    private static final int NUM_OF_ADJACENT_DIGIT = 13;

    private static long maxDigitProduct = 0;

    private static long digitProduct = 1;

    private static int endOfMaxSequence = 0;

    public static void main(String[] args) {
        int currentDigit;
        int startOfSecondInterval = findProductOnIntervalWithNoZeros(0);

        // Each time we shift the sequence to the left by 1 digit.
        // We look for the product of the digits of the sequence,
        // based on the product of the previous sequence, divided
        // by the first digit of the previous sequence and multiplied
        // by the last digit of the current sequence
        for (int i = startOfSecondInterval + 1; i < ONE_THOUSAND_DIGIT_NUM.length(); i++) {
            currentDigit = Character.getNumericValue(ONE_THOUSAND_DIGIT_NUM.charAt(i));
            if (currentDigit == 0) {
                i = findProductOnIntervalWithNoZeros(i + 1);
                continue;
            }
            int firstPrevMultiplier = Character.getNumericValue(ONE_THOUSAND_DIGIT_NUM.charAt(i - NUM_OF_ADJACENT_DIGIT));
            digitProduct /= firstPrevMultiplier;
            digitProduct *= currentDigit;
            if (digitProduct > maxDigitProduct) {
                maxDigitProduct = digitProduct;
                endOfMaxSequence = i;
            }
        }
        System.out.printf("The %d adjacent digits in the 1000-digit number " +
                "that have the greatest product is:\n", NUM_OF_ADJACENT_DIGIT);
        for (int i = endOfMaxSequence - NUM_OF_ADJACENT_DIGIT + 1; i < endOfMaxSequence; i++) {
            System.out.print(ONE_THOUSAND_DIGIT_NUM.charAt(i) + " * ");
        }
        System.out.print(ONE_THOUSAND_DIGIT_NUM.charAt(endOfMaxSequence));
        System.out.println(" = " + maxDigitProduct);
    }

    /**
     * Finds such an interval that does not contain 0.
     * Finds the product of numbers on it
     * and checks whether it is the largest
     * @param start start of sequence
     * @return end of sequence
     */
    private static int findProductOnIntervalWithNoZeros(int start) {
        int i;
        int currentDigit;
        int counter = 0;
        digitProduct = 1;
        for (i = start; i < ONE_THOUSAND_DIGIT_NUM.length(); i++) {
            currentDigit = Character.getNumericValue(ONE_THOUSAND_DIGIT_NUM.charAt(i));
            // if the current interval contains 0,
            // we start searching for the interval again
            if (currentDigit == 0) {
                digitProduct = 1;
                counter = 0;
                continue;
            }
            digitProduct *= currentDigit;
            counter++;
            // if the found sequence is
            // the required length
            if (counter == NUM_OF_ADJACENT_DIGIT) {
                if (digitProduct > maxDigitProduct) {
                    maxDigitProduct = digitProduct;
                    endOfMaxSequence = 1;
                }
                break;
            }
        }
        return i;
    }


}
