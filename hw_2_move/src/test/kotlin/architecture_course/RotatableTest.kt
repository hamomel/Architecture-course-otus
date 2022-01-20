package architecture_course

import architecture_course.base.UObject
import kotlin.test.Test
import kotlin.test.assertEquals

class RotatableTest {
    @Test
    fun `should rotate to expected position`() {
        val initialDirection = 1
        val dirCount = 8
        val speed = 5
        val expectedDirection = 6

        val uObject = UObject(
            mutableMapOf(
                Rotatable.DIRECTION_PARAM_NAME to initialDirection,
                Rotatable.SPEED_PARAM_NAME to speed,
                Rotatable.DIR_COUNT_PARAM_NAME to dirCount
            )
        )
        val rotatable = RotatableAdapter(uObject)
        val rotate = Rotate(rotatable)

        rotate.execute()

        assertEquals(expectedDirection, rotatable.direction)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw if direction is not set`() {
        val dirCount = 8
        val speed = 5

        val uObject = UObject(
            mutableMapOf(
                Rotatable.SPEED_PARAM_NAME to speed,
                Rotatable.DIR_COUNT_PARAM_NAME to dirCount
            )
        )
        val rotatable = RotatableAdapter(uObject)
        val rotate = Rotate(rotatable)

        rotate.execute()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw if speed is not set`() {
        val initialDirection = 1
        val dirCount = 8

        val uObject = UObject(
            mutableMapOf(
                Rotatable.DIRECTION_PARAM_NAME to initialDirection,
                Rotatable.DIR_COUNT_PARAM_NAME to dirCount
            )
        )
        val rotatable = RotatableAdapter(uObject)
        val rotate = Rotate(rotatable)

        rotate.execute()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw if direction count not set`() {
        val initialDirection = 1
        val speed = 5

        val uObject = UObject(
            mutableMapOf(
                Rotatable.DIRECTION_PARAM_NAME to initialDirection,
                Rotatable.SPEED_PARAM_NAME to speed,
            )
        )
        val rotatable = RotatableAdapter(uObject)
        val rotate = Rotate(rotatable)

        rotate.execute()
    }
}
