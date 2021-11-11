package com.company;

public class CityCell extends Cell {
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    String color;
    int statusRenta;
    int priceHouse;
    int priceHotel;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    String name;
    //##################################################################################################################################################
    CityCell(String name, int rotation,  String color, int statusRenta, int priceHouse , int priceHotel, Player holder,Cell helpful, int ... rentaMas) {
        this.name=name;
        this.rotation=rotation;
        this.color=color;
        this.statusRenta=statusRenta;
        this.priceHouse=priceHouse;
        this.priceHotel=priceHotel;
        this.holder=holder;
        this.helpful=helpful;
        this.rentaMas=rentaMas;
        //---------------------------------------------------Записати статус, просто викликавши redrawStatus()-------------------------------------------------------

        //---------------------------------------------------Записати назву, аналогічно як в redrawStatus()-------------------------------------------------------
        String name= String.valueOf(name);
        String[] n=name.split("");
          switch (rotation) {
              case 0:
                  for (int i=0; i<=3; i++)
                System.out.print(n+cellsMatrix[i][0]+cellsMatrix[i][1]+cellsMatrix[i][2]+cellsMatrix[i][3]);
                  break;
              case 1:
                  for (int j=0; j<=3; j++)
                      System.out.print(n+cellsMatrix[0][j]+cellsMatrix[1][j]+cellsMatrix[2][j]+cellsMatrix[3][j]);
                  break;
              case 2:
                  for (int i=0; i<=3; i++)
                      System.out.print(n+cellsMatrix[i][0]+cellsMatrix[i][1]+cellsMatrix[i][2]+cellsMatrix[i][3]);

              case 3:
                  for (int j=0; j<=3; j++)
                      System.out.print(n+cellsMatrix[0][j]+cellsMatrix[1][j]+cellsMatrix[2][j]+cellsMatrix[3][j]);
                  break;

          }


    }
    //##################################################################################################################################################
    void action(Player player){
        if (statusRenta!=0){
            player.money =player.money -rentaMas[statusRenta];

        }

    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String oldChar, String newChar){

    }
    //##################################################################################################################################################
    void  redrawStatus(char holderChar) {
        //--------------------------------------------------Запис власника-------------------------------------------------------------------------------

        //--------------------------------------------------Зміна ренти-------------------------------------------------------------------------------
        int price = rentaMas[statusRenta];
        String s = String.valueOf(price);
        char[] masC = s.toCharArray();
        switch (rotation) {
            case 0:
                switch (row) {
                    case 0:
                        for (int i = 0; i <= 3; i++)
                            System.out.print(masC + cellsMatrix[i][0] + cellsMatrix[i][1] + cellsMatrix[i][2] + cellsMatrix[i][3]);
                }
                break;
            case 1:
                for (int j=0; j<=3; j++)
                    System.out.print(masC+cellsMatrix[0][j]+cellsMatrix[1][j]+cellsMatrix[2][j]+cellsMatrix[3][j]);
                break;

            case 2:
                switch (row) {
                    case 2:
                        for (int i = 0; i <= 3; i++)
                            System.out.print(masC + cellsMatrix[i][0] + cellsMatrix[i][1] + cellsMatrix[i][2] + cellsMatrix[i][3]);
                }
                break;
            case 3:
                    case 3:
                        for (int j = 0; j <= 3; j++)
                            System.out.print(masC + cellsMatrix[0][j] + cellsMatrix[1][j] + cellsMatrix[2][j] + cellsMatrix[3][j]);
                        break;
                break;

        }


    }
        //masC[0]=2
        //masC[1]=8
        //masC[2]=0

    //##################################################################################################################################################
    void printInfo(){

    }
    //##################################################################################################################################################
    void printMatrix(int row){
        switch (rotation) {
            case 0:
                switch (row) {
                    case 0:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                        break;
                    default:
                        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                }
            break;
            case 1:
                System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+color+cellsMatrix[row][3]);
            break;

            case 2:
                switch (row) {
                    case 3:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                    break;
                    default:
                        System.out.print(GameM.WHITE_BACKGROUND + cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
                }
            break;
            case 3:
                System.out.print(color + cellsMatrix[row][0] +GameM.WHITE_BACKGROUND+ cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
            break;
        }
    }
}
