package architecture_course.exceptionhandler

import architecture_course.command.Command
import architecture_course.command.LoggingCommand
import architecture_course.command.RepeatingCommand
import architecture_course.command.SecondRepeatingCommand
import architecture_course.logger.Logger
import java.util.Queue

class RetryTwiceHandler(
    private val queue: Queue<Command>,
    private val logger: Logger
) : ExceptionHandler {
    override fun handle(cmd: Command, exception: Exception) {
        val command = when (cmd) {
            is RepeatingCommand -> SecondRepeatingCommand(cmd)
            is SecondRepeatingCommand -> LoggingCommand(logger, cmd, exception)
            else -> RepeatingCommand(cmd)
        }

        queue.offer(command)
    }
}
