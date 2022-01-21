package architecture_course.base

open class MacroCommand(
    private vararg val commands: Command
) : Command {
    override fun execute() {
        var executingCommand: Command? = null

        try {
            commands.forEach { cmd ->
                executingCommand = cmd
                cmd.execute()
            }
        } catch (e: Exception) {
            throw MacroCommandException(
                causeCommand = executingCommand,
                cause = e,
                message = "something went wrong"
            )
        }
    }
}
class MacroCommandException(
    val causeCommand: Command?,
    override val cause: Exception,
    override val message: String
) : CommandException(message)
