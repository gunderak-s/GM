package com.company;

public class CityCellGame extends CellGame {
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    String color;
    int priceCells;
    int statusRenta;
    int priceHouse;
    int priceHotel;
    int[] rentaMas;
    Player holder;

    void print(int row){
        switch (rotation) {
            case 0:
                switch (row) {
                    case 0:
                        System.out.print(color+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
                        break;
                    case 1:
                }
            case 1:

            case 2:
        }
    }
}
