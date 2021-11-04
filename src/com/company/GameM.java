package com.company;

import java.util.ArrayList;

public class GameM {
    Cell[][] fildGame;
    Cell[] roadGame;
    final static int SIZE_GAME = 11;
    final static char HOUSE = 8962;
    ArrayList<Player> players;



    GameM(){
    }

    void game(){
        setFild();
        setPlayers();
        int turn=0;
        int cube1=1;
        int cube2=1;
        while (players.size()>1){

            cube1=(int)(Math.random()*6)+1;
            cube2=(int)(Math.random()*6)+1;

            players.get(turn).setPositionOnRoad(cube1+cube2);
            roadGame[players.get(turn).positionOnRoad].move(players.get(turn));

            turn++;
            if (turn>players.size()-1)
                turn=0;
        }

    }

    void  setPlayers(){
    }


    public void setFild() {
        fildGame=new Cell[SIZE_GAME][SIZE_GAME];
        for (int i = 0; i <= 10; i++)
            for (int j = 0; j <= 10; j++) {

        fildGame[0][0] = new CityCell();
        fildGame[0][0].cellsMatrix = new char[][]{{' ', ' ', ' ', ' '},
                                                  {' ', ' ', ' ', ' '},
                                                  {' ', ' ', ' ', ' '},
                                                  {' ', ' ', ' ', ' '}
        };

                fildGame[i][j] = new Cell();
                fildGame[i][j].cellsMatrix=new char[][]{{' ', ' ', ' ', ' '},
                                                        {' ', ' ', ' ', ' '},
                                                        {' ', ' ', ' ', ' '},
                                                        {' ', ' ', ' ', ' '}
                };
            }
        fildGame[0][1] = new CityCell(2, CityCell.RED_BACKGROUND,0, 150, 150, 220, null);
        fildGame[0][1].cellsMatrix=new char[][]{{' ', '2', '2', '0'},
                                                {' ', ' ', ' ', ' '},
                                                {'В', 'е', 'н', 'е'},
                                                {' ', ' ', ' ', ' '}};

        fildGame[0][3]=new CityCell(2,CityCell.RED_BACKGROUND,0, 150, 150, 220, null);
        fildGame[0][3].cellsMatrix=new char[][]{{' ', '2', '2', '0'},
                                                {' ', ' ', ' ', ' '},
                                                {'М', 'і', 'л', 'а'},
                                                {' ', ' ', ' ', ' '}};

        fildGame[0][4]=new CityCell(2, CityCell.RED_BACKGROUND, 0, 150, 150, 240, null);
        fildGame[0][4].cellsMatrix=new char[][]{{' ', '2', '4', '0'},
                                                {' ', ' ', ' ', ' '},
                                                {'Б', 'а', 'р', 'і'},
                                                {' ', ' ', ' ', ' '}};

        fildGame[0][6]=new CityCell(2, CityCell.PURPLE_BACKGROUND,0, 150, 150, 260, null);
        fildGame[0][6].cellsMatrix=new char[][]{{' ', '2', '6', '0'},
                                                {' ', ' ', ' ', ' '},
                                                {'А', 'м', 'с', 'т'},
                                                {' ', ' ', ' ', ' '}};

        fildGame[0][7]=new CityCell(2, CityCell.PURPLE_BACKGROUND,0, 150, 150, 260, null);
        fildGame[0][7].cellsMatrix=new char[][]{{' ', '2', '6', '0'},
                                                {' ', ' ', ' ', ' '},
                                                {'Г', 'о', 'р', 'н'},
                                                {' ', ' ', ' ', ' '}};

        fildGame[0][9] = new CityCell(2,CityCell.PURPLE_BACKGROUND,0, 150, 150, 280, null);
        fildGame[0][9].cellsMatrix=new char[][]{{' ', '2', '8', '0'},
                                                {' ', ' ', ' ', ' '},
                                                {'Л', 'і', 'с', 'е'},
                                                {' ', ' ', ' ', ' '}};

        fildGame[1][10] = new CityCell(3,CityCell.BLUE_BACKGROUND,0, 200, 200, 300, null);
        fildGame[1][10].cellsMatrix=new char[][]{{' ', 'К', ' ', ' '},
                                                 {' ', 'р', ' ', '3'},
                                                 {' ', 'і', ' ', '0'},
                                                 {' ', 'с', ' ', '0'}};

        fildGame[2][10] = new CityCell(3,CityCell.BLUE_BACKGROUND,0, 200, 200, 300, null);
        fildGame[2][10].cellsMatrix=new char[][]{{' ', 'Ш', ' ', ' '},
                                                 {' ', 'і', ' ', '3'},
                                                 {' ', 'є', ' ', '0'},
                                                 {' ', 'н', ' ', '0'}};

        fildGame[4][10] = new CityCell(3,CityCell.BLUE_BACKGROUND,0, 200, 200, 320, null);
        fildGame[4][10].cellsMatrix=new char[][]{{' ', 'О', ' ', ' '},
                                                 {' ', 'с', ' ', '3'},
                                                 {' ', 'л', ' ', '2'},
                                                 {' ', 'о', ' ', '0'}};

        fildGame[7][10] = new CityCell(3,CityCell.CYAN_BACKGROUND,0, 200, 200, 350, null);
        fildGame[7][10].cellsMatrix=new char[][]{{' ', 'Л', ' ', ' '},
                                                 {' ', 'ь', ' ', '3'},
                                                 {' ', 'в', ' ', '5'},
                                                 {' ', 'і', ' ', '0'}};

        fildGame[9][10] = new CityCell(3,CityCell.CYAN_BACKGROUND,0, 200, 200, 400, null);
        fildGame[9][10].cellsMatrix=new char[][]{{' ', 'К', ' ', ' '},
                                                 {' ', 'и', ' ', '4'},
                                                 {' ', 'ї', ' ', '0'},
                                                 {' ', 'в', ' ', '0'}};

        fildGame[1][0] = new CityCell(1,CityCell.GREEN_BACKGROUND,0, 100, 100, 200, null);
        fildGame[1][0].cellsMatrix=new char[][]{{' ', ' ', 'П', ' '},
                                                {'2', ' ', 'р', ' '},
                                                {'0', ' ', 'а', ' '},
                                                {'0', ' ', 'г', ' '}};

        fildGame[2][0] = new CityCell(1,CityCell.GREEN_BACKGROUND,0, 100, 100, 180, null);
        fildGame[2][0].cellsMatrix=new char[][]{{' ', ' ', 'З', ' '},
                                                {'1', ' ', 'л', ' '},
                                                {'8', ' ', 'і', ' '},
                                                {'0', ' ', 'н', ' '}};


        fildGame[4][0] = new CityCell(1,CityCell.GREEN_BACKGROUND,0, 100, 100, 180, null);
        fildGame[4][0].cellsMatrix=new char[][]{{' ', ' ', 'Б', ' '},
                                                {'1', ' ', 'р', ' '},
                                                {'8', ' ', 'н', ' '},
                                                {'0', ' ', 'о', ' '}};


        fildGame[6][0] = new CityCell(1,CityCell.GREEN_BACKGROUND,0, 100, 100, 160, null);
        fildGame[6][0].cellsMatrix=new char[][]{{' ', ' ', 'К', ' '},
                                                {'1', ' ', 'а', ' '},
                                                {'6', ' ', 'т', ' '},
                                                {'0', ' ', 'о', ' '}};

        fildGame[7][0] = new CityCell(1,CityCell.GREEN_BACKGROUND,0, 100, 100, 140, null);
        fildGame[7][0].cellsMatrix=new char[][]{{' ', ' ', 'О', ' '},
                                                {'1', ' ', 'п', ' '},
                                                {'4', ' ', 'о', ' '},
                                                {'0', ' ', 'л', ' '}};


        fildGame[9][0] = new CityCell(1,CityCell.GREEN_BACKGROUND,0, 100, 100, 140, null);
        fildGame[9][0].cellsMatrix=new char[][]{{' ', ' ', 'В', ' '},
                                                {'1', ' ', 'р', ' '},
                                                {'4', ' ', 'о', ' '},
                                                {'0', ' ', 'ц', ' '}};

        fildGame[10][1] = new CityCell(0,CityCell.YELLOW_BACKGROUND,0, 50, 50, 120, null);
        fildGame[10][1].cellsMatrix=new char[][]{{' ', ' ', ' ', ' '},
                                                 {'Н', 'а', 'н', 'т'},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', '1', '2', '0'}};

        fildGame[10][2] = new CityCell(0,CityCell.YELLOW_BACKGROUND,0, 50, 50, 100, null);
        fildGame[10][2].cellsMatrix=new char[][]{{' ', ' ', ' ', ' '},
                                                 {'П', 'а', 'р', 'ж'},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', '1', '0', '0'}};

        fildGame[10][4] = new CityCell(0,CityCell.YELLOW_BACKGROUND,0, 50, 50, 100, null);
        fildGame[10][4].cellsMatrix=new char[][]{{' ', ' ', ' ', ' '},
                                                 {'Л', 'і', 'о', 'н'},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', '1', '0', '0'}};

        fildGame[10][7] = new CityCell(0,CityCell.YELLOW_BACKGROUND,0, 50, 50, 60, null);
        fildGame[10][7].cellsMatrix=new char[][]{{' ', ' ', ' ', ' '},
                                                 {'М', 'а', 'н', 'ч'},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', ' ', '6', '0'}};

        fildGame[10][9] = new CityCell(0,CityCell.YELLOW_BACKGROUND,0, 50, 50, 60, null);
        fildGame[10][9].cellsMatrix=new char[][]{{' ', ' ', ' ', ' '},
                                                 {'Л', 'о', 'н', 'д'},
                                                 {' ', ' ', ' ', ' '},
                                                 {' ', ' ', '6', '0'}};
    }



    void Print(){
        for (int rowCells = 0; rowCells < SIZE_GAME; rowCells++)
            for (int i = 0; i< Cell.SIZE_CELLS; i++){
                for (int j = 0; j< SIZE_GAME; j++)
                    fildGame[rowCells][j].print(i);
                System.out.println();
                }
    }
}
