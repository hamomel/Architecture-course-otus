package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.LoggingCommand
import architecture_course.logger.Logger
import java.util.Queue

class LoggingHandler(
    private val logger: Logger,
    private val queue: Queue<Command>
) : ExceptionHandler {

    override fun handle(cmd: Command, exception: Exception) {
        val command = LoggingCommand(logger, cmd, exception)
        queue.offer(command)
    }
}
