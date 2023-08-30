package concepts.types


fun main() {
    /* 부호 없는 정수 타입 */
    // 부호 없는 정수 타입 외에도, 코틀린은 다음과 같은 타입을 제공한다.
    // UByte: 부호 없는 8비트 정수, 0부터 255까지의 범위
    // UShort: 부호 없는 16비트 정수, 0부터 65535까지의 범위
    // UInt: 부호 없는 32비트 정수, 0부터 2^32 - 1까지의 범위
    // ULong: 부호 없는 64비트 정수, 0부터 2^64 - 1까지의 범위
    // 부호 없는 타입은 대부분의 연산을 부호 있는 타입과 동일하게 지원한다.
    
    // 부호 없는 숫자는 같은 너비의 대응하는 부호 있는 타입의 단일 저장 속성으로 구현된 인라인 클래스로 구현된다.
    // 그럼에도 불구하고, 부호 없는 타입에서 부호 있는 타입으로 타입을 변경하거나 (그 반대도 마찬가지) 하는 것은 이진 호환성이 없는 변경이다.
    
    /* 부호 없는 배열과 범위 */
    // 기본 타입과 마찬가지로, 각 부호 없는 타입은 그 타입의 배열을 나타내는 대응 타입을 가진다.
    // UByteArray: 부호 없는 바이트의 배열
    // UShortArray: 부호 없는 숏의 배열
    // UIntArray: 부호 없는 인트의 배열
    // ULongArray: 부호 없는 롱의 배열
    // 부호 있는 정수 배열과 마찬가지로, 박싱 오버헤드 없이 Array 클래스와 유사한 API를 제공한다.
    // 부호 없는 배열을 사용하면, 이 기능이 아직 안정적이지 않다는 경고가 표시된다. 경고를 제거하려면 @ExperimentalUnsignedTypes annotation을 옵트인한다.
    // 클라이언트가 API 사용에 명시적으로 옵트인해야 하는지 여부는 당신의 몫이지만, 부호 없는 배열은 안정적인 기능이 아니므로 언어의 변경으로 인해 그들을 사용하는 API가 변경될 수 있다는 것을 염두에
    // 두어야 한다.
    // 범위와 진행은 UIntRange, UIntProgression, ULongRange 및 ULongProgression 클래스에 의해 UInt 및 ULong을 지원한다.
    // 부호 없는 정수 타입과 함께, 이러한 클래스는 안정적이다.
    
    /* 부호 없는 정수 리터럴 */
    // 부호 없는 정수를 사용하기 쉽게 하기 위해, 코틀린은 특정 부호 없는 타입을 나타내는 접미사를 정수 리터럴에 태그할 수 있는 기능을 제공한다 (Float 또는 Long과 유사하게):
    // u 및 U 태그는 부호 없는 리터럴을 위한 것이다. 정확한 타입은 예상 타입에 따라 결정된다. 예상 타입이 제공되지 않으면, 컴파일러는 리터럴의 크기에 따라 UInt 또는 ULong을 사용한다:
    
    // val b: UByte = 1u  // UByte, expected type provided
    // val s: UShort = 1u // UShort, expected type provided
    // val l: ULong = 1u  // ULong, expected type provided
    // val a1 = 42u // UInt: no expected type provided, constant fits in UInt
    // val a2 = 0xFFFF_FFFF_FFFFu // ULong: no expected type provided, constant doesn't fit in UInt
    
    // uL 및 UL은 리터럴을 부호 없는 롱으로 명시적으로 태그한다:
    // val a = 1UL
    // ULong, 예상 타입이 제공되지 않고 상수가 UInt에 맞는다.
    
    /* 사용 사례 */
    // 부호 없는 숫자의 주요 사용 사례는 양의 값을 나타내기 위해 정수의 전체 비트 범위를 활용하는 것이다.
    // 예를 들어, 32비트 AARRGGBB 형식의 색상과 같은 부호 있는 타입에 맞지 않는 16진수 상수를 나타내려면:
    
    // data class Color(val representation: UInt)
    // val yellow = Color(0xFFCC00CCu)
    
    // toByte() 리터럴 캐스트를 명시적으로 사용하지 않고 바이트 배열을 초기화하는 데 부호 없는 숫자를 사용할 수 있다:
    
    // val byteOrderMarkUtf8 = ubyteArrayOf(0xEFu, 0xBBu, 0xBFu)
    
    // 다른 사용 사례는 네이티브 API와의 상호 운용성이다.
    // 코틀린은 시그니처에 부호 없는 타입을 포함하는 네이티브 선언을 나타낼 수 있게 한다.
    // 매핑은 의미를 변경하지 않고 부호 있는 정수를 부호 없는 정수로 대체하지 않는다.
    
    /* Non-goals */
    // 부호 없는 정수는 양의 숫자와 0만 나타낼 수 있지만, 어플리케이션 도메인이 음수가 아닌 정수를 요구하는 경우에는 사용하지 않는 것이 목표이다.
    // 예를 들어, 컬렉션 크기 또는 컬렉션 인덱스 값의 타입으로.
    // 몇 가지 이유가 있다:
    // 부호 있는 정수를 사용하면 의도치 않은 오버플로를 감지하고, 빈 리스트에 대한 List.lastIndex가 -1인 오류 조건을 신호로 보낼 수 있다.
    // 부호 없는 정수는 그들의 값의 범위가 부호 있는 정수의 범위의 부분집합이 아니기 때문에, 부호 있는 정수의 범위 제한 버전으로 취급될 수 없다.
    // 부호 있는 정수도 부호 없는 정수도 서로의 하위 타입이 아니다.
}