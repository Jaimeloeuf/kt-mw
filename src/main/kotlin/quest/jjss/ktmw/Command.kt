package quest.jjss.ktmw

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("COMMANDS")
data class Command(
    @Id val id: String,
    val command: String,
    val description: String
) {
    constructor(command: String, description: String) : this(UUID.randomUUID().toString(), command, description)
}
