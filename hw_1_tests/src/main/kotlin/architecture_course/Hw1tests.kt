package architecture_course

import kotlin.math.abs
import kotlin.math.sqrt

private const val E = 2 * Double.MIN_VALUE
/**
 * Solves square equations (aX^2 + bX + c = 0)
 * Solvation algorithm:
 *
 * if a = 0 it is not a square equation. Should throw exception
 *
 * D = b^2 - 4ac
 *
 * if D > 0
 *     x1 = (-b + sqrt(D)) / 2a
 *     x2 = (-b - sqrt(D)) / 2a
 *
 * if D = 0
 *     x1 = x2 = -b / 2a
 *
 * if D < 0
 *     no roots
 */
fun squareEquation(a: Double, b: Double, c: Double): DoubleArray {
    if (a.isNaN() || b.isNaN() || c.isNaN()) {
        throw IllegalArgumentException("arguments must not be NaN")
    }

    if (a.isInfinite() || b.isInfinite() || c.isInfinite()) {
        throw IllegalArgumentException("arguments must not be infinite")
    }

    if (abs(a) <= E) {
        throw IllegalArgumentException("a = 0, it is not a square equation")
    }

    val D = b * b - 4 * a * c

    if (D < -E) {
        return DoubleArray(0)
    } else if (abs(D) <= E) {
        val root = -b / (2 * a)

        return doubleArrayOf(root, root)
    } else {
        val root1 = (-b + sqrt(D)) / (2 * a)
        val root2 = (-b - sqrt(D)) / (2 * a)

        return doubleArrayOf(root1, root2)
    }
}

