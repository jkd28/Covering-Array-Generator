/**
 * Description
 * @author John Dott.
 */
public class Pairwise {
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
    }
}
