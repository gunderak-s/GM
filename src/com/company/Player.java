package com.company;

public class Player {
    String name;
    char symbol;
    int money;
    int positionOnRoad;
    boolean inPrison;
    int termPrison ;
    //##################################################################################################################################################
    Player(String name, char symbol){
        this.name=name;
        this.symbol=symbol;
        money=1500;
        positionOnRoad=0;
    }
}
