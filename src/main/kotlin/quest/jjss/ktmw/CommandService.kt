package quest.jjss.ktmw

import org.springframework.stereotype.Service

@Service
class CommandService(private val db: CommandRepository) {
    fun findCommands(): List<Command> = db.findAll().toList()

    fun save(command: Command): Command = db.save(command)

    fun doesCommandExist(command: String): Boolean =
        db.findByCommandLike(command).isNotEmpty()

    fun delete(id: String): Boolean {
        // @todo Handle this exception
        db.deleteById(id)
        return true
    }
}
