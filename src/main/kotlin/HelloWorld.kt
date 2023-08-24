

fun main() {
    println("Hello, world!")    // Hello, world!
//    Variables
//    Val : 읽기 전용
    val popcorn = 5    // There are 5 boxes of popcorn
    val hotdog = 7     // There are 7 hot dogs
    println("popcorn and hot-dog total: ${popcorn + hotdog}")
//    Var : 수정 가능(재할당 가능)

// Some customers leave the queue
    val customers = 8 // There are 10 customers in the queue
    println(customers) // 8

//    String templates $로 변수의 저장된 문자열 값을 읽어 올 수 있음
    println("There are $customers customers")
// There are 10 customers

    println("There are ${customers + 1} customers")
// There are 11 customers
}