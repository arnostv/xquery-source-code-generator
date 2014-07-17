package xquery_source_code_generator

class ModuleBuilder(modules:ModuleCollection) {

  def buildModule(nsPrefix: NsPrefix, numberOfFunctions: Int): Module = {
    val functions = for (i: Int <- 1 to numberOfFunctions) yield {
      val funcBuilder = FunctionBuilder(modules)
      val numberOfParameters = i % 4
      funcBuilder.buildFunction(s"func${i}p$numberOfParameters", numberOfParameters)
    }
    Module(nsPrefix, functions.toList)
  }

}
