package player;

import game.entity.card.character.Hero;
import game.state.collections.Deck;

public abstract class Player {

    private final Hero startHero;
    private final Deck startDeck;

    public Player(Hero startHero, Deck startDeck) {
        this.startHero = startHero;
        this.startDeck = startDeck;
    }

    public Hero getStartHero() {
        return startHero;
    }

    public Deck getStartDeck() {
        return startDeck;
    }
}
