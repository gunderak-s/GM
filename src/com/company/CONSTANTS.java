package com.company;

public interface CONSTANTS {
    //###################################################  АНДРІЙ  ###############################################################################################
    //---------------------------------------------------Костанти кольорів фону-------------------------------------------------------
    // темніші
    String BLACK_BACKGROUND = "\u001B[40m";
    String RED_BACKGROUND = "\u001B[41m";
    String GREEN_BACKGROUND = "\u001B[42m";
    String YELLOW_BACKGROUND = "\u001B[43m";
    String BLUE_BACKGROUND = "\u001B[44m";
    String PURPLE_BACKGROUND = "\u001B[45m";
    String CYAN_BACKGROUND = "\u001B[46m";
    String WHITE_BACKGROUND = "\u001B[47m";
    // світліші
    String GRAY_BACKGROUND = "\u001B[100m";
    String BRIGHT_RED_BACKGROUND = "\u001B[101m";
    String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
    String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";
    //---------------------------------------------------Костанти кольорів тексту------------------------------------------------
    // темніші
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    // світліші
    public static final String BRIGHT_BLACK = "\u001B[90m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    //------------------------------------------У ГРІ------------------------------------------------------------
    String COLOR_FON=WHITE_BACKGROUND;
    String COLOR_TEXT=BRIGHT_WHITE;
    String COLOR_PLAYERS=BLACK;
    //------------------------------------------СИМВОЛИ------------------------------------------------------------
    String HOUSE = Character.toString(0x2302); // домик
    String HOTEL = Character.toString(0x2302); // домик
    String SHIP ="\uD83D\uDEA2";/*🚢*/
    String LIGHT="\uD83D\uDCA1";/*💡*/
    String SHOWER="\uD83D\uDEBF";/*🚿*/
    String ANCHAR="⚓";
    String WHEEL="⎈";//рівно
    String WAVE1="∿";
    String WAVE2="≈";//рівно
    String WAVE3="≋";
    String FLAG_BLACK="⚑";
    String FLAG_WHITE="⚐";
    String ELECTRICITY="⚡";
    String WARNING="⚠";// широкий
    //------------------------------------------РОЗМІРИ------------------------------------------------------------
    int SIZE_CELLS =4;
    int SIZE_GAME = 11;
}
