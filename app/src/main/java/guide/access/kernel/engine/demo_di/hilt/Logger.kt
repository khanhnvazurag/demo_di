package guide.access.kernel.engine.demo_di.hilt

import android.util.Log

class Logger {
    fun log(message: String) {
        Log.d("Logger", "log: $message")
    }
}