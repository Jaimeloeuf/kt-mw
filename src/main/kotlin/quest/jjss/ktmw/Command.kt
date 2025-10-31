package quest.jjss.ktmw

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("COMANDS")
data class Command(@Id val id: String, val command: String, val description: String)
