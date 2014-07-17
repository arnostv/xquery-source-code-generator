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

    "build function calling other module" in {
      val modules = new ModuleCollection
      val moduleBuilder = new ModuleBuilder(modules)
      val module: Module = moduleBuilder.buildModule(TestData.ns1, 1)
      modules.registerModule(module)

      val functionBuilder = new FunctionBuilder(modules)
      val function = functionBuilder.buildFunction("funcA", 1)

      function === new FunctionBody("funcA", List(FunctionCall("func1", TestData.ns1)), 1)
    }
  }

}
