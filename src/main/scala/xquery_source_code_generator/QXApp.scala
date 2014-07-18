package xquery_source_code_generator

object QXApp {

  def main(args: Array[String]) = {
    val collection = new ModuleCollection

    val builder = new ModuleBuilder(collection)
    val modules: Seq[Module] = builder.buildBunchOfModules(4)

    for (module <- modules) {
      println(module.renderedSource)
    }
  }

}
