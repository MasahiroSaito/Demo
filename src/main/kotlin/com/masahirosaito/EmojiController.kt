package com.masahirosaito

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
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
        deleteMessage(timestamp, channel_id)
        val payload = Payload("現在の絵文字数: ${getEmojis().emoji.size}")
        return GsonBuilder().setPrettyPrinting().create().toJson(payload)
    }

    data class Payload(val text: String)

    data class Emojis(val emoji: Map<String, String> = mapOf())

    private fun getEmojis(): Emojis {
        return Gson().fromJson(post(FormBody.Builder()
                .add("token", "xoxp-91820252256-108563521552-157982807905-62424e2e44665107e4b37afa199b7930")
                .add("pretty", "1")
                .build()
        ), Emojis::class.java) ?: Emojis()
    }

    private fun deleteMessage(ts: String, channel_id: String) {
        post(FormBody.Builder()
                .add("token", "xoxp-91820252256-108563521552-157982807905-62424e2e44665107e4b37afa199b7930")
                .add("ts", ts)
                .add("channel", channel_id)
                .add("pretty", "1")
                .build()
        )
    }

    private fun post(body: RequestBody): String {
        val client = OkHttpClient()
        val request = Request.Builder()
                .url("https://slack.com/api/emoji.list")
                .post(body)
                .build()
        val response = client.newCall(request).execute()
        return response.body().string()
    }
}
