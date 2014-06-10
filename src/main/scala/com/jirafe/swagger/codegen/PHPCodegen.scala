package com.jirafe.swagger.codegen

import com.wordnik.swagger.codegen.BasicPHPGenerator

object PHPCodegen extends BasicPHPGenerator {
  def main(args: Array[String]) = generateClient(args)

  override def resourceNameFromFullPath(apiPath: String) = {
    // Ignore the first
    apiPath.split("/")(2).split("\\.")(0).replaceAll("/", "")
  }

  // package for models
  override def modelPackage = Some("")
}
