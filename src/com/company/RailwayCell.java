package com.company;

public class RailwayCell extends Cell{
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    Player holder;
    int statusRenta;
    int[] rentaMas;
    //##################################################################################################################################################
    RailwayCell(){

    }
    //##################################################################################################################################################
    void action(Player player){
        if (holder!=null) {
            holder.money = holder.money + rentaMas[statusRenta];
            player.money=player.money-rentaMas[statusRenta];
            System.out.println(holder.name+" оплата ренти: +"+rentaMas[statusRenta]);
            System.out.println(player.name+" оплата ренти: -"+rentaMas[statusRenta]);
        }
        redrawSymbolPlayer(' ',player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(char prevChar, char newChar){

    }
    //##################################################################################################################################################
    void  redrawStatus(char holderChar){

    }
    //##################################################################################################################################################
    void printMatrix(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
