package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.RepeatingCommand
import org.junit.Assert.*
import org.mockito.Mockito.mock
import java.util.ArrayDeque
import java.util.Queue
import kotlin.test.Test

class RepeatingHandlerTest {
    private val queue: Queue<Command> = ArrayDeque()

    private val handler = RepeatingHandler(queue)

    @Test
    fun `should put repeating command into queue`() {
        val command = mock(Command::class.java)

        handler.handle(command, Exception())

        val queued = queue.peek()

        assertEquals(1, queue.size)
        assertEquals(RepeatingCommand::class, queued::class)
    }
}
