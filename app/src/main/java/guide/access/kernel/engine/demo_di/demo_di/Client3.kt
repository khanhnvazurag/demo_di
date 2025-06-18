package guide.access.kernel.engine.demo_di.demo_di

class Client3() {

    //setter inject
    private var messageService: MessageService? = null
    fun setMessageService(messageService: MessageService) {
        this.messageService = messageService
    }

    fun progressMessage(message: String) {
        messageService?.sendMessage(message)
    }
}