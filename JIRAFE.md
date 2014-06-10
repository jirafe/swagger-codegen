# Jirafe Build Instructions

Follow directions in README to download and install swagger-codegen, after running `./sbt assembly` follow these instructions

## Ruby
1. `./bin/runscala.sh  com.jirafe.swagger.codegen.RubyCodegen https://event.jirafe.com/api-docs`
2. replace `jirafe/jirafe-ruby/lib` with `generated-code/ruby/lib`

## PHP
1. `./bin/runscala.sh  com.jirafe.swagger.codegen.PHPCodegen https://event.jirafe.com/api-docs`
2. replace contens of `jirafe/jirafe-php/src` with files from `generated-code/php/`


## Python
1. `./bin/runscala.sh  com.jirafe.swagger.codegen.PHPCodegen https://event.jirafe.com/api-docs`
2. replace contens of `jirafe/jirafe-python/jirafe` with files from `generated-code/python/`
