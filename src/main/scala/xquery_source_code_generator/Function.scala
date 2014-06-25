package xquery_source_code_generator

case class FunctionBody(name: String, calls: List[FunctionCall] = List()) extends SourceRenderer {

  override def renderedSource: String = {
    val declaration = s"declare function $name() {"

    val callsRendered: String =
      if (calls.isEmpty) {
        "  ()"
      } else {
        val map: List[String] = calls.map(x => "  " + x.namespace.prefix + ":" + x.targetName + "()")
        val s: String = map.mkString("\n")
        s
      }

    declaration + "\n" + callsRendered + "\n};"
  }

}

case class FunctionCall(targetName: String, namespace: NsPrefix)
