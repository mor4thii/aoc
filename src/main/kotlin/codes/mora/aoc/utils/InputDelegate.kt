package codes.mora.aoc.utils

import org.springframework.util.ResourceUtils
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class InputDelegate : ReadOnlyProperty<Any, List<String>> {
    override fun getValue(thisRef: Any, property: KProperty<*>) = thisRef::class.qualifiedName
        ?.replace(".", "/")
        ?.let {
            ResourceUtils.getFile("classpath:$it").readLines()
        }
        ?: emptyList()
}
