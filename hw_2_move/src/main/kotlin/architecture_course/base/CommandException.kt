package architecture_course.base

open class CommandException(override val message: String) : Exception(message)
