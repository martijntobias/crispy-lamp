package game.entity.state;

import game.entity.Hero;
import player.Player;

import java.util.Map;

public class State {
    private Player player1;
    private Player player2;

    private Map<Player, Hero> heroes;
    private Map<Player, Board> boards;


}
