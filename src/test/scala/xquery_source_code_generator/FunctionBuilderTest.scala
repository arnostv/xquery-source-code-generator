package xquery_source_code_generator

import org.specs2.mutable.Specification


class FunctionBuilderTest extends Specification {
  "function builder" should {
    "build empty function call when no parameters are provided and no modules are created" in {
      val modules = new ModuleCollection
      val functionBuilder = new FunctionBuilder(modules)

      val function = functionBuilder.buildFunction("func1", 0)
      function === new FunctionBody("func1", List())
    }

    "build empty function call with parameters when no modules are created" in {
      val modules = new ModuleCollection
      val functionBuilder = new FunctionBuilder(modules)

      val function = functionBuilder.buildFunction("funcP2", 2)
      function === new FunctionBody("funcP2", List(), 2)
    }
  }

}
