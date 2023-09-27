import java.util.Scanner;

public class LinearFibonacci {
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number must be greater than or equal to 0.");
        } else if (n <= 1) {
            return n;
        } else {
            int[] fib = new int[n + 1];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[n];
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char exitKey = 'q';

        do {
            try {
                System.out.print("Enter a number (or press '" + exitKey + "' to quit): ");
                if (scanner.hasNextInt()) {
                    int n = scanner.nextInt();
                    if (n < 0) {
                        System.out.println("The number must be greater than or equal to 0.");
                    } else {
                        int result = fibonacci(n);
                        System.out.println("Fibonacci(" + n + ") = " + result);
                    }
                } else {
                    String input = scanner.next();
                    if (input.length() == 1 && input.charAt(0) == exitKey) {
                        break; // Exit the loop if 'q' is pressed
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Program terminated.");
        scanner.close();
   
    }
}