package pocket.app

abstract class ProcessProvider {
    abstract fun get(): Process
}

class NodeProcessProvider() : ProcessProvider() {
    override fun get(): Process = ProcessBuilder("node").start()
}