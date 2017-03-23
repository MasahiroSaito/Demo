package com.masahirosaito

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
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
        val payload = Payload("現在の絵文字数: ${getEmojis().emoji.size}")
        return GsonBuilder().setPrettyPrinting().create().toJson(payload)
    }

    data class Payload(val text: String)

    data class Emojis(val emoji: Map<String, String> = mapOf())

    private fun getEmojis() = Gson().fromJson(post(), Emojis::class.java) ?: Emojis()

    private fun post(): String {
        val client = OkHttpClient()
        val body = FormBody.Builder()
                .add("token", "xoxp-91820252256-108563521552-157982807905-62424e2e44665107e4b37afa199b7930")
                .add("pretty", "1")
                .build()
        val request = Request.Builder()
                .url("https://slack.com/api/emoji.list")
                .post(body)
                .build()
        val response = client.newCall(request).execute()
        return response.body().string()
    }
}
