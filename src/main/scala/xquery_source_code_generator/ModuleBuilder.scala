package xquery_source_code_generator

class ModuleBuilder(modules:ModuleCollection) {

  def buildModule(nsPrefix: NsPrefix, numberOfFunctions: Int): Module = {
    val functions = for (i: Int <- 1 to numberOfFunctions) yield {
      val funcBuilder = FunctionBuilder(modules)
      val numberOfParameters = i % 4
      funcBuilder.buildFunction(s"func${i}p$numberOfParameters", numberOfParameters)
    }
    val module: Module = Module(nsPrefix, functions.toList)
    modules.registerModule(module)
    module
  }

  def buildBunchOfModules(numberOfModules: Int): Seq[Module] = {
    val nsGenerator = new NamespaceGenerator
    for (i <- 1 to numberOfModules) yield {
      val nsPrefix = nsGenerator.nextNamespace
      val numberOfFunction = 3 + (i % numberOfModules)

      buildModule(nsPrefix, numberOfFunction)
    }
  }

}
