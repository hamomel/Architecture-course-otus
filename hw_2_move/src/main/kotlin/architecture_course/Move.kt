package architecture_course

import architecture_course.Movable.Companion.POSITION_PARAM_NAME
import architecture_course.Movable.Companion.SPEED_PARAM_NAME
import architecture_course.base.Command
import architecture_course.base.Coordinates
import architecture_course.base.UObject

interface Movable {
    var position: Coordinates
    var speed: Coordinates

    companion object {
        const val POSITION_PARAM_NAME = "position"
        const val SPEED_PARAM_NAME = "speed"

    }
}

class Move(
    private val movable: Movable
) : Command {
    override fun execute() {
        movable.position =  Coordinates(
            x = movable.position.x + movable.speed.x,
            y = movable.position.y + movable.speed.y
        )
    }
}

class MovableAdapter(
    private val uObject: UObject
) : Movable {
    override var position: Coordinates
        get() = uObject.getParam(POSITION_PARAM_NAME)
        set(value) {
            uObject.setParam(POSITION_PARAM_NAME, value)
        }

    override var speed: Coordinates
        get() = uObject.getParam(SPEED_PARAM_NAME)
        set(value) {
            uObject.setParam(SPEED_PARAM_NAME, value)
        }
}
