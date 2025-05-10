package pocket;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        final var pocketTranspiler = new PocketTranspiler(Path.of("src/main/resources/"));
        try {
            pocketTranspiler.transpileEntry("loop.pk");
            System.out.println(pocketTranspiler.generateJavaScriptFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
