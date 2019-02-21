package com.aproperfox.kameratestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.aproperfox.kameracore.CameraResult
import com.aproperfox.kameracore.CameraWrapper
import com.aproperfox.kameracore.TestCamera
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

  lateinit var camera: CameraWrapper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    camera = TestCamera()
    openCamera()
  }

  private fun openCamera() {
    GlobalScope.launch(Dispatchers.Main) {
      val result = withContext(Dispatchers.Default) {
        camera.open()
      }
      val text = when (result) {
        CameraResult.Success -> "Success!"
        is CameraResult.Error -> "Error: ${result.message}"
      }
      Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }
  }
}
