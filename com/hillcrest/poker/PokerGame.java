package com.hillcrest.poker;

public class PokerGame {

    private int tokens;
    private Deck deck;
    private Card[] playerHand;

    public PokerGame(){
        tokens = 10;
        deck = new Deck();
        playerHand = new Card[5];
    }

    /**
     * gets gme menu
     * @return the game menu
     */
    public String getGameMenu(){
        String output = "Game Menu: \n";
        output += "You have" + tokens + "tokens remaining \n";
        output += "1 - Start new game \n";
        output += "2 - Quit\n";
        return output;
    }

    /**
     * give a player 5 cards for their hand
     */

    public void deal(){
        for(int i = 0; i < playerHand.length; i++){
            playerHand [i] = deck.dealCard();
        }
    }

    /** displays card menu
     * @param card the card to decide again
     * @return the same
     */
    public String getCardMenu(int card){
        String output = "Keep this card? " + playerHand[card] + "\n";
        output += " 1= Yes\n";
        output += "2 = No\n";
        return output;
    }

    /** discards a card form the player hands and replaces it with a new card form the deck
     *
     * @param card teh card to discard
     */
    public void discardCard(int card){
        deck.discardCard(playerHand[card]);
        playerHand[card] = deck.dealCard();

    }

    /**
     * displays the player's hand
     * @return the player hand
     */

    public String displayHand(){
        String output = "Your hand\n";
        for(int i = 0; i < playerHand.length; i++){
            output += playerHand [i] + " ";
        }
        return output;
    }

    /** scores the hand and returns the tokens 1
     *
     * @return the token that you get from each thing
     */
    public int scoreHand() {
        sortHand();
        boolean straight = isStraight();

        boolean flush = isFlush();

        if (flush) {
            if (straight) {
                if (playerHand[4].getNumber() == Card.ACE && playerHand[3].getNumber() == Card.KING) {
                    return 250;
                } else {
                    return 50;
                }
            }else{
                return 5;
            }
        }
        boolean twoPair = false;
        int maxMatches = 0;
        for (int i = 0; i < playerHand.length; i++) {
            int count = 1;
            for (int j = i + 1; j < playerHand.length; j++) {
                if (playerHand[i].getNumber() == playerHand[j].getNumber()) {
                    count++;
                }
            }

            if(count >= maxMatches) {
                if (maxMatches >= 2) {
                    twoPair = true;
                }
                maxMatches = count;
            }
        }

        if(maxMatches == 4){
            return 25;
        }else if(maxMatches == 3){
            if(twoPair){
                return 6;
            }else {
                return 3;
            }
        } else if(maxMatches == 2){
            if(twoPair){
                return 2;
            } else {
                return 1;
            }
        }else {
            return 0;
        }
    }

    /**
     * checks card to determine if they are a flush
     * @return true if the cards are a flush
     */
    private boolean isFlush() {
        boolean flush = true;

        Card card = playerHand[0];
        for(int i = 1; i < playerHand.length; i++){
            if(card.getSuit() != playerHand[i].getSuit()){
                flush = false;
                break;
            }
        }
        return flush;
    }

    /** check cards to determine ifther is a straight
     *
     * @return true if the cards arre a straight
     */
    private boolean isStraight() {
        boolean straignt = true;

        for(int i = 0; i < playerHand.length - 1; i++){
            if(straignt && playerHand[i].getNumber() + 1 != playerHand[i+1].getNumber()){
                straignt = false;
                break;
            }
        }

        if(!straignt && playerHand[0].getNumber() == Card.ACE && playerHand[4].getNumber() == Card.KING){
            straignt = true;
            Card ace = playerHand[0];
            for(int i = 0; i < 4; i++){
                playerHand[i] = playerHand[i+1];
            }
            playerHand[4] = ace;

            for(int i = 0; i <  playerHand.length - 2; i++ ){
                if(straignt && playerHand[i].getNumber()+1 != playerHand[i+1].getNumber()){
                    straignt = false;
                    break;
                }
            }
        }
        return straignt;
    }

    /** sorts the hand
     *
     */
    private void sortHand (){
        for(int i = 0; i < playerHand.length; i++){
            int minPosition = minimiumPossition(i);
            Card swapCard = playerHand[minPosition];
            playerHand[minPosition] = playerHand[i];
            playerHand[i] = swapCard;
        }

    }

    /** get min value ij array
     *
     * @param from
     * @return
     */
    private int minimiumPossition (int from){
        int minPossition = from;
        for(int i = from + 1; i < playerHand.length; i++){
            if(playerHand[i].getNumber() < playerHand[minPossition].getNumber()){
                minPossition = i;
            }
        }
        return minPossition;
    }

    public Card[] getPlayerHand() {
        return playerHand;
    }

    public void decrementToken(){
        tokens--;
    }
    public void payWinnings(int winnings){
        tokens += winnings;
    }
}
