package player;

import game.entity.card.character.Hero;
import game.state.collections.Deck;

public class Human extends Player {

    public Human(Hero startHero, Deck startDeck) {
        super(startHero, startDeck);
    }
}
