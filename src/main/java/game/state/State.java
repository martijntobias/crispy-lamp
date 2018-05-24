package game.state;

import game.entity.Hero;
import game.state.collections.Board;
import game.state.collections.Deck;
import game.state.collections.Hand;
import player.Player;

import java.util.HashMap;
import java.util.Map;

public class State {
    private final Player player1;
    private final Player player2;

    private final Map<Player, Hero> heroes;
    private final Map<Player, Deck> decks;
    private final Map<Player, Hand> hands;
    private final Map<Player, Board> boards;

    public State(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.heroes = new HashMap<>();
        heroes.put(player1, player1.getStartHero());
        heroes.put(player2, player2.getStartHero());

        this.decks = new HashMap<>();
        decks.put(player1, player1.getStartDeck());
        decks.put(player2, player2.getStartDeck());

        this.hands = new HashMap<>();

        this.boards = new HashMap<>();
    }
}
