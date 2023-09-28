import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RecursivePrimeNumbers {

    // Recursive function to find prime numbers up to n
    public static ArrayList<Integer> findPrimesRecursive(int n) {
        return findPrimesRecursive(n, 2, new ArrayList<>());
    }

    // Helper function for recursion with additional parameters
    private static ArrayList<Integer> findPrimesRecursive(int n, int current, ArrayList<Integer> primes) {
        if (current > n) {
            return primes; // Base case: If variable current > n, return List
        }
        // Check if variable current is prime
        boolean isPrime = isPrime(current, 2);
        if (isPrime) {
            primes.add(current); // If prime, add to the ArrayList of primes
        }
        // Continue to the next number
        return findPrimesRecursive(n, current + 1, primes);
    }

    // Helper function to check if a number is prime
    private static boolean isPrime(int num, int divisor) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true; // 2 is a prime number
        }
        if (num % divisor == 0) {
            return false; // If divisible by any smaller number, not prime
        }
        if (divisor * divisor > num) {
            return true; // If no divisors found, it's prime
        }
        // Recursively check the next divisor
        return isPrime(num, divisor + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char exitKey = 'q';
        boolean shouldExit = false;

        do {
            try {
                if (shouldExit) {
                    break; // Exit the loop if 'q' is pressed
                }

                System.out.print("Enter a number (or press '" + exitKey + "' to quit): ");
                int n = scanner.nextInt();

                if (n < 0) {
                    System.out.println("Invalid input. Please enter a non-negative number.");
                    continue;
                }

                if (n <= 1) {
                    System.out.println("N must be greater than 1.");
                    continue; // Skip printing the list and continue the loop
                }

                List<Integer> result = findPrimesRecursive(n);

                System.out.print("Primes up to " + n + ": ");
                for (int prime : result) {
                    System.out.print(prime + " ");
                }
                System.out.println();
            } catch (InputMismatchException e) {
                String input = scanner.next();
                if (input.length() == 1 && input.charAt(0) == exitKey) {
                    shouldExit = true; // Set shouldExit to true if 'q' was pressed
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } while (!shouldExit);

        System.out.println("Program closed.");
        scanner.close();
    }
}
