package xquery_source_code_generator

class ModuleBuilder(modules:ModuleCollection) {

  def buildModule(nsPrefix: NsPrefix, numberOfFunctions: Int): Module = {
    val functions = for (i: Int <- 1 to numberOfFunctions) yield {
      val funcBuilder = FunctionBuilder(modules)
      funcBuilder.buildFunction(s"func$i", i % 4)
    }
    Module(nsPrefix, functions.toList)
  }

}
