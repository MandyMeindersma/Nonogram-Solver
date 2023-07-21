package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import src.main.Board;



public class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10);
    }

    @Test
    @DisplayName("Sum of 521")
    void testSumOfNumbers521() {
        assertEquals(8, board.sumOfDigits(521));
    }

    @Test
    @DisplayName("Sum of 11111")
    void testSumOfNumbers11111() {
        assertEquals(5, board.sumOfDigits(11111));
    }

    @Test
    @DisplayName("Sum of 212")
    void testSumOfNumbers212() {
        assertEquals(5, board.sumOfDigits(212));
    }

    @Test
    @DisplayName("Sum of 44")
    void testSumOfNumbers44() {
        assertEquals(8, board.sumOfDigits(44));
    }
}
