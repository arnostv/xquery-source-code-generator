package xquery_source_code_generator

case class FunctionBody (name: String) extends SourceRenderer {
  override def renderedSource: String =
   s"""
      |declare function $name() {
      |  ()
      |};""".stripMargin
}
