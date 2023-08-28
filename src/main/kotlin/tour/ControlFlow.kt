package tour

fun main() {
    /*if*/
    // if 를 사용하고자 한다면 소괄호 안에 조건을 넣어주고 중괄호 안에 실행할 코드를 넣어준다.
    val d: Int
    val check = true
    
    d = if (check) {
        1
    } else {
        2
    }
    
    println(d)
    // 1
    // 더 이상 삼항 연산자가 없다. 대신, if-else 문을 표현식으로 사용할 수 있다.
    val a = 1
    val b = 2
    println(if (a > b) a else b)
    /*when*/
    // 만약 다중으로 분기를 하고 싶다면 when 을 사용한다.
    // when 또한 if 와 마찬가지로 표현식으로 사용할 수 있다.
    // if 문과 마찬가지로 소괄호 안에 조건을 넣어주고 중괄호 안에 실행할 코드를 넣어준다.
    // -> 을 사용해서 조건과 실행할 코드를 연결해준다.
    // 하나의 branch 만 사용한다.
    val x = 1
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> println("x is neither 1 nor 2")
    }
    // when 도 if 와 마찬가지로 표현식으로 사용할 수 있다.
    val obj = "Hello"
    val result = when (obj) {
        // If obj equals "1", sets result to "one"
        "1" -> "One"
        // If obj equals "Hello", sets result to "Greeting"
        "Hello" -> "Greeting"
        // Sets result to "Unknown" if no previous condition is satisfied
        else -> "Unknown"
    }
    println(result)
    // Greeting
    
    // when 이 표현식으로 사용될 때 컴파일러가 branch 조건들에 의해 가능한 케이스들을 다 확인할 수 없다면 else 브랜치가 필요하다.
    
    // when은 논리 연산 분기를 확인 할 때 유용하다.
    val y = 1
    val z = 2
    when {
        y < z -> println("y is less than z")
        y > z -> println("y is greater than z")
        else -> println("y must equal z")
    }
    /*Ranges*/
    // ..은 범위를 설정하는데 있어서 가장 많이 쓰인다.
    // 1..4 는 1,2,3,4 와 동일하다.
    
    // 끝의 값을 포함하고 싶지 않을 때는 ..<을 사용한다.
    // 1..<4 는 1,2,3 과 동일하다.
    
    // 역순으로 범위를 설정하고 싶다면 downTo 를 사용한다.
    // 4 downTo 1 은 4,3,2,1 과 동일하다.
    
    // step 을 사용하면 범위의 증가폭을 설정할 수 있다.
    // 1..5step 2 는 1,3,5 과 동일하다.
    
    // Char 타입에도 사용할 수 있다.
    //'a'..'d' 는 a,b,c,d 와 동일하다.
    //'a'..'d' step 2 는 a,c 와 동일하다.
    //'z' downTo 's' step2 는 'z','x','v','t'
    
    /*Loop*/
    // 대표적인 반복문은 for와 while이 있다.
    // 반복자와 범위를 괄호() 안에 넣고 키워드를 in으로 설정합니다. 중괄호 {} 안에 완료하려는 작업을 추가합니다.
    for (number in 1..5) {
        // number is the iterator and 1..5 is the range
        print(number)
    }
    // 12345
    // 컬렉션은 루프로 반복될 수도 있습니다.
    val cakes = listOf("carrot", "cheese", "chocolate")
    
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    // Yummy, it's a carrot cake!
    // Yummy, it's a cheesecake!
    // Yummy, it's a chocolate cake!
    
    //    조건식이 true인 동안 코드 블록을 실행합니다. (while)
    
    //    먼저 코드 블록을 실행한 다음 조건식을 확인합니다.(do-while)
    
    // 조건식을 () 안에 담고 중괄호 {} 안에 완료하려는 작업을 추가합니다.
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
    // Eat a cake
    // Eat a cake
    // Eat a cake
    
    // do 중괄호 안에 완료하려는 작업을 추가합니다. 그리고 while 뒤에 조건식을 () 안에 담습니다.
    var cakesBaked = 0
    do {
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < cakesEaten)
    // Bake a cake
    // Bake a cake
    // Bake a cake
    
    
}
