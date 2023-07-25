package src.main;

import java.util.Arrays;

public class Board {

    private String[][] board;
    private int size;

    public Board(int size) {
        String[][] initBoard = new String[size][size];
        for (String[] array : initBoard) {
            Arrays.fill(array, CellTypes.UNKNOWN.view());
        }
        this.board = initBoard;
        this.size = size;
    }

    public enum LineType {
        ROW,
        COLUMN;
    }

    public void visualize() {
        System.out.println(" 0123456789");
        int rowCount = 0;
        for (String[] row : board) {
            System.out.print(rowCount);
            for (String column : row) {
                System.out.print(column);
            }
            System.out.println();
            rowCount += 1;
        }
        System.out.println();
    }

    public void fill(int x, int y) {
        board[y][x] = CellTypes.FILLED.view();
    }

    public void fillAll(int startCoordinate, int endCoordinate, LineType lineType, int lineCoordinate) {
        if (lineType == LineType.ROW) {
            for (int i = startCoordinate;i<endCoordinate;i++) {
                fill(i, lineCoordinate-1);
            }
        } else if (lineType == LineType.COLUMN) {
            for (int i = startCoordinate;i<endCoordinate;i++) {
                fill(lineCoordinate-1, i);
            }
        }
    }

    private void fillGroupsToSizeOfBoard(int numbers, LineType lineType, int lineIndex) {
        int numberToFillIn = 0;
        int indexToFill = size;
        while (numbers > 0) {
            numberToFillIn = numbers % 10;
            fillAll(indexToFill - numberToFillIn, indexToFill, lineType, lineIndex);
            numbers = numbers / 10;

            int spaceForEmpty = indexToFill - numberToFillIn - 1;
            if (spaceForEmpty < 10 && spaceForEmpty > -1) {
                if (lineType == LineType.ROW) {
                    emptySquare(spaceForEmpty, lineIndex-1);
                } else if (lineType == LineType.COLUMN) {
                    emptySquare(lineIndex-1, spaceForEmpty);
                }
            }
            indexToFill = indexToFill - numberToFillIn - 1;
        }
    }

    private void emptySquare(int x, int y) {
        board[y][x] = CellTypes.EMPTY.view();
    }

    public void logic(int numbers, LineType lineType, int lineIndex) {
        // if it is the size of the board, then fill it all
        if (numbers == 0) {
            fillAll(0,size, lineType, lineIndex);
        }

        int numberOfSpacesBetweenFilledAreas = String.valueOf(numbers).length() - 1;
        int numberOfFilledSpaces = sumOfDigits(numbers);

        if (numberOfFilledSpaces + numberOfSpacesBetweenFilledAreas == size) {
            fillGroupsToSizeOfBoard(numbers, lineType, lineIndex);
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
