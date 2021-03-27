package br.com.fernandomflopes.issapiwrapper.iss

import br.com.fernandomflopes.issapiwrapper.model.ISSNow
import com.google.gson.Gson
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request

class ISS {

    private val NOW_URL = "http://api.open-notify.org/iss-now.json"

    private fun getResponse(url : String) = OkHttpClient()
            .newCall(Request.Builder().url(url).build())
            .execute()
            .body?.string()

    fun getNow() : ISSNow {
        val responseText = getResponse(NOW_URL)

        return Gson().fromJson(responseText, ISSNow::class.java)
    }

}