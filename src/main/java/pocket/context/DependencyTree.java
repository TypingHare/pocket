package pocket.context;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DependencyTree {
    public final Node root;

    public DependencyTree(@NotNull final String name) {
        this.root = new Node(name);
    }

    public static class Node {
        final String name;
        final List<Node> children = new ArrayList<>();

        public Node(@NotNull final String name) {
            this.name = name;
        }

        public @Nullable Node getChild(@NotNull final String name) {
            return children.stream().filter(n -> n.name.equals(name)).findFirst().orElse(null);
        }

        public @NotNull Node add(@NotNull final String name) {
            final var child = getChild(name);
            if (child != null) {
                return child;
            }

            final var node = new Node(name);
            children.add(node);

            return node;
        }
    }
}
