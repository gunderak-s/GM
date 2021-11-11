package com.company;

import java.io.Serializable;

public class Cell implements Serializable {
    String[][] cellsMatrix;
    final static int SIZE_CELLS =4;
    //##################################################################################################################################################
    Cell(){
        cellsMatrix = new String[][]{{" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "},
                {" ", " ", " ", " "}
        };
    }
    //##################################################################################################################################################
    void action(Player player){
        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar){
                for (int i=0;i<4;i++)
                    for (int j=0;j<4;j++)
                    if (cellsMatrix[i][j]==prevChar) {
                        cellsMatrix[i][j] = newChar;
                        return;
                    }
    }
    //##################################################################################################################################################
    void  redrawStatus(char holderChar){

    }
    //##################################################################################################################################################
    void printInfo(){
    }
    //##################################################################################################################################################
    void printMatrix(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
