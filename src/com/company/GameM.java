package com.company;

public class GameM {
    CellsGame[][] fildGame;
    CellsGame[] roadGame;
    final static int LENGTHGAME=11;

    GameM(){
        fildGame=new CellsGame[LENGTHGAME][LENGTHGAME];
        fildGame[0][0]=new StreetCellsGame();
        fildGame[0][0].cellsMatrix= new char[][]{{' ', ' ', ' ', ' '},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', ' ', ' ', ' '},
        };


    }

    void Print(){
        for (int rowCells = 1; rowCells <LENGTHGAME; rowCells++)
            for (int i=1;i<CellsGame.LENGTHCELLS;i++){
                for (int j=1;j<LENGTHGAME;j++)
                    System.out.print(fildGame[rowCells][j].cellsMatrix[i][0] + "" + fildGame[rowCells][j].cellsMatrix[i][1] + "" + fildGame[rowCells][j].cellsMatrix[i][2] + "" + fildGame[rowCells][j].cellsMatrix[i][3]);
                System.out.println();
                }
    }
}
