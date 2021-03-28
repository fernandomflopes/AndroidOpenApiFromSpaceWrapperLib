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

        lifecycleScope.launch {
            ISS().getNow(3000).collect {

                binding.txtLongitude.text = it.position.longitude.toString()
                binding.txtLatitude.text = it.position.latitude.toString()

            }
        }

    }
}