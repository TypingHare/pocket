package pocket.ast

import org.jgrapht.GraphPath
import org.jgrapht.alg.cycle.CycleDetector
import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.traverse.TopologicalOrderIterator

class DependencyGraph<T> {
    private val graph =
        DefaultDirectedGraph<T, DefaultEdge>(DefaultEdge::class.java)

    fun addNode(node: T) {
        graph.addVertex(node)
    }

    fun addDependency(
        dependency: T,
        dependent: T,
    ) {
        if (!graph.containsVertex(dependency)) {
            graph.addVertex(dependency)
        }
        if (!graph.containsVertex(dependent)) {
            graph.addVertex(dependent)
        }

        if (!graph.containsEdge(dependency, dependent)) {
            graph.addEdge(dependency, dependent)
        }
    }

    fun resolveOrder(): List<T> {
        val cycleDetector = CycleDetector(graph)
        if (cycleDetector.detectCycles()) {
            val cycles = cycleDetector.findCycles()
            throw IllegalStateException("Circular dependency detected among: $cycles")
        }

        val sorted = mutableListOf<T>()
        val iterator = TopologicalOrderIterator(graph)
        while (iterator.hasNext()) {
            sorted.add(iterator.next())
        }

        return sorted
    }

    fun pathBetween(dependency: T, dependent: T): GraphPath<T, DefaultEdge>? =
        DijkstraShortestPath.findPathBetween(
            graph,
            dependent,
            dependency
        )
}

