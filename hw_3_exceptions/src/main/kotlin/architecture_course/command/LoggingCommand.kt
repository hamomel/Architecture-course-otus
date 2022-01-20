package architecture_course.command

import architecture_course.logger.Logger

class LoggingCommand(
    private val logger: Logger,
    private val command: Command,
    private val exception: Exception
) : Command {
    override fun execute() {
        logger.logE(command, exception)
    }
}
