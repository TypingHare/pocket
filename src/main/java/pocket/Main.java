package pocket;


import picocli.CommandLine;

public class Main {
  public static void main(final String[] args) {
    new CommandLine(new Pocket()).execute(args);
  }
}
