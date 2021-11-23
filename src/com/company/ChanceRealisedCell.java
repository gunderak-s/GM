package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ChanceRealisedCell extends Cell implements CONSTANTS{
    //##################################################################################################################################################
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
    //##################################################################################################################################################
    boolean playerFromCell(Player player){
        redrawSymbolPlayer(player.symbol," ");
        return true;
    }
    //##################################################################################################################################################
    public void playerIntoCell(Player player){
        redrawSymbolPlayer(" ",player.symbol);
        chance[random.get(count)].chance(player);
        count++;
        if (count==13)count=0;
    }
    //##################################################################################################################################################
    public void printRow(int row){
        System.out.print(GameM.WHITE_BACKGROUND+cellsMatrix[row][0]+cellsMatrix[row][1]+cellsMatrix[row][2]+cellsMatrix[row][3]);
    }
}
