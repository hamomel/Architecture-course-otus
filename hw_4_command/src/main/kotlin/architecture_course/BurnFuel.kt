package architecture_course

import architecture_course.base.Command

class BurnFuel(
    private val fuelBurner: FuelBurner
) : Command {
    override fun execute() {
        fuelBurner.fuelLevel = fuelBurner.fuelLevel - fuelBurner.fuelConsumption
    }
}
