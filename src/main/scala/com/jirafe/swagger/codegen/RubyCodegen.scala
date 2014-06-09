package com.jirafe.swagger.codegen

import com.wordnik.swagger.codegen.BasicRubyGenerator

import java.io.File

object RubyCodegen extends BasicRubyGenerator {
  def main(args: Array[String]) = generateClient(args)

  override def resourceNameFromFullPath(apiPath: String) = {
    // Ignore the first
    apiPath.split("/")(2).split("\\.")(0).replaceAll("/", "")
  }

  override def toApiName(name: String) = {
    name.replaceAll("\\{","").replaceAll("\\}", "") match {
      case s: String if(s.length > 0) => s(0).toUpper + s.substring(1) + "Api"
      case _ => "Api"
    }
  }

  // package for models
  override def modelPackage = Some("lib/jirafe")

  // package for apis
  override def apiPackage = Some("lib/jirafe")

  override def toModelFilename(name: String) = toUnderscore(name.replaceAll("(\\{|\\})",""))
  override def toApiFilename(name: String) = toUnderscore(name.replaceAll("(\\{|\\})","")) + "_api"

  override def toUnderscore(name: String): String = {
  	val underscored = super.toUnderscore(name)
  	if (underscored(0) == '_') underscored.substring(1)
  	else underscored
  }

  // supporting classes
  override def supportingFiles = List(
    ("monkey.mustache", destinationDir + File.separator + apiPackage.get, "monkey.rb"),
    ("swagger.mustache", destinationDir + File.separator + "lib", "jirafe.rb"),
    ("swagger" + File.separator + "configuration.mustache", destinationDir + File.separator + apiPackage.get, "configuration.rb"),
    ("swagger" + File.separator + "response.mustache", destinationDir + File.separator + apiPackage.get, "response.rb"),
    ("swagger" + File.separator + "version.mustache", destinationDir + File.separator + apiPackage.get, "version.rb"),
    ("swagger" + File.separator + "request.mustache", destinationDir + File.separator + apiPackage.get, "request.rb"))

}
