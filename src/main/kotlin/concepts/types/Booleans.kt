package concepts.types

fun main() {
    /* Booleans */
    // 티입 Boolean은 true와 false 두 가지 값을 가질 수 있는 boolean 객체를 나타낸다.
    // Boolean has a nullable counterpart Boolean? that also has the null value.
    // Boolean에는 null 값도 가질 수 있는 null이 가능한(nullable) 형식인 Boolean?이 존재한다
    // Built-in operations on booleans include:
    // boolean에 대한 내장 연산은 다음과 같다.
    // || – disjunction (logical OR)
    // || – 분리 (논리 OR)
    // && – conjunction (logical AND)
    // && – 결합 (논리 AND)
    // ! – negation (logical NOT)
    // ! – 부정 (논리 NOT)
    // || and && work lazily.
    // ||와 &&는 나중에 작동한다.
    // val myTrue: Boolean = true
    // val myFalse: Boolean = false
    // val boolNull: Boolean? = null
    
    // println(myTrue || myFalse)
    // println(myTrue && myFalse)
    // println(!myTrue)
    // On JVM: nullable references to boolean objects are boxed similarly to numbers.
    // JVM에서: boolean 객체에 대한 nullable 참조는 숫자와 유사하게 박싱된다.
}