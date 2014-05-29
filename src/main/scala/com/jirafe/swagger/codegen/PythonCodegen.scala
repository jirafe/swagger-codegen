package com.jirafe.swagger.codegen

import com.wordnik.swagger.codegen.BasicPythonGenerator

object PythonCodegen extends BasicPythonGenerator {
  def main(args: Array[String]) = generateClient(args)

  override def resourceNameFromFullPath(apiPath: String) = {
    // Ignore the first
    apiPath.split("/")(2).split("\\.")(0).replaceAll("/", "")
  }


}
