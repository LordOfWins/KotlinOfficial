package concepts.classes_and_objects

fun main() {
    /* 클래스 선언 */
    // 코틀린에서 클래스는 class 키워드를 사용하여 선언됩니다.
    
    // class Person { /*...*/ }
    
    // 클래스 선언은 클래스 이름, 클래스 헤더(타입 파라미터, 주 생성자, 그리고 다른 것들을 지정하는 것), 그리고 중괄호로 둘러싸인 클래스 바디로 구성됩니다.
    // 헤더와 바디는 둘 다 선택적입니다. 만약 클래스가 바디가 없다면, 중괄호는 생략할 수 있습니다.
    // class Empty
    
    /* 생성자 */
    // 코틀린에서 클래스는 주 생성자와 하나 이상의 보조 생성자를 가질 수 있습니다.
    // 주 생성자는 클래스 헤더에 선언되며, 클래스 이름과 선택적인 타입 파라미터 뒤에 옵니다.
    
    // class Person constructor(firstName: String) { /*...*/ }
    
    // 주 생성자가 어노테이션 또는 가시성 변경자를 가지고 있지 않다면, constructor 키워드는 생략할 수 있습니다.
    
    // class Person(firstName: String) { /*...*/ }
    
    // 주 생성자는 클래스 인스턴스와 클래스 헤더의 프로퍼티를 초기화합니다.
    // 클래스 헤더는 실행 가능한 코드를 포함할 수 없습니다.
    // 객체 생성 중에 코드를 실행하고 싶다면, 클래스 바디 내부에서 초기화 블록을 사용하세요.
    // 초기화 블록은 init 키워드와 중괄호로 선언됩니다.
    // 중괄호 내부에 실행하고 싶은 코드를 작성하세요.
    // 인스턴스 초기화 중에, 초기화 블록은 클래스 바디에 나타나는 순서대로 실행되며, 프로퍼티 초기화와 섞여서 실행됩니다.
    /*
    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name".also(::println)

        init {
            println("First initializer block that prints $name")
        }
        val secondProperty = "Second property: ${name.length}".also(::println)
       
        init {
            println("Second initializer block that prints ${name.length}")
        }
    }
    */
    // 주 생성자 파라미터는 초기화 블록에서 사용될 수 있습니다.
    // 클래스 바디에 선언된 프로퍼티 초기화에서도 사용될 수 있습니다.
    
    /*
     class Customer(name: String) {
         val customerKey = name.uppercase()
     }
    */
    
    // 코틀린은 프로퍼티를 선언하고 주 생성자에서 초기화하는 간결한 문법을 가지고 있습니다.
    
    /*
    class Person(val firstName: String, val lastName: String, var age: Int)
    */
    
    // 이런 선언은 클래스 프로퍼티의 기본값을 포함할 수 있습니다.
    
    /*
    class Person(val firstName: String, val lastName: String, var isEmployed: Boolean = true)
    */
    
    // 클래스 프로퍼티를 선언할 때, 후행 쉼표를 사용할 수 있습니다.
    
    /*
    class Person(
        val firstName: String,
        val lastName: String,
        var age: Int, // trailing comma
    ) {  *//*...*//*  }
    */
    
    // 일반 프로퍼티와 마찬가지로, 주 생성자에서 선언된 프로퍼티는 변경 가능(var)하거나 읽기 전용(val)일 수 있습니다.
    // 생성자에 어노테이션이나 가시성 변경자가 있다면, constructor 키워드가 필요하고 변경자는 그 앞에 위치해야 합니다.
    
    // class Customer public @Inject constructor(name: String) { /*...*/ }
    
    /* 보조 생성자 */
    // 클래스는 constructor로 시작하는 보조 생성자를 선언할 수도 있습니다.
    
    /*
    class Person(val pets: MutableList<Pet> = mutableListOf())
    */
    
    /*
    class Pet {
        constructor(owner: Person) {
            owner.pets.add(this) // adds this pet to the list of its owner's pets
        }
    }
    */
    
    // 클래스에 주 생성자가 있다면, 각 보조 생성자는 주 생성자에게 다른 보조 생성자를 통해 직접적으로 또는 간접적으로 위임해야 합니다.
    // 같은 클래스의 다른 생성자에 위임은 this 키워드를 사용하여 수행합니다.
    
    /*
    class Person(val name: String) {
        val children: MutableList<Person> = mutableListOf()
        constructor(name: String, parent: Person) : this(name) {
            parent.children.add(this)
        }
    }
    */
    
    // 초기화 블록의 코드는 효율적으로 주 생성자의 일부가 됩니다.
    // 주 생성자에 대한 위임은 보조 생성자의 첫 번째 문장에 접근할 때 발생하므로, 모든 초기화 블록과 프로퍼티 초기화에서의 코드는 보조 생성자의 바디가 실행되기 전에 실행됩니다.
    // 클래스에 주 생성자가 없더라도, 위임은 암묵적으로 발생하고 초기화 블록은 여전히 실행됩니다.
    
    /*
    class Constructors {
        init {
            println("Init block")
        }
        constructor(i: Int) {
            println("Constructor $i")
        }
    }
    */
    
    // 비 추상 클래스가 생성자(주 생성자 또는 보조 생성자)를 선언하지 않으면, 인자가 없는 생성자가 생성됩니다.
    // 생성자의 가시성은 public이 됩니다.
    // 클래스가 public 생성자를 가지지 않길 원한다면, 비어있는 주 생성자를 선언하고 가시성을 기본값이 아닌 다른 값으로 지정하세요.
    
    /*
    class DontCreateMe private constructor() {  *//*...*//*  }
    */
    
    // JVM에서, 주 생성자의 모든 파라미터가 기본값을 가지고 있다면, 컴파일러는 기본값을 사용하는 추가적인 파라미터 없는 생성자를 생성합니다.
    // 이는 파라미터 없는 생성자를 통해 클래스 인스턴스를 생성하는 Jackson이나 JPA와 같은 라이브러리에서 사용하기 쉽게 만듭니다.
    
    /*
    class Customer(val customerName: String = "")
    */
    
    /* 클래스의 인스턴스 생성 */
    // 클래스의 인스턴스를 생성하려면, 일반 함수처럼 생성자를 호출하세요.
    
    // val invoice = Invoice()
    // val customer = Customer("Joe Smith")
    
    // 코틀린은 new 키워드를 가지고 있지 않습니다.
    // 중첩 클래스, 내부 클래스, 익명 내부 클래스의 인스턴스를 생성하는 과정은 Nested classes에서 설명합니다.
    
    /* 클래스 멤버 */
    // 클래스는 다음을 포함할 수 있습니다.
    // 생성자 및 초기화 블록
    // 함수
    // 프로퍼티
    // 중첩 클래스와 내부 클래스
    // 객체 선언
    
    /* 상속 */
    // 클래스는 서로 상속을 받아 계층 구조를 형성할 수 있습니다.
    
    /* 추상 클래스 */
    // 클래스는 abstract로 선언될 수 있습니다. 그리고 그 멤버들 중 일부 또는 전부도 abstract로 선언될 수 있습니다.
    // abstract 멤버는 클래스 내부에 구현이 없습니다.
    // abstract 클래스나 함수에 open을 어노테이션할 필요가 없습니다.
    
    /*
    abstract class Polygon {
        abstract fun draw()
    }

    class Rectangle : Polygon() {
        override fun draw() {
            // draw the rectangle
        }
    }
    */
    
    // abstract 멤버로 non-abstract open 멤버를 오버라이드할 수 있습니다.
    
    /*
    open class Polygon {
        open fun draw() {
            // some default polygon drawing method
        }
    }

    abstract class WildShape : Polygon() {
        // Classes that inherit WildShape need to provide their own
        // draw method instead of using the default on Polygon
        abstract override fun draw()
    }
    */
    
    /* 컴패니언 객체 */
    // 클래스 인스턴스 없이 호출할 수 있는 함수를 작성해야 하지만, 클래스 내부에 있는 내부 구현에 접근해야 하는 경우(팩토리 메서드와 같은), 클래스 내부의 객체 선언의 멤버로 작성할 수 있습니다.
    // 더 구체적으로, 클래스 내부에 companion 객체를 선언하면, 클래스 이름만을 한정자로 사용하여 그 멤버에 접근할 수 있습니다.
}
