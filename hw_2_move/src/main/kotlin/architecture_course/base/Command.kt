package architecture_course.base

import kotlin.jvm.Throws

interface Command {
    @Throws(Exception::class)
    fun execute()
}
