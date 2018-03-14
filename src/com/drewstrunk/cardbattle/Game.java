package com.drewstrunk.cardbattle;

import java.util.*;

public class Game {

    public static void main(String[] args) {

        //Print all of this when the program starts.
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

        //Run the deal method.
        deal();


    }

    //This method will take input from the user to determine the number of players.
    public static int getNumberOfPlayers() {
        //Create a variable to track the number of players and start it at 0.
        int numberOfPlayers = 0;
        //Use try/catch to gracefully handle a user entering a non integer.
        try {
            //Create a new instance of the Scanner class called reader to take input from the user.
            Scanner reader = new Scanner(System.in);
            //Set the numberOfPlayers variable to the users input.  The input must be an integer.
            numberOfPlayers = reader.nextInt();

            //Since we only want to allow between 2 and 6 players, we need to give feedback to the user if they
            //enter a number less than 2 or greater than 6 and allow them to try again.
            if (numberOfPlayers < 2) {
                System.out.println("You can not have less than two players.  Please enter the number of players. (2-6)");
                numberOfPlayers = reader.nextInt();
            } else if (numberOfPlayers > 6) {
                System.out.println("You can not have more than 6 players.  Please enter the number of players.  (2-6)");
                numberOfPlayers = reader.nextInt();
            }
            //If the input is a non integer, we want to tell the user to restart the program.
        } catch (InputMismatchException e) {
            System.out.println("You did not enter a number.  Now everything is broken.  Please restart.");
        }
        //The getNumberOfPlayers method will return numberOfPlayers.
        return numberOfPlayers;
    }

        //This method will deal the cards.
        public static void deal () {
            //Create a new instance of the Deck class called thisDeck.
            //This is the deck that we will deal from and remove cards from as we go.
            ArrayList<String> thisDeck = Deck.createDeck();
            //Create another new instance of the Deck class called unchangedDeck.
            //This is the deck we will use to check card values.  It will remain unchanged.
            ArrayList<String> unchangedDeck = Deck.createDeck();

            //Create a variable called numberOfPlayers that we set to the number entered by the user in the
            //getNumberOfPlayers method.
            int numberOfPlayers = getNumberOfPlayers();
            //Create a new array list where we will store our list of players.
            ArrayList<String> playerPositions = new ArrayList<>();
            playerPositions.add("Player One");
            playerPositions.add("Player Two");
            playerPositions.add("Player Three");
            playerPositions.add("Player Four");
            playerPositions.add("Player Five");
            playerPositions.add("Player Six");

            //Create an array called dealtCards where we will track the value of the cards that have been dealt.
            int dealtCards[] = {0, 0, 0, 0, 0, 0};

            //This loop will deal cards.  We want to run it a number of times equal to the number of players.
            for (int i = 0; i < numberOfPlayers; i++) {
                
                //Create a new instance of the Random class called random that will allow us to select a random
                //index from the deck array list.
                Random random = new Random();
                
                //Create a variable called index that will select a random index from our deck array list.
                int index = random.nextInt(thisDeck.size());

                //Create a String variable that will represent a random card.  Set it to whichever card is the the position
                //that we just randomly chose in the deck array list.
                String randomCard = thisDeck.get(index);

                //Create an int variable that will represent the absolute position of the card in a complete deck.
                //We need to know it's original position to calculate its value because we are going to be removing cards
                //from thisDeck.  Therefore we set it to its original index in the unchangedDeck array list - its index
                //will represent its score.  twoOfSpades = 0, threeOfSpades = 1, aceOfHearts = 52, etc.
                int randomCardPosition = unchangedDeck.indexOf(randomCard);

                //Print each players card.  Since we started our loop at 0, the player number will end up being i+1.
                System.out.println("Player " + (i + 1) + "'s randomCard is: " + randomCard);

                //Set the value of dealtCards in the current position to the score of our random card.
                dealtCards[i] = randomCardPosition;

                //Remove the card we chose from our deck so that it can not be dealt again.
                thisDeck.remove(randomCard);
            }

            //Create a new array called staticDealtCards that will track the starting position of each of our cards.
            //We need to do this because we are going to sort the dealtCards array to figure out a winner, but we need to
            //remember which score belongs to which player.
            int[] staticDealtCards = {0, 0, 0, 0, 0, 0};

            //Create a loop that will run a number of times equal to the length of our staticDealtCards array.
            //This will set our staticDealtCards array to the same numbers as our dealtCards array.
            for (int m = 0; m < staticDealtCards.length; m++) {
                staticDealtCards[m] = dealtCards[m];
            }

            //This is a bubble sort that will sort our dealtCards array from smallest to largest.
            for (int y = 0; y < dealtCards.length - 1; y++) {
                for (int z = 0; z < dealtCards.length - y - 1; z++) {
                    if (dealtCards[z] > dealtCards[z + 1]) {
                        int newPosition = dealtCards[z];
                        dealtCards[z] = dealtCards[z + 1];
                        dealtCards[z + 1] = newPosition;
                    }
                }
            }

            //Create a new variable called winningCard that will equal the largest number in the array (which is always
            //going to be the number in the 5th position after our sort).
            int winningCard = dealtCards[5];

            //Create a loop that will look through all of our dealt cards until it finds the one that is equal to our winning card.
            //Then we will print the winning player and the winning card.
            for (int n = 0; n < dealtCards.length; n++) {
                //If the user was never able to enter a number between 2 and 6 (for example if they entered a character or string,
                //numberOfPlayers will still be set to 0 and we will not have a winner so we don't want to run this loop in that case.
                if (numberOfPlayers < 2) {
                    break;
                }
                if (winningCard == staticDealtCards[n]) {
                    System.out.println("The winner is " + playerPositions.get(n) + " with the " + unchangedDeck.get(winningCard) + ".");
                }
            }

        }
    }