package architecture_course.logger

import architecture_course.command.Command
import java.lang.Exception

interface Logger {
    fun logE(cmd: Command, exception: Exception)
}
