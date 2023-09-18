package concepts.control_flow

fun main() {
    /* if 표현식 */
    // 코틀린에서 if는 표현식입니다. 값이 반환됩니다.
    // 따라서 일반적인 if가 이 역할을 잘 수행하기 때문에 삼항 연산자 (condition ? then : else)가 없습니다.
    
    // var max = a
    // if (a < b) max = b
    
    // else를 사용하여
    // if (a > b) {
    //     max = a
    // } else {
    //     max = b
    // }
    
    // 표현식으로서
    // max = if (a > b) a else b
    
    // else if도 사용할 수 있습니다.
    // val maxLimit = 1
    // val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b
    
    // 표현식이 블록일 수 있습니다. 이 경우 마지막 표현식이 블록의 값입니다.
    
    // val max = if (a > b) {
    //     print("Choose a")
    //     a
    // } else {
    //     print("Choose b")
    //     b
    // }
    
    // 만약 if를 표현식으로 사용한다면, 예를 들어 값을 반환하거나 변수에 할당하는 경우 else 브랜치는 필수입니다.
    
    // When 표현식
    
    // when 다중 분기 조건 표현식을 정의합니다.
    // C언어 스타일의 switch문과 유사합니다.
    
    // when (x) {
    //     1 -> print("x == 1")
    //     2 -> print("x == 2")
    //     else -> {
    //         print("x is neither 1 nor 2")
    //     }
    // }
    
    // 특정 브랜치가 만족할 때까지 when은 인수를 모든 브랜치에 순차적으로 일치시킵니다.
    // when은 표현식이나 문으로 사용할 수 있습니다.
    // 만약 표현식으로 사용된다면, 첫번째 일치하는 브랜치의 값이 전체 표현식의 값이 됩니다.
    // 만약 문으로 사용된다면, 개별 브랜치의 값은 무시됩니다.
    // if와 마찬가지로, 각 브랜치는 블록이 될 수 있으며, 그 값은 블록의 마지막 표현식의 값입니다.
    // 다른 브랜치 조건이 만족되지 않는다면 else 브랜치로 충족됩니다.
    // 만약 when이 표현식으로 사용된다면, else 브랜치는 필수입니다. 컴파일러가 모든 가능한 경우가 브랜치 조건으로 충족되는 것을 증명할 수 없는 한, 예를 들어 enum class entries와 sealed class subtypes 같은 경우입니다.
    
    // enum class Bit {
    //     ZERO, ONE
    // }
    //
    
    // val numericValue = when (getRandomBit()) {
    //     Bit.ZERO -> 0
    //     Bit.ONE -> 1
    //     // 'else' is not required because all cases are covered
    // }
    
    // when문에서 else 브랜치는 다음 조건에서 필수입니다.
    // when의 주제가 Boolean, enum, 또는 sealed type이거나 그들의 nullable counterparts인 경우입니다.
    // when의 브랜치가 이 주제에 대한 모든 가능한 경우를 다루지 않는 경우입니다.
    
    // enum class Color {
    //     RED, GREEN, BLUE
    // }
    
    // when (getColor()) {
    //     Color.RED -> println("red")
    //     Color.GREEN -> println("green")
    //     Color.BLUE -> println("blue")
    // }
    // 모든 경우가 다루어지기 때문에 'else'는 필수가 아닙니다.
    
    // when (getColor()) {
    //     Color.RED -> println("red") // no branches for GREEN and BLUE
    //     else -> println("not red") // 'else' is required
    // }
    
    // 여러 경우에 대해 공통 동작을 정의하려면 쉼표로 단일 줄에 조건을 결합하십시오.
    
    // when (x) {
    //     0, 1 -> print("x == 0 or x == 1")
    //     else -> print("otherwise")
    // }
    
    // 상수뿐만 아니라 임의의 표현식을 브랜치 조건으로 사용할 수 있습니다.
    
    // when (x) {
    //     s.toInt() -> print("s encodes x")
    //     else -> print("s does not encode x")
    // }
    
    // You can also check a value for being in or !in a range or a collection:
    // 범위 또는 컬렉션에 in 또는 !in에 있는 값을 확인할 수도 있습니다.
    
    /*
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
    */
    
    // 다른 옵션은 값이 특정 유형을 is 또는 !is로 확인하는 것입니다.
    // 스마트 캐스트로 인해 추가 검사없이 유형의 메서드와 속성에 액세스 할 수 있습니다.
    
    /*
    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }
    */
    
    // when은 if-else if 체인을 대체하는 데에도 사용할 수 있습니다.
    // 인수가 제공되지 않으면 브랜치 조건은 단순한 부울 표현식이고 조건이 true 인 경우 브랜치가 실행됩니다.
    
    /*
    when {
        x.isOdd() -> print("x is odd")
        y.isEven() -> print("y is even")
        else -> print("x+y is odd")
    }
    */
    
    // 다음과 같은 문법을 사용하여 when 표현식의 대상을 변수에 담을 수 있습니다.
    
    /*
     fun Request.getBody() =
        when (val response = executeRequest()) {
            is Success -> response.body
            is HttpError -> throw HttpException(response.status)
        }
     */
    
    // 코틀린의 when 표현식에서 주어진 변수(주제)가 when 표현식의 본문 내에서만 사용 가능하다
    
    /* For 루프 */
    // The for loop iterates through anything that provides an iterator.
    // for 루프는 반복자를 제공하는 모든 것을 순회합니다.
    // This is equivalent to the foreach loop in languages like C#.
    // 이것은 C #과 같은 언어의 foreach 루프와 동일합니다.
    // The syntax of for is the following:
    // for의 구문은 다음과 같습니다.
    
    /*
    for (item in collection) print(item)
    */
    
    // for의 본문은 블록형태가 될 수 있습니다.
    
    /*
    for (item: Int in ints) {
        // ...
    }
    */
    
    // 앞에서 언급했듯이 for는 반복자를 제공하는 것을 순회합니다.
    // 이것은 다음을 의미합니다.
    // Iterator <>를 반환하는 멤버 또는 확장 기능 iterator ()가 있습니다.
    // 멤버 또는 확장 기능 next ()가 있습니다.
    // 멤버 또는 확장 기능 hasNext ()가 있으며 Boolean을 반환합니다.
    // 이 세 가지 함수는 모두 operator로 표시되어야합니다.
    // 숫자 범위를 반복하려면 범위 표현식을 사용하십시오.
    
    /*
    for (i in 1..3) {
        println(i)
    }
    */
    
    /*
    for (i in 6 downTo 0 step 2) {
        println(i)
    }
    */
    
    // 범위 또는 배열에 대한 for 루프는 반복자 개체를 생성하지 않는 인덱스 기반 루프로 컴파일됩니다.
    // 배열이나 목록을 인덱스로 반복하려면 다음과 같이 할 수 있습니다.
    
    /*
    for (i in array.indices) {
        println(array[i])
    }
    */
    
    // 또는 withIndex 라이브러리 함수를 사용할 수 있습니다.
    
    /*
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
    */
    
    /* while 루프 */
    // while 및 do-while 루프는 조건이 충족 될 때까지 본문을 계속 실행합니다.
    // 그들 사이의 차이점은 조건 검사 순서입니다.
    // while checks the condition and, if it's satisfied, executes the body and then returns to the condition check.
    // while은 조건을 확인하고, 조건이 충족되면 본문을 실행한 다시 조건으로 돌아갑니다.
    // do-while은 본문을 실행한 다음 조건을 확인합니다.
    // 조건이 충족되면 루프가 반복됩니다.
    // 따라서 do-while의 본문은 조건과 관계없이 적어도 한 번 실행됩니다.
    
    // while (x > 0) {
    //     x--
    // }
    
    // do {
    //     val y = retrieveData()
    // } while (y != null) // y is visible here!
}