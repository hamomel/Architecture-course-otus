package architecture_course.exceptionhandler

import architecture_course.command.Command

interface ExceptionHandler {
    fun handle(cmd: Command, exception: Exception)
}
