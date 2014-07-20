package xquery_source_code_generator

import org.specs2.mutable.Specification


class NamespaceGeneratorTest extends Specification {
  "Namespace generator" should {
    "generate sequence of namespaces" in {
      val generator = new NamespaceGenerator

      val ns1 = generator.nextNamespace
      val ns2 = generator.nextNamespace
      val ns3 = generator.nextNamespace
      val exp1 = NsPrefix(Namespace("ns1.xq"), "ns1")
      val exp2 = NsPrefix(Namespace("ns2.xq"), "ns2")
      val exp3 = NsPrefix(Namespace("ns3.xq"), "ns3")

      List(ns1, ns2, ns3) === List(exp1, exp2, exp3)

    }
  }

}
