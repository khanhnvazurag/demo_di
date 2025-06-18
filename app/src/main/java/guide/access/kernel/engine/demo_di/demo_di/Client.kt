package guide.access.kernel.engine.demo_di.demo_di

class Client(private val messageService: MessageService) {

//    private val emailService = EmailService()
//    private val smsService = SMSService() //add

    fun progressMessage(message: String) {
        messageService.sendMessage(message)
    }
}