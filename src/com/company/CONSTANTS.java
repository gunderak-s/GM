package com.company;

public interface CONSTANTS {
    //---------------------------------------------------Костанти кольорів-------------------------------------------------------
    // темніші рядків
    String BLACK_BACKGROUND = "\u001B[40m";
    String RED_BACKGROUND = "\u001B[41m";
    String GREEN_BACKGROUND = "\u001B[42m";
    String YELLOW_BACKGROUND = "\u001B[43m";
    String BLUE_BACKGROUND = "\u001B[44m";
    String PURPLE_BACKGROUND = "\u001B[45m";
    String CYAN_BACKGROUND = "\u001B[46m";
    String WHITE_BACKGROUND = "\u001B[47m";
    // світліші рядків
    String GRAY_BACKGROUND = "\u001B[100m";
    String BRIGHT_RED_BACKGROUND = "\u001B[101m";
    String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
    String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";
    //---------------------------------------------------Костанти символів-------------------------------------------------------
    String HOUSE = Character.toString(0x2302); // домик
    String SHIP ="\uD83D\uDEA2";/*🚢*/
    String LIGHT="\uD83D\uDCA1";/*💡*/
    String SHOWER="\uD83D\uDEBF";/*🚿*/
    //---------------------------------------------------Костанти розмірів-------------------------------------------------------
    int SIZE_GAME = 11;
    int SIZE_CELLS =4;
}
