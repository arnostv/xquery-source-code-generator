package xquery_source_code_generator

class ModuleBuilder(modules:ModuleCollection) {

  def buildModule(nsPrefix: NsPrefix): Module = {
    Module(nsPrefix, List())
  }

}
