package architecture_course

import architecture_course.FuelBurner.Companion.FUEL_CONSUMPTION
import architecture_course.FuelBurner.Companion.FUEL_LEVEL
import architecture_course.base.UObject

interface FuelBurner {
    var fuelLevel: Int
    var fuelConsumption: Int

    companion object {
        const val FUEL_LEVEL = "fuel_level"
        const val FUEL_CONSUMPTION = "fuel_consumption"
    }
}

class FuelBurnerAdapter(
    private val uObject: UObject
): FuelBurner {
    override var fuelLevel: Int
        get() = uObject.getParam(FUEL_LEVEL)
        set(value) {
            uObject.setParam(FUEL_LEVEL, value)
        }

    override var fuelConsumption: Int
        get() = uObject.getParam(FUEL_CONSUMPTION)
        set(value) {
            uObject.setParam(FUEL_CONSUMPTION, value)
        }
}
