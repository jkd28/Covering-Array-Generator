/**
 * Description
 * @author John Dott.
 */
public class Pairwise {
    /** Returns an exhaustive truth table for the number of parameters in the given list
       The generated truth table is stored with rows|cols ordering of the parameters
     @param n    The number of relations for which to generate a truth table
     @return     A 2-D boolean array which is a full truth table for n-parameters
    */
    public static boolean[][] getTruthTable(int n) {
        if (n <= 0) {
            return null;
        }
        int numRows = (int)Math.pow((double)2,(double)n);
        boolean[][] truthTable = new boolean[numRows][n];

        int count = 0;
        for (int row = numRows - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0 ; col--) {
                boolean value = (row / (int)Math.pow(2, col)) % 2 == 0;
                System.out.print(value  + "\t");
                truthTable[row][col] = value;
            }
            System.out.println();
        }
        return truthTable;
    }


    /** Returns a list of strings, each of which has been truncated to a length of
        10 characters.
     @param toTruncate  A list of strings to be truncated
     @return            A list of truncated strings, no longer than 10 characters each
    */
    public static String[] truncate(String[] toTruncate) {
        if (toTruncate == null) {
            return new String[0];
        }

        for (int i = 0; i < toTruncate.length; i++) {
            if (toTruncate[i].length() > 10) {
                toTruncate[i] = toTruncate[i].substring(0, 10);
            }
        }
        return toTruncate;
    }


    /** Returns a boolean signifying whether or not the arguments
        list is at least 2 inputs
     @param arguments The string of arguments
     @return          The validation status of the input arguments
    */
    public static boolean validInput(String[] arguments) {
        if ((arguments == null) || (arguments.length < 2)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     @param args The list of parameters for which to generate a Pairwise Test plan
    */
    public static void main(String[] args) {
        if (!validInput(args)) {
            System.out.println("USAGE: java Pairwise <list of 2 or more parameters>");
            System.exit(1);
        }

        // Get the list of parametes with the 10-char truncation limit applied
        String[] params = truncate(args);
        if (params.length == 0) {
            System.out.println("An internal error occured. Exiting...");
            System.exit(1);
        }

        // Generate the full truth table for the number of parameters we are given
        boolean[][] truthTable = getTruthTable(params.length);
    }
}
