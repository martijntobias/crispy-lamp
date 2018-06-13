package game.state.collections;

import game.entity.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card get(int i) {
        return cards.get(i);
    }

    public List<Card> getAll() {
        return new ArrayList<>(cards);
    }

    /**
     * Adds the card to the hand. Will return false and ignore the card if the hand is already full.
     * TODO: Add "burned" cards (not added because the hand is full) to a list in State for later reference
     * @param card
     * @return
     */
    public boolean add(Card card) {
        int MAX_SIZE = 10;
        if(size() >= MAX_SIZE) {
            return false;
        } else {
            cards.add(card);
            return true;
        }
    }
}
