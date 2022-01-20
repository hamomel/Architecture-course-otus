package architecture_course.command

class SecondRepeatingCommand(
    private val command: Command
) : Command {

    override fun execute() {
        command.execute()
    }
}
