package com.sambalinski.jsonstorageservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import springfox.documentation.swagger2.annotations.EnableSwagger2

//@EnableSwagger2
@SpringBootApplication
class JsonStorageApplication

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<JsonStorageApplication>(*args)
}
