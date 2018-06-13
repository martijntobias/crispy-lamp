package player;

import game.entity.card.character.Hero;
import game.state.Action;
import game.state.State;
import game.state.collections.Deck;

import java.util.Random;

public abstract class Player {

    protected final String name;
    protected final Hero startHero;
    protected final Deck startDeck;
    protected final Random random;

    public Player(Hero startHero, Deck startDeck, String name, Random random) {
        this.startHero = startHero;
        this.startDeck = startDeck;
        this.name = name;
        this.random = random;
    }

    public Hero getStartHero() {
        return startHero;
    }

    public Deck getStartDeck() {
        return startDeck;
    }

    public String toString() {
        return String.format("Player %s", name);
    }

    /**
     * Presents the Player with a State. This State should be in a position where this Player is the active player and
     * can be given a list of Actions to take. One of these Actions will be returned.
     * @param state A State where this Player is the active player.
     * @return The Action chosen by this Player that should be taken.
     */
    public abstract Action getAction(State state);
}
