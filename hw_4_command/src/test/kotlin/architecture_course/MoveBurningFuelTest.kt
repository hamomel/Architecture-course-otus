package architecture_course

import org.mockito.Mockito.`when`
import org.mockito.Mockito.inOrder
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoInteractions
import kotlin.test.Test

class MoveBurningFuelTest {
    private val checkFuel: CheckFuel = mock(CheckFuel::class.java)
    private val move: Move = mock(Move::class.java)
    private val burnFuel: BurnFuel = mock(BurnFuel::class.java)

    private val command = MoveBurningFuel(
        checkFuel, move, burnFuel
    )

    @Test
    fun `should execute all commands`() {
        command.execute()

        verify(checkFuel).execute()
        verify(move).execute()
        verify(burnFuel).execute()
    }

    @Test
    fun `should execute all commands in order`() {
        command.execute()

        val inOrder = inOrder(checkFuel, move, burnFuel)
        inOrder.verify(checkFuel).execute()
        inOrder.verify(move).execute()
        inOrder.verify(burnFuel).execute()
    }

    @Test
    fun `should not move if no fuel available`() {
        `when`(checkFuel.execute()).thenThrow(NoFuelException())

        try {
            command.execute()
        } catch (e: Exception) {
            // nothing to do here
        }

        verifyNoInteractions(move)
    }
}
