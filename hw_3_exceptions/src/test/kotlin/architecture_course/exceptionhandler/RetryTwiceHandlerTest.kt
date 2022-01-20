package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.LoggingCommand
import architecture_course.command.RepeatingCommand
import architecture_course.command.SecondRepeatingCommand
import architecture_course.logger.Logger
import org.junit.Assert.*
import org.mockito.Mockito.mock
import java.util.ArrayDeque
import java.util.Queue
import kotlin.test.Test

class RetryTwiceHandlerTest {
    private val queue: Queue<Command> = ArrayDeque()
    private val logger: Logger = mock(Logger::class.java)

    private val handler = RetryTwiceHandler(queue, logger)

    @Test
    fun `should put repeating command when command is other`() {
        val command = mock(Command::class.java)

        handler.handle(command, Exception())

        val outCommand = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(RepeatingCommand::class, outCommand::class)
    }

    @Test
    fun `should put second repeating command when command is repeating`() {
        val command = RepeatingCommand(mock(Command::class.java))

        handler.handle(command, Exception())

        val outCommand = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(SecondRepeatingCommand::class, outCommand::class)
    }

    @Test
    fun `should put logging command when command is second repeating`() {
        val command = SecondRepeatingCommand(mock(Command::class.java))

        handler.handle(command, Exception())

        val outCommand = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(LoggingCommand::class, outCommand::class)
    }
}
