package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.RepeatingCommand
import java.util.Queue

class RepeatingHandler(
    private val queue: Queue<Command>
): ExceptionHandler {

    override fun handle(cmd: Command, exception: Exception) {
        val command = RepeatingCommand(cmd)
        queue.offer(command)
    }
}
