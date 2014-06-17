package xquery_source_code_generator

case class Module (
  nsPrefix: String,
  namespace: String,
  functions: List[FunctionBody]
) extends SourceRenderer {
  override def renderedSource: String = {
    val header = s"""|module namespace ${nsPrefix} = "${namespace}";
                     |
                     |""".stripMargin

    val functionsRendered: List[String] = functions.map(_.renderedSource)

    header + (functionsRendered.mkString("\n"))
   }
}