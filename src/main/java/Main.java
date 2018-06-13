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

    private long SEED = 13245;
    private boolean USE_RANDOM_SEED = false;

    private Gson gson;
    private Random rand;

    public static void main(String... args) throws IOException {

        Main main = new Main();
        main.init();

        main.test1();
    }

    private  void init() {
        this.rand = new Random(USE_RANDOM_SEED ? System.currentTimeMillis() : SEED);
        this.gson = new GsonBuilder().create();
    }

    private void test1() throws IOException {
        File testCards = new File("src/main/resources/entities/test.json");
        Type type = new TypeToken<List<Minion>>(){}.getType();
        List<Minion> minions = gson.fromJson(read(testCards), type);

        Hero hero1 = new Hero();
        Hero hero2 = new Hero();

        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        List<Minion> murlocs = minions.stream()
                .filter(m -> m.getType() == game.entity.Type.MURLOC)
                .collect(Collectors.toList());
        for(int i = 0; i < 5; i++) {
            deck1.add(Util.clone(minions.get(rand.nextInt(minions.size()))));
            deck2.add(Util.clone(murlocs.get(rand.nextInt(murlocs.size()))));
        }

        Player player1 = new Human(hero1, deck1, "Generic Gary", rand);
        Player player2 = new Human(hero2, deck2, "Mancy Murloc", rand);

        State game = new State(player1, player2, rand);

        game.preGame();
        while(!game.isOver()) {
            game.action(game.getActivePlayer().getAction(game));
        }

        printj(game);
    }
}
