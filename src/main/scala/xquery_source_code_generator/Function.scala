package xquery_source_code_generator

case class FunctionBody(name: String, calls: List[FunctionCall] = List(), params: Int = 0) extends SourceRenderer {

  override def renderedSource: String = {
    val paramsText = (for (i <- 1 to params) yield ("$par" + i)).mkString(", ")
    val declaration = s"declare function $name($paramsText) {"

    def resultSequence: String = {
      calls.map("  " + _.renderedSource).mkString(",\n")
    }

    val callsRendered: String = calls.size match {
      case 0 => "  ()"
      case 1 => resultSequence
      case _ => "  (" + resultSequence + ")"
    }

    declaration + "\n" + callsRendered + "\n};"
  }

}

case class FunctionCall(targetName: String, namespace: NsPrefix) extends SourceRenderer {
  override def renderedSource: String = namespace.prefix + ":" + targetName + "()"
}
