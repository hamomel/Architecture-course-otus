package architecture_course

import architecture_course.Movable.Companion.POSITION_PARAM_NAME
import architecture_course.Movable.Companion.SPEED_PARAM_NAME
import architecture_course.base.Coordinates
import architecture_course.base.UObject
import org.junit.Assert
import kotlin.test.Test

class MovableTest {

    @Test
    fun `should move to position`() {
        val initialPosition = Coordinates(12, 5)
        val expectedPosition = Coordinates(5, 8)
        val speed = Coordinates(-7, 3)

        val obj = UObject(
            mutableMapOf(
                POSITION_PARAM_NAME to initialPosition,
                SPEED_PARAM_NAME to speed
            )
        )
        val movable = MovableAdapter(obj)
        val move = Move(movable)

        move.execute()

        Assert.assertEquals(expectedPosition, movable.position)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw when position is not set`() {
        val speed = Coordinates(-7, 3)

        val obj = UObject(
            mutableMapOf(SPEED_PARAM_NAME to speed)
        )
        val movable = MovableAdapter(obj)
        val move = Move(movable)

        move.execute()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw when speed is not set`() {
        val initialPosition = Coordinates(12, 5)

        val obj = UObject(
            mutableMapOf(POSITION_PARAM_NAME to initialPosition)
        )
        val movable = MovableAdapter(obj)
        val move = Move(movable)

        move.execute()
    }
}
