package xquery_source_code_generator


class FunctionBuilder(modules: ModuleCollection) {
  def buildFunction(name: String, numberOfParameters: Int): FunctionBody = {
    FunctionBody(name = name, calls = List(), params = numberOfParameters)
  }

}
