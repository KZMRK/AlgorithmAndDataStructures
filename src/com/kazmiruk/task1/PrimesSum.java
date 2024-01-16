package com.kazmiruk.task1;

/**
 * The Sieve of Eratosthenes algorithm is
 * used to find the sum of N prime numbers.
 * The time complexity of the algorithm will be
 * O(√N + N)
 */
public class PrimesSum {

    private final static int N = 2_000_000;

    public static void main(String[] args) {
        // if the number is prime,
        // it is under an index that is false
        boolean[] primes = new boolean[N];
        primes[0] = primes[1] = true;

        for (int i = 2; i < Math.ceil(Math.sqrt(primes.length)); i++) {
            if (!primes[i]) {
                int j = i * i;
                while (j < N) {
                    primes[j] = true;
                    j += i;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < primes.length; i++) {
            if (!primes[i]) {
                sum += i;
            }
        }
        System.out.printf("The sum of the primes below %d is %d", N, sum);
    }
}