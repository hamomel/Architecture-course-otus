package architecture_course.base

class UObject(
    private val params: MutableMap<String, Any>
) {
    fun <T> getParam(name: String): T = params[name] as? T
        ?: throw IllegalArgumentException("there is no param with name $name")

    fun setParam(name: String, param: Any) {
        params[name] = param
    }
}
