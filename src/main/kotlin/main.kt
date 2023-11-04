fun main() {
    val seconds = 300
    val name = "Anna"
    println(agoToText(seconds, name))
}

fun agoToText(seconds: Int, name: String): String {
    val minutes = seconds / 60
    val hours = seconds / 3600

    return when (seconds) {
        in 0..60 -> "Пользователь $name был(а) в сети только что"
        in 61..3600 -> "Пользователь $name был(а) в сети $minutes" + stringsForMinutes(minutes)
        in 3601..86400 -> "Пользователь $name был(а) в сети $hours" + stringsForHours(hours)
        in 86401..172800 -> "Пользователь $name был(а) в сети вчера"
        in 172801..345600 -> "Пользователь $name был(а) в сети позавчера"
        else -> "Пользователь $name был(а) в сети давно"
    }
}

fun stringsForMinutes(minutes: Int): String {
    return when {
        minutes % 100 in 5..20 -> " минут назад"
        minutes % 10 == 1 -> " минуту назад"
        minutes % 10 in 2..4 -> " минуты назад"
        else -> " минут назад"
    }
}

fun stringsForHours(hours: Int): String {
    return when {
        hours % 100 in 5..20 -> " часов назад"
        hours % 10 == 1 -> " час назад"
        hours % 10 in 2..4 -> " часа назад"
        else -> " часов назад"
    }
}