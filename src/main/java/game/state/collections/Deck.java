package game.state.collections;

import game.entity.card.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deck implements Serializable {

    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Removes and returns the "topmost" card from the deck. Will return null if this deck is empty. The topmost card is
     * defined as the card at index position 0.
     * @return The "topmost" card or null if the deck is empty.
     */
    public Card remove() {
        if(isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }

    /**
     * Adds the card to the deck. Will return false and do nothing with the card if the hand is already full.
     * @param card The card that is to be added to the deck.
     * @return Whether or not this card was added to the deck.
     */
    public boolean add(Card card) {
        int MAX_SIZE = 60;
        if(size() >= MAX_SIZE) {
            return false;
        } else {
            cards.add(card);
            return true;
        }
    }

    /**
     * Adds all the cards to the deck. Will return wether or not all have been succesfully added.
     * @param cards
     * @return
     */
    public boolean addAll(List<Card> cards) {
        boolean all = true;
        for(Card card : cards) {
            all = add(card);
            if(!all) {
                break;
            }
        }
        return all;
    }
}
