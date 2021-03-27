package br.com.fernandomflopes.iss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import androidx.lifecycle.lifecycleScope
import br.com.fernandomflopes.iss.databinding.ActivityMainBinding
import br.com.fernandomflopes.issapiwrapper.iss.ISS
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.webView.settings.javaScriptEnabled = true

        lifecycleScope.launch {
            ISS().getNow(3000).collect {

                binding.txtLongitude.text = it.position.longitude.toString()
                binding.txtLatitude.text = it.position.latitude.toString()
                binding.webView
                        .loadUrl("file:///android_asset/hello.html?lat=${it.position.latitude}&lng=${it.position.longitude}")
            }
        }

    }
}