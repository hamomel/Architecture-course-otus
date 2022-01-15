package architecture_course.command

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SecondRepeatingCommandTest {
    private val failedCommand = mock(Command::class.java)

    private val commandUnderTest = RepeatingCommand(failedCommand)

    @Test
    fun `should execute failed command`() {
        commandUnderTest.execute()

        verify(failedCommand).execute()
    }
}
