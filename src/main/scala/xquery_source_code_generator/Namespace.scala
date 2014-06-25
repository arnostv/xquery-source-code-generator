package xquery_source_code_generator

case class Namespace(uri: String)

case class NsPrefix(namespace: Namespace, prefix: String)
