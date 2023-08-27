package tour

fun main() {
    // 코틀린은 자동 추론 가능
    
    // 변수를 선언하고 나중에 초기화 할 수 있는데 초기화를 안 하려면 :(콜론)을 붙여 준다.
    val name = "Kotlin"
    println(name) // Kotlin
    
    // Some customers leave the queue
    var customers = 8
    customers += 3 // Example of addition: 11
    customers += 7            // Example of addition: 18
    customers -= 3            // Example of subtraction: 15
    customers *= 2            // Example of multiplication: 30
    customers /= 3            // Example of division: 10
    println(customers) // 10
}