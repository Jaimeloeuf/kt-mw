package quest.jjss.ktmw

import org.springframework.data.repository.CrudRepository

interface CommandRepository : CrudRepository<Command, String>
