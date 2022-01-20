package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.LoggingCommand
import architecture_course.logger.Logger
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import java.io.IOException
import java.util.ArrayDeque
import java.util.Queue

class LoggingHandlerTest {
    private val logger: Logger = Mockito.mock(Logger::class.java)
    private val queue: Queue<Command> = ArrayDeque()

    private val handler = LoggingHandler(
        logger = logger,
        queue = queue
    )

    @Test
    fun `should put logging command into queue`() {

        handler.handle(Mockito.mock(Command::class.java), IOException())

        val queued = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(LoggingCommand::class, queued::class)
    }
}
