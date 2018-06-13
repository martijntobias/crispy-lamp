package game.state;

import game.entity.card.Card;
import game.entity.card.character.Hero;
import game.state.collections.Board;
import game.state.collections.Deck;
import game.state.collections.Hand;
import player.Player;
import util.Util;

import java.io.Serializable;
import java.util.*;

/**
 * Contains all information regarding the game's State.
 */
public class State implements Cloneable, Serializable {
    private static final int STARTING_HAND_SIZE = 3;

    private final Random rand;

    private final Player player1;
    private final Player player2;
    private final Map<Player, Hero> heroes;
    private final Map<Player, Deck> decks;
    private final Map<Player, Hand> hands;
    private final Map<Player, Board> boards;

    private Player activePlayer;

    public State(Player player1, Player player2, Random random) {
        this.rand = random;

        this.player1 = player1;
        this.player2 = player2;

        this.heroes = new HashMap<>();
        heroes.put(player1, Util.clone(player1.getStartHero()));
        heroes.put(player2, Util.clone(player2.getStartHero()));

        this.decks = new HashMap<>();
        decks.put(player1, Util.clone(player1.getStartDeck()));
        decks.put(player2, Util.clone(player2.getStartDeck()));

        this.hands = new HashMap<>();
        hands.put(player1, new Hand());
        hands.put(player2, new Hand());

        this.boards = new HashMap<>();
        boards.put(player1, new Board());
        boards.put(player2, new Board());
    }

    /**
     * Handles everything happening prior to the start of the first turn. This means deciding who goes first, and the
     * mulligan phase.
     * TODO: The Coin.
     * TODO: Mulligans.
     */
    public void preGame() {
        activePlayer = rand.nextBoolean() ? player1 : player2;
        for(int i = 0; i < STARTING_HAND_SIZE; i++) {
            draw(activePlayer);
            draw(getInactivePlayer());
        }
        draw(getInactivePlayer());
    }

    /**
     * Returns whether or not the game is over, meaning one or more of the players is dead.
     * TODO: isOver()
     * @return Always false
     */
    public boolean isOver() {
        return false;
    }

    /**
     * Performs the current Action, thus changing this State in the process.
     * TODO: action().
     * @param action The Action to be performed.
     */
    public void action(Action action) {
        throw new UnsupportedOperationException();
    }

    /**
     * Helper function. Gets the Player that is not ActivePlayer.
     * @return
     */
    private Player getInactivePlayer() {
        return player1 == activePlayer ? player2 : player1;
    }

    /**
     * Makes player draw one card.
     * @param player The player who is to draw a card.
     * @return Whether or not a card was succesfully added. Will also return false if player's deck is empty.
     */
    private boolean draw(Player player) {
        Card card = decks.get(player).remove();
        if(card == null) {
            return false;
        }
        return hands.get(player).add(card);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    /**
     * Returns a List of all possible Actions that the active player can take.
     * TODO: actions().
     * @return A List of all possible Actions, including ending the turn.
     */
    public List<Action> actions() {
        List<Action> actions = new ArrayList<>();

        Action endTurn = new Action();
        actions.add(endTurn);

        return actions;
    }
}
