package concepts.types

fun main() {
    /* Integer types */
    // 코틀린은 숫자를 나타내는 내장 타입을 제공한다.
    // 정수 숫자의 경우, 다음과 같이 크기가 다르고, 따라서 값 범위가 다른 네 가지 타입이 있다.
    
    // Type     Size (bits)     Min value                           Max value
    // Byte     8               -128                                127
    // Short    16              -32768                              32767
    // Int      32              -2,147,483,648 (-2^31)              2,147,483,647 (2^31 - 1)
    // Long     64              -9,223,372,036,854,775,808 (-2^63)  9,223,372,036,854,775,807 (2^63 - 1)
    
    // 당신이 명시적으로 타입을 지정하지 않고 변수를 초기화하면, 컴파일러는 값이 표현할 수 있는 가장 작은 범위의 타입을 자동으로 추론한다.
    // 만약 Int의 범위를 넘지 않는다면, 타입은 Int이다. 만약 넘는다면, 타입은 Long이다.
    // 명시적으로 Long 값을 지정하려면, 값 뒤에 접미사 L을 붙인다.
    // 명시적 타입 지정은 컴파일러가 지정된 타입의 범위를 넘지 않는지 확인하도록 한다.
    
    // val one = 1 // Int
    // val threeBillion = 3000000000 // Long
    // val oneLong = 1L // Long
    // val oneByte: Byte = 1
    
    // 정수 타입 외에도 코틀린은 부호 없는 정수 타입을 제공한다.
    
    /* Floating-point types */
    // 실수에 대해서는, 코틀린은 IEEE 754 표준을 준수하는 부동 소수점 타입 Float와 Double을 제공한다.
    // Float는 IEEE 754 단일 정밀도를 반영하고, Double은 배정밀도를 반영한다.
    // 이러한 타입은 크기가 다르고, 다른 정밀도의 부동 소수점 숫자를 저장한다.
    
    // Type     Size (bits)     Significant bits     Exponent bits   Decimal digits
    // Float    32              24                   8               6-7
    // Double   64              53                   11              15-16
    
    // 당신은 소수 부분을 가진 숫자로 Double과 Float 변수를 초기화할 수 있다.
    // 소수 부분은 정수 부분과 점(.)으로 구분된다.
    // 소수로 초기화된 변수에 대해서는, 컴파일러는 Double 타입을 추론한다.
    
    // val pi = 3.14 // Double
    // val one: Double = 1 // Error: type mismatch
    // val oneDouble = 1.0 // Double
    
    // 명시적으로 Float 타입을 지정하려면, 접미사 f 또는 F를 추가한다.
    // 만약 이러한 값이 6-7개의 소수 자릿수보다 많은 소수 자릿수를 포함하고 있다면, 반올림된다.
    // val e = 2.7182818284 // Double
    // val eFloat = 2.7182818284f // Float, actual value is 2.7182817
    
    // 다른 언어와 달리, 코틀린에서는 숫자에 대한 암시적 확대 변환이 없다.
    // 예를 들어, Double 매개변수를 가진 함수는 Double 값에 대해서만 호출할 수 있고, Float, Int 또는 다른 숫자 값에 대해서는 호출할 수 없다.
    
    fun printDouble(d: Double) {
        print(d)
    }
    
    val i = 1
    val d = 1.0
    val f = 1.0f
    
    printDouble(d)
    // printDouble(i) // Error: Type mismatch
    // printDouble(f) // Error: Type mismatch
    
    // 숫자 값을 다른 타입으로 변환하려면, 명시적 변환을 사용한다.
    
    /* Literal constants for numbers */
    // 정수 값에 대한 다음과 같은 종류의 리터럴 상수가 있다.
    // 십진수: 123
    // Longs는 대문자 L로 태그된다: 123L
    // 16진수: 0x0F
    // 이진수: 0b00001011
    // 코틀린은 8진수 리터럴을 지원하지 않는다.
    // 코틀린은 부동 소수점 숫자에 대한 전통적인 표기법을 지원한다.
    // Doubles 기본값: 123.5, 123.5e10
    // f 또는 F가 붙은 Floats : 123.5f
    // 숫자 상수를 더 읽기 쉽게 만들기 위해 밑줄을 사용할 수 있다.
    // val oneMillion = 1_000_000
    // val creditCardNumber = 1234_5678_9012_3456L
    // val socialSecurityNumber = 999_99_9999L
    // val hexBytes = 0xFF_EC_DE_5E
    // val bytes = 0b11010010_01101001_10010100_10010010
    
    // 부호 없는 정수 리터럴에 대한 특수 태그도 있다.
    
    /* Numbers representation on the JVM */
    // JVM 플랫폼에서 숫자는 int, double 등의 원시 타입으로 저장된다.
    // 예외는 Int?와 같은 nullable number reference를 생성하거나 제네릭을 사용하는 경우이다.
    // 이러한 경우 숫자는 Java 클래스 Integer, Double 등에 박싱된다.
    // 동일한 숫자에 대한 nullable references는 서로 다른 객체를 참조할 수 있다.
    
    val a: Int = 100
    val boxedA: Int = a
    val anotherBoxedA: Int = a
    
    val b: Int = 10000
    val boxedB: Int = b
    val anotherBoxedB: Int = b
    
    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false
    
    // All nullable references to a are actually the same object because of the memory optimization that JVM applies to Integers between -128 and 127.
    // JVM이 -128과 127 사이의 정수에 적용하는 메모리 최적화 때문에 a 에 대한 모든 nullable references는 실제로 동일한 객체이다.
    // b에 대해서는 적용되지 않으므로, 그들은 다른 객체이다.
    // 반면에, 그들은 여전히 같다.
    
    println(b == b) // Prints 'true'
    println(boxedB == anotherBoxedB) // Prints 'true'
    
    /* Explicit number conversions */
    // 다른 표현 때문에, 작은 타입은 큰 타입의 하위 타입이 아니다. 만약 그렇다면, 우리는 다음과 같은 문제를 가질 것이다.
    // 가상의 코드, 실제로 컴파일되지 않는다.
    // val p: Int = 1 // A boxed Int (java.lang.Integer)
    // val q: Long? = p // Implicit conversion yields a boxed Long (java.lang.Long)
    // print(p == q) // Surprise! This prints "false" as Long's equals() checks whether the other is Long as well
    
    // 따라서 동등성은 묵시적으로 잃어버려졌을 것이다. 식별성은 말할 것도 없다.
    // 결과적으로, 작은 타입은 큰 타입으로 묵시적으로 변환되지 않는다.
    // 이것은 Byte 타입의 값을 Int 변수에 할당하려면 명시적 변환이 필요하다는 것을 의미한다.
    
    val byte: Byte = 1 // OK, literals are checked statically
    // val i: Int = b // ERROR
    val i1: Int = byte.toInt()
    
    // 모든 숫자 타입은 다른 타입으로의 변환을 지원한다.
    // toByte(): Byte
    // toShort(): Short
    // toInt(): Int
    // toLong(): Long
    // toFloat(): Float
    // toDouble(): Double
    
    // 다양한 경우에, 명시적 변환이 필요하지 않다. 왜냐하면 타입은 컨텍스트로부터 추론되고, 산술 연산은 적절한 변환을 위해 오버로드되기 때문이다. 예를 들어:
    val l = 1L + 3 // Long + Int => Long
    
    /* Operations on numbers */
    // 코틀린은 숫자에 대한 표준 산술 연산을 지원한다: +, -, *, /, %.
    // 이들은 적절한 클래스의 멤버로 선언된다.
    
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)
    
    // 당신은 또한 이러한 연산자를 사용자 정의 클래스에 대해 오버라이드할 수 있다.
    
    /* Division of integers */
    // 정수 숫자 사이의 나눗셈은 항상 정수 숫자를 반환한다. 어떤 소수 부분도 버려진다.
    
    val x = 5 / 2
    // println(x == 2.5)
    // 오류: 연산자 '=='는 'Int'와 'Double'에 적용할 수 없다.
    println(x == 2)
    
    // 이것은 모든 두 정수 타입 사이의 나눗셈에 대해서도 참이다.
    
    val y = 5L / 2
    println(y == 2L)
    
    // 부동 소수점 타입을 반환하려면, 인자 중 하나를 명시적으로 부동 소수점 타입으로 변환하라.
    
    val z = 5 / 2.toDouble()
    println(z == 2.5)
    
    /* Bitwise operations */
    // 코틀린은 정수 숫자에 대한 비트 연산을 제공한다.
    // 이들은 숫자 표현의 비트와 직접적으로 이진 레벨에서 작동한다.
    // 비트 연산은 중위 표기법으로 호출할 수 있는 함수로 표현된다.
    // 이들은 Int와 Long에만 적용할 수 있다.
    
    val x1 = (1 shl 2) and 0x000FF000
    
    // 다음은 비트 연산의 완전한 목록이다.
    // shl(bits) – signed shift left
    // shr(bits) – signed shift right
    // ushr(bits) – unsigned shift right
    // and(bits) – bitwise AND
    // or(bits) – bitwise OR
    // xor(bits) – bitwise XOR
    // inv() – bitwise inversion
    
    // Floating-point numbers comparison
    // 이 섹션에서 논의하는 부동 소수점 숫자에 대한 연산은 다음과 같다.
    // 동등성 검사: a == b and a != b
    // 비교 연산자: a < b, a > b, a <= b, a >= b
    // 범위 인스턴스화와 범위 검사: a..b, x in a..b, x !in a..b
    // 피연산자 a와 b가 Float 또는 Double 또는 그들의 nullable 상대 타입(타입이 선언되거나 추론되거나 스마트 캐스트의 결과인 경우)으로 정적으로 알려져 있을 때, 숫자와 그들이 형성하는 범위에 대한 연산은 IEEE 754 부동 소수점 산술 표준을 따른다.
    // 그러나 일반적인 사용 사례를 지원하고 전체 순서를 제공하기 위해, 정적으로 부동 소수점 숫자로 타입이 지정되지 않은 피연산자에 대한 동작은 다르다. 예를 들어, Any, Comparable<...>, 또는 Collection<T> 타입.
    // 이 경우, 연산은 Float와 Double에 대한 equals와 compareTo 구현을 사용한다. 결과적으로:
    // NaN은 자신과 같다고 간주된다.
    // NaN은 POSITIVE_INFINITY를 포함한 다른 모든 요소보다 크다고 간주된다.
    // -0.0은 0.0보다 작다고 간주된다.
    // 다음은 피연산자가 정적으로 부동 소수점 숫자로 타입이 지정된 경우(Double.NaN)와 부동 소수점 숫자로 정적으로 타입이 지정되지 않은 경우(listOf(T))의 동작 차이를 보여주는 예제이다.
    println(Double.NaN == Double.NaN)                 // false
    println(listOf(Double.NaN) == listOf(Double.NaN)) // true
    
    println(0.0 == -0.0)                              // true
    println(listOf(0.0) == listOf(-0.0))              // false
    
    println(listOf(Double.NaN, Double.POSITIVE_INFINITY, 0.0, -0.0).sorted())
    // [-0.0, 0.0, Infinity, NaN]
}