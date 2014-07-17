package xquery_source_code_generator

object QXApp {

  def main(args: Array[String]) = {
    val collection = new ModuleCollection

    val module1: Module = buildNewModule(collection, "ns1")
    println(module1.renderedSource)

    val module2: Module = buildNewModule(collection, "ns2")
    println(module2.renderedSource)

    val module3: Module = buildNewModule(collection, "ns3")
    println(module3.renderedSource)

    val module4: Module = buildNewModule(collection, "ns4")
    println(module4.renderedSource)



  }

  def buildNewModule(collection: ModuleCollection, ns: String): Module = {
    val builder = new ModuleBuilder(collection)
    val module: Module = builder.buildModule(NsPrefix(Namespace(s"my://$ns"), ns), 3)
    collection.registerModule(module)
    module
  }
}
