package com.company;

public class CompanyCell extends Cell {

    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    int statusRenta;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    CompanyCell[] com;

    public CompanyCell(int rotation,  int statusRenta,  Cell helpful, Player holder,CompanyCell[] com, int... rentaMas) {
        this.rotation = rotation;
        this.statusRenta = statusRenta;
        this.holder = holder;
        this.helpful = helpful;
        this.com = com;
        this.rentaMas = rentaMas;
    }

    void action(Player player) {
        if (statusRenta != 0) {
            player.money = player.money - rentaMas[statusRenta];

        }

    }
    //##################################################################################################################################################

    void redrawSymbolPlayer(String oldChar, String newChar) {
        /*0-знизу, 1-зліва, 2-згори, 3-справа*/
        switch (rotation) {
            case 2:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[2][i] == oldChar) {
                        cellsMatrix[2][i] = newChar;
                        return;
                    }
                    break;
                }
            case 3:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[i][1] == oldChar) {
                        cellsMatrix[i][1] = newChar;
                        return;
                    }
                    break;
                }
            case 0:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[1][i] == oldChar) {
                        cellsMatrix[1][i] = newChar;
                        return;
                    }
                    break;
                }
            case 1:
                for (int i = 0; i < cellsMatrix.length; i++) {
                    if (cellsMatrix[i][2] == oldChar) {
                        cellsMatrix[i][2] = newChar;
                        return;
                    }
                    break;
                }
        }
    }


    //##################################################################################################################################################
    void resetStatus() {
        //--------------------------------------------------Зміна ренти і запис нової в матрицю-------------------------------------------------------------------
        /*не розумію що тут має робитись*/
        /*int price =rentaMas[statusRenta];
        String s=String.valueOf(price);
        char[] masC=s.toCharArray();
        int lengthMas=masC.length;*/

        //masC[0]=2
        //masC[1]=8
        //masC[2]=0
    }

    //##################################################################################################################################################
    void printMatrix(int row) {
        switch (rotation) {

            case 1:
                System.out.print(cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + symbol + cellsMatrix[row][3]);
                break;

            case 3:
                System.out.print(symbol + cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
                break;
        }
    }
}

