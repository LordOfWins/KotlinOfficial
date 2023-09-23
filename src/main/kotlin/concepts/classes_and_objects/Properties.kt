package concepts.classes_and_objects

fun main() {
    /* 프로퍼티 */
    // 프로퍼티 선언
    // 코틀린 클래스의 프로퍼티는 var 키워드를 사용하여 변경 가능하게 선언하거나, val 키워드를 사용하여 읽기 전용으로 선언할 수 있습니다.
    
    /*
    class Address {
        var name: String = "Holmes, Sherlock"
        var street: String = "Baker"
        var city: String = "London"
        var state: String? = null
        var zip: String = "123456"
    }
    */
    
    // 프로퍼티를 사용하려면, 이름으로 참조하면 됩니다.
    
    /*
    fun copyAddress(address: Address): Address {
        val result = Address() // there's no 'new' keyword in Kotlin
        result.name = address.name // accessors are called
        result.street = address.street
        // ...
        return result
    }
    */
    
    /* 접근자와 설정자 */
    // 프로퍼티를 선언하는 전체 구문은 다음과 같습니다.
    
    /*
    var <propertyName>[: <PropertyType>] [= <property_initializer>]
        [<getter>]
        [<setter>]
    */
    
    // 초기화, getter, setter는 선택적입니다.
    // 프로퍼티 타입은 초기화나 getter의 반환 타입에서 추론될 수 있다면 선택적입니다.
    
    /*
    var initialized = 1 // 타입 Int, 기본 getter와 setter를 가집니다.
    */
    
    /*
    var allByDefault // 오류: 명시적 초기화가 필요합니다. 기본 getter와 setter가 암시됩니다.
    */
    
    // 읽기 전용 프로퍼티 선언의 전체 구문은 변경 가능한 프로퍼티와 두 가지 방법으로 다릅니다.
    // var 대신 val로 시작하며 setter를 허용하지 않습니다.
    
    // val simple: Int? // 타입 Int, 기본 getter, 생성자에서 초기화해야 합니다.
    
    // val inferredType = 1 // 타입 Int, 기본 getter를 가집니다.
    
    // 프로퍼티에 대한 사용자 정의 접근자를 정의할 수 있습니다.
    // getter를 정의하면, 프로퍼티에 접근할 때마다 호출됩니다. (이 방법으로 계산된 프로퍼티를 구현할 수 있습니다.)
    // 다음은 사용자 정의 getter의 예입니다.
    
    /*
    class Rectangle(val width: Int, val height: Int) {
        val area: Int // property type is optional since it can be inferred from the getter's return type
            get() = this.width * this.height
    }
    */
    
    // getter에서 타입을 추론할 수 있다면, 프로퍼티 타입을 생략할 수 있습니다.
    
    /*
    val area get() = this.width * this.height
    */
    
    // setter를 정의하면, 초기화를 제외하고 프로퍼티에 값을 할당할 때마다 호출됩니다.
    // 사용자 정의 setter는 다음과 같습니다.
    /*
    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            setDataFromString(value) // parses the string and assigns values to other properties
    }
    */
    // setter 파라미터의 이름은 value로 관례적으로 정해져 있지만, 원한다면 다른 이름을 선택할 수 있습니다.
    // 접근자를 주석 처리하거나 가시성을 변경해야 하지만, 기본 구현을 변경하고 싶지 않다면, 접근자의 본문을 정의하지 않고 접근자를 정의할 수 있습니다.
    
    /*
    var setterVisibility: String = "abc"
        private set // the setter is private and has the default implementation

    var setterWithAnnotation: Any? = null
        @Inject set // annotate the setter with Inject
    */
    
    /* 백킹 필드 */
    // 코틀린에서 필드는 메모리에 값을 보관하기 위해 프로퍼티의 일부로만 사용됩니다.
    // 필드는 직접 선언할 수 없습니다.
    // 그러나 프로퍼티가 백킹 필드가 필요할 때, 코틀린은 자동으로 제공합니다.
    // 이 백킹 필드는 접근자에서 field 식별자를 사용하여 참조할 수 있습니다.
    
    /*
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
                // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
    }
    */
    
    // field 식별자는 프로퍼티의 접근자에서만 사용할 수 있습니다.
    // 백킹 필드는 프로퍼티가 최소 한 개 접근자의 기본 구현을 사용하거나, 사용자 정의 접근자가 field 식별자를 통해 참조하는 경우에 생성됩니다.
    // 예를 들어, 다음과 같은 경우에는 백킹 필드가 없습니다.
    
    /*
    val isEmpty: Boolean
        get() = this.size == 0
    Backing properties
    */
    
    // 이 암시적 백킹 필드 체계에 맞지 않는 작업을 수행하려면, 항상 백킹 프로퍼티를 가질 수 있습니다.
    
    /*
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // Type parameters are inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
    }
    */
    
    // JVM에서: 기본 getter와 setter를 가진 private 프로퍼티에 대한 접근은 함수 호출 오버헤드를 피하기 위해 최적화됩니다.
    
    /* 컴파일 타임 상수 */
    // 읽기 전용 프로퍼티의 값이 컴파일 타임에 알려져 있다면, const 한정자를 사용하여 컴파일 타임 상수로 표시합니다.
    // 이러한 프로퍼티는 다음 요구 사항을 충족해야 합니다.
    // 최상위 프로퍼티이거나, 객체 선언의 멤버이거나, 동반 객체의 멤버여야 합니다.
    // String 또는 원시 타입의 값으로 초기화되어야 합니다.
    // 사용자 정의 getter가 될 수 없습니다.
    // 컴파일러는 상수의 사용을 인라인하고, 상수에 대한 참조를 실제 값으로 대체합니다.
    // 그러나, 필드는 제거되지 않으므로, 리플렉션을 사용하여 상호 작용할 수 있습니다.
    // 이러한 프로퍼티는 어노테이션에서도 사용할 수 있습니다.
    
    /*
    const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
    @Deprecated(SUBSYSTEM_DEPRECATED) fun foo() { ... }
    */
    
    /* 지연 초기화 프로퍼티와 변수 */
    // 일반적으로, null이 아닌 타입을 가진 프로퍼티는 생성자에서 초기화되어야 합니다.
    // 그러나, 이렇게 하는 것이 편리하지 않은 경우가 많습니다.
    // 예를 들어, 프로퍼티는 의존성 주입을 통해 초기화되거나, 유닛 테스트의 setup 메소드에서 초기화될 수 있습니다.
    // 이러한 경우에는 생성자에서 null이 아닌 초기화자를 제공할 수 없지만, 클래스의 본문에서 프로퍼티를 참조할 때 null 체크를 피하려고 합니다.
    // 이러한 경우를 처리하기 위해, 프로퍼티에 lateinit 한정자를 표시할 수 있습니다.
    
    /*
    public class MyTest {
        lateinit var subject: TestSubject

        @SetUp fun setup() {
            subject = TestSubject()
        }

        @Test fun test() {
            subject.method()  // dereference directly
        }
    }
    */
    
    // 이 한정자는 클래스의 본문 (기본 생성자가 아닌 경우, 그리고 프로퍼티에 사용자 정의 getter 또는 setter가 없는 경우)에 선언된 var 프로퍼티뿐만 아니라, 최상위 프로퍼티와 로컬 변수에도 사용될 수 있습니다.
    // 프로퍼티 또는 변수의 타입은 null이 아니어야 하며, 원시 타입이어서는 안 됩니다.
    // 초기화되기 전에 lateinit 프로퍼티에 접근하면, 접근한 프로퍼티와 초기화되지 않았다는 사실을 명확히 식별하는 특수 예외가 발생합니다.
    
    /* lateinit var가 초기화되었는지 확인하기 */
    // lateinit var가 이미 초기화되었는지 확인하려면, 해당 프로퍼티에 대한 참조에서 .isInitialized를 사용하십시오.
    
    /*
    if (foo::bar.isInitialized) {
        println(foo.bar)
    }
    */
    
    // 이 체크는 동일한 타입에서 선언될 때, 외부 타입 중 하나에서 선언될 때 또는 동일한 파일의 최상위 수준에서 선언될 때 구문적으로 접근 가능한 프로퍼티에만 사용할 수 있습니다.
    
    /* 위임된 프로퍼티 */
    // 가장 일반적인 종류의 프로퍼티는 백킹 필드에서 간단히 읽기만 하고 (아마도 쓰기도 하지만), 사용자 정의 getter와 setter를 사용하여 프로퍼티의 어떤 동작이든 구현할 수 있습니다.
    // 첫 번째 종류의 단순함과 두 번째 종류의 다양성 사이 어딘가에는 프로퍼티가 수행할 수 있는 일반적인 패턴이 있습니다.
    // 몇 가지 예: 지연된 값, 주어진 키로 맵에서 읽기, 데이터베이스 접근, 접근 시 리스너에게 알림.
    // 이러한 일반적인 동작은 위임된 프로퍼티를 사용하여 라이브러리로 구현할 수 있습니다.
}