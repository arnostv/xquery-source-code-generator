package xquery_source_code_generator

import java.io.{File, FileWriter}

object QXApp {

  val generatorRootDirectory = cleanGeneratedOutputDir()

  def cleanGeneratedOutputDir() = {
    val dir = new File("generator-output")
    if (!dir.isDirectory) {
      throw new RuntimeException("Directory " + dir.getCanonicalPath + " does not exist")
    }

    for (file <- dir.listFiles()) {
      file.delete()
    }

    dir
  }


  def main(args: Array[String]) = {
    val collection = new ModuleCollection

    val builder = new ModuleBuilder(collection)
    val modules: Seq[Module] = builder.buildBunchOfModules(4)

    for (module <- modules) {
      println(module.nsPrefix.namespace)
      val toFile: File = nsPrefixToFile(module.nsPrefix)
      println(toFile)

      val writer = new FileWriter(toFile)
      writer.write(module.renderedSource)
      writer.close()
    }

    def nsPrefixToFile(nsPrefix: NsPrefix): File = {
      val last = nsPrefix.namespace.uri.split("/").last

      new File(generatorRootDirectory, last + ".xq")
    }

  }

}
