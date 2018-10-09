package com.company;

import java.util.Scanner;

public class TicTacToe2 {
    String[][] gameBoardArr; // тут вообще всё может быть private, но не понятно почему(((

    String playerX, playerO, currentPlayer; //разобраться с этим

    private int row, col;
    private boolean isX, canGo;


    TicTacToe2() {

        boolean yes = true, no = false;


        String oneMoreTime = "Yes";


        while (true) {

            if (oneMoreTime.equalsIgnoreCase("yes")) {
                //nothing here, for sure

            } else if (oneMoreTime.equalsIgnoreCase("no")) {
                System.out.println("Датуидания");
                break;

            } else {
                System.out.println("Свершилось что-то страшное, уходим");
            }

            isX = true;
            canGo = true;
            playerX = "X";
            playerO = "O";
            currentPlayer = playerX;
            Scanner inputScan = new Scanner(System.in);
            gameBoardArr = new String[3][3];


            initGameBoard();

            while (true) { //Сделать повторение программы после спрашивания об этом у пользователя


                if (currentPlayer.equals(playerX) && canGo) { //Это работает некоректно (при попытке поставить на занятое место происходит дичь, ЧИНИ)
                    System.out.println("Ходят крестики \n");

                } else if (currentPlayer.equals(playerO) && canGo) {
                    System.out.println("Ходят нолики \n");

                }


                if (currentPlayer.equals(playerX) && canGo) {
                    currentPlayer = playerO;
                } else if (currentPlayer.equals(playerO) && canGo) {
                    currentPlayer = playerX;
                }


                while (true) {
                    System.out.println("Введите строчку");
                    row = inputScan.nextInt();
                    if (row <= 3 && row >= 0) {
                        break;
                    } else {
                        System.out.println("Не, так не покатит. Число от ноля до двойки, давай пробуй еще раз");
                    }
                }

                while (true) {
                    System.out.println("Введите колонку");
                    col = inputScan.nextInt();
                    if (col <= 3 && col >= 0) {
                        break;
                    } else {
                        System.out.println("Не, так не покатит. Число от ноля до двойки, давай пробуй еще раз");
                    }
                }

                buildGameBoard();
                if (winCheckerO()) {
                    System.out.println("/////////////////////////// \n Нолики победили \n ИГРА ЗАКОНЧЕНА");
                    System.out.println("\n Играем еще?");
                    oneMoreTime = inputScan.next();

                    if (oneMoreTime.equalsIgnoreCase("yes")){
                        System.out.println("Мм, да я вижу вы знаете толк в извращениях... Ну чтож, поехали \n");
                    }
                    break;


                } else if (winCheckerX()) {
                    System.out.println("/////////////////////////// \n Крестики победили \n ИГРА ЗАКОНЧЕНА");
                    System.out.println("\n Играем еще?");
                    oneMoreTime = inputScan.next();

                    if (oneMoreTime.equalsIgnoreCase("yes")){
                        System.out.println("Мм, да я вижу вы знаете толк в извращениях... Ну чтож, поехали \n");
                    }
                    break;


                } else if(drawChecker()) {
                    System.out.println("/////////////////////////// \n Хм, похоже на ничью");
                    System.out.println("\n Играем еще?");
                    oneMoreTime = inputScan.next();

                    if (oneMoreTime.equalsIgnoreCase("yes")){
                        System.out.println("Мм, да я вижу вы знаете толк в извращениях... Ну чтож, поехали \n");
                    }
                    break;
                }

            }
        }

    }

    private void initGameBoard() {
        for (int i = 0; i < gameBoardArr.length; i++) {
            for (int j = 0; j < gameBoardArr.length; j++) {
                gameBoardArr[i][j] = "0";
            }
        }
    }

    private void buildGameBoard() {
        for (int i = 0; i < gameBoardArr.length; i++) {
            for (int j = 0; j < gameBoardArr.length; j++) {
                if (i == row && j == col) {
                    if (!gameBoardArr[i][j].equals("0")) {
                        System.out.println("Нельзя ставить на чужое место, давай еще раз");
                        canGo = false;
                        return;
                    }
                    if (isX) {
                        gameBoardArr[i][j] = "X";
                        isX = false;
                        canGo = true;

                    } else {
                        gameBoardArr[i][j] = "O";
                        isX = true;
                        canGo = true;

                    }
                }
            }
        }
        for (int i = 0; i < gameBoardArr.length; i++) {
            for (int j = 0; j < gameBoardArr.length; j++) {

                System.out.print(gameBoardArr[i][j] + "\t");

                if (j < gameBoardArr.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();

            if (i < gameBoardArr.length - 1) {
                System.out.println("___________");
            }
        }
    }

    private boolean winCheckerX() {
        boolean winX = false;

        for (int i = 0; i < 3; i++) {
            if (gameBoardArr[i][0].equals("X") && gameBoardArr[i][1].equals("X") && gameBoardArr[i][2].equals("X")) {
                winX = true;
                break;

            } else if (gameBoardArr[i][0].equals("X") && gameBoardArr[i][1].equals("X") && gameBoardArr[i][2].equals("X")) {
                winX = true;
                break;

            } else if (gameBoardArr[0][i].equals("X") && gameBoardArr[1][i].equals("X") && gameBoardArr[2][i].equals("X")) {
                winX = true;
                break;

            } else if (gameBoardArr[0][0].equals("X") && gameBoardArr[1][1].equals("X") && gameBoardArr[2][2].equals("X")) {
                winX = true;
                break;

            }else if(gameBoardArr[0][2].equals("X") && gameBoardArr[1][1].equals("X") && gameBoardArr[2][0].equals("X")){
                winX = true;
                break;
            }

        }

        return winX;

    }

    private boolean winCheckerO() {
        boolean winO = false;

        for (int i = 0; i < gameBoardArr.length; i++) {
            if (gameBoardArr[i][0].equals("O") && gameBoardArr[i][1].equals("O") && gameBoardArr[i][2].equals("O")) {
                winO = true;
                break;

            } else if (gameBoardArr[i][0].equals("O") && gameBoardArr[i][1].equals("O") && gameBoardArr[i][2].equals("O")) {
                winO = true;
                break;

            } else if (gameBoardArr[0][i].equals("O") && gameBoardArr[1][i].equals("O") && gameBoardArr[2][i].equals("O")) {
                winO = true;
                break;

            } else if (gameBoardArr[0][0].equals("O") && gameBoardArr[1][1].equals("O") && gameBoardArr[2][2].equals("O")) {
                winO = true;
                break;

            }else if(gameBoardArr[0][2].equals("O") && gameBoardArr[1][1].equals("O") && gameBoardArr[2][0].equals("O")){
                winO = true;
                break;
            }

        }

        return winO;
    }

    private boolean drawChecker() {
        int draw = 0;
        boolean isDraw;

        for (int i = 0; i < gameBoardArr.length; i++) {
            for (int j = 0; j < gameBoardArr.length; j++) {
                if (!gameBoardArr[i][j].equals("0")){
                    draw++;
                }
            }
        }
        if (draw == 9){
            isDraw = true;
        }
        else{
            isDraw = false;
        }
        return isDraw;
    }
}


