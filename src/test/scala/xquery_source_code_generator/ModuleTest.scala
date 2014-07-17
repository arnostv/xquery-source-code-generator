package xquery_source_code_generator

import org.specs2.mutable.Specification


class ModuleTest extends Specification {
  "Single module" should {
    "contain one empty function" in {
       val function = FunctionBody("functOne")
       val module = Module(NsPrefix(Namespace("nsone"),"moduleA"), List(function))

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
      val ns = NsPrefix(Namespace("ns-one"), "moduleA")

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

    "import namespaces for function call to other module" in {
      val call1 = FunctionCall("func1", TestData.ns1, List())
      val call2 = FunctionCall("func2", TestData.ns2, List())
      val calls = List(call1, call2)
      val fun1 = FunctionBody("funOne", calls)
      val ns = NsPrefix(Namespace("ns-one"), "moduleA")

      val module = Module(ns, List(fun1))

      module.renderedSource ===
        """module namespace moduleA = "ns-one";
          |
          |import module namespace ns1 "my://ns1";
          |import module namespace ns2 "my://ns2";
          |
          |declare function funOne() {
          |  (  ns1:func1(),
          |  ns2:func2())
          |};""".stripMargin

    }
  }
}
