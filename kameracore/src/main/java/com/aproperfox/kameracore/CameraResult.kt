package com.aproperfox.kameracore

sealed class CameraResult {
  object Success : CameraResult()
  data class Error(val message: String) : CameraResult()
}