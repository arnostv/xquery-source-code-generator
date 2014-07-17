package xquery_source_code_generator

import org.specs2.mutable.Specification


class ModuleCollectionTest extends Specification {
  "register module" should {
    "register empty module" in {
      val moduleCollection = new ModuleCollection
      val module = Module(NsPrefix(Namespace("my://ns"), "ns1"), List())
      moduleCollection.registerModule(module) === Module(NsPrefix(Namespace("my://ns"), "ns1"), List())
    }

  }

  "list registered modules" should {
    "provide registered modules" in {
      val moduleCollection = new ModuleCollection
      val moduleA = Module(NsPrefix(Namespace("my://nsA"), "nsA"), List())
      val moduleB = Module(NsPrefix(Namespace("my://nsB"), "nsB"), List())

      moduleCollection.registerModule(moduleA)
      moduleCollection.registerModule(moduleB)


      moduleCollection.moduleList === List(moduleB, moduleA)
    }
  }

}
