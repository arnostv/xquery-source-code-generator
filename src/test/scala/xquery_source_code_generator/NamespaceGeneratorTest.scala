package xquery_source_code_generator

import org.specs2.mutable.Specification


class NamespaceGeneratorTest extends Specification {
  "Namespace generator" should {
    "generate sequence of namespaces" in {
      val generator = new NamespaceGenerator

      val ns1 = generator.nextNamespace
      val ns2 = generator.nextNamespace
      val ns3 = generator.nextNamespace
      val exp1 = NsPrefix(Namespace("my://ns1"), "ns1")
      val exp2 = NsPrefix(Namespace("my://ns2"), "ns2")
      val exp3 = NsPrefix(Namespace("my://ns3"), "ns3")

      List(ns1, ns2, ns3) === List(exp1, exp2, exp3)

    }
  }

}
