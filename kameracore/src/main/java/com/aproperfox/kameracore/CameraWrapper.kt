package com.aproperfox.kameracore

interface CameraWrapper {
  suspend fun open() : CameraResult
  fun takePicture()
  fun startPreview()
  fun toggleFlash(): Boolean
  fun stopPreview()
}