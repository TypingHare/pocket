package pocket.utility;

import org.jetbrains.annotations.NotNull;

public final class FileUtility {
    @NotNull
    public static String removeExtension(@NotNull final String filepath) {
        final var lastSeparatorIndex = Math.max(filepath.lastIndexOf('/'), filepath.lastIndexOf('\\'));
        final var lastDotIndex = filepath.lastIndexOf('.');

        if (lastDotIndex > lastSeparatorIndex) {
            return filepath.substring(0, lastDotIndex);
        }

        return filepath;
    }
}
