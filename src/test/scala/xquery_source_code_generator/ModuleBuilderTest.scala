package xquery_source_code_generator

import org.specs2.mutable.Specification


class ModuleBuilderTest extends Specification {
  "module builder" should {
    "build empty module when module collection is empty" in {
      val modules = new ModuleCollection
      val builder = new ModuleBuilder(modules)

      val module = builder.buildModule(NsPrefix(Namespace("my://namespace/one"), "ns1"), 0)
      module === Module(NsPrefix(Namespace("my://namespace/one"), "ns1"), List())
      modules.moduleList.contains(module) === true
    }

    "build module with few functions" in {
      val modules = new ModuleCollection
      val builder = new ModuleBuilder(modules)

      val module = builder.buildModule(NsPrefix(Namespace("my://namespace/one"), "ns1"), 3)
      module.functions.size === 3

    }

    "bunch bunch of modules" in {
      val modules = new ModuleCollection
      val builder = new ModuleBuilder(modules)

      val bunchOfModules: Seq[Module] = builder.buildBunchOfModules(3)


      modules.moduleList.size === 3
      modules.moduleList(0).nsPrefix.prefix === "ns3"
      modules.moduleList(1).nsPrefix.prefix === "ns2"
      modules.moduleList(2).nsPrefix.prefix === "ns1"
    }
  }
}
