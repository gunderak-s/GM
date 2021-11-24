package com.company;

import java.io.Serializable;

public class CompanyCell extends Cell implements  CONSTANTS{
    //##################################################################################################################################################
    int rotation;   // 0-знизу, 1-зліва, 2-згори, 3-справа
    int statusRenta;
    final int[] rentaMas;
    Player holder;
    Cell helpful;
    CompanyCell[] company;
    //##################################################################################################################################################
    public CompanyCell(String[][] cellsMatrix, int rotation,  int statusRenta, Cell helpful, Player holder, CompanyCell[] company, int... rentaMas) {
        this.cellsMatrix=cellsMatrix;
        this.rotation = rotation;
        this.statusRenta = statusRenta;
        this.helpful = helpful;
        this.holder = holder;
        this.company=company;
        this.rentaMas = rentaMas;
        drawTextIntoCell(String.valueOf(rentaMas[0]), 3, false);

    }
    //##################################################################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //##################################################################################################################################################
    void playerIntoCell(Player player){
        if (statusRenta!=0) {
            player.money-= rentaMas[statusRenta];
            holder.money+= rentaMas[statusRenta];
        }
        redrawSymbolPlayer(" ",player.symbol);
    }
    //###############################################  МІША  ###################################################################################################
    void purchase(Player player, int numberCell){
    }
    //#################################################################################################################################################
    void  setHolder(Player holder){
        this.holder=holder;
        holder.ownership.add(this);
        switch (rotation) {
            case 1:
                cellsMatrix[3][2] = holder.symbol;
                break;
            case 2:
                cellsMatrix[2][3] = holder.symbol;
                break;
        }
    }
    //##################################################################################################################################################
    void drawTextIntoCell(String text,int row, boolean helpful){
        Cell cell;
        if (helpful)
            cell=this.helpful;
        else
            cell = this;
        if (text.length()<4)
            for (int i=0; i<CONSTANTS.SIZE_CELLS-text.length(); i++)
                text = text + " ";
        String[] textInMas = text.split("");
        switch (rotation) {
            case 0:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[row][i] = textInMas[i];
                break;
            case 1:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[i][SIZE_CELLS-1-row] = textInMas[i];
                break;
            case 2:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[SIZE_CELLS-1-row][i] = textInMas[i];
                break;
            case 3:
                for (int i=0; (i<CONSTANTS.SIZE_CELLS)&(i<text.length()); i++)
                    cell.cellsMatrix[i][row] = textInMas[i];
                break;
        }
    }
    //###############################################  ВОВА  ###################################################################################################
    float getPrice(){
        return  0;
    }
    //##################################################################################################################################################
    public void printRow(int row) {
                System.out.print(cellsMatrix[row][0] + cellsMatrix[row][1] + cellsMatrix[row][2] + cellsMatrix[row][3]);
    }
    //##############################################  АНДРІЙ  ####################################################################################################
    public void printInfo() {

    }
}

