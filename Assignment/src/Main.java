//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import RenameMe.Dice.RandomSingleDiceShaker;
import RenameMe.DiceShaker;

import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int rows = 5;
        int cols = 6;
        int boardSize = rows * cols;
        int numPlayers = 2;
        String rulesUsed = "bouncing end, Hit and Wormhole";


        System.out.println("########################################");
        System.out.println("#         BOARD GAME SIMULATION        #");
        System.out.println("########################################");
        System.out.println("Board Size: "+ boardSize + " squares");
        System.out.println("Number of Players: " + numPlayers);
        System.out.println("Game Rules: " + rulesUsed);
        System.out.println("########################################\n");


        DiceShaker diceShaker = new RandomSingleDiceShaker();
        Iterator<Integer> diceIterator = diceShaker.iterator();

        int[][] board = new int[rows][cols];
        int squareNum = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = squareNum++;
            }
        }


        int[] playerPositions = new int[numPlayers];
        int[] playerTurns = new int[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playerPositions[i] = 1; // All players start at square 1
            playerTurns[i] = 0;
        }

        boolean gameWon = false;
        int currentPlayer = 0;
        int totalTurnsAllPlayers = 0;
        Random random = new Random();


        while (!gameWon) {
            int playerDisplayNum = currentPlayer + 1;
            int posBefore = playerPositions[currentPlayer];

            int roll = diceIterator.next();

            int posAfter = posBefore + roll;
            if (posAfter > boardSize) {
                posAfter = boardSize;
            }

            // if wormhole
            if (posAfter == 10) {
                posAfter = 16;
                System.out.println("Hit a wormhole forwards! Boosted to square " + posAfter);
            } else if (posAfter == 24) {
                posAfter = 18; // Wormhole drop backward
                System.out.println(" Hit a wormhole backwards! Sucked backward to square " + posAfter);
            }

            // if hit player rule
            for (int p = 0; p < numPlayers; p++) {
                if (p != currentPlayer && playerPositions[p] == posAfter) {
                    playerPositions[p] = 1;
                    System.out.println("Hit a player! Player (number here) was hit and sent back to square 1!");
                }
            }

            playerPositions[currentPlayer] = posAfter;
            playerTurns[currentPlayer]++;
            totalTurnsAllPlayers++;


            System.out.println("Current Player: Player " + playerDisplayNum);
            System.out.println("Dice Roll Value: " + roll);
            System.out.println("Position Before Turn: " + posBefore);
            System.out.println("Position After Turn:  " + posAfter);


            System.out.println("Turns taken by Player " + playerDisplayNum + " so far: " + playerTurns[currentPlayer]);
            System.out.println("----------------------------------------");


            //if end rule do here

            if (posAfter == boardSize) {
                gameWon = true;
                System.out.println("\n########################################");
                System.out.println("#             GAME OVER                 #");
                System.out.println("########################################");
                System.out.println("Winning Player: Player " + playerDisplayNum);
                System.out.println("Total Turns Taken By All Players: " + totalTurnsAllPlayers);
                System.out.println("########################################");
                break;
            }

            currentPlayer = (currentPlayer + 1) % numPlayers; //check if its more efficient to infinite loop?
        }
    }
}


