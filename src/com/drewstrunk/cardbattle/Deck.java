package com.drewstrunk.cardbattle;

import java.util.ArrayList;

public class Deck {

    public static ArrayList<String> createDeck() {

        //Create a new instance of the card class to use in our deck.
        Card card = new Card();

        //Set our deck size to 52.  We can change the deck size by changing this number.
        int deckSize = 52;

        //Create a new array list called deckList where we'll build our deck of cards.
        //The array list has a size of deckSize.
        ArrayList<String> deckList = new ArrayList<>(deckSize);

        //Add cards to the deck in the order of value.  Two is the lowest card, Ace is the highest.  Spades, Clubs, Diamonds, then Hearts.
        //We will determine a card's value based on its position in the array list.
        deckList.add(card.twoOfSpades);
        deckList.add(card.threeOfSpades);
        deckList.add(card.fourOfSpades);
        deckList.add(card.fiveOfSpades);
        deckList.add(card.sixOfSpades);
        deckList.add(card.sevenOfSpades);
        deckList.add(card.eightOfSpades);
        deckList.add(card.nineOfSpades);
        deckList.add(card.tenOfSpades);
        deckList.add(card.jackOfSpades);
        deckList.add(card.queenOfSpades);
        deckList.add(card.kingOfSpades);
        deckList.add(card.aceOfSpades);

        deckList.add(card.twoOfClubs);
        deckList.add(card.threeOfClubs);
        deckList.add(card.fourOfClubs);
        deckList.add(card.fiveOfClubs);
        deckList.add(card.sixOfClubs);
        deckList.add(card.sevenOfClubs);
        deckList.add(card.eightOfClubs);
        deckList.add(card.nineOfClubs);
        deckList.add(card.tenOfClubs);
        deckList.add(card.jackOfClubs);
        deckList.add(card.queenOfClubs);
        deckList.add(card.kingOfClubs);
        deckList.add(card.aceOfClubs);

        deckList.add(card.twoOfDiamonds);
        deckList.add(card.threeOfDiamonds);
        deckList.add(card.fourOfDiamonds);
        deckList.add(card.fiveOfDiamonds);
        deckList.add(card.sixOfDiamonds);
        deckList.add(card.sevenOfDiamonds);
        deckList.add(card.eightOfDiamonds);
        deckList.add(card.nineOfDiamonds);
        deckList.add(card.tenOfDiamonds);
        deckList.add(card.jackOfDiamonds);
        deckList.add(card.queenOfDiamonds);
        deckList.add(card.kingOfDiamonds);
        deckList.add(card.aceOfDiamonds);

        deckList.add(card.twoOfHearts);
        deckList.add(card.threeOfHearts);
        deckList.add(card.fourOfHearts);
        deckList.add(card.fiveOfHearts);
        deckList.add(card.sixOfHearts);
        deckList.add(card.sevenOfHearts);
        deckList.add(card.eightOfHearts);
        deckList.add(card.nineOfHearts);
        deckList.add(card.tenOfHearts);
        deckList.add(card.jackOfHearts);
        deckList.add(card.queenOfHearts);
        deckList.add(card.kingOfHearts);
        deckList.add(card.aceOfHearts);

        //The createDeck method will return the array list.
        return deckList;

    }

}
