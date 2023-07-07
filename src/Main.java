package src;

import src.Board;



public class Main {

    public static int BOARD_SIZE = 10;
    public static void main(String[] args) {
        nanogramSolver(args);
    }

    public static void nanogramSolver(String[] args) {

        Board board = new Board(BOARD_SIZE);

        if (!validateInput(args)) {
            System.out.println("incorrect input");
            System.exit(0);
        }

        boolean horizontalInput = true;


        for (String val : args) {
            int numbers = -1;
            if (horizontalInput) {
                String[] horizontalValues = val.split(",");

                for (String horizontalValue : horizontalValues) {
                    numbers = Integer.valueOf(horizontalValue.toString());
                    board.logic(numbers);
                }
            }

            if (!horizontalInput) {
                numbers = Integer.valueOf(val.toString());
                board.logic(numbers);
            }
            horizontalInput = false;


        }

    }

    public static boolean validateInput(String[] args) {
        //TODO actually implement this
        return true;
    }
}
