package com.aproperfox.kameracore

import android.hardware.Camera
import kotlinx.coroutines.delay

class TestCamera : CameraWrapper {

  private lateinit var camera: Camera

  override suspend fun open() : CameraResult {
    camera = try {
      Camera.open()
    } catch (e: Exception) {
      e.printStackTrace()
      delay(1000)
      try {
        Camera.open()
      } catch (e2: Exception) {
        return CameraResult.Error(e2.message ?: "Error opening camera.")
      }
    }
    return CameraResult.Success
  }

  override fun takePicture() {
  }

  override fun startPreview() {
  }

  override fun toggleFlash(): Boolean {
    return false
  }

  override fun stopPreview() {
  }
}