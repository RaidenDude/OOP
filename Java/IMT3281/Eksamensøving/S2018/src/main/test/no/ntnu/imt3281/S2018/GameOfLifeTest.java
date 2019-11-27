package no.ntnu.imt3281.S2018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private static final int ROWSIZE = 4;
    private static final int COLUMNSIZE = 8;

    /**
     * Creates an empty board, and checks that [1, 4] has no neighbours
     */
    @Test
    void testEmptyBoard() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Checks that [1, 4] has 0 neighbours
        assertEquals(0, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates a living cell, and confirms that it is found as a neighbour
     */
    @Test
    void testOneLivingNeighbour() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3]
        game.setLivingCell(0, 3);

        // Checks that [1, 4] now has 1 neighbour
        assertEquals(1, game.amountOfNeighbours(1, 4));

        // Creates another empty board
        game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [2, 3]
        game.setLivingCell(2, 3);

        // Checks that [3, 3] now has 1 neighbour
        assertEquals(1, game.amountOfNeighbours(3, 3));
    }

    /**
     * Creates two living cells, and confirms that they are both found as neighbours
     */
    @Test
    void testTwoLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3] and [0, 4]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);

        // Checks that [1, 4] now has 2 neighbours
        assertEquals(2, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates three living cells, and confirms that they are all found as neighbours
     */
    @Test
    void testThreeLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3], [0, 4], and [0, 5]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);
        game.setLivingCell(0, 5);

        // Checks that [1, 4] now has 3 neighbours
        assertEquals(3, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates four living cells, and confirms that they are all found as neighbours
     */
    @Test
    void testFourLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3], [0, 4], and [0, 5]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);
        game.setLivingCell(0, 5);

        // Creates a new living cell in [1, 5]
        game.setLivingCell(1, 5);

        // Checks that [1, 4] now has 4 neighbours
        assertEquals(4, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates five living cells, and confirms that they are all found as neighbours
     */
    @Test
    void testFiveLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3], [0, 4], and [0, 5]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);
        game.setLivingCell(0, 5);

        // Creates a new living cell in [1, 5] and [2, 5]
        game.setLivingCell(1, 5);
        game.setLivingCell(2, 5);

        // Checks that [1, 4] now has 5 neighbours
        assertEquals(5, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates six living cells, and confirms that they are all found as neighbours
     */
    @Test
    void testSixLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3], [0, 4], and [0, 5]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);
        game.setLivingCell(0, 5);

        // Creates a new living cell in [1, 5], [2, 4], and [2, 5]
        game.setLivingCell(1, 5);
        game.setLivingCell(2, 4);
        game.setLivingCell(2, 5);

        // Checks that [1, 4] now has 6 neighbours
        assertEquals(6, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates seven living cells, and confirms that they are all found as neighbours
     */
    @Test
    void testSevenLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3], [0, 4], and [0, 5]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);
        game.setLivingCell(0, 5);

        // Creates a new living cell in [1, 5]
        game.setLivingCell(1, 5);

        // Creates a new living cell in [2, 3], [2, 4], and [2, 5]
        game.setLivingCell(2, 3);
        game.setLivingCell(2, 4);
        game.setLivingCell(2, 5);

        // Checks that [1, 4] now has 7 neighbours
        assertEquals(7, game.amountOfNeighbours(1, 4));
    }

    /**
     * Creates eight living cells, and confirms that they are all found as neighbours
     */
    @Test
    void testEightLivingNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 3], [0, 4], and [0, 5]
        game.setLivingCell(0, 3);
        game.setLivingCell(0, 4);
        game.setLivingCell(0, 5);

        // Creates a new living cell in [1, 3] and [1, 5]
        game.setLivingCell(1, 3);
        game.setLivingCell(1, 5);

        // Creates a new living cell in [2, 3], [2, 4], and [2, 5]
        game.setLivingCell(2, 3);
        game.setLivingCell(2, 4);
        game.setLivingCell(2, 5);

        // Checks that [1, 4] now has 8 neighbours
        assertEquals(8, game.amountOfNeighbours(1, 4));
    }

    /**
     * Tests neighbour-amounts in the top left corner
     */
    @Test
    void testUpperLeftNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [0, 1], [1, 0], and [1, 1]
        game.setLivingCell(0, 1);
        game.setLivingCell(1, 0);
        game.setLivingCell(1, 1);

        // Checks that [0, 0] now has 3 neighbours
        assertEquals(3, game.amountOfNeighbours(0, 0));
    }

    /**
     * Tests neighbour-amounts in the bottom right corner
     */
    @Test
    void testLowerRightNeighbours() {
        // Creates an empty board
        GameOfLife game = new GameOfLife(ROWSIZE, COLUMNSIZE);

        // Creates a new living cell in [3, 6], [2, 6], and [2, 7]
        game.setLivingCell(3, 6);
        game.setLivingCell(2, 6);
        game.setLivingCell(2, 7);

        // Checks that [3, 7] now has 3 neighbours
        assertEquals(3, game.amountOfNeighbours(3, 7));
    }


}
