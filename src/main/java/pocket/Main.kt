package pocket

import picocli.CommandLine

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        CommandLine(Pocket()).execute(*args)
    }
}