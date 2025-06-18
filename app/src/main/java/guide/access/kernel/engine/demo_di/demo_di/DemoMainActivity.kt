package guide.access.kernel.engine.demo_di.demo_di

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import guide.access.kernel.engine.demo_di.R

class DemoMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_demo_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //constructor inject
        val smsService = SMSService()
        val emailService = EmailService()
        val client = Client(emailService)
        client.progressMessage("Hello Work! Email")

        //interface injection
        val client2 = Client2()
        client2.setService(emailService)
        client2.progressMessage("Hello Work! Email")

        //setter injection
        val client3 = Client3()
        client3.setMessageService(emailService)
        client3.progressMessage("Hello Work! Email")

    }
}