package concepts.types

fun main() {
    /* Strings */
    /* 문자열 */
    // Kotlin에서 문자열은 String 타입으로 표현됩니다.
    // 일반적으로 문자열 값은 큰 따옴표 (") 안에 문자의 시퀀스입니다.
    
    var str = "abcd 123"
    
    // 문자열의 요소는 색인 작업을 통해 액세스 할 수 있는 문자입니다. s[i].
    // for 루프를 사용하여 이러한 문자를 반복할 수 있습니다.
    
    for (c in str) {
        println(c)
    }
    
    // 문자열은 불변입니다.
    // 문자열을 초기화하면 값을 변경하거나 새 값을 할당 할 수 없습니다.
    // 문자열을 변환하는 모든 작업은 결과를 새 String 객체로 반환하지 원래 문자열을 변경하지 않습니다.
    
    str = "abcd"
    println(str.uppercase()) // 새 String 객체를 만들고 출력
    println(str) // 원래 문자열은 그대로 유지됩니다.
    
    // 문자열을 연결하려면 + 연산자를 사용하십시오.
    // 이것도 표현식의 첫 번째 요소가 문자열인 한 다른 유형의 값과 문자열을 연결하는 데 사용할 수 있습니다.
    
    val s = "abc" + 1
    println(s + "def")
    
    // 대부분의 경우 문자열 템플릿 또는 여러 줄의 문자열을 사용하는 것이 문자열 연결보다 좋습니다.
    
    /* 문자열 리터럴 */
    // 코틀린은 두 가지 유형의 문자열 리터럴이 있습니다.
    // 이스케이프 된 문자열
    // 이스케이프 된 문자열에는 이스케이프 된 문자가 포함될 수 있습니다.
    // 다음은 이스케이프 된 문자열의 예입니다.
    
    // val s = "Hello, world!\n"
    
    // 이스케이핑은 역 슬래시 (\)로 전통적인 방식으로 수행됩니다.
    
    // 여러 줄의 문자열
    // 여러 줄의 문자열에는 줄 바꿈 및 임의의 텍스트가 포함될 수 있습니다.
    // 이것은 삼중 따옴표 (""")로 구분되며 이스케이프를 포함하지 않으며 줄 바꿈 및 기타 문자를 포함할 수 있습니다.
    // val text = """
    //     for (c in "foo")
    //         print(c)
    // """
    // 여러 줄의 문자열에서 선행 공백을 제거하려면 trimMargin() 함수를 사용하십시오.
    // val text = """
    //     |Tell me and I forget.
    //     |Teach me and I remember.
    //     |Involve me and I learn.
    //     |(Benjamin Franklin)
    //     """.trimMargin()
    // 기본적으로 파이프 기호 |가 여백 접두사로 사용되지만 다른 문자를 선택하고 trimMargin(">")과 같이 매개 변수로 전달할 수 있습니다.
    
    /* 문자열 템플릿 */
    // 문자열 리터럴에는 측정되고 결과가 문자열로 연결되는 코드 조각 인 템플릿 표현식이 포함될 수 있습니다.
    // 템플릿 표현식은 달러 기호($)로 시작하고 이름 또는 중괄호 안의 식으로 구성됩니다.
    val i = 10
    println("i = $i") // Prints "i = 10"
    
    // 또는 중괄호 안의 식:
    
    val s2 = "abc"
    println("$s2.length is ${s2.length}") // Prints "abc.length is 3"
    
    // 여러 줄의 문자열 및 이스케이프 된 문자열에서 템플릿을 모두 사용할 수 있습니다.
    // 역 슬래시 이스케이프를 지원하지 않는 여러 줄의 문자열에 달러 기호 $를 삽입하려면 식별자의 시작으로 허용되는 기호 앞에 다음 구문을 사용하십시오.
    
    // val price = """
    // ${'$'}_9.99
    // """
}