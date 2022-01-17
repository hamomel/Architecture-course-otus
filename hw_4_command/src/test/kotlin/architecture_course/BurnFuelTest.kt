package architecture_course

import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import kotlin.test.Test

class BurnFuelTest {
    private val fuelBurner = mock(FuelBurner::class.java)

    private val command = BurnFuel(fuelBurner)

    @Test
    fun `should subtract fuel level`() {
        Mockito.`when`(fuelBurner.fuelLevel).then { 10 }
        Mockito.`when`(fuelBurner.fuelConsumption).then { 5 }

        command.execute()

        verify(fuelBurner).fuelLevel = 5
    }
}
