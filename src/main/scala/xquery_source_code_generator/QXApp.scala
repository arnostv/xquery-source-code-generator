package xquery_source_code_generator

object QXApp {

  def main(args: Array[String]) = {
    val collection = new ModuleCollection
    val builder = new ModuleBuilder(collection)

    val module: Module = builder.buildModule(NsPrefix(Namespace("my://ns1"), "ns1"), 3)
    println(module.renderedSource)

    collection.registerModule(module)


  }

}
