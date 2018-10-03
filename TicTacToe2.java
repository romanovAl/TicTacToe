package com.company;

import java.util.Scanner;

public class TicTacToe2 {
    String[][] gameBoard = new String[3][3]; // тут вообще всё серое, но не понятно почему(((

    Scanner inputScan = new Scanner(System.in);

    String playerX = "X", playerO = "O", currentPlayer = playerX;

    int row, col, col1, row1;
    boolean isX , canGo ;

    TicTacToe2() {
//        initGameBoard();
        isX = true;
        canGo = true;

        while (true) {           // Переделать вайл тру. Сделать функцию, котороя проверяет победу и возвращает буливун. Пихать сюда его
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

            buildGameBoard2();

        }


    }



    private void buildGameBoard2() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == row && j == col) {
                    if (gameBoard[i][j] != null) {
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == null){
                    System.out.print("0" + "\t");
                }else{
                    System.out.print(gameBoard[i][j] + "\t");
                }

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


}


