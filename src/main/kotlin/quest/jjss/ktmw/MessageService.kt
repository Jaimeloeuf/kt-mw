package quest.jjss.ktmw

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): Message? = db.findByIdOrNull(id)

    fun save(message: Message): Message {
        val savedMessage = db.save(message)

        if (savedMessage.text.startsWith('/')) {
            this.processCommandMessage(savedMessage)
        }

        return savedMessage
    }

    fun processCommandMessage(message: Message) {
        val command = message.text.split(' ').first().substring(1)
        println("Received command: $command")
    }

    fun delete(id: String): Boolean {
        // @todo Handle this exception
        db.deleteById(id)
        return true
    }
}
