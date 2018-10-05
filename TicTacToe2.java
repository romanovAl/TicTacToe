package com.company;

import java.util.Scanner;

public class TicTacToe2 {
    String[][] gameBoard ; // тут вообще всё может быть private, но не понятно почему(((

    String playerX , playerO , currentPlayer ;

    int row, col;
    boolean isX , canGo ;

    TicTacToe2() {

        isX = true;
        canGo = true;
        playerX = "X";
        playerO = "O";
        currentPlayer = playerX;
        Scanner inputScan = new Scanner(System.in);
        gameBoard = new String[3][3];
        boolean winX = false, winO = false, draw = false;

        initGameBoard();

        while (true) {           //до сих пор процесс бесконечный, надо шот делать
            System.out.println();//чоб хоть что-то в этом коде было красиво


            if (currentPlayer.equals(playerX) && canGo) {
                System.out.println("Ходят крестики");
            } else {
                System.out.println("Ходят нолики");
                System.out.println();
            }

            currentPlayer = currentPlayer.equals(playerX) && canGo ? playerO : playerX;


            while (true) {
                System.out.println("Введите строчку");
                row = inputScan.nextInt();
                if (row <= 3 && row >= 0) {
                    break;
                }else{
                    System.out.println("Не, так не покатит. Число от ноля до двойки, давай пробуй еще раз");
                }
            }

            while (true) {
                System.out.println("Введите колонку");
                col = inputScan.nextInt();
                if (col <= 3 && col >= 0) {
                    break;
                }else{
                    System.out.println("Не, так не покатит. Число от ноля до двойки, давай пробуй еще раз");
                }
            }

            buildGameBoard();
            if (winCheckerO()){
                System.out.println("Нолики победили");

            }else if(winCheckerX()){
                System.out.println("Крестики победили");

            }
            else {
                System.out.println("Ну как-бы ничья"); //Оно выводится постоянно, надо сделать функцию на ничью
            }
        }


    }

    private void initGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = "0";
            }
        }
    }

    private void buildGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == row && j == col) {
                    if (gameBoard[i][j] != "0") {
                        System.out.println("Нельзя ставить на чужое место, давай еще раз");
                        canGo = false;
                        return;
                    }
                    if (isX) {
                        gameBoard[i][j] = "X";
                        isX = false;
                    } else {
                        gameBoard[i][j] = "O";
                        isX = true;
                    }
                }
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(gameBoard[i][j] + "\t");

                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (i < 2) {
                System.out.println("___________");
            }
        }
    }

    private boolean winCheckerX() {
        boolean winX = false;
        int j = 0;
        int a = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][j].equals("X")  && gameBoard[i][j + 1].equals("X") && gameBoard[i][j+2].equals("X")) {
                winX = true;
            }
            else if(gameBoard[a][j].equals("X")  && gameBoard[a+1][j + 1].equals("X") && gameBoard[a+2][j+2].equals("X")){
                winX = true;
            }
            else {
                winX = false;
            }

        }

        return winX;
    }


    private boolean winCheckerO(){
        boolean winO = false;
        int j = 0;
        int a = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][j].equals("O")  && gameBoard[i][j + 1].equals("O") && gameBoard[i][j+2].equals("O")) {
                winO = true;
            }
            else if(gameBoard[a][j].equals("O")  && gameBoard[a+1][j + 1].equals("O") && gameBoard[a+2][j+2].equals("O")){
                winO = true;
            }
            else {
                winO = false;
            }

        }

        return winO;
    }


}


