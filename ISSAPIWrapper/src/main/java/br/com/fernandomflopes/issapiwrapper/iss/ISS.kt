package br.com.fernandomflopes.issapiwrapper.iss

import br.com.fernandomflopes.issapiwrapper.model.ISSNow
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

    fun getNow(delayInMillis: Long) : Flow<ISSNow> {
        return flow<ISSNow> {
            while(true) {
                emit(getNow())
                delay(delayInMillis)
            }
        }.flowOn(Dispatchers.IO)
    }
}