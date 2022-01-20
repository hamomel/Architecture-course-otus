package architecture_course.command

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import kotlin.test.Test

class RepeatingCommandTest {
    private val failedCommand = mock(Command::class.java)

    private val commandUnderTest = RepeatingCommand(failedCommand)

    @Test
    fun `should execute failed command`() {
        commandUnderTest.execute()

        verify(failedCommand).execute()
    }
}
