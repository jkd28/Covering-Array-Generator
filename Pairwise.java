/**
 * Description
 * @author John Dott.
*/

import java.util.ArrayList;

public class Pairwise {
    /** Generates the output string from the Covering Array provided
    @param coveringArray    The covering array for a given set of inputs
    @param params           The name of the inputs for use in output formatting

    @return                 The pretty, formatted string form of the covering array
    */
    public static String getFormattedCoveringArray(ArrayList<boolean[]> coveringArray, String[] params) {
        // First, build the parameter line
        StringBuilder arrayToString = new StringBuilder("");
        for (String parameter : params) {
            arrayToString.append(parameter);
            arrayToString.append("\t");
        }

        arrayToString.append("\n");

        // Now build the actual covering array output
        for (boolean[] row : coveringArray) {
            for (int i = 0; i < row.length; i++) {
                int boolVal = row[i] ? 1 : 0;

                StringBuilder rowString = new StringBuilder();
                rowString.append(boolVal);
                rowString.append("\t");

                arrayToString.append(rowString);
            }
            arrayToString.append("\n");
        }
        return arrayToString.toString();
    }

    /** This helper method adds the covering row for the given pairing of parameters to the Covering Row list.
        If the row is already present in the list, nothing is added.

    @param param1           The number of the first column (parameter) to compare
    @param param2           The number of the second column (parameter) to compare
    @param truthTable       Truth table for the number of parameters provided to the program
    @param coveringArray    Current covering array to which the new row will be added

    @return             The covering array with added covering row
    */
    private static ArrayList<boolean[]> addCoveringRow(int param1, int param2,
                                                        boolean[][] truthTable,
                                                        ArrayList<boolean[]> coveringArray) {
        // Enumerate all possible pairwise combinations for comparison
        boolean[][] comparisons = {{false, false}, {false, true}, {true, false}, {true, true}};

        // Check the covering array for a match first
        for (boolean[] comparison : comparisons) {
            boolean check1 = comparison[0];
            boolean check2 = comparison[1];

            boolean matchFoundInCoveringArray = false;
            for (boolean[] row : coveringArray) {
                if ((check1 == row[param1]) && (check2 == row[param2])) {
                    // There is a match in the covering array
                    matchFoundInCoveringArray = true;
                    break;
                }
            }

            if (!matchFoundInCoveringArray) {
                // We need to search the truth table for a covering row
                for (boolean[] row : truthTable) {
                    if ((check1 == row[param1]) && (check2 == row[param2])) {
                        coveringArray.add(row);
                        break;
                    }
                }
            }
        }
        return coveringArray;
    }

    /** Returns the collection of rows that allows for each pairwise combination of parameters to
        be tested.
    @param truthTable   A full truth table for the number of parameters provided to the program

    @return             The rows which comprise a covering array for all pairwise combinations of parameters
    */
    public static ArrayList<boolean[]> getCoveringArray(boolean[][] truthTable) {
        int numColumns = truthTable[0].length;

        ArrayList<boolean[]> coveringArray = new ArrayList<boolean[]>();
        // Find all possible pairwise combinations of paramters (columns)
        for (int currentColumn = 0; currentColumn < numColumns; currentColumn++) {
            for (int pairing = currentColumn + 1; pairing < numColumns; pairing++) {
                coveringArray = addCoveringRow(currentColumn, pairing, truthTable, coveringArray);
            }
        }
        return coveringArray;
    }


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
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < n; col++) {
                boolean value = (row / (int)Math.pow(2, col)) % 2 == 0;
                truthTable[row][col] = value;
            }
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
            System.out.println("Please enter at least 2 parameters!");
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

        // Find the covering array
        ArrayList<boolean[]> coveringArrayRows = getCoveringArray(truthTable);

        String output = getFormattedCoveringArray(coveringArrayRows, params);
        System.out.println(output);
    }
}
