package concepts

fun main() {
    /* 패키지와 임포트 */
    // 소스 파일은 패키지 선언으로 시작할 수 있습니다.
    
    /*
    package org.example

    fun printMessage() {  *//*...*//*  }
    class Message {  *//*...*//*  }

    // ...
    */
    
    // 소스 파일의 모든 내용(클래스, 함수 등)은 이 패키지에 포함됩니다.
    // 따라서 위의 예에서 printMessage()의 전체 이름은 org.example.printMessage이고 Message의 전체 이름은 org.example.Message입니다.
    // 패키지가 지정되지 않은 경우 해당 파일의 내용은 이름이 없는 기본 패키지에 속합니다.
    
    /* Default imports */
    // 코틀린 파일에는 기본적으로 여러 패키지가 임포트됩니다.
    
    /*
    kotlin.*
    kotlin.annotation.*
    kotlin.collections.*
    kotlin.comparisons.*
    kotlin.io.*
    kotlin.ranges.*
    kotlin.sequences.*
    kotlin.text.*
    */
    
    // 대상 플랫폼에 따라 추가 패키지가 임포트됩니다.
    
    // JVM:
    // java.lang.*
    // kotlin.jvm.*
    
    // JS:
    // kotlin.js.*
    
    /* Imports */
    // 기본 임포트 외에도 각 파일에는 자체 임포트 지시문이 포함될 수 있습니다.
    // 단일 이름을 임포트할 수 있습니다.
    // import org.example.Message // Message는 이제 자격을 갖추지 않고도 액세스할 수 있습니다.
    // 또는 범위(package, class, object 등)의 모든 액세스 가능한 내용을 임포트할 수 있습니다.
    // import org.example.* // 'org.example'의 모든 것이 액세스 가능해집니다.
    
    // 이름 충돌이 있는 경우 as 키워드를 사용하여 충돌하는 엔티티의 이름을 명시적으로 바꿀 수 있습니다.
    // import org.example.Message //메시지에 액세스할 수 있습니다.
    // import org.test.Message as TestMessage // 테스트 메시지는 'org.test.Message'를 나타냅니다.
    // import 키워드는 클래스를 가져오는 데 제한되지 않습니다. 이를 사용하여 다른 선언도 가져올 수 있습니다.
    // 탑 레벨 함수와 프로퍼티
    // 객체 선언에서 선언된 함수와 프로퍼티
    // enum 상수
    
    /* 턉 래밸의 가시성 */
    // 탑 레벨 선언이 private로 표시되면 해당 선언이 선언된 파일에 대해서만 private입니다.
}