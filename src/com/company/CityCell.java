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
    //##################################################################################################################################################
    CityCell(String name, int rotation,  String color, int statusRenta, int priceHouse , int priceHotel, Player holder,Cell helpful, int ... rentaMas) {
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

    }
    //##################################################################################################################################################
    void action(Player player){
        if (statusRenta!=0){
            player.money =player.money -rentaMas[statusRenta];

        }
        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String prevChar,String newChar){

    }
    //##################################################################################################################################################
    void  resetStatus(Player holder){

        //--------------------------------------------------Запис власника-------------------------------------------------------------------------------

        //--------------------------------------------------Запис ренти-------------------------------------------------------------------------------
        int price =rentaMas[statusRenta];
        String s=String.valueOf(price);
        String[] masS=s.split("");
        //int lengthMas=masC.length;

        //masC[0]=2
        //masC[1]=8
        //masC[2]=0
    }
    //##################################################################################################################################################
    void  resetStatus(){

        //--------------------------------------------------Запис власника-------------------------------------------------------------------------------

        //--------------------------------------------------Зміна ренти-------------------------------------------------------------------------------
        int price =rentaMas[statusRenta];
        String s=String.valueOf(price);
        String[] masS=s.split("");
        //int lengthMas=masC.length;

        //masC[0]=2
        //masC[1]=8
        //masC[2]=0
    }
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
