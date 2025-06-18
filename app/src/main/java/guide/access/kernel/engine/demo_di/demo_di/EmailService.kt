package guide.access.kernel.engine.demo_di.demo_di

import android.util.Log

//normal
//class EmailService {
//    fun sendMessage(message: String){
//        Log.d("TAG_LOGGER"," sendMessage : $message")
//    }
//}

class EmailService : MessageService {
    override fun sendMessage(message: String) {
        Log.d("TAG_LOGGER", " sendMessage : $message")
    }
}