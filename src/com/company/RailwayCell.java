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
        redrawSymbolPlayer(" ",player.symbol);
    }
    //##################################################################################################################################################
    void redrawSymbolPlayer(String oldChar, String newChar){
        /*0-знизу, 1-зліва, 2-згори, 3-справа*/
        switch (rotation){
            case 2:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[2][i] == oldChar) {
                        cellsMatrix[2][i] = newChar;
                    break;}
                    break; }
            case 3:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[i][1]==oldChar) {
                        cellsMatrix[i][1]=newChar;
                    return;}
                break;}
            case 0:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[1][i]==oldChar) {
                        cellsMatrix[1][i]=newChar;
                    return;}
                break;}
            case 1:
                for (int i = 0; i <cellsMatrix.length ; i++) {
                    if (cellsMatrix[i][2]==oldChar) {
                        cellsMatrix[i][2]=newChar;
                    return;}
                break;}
        }
    }
    //##################################################################################################################################################
    void resetStatus(){

    }
    //##################################################################################################################################################
    void printMatrix(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
