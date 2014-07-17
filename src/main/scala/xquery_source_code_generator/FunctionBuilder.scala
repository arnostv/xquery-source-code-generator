package xquery_source_code_generator


case class FunctionBuilder(modules: ModuleCollection) {
  def buildFunction(name: String, numberOfParameters: Int): FunctionBody = {

    val numberOfFunctionCalls = numberOfParameters

    val calls = if (modules.moduleList.size > 0) {
      for (i <- 1 to numberOfFunctionCalls) yield {
        val module: Module = modules.moduleList(i % modules.moduleList.size)
        val targetFunction: FunctionBody = module.functions(i % module.functions.size)
        FunctionCall(targetFunction.name, module.nsPrefix)
      }
    } else {
      List()
    }

    FunctionBody(name = name, calls = calls.toList, params = numberOfParameters)
  }

}
