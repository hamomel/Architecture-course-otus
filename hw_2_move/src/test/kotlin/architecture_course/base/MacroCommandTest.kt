package architecture_course.base

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoInteractions
import kotlin.test.Test

class MacroCommandTest {
    private val commands = List(5) { mock(Command::class.java) }

    private val macroCommand = MacroCommand(*commands.toTypedArray())

    @Test
    fun `should execute all commands`() {
        macroCommand.execute()

        commands.forEach { command ->
            verify(command).execute()
        }
    }

    @Test(expected = MacroCommandException::class)
    fun `should throw when command throws`() {
        `when`(commands[2].execute()).thenThrow(CommandException(""))

        macroCommand.execute()
        verify(commands[2]).execute()
        verifyNoInteractions(commands[3])
    }

    @Test
    fun `should not execute following commands when command throws`() {
        `when`(commands[2].execute()).thenThrow(CommandException(""))

        try {
            macroCommand.execute()
        } catch (e: Exception) {
            // nothing to do here
        }

        verify(commands[2]).execute()
        verifyNoInteractions(commands[3])
    }
}
