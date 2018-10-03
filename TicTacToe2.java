package com.company;

import java.util.Scanner;

public class TicTacToe2 {
    String[][] gameBoard = new String[3][3]; // тут вообще всё серое, но не понятно почему(((

    Scanner inputScan = new Scanner(System.in);

    String playerX = "X", playerO = "O", currentPlayer = playerX;

    int row, col;


    TicTacToe2(){
        initGameBoard();
        outer:
        while (true){           // Переделать вайл тру. Сделать функцию, котороя проверяет победу и возвращает буливун. Пихать сюда его
            System.out.println();//чоб хоть что-то в этом коде было красиво

            if (currentPlayer.equals(playerX)){
                System.out.println("Ходят крестики");
            }
            else{
                System.out.println("Ходят нолики");
            }
            System.out.println("Введите колонку");
            col = inputScan.nextInt(); // сделать проверку на то, чтоб число было от 0 до 2, иначе ошибки всякие вылазят

            System.out.println("Введите строку");
            row = inputScan.nextInt();
            if (gameBoard[col][row].equals("X") || gameBoard[col][row].equals("O")) {
                System.out.println("u cant");// это неработающая проверка на предмет того, что на этом месте уже что-то лежит. Починить или доломать
                    break outer;
            }else{
                buildGameBoard();
            }


            currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX; // Смена игрока происходит раз в итерацию
        }



    }




    public void initGameBoard(){
        for(int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                gameBoard[col][row] = "0";
            }
        }
    }

    public void buildGameBoard(){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                    if (j == col && i == row){
                        if (currentPlayer.equals(playerX)){
                            gameBoard[i][j] = "X";
                        }
                        else{
                            gameBoard[i][j] = "O";
                        }

                    }

                System.out.print(gameBoard[i][j] + "\t");

                if (j < 2){
                    System.out.print("|");
                }

                }
            System.out.println();
            if (i<2){
                System.out.println("___________");
            }


        }
    }
}


