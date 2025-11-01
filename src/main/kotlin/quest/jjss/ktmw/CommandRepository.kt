package quest.jjss.ktmw

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface CommandRepository : CrudRepository<Command, String> {
    @Query("SELECT c FROM Command c WHERE c.command LIKE %:command%")
    fun findByCommandLike(@Param("command") command: String): List<Command>
}
