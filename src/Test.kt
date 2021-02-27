fun main() {
    val obj = Customer("코틀린")
}

class Customer(name: String) {
    init {
        println("이름 : $name")
    }
}