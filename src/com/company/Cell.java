package com.company;

public class Cell {
    char[][] cellsMatrix;
    final static int SIZE_CELLS =4;
    //##################################################################################################################################################
    void print(int row){
        System.out.print(CityCell.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
    //##################################################################################################################################################
    void action(Player player){

    }
    //##################################################################################################################################################
    void redrawSymbol(char prevChar,char newChar){

    }
}
