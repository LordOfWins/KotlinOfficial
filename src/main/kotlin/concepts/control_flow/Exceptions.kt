package concepts.control_flow

fun main() {
    /* 예외 */
    
    /* 예외 클래스 */
    // 모든 예외 클래스는 Throwable 클래스를 상속합니다.
    // 모든 예외는 메시지, 스택 트레이스, 그리고 선택적인 이유를 가지고 있습니다.
    // 예외 객체를 던지려면, throw 표현식을 사용합니다.
    
    /*
    throw Exception("Hi There!")
    */
    
    // 예외를 처리하려면, try...catch 표현식을 사용합니다.
    
    /*
    try {
        // some code
    } catch (e: SomeException) {
        // handler
    } finally {
        // optional finally block
    }
    */
    
    // 0개 또는 그 이상의 catch 블록이 있을 수 있으며, finally 블록은 생략될 수 있습니다.
    // 하지만, 적어도 하나의 catch 또는 finally 블록이 필요합니다.
    
    /* Try는 표현식입니다 */
    // try는 표현식입니다. 즉, 반환 값을 가질 수 있습니다.
    
    /*
    val a: Int? = try { input.toInt() } catch (e: NumberFormatException) { null }
    */
    
    // try 표현식의 반환 값은 try 블록의 마지막 표현식 또는 catch 블록의 마지막 표현식입니다.
    // finally 블록의 내용은 표현식의 결과에 영향을 주지 않습니다.
    
    /* 확인된 예외 */
    // 코틀린은 확인된 예외를 가지고 있지 않습니다.
    // 이에 대한 많은 이유가 있지만, 이것이 그런 이유인지를 보여주는 간단한 예제를 제공하겠습니다.
    // 다음은 StringBuilder 클래스에서 구현된 JDK의 예제 인터페이스입니다.
    
    /*
    Appendable append(CharSequence csq) throws IOException
    */
    
    // 이 시그니처는 문자열을 무언가에 추가할 때마다 (StringBuilder, 어떤 종류의 로그, 콘솔 등) IOExceptions를 잡아야 한다고 말합니다.
    // 왜?
    // 왜냐하면 구현은 IO 작업을 수행할 수 있기 때문입니다 (Writer도 Appendable을 구현합니다).
    // 그 결과, 이런 코드가 곳곳에 있습니다.
    
    /*
    try {
        log.append(message)
    } catch (IOException e) {
        // Must be safe
    }
    */
    
    // 이것은 좋지 않습니다.
    // Effective Java, 3rd Edition, Item 77: 예외를 무시하지 마세요를 보세요.
    // Bruce Eckel은 다음과 같이 확인된 예외에 대해 말합니다.
    // 작은 프로그램을 검사하면 예외 사양을 요구하는 것이 개발자 생산성을 향상시키고 코드 품질을 향상시킬 수 있다는 결론에 이르게 됩니다. 그러나 대형 소프트웨어 프로젝트의 경험은 다른 결과를 시사합니다 - 생산성 감소 및 코드 품질 증가 없음.
    // 여기 몇 가지 추가적인 생각들입니다.
    // 자바의 확인된 예외는 실수였습니다. (Rod Waldhoff)
    // 확인된 예외의 문제점 (Anders Hejlsberg)
    // If you want to alert callers about possible exceptions when calling Kotlin code from Java, Swift, or Objective-C, you can use the @Throws annotation.
    // Java, Swift 또는 Objective-C에서 Kotlin 코드를 호출할 때 호출자에게 가능한 예외에 대해 경고하려면 @Throws 주석을 사용할 수 있습니다.
    
    /* Nothing 타입 */
    // Nothing 타입은 값이 없음을 나타냅니다.
    // 예를 들어, 함수가 예외를 던지는 경우, 그 함수의 반환 타입은 Nothing입니다.
    // Nothing은 함수가 정상적으로 반환되지 않음을 나타내는데 사용됩니다.
    // throw는 코틀린에서 표현식이므로 Elvis 표현식의 일부로 사용할 수 있습니다.
    
    /*
    val s = person.name ?: throw IllegalArgumentException("Name required")
    */
    
    // throw 표현식은 Nothing 타입을 가지고 있습니다.
    // 이 타입은 값이 없으며, 절대로 도달할 수 없는 코드 위치를 표시하는 데 사용됩니다.
    // 자신의 코드에서는, 절대로 반환하지 않는 함수를 표시하기 위해 Nothing을 사용할 수 있습니다.
    
    /*
    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }
    */
    
    // 이 함수를 호출하면, 컴파일러는 호출을 넘어서 실행되지 않음을 알게 됩니다.
    
    /*
    val s = person.name ?: fail("Name required")
    println(s) // 's'는 이 시점에서 초기화되었음을 알 수 있습니다.
    */
    
    // 타입 추론을 다룰 때 이 타입을 만날 수도 있습니다.
    // 이 타입의 nullable 변형인 Nothing?은 null이라는 하나의 가능한 값만 가지고 있습니다.
    // 추론된 타입의 값을 초기화하기 위해 null을 사용하고 더 구체적인 타입을 결정하는 데 사용할 수 있는 다른 정보가 없으면, 컴파일러는 Nothing? 타입을 추론합니다.
    
    /*
    val x = null           // 'x' has type `Nothing?`
    val l = listOf(null)   // 'l' has type `List<Nothing?>
    */
    
    /* 자바 상호 운용성 */
    // 코틀린은 예외를 처리하는 방법에 대해 자바와 호환됩니다.
    // 자바에서 코틀린 코드를 호출할 때, 예외는 일반적인 방법으로 처리됩니다.
    // Java interoperability에서 예외를 처리하는 방법에 대한 정보는 Java interoperability 페이지의 예외 섹션을 참조하십시오.
}