package pocket.ast.visitor

import pocket.ast.node.ImportExpr

class DependencyVisitor() : StructuralVisitor<Object>() {
    val dependencySet: MutableSet<String> = mutableSetOf()

    override fun visitImportExpr(expr: ImportExpr): Object? {
        dependencySet.add(expr.targetPath)
        return null
    }
}