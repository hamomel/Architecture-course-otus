package architecture_course.command

class RepeatingCommand(
    private val command: Command
): Command {

    override fun execute() {
        command.execute()
    }
}
