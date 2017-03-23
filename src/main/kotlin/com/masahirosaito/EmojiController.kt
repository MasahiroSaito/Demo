package com.masahirosaito

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EmojiController {

    @RequestMapping(value = "/emoji/", method = arrayOf(RequestMethod.POST))
    fun index(@RequestParam param: String): String {
        return param
    }
}
