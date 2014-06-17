package xquery_source_code_generator


class FunctionBodyTest extends org.specs2.mutable.Specification {

  "Function body" should {
      "be empty for function body only with namespace" in {
        FunctionBody("functionOne").renderedSource ===
          """declare function functionOne() {
             |  ()
             |};""".stripMargin
      }

      "contain function call" in {
        FunctionBody("funcTwo").copy(calls = List(FunctionCall("functX", NsPrefix("targetNs","n1")))).renderedSource ===
         """declare function funcTwo() {
            |  n1:functX()
            |};""".stripMargin
      }
  }

}
