package com.company;

public class GameM {
    CellGame[][] fildGame;
    CellGame[] roadGame;
    final static int SIZE_GAME =11;
    final static char HOUSE=8962;
    Player[] players;



    GameM(){
        fildGame=new CellGame[SIZE_GAME][SIZE_GAME];
        fildGame[0][3]=new CityCellGame();
        fildGame[0][3].cellsMatrix= new char[][]{{' ', '1', '2', '0'},
                                                 {' ', ' ', ' ', ' '},
                                                 {'Л', 'Ь', 'В', 'І'},
                                                 {' ', ' ', ' ', ' '},
        };

        fildGame[0][0]=new CellGame();
        fildGame[0][0].cellsMatrix= new char[][]{{' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' '},
        };
    }

    void game(){

    }

    void Print(){
        for (int rowCells = 1; rowCells < SIZE_GAME; rowCells++)
            for (int i = 1; i< CellGame.SIZE_CELLS; i++){
                for (int j = 1; j< SIZE_GAME; j++)
                    fildGame[rowCells][j].print();
                System.out.println();
                }
    }
}
