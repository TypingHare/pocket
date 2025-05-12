package pocket.ast;

import org.jetbrains.annotations.NotNull;

public abstract class ASTNode {
  @NotNull public final String filename;
  public final int line;
  public final int column;

  public ASTNode(@NotNull final String filename, final int line, final int column) {
    this.filename = filename;
    this.line = line;
    this.column = column;
  }

  public ASTNode(@NotNull final ASTNode node) {
    this.filename = node.filename;
    this.line = node.line;
    this.column = node.column;
  }

  public static ASTNode create(@NotNull final String filepath, final int line, final int column) {
    return new ASTNode(filepath, line, column) {};
  }
}
