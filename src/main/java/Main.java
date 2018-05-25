import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import game.entity.Minion;
import util.IO;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static util.IO.printf;
import static util.IO.read;

public class Main {

    public static void main(String... args) throws IOException {
        Gson gson = new Gson();
        File test = new File("res/entities/test.json");
        Type type = new TypeToken<List<Minion>>(){}.getType();
        List<Minion> minions = gson.fromJson(read(test), type);
        printf("minions: %s", minions);
    }
}
