package player;

import game.entity.Hero;
import game.state.collections.Deck;

public class Human extends Player {

    public Human(Hero startHero, Deck startDeck) {
        super(startHero, startDeck);
    }
}
