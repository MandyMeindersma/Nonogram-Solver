package src.main;

import java.util.Arrays;

public class Board {

    private String[] board;
    private int size;

    public Board(int size) {
        String[] initBoard = new String[size];
        Arrays.fill(initBoard, CellTypes.UNKNOWN.view());
        this.board = initBoard;
        this.size = size;
    }

    public void visualize() {
        System.out.println("0123456789");
        for (String val : board) {
            System.out.print(val);
        }
        System.out.println();
    }

    public void fill(int coordinate) {
        board[coordinate] = CellTypes.FILLED.view();
    }

    public void fillAll(int startCoordinate, int endCoordinate) {
        for (int i = startCoordinate;i<endCoordinate;i++) {
            fill(i);
        }

    }

    public void logic(int numbers) {
        // if it is the size of the board, then fill it all
        if (numbers == 0) {
            fillAll(0,size);
            visualize();
        }

        int numberOfSpacesBetweenFilledAreas = String.valueOf(numbers).length() - 1;
        int numberOfFilledSpaces = sumOfDigits(numbers);

        if (numberOfFilledSpaces + numberOfSpacesBetweenFilledAreas == size) {
            System.out.println("made it to knowing how to fill the board");
        }
    }

    public int sumOfDigits(int numbers) {
        int sum = 0;
        int numberToAdd;
        while (numbers > 0) {
            numberToAdd = numbers % 10;
            sum = sum + numberToAdd;
            numbers = numbers / 10;
        }
        sum = sum + numbers;

        return sum;
    }
}
