package architecture_course

import architecture_course.base.Command
import architecture_course.base.CommandException

class CheckFuel(
    private val fuelBurner: FuelBurner
) : Command {

    @Throws(NoFuelException::class)
    override fun execute() {
        if (fuelBurner.fuelLevel <= fuelBurner.fuelConsumption) {
            throw NoFuelException()
        }
    }
}

class NoFuelException : CommandException("no more fuel left")
