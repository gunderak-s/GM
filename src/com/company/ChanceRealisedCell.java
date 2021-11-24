package com.company;

import java.util.ArrayList;
import java.util.Random;

public class ChanceRealisedCell extends Cell {
    private int count;
    private CardActivity[] chance;
    private ArrayList<Integer> random=new ArrayList();

    public ChanceRealisedCell(CardActivity[] chance) {
        this.chance = chance;
        count=0;
       random.add(new Random().nextInt(13)+1);
       while (random.size()!=13){
           int a=new Random().nextInt(13)+1;
           if (random.stream().allMatch(integer -> integer !=a)){
               random.add(a);}
       }
    }
    public void action(Player player){
        redrawSymbolPlayer(" ",player.symbol);
        chance[random.get(count)].chance(player);
        count++;
        if (count==13)count=0;
    }
}
