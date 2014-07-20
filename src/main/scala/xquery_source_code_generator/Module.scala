package xquery_source_code_generator

case class Module (
  nsPrefix: NsPrefix,
  functions: List[FunctionBody]
) extends SourceRenderer {
  override def renderedSource: String = {

    val calledNs = (for (fun <- functions; call <- fun.calls) yield {
      call.namespace
    }).toSet

    val imports = for (ns <- calledNs) yield {
      val q = '"'
      s"import module namespace ${ns.prefix} = $q${ns.namespace.uri}$q;"
    }

    val importsStr = if (imports.size>0) imports.mkString("\n","\n", "\n")  else ""

    val header = s"""|module namespace ${nsPrefix.prefix} = "${nsPrefix.namespace.uri}";
                     |$importsStr
                     |""".stripMargin

    val functionsRendered: List[String] = functions.map(_.renderedSource)

    header + functionsRendered.mkString("\n\n")
   }
}