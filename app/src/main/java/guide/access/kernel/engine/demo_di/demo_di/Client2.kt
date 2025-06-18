package guide.access.kernel.engine.demo_di.demo_di

class Client2 : InjectionMessage {

    private var messageService: MessageService? = null

    fun progressMessage(message: String) {
        messageService?.sendMessage(message)
    }

    //interface
    override fun setService(messageService: MessageService) {
        this.messageService = messageService
    }
}