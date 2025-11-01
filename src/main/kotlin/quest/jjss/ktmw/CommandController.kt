package quest.jjss.ktmw

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/command")
class CommandController(private val service: CommandService) {
    @GetMapping
    fun listCommands() = service.findCommands()

    @GetMapping("/{id}")
    fun getMessage(@PathVariable id: String): ResponseEntity<Command> =
        service.findCommandById(id).toResponseEntity()

    private fun Command?.toResponseEntity(): ResponseEntity<Command> =
        // If the message is null (not found), set to 404
        this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun post(@RequestBody command: Command): ResponseEntity<Command> {
        val savedCommand = service.save(command)
        return ResponseEntity.created(URI("/command/${savedCommand.id}")).body(savedCommand)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Boolean> {
        return ResponseEntity.ok(service.delete(id))
    }
}