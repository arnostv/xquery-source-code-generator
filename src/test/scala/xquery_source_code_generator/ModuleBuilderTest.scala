package xquery_source_code_generator

import org.specs2.mutable.Specification


class ModuleBuilderTest extends Specification {
  "module builder" should {
    "build first module when module collection is empty" in {
      val modules = new ModuleCollection
      val builder = new ModuleBuilder(modules)

      val module = builder.buildModule(NsPrefix(Namespace("my://namespace/one"), "ns1"))
      module === Module(NsPrefix(Namespace("my://namespace/one"), "ns1"), List())
    }
  }
}
