package architecture_course.command

import architecture_course.logger.Logger
import org.mockito.Mockito
import kotlin.test.Test

class LoggingCommandTest {
    private val logger: Logger = Mockito.mock(Logger::class.java)
    private val cmd: Command = Mockito.mock(Command::class.java)
    private val exception = Exception()

    private val underTest = LoggingCommand(logger, cmd, exception)

    @Test
    fun `should call logger on handle`() {
        underTest.execute()

        Mockito.verify(logger).logE(cmd, exception)
    }
}
