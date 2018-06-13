import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import game.entity.card.character.Hero;
import game.entity.card.character.Minion;
import game.state.State;
import game.state.collections.Deck;
import player.Human;
import player.Player;
import util.IO;
import util.Util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static util.IO.printf;
import static util.IO.printj;
import static util.IO.read;

public class Main {

    public static void main(String... args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Minion> minions = readTestMinions(gson);

        test(minions);
    }

    private static List<Minion> readTestMinions(Gson gson) throws IOException {
        File testCards = new File("res/entities/test.json");
        Type type = new TypeToken<List<Minion>>(){}.getType();
        List<Minion> minions = gson.fromJson(read(testCards), type);
        return minions;
    }

    private static void test(List<Minion> minions) {
        Random r = new Random();

        printj( minions);

        Hero hero1 = new Hero();
        Hero hero2 = new Hero();

        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        for(int i = 0; i < 30; i++) {
            deck1.add(Util.clone(minions.get(r.nextInt(minions.size()))));
            deck2.add(Util.clone(minions.get(r.nextInt(minions.size()))));
        }

        Player player1 = new Human(hero1, deck1);
        Player player2 = new Human(hero2, deck2);

        State game = new State(player1, player2);

        printj(game);
    }
}
