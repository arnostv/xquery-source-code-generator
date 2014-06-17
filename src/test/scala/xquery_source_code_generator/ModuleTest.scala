package xquery_source_code_generator

import org.specs2.mutable.Specification


class ModuleTest extends Specification {
  "Single module" should {
    "contain one empty function" in {
       val function = FunctionBody("functOne")
       val module = Module(NsPrefix("nsone","moduleA"), List(function))

       module.renderedSource ===
         """module namespace moduleA = "nsone";
           |
           |declare function functOne() {
           |  ()
           |};""".stripMargin
    }

    "contain multiple functions" in {
      val fun1 = FunctionBody("funOne")
      val fun2 = FunctionBody("funTwo")
      val ns = NsPrefix("ns-one", "moduleA")

      val module = Module(ns, List(fun1, fun2))

      module.renderedSource ===
        """module namespace moduleA = "ns-one";
          |
          |declare function funOne() {
          |  ()
          |};
          |declare function funTwo() {
          |  ()
          |};""".stripMargin
    }
  }
}
