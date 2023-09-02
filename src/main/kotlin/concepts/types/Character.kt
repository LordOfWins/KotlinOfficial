package concepts.types

fun main() {
    /* 문자 */
    // 문자는 Char 타입으로 표현된다.
    // 문자 리터럴은 작은 따옴표(')로 감싼다: '1'.
    // 특수 문자는 역슬래시(\)로 시작한다.
    // 다음 이스케이프 시퀀스가 지원된다.
    // \t – tab
    // \t - 탭
    // \b - 백스페이스
    // \n – new line (LF)
    // \n - 새로운 줄 (LF)
    // \r - 캐리지 리턴 (CR)
    // \' - 작은 따옴표
    // \" - 큰 따옴표
    // \\ – backslash
    // \\ - 역슬래시
    // \$ – dollar sign
    // \$ - 달러 기호
    // 다른 문자를 인코딩하려면 유니코드 이스케이프 시퀀스 구문을 사용한다: '\uFF00'.
    
    // val aChar: Char = 'a'
    //
    // println(aChar)
    // println('\n') // Prints an extra newline character
    // println('\uFF00')
    
    // 문자 변수의 값이 숫자인 경우, digitToInt() 함수를 사용하여 명시적으로 Int 숫자로 변환할 수 있다.
    println('3'.digitToInt()) // 0
}