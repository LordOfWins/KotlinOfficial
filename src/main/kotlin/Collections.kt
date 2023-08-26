fun main() {
    //Collections
    //그룹의 데이터를 관리하기에 좋다.
    //Lists, Sets, Maps 세 가지가 있다. 각각 읽기 전용이거나 수정 가능한 상태로 만들 수 있다.
    //List
    //순서로 저장하고 항목들을 복사할 수 있음
    //읽기 전용 listOf
    //수정 가능 mutableListOf
    val readOnlyShapes = listOf("triange", "square", "circle")
    println(readOnlyShapes) // [triange] [square] [circle]

    // Mutable list with explicit type declaration
    val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
    println(shapes)
    // [triangle, square, circle]

    // mutable 리스트를 읽기 전용으로 만드려면 다음과 같이 하면 된다.
    val shapesLocked: List<String> = shapes // List 타입으로 선언하고 값을 할당하면 읽기 전용으로 만들 수 있다.
    println("shapesLocked의 값 $shapesLocked") // [triangle, square, circle]
    //리스트의 첫번째 또는 마지막 값을 얻기 위해서 .first() 와 .last() 함수를 각각 사용한다.
    println("이 리스트의 첫 번째 값: ${readOnlyShapes.first()}")
    println("이 리스트의 마지막 값: ${readOnlyShapes.last()}")

    //목록 중 항목의 개수를 얻으려면 .count() 함수를 사용한다.
    println("이 리스트는 ${readOnlyShapes.count()} 개의 항목이 있습니다.")

    //하나의 항목이 목록에 있는지 확인하려면 in 함수를 사용한다.
    println("목록에 square가 있습니까? ${"square" in readOnlyShapes}") // true

    //항목을 추가하거나 제거하려면 .add() 와 .remove() 함수를 사용한다.
    //rectangle을 추가하려면 다음과 같이 한다.
    shapes.add("rectangle")
    println("목록에 rectangle가 있습니까? ${"rectangle" in shapes}") // true
    println(shapes) // [triangle, square, circle, rectangle]

    //square를 제거하려면 다음과 같이 한다.
    shapes.remove("square")
    println("목록에 square가 있습니까? ${"square" in shapes}") // false
    println(shapes) // [triangle, circle, rectangle]

    /*List 가 순서가 있고 항목을 복사할 수 있는 것이라면 Set 은 순서가 없고 중복이 없는 항목을 저장한다.
    읽기 전용 set 은 Set 과 setOf() 함수를 사용한다.
    수정 가능한 set 은 MutableSet 과 mutableSetOf() 함수를 사용한다.
    Set 을 만들 때 코틀린은 타입 추론이 가능하다. 만약 명시적으로 하고 싶다면 set 선언 후에 <>를 사용하면 된다.*/
    // 읽기 전용 set
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    // 수정 가능한 set
    println(readOnlyFruit)
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    //cherry가 두 번 들어가 있지만 set 은 중복을 허용하지 않기 때문에 한 번만 저장된다.

    //Set 도 마찬가지로 읽기 전용을 만드려면 Set 타입으로 선언하고 값을 할당하면 된다.
    val readOnlyFruitLocked: Set<String> = fruit
    println("readOnlyFruitLocked $readOnlyFruitLocked") // [apple, banana, cherry]
    // [apple, banana, cherry]
    //Set 은 저장된 순서는 보장되지 않는다.

    //Set 의 순서가 없어서 특정 인덱스에 접근할 수 없다.

    //Set 의 항목의 개수를 세려면 .count() 함수를 사용한다.
    println("${readOnlyFruit.count()}개를 가지고 있습니다.")
    // This set has 3 items

    //Set 에 항목이 있는지 확인하려면 in 함수를 사용한다.
    println("Set에 banana가 있습니까? ${"banana" in readOnlyFruit}") // true

    //Set 에 항목을 추가하려면 .add() 함수를 사용한다.
    fruit.add("orange")
    println("Set에 orange가 있습니까? ${"orange" in fruit}") // true
    println(fruit) // [apple, banana, cherry, orange]

    //Set 에 항목을 제거하려면 .remove() 함수를 사용한다.
    fruit.remove("banana")
    println("Set에 banana가 있습니까? ${"banana" in fruit}") // false
    println(fruit) // [apple, cherry, orange]

    /*Map 은 키와 값의 쌍을 저장한다.
    키로 값을 찾을 수 있다.
    읽기 전용 map 은 Map 과 mapOf() 함수를 사용한다.
    수정 가능한 map 은 MutableMap 과 mutableMapOf() 함수를 사용한다.
    Map 을 만들 때 코틀린은 타입 추론이 가능하다. 만약 명시적으로 하고 싶다면 map 선언 후에 키와 값을 <>로 저장하면 된다.
    map 을 만들기 가장 쉬운 방법으로 각 키와 연관된 값에 to 를 사용하는 것이다.
    읽기 전용 map*/
    val readOnlyFruitColor = mapOf("apple" to "red", "banana" to "yellow", "cherry" to "red")
    println(readOnlyFruitColor) // {apple=red, banana=yellow, cherry=red}
    //수정 가능한 map
    val fruitColor: MutableMap<String, String> = mutableMapOf("apple" to "red", "banana" to "yellow", "cherry" to "red")
    println(fruitColor) // {apple=red, banana=yellow, cherry=red}

    //map 을 읽기 전용으로 만들려면 Map 타입으로 선언하고 값을 할당하면 된다.
    val readOnlyFruitColorLocked: Map<String, String> = fruitColor
    println("readOnlyFruitColorLocked $readOnlyFruitColorLocked") // {apple=red, banana=yellow, cherry=red}

    //map 에 값을 접근하려면 키와 함께 대괄호를 사용한다.
    println("apple의 색깔은 ${readOnlyFruitColor["apple"]}") // red

    //map 의 항목 개수를 세고 싶다면 .count() 함수를 사용한다.
    println("${readOnlyFruitColor.count()}개의 항목이 있습니다.") // 3 items

    //mutable map 에 항목을 추가하려면 .put() 함수를 사용한다.
    fruitColor.put("orange", "orange")
    println("orange의 색깔은 ${fruitColor["orange"]}") // orange

    //mutable map 에 항목을 제거하려면 .remove() 함수를 사용한다.
    fruitColor.remove("banana")
    println("banana의 색깔은 ${fruitColor["banana"]}") // null
    println(fruitColor) // {apple=red, cherry=red, orange=orange}

    //특정 키가 있는지 확인하려면 .containsKey() 함수를 사용한다.
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu.containsKey("kiwi")) // true
    println(readOnlyJuiceMenu.containsKey("banana")) // false

    //key 와 value 들의 목록을 얻으려면 .keys 와 .values 함수를 사용한다.
    println(readOnlyJuiceMenu.keys) // [apple, kiwi, orange]
    println(readOnlyJuiceMenu.values) // [100, 190, 100]

    // 키와 값이 map에 있는지 확인하려면 in 함수를 사용한다.
    println("apple이 메뉴에 있습니까? ${"apple" in readOnlyJuiceMenu}") // true
    println("100이 메뉴에 있습니까? ${100 in readOnlyJuiceMenu.values}") // true


    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    println(greenNumbers.count() + redNumbers.count())

    val supported = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in supported
    // Write your code here
    println("Support for $requested: $isSupported")
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    // Write your code here
    val n = 2
    println("$n is spelt as '${number2word[n]}'")
}
