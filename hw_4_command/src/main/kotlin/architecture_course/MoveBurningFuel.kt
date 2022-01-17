package architecture_course

import architecture_course.base.MacroCommand

// как гарантировать что все переданные команды относятся к одному и тому же UObject?
class MoveBurningFuel(
    checkFuel: CheckFuel,
    move: Move,
    burnFuel: BurnFuel
) : MacroCommand(checkFuel, move, burnFuel)
