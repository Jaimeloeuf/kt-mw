package quest.jjss.ktmw

import org.springframework.stereotype.Service

@Service
class CommandService(private val db: CommandRepository) {
    fun findCommands(): List<Command> = db.findAll().toList()

    fun delete(id: String): Boolean {
        // @todo Handle this exception
        db.deleteById(id)
        return true
    }
}
