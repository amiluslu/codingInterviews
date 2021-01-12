package com.amilus;

import java.util.Random;

public class TicTacToe {

    public final static int TOTAL_ROWS = 5;
    public final static int TOTAL_COLS = 5;

    public final static int PLAYER_ONE = 0;
    public final static int PLAYER_TWO = 1;

    public final static char PLAYER_ONE_PIECE = 'X';
    public final static char PLAYER_TWO_PIECE = 'O';

    public static final char EMPTY = ' ';

    public final static int DIRECTION_LEFT = 0;
    public final static int DIRECTION_RIGHT = 1;
    public final static int DIRECTION_UP = 2;
    public final static int DIRECTION_DOWN = 3;

    public static char[][] gameBoardPositions = new char[TOTAL_ROWS][TOTAL_COLS];
    public static int currentTurn = 1;
    public static int currentPlayer;

    public static void main(String[] args) {

        initializeGameBoard();

        currentPlayer = selectPlayerToStart();

        while(!isEndOfGame())
        {
            displayGameStatistics();

            int[] newPosition = generatePosition();

            if(isPositionOccupied(newPosition[0], newPosition[1]))
            {
                System.out.println("Position " + newPosition[0] + ","
                                + newPosition[1] + " is already occupied. Current player skips a turn.");
            }
            else
            {
                placeItem(newPosition[0], newPosition[1]);

                if(currentPlayer == PLAYER_ONE)
                {
                    System.out.println("Placed " + PLAYER_ONE_PIECE +
                            " at position " + newPosition[0] + "," + newPosition[1]);
                }
                else
                {
                    System.out.println("Placed " + PLAYER_TWO_PIECE +
                            " at position " + newPosition[0] + "," + newPosition[1]);
                }
            }

            endOfTurnActions();

            displayGameBoard();
        }

        if(existRowOfItem(PLAYER_ONE_PIECE))
        {
            System.out.println("PLAYER ONE wins. There is a row of "
                    + PLAYER_ONE_PIECE + " on the game board.");
        }
        else if(existRowOfItem(PLAYER_TWO_PIECE))
        {
            System.out.println("PLAYER TWO wins. There is a row of "
                    + PLAYER_TWO_PIECE + " on the game board.");
        }
        else if(existColumnOfItem(PLAYER_ONE_PIECE))
        {
            System.out.println("PLAYER ONE wins. There is a column of "
                    + PLAYER_ONE_PIECE + " on the game board.");
        }
        else if(existColumnOfItem(PLAYER_TWO_PIECE))
        {
            System.out.println("PLAYER TWO wins. There is a column of "
                    + PLAYER_TWO_PIECE + " on the game board.");
        }
        else if(existDiagonalOfItem(PLAYER_ONE_PIECE))
        {
            System.out.println("PLAYER ONE wins. There is a diagonal of "
                    + PLAYER_ONE_PIECE + " on the game board.");
        }
        else if(existDiagonalOfItem(PLAYER_TWO_PIECE))
        {
            System.out.println("PLAYER TWO wins. There is a diagonal of "
                    + PLAYER_TWO_PIECE + " on the game board.");
        }
        else
        {
            System.out.println
                    ("There is NO WINNER All positions on the game board have been occupied.");
        }
    }

    public static void initializeGameBoard()
    {
        for (int row = 0; row < TOTAL_ROWS; row++)
        {
            for (int col = 0; col < TOTAL_COLS; col++)
            {
                gameBoardPositions[row][col] = EMPTY;
            }
        }
    }

    public static void displayGameBoard()
    {
        for (int row = 0; row < TOTAL_ROWS; row++)
        {
            for (int col = 0; col < TOTAL_COLS; col++)
            {
                char charDisplay = gameBoardPositions[row][col];

                System.out.print("[" + charDisplay + "]");

                if((col + 1) % (TOTAL_COLS) == 0)
                {
                    System.out.println();
                }
            }
        }

        System.out.println();
    }

    public static int selectPlayerToStart()
    {
        Random random = new Random();

        return random.nextInt(2);
    }

    public static int [] generatePosition()
    {
        Random random = new Random();
        int row = random.nextInt(TOTAL_ROWS);
        int col = random.nextInt(TOTAL_COLS);

        return new int[] { row, col };
    }

    public static void placeItem(int row, int col)
    {
        if(currentPlayer == PLAYER_ONE)
        {
            gameBoardPositions[row][col] = PLAYER_ONE_PIECE;
        }
        else
        {
            gameBoardPositions[row][col] = PLAYER_TWO_PIECE;
        }
    }

