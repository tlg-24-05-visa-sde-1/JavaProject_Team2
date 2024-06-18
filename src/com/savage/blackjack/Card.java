package com.savage.blackjack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public enum Card {
    ACE_SPADES(11, "resources/spades/ace_of_spades.txt"),
    TWO_SPADES(2, "resources/spades/two_of_spades.txt"),
    THREE_SPADES(3, "resources/spades/three_of_spades.txt"),
    FOUR_SPADES(4, "resources/spades/four_of_spades.txt"),
    FIVE_SPADES(5, "resources/spades/five_of_spades.txt"),
    SIX_SPADES(6, "resources/spades/six_of_spades.txt"),
    SEVEN_SPADES(7, "resources/spades/seven_of_spades.txt"),
    EIGHT_SPADES(8, "resources/spades/eight_of_spades.txt"),
    NINE_SPADES(9, "resources/spades/nine_of_spades.txt"),
    TEN_SPADES(10, "resources/spades/ten_of_spades.txt"),
    JACK_SPADES(10, "resources/spades/jack_of_spades.txt"),
    QUEEN_SPADES(10, "resources/spades/queen_of_spades.txt"),
    KING_SPADES(10, "resources/spades/king_of_spades.txt"),
    ACE_HEARTS(11, "resources/hearts/ace_of_hearts.txt"),
    TWO_HEARTS(2, "resources/hearts/two_of_hearts.txt"),
    THREE_HEARTS(3, "resources/hearts/three_of_hearts.txt"),
    FOUR_HEARTS(4, "resources/hearts/four_of_hearts.txt"),
    FIVE_HEARTS(5, "resources/hearts/five_of_hearts.txt"),
    SIX_HEARTS(6, "resources/hearts/six_of_hearts.txt"),
    SEVEN_HEARTS(7, "resources/hearts/seven_of_hearts.txt"),
    EIGHT_HEARTS(8, "resources/hearts/eight_of_hearts.txt"),
    NINE_HEARTS(9, "resources/hearts/nine_of_hearts.txt"),
    TEN_HEARTS(10, "resources/hearts/ten_of_hearts.txt"),
    JACK_HEARTS(10, "resources/hearts/jack_of_hearts.txt"),
    QUEEN_HEARTS(10, "resources/hearts/queen_of_hearts.txt"),
    KING_HEARTS(10, "resources/hearts/king_of_hearts.txt"),
    ACE_CLUBS(11, "resources/clubs/ace_of_clubs.txt"),
    TWO_CLUBS(2, "resources/clubs/two_of_clubs.txt"),
    THREE_CLUBS(3, "resources/clubs/three_of_clubs.txt"),
    FOUR_CLUBS(4, "resources/clubs/four_of_clubs.txt"),
    FIVE_CLUBS(5, "resources/clubs/five_of_clubs.txt"),
    SIX_CLUBS(6, "resources/clubs/six_of_clubs.txt"),
    SEVEN_CLUBS(7, "resources/clubs/seven_of_clubs.txt"),
    EIGHT_CLUBS(8, "resources/clubs/eight_of_clubs.txt"),
    NINE_CLUBS(9, "resources/clubs/nine_of_clubs.txt"),
    TEN_CLUBS(10, "resources/clubs/ten_of_clubs.txt"),
    JACK_CLUBS(10, "resources/clubs/jack_of_clubs.txt"),
    QUEEN_CLUBS(10, "resources/clubs/queen_of_clubs.txt"),
    KING_CLUBS(10, "resources/clubs/king_of_clubs.txt"),
    ACE_DIAMONDS(11, "resources/diamonds/ace_of_diamonds.txt"),
    TWO_DIAMONDS(2, "resources/diamonds/two_of_diamonds.txt"),
    THREE_DIAMONDS(3, "resources/diamonds/three_of_diamonds.txt"),
    FOUR_DIAMONDS(4, "resources/diamonds/four_of_diamonds.txt"),
    FIVE_DIAMONDS(5, "resources/diamonds/five_of_diamonds.txt"),
    SIX_DIAMONDS(6, "resources/diamonds/six_of_diamonds.txt"),
    SEVEN_DIAMONDS(7, "resources/diamonds/seven_of_diamonds.txt"),
    EIGHT_DIAMONDS(8, "resources/diamonds/eight_of_diamonds.txt"),
    NINE_DIAMONDS(9, "resources/diamonds/nine_of_diamonds.txt"),
    TEN_DIAMONDS(10, "resources/diamonds/ten_of_diamonds.txt"),
    JACK_DIAMONDS(10, "resources/diamonds/jack_of_diamonds.txt"),
    QUEEN_DIAMONDS(10, "resources/diamonds/queen_of_diamonds.txt"),
    KING_DIAMONDS(10, "resources/diamonds/king_of_diamonds.txt"),;

    private final int value;
    private final String image;

    Card(int value, String image) {
        this.value = value;
        this.image = image;
    }

      public int getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }

    public String getImageContent() {
        try{
            return new String(Files.readAllBytes(Paths.get(image)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error reading image";
    }
}