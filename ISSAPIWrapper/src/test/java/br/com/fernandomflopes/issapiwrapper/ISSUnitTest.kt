package br.com.fernandomflopes.issapiwrapper

import br.com.fernandomflopes.issapiwrapper.iss.ISS
import br.com.fernandomflopes.issapiwrapper.model.ISSNow
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Test

import org.junit.Assert.*

class ISSUnitTest {
    @Test
    fun addition_isCorrect() {
        val iss = ISS().getNow()

        assertTrue(iss.message == "success")
    }
}