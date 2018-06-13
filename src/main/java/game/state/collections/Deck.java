package game.state.collections;

import game.entity.card.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deck implements Serializable {

    private final int MAX_SIZE = 60;

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

    public Card get(int i) {
        return cards.get(i);
    }

    public List<Card> getAll() {
        return new ArrayList<>(cards);
    }

    /**
     * Adds the card to the deck. Will return false and do nothing with the card if the hand is already full.
     * @param card
     * @return
     */
    public boolean add(Card card) {
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
