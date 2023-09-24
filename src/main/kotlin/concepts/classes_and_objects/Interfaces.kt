package concepts.classes_and_objects

fun main() {
    /* 인터페이스 */
    // 코틀린에서 인터페이스는 추상 메서드의 선언과 메서드 구현을 포함할 수 있습니다.
    // 추상 클래스와 다른 점은 인터페이스는 상태를 저장할 수 없다는 것입니다.
    // 프로퍼티를 가질 수 있지만, 추상이거나 접근자 구현을 제공해야 합니다.
    // 인터페이스는 interface 키워드를 사용하여 정의합니다.
    
    /*
    interface MyInterface {
        fun bar()
        fun foo() { // optional body
        }
    }
    */
    
    // 클래스나 객체는 하나 이상의 인터페이스를 구현할 수 있습니다.
    
    /*
    class Child : MyInterface {
        override fun bar() { // body
        }
    }
    */
    
    /* 인터페이스에서 프로퍼티 */
    // 인터페이스에서 프로퍼티를 선언할 수 있습니다.
    // 인터페이스에서 선언된 프로퍼티는 추상이거나 접근자에 대한 구현을 제공할 수 있습니다.
    // 인터페이스에서 선언된 프로퍼티는 백킹 필드를 가질 수 없으며, 따라서 인터페이스에서 선언된 접근자는 그들을 참조할 수 없습니다.
    
    /*
    interface MyInterface {
        val prop: Int // abstract

        val propertyWithImplementation: String
            get() = "foo"

        fun foo() {
            print(prop)
        }
    }

    class Child : MyInterface {
        override val prop: Int = 29
    }
    */
    
    /* 인터페이스 상속 */
    // 인터페이스는 다른 인터페이스에서 파생될 수 있습니다. 이는 멤버에 대한 구현을 제공하고 새 함수와 프로퍼티를 선언할 수 있다는 것을 의미합니다.
    // 당연히, 이러한 인터페이스를 구현하는 클래스는 누락된 구현을 정의해야 합니다.
    
    /*
    interface Named {
        val name: String
    }

    interface Person : Named {
        val firstName: String
        val lastName: String

        override val name: String get() = "$firstName $lastName"
    }

    data class Employee( // implementing 'name' is not required
        override val firstName: String, override val lastName: String, val position: Position
    ) : Person
    */
    
    /* 오버라이딩 충돌 해결 */
    // 슈퍼 타입 목록에서 많은 타입을 선언할 때, 동일한 메서드의 두 개 이상의 구현을 상속할 수 있습니다.
    
    /*
    interface A {
        fun foo() {
            print("A")
        }

        fun bar()
    }

    interface B {
        fun foo() {
            print("B")
        }

        fun bar() {
            print("bar")
        }
    }

    class C : A {
        override fun bar() {
            print("bar")
        }
    }

    class D : A, B {
        override fun foo() {
            super<A>.foo()
            super<B>.foo()
        }

        override fun bar() {
            super.bar()
        }
    }
    */
    
    // A와 B 인터페이스는 모두 foo()와 bar() 함수를 선언합니다.
    // 둘 다 foo()를 구현하지만, B만 bar()를 구현합니다. (bar()는 A에서 추상으로 표시되지 않습니다. 왜냐하면 이것은 함수가 본문이 없는 경우 인터페이스의 기본값이기 때문입니다.)
    // 이제 A에서 구체적인 클래스 C를 파생시키면, bar()를 오버라이드하고 구현을 제공해야 합니다.
    // 그러나 A와 B에서 D를 파생시키면, 여러 인터페이스에서 상속한 모든 메서드를 구현해야 하며, D가 어떻게 구현해야 하는지 정확히 지정해야 합니다.
    // 이 규칙은 단일 구현을 상속한 메서드 (bar())와 여러 구현을 상속한 메서드 (foo()) 모두에 적용됩니다.
}