package architecture_course

import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.Test

class CheckFuelTest {
    private val fuelBurner = mock(FuelBurner::class.java)

    private val command = CheckFuel(fuelBurner)

    @Test
    fun `should pass when fuel level is acceptable`() {
        `when`(fuelBurner.fuelLevel).then { 10 }
        `when`(fuelBurner.fuelConsumption).then { 5 }

        command.execute()
    }

    @Test(expected = NoFuelException::class)
    fun `should throw when fuel level is low`() {
        `when`(fuelBurner.fuelLevel).then { 5 }
        `when`(fuelBurner.fuelConsumption).then { 10 }

        command.execute()
    }
}
