package xquery_source_code_generator


class NamespaceGenerator {
  var nsCounter = 0

  def nextNamespace: NsPrefix = {
    nsCounter = nsCounter + 1
    NsPrefix(Namespace(s"ns$nsCounter.xq"), s"ns$nsCounter")
  }

}