    public static void displayGameStatistics()
    {
        if (currentPlayer == PLAYER_ONE)
        {
            System.out.println("Current player is PLAYER ONE");
        }
        else
        {
            System.out.println("Current player is PLAYER TWO");
        }
        System.out.println("Current turn is " + currentTurn);
    }

    public static boolean isPositionOccupied(int row, int col)
    {
        return gameBoardPositions[row][col] != EMPTY;
    }

    public static void endOfTurnActions()
    {
        //At the end of each turn, the current player is switched.
        currentPlayer = switchPlayer();
        //And the count of turns is incremented.
        currentTurn++;
    }

    public static int switchPlayer()
    {
        if (currentPlayer == PLAYER_ONE)
        {
            return PLAYER_TWO;
        }
        else
        {
            return PLAYER_ONE;
        }
    }

    public static boolean isEndOfGame()
    {
        if
        (
                endGameConditionOne()
                        ||
                        endGameConditionTwo()
                        ||
                        endGameConditionThree()
                        ||
                        endGameConditionFour()
        )
        {
            System.out.println("Game Over.");
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean endGameConditionOne()
    {

        for(int row = 0; row < TOTAL_ROWS; row++)
        {
            for(int col = 0; col < TOTAL_COLS; col++)
            {
                if(gameBoardPositions[row][col] == EMPTY)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean endGameConditionTwo()
    {
        return existRowOfItem(PLAYER_ONE_PIECE)
                ||
                existRowOfItem(PLAYER_TWO_PIECE);
    }

    public static boolean endGameConditionThree()
    {
        return existColumnOfItem(PLAYER_ONE_PIECE)
                ||
                existColumnOfItem(PLAYER_TWO_PIECE);
    }

    public static boolean endGameConditionFour()
    {
        return existDiagonalOfItem(PLAYER_ONE_PIECE)
                ||
                existDiagonalOfItem(PLAYER_TWO_PIECE);
    }

    public static boolean existRowOfItem(char item)
    {
        int countNoOfItem;

        for(int row = 0; row < TOTAL_ROWS; row++)
        {
            countNoOfItem = 0;

            for(int col = 0; col < TOTAL_COLS; col++)
            {
                if(gameBoardPositions[row][col] == item)
                {
                    countNoOfItem++;
                }

                if(countNoOfItem == TOTAL_COLS)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean existColumnOfItem(char item)
    {
        int countNoOfItem;

        for(int col = 0; col < TOTAL_COLS; col++)
        {
            countNoOfItem = 0;

            for(int row = 0; row < TOTAL_ROWS; row++)
            {
                if(gameBoardPositions[row][col] == item)
                {
                    countNoOfItem++;
                }

                if(countNoOfItem == TOTAL_ROWS)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean existDiagonalOfItem(char item)
    {
        int startRow = 0;
        int startCol = 0;

        int countNoOfItem = 0;

        for (int[] position = new int[] {startRow, startCol};
         position != null;
         position = getNextDiagonalPosition(position, DIRECTION_RIGHT, DIRECTION_DOWN))
        {
            if(gameBoardPositions[position[0]][position[1]] == item)
            {
                countNoOfItem++;
            }

            if(countNoOfItem == TOTAL_ROWS)
            {
                return true;
            }
        }

        countNoOfItem = 0;
        startRow = 0;
        startCol = (TOTAL_COLS - 1);

        for (int[] position = new int[] {startRow, startCol};
         position != null;
         position = getNextDiagonalPosition(position, DIRECTION_LEFT, DIRECTION_DOWN))
        {
            if(gameBoardPositions[position[0]][position[1]] == item)
            {
                countNoOfItem++;
            }

            if(countNoOfItem == TOTAL_ROWS)
            {
                return true;
            }
        }

        return false;
    }

    public static int [] getNextDiagonalPosition
            (int [] position, int horzDirection, int vertDirection)
    {
        int startRow = 0;
        int startCol = 0;

        int endRow = startRow + (TOTAL_ROWS - 1);
        int endCol = startCol + (TOTAL_COLS - 1);

        int row = position[0];
        int col = position[1];

        if (horzDirection == DIRECTION_LEFT)
        {
            col--;
        }
        else if (horzDirection == DIRECTION_RIGHT)
        {
            col++;
        }

        if (vertDirection == DIRECTION_UP)
        {
            row--;
        }
        else if (vertDirection == DIRECTION_DOWN)
        {
            row++;
        }

        if
        (
                ((row >= startRow) && (row <= endRow))
                        &&
                        ((col >= startCol) && (col <= endCol))
        )
        {

            return new int[] { row, col };
        }
        else
        {

            return null;
        }
    }
}
