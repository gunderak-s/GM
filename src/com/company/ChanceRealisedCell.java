package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ChanceRealisedCell extends Cell{
    //#####################################################  ВОВА  #############################################################################################
    private int count;
    private Chance[] chance;
    private ArrayList<Integer> random=new ArrayList();
    //#####################################################  ВОВА  #############################################################################################
    public ChanceRealisedCell(Chance []chance) {
        this.chance = chance;
        count=0;
       random.add(new Random().nextInt(13)+1);
       while (random.size()!=13){
           int a=new Random().nextInt(13)+1;
           if (random.stream().allMatch(integer -> integer !=a)){
               random.add(a);}
       }
    }
    //#####################################################  ВОВА  #############################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //#####################################################  ВОВА  #############################################################################################
    public void playerIntoCell(Player player){
        redrawSymbolPlayer(" ",player.symbol);
        chance[random.get(count)].chance(player);
        count++;
        if (count==13)count=0;
    }
    //#####################################################  ВОВА  #############################################################################################
    void redrawSymbolPlayer(String prevChar, String newChar){
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                if (cellsMatrix[i][j].equals(prevChar)) {
                    cellsMatrix[i][j] = newChar;
                    return;
                }
    }
    //#####################################################  ОЛЕНА  #############################################################################################
    void drawTextIntoCell(String text,int row, boolean helpful){

    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
