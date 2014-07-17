package xquery_source_code_generator


case class FunctionBuilder(modules: ModuleCollection) {
  def buildFunction(name: String, numberOfParameters: Int): FunctionBody = {

    val numberOfFunctionCalls = numberOfParameters

    val calls = if (modules.moduleList.size > 0) {
      for (i <- 1 to numberOfFunctionCalls) yield {
        val randomTargetModule: Module = modules.moduleList(i % modules.moduleList.size)
        val randomTargetFunction: FunctionBody = randomTargetModule.functions(i % randomTargetModule.functions.size)

        val paramVals = for (i <- 1 to randomTargetFunction.params) yield s"'Par$i'"
        FunctionCall(randomTargetFunction.name, randomTargetModule.nsPrefix, paramVals.toList)
      }
    } else {
      List()
    }

    FunctionBody(name = name, calls = calls.toList, params = numberOfParameters)
  }

}
