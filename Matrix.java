// Determinant Calculator by Sam Howard
import java.util.Scanner;

public class Matrix {
    private static int n;
    private static int[][] matrix;
    private static int a;
    private static int b;
    
    /* Main method that defines a scanner object and prompts the user
     * to type in integers to be inputed into a 2D array of size either
     * 2 or 3. This will help to theorectically define a 2x2 or 3x3 
     * matrix and fill it with the elements the user inputs.
     */

    public static void main(String[] args) {
        int  number = 2;
        Scanner in = new Scanner(System.in);
        System.out.println("Type in a square matrix of size 2 or 3: ");
        n = in.nextInt();
        matrix = new int[n][n];
        int v;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Values: ");
                v = in.nextInt();
                matrix[i][j] = v;
            }
        }
       
       /* Next, we see a switch statement that will execute depending on
        * the size n that the user inputs. If the user types '2' for a 
        * 2x2 matrix, the switch will execute case 2:  which will print
        * the 2x2 matrix and then find the determinant using hard coded
        * variables that follow the basic 2x2 matrix determinant formula. 
        * Then it returns the correct determinant value stored in variable 
        * d and prints.
        */
        int d = 0;
        switch (n) {
            case 2:
                System.out.println("\nPrinting " + n + " x " + n + " Matrix:");

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println(" ");
                }

                System.out.println(" ");
            
                a = matrix[0][0] * matrix[1][1];
                b = matrix[0][1] * matrix[1][0];
                d = a - b;
        
                System.out.println("det = " + d);
                break;
        /*
         * In case 3: the user has chosen and populated a 3x3 matrix.
         * We can solve a 3x3 matrix using Laplace expansion with 
         * correct cofactors and cofactor sign. Since whenever you
         * expand across a given row / column, the sign of the cofactor
         * will change from positive, negative, and positive in a pattern.
         * We chose to go ahead and hard code this pattern and compute the
         * 2x2 determinants we need and storing in variables a, b, and c.
         * Then, all we have to do is add all three together and we have
         * the 3x3 determinant. We then store in d and print.
         */
            case 3:
                System.out.println("\nPrinting " + n + " x " + n + " Matrix:");
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println(" ");
                }

                System.out.println(" ");
                
                int x = matrix[0][0] * ((matrix[1][1] * matrix[2][2]) - (matrix[2][1] * matrix[1][2]));
                int y = -matrix[0][1] * ((matrix[1][0] * matrix[2][2]) - (matrix[2][0] * matrix[1][2]));
                int z = matrix[0][2] * ((matrix[1][0] * matrix[2][1]) - (matrix[1][1] * matrix[2][0]));

                d = x + y + z;

                System.out.println("det = " + d);
                break;
        /* If the user inputs a typo, we can return a brief statement correcting
         * the user and advicing appropriate intput.
         * */
            default:
                System.out.println("You didn't input a valid matrix size!");
                System.out.println("Program only accepts input of 2 or 3, ");
                System.out.println("and please don't type in letters...");
        }   
    }
}
        


