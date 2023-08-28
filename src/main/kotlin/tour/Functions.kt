package tour

fun main() { // 함수의 매개변수는 괄호 안에 적는다.
    
    // 각 매개변수는 타입을 가져야 하고, 여러 개의 매개변수는 쉼표로 구분한다.
    // the return type is written after the function's parentheses (), separated by a colon :.
    // 함수의 반환 타입은 괄호 뒤에 콜론으로 구분한다.
    
    // the body of a function is written within curly braces {}.
    // 함수의 본문은 중괄호 안에 적는다.
    
    // the return keyword is used to exit or return something from a function.
    // return 키워드는 함수를 종료하거나 함수에서 값을 반환할 때 사용한다.
    
    // If a function doesn't return anything useful, the return type and return keyword can be omitted. Learn more about this in Functions without return.
    // 함수가 유용한 값을 반환하지 않는다면 반환 타입과 return 키워드를 생략할 수 있다.
    
    // In the following example:
    // 다음 예제에서:
    
    // x and y are function parameters.
    // x 와 y 는 함수의 매개변수이다.
    
    // x and y have type Int.
    // x 와 y 는 Int 타입이다.
    
    // the function's return type is Int.
    // 함수의 반환 타입은 Int 이다.
    
    // the function returns a sum of x and y when called.
    // 함수는 호출될 때 x 와 y 의 합을 반환한다.
    
    hello() // Hello, world!
    println(sum(1, 2)) // 3
    
    /*Named arguments*/ // 간결한 코드를 위해 함수를 호출할 때 매개변수 이름을 포함할 필요는 없다.
    // 하지만 매개변수 이름을 포함하면 코드를 읽기 쉽다. 이를 named arguments 라고 한다.
    // 매개변수 이름을 포함한다면 매개변수를 어떤 순서로 적어도 상관없다.
    
    // 다음 예제에서는 string templates ($) 를 사용하여 매개변수 값을 가져와 String 타입으로 변환한 다음 문자열로 연결하여 출력한다.
    
    // The following example shows how to use named arguments:
    printMessageWithPrefix(prefix = "Log", message = "Hello") // [Log] Hello
    
    /*Default parameter values*/ //    You can define default values for your function parameters. Any parameter with a default value can be omitted when calling your function. To declare a default value, use the assignment operator = after the type:
    //    함수의 매개변수에 기본값을 정의할 수 있다. 기본값이 있는 매개변수는 함수를 호출할 때 생략할 수 있다. 기본값을 선언하려면 타입 뒤에 할당 연산자 = 를 사용한다.
    
    // Function called with both parameters
    printMessageWithPrefix("Hello", "Log") // [Log] Hello
    
    // Function called only with message parameter
    printMessageWithPrefix("Hello") // [Info] Hello
    
    // You can skip specific parameters with default values, rather than omitting them all. However, after the first skipped parameter, you must name all subsequent parameters.
    // 기본값이 있는 특정 매개변수를 생략할 수 있다. 하지만 첫 번째 생략된 매개변수 이후에는 모든 매개변수에 이름을 지정해야 한다.
    
    /*Functions without return*/
    // 함수가 유용한 값을 반환하지 않는다면 반환 타입은 Unit 이다. Unit 은 Unit 이라는 하나의 값만 가진 타입이다.
    // 함수 본문에서 Unit 이 반환된다고 명시적으로 선언할 필요는 없다.
    // 즉, return 키워드를 사용하거나 반환 타입을 선언할 필요가 없다.
    printMessage("Hello")
    
    /* Single-expression functions  */
    // To make your code more concise, you can use single-expression functions. For example, the sum() function can be shortened:
    // 코드를 더 간결하게 만들려면 single-expression functions 을 사용할 수 있다. 예를 들어 sum() 함수는 다음과 같이 줄일 수 있다.
    
    // You can remove the curly braces {} and declare the function body using the assignment operator =. And due to Kotlin's type inference, you can also omit the return type. The sum() function then becomes one line:
    // 중괄호 {} 를 제거하고 할당 연산자 = 를 사용하여 함수 본문을 선언할 수 있다. 그리고 Kotlin 의 타입 추론 덕분에 반환 타입도 생략할 수 있다. 그러면 sum() 함수는 한 줄이 된다.
    println(sum(1, 2))
    // 3
    
    /* Lambda expressions */
    // Kotlin allows you to write even more concise code for functions by using lambda expressions.
    // Kotlin 은 lambda expressions 을 사용하여 함수를 더 간결하게 작성할 수 있다.
    
    // For example, the following uppercaseString() function:
    // 다음 uppercaseString() 함수는:
    println(uppercaseString("hello"))
    // HELLO
    
    // can be rewritten using a lambda expression:
    // lambda expression 을 사용하여 다음과 같이 다시 작성할 수 있다.
    
    // Lambda expressions can be hard to understand at first glance so let's break it down. Lambda expressions are written within curly braces {}.
    // Lambda expressions 는 처음 보기에 이해하기 어려울 수 있으므로 하나씩 살펴보자. Lambda expressions 는 중괄호 {} 안에 작성한다.
    
    // Within the lambda expression, you write:
    // Lambda expression 안에서 다음을 작성한다.
    
    // the parameters followed by an ->.
    // 파라미터는 -> 뒤에 따라온다.
    
    // the function body after the ->.
    // -> 뒤에 함수 본문이 온다.
    
    // In the previous example:
    // 이전 예제에서:
    // string is a function parameter.
    // string 은 함수의 매개변수이다.
    
    // string has type String.
    // string 은 String 타입이다.
    
    // the function returns the result of the .uppercase() function called on string.
    // 함수는 string 에서 호출된 .uppercase() 함수의 결과를 반환한다.
    
    // If you declare a lambda without parameters, then there is no need to use ->. For example:
    // 매개변수가 없는 lambda 를 선언한다면 -> 를 사용할 필요가 없다. 예를 들어:
    
    println("Log message")
    
    // Lambda expressions can be used in a number of ways. You can:
    // Lambda expressions 는 여러 가지 방법으로 사용할 수 있다.
    
    // assign a lambda to a variable that you can then invoke later
    // 나중에 호출할 수 있는 변수에 lambda 를 할당한다.
    
    // pass a lambda expression as a parameter to another function
    // 다른 함수의 매개변수로 lambda expression 을 전달한다.
    
    // return a lambda expression from a function
    // 함수에서 lambda expression 을 반환한다.
    
    // invoke a lambda expression on its own
    // lambda expression 을 자체적으로 호출한다.
    
    /* Assign to variable */
    
    // To assign a lambda expression to a variable, use the assignment operator =:
    // lambda expression 을 변수에 할당하려면 할당 연산자 = 를 사용한다.
    
    val upperCaseString = { string: String -> string.uppercase() }
    println(upperCaseString("hello"))
    // HELLO
    
    /* Pass to another function */
    
    // A great example of when it is useful to pass a lambda expression to a function, is using the .filter() function on collections:
    // lambda expression 을 다른 함수에 전달하는 것이 유용한 예는 컬렉션의 .filter() 함수를 사용하는 것이다.
    
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }
    val negatives = numbers.filter { x -> x < 0 }
    println(positives)
    // [1, 3, 5]
    println(negatives)
    // [-2, -4, -6]
    
    // .filter() 함수는 lambda expression 을 predicate 로 사용한다.
    // { x -> x > 0 } 는 리스트의 각 요소를 가져와 양수만 반환한다.
    // { x -> x < 0 } 는 리스트의 각 요소를 가져와 음수만 반환한다.
    
    // If a lambda expression is the only function parameter, you can drop the function parentheses (). This is an example of a trailing lambda, which is discussed in more detail at the end of this chapter.
    // lambda expression 이 유일한 함수 매개변수라면 함수 괄호 () 를 생략할 수 있다. 이는 이 장의 끝에서 자세히 설명하는 trailing lambda 의 예이다.
    
    // Another good example, is using the .map() function to transform items in a collection:
    // 또 다른 좋은 예는 .map() 함수를 사용하여 컬렉션의 항목을 변환하는 것이다.
    
    // The .map() function accepts a lambda expression as a transformer:
    val doubled = numbers.map { x -> x * 2 }
    val tripled = numbers.map { x -> x * 3 }
    println(doubled)
    // [2, -4, 6, -8, 10, -12]
    println(tripled)
    // [3, -6, 9, -12, 15, -18]
    
    // The .map() function accepts a lambda expression as a predicate:
    // .map() 함수는 lambda expression 을 predicate 로 사용한다.
    
    // { x -> x * 2 } takes each element of the list and returns that element multiplied by 2.
    // { x -> x * 2 } 는 리스트의 각 요소를 가져와 그 요소를 2배로 곱한 값을 반환한다.
    
    // { x -> x * 3 } takes each element of the list and returns that element multiplied by 3.
    // { x -> x * 3 } 는 리스트의 각 요소를 가져와 그 요소를 3배로 곱한 값을 반환한다.
    
    /* Function types */
    
    // Before you can return a lambda expression from a function, you first need to understand function types.
    // 함수에서 lambda expression 을 반환하려면 먼저 함수 타입을 이해해야 한다.
    
    // You have already learned about basic types but functions themselves also have a type. Kotlin's type inference can infer a function's type from the parameter type. But there may be times when you need to explicitly specify the function type. The compiler needs the function type so that it knows what is and isn't allowed for that function.
    // 기본 타입에 대해 이미 배웠지만 함수 자체도 타입을 가진다. Kotlin 의 타입 추론은 함수의 타입을 매개변수 타입에서 추론할 수 있다. 하지만 함수 타입을 명시적으로 지정해야 하는 경우도 있다. 컴파일러는 함수 타입이 필요하므로 함수에 대해 허용되는 것과 허용되지 않는 것을 알 수 있다.
    
    // The syntax for a function type has:
    // 함수 타입의 구문은 다음과 같다.
    
    // each parameter's type written within parentheses () and separated by a comma ,.
    // 각 매개변수의 타입은 괄호 () 안에 적고 쉼표 , 로 구분한다.
    
    // the return type written after ->.
    // 반환 타입은 -> 뒤에 적는다.
    
    // For example: (String) -> String or (Int, Int) -> Int.
    // 예를 들어: (String) -> String 또는 (Int, Int) -> Int.
    
    // This is what a lambda expression looks like if a function type for upperCaseString() is defined:
    // upperCaseString() 의 함수 타입이 정의된 경우 lambda expression 은 다음과 같다.
    println(upperCaseString("hello"))
    // HELLO
    
    // If your lambda expression has no parameters then the parentheses () are left empty. For example: () -> Unit
    // lambda expression 이 매개변수가 없다면 괄호 () 는 비워둔다. 예를 들어: () -> Unit
    
    // You must declare parameter and return types either in the lambda expression or as a function type. Otherwise, the compiler won't be able to know what type your lambda expression is.
    // lambda expression 이나 함수 타입에서 매개변수와 반환 타입을 선언해야 한다. 그렇지 않으면 컴파일러는 lambda expression 의 타입을 알 수 없다.
    
    // For example, the following won't work:
    // 다음은 작동하지 않는다.
    
    // val upperCaseString = { string -> string.uppercase() }
    
    /* Return from a function */
    
    // Lambda expressions can be returned from a function. So that the compiler understands what type the lambda expression returned is, you must declare a function type.
    // Lambda expressions 은 함수에서 반환될 수 있다. 컴파일러가 반환된 lambda expression 의 타입을 이해할 수 있도록 함수 타입을 선언해야 한다.
    
    // In the following example, the toSeconds() function has function type (Int) -> Int because it always returns a lambda expression that takes a parameter of type Int and returns an Int value.
    // 다음 예제에서 toSeconds() 함수는 항상 Int 타입의 매개변수를 가져와 Int 값을 반환하는 lambda expression 을 반환하므로 함수 타입 (Int) -> Int 를 가진다.
    
    // This example uses a when expression to determine which lambda expression is returned when toSeconds() is called:
    // 이 예제는 when 표현식을 사용하여 toSeconds() 가 호출될 때 반환되는 lambda expression 을 결정한다.
    
    val timesInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")
    // Total time is 1680 secs
    
    // Invoke separately
    // Lambda expressions can be invoked on their own by adding parentheses () after the curly braces {} and including any parameters within the parentheses:
    // Lambda expressions 은 중괄호 {} 뒤에 괄호 () 를 추가하여 자체적으로 호출할 수 있으며 괄호 안에 매개변수를 포함한다.
    
    println({ string: String -> string.uppercase() }("hello"))
    // HELLO
    
    /* Trailing lambdas */
    // As you have already seen, if a lambda expression is the only function parameter, you can drop the function parentheses (). If a lambda expression is passed as the last parameter of a function, then the expression can be written outside the function parentheses (). In both cases, this syntax is called a trailing lambda.
    // 이미 보았듯이 lambda expression 이 유일한 함수 매개변수라면 함수 괄호 () 를 생략할 수 있다. lambda expression 이 함수의 마지막 매개변수로 전달된다면 표현식은 함수 괄호 () 외부에 작성할 수 있다. 이 두 가지 경우 모두 이 구문을 trailing lambda 라고 한다.
    
    // For example, the .fold() function accepts an initial value and an operation:
    // .fold() 함수는 초기값과 연산을 받는다.
    
    // The initial value is zero.
    // The operation sums the initial value with every item in the list cumulatively.
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 6
    
    // Alternatively, in the form of a trailing lambda
    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })  // 6
    
    
}

fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hour" -> { value -> value * 60 * 60 }
    "minute" -> { value -> value * 60 }
    "second" -> { value -> value }
    else -> { value -> value }
}

val upperCaseString: (String) -> String = { string -> string.uppercase() }
fun hello() {
    return println("Hello, world!")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}
// fun sum(x: Int, y: Int) = x + y

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun printMessage(message: String) {
    println(message)
    // `return Unit` or `return` is optional
}

fun uppercaseString(string: String): String {
    return string.uppercase()
}