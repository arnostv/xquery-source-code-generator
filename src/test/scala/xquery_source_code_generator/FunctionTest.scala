package xquery_source_code_generator


class FunctionTest extends org.specs2.mutable.Specification {

  "Function body" should {
      "be empty for function body only with namespace" in {
        FunctionBody("functionOne").renderedSource ===
          """declare function functionOne() {
             |  ()
             |};""".stripMargin
      }

      "contain function call" in {
        FunctionBody("funcTwo").copy(calls = List(FunctionCall("functX", NsPrefix(Namespace("targetNs"),"n1"), List()))).renderedSource ===
         """declare function funcTwo() {
            |  n1:functX()
            |};""".stripMargin
      }

      "make sequence for result of multiple function calls" in {
        val call1: FunctionCall = FunctionCall("funct1", NsPrefix(Namespace("targetNs"), "n1"), List())
        val call2: FunctionCall = FunctionCall("funct2", NsPrefix(Namespace("targetNs"), "n1"), List())
        FunctionBody("funcTwo").copy(calls = List(call1, call2)).renderedSource ===
         """declare function funcTwo() {
            |  (  n1:funct1(),
            |  n1:funct2())
            |};""".stripMargin
      }

      "have required number of parameters" in {
        FunctionBody(name = "fun1", params = 3).renderedSource ===
          """declare function fun1($par1, $par2, $par3) {
            |  ()
            |};""".stripMargin
      }

      "have required parameters in function call" in {
        val functionCall: FunctionCall = FunctionCall("funWithPar", NsPrefix(Namespace("targetNs"), "n1"), List("'Hello'", "10"))
        FunctionBody("funcA").copy(calls = List(functionCall)).renderedSource ===
          """declare function funcA() {
            |  n1:funWithPar('Hello', 10)
            |};""".stripMargin
      }
  }

}
