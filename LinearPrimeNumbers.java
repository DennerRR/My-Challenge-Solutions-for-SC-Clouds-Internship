import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LinearPrimeNumbers {
    // Function to find prime numbers up to n using a linear approach
    public static List<Integer> findPrimesLinear(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n < 2) {
            throw new IllegalArgumentException("N must be greater than 1.");
        }
        for (int current = 2; current <= n; current++) {
            if (isPrime(current)) {
                primes.add(current);
            }
        }
        return primes;
    }

    // Helper function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 2) {
            return num == 2; // 2 is a prime number
        }
        if (num % 2 == 0) {
            return false; // If divisible by 2, not prime
        }
        for (int divisor = 3; divisor * divisor <= num; divisor += 2) {
            if (num % divisor == 0) {
                return false; // If divisible by any smaller number, not prime
            }
        }
        return true; // If no divisors found, it's prime
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char exitKey = 'q';

        do {
            try {
                System.out.print("Enter a number (or press '" + exitKey + "' to quit): ");
                int n = scanner.nextInt();

                List<Integer> result = findPrimesLinear(n);
                System.out.print("Primes up to " + n + ": ");
                for (int prime : result) {
                    System.out.print(prime + " ");
                }
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print only the error message
            } catch (InputMismatchException e) {
                String input = scanner.next();
                if (input.length() == 1 && input.charAt(0) == exitKey) {
                    break; // Exit the loop if 'q' was pressed
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } while (true);

        System.out.println("Program closed.");
        scanner.close();
    }
}