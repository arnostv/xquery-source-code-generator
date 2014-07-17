package xquery_source_code_generator

class ModuleCollection {
  private var modules: List[Module] = List()


  def moduleList = modules

  def registerModule(module: Module): Module = {
    modules = module :: modules
    module
  }

}
