package com.company;

public class Player {
    String name;
    String symbol;
    int money;
    int positionOnRoad;
    boolean inPrison;
    int termPrison ;
    //##################################################################################################################################################
    Player(String name, String symbol){
        this.name=name;
        this.symbol=symbol;
        money=1500;
        positionOnRoad=0;
    }
}
