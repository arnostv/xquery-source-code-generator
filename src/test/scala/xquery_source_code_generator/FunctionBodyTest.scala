package xquery_source_code_generator


class FunctionBodyTest extends org.specs2.mutable.Specification {

  "Function body" should {
      "be empty for function body only with name" in {
        FunctionBody("functionOne").renderedSource ===
          """
            |declare function functionOne() {
            |  ()
            |}""".stripMargin
      }
  }

}
