package com.hillcrest.poker;

/***
 * class representing a card
 */

public class Card {
    public static final int ACE = 1;
    public static final int KING = 13;

    private int number;
    private int suit;

    /**
     * creats an interface of the card
     * @param number the numebr of the card
     * @param suit thet suit of the card
     */
    public Card(int number, int suit){
        /**
         * number is between 1 nad 13 inclusive
         */
        this.number = number;
        /**
         * suite card 0 - spades = 1; heaerts =2; clubs = 3; diamonds = 4;
         */
        this.suit = suit;
    }
    public String toString() {
        String output = "";

        if(number == ACE){
            output += "Ace";
        }else if (number == 11){
            output += "Jack";
        }else if (number == 12) {
            output += "Queen";
        }else if (number == KING) {
            output += "King";
        }else {
            output += number;
        }

        if(suit == 0){
            output += " of Spades\n";
        }else if (suit == 1){
            output += " of hearts\n";
        }else if (suit == 2){
            output += " of Clubs\n";
        }else {
            output += " of Diamoinds\n";
        }

        return output;
    }
    // returns the numebr of the card
    public int getNumber() {
        return number;
    }
    // returns suit of card
    public int getSuit(){
        return suit;
    }

}
