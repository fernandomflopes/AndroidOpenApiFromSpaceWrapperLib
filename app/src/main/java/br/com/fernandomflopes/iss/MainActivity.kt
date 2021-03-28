package br.com.fernandomflopes.iss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import br.com.fernandomflopes.iss.databinding.ActivityMainBinding
import br.com.fernandomflopes.issapiwrapper.iss.ISS
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val ZOOM_LEVEL = 1f

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val mapFragment: SupportMapFragment? by lazy {
        supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            ISS().getNow(7000).collect {

                binding.txtLongitude.text = it.position.longitude.toString()
                binding.txtLatitude.text = it.position.latitude.toString()
                val position = LatLng(
                    it.position.latitude.toDouble(),
                    it.position.longitude.toDouble()
                )
                mapFragment?.getMapAsync {
                    it.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(position, ZOOM_LEVEL),
                        2000,
                        null
                    )
                    it.addMarker(MarkerOptions().position(position))
                }
            }
        }

    }

}