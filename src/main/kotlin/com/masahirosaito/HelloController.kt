package com.masahirosaito

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

//    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
//    fun index(@RequestParam token: String): String {
//        return "This is Spring Boot Application."
//    }

    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun index(@RequestParam param: String): String {
        return "Kotlin Spring Boot Application in Heroku."
    }
}
