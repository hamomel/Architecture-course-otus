package architecture_course

import architecture_course.Rotatable.Companion.DIR_COUNT_PARAM_NAME
import architecture_course.Rotatable.Companion.DIRECTION_PARAM_NAME
import architecture_course.Rotatable.Companion.SPEED_PARAM_NAME
import architecture_course.base.Command
import architecture_course.base.UObject

interface Rotatable {
    var direction: Int
    var speed: Int
    var directionsCount: Int

    companion object {
        const val DIRECTION_PARAM_NAME = "direction"
        const val SPEED_PARAM_NAME = "speed"
        const val DIR_COUNT_PARAM_NAME = "directions_count"
    }
}

class RotatableAdapter(
    private val uObject: UObject
) : Rotatable {
    override var direction: Int
        get() = uObject.getParam(DIRECTION_PARAM_NAME)
        set(value) {
            uObject.setParam(DIRECTION_PARAM_NAME, value)
        }

    override var speed: Int
        get() = uObject.getParam(SPEED_PARAM_NAME)
        set(value) {
            uObject.setParam(SPEED_PARAM_NAME, value)
        }

    override var directionsCount: Int
        get() = uObject.getParam(DIR_COUNT_PARAM_NAME)
        set(value) {
            uObject.setParam(DIR_COUNT_PARAM_NAME, value)
        }
}

class Rotate(
    private val rotatable: Rotatable
) : Command {
    override fun execute() {
        rotatable.direction = (rotatable.direction + rotatable.speed) % rotatable.directionsCount
    }
}
