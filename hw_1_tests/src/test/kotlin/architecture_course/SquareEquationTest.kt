package architecture_course

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SquareEquationTest {

    @Test
    fun `should throw if a = 0`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is close to 0") {
            squareEquation(1e-323, 1.0, 1.0)
        }
    }

    @Test
    fun `should return empty array if equation has no roots`() {
        val roots = squareEquation(1.0, 0.0, 1.0)

        assertEquals(
            DoubleArray(0).size,
            roots.size,
            "actual roots size is ${roots.size} while expected 0 roots"
        )
    }

    @Test
    fun `roots should be equal when D = 0`() {
        val roots = squareEquation(1.0, 2.0, 1.0)

        assertEquals(roots.size, 2, "returned ${roots.size} roots when should be exactly 2")
        assertEquals(roots[0], roots[1], "roots ${roots.joinToString()} are not equal")
    }

    @Test
    fun `should return correct roots when equation has 2 equal roots`() {
        val roots = squareEquation(1.0, 2.0, 1.0)

        assertEquals(-1.0, roots[0], "root is ${roots[0]} while should be 0")
    }

    @Test
    fun `should return 2 root when equation has 2 different roots`() {
        val roots = squareEquation(1.0, 0.0, -1.0)

        assertEquals(roots.size, 2, "returned ${roots.size} roots when should be exactly 2")
    }

    @Test
    fun `should return correct roots when equation has 2 different roots`() {
        val roots = squareEquation(1.0, 0.0, -1.0)

        assertEquals(1.0, roots[0], "first root is ${roots[0]} while should be 1")
        assertEquals(-1.0, roots[1], "second root is ${roots[1]} while should be -1")
    }

    @Test
    fun `should throw when a is NaN`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is NaN") {
            squareEquation(Double.NaN, 1.0, 1.0)
        }
    }

    @Test
    fun `should throw when b is NaN`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is NaN") {
            squareEquation(1.0, Double.NaN,1.0)
        }
    }

    @Test
    fun `should throw when c is NaN`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is NaN") {
            squareEquation(1.0, 1.0, Double.NaN)
        }
    }

    @Test
    fun `should throw when a is infinity`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is positive infinity") {
            squareEquation(Double.POSITIVE_INFINITY, 1.0, 1.0)
        }
        assertFailsWith<IllegalArgumentException>("didn't fall when a is negative infinity") {
            squareEquation(Double.POSITIVE_INFINITY, 1.0, 1.0)
        }
    }

    @Test
    fun `should throw when b is infinity`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is positive infinity") {
            squareEquation( 1.0, Double.POSITIVE_INFINITY,1.0)
        }
        assertFailsWith<IllegalArgumentException>("didn't fall when a is negative infinity") {
            squareEquation( 1.0, Double.POSITIVE_INFINITY,1.0)
        }
    }
    @Test
    fun `should throw when c is infinity`() {
        assertFailsWith<IllegalArgumentException>("didn't fall when a is positive infinity") {
            squareEquation(1.0, 1.0, Double.POSITIVE_INFINITY)
        }
        assertFailsWith<IllegalArgumentException>("didn't fall when a is negative infinity") {
            squareEquation(1.0, 1.0, Double.POSITIVE_INFINITY)
        }
    }
}
