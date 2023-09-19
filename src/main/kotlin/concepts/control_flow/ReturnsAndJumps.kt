package concepts.control_flow

fun main() {
    /* Returns and jumps */
    // 반환과 건너뛰기
    // 코틀린은 세 가지 구조적 건너뛰는 표현식을 가지고 있습니다.
    // 기본적으로 return은 가장 가까운 둘러싸는 함수나 익명 함수로부터 반환합니다.
    // break는 가장 가까운 둘러싸는 루프를 종료합니다.
    // continue는 가장 가까운 둘러싸는 루프의 다음 단계로 진행합니다.
    // 이러한 표현식은 모두 더 큰 표현식의 일부로 사용할 수 있습니다.
    
    /*
    val s = person.name ?: return
    */
    
    // 이러한 표현식의 타입은 Nothing 타입입니다.
    
    /* Break와 continue 라벨 */
    // 코틀린의 어떤 표현식은 라벨로 표시될 수 있습니다.
    // Labels have the form of an identifier followed by the @ sign, such as abc@ or fooBar@.
    // 라벨은 abc@나 fooBar@와 같은 @ 기호로 끝나는 식별자 형태를 가지고 있습니다.
    // To label an expression, just add a label in front of it.
    // 표현식에 라벨을 지정하려면, 그 앞에 라벨을 추가하면 됩니다.
    
    /*
    loop@ for (i in 1..100) {
        // ...
    }
    */
    
    // 이제, break나 continue를 라벨과 함께 사용할 수 있습니다.
    
    /*
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (...) break@loop
        }
    }
    */
    
    // 라벨과 함께 지정된 break는 그 라벨로 표시된 루프 바로 다음 실행 지점으로 점프합니다.
    // continue는 그 루프의 다음 반복으로 진행합니다.
    
    /* 라벨에 Return */
    // 코틀린에서 함수는 함수 리터럴, 로컬 함수, 객체 표현식을 사용하여 중첩될 수 있습니다.
    // 지정된 returns는 외부 함수에서 반환할 수 있도록 해줍니다.
    // 가장 중요한 사용 사례는 람다 표현식에서 반환하는 것입니다.
    // 다음과 같이 작성하면, return-expression은 가장 가까운 둘러싸는 함수인 foo에서 반환합니다.
    
    /*
    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // 로컬이 아닌 return은 foo()의 호출자에게 직접 반환합니다.
            print(it)
        }
        println("this point is unreachable")
    }
    */
    
    // 로컬이 아닌 return은 인라인 함수에 전달된 람다 표현식에 대해서만 지원됩니다.
    // 람다 표현식에서 반환하려면, 라벨을 지정하고 반환을 지정하면 됩니다.
    
    /*
    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // 람다의 호출자에게 로컬 반환 - forEach 루프
            print(it)
        }
        print(" done with explicit label")
    }
    */
    
    // 이제, 람다 표현식에서만 반환합니다.
    // 람다가 전달되는 함수와 동일한 이름을 가진 라벨을 사용하는 것이 더 편리합니다.
    
    /*
    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // 람다의 호출자에게 로컬 반환 - forEach 루프
            print(it)
        }
        print(" done with implicit label")
    }
    */
    
    // 또는 람다 표현식을 익명 함수로 대체할 수 있습니다.
    // 익명 함수의 반환문은 익명 함수 자체에서 반환합니다.
    
    /*
    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
            if (value == 3) return // 익명 함수의 호출자에게 로컬 반환 - forEach 루프
            print(value)
        })
        print(" done with anonymous function")
    }
    */
    
    // 이전 세 가지 예제에서 로컬 반환을 사용하는 것은 일반적인 루프에서 continue를 사용하는 것과 유사합니다.
    // break에 대한 직접적인 동등물은 없지만, 다른 중첩 람다를 추가하고 그것에서 비 로컬 반환하는 것으로 시뮬레이션 할 수 있습니다.
    
    /*
    fun foo() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // run에 전달된 람다에서 비 로컬 반환
                print(it)
            }
        }
        print(" done with nested loop")
    }
    */
    
    // 값을 반환할 때, 파서는 지정된 반환을 우선시합니다.
    // return@a 1
    // 이것은 "라벨 @a에서 1을 반환"이라는 의미이며 "라벨 표시된 표현식 (@a 1)을 반환"이 아닙니다.
}