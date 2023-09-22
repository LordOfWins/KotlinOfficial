package concepts.classes_and_objects

fun main() {
    /* 상속 */
    // 코틀린에서의 모든 클래스는 Any라는 공통 상위클래스를 가지고 있습니다. 이는 상위타입이 선언되지 않은 클래스의 기본 상위클래스입니다.
    
    // class Example // 암시적으로 Any로부터 상속받습니다.
    
    // Any는 equals(), hashCode(), 그리고 toString()이라는 세 가지 메소드를 가지고 있습니다.
    // 따라서, 이 메소드들은 모든 코틀린 클래스에 대해 정의되어 있습니다.
    // 기본적으로, 코틀린 클래스는 final입니다. 즉, 상속될 수 없습니다.
    // 클래스를 상속 가능하게 하려면, open 키워드로 표시하세요.
    
    // open class Base // 클래스는 상속 가능합니다.
    
    // 명시적인 상위타입을 선언하려면, 클래스 헤더의 콜론 뒤에 타입을 위치시키세요.
    
    /*
    open class Base(p: Int)
    class Derived(p: Int) : Base(p)
    */
    
    // 만약 파생 클래스가 주 생성자를 가지고 있다면, 상위클래스는 (그리고 반드시) 파생 클래스의 파라미터에 따라 주 생성자에서 초기화될 수 있습니다.
    // 만약 파생 클래스가 주 생성자를 가지고 있지 않다면, 각 보조 생성자는 super라는 키워드를 사용하여 상위타입을 초기화해야 하거나, 상위타입을 초기화하는 다른 생성자에게 위임해야 합니다.
    // 이 경우에는 다른 보조 생성자가 상위타입의 다른 생성자를 호출할 수 있다는 것을 주의하세요.
    
    /*
    class MyView : View {
        constructor(ctx: Context) : super(ctx)

        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    }
    */
    
    /* 메소드 오버라이딩 */
    // 코틀린은 오버라이드 가능한 멤버와 오버라이드에 대해 명시적인 수정자를 요구합니다.
    
    /*
    open class Shape {
        open fun draw() {  *//*...*//*  }
        fun fill() {  *//*...*//*  }
    }
    class Circle() : Shape() {
        override fun draw() {  *//*...*//*  }
    }
    */
    
    // 오버라이드 수정자는 Circle.draw()에 필요합니다.
    // 만약 이게 빠지면, 컴파일러는 에러를 날 것입니다.
    // 만약 함수에 Shape.fill()처럼 open 수정자가 없다면, 서브클래스에서 동일한 시그니처를 가진 메소드를 선언하는 것은 허용되지 않는다. 오버라이드가 있든 없든 말이다.
    // open 수정자는 open 수정자가 없는 final 클래스의 멤버에 추가되었을 때 효과가 없습니다.
    // 오버라이드로 표시된 멤버는 그 자체로 open이므로, 서브클래스에서 오버라이드될 수 있습니다.
    // 만약 다시 오버라이드하는 것을 금지하고 싶다면, final을 사용하세요.
    
    /*
    open class Rectangle() : Shape() {
        final override fun draw() {  *//*...*//*  }
    }
    */
    
    /* 오버라이딩 프로퍼티 */
    // 오버라이딩 메소드와 마찬가지로, 오버라이딩 메커니즘은 프로퍼티에서도 작동합니다.
    // 상위클래스에서 선언된 프로퍼티는 파생 클래스에서 다시 선언되어야 하며, override로 선행되어야 하고, 호환 가능한 타입을 가져야 합니다.
    // 각 선언된 프로퍼티는 초기화자를 가진 프로퍼티 또는 get 메소드를 가진 프로퍼티에 의해 오버라이드될 수 있습니다.
    
    /*
    open class Shape {
        open val vertexCount: Int = 0
    }

    class Rectangle : Shape() {
        override val vertexCount = 4
    }
    */
    
    // 또한 val 프로퍼티를 var 프로퍼티로 오버라이드할 수 있지만, 그 반대는 불가능합니다.
    // 이는 val 프로퍼티는 사실상 get 메소드를 선언하고, var로 오버라이드하면 파생 클래스에서 set 메소드를 추가로 선언하기 때문에 허용됩니다.
    // 주 생성자에서 프로퍼티 선언의 일부로 override 키워드를 사용할 수 있다는 것을 주의하세요.
    
    /*
    interface Shape {
        val vertexCount: Int
    }
    
    class Rectangle(override val vertexCount: Int = 4) : Shape // 항상 4개의 꼭지점을 가지고 있습니다.
    
    class Polygon : Shape {
        override var vertexCount: Int = 0  // 나중에 어떤 숫자든지 설정할 수 있습니다.
    }
    */
    
    /* 파생 클래스 초기화 순서 */
    // 파생 클래스의 새 인스턴스를 생성하는 동안, 상위클래스 초기화는 첫 번째 단계로 수행됩니다. (상위클래스 생성자의 인자 평가에 의해 선행됨) 이는 파생 클래스의 초기화 로직이 실행되기 전에 수행된다는 것을 의미합니다.
    
    /*
    open class Base(val name: String) {
        init { println("Initializing a base class") }
        open val size: Int =
            name.length.also { println("Initializing size in the base class: $it") }
    }
    class Derived(
        name: String,
        val lastName: String,
    ) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {
        init { println("Initializing a derived class") }
        override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
    }
    */
    
    // 이는 상위클래스 생성자가 실행될 때, 파생 클래스에서 선언되거나 오버라이드된 프로퍼티가 아직 초기화되지 않았다는 것을 의미합니다.
    // 상위클래스 초기화 로직에서 이러한 프로퍼티 중 하나를 사용하면 (직접적으로든 간접적으로든 오버라이드된 다른 open 멤버 구현을 통해든), 잘못된 동작이나 런타임 실패가 발생할 수 있습니다.
    // 따라서 상위클래스를 디자인할 때, 생성자, 프로퍼티 초기화자, 또는 init 블록에서 open 멤버를 사용하는 것을 피해야 합니다.
    
    /* 상위클래스 구현 호출 */
    // 파생 클래스의 코드는 super 키워드를 사용하여 상위클래스 함수와 프로퍼티 접근자 구현을 호출할 수 있습니다.
    
    /*
    open class Rectangle {
        open fun draw() { println("Drawing a rectangle") }
        val borderColor: String get() = "black"
    }

    class FilledRectangle : Rectangle() {
        override fun draw() {
            super.draw()
            println("Filling the rectangle")
        }

        val fillColor: String get() = super.borderColor
    }
    */
    
    // 내부 클래스에서, 외부 클래스의 상위클래스에 접근하려면 super 키워드를 외부 클래스 이름으로 한정하면 됩니다. super@Outer:
    
    /*
    class FilledRectangle: Rectangle() {
        override fun draw() {
            val filler = Filler()
            filler.drawAndFill()
        }
        inner class Filler {
            fun fill() { println("Filling") }
            fun drawAndFill() {
                super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
                fill()
                println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
            }
        }
    }
    */
    
    /* 오버라이딩 규칙 */
    // 코틀린에서, 구현 상속은 다음 규칙에 의해 규제됩니다: 만약 클래스가 상위클래스로부터 동일한 멤버의 여러 구현을 상속받는다면, 이 멤버를 오버라이드하고 자체 구현을 해야 합니다. (아마도 상속받은 것 중 하나를 사용하여)
    // 상속된 구현이 가져온 상위타입을 나타내려면, super<Base>와 같이 꺽쇠 안에 상위타입 이름으로 한정된 super를 사용하세요.
    
    /*
    open class Rectangle {
        open fun draw() {  *//* ... *//*  }
    }

    interface Polygon {
        fun draw() {  *//* ... *//*  } // interface members are 'open' by default
    }

    class Square() : Rectangle(), Polygon {
        // The compiler requires draw() to be overridden:
        override fun draw() {
            super<Rectangle>.draw() // call to Rectangle.draw()
            super<Polygon>.draw() // call to Polygon.draw()
        }
    }
    */
    
    // Rectangle과 Polygon에서 모두 상속받는 것은 괜찮지만, 둘 다 draw()의 구현을 가지고 있으므로, Square에서 draw()를 오버라이드하고 모호성을 제거하기 위해 별도의 구현을 제공해야 합니다.
}