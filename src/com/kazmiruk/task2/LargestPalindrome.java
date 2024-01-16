package com.kazmiruk.task2;

/**
 * Finds the largest numbers in the interval
 * from START to END, the product of which gives the largest
 * palindrome
 */
public class LargestPalindrome {

    private static final int START = 100;
    private static final int END = 999;

    public static void main(String[] args) {
        int firstMultiplier = 1;
        int secondMultiplier = 1;

        for (int i = START; i <= END; i++) {
            for (int j = i; j <= END; j++) {
                if (isPalindrome(i * j)) {
                    firstMultiplier = i;
                    secondMultiplier = j;
                }
            }
        }
        System.out.printf(
                "The largest palindrome made from the product of two 3-digit numbers is %d (%d * %d)",
                firstMultiplier * secondMultiplier,
                firstMultiplier,
                secondMultiplier
        );
    }

    /**
     * Checks if a number is a palindrome
     * @param num to check
     * @return is a palindrome
     */
    private static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;

        while (num > 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num /= 10;
        }
        return originalNum == reversedNum;
    }
}
