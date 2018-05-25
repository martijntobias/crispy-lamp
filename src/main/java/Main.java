import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import game.entity.Hero;
import game.entity.Minion;
import game.state.collections.Deck;
import player.Human;
import player.Player;
import util.Util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static util.IO.printf;
import static util.IO.read;

public class Main {

    public static void main(String... args) throws IOException {
        Gson gson = new Gson();
        File test = new File("res/entities/test.json");
        Type type = new TypeToken<List<Minion>>(){}.getType();
        List<Minion> minions = gson.fromJson(read(test), type);
        printf("minions: %s", minions);

        Deck deck1 = new Deck();
        deck1.addAll(minions.stream()
                .map(Util::clone)
                .collect(Collectors.toList()));
        Player player1 = new Human(new Hero(), deck1);
        Player player2 = new Human(new Hero(), new Deck());

        Deck deckClone = Util.clone(deck1);
        printf("deckClone (%s) equals deck1 (%s)? %s", gson.toJson(deckClone), gson.toJson(deck1), deckClone == deck1);
        printf("player1: %s", gson.toJson(player1));
    }
}
