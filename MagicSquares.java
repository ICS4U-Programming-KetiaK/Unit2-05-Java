/**
* MagicSquares program displays the
* magic squares for a 3x3 square.
*
* @author Nicholas B. & Mr. Coxall & Ketia Gaelle Kaze
* @version 1.0
* @since   2022-04-21
*/

class MagicSquares {
    /**
    * The middle left index.
    */
    public static final int THREE = 3;
    /**
    * The center index.
    */
    public static final int FOUR = 4;
    /**
    * The middle right index.
    */
    public static final int FIVE = 5;
    /**
    * The lower left index.
    */
    public static final int SIX = 6;
    /**
    * The lower center index.
    */
    public static final int SEVEN = 7;
    /**
     * The lower right index.
     */
    public static final int EIGHT = 8;
    /**
    * The maximum number for magicNumbers.
    */
    public static final int NINE = 9;
    /**
    * The maximum number for magicNumbers.
    */
    public static final int MAGICNUM = 15;
    /**
    * Creating an empty constructor.
    */

    public MagicSquares() { }

    /**
    * Creating a function that displays the magic squares.
    *
    * @param square passed
    * @param currentSquare passed
    * @param  index passed
    */

    public static void genSquare(int[] square, int[] currentSquare,
                int index) {
        for (int counter = 0; counter < square.length; counter++) {
            // Create new squares
            if (currentSquare[counter] == 0) {
                currentSquare[counter] = 1;
                square[index] = counter + 1;

                if (index < square.length - 1) {
                    // Completes the new array of square
                    genSquare(square, currentSquare, index + 1);
                } else {
                    if (isMagic(square)) {
                        printMagicSquare(square);
                    }
                }
                currentSquare[counter] = 0;
            }
        }
    }

    /**
    * Creating a function that tells if the array is a
    * magic square or not.
    *
    * @param preSquare passed in
    *
    * @return result
    */
    public static boolean isMagic(final int[] preSquare) {
        // returns true or false if the array is a magic square or not
        int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        boolean result = row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
        return result;
    }

    /**
    * Creating a function that prints the array in the format of a
    * magic square.
    *
    * @param outputSquare passed in
    */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }

    /**
    * Creating the main function.
    *
    * @param args nothing passed in
    *
    */
    public static void main(final String[] args) {
        // main stub, get user input here
        int[] magicSquare = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);
    }
}
