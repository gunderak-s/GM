package com.company;

public class GameM {
    CellGame[][] fildGame;
    CellGame[] roadGame;
    final static int SIZE_GAME =11;

    GameM(){
        fildGame=new CellGame[SIZE_GAME][SIZE_GAME];
        fildGame[0][0]=new StreetCellGame();
        fildGame[0][0].cellsMatrix= new char[][]{{' ', ' ', ' ', ' '},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', ' ', ' ', ' '},
        };


    }

    void Print(){
        for (int rowCells = 1; rowCells < SIZE_GAME; rowCells++)
            for (int i = 1; i< CellGame.SIZE_CELLS; i++){
                for (int j = 1; j< SIZE_GAME; j++)
                    System.out.print(fildGame[rowCells][j].cellsMatrix[i][0] + "" + fildGame[rowCells][j].cellsMatrix[i][1] + "" + fildGame[rowCells][j].cellsMatrix[i][2] + "" + fildGame[rowCells][j].cellsMatrix[i][3]);
                System.out.println();
                }
    }
}
