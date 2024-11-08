import java.util.Scanner;
import java.util.StringTokenizer;

class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading the whole line from input
        System.out.print("Enter a line of numbers: ");
        String line = sc.nextLine();
        
        // Tokenizing the input using StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        int sum = 0;

        // Looping through all tokens and summing them
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            try {
                int num = Integer.parseInt(token);  // Parse the token to an integer
                sum += num;  // Add the number to the sum
            } catch (NumberFormatException e) {
                System.out.println("Ignoring non-numeric input: " + token);
            }
        }

        // Printing the sum of the numbers
        System.out.println("The sum of the numbers is: " + sum);
        
        // Close the scanner
        sc.close();
    }
}
