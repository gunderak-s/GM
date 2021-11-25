package com.company;


public class PoliceCell extends Cell{
    //#####################################################  ОЛЕНА  #############################################################################################
    String[][] cellMatrix;
    PrisonCell prison;
    //#####################################################  ОЛЕНА  #############################################################################################
    public PoliceCell(PrisonCell prison, String[][] cellMatrix) {
     this.cellMatrix = cellMatrix;
     this.prison=prison ;

    }
    //##################################################################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //#####################################################  МІША  #############################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar){
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                if (cellsMatrix[i][j].equals(prevChar)) {
                    cellsMatrix[i][j] = newChar;
                    return;
                }
    }
    //#####################################################  ОЛЕНА  #############################################################################################
    public void playerIntoCell(Player player){
        prison.arest(player);
    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
