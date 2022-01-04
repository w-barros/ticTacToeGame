package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String switchPlayer(String player) {
        if (player.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

    public static void makeAmove (List<String> game, String player) {
        Scanner scannerMove = new Scanner(System.in);
        System.out.println("Enter the coordinates:");
        String firstInput = scannerMove.next();
        String secondInput = scannerMove.next();
        int firstCoord = 0;
        int secondCoord = 0;
        try {
            firstCoord = Integer.parseInt(firstInput);
            secondCoord = Integer.parseInt(secondInput);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            makeAmove(game, player);
        }
        if (firstCoord < 1 || firstCoord > 3 || secondCoord < 1 || secondCoord > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            makeAmove(game, player);
            return;
        }

        if (firstCoord == 1 && secondCoord == 1 && (game.get(0).equals(" "))) {
            game.set(0, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        if (firstCoord == 1 && secondCoord == 2 && (game.get(1).equals(" "))) {
            game.set(1, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        if (firstCoord == 1 && secondCoord == 3 && (game.get(2).equals(" "))) {
            game.set(2, player);
            printGame(game);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        //
        if (firstCoord == 2 && secondCoord == 1 && (game.get(3).equals(" "))) {
            game.set(3, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        if (firstCoord == 2 && secondCoord == 2 && (game.get(4).equals(" "))) {
            game.set(4, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        if (firstCoord == 2 && secondCoord == 3 && (game.get(5).equals(" "))) {
            game.set(5, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        //
        if (firstCoord == 3 && secondCoord == 1 && (game.get(6).equals(" "))) {
            game.set(6, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        if (firstCoord == 3 && secondCoord == 2 && (game.get(7).equals(" "))) {
            game.set(7, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }
        if (firstCoord == 3 && secondCoord == 3 && (game.get(8).equals(" "))) {
            game.set(8, player);
            String newPlayer = switchPlayer(player);
            gameLoop(game, newPlayer);
        }

        System.out.println("This cell is occupied! Choose another one!");
        makeAmove(game, player);
    }

    public static void printGame (List<String> game) {
        System.out.println("---------");
        System.out.println("| " + game.get(0) + " " + game.get(1) + " " + game.get(2) + " |");
        System.out.println("| " + game.get(3) + " " + game.get(4) + " " + game.get(5) + " |");
        System.out.println("| " + game.get(6) + " " + game.get(7) + " " + game.get(8) + " |");
        System.out.println("---------");
    }

    public static void gameLoop (List<String> game, String player) {
        printGame(game);

        // X Wins
                if (game.get(0).equals("X") && game.get(1).equals("X") && game.get(2).equals("X") ||
                        game.get(3).equals("X") && game.get(4).equals("X") && game.get(5).equals("X") ||
                        game.get(6).equals("X") && game.get(7).equals("X") && game.get(8).equals("X") ||
                        game.get(0).equals("X") && game.get(3).equals("X") && game.get(6).equals("X") ||
                        game.get(1).equals("X") && game.get(4).equals("X") && game.get(7).equals("X") ||
                        game.get(2).equals("X") && game.get(5).equals("X") && game.get(8).equals("X") ||
                        game.get(0).equals("X") && game.get(4).equals("X") && game.get(8).equals("X") ||
                        game.get(2).equals("X") && game.get(4).equals("X") && game.get(6).equals("X")
        ) {
                    System.out.println("X wins");
                    System.exit(0);
        }

        // O Wins
        if (game.get(0).equals("O") && game.get(1).equals("O") && game.get(2).equals("O") ||
                game.get(3).equals("O") && game.get(4).equals("O") && game.get(5).equals("O") ||
                game.get(6).equals("O") && game.get(7).equals("O") && game.get(8).equals("O") ||
                game.get(0).equals("O") && game.get(3).equals("O") && game.get(6).equals("O") ||
                game.get(1).equals("O") && game.get(4).equals("O") && game.get(7).equals("O") ||
                game.get(2).equals("O") && game.get(5).equals("O") && game.get(8).equals("O") ||
                game.get(0).equals("O") && game.get(4).equals("O") && game.get(8).equals("O") ||
                game.get(2).equals("O") && game.get(4).equals("O") && game.get(6).equals("O")
        ) {
            System.out.println("O wins");
            System.exit(0);
        }

        boolean hasEmptyCells = false;
        // Empty cell
        if (game.contains(" ")) {
            hasEmptyCells = true;
        } else {
            hasEmptyCells = false;
        }

                //DRAW
        if (hasEmptyCells == false) {
            System.out.println("Draw");
            System.exit(0);
        }

        makeAmove(game, player);

    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(" "," "," "," "," "," "," "," ", " "));
     printGame(list);
     makeAmove(list, "X");

//
//        boolean gameNotFinished = false;
//        boolean draw = false;
//        boolean xWins = false;
//        boolean oWins = false;
//        boolean impossible = false;
//        boolean hasEmptyCells = false;
//
//
//        List list = Arrays.asList(lineAsArray);
//
//
//        if (lineAsArray[0].equals("X") && lineAsArray[1].equals("X") && lineAsArray[2].equals("X") ||
//                lineAsArray[3].equals("X") && lineAsArray[4].equals("X") && lineAsArray[5].equals("X") ||
//                lineAsArray[6].equals("X") && lineAsArray[7].equals("X") && lineAsArray[8].equals("X") ||
//                lineAsArray[0].equals("X") && lineAsArray[3].equals("X") && lineAsArray[6].equals("X") ||
//                lineAsArray[1].equals("X") && lineAsArray[4].equals("X") && lineAsArray[7].equals("X") ||
//                lineAsArray[2].equals("X") && lineAsArray[5].equals("X") && lineAsArray[8].equals("X") ||
//                lineAsArray[0].equals("X") && lineAsArray[4].equals("X") && lineAsArray[8].equals("X") ||
//                lineAsArray[2].equals("X") && lineAsArray[4].equals("X") && lineAsArray[6].equals("X")
//        ) {
//            xWins = true;
//            System.out.println("X ganhou");
//        }
//        if (lineAsArray[0].equals("O") && lineAsArray[1].equals("O") && lineAsArray[2].equals("O") ||
//                lineAsArray[3].equals("O") && lineAsArray[4].equals("O") && lineAsArray[5].equals("O") ||
//                lineAsArray[6].equals("O") && lineAsArray[7].equals("O") && lineAsArray[8].equals("O") ||
//                lineAsArray[0].equals("O") && lineAsArray[3].equals("O") && lineAsArray[6].equals("O") ||
//                lineAsArray[1].equals("O") && lineAsArray[4].equals("O") && lineAsArray[7].equals("O") ||
//                lineAsArray[2].equals("O") && lineAsArray[5].equals("O") && lineAsArray[8].equals("O") ||
//                lineAsArray[0].equals("O") && lineAsArray[4].equals("O") && lineAsArray[8].equals("O") ||
//                lineAsArray[2].equals("O") && lineAsArray[4].equals("O") && lineAsArray[6].equals("O")
//        ) {
//            oWins = true;
//            System.out.println(" O ganhou");
//        }
//        if (list.contains("_")) {
//            hasEmptyCells = true;
//        } else {
//            hasEmptyCells = false;
//        }
//
//
//        long xses = list.stream().filter(c -> c.equals("X")).count();
//        long oses = list.stream().filter(c -> c.equals("O")).count();
//
//        if (xWins && oWins || xses > (oses + 1) || oses > (xses + 1)) {
//            System.out.println("Impossible");
//            return;
//        }
//
//        //NOT FINISHED
//        if (xWins == false && oWins == false && hasEmptyCells) {
//            System.out.println("Game not finished");
//            return;
//        }
//
//        //DRAW
//        if (xWins == false && oWins == false && hasEmptyCells == false) {
//            System.out.println("Draw");
//            return;
//        }
//
//        //X wins
//        if (xWins) {
//            System.out.println("X wins");
//            return;
//        }
//
//        //O wins
//        if (oWins) {
//            System.out.println("O wins");
//            return;
//        }
//    }
}}
