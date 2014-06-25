package xquery_source_code_generator

case class FunctionBody(name: String, calls: List[FunctionCall] = List()) extends SourceRenderer {

  override def renderedSource: String = {
    val declaration = s"declare function $name() {"

    val callsRendered: String =
      if (calls.isEmpty) {
        "  ()"
      } else {
        calls.map("  " + _.renderedSource).mkString("\n")
      }

    declaration + "\n" + callsRendered + "\n};"
  }

}

case class FunctionCall(targetName: String, namespace: NsPrefix) extends SourceRenderer {
  override def renderedSource: String = namespace.prefix + ":" + targetName + "()"
}
