package tour

fun main() {
    // 코틀린에서 null 값을 가질 수 있다. 프로그램에서 null 값으로 인한 문제를 방지하기 위해 코틀린은 null safety를 사용한다. null safety는 실행 시간이 아닌 컴파일 시간에 null 값으로 인한 잠재적인 문제를 감지한다.
    // null safety는 다음과 같은 기능의 조합이다.
    // 명시적으로 프로그램에서 null 값을 허용할 때.
    // null 값을 확인한다.
    // null 값을 포함할 수 있는 속성 또는 함수에 대해 안전한 호출을 사용한다.
    // null 값이 감지되면 수행할 작업을 선언한다.
    
    /* Nullable types */
    // 코틀린은 선언된 타입이 null 값을 가질 수 있는 nullable type을 지원한다.
    // 기본적으로 타입은 null 값을 허용하지 않는다. nullable type은 타입 선언 뒤에 ?를 명시적으로 추가하여 선언한다.
    
    // For example:
    // 예를 들어:
    // neverNull은 String 타입이다.
    var neverNull: String = "This can't be null"
    
    // 컴파일러 에러를 발생시킨다.
    // neverNull = null
    
    // nullable은 nullable String 타입이다.
    var nullable: String? = "You can keep a null here"
    
    // 이것은 괜찮다.
    nullable = null
    
    // 기본적으로 null 값은 허용되지 않는다.
    var inferredNonNull = "The compiler assumes non-null"
    
    // 컴파일러 에러를 발생시킨다.
    // inferredNonNull = null
    
    // notNull은 null 값을 허용하지 않는다.
    fun strLength(notNull: String): Int {
        return notNull.length
    }
    
    println(strLength(neverNull)) // 18
    // println(nullable?.let { strLength(it) }) // null
    println(strLength(inferredNonNull))  // Throws a compiler error
    // println(strLength(nullable))  // Throws a compiler error
    // length는 문자열 내의 문자 수를 포함하는 String 클래스의 속성이다.
    
    /* Check for null values */
    // 조건문 내에서 null 값의 존재 여부를 확인할 수 있다.
    // 다음 예제에서 describeString() 함수는 maybeString이 null이 아니고 길이가 0보다 큰지 확인하는 if 문을 가지고 있다.
    fun describeString(maybeString: String?): String = if (maybeString != null && maybeString.length > 0) {
        "String of length ${maybeString.length}"
    } else {
        "Empty or null string"
    }
    
    var nullString: String? = null
    println(describeString(nullString))
    // Empty or null string
    
    /* Use safe calls */
    // null 값을 포함할 수 있는 객체의 속성에 안전하게 접근하려면 안전한 호출 연산자 ?를 사용한다.
    // 안전한 호출 연산자는 객체의 속성이 null이면 null을 반환한다.
    // 이것은 null 값의 존재로 인해 코드에서 오류가 발생하는 것을 피하고자 할 때 유용하다.
    // 다음 예제에서 lengthString() 함수는 문자열의 길이 또는 null을 반환하기 위해 안전한 호출을 사용한다.
    fun lengthString(maybeString: String?): Int? = maybeString?.length
    println(lengthString(nullString))
    // null
    
    // 안전한 호출은 연결될 수 있어서 만약 객체의 속성 중 하나가 null 값을 포함하고 있다면 null이 반환되고 에러가 발생하지 않는다.
    // 예를 들어:
    // person.company?.address?.country
    
    /* Use Elvis operator */
    // ?: 연산자를 사용하여 null 값이 감지되면 반환할 기본값을 제공할 수 있다.
    // ?: 연산자의 왼쪽에 null 값을 확인할 대상을 적는다.
    // ?: 연산자의 오른쪽에 null 값이 감지되면 반환할 값을 적는다.
    // 다음 예제에서 nullString은 null 이므로 length 속성에 접근하는 안전한 호출은 null 값을 반환한다.
    // 결과적으로 ?: 연산자는 0을 반환한다.
    println(nullString?.length ?: 0)
    // 0
    
}



