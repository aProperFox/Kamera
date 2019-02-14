package com.aproperfox.kameracore

interface CameraWrapper {
  fun takePicture()
  fun startPreview()
  fun toggleFlash(): Boolean
  fun stopPreview()
}