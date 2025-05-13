package pocket.ast;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ModuleFnNameGenerator {
    @NotNull
    String generate(@NotNull final String filepath);
}
