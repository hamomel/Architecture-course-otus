package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.LoggingCommand
import architecture_course.command.RepeatingCommand
import architecture_course.logger.Logger
import org.junit.Assert.*
import org.mockito.Mockito.mock
import java.util.ArrayDeque
import java.util.Queue
import kotlin.test.Test

class RetryOrLogHandlerTest {
    private val queue: Queue<Command> = ArrayDeque()
    private val logger: Logger = mock(Logger::class.java)

    private val handler = RetryOrLogHandler(queue, logger)

    @Test
    fun `should put repeating command into queue when failing is not repeating`() {
        val failedCommand = mock(Command::class.java)

        handler.handle(failedCommand, Exception())

        val outCommand = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(RepeatingCommand::class, outCommand::class)
    }

    @Test
    fun `should put logging command into queue when failing is repeating`() {
        val failedCommand = RepeatingCommand(mock(Command::class.java))

        handler.handle(failedCommand, Exception())

        val outCommand = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(LoggingCommand::class, outCommand::class)
    }
}
