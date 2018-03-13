package com.drewstrunk.cardbattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        System.out.println("******CARD BATTLE******");
        System.out.println();

        System.out.println("Each player will be dealt a card.  The highest card wins.");
        System.out.println("Suits are ranked as follows:");
        System.out.println("1: Hearts");
        System.out.println("2: Diamonds");
        System.out.println("3: Clubs");
        System.out.println("4: Spades");
        System.out.println();
        System.out.println();

        System.out.println("Please enter the number of players. (2-6)");

        deal();


    }

    public static int getNumberOfPlayers() {
        Scanner reader = new Scanner(System.in);
        int numberOfPlayers = reader.nextInt();

        if (numberOfPlayers < 2) {
            System.out.println("You can not have less than two players.  Please enter the number of players. (2-6)");
            numberOfPlayers = reader.nextInt();
        }

        else if (numberOfPlayers > 6) {
            System.out.println("You can not have more than 6 players.  Please enter the number of players.  (2-6)");
            numberOfPlayers = reader.nextInt();
        }

        return numberOfPlayers;

    }

    public static void deal() {

        ArrayList<String> thisDeck = Deck.createDeck();
        ArrayList<String> unchangedDeck = Deck.createDeck();

        int numberOfPlayers = getNumberOfPlayers();
        ArrayList<String> playerPositions = new ArrayList<>();
        playerPositions.add("Player One");
        playerPositions.add("Player Two");
        playerPositions.add("Player Three");
        playerPositions.add("Player Four");
        playerPositions.add("Player Five");
        playerPositions.add("Player Six");


        int dealtCards[] = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < numberOfPlayers; i++) {

            Random randomCard;
            randomCard = new Random();

            int index = randomCard.nextInt(thisDeck.size());

            String card = thisDeck.get(index);
            int cardPosition = unchangedDeck.indexOf(card);

            System.out.println("Player " + (i + 1) + "'s card is: " + card);

            dealtCards[i] = cardPosition;

            thisDeck.remove(card);
        }

        int[] staticDealtCards = {0, 0, 0, 0, 0, 0};
        for (int m = 0; m < staticDealtCards.length; m++) {
            staticDealtCards[m] = dealtCards[m];
        }

        int length = dealtCards.length;

        for (int y = 0; y < length - 1; y++) {
            for (int z = 0; z < length - y - 1; z++) {
                if (dealtCards[z] > dealtCards[z + 1]) {
                    int newPosition = dealtCards[z];
                    dealtCards[z] = dealtCards[z + 1];
                    dealtCards[z + 1] = newPosition;
                }
            }
        }

        int winningCard = dealtCards[5];

        for (int n = 0; n < dealtCards.length; n++) {
            if (winningCard == staticDealtCards[n]) {
                System.out.println("The winner is " + playerPositions.get(n) + " with the " + unchangedDeck.get(winningCard) + ".");
            }
        }

    }
}
