package xquery_source_code_generator

import org.specs2.mutable.Specification


class ModuleTest extends Specification {
  "Module" should {
    "contain one empty function" in {
       val function = FunctionBody("functOne")
       val module = Module("moduleA", "nsone", List(function))

       module.renderedSource === """module namespace moduleA = "nsone";
                                   |
                                   |
                                   |declare function functOne() {
                                   |  ()
                                   |};""".stripMargin
    }
  }
}
