package src;

import src.CellTypes;

import java.sql.SQLOutput;
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

        if (numbers == 7) {
            System.out.println("made to 7");
        }
    }
}
