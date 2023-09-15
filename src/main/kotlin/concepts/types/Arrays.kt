package concepts.types

fun main() {
    /* 배열 */
    // Kotlin에서 배열은 Array 클래스로 표현됩니다.
    // It has get() and set() functions that turn into [] by operator overloading conventions, and the size property, along with other useful member functions:
    // get() 및 set() 함수는 연산자 오버로딩 규칙에 의해 []로 변환되며 size 속성과 함께 다른 유용한 멤버 함수가 있습니다.
    
    // class Array<T> private constructor() {
    //     val size: Int
    //     operator fun get(index: Int): T
    //     operator fun set(index: Int, value: T): Unit
    //
    //     operator fun iterator(): Iterator<T>
    //     // ...
    // }
    
    // 배열을 만들려면 arrayOf() 함수를 사용하고 항목 값을 전달하면 arrayOf(1, 2, 3)은 배열 [1, 2, 3]을 만듭니다.
    // 대체적으로 arrayOfNulls() 함수를 사용하여 null 요소로 채워진 주어진 크기의 배열을 만들 수 있습니다.
    // 다른 옵션은 배열 크기와 해당 인덱스의 배열 요소 값을 반환하는 함수를 취하는 Array 생성자를 사용하는 것입니다.
    
    // ["0", "1", "4", "9", "16"] 값으로 Array<String>을 생성.
    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }
    // [] 연산은 멤버 함수 get() 및 set()에 대한 호출을 나타냅니다.
    
    // 코틀린의 배열은 불변입니다.
    // 이는 코틀린이 Array<String>을 Array<Any>에 할당하지 못하도록하여 가능한 런타임 오류를 방지한다는 것을 의미합니다 (하지만 Array<out Any>를 사용할 수 있습니다).
    
    /* 기본 타입 배열 */
    // 코틀린에는 ByteArray, ShortArray, IntArray 등의 박싱 오버헤드없이 기본 유형의 배열을 나타내는 클래스도 있습니다.
    // 이러한 클래스는 Array 클래스와 상속 관계가 없지만 동일한 메서드 및 속성 집합을 갖습니다.
    // 각각에 대해 대응하는 팩토리 함수를 갖고 있습니다.
    
    // val x: IntArray = intArrayOf(1, 2, 3)
    // x[0] = x[1] + x[2]
    
    // [0, 0, 0, 0, 0] 값으로 크기가 5인 int 배열을 생성.
    // val arr = IntArray(5)
    //
    // 예시: 상수로 배열의 값을 초기화하는 방법
    
    //[42, 42, 42, 42, 42] 값으로 크기가 5인 int 배열을 생성.
    // val arr = IntArray(5) { 42 }
    //
    // 예시: 람다를 사용하여 배열의 값을 초기화하는 방법
    // [0, 1, 2, 3, 4] 값으로 크기가 5인 int 배열을 생성 (값은 해당 인덱스 값으로 초기화됨).
    // var arr = IntArray(5) { it * 1 }
}