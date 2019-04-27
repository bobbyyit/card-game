package com.yit.cardgame.foundation;

public enum Cards {

    ACE_OF_HEARTS(1, 1, "Hearts", ""),
    ACE_OF_SPADES(2, 1, "Spades", ""),
    ACE_OF_DIAMONDS(3, 1, "Diamonds", ""),
    ACE_OF_CLUBS(4, 1, "Clubs" ,""),
    TWO_OF_HEARTS(5, 2, "Hearts", ""),
    TWO_OF_SPADES(6, 2, "Spades", ""),
    TWO_OF_DIAMONDS(7, 2, "Diamonds", ""),
    TWO_OF_CLUBS(8, 2, "Clubs", ""),
    THREE_OF_HEARTS(9, 3, "Hearts", ""),
    THREE_OF_SPADES(10, 3, "Spades", ""),
    THREE_OF_DIAMONDS(11, 3, "Diamonds", ""),
    THREE_OF_CLUBS(12, 3, "Clubs", ""),
    FOUR_OF_HEARTS(13, 4, "Hearts", ""),
    FOUR_OF_SPADES(14, 4, "Spades", ""),
    FOUR_OF_DIAMONDS(15, 4, "Diamonds", ""),
    FOUR_OF_CLUBS(16, 4, "Clubs", ""),
    FIVE_OF_HEARTS(17, 5, "Hearts", ""),
    FIVE_OF_SPADES(18, 5, "Spades", ""),
    FIVE_OF_DIAMONDS(19, 5, "Diamonds" ,""),
    FIVE_OF_CLUBS(20, 5, "Clubs", ""),
    SIX_OF_HEARTS(21, 6, "Hearts", ""),
    SIX_OF_SPADES(22, 6, "Spades", ""),
    SIX_OF_DIAMONDS(23, 6, "Diamonds", ""),
    SIX_OF_CLUBS(24, 6, "Clubs", ""),
    SEVEN_OF_HEARTS(25, 7, "Hearts", ""),
    SEVEN_OF_SPADES(26, 7, "Spades", ""),
    SEVEN_OF_DIAMONDS(27, 7, "Diamonds", ""),
    SEVEN_OF_CLUBS(28, 7, "Clubs", ""),
    EIGHT_OF_HEARTS(29, 8, "Hearts", ""),
    EIGHT_OF_SPADES(30, 8, "Spades" ,""),
    EIGHT_OF_DIAMONDS(31, 8, "Diamonds", ""),
    EIGHT_OF_CLUBS(32, 8, "Clubs", ""),
    NINE_OF_HEARTS(33, 9, "Hearts", ""),
    NINE_OF_SPADES(34, 9, "Spades", ""),
    NINE_OF_DIAMONDS(35, 9, "Diamonds", ""),
    NINE_OF_CLUBS(36, 9, "Clubs", ""),
    TEN_OF_HEARTS(37, 10, "Hearts", ""),
    TEN_OF_SPADES(38, 10, "Spades", ""),
    TEN_OF_DIAMONDS(39, 10, "Diamonds", ""),
    TEN_OF_CLUBS(40, 10, "Clubs", ""),
    JACK_OF_HEARTS(41, 11, "Hearts", ""),
    JACK_OF_SPADES(42, 11, "Spades", ""),
    JACK_OF_DIAMONDS(43, 11, "Diamonds", ""),
    JACK_OF_CLUBS(44, 11, "Clubs", ""),
    QUEEN_OF_HEARTS(45, 12, "Hearts", ""),
    QUEEN_OF_SPADES(46, 12, "Spades", ""),
    QUEEN_OF_DIAMONDS(47, 12, "Diamonds", ""),
    QUEEN_OF_CLUBS(48, 12, "Clubs", ""),
    KING_OF_HEARTS(49, 13, "Hearts", ""),
    KING_OF_SPADES(50, 13, "Spades", ""),
    KING_OF_DIAMONDS(51, 13, "Diamonds", ""),
    KING_OF_CLUBS(52, 13, "Clubs", "");

    private final int id;
    private final int value;
    private final String suit;
    private final String niceName;

    Cards(int id, int value, String suit, String niceName) {
        this.id = id;
        this.value = value;
        this.suit = suit;
        this.niceName = niceName;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getNiceName() {
        return niceName;
    }
}
