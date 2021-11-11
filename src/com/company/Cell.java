package com.company;

public class Cell {
    int rotation;
    String[][] cellsMatrix;
    final static int SIZE_CELLS = 4;

    //##################################################################################################################################################
    Cell() {
        cellsMatrix = new String[][]{
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "}
        };
    }

    //##################################################################################################################################################
    void action(Player player) {

    }

    //##################################################################################################################################################
    void redrawSymbolPlayer(String oldChar, String newChar) {
        //0-знизу, 1-зліва, 2-згори, 3-справа
        switch (rotation) {
            case 2:
            for (int i = 0; i < cellsMatrix.length; i++) {
                if (cellsMatrix[2][i] == oldChar) cellsMatrix[2][i] = newChar;
            }break;
            case 3:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[i][1] == oldChar) cellsMatrix[i][1] = newChar;
                }break;
            case 0:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[1][i] == oldChar) cellsMatrix[1][i] = newChar;
                }break;
            case 1:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[i][2] == oldChar) cellsMatrix[i][2] = newChar;
                }break;

        }

    }

    //##################################################################################################################################################
    void redrawStatus(char holderChar) {

    }

    //##################################################################################################################################################
    void printInfo() {
    }

    //##################################################################################################################################################
    void printMatrix(int row) {
        System.out.print(GameM.WHITE_BACKGROUND + cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
    }
}
