package pocket.provider

class NodeProcessProvider() : ProcessProvider() {
    override fun get(): Process = ProcessBuilder("node").start()
}