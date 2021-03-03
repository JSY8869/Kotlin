fun main() {
    val obj = User("Kotlin", 12)
    print(obj.toString())
}

data class User(var name: String, var age: Int)