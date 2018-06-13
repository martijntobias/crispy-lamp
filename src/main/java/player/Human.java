package player;

import game.entity.card.character.Hero;
import game.state.Action;
import game.state.State;
import game.state.collections.Deck;

import java.util.List;
import java.util.Random;

public class Human extends Player {

    public Human(Hero startHero, Deck startDeck, String name, Random random) {
        super(startHero, startDeck, name, random);
    }

    @Override
    public Action getAction(State state) {
        if(state.getActivePlayer() != this) {
            throw new IllegalStateException(String.format("%s is not the active player!", this));
        }

        List<Action> possibleActions = state.actions();

        return possibleActions.get(random.nextInt(possibleActions.size()));
    }
}
