package concepts.types

fun main() {
    /* 타입 체크 및 캐스트 */
    // 코틀린에서는 런타임에서 객체의 타입을 확인하는 타입 체크를 수행할 수 있습니다.
    // 타입 캐스트는 객체를 다른 타입으로 변환합니다.
    
    /* is와 !is 연산자 */
    // is 연산자 또는 그의 부정형 !is를 사용하여 객체가 주어진 타입에 일치하는지 여부를 식별하는 런타임 체크를 수행합니다.
    
    /* if (obj is String) {
        print(obj.length)
    }
    
    if (obj !is String) { // Same as !(obj is String)
        print("Not a String")
    } else {
        print(obj.length)
    } */
    
    /* 스마트 캐스트 */
    // 대부분의 경우 코틀린에서 명시적 캐스트 연산자를 사용할 필요가 없는데 왜냐하면 컴파일러는 불변 값에 대한 is-checks 및 명시적 캐스트를 추적하고 필요할 때 (안전한) 캐스트를 자동으로 삽입합니다.
    /*fun demo(x: Any) {
        if (x is String) {
            print(x.length) // x is automatically cast to String
        }
    } */
    
    // 컴파일러는 부정적인 체크가 반환으로 이어지면 캐스트가 안전하다는 것을 알고 있습니다.
    
    /* if (x !is String) return
    
    print(x.length)*/
    // x는 자동으로 String으로 캐스트됩니다.
    // 또 만약 이것이 && 또는 ||의 오른쪽에 있고, 적절한 체크(일반적인 또는 부정적인)가 왼쪽에 있다면:
    // x는 ||의 오른쪽에 자동으로 String으로 캐스트됩니다.
    
    // if (x !is String || x.length == 0) return
    // x는 &&의 오른쪽에 자동으로 String으로 캐스트됩니다.
    /* if (x is String && x.length > 0) {
        print(x.length) // x is automatically cast to String
    } */
    // 스마트 캐스트는 when 표현식과 while 루프에도 작동합니다.
    
    /* when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    } */
    
    // Note that smart casts work only when the compiler can guarantee that the variable won't change between the check and its usage.
    // 즉, 스마트 캐스트는 컴파일러가 변수가 체크와 사용 사이에서 변경되지 않음을 보장할 수 있을 때만 작동합니다.
    
    // 스마트 캐스트는 다음 조건에서 사용할 수 있습니다.
    // val local variables         Always, except local delegated properties.
    // val 지역 변수               항상, 지역 위임 속성을 제외하고.
    // val properties              If the property is private, internal, or if the check is performed in the same module where
    // val 속성                    만약 속성이 private, internal이거나, 체크가 같은 모듈에서 수행된다면
    // the property is declared. Smart casts can't be used on open properties or properties that have custom getters.
    // 속성이 선언된다. 스마트 캐스트는 열린 속성이나 사용자 정의 getter가 있는 속성에는 사용할 수 없습니다.
    // var local variables         If the variable is not modified between the check and its usage, is not captured
    // var 지역 변수               체크와 사용 사이에 수정되지 않은 경우, 캡처되지 않은 경우
    // in a lambda that modifies it, and is not a local delegated property.
    // 람다에서 수정하는 것이 아니고, 지역 위임 속성이 아닌 경우.
    // var properties              Never, because the variable can be modified at any time by other code.
    // var 속성                    절대로, 다른 코드에서 언제든지 변수를 수정할 수 있기 때문입니다.
    /* "Unsafe" cast operator */
    /* 안전하지 않은 캐스트 연산자 */
    // Usually, the cast operator throws an exception if the cast isn't possible. Thus, it's called unsafe. The unsafe cast in Kotlin is done by the infix operator as.
    // 일반적으로 캐스트 연산자는 캐스트가 불가능한 경우 예외를 throw합니다. 따라서 이를 unsafe라고 합니다. Kotlin의 unsafe 캐스트는 중위 연산자 as를 사용하여 수행됩니다.
    // val x: String = y as String
    // Note that null cannot be cast to String, as this type is not nullable. If y is null, the code above throws an exception. To make code like this correct for null values, use the nullable type on the right-hand side of the cast:
    // null은 nullable이 아니므로 String으로 캐스트할 수 없습니다. y가 null이면 위의 코드는 예외를 throw합니다. 이러한 코드를 null 값에 대해 올바르게 만들려면 캐스트의 오른쪽에 nullable 타입을 사용하십시오.
    // val x: String? = y as String?
    // "Safe" (nullable) cast operator
    // "안전한" (nullable) 캐스트 연산자
    // To avoid exceptions, use the safe cast operator as?, which returns null on failure.
    // 예외를 피하려면 실패 시 null을 반환하는 안전한 캐스트 연산자 as?를 사용하십시오.
    // val x: String? = y as? String
    // Note that despite the fact that the right-hand side of as? is a non-null type String, the result of the cast is nullable.
    // as?의 오른쪽이 non-null 타입 String임에도 불구하고 캐스트의 결과는 nullable입니다.
}