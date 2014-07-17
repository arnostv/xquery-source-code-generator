package xquery_source_code_generator

class ModuleBuilder(modules:ModuleCollection) {

  def buildModule(nsPrefix: NsPrefix, numberOfFunctions: Int): Module = {
    val functions = for (i: Int <- 1 to numberOfFunctions) yield FunctionBody(s"func$i", List())
    Module(nsPrefix, functions.toList)
  }

}
