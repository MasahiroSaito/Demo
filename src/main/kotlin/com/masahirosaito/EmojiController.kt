package com.masahirosaito

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EmojiController {

    @RequestMapping(value = "/emoji", method = arrayOf(RequestMethod.POST))
    fun index(
            @RequestParam token: String = "",
            @RequestParam team_id: String = "",
            @RequestParam team_domain: String = "",
            @RequestParam channel_id: String = "",
            @RequestParam channel_name: String = "",
            @RequestParam timestamp: String = "",
            @RequestParam user_id: String = "",
            @RequestParam user_name: String = "",
            @RequestParam text: String = "",
            @RequestParam trigger_word: String = ""
    ): String {
        return "{}"
    }
}
