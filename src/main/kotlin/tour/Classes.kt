package tour

fun main() {
    // 코틀린은 클래스와 객체를 사용하여 객체 지향 프로그래밍을 지원함.
    // 객체는 프로그램에서 데이터를 저장하는 데 유용합니다. 클래스를 사용하면 객체에 대한 특성 집합을 선언할 수 있음.
    // 클래스를 선언하려면 class 키워드를 사용
    
    /* Properties */
    // 클래스의 객체의 특성은 속성에 선언할 수 있음
    // 클래스 이름 뒤의 괄호 () 내에 속성을 선언
    
    // 중괄호 {}로 정의된 클래스 본문 내에서 선언
    
    /* class ContactWithProperty(val id: Int, var email: String) {
        val category: String = ""
    } */
    
    // 클래스의 인스턴스가 생성된 후에 변경해야 하는 경우를 제외하고는 속성을 읽기 전용 (val)으로 선언
    // 괄호 내에서 val 또는 var 없이 속성을 선언할 수 있지만 이러한 속성은 인스턴스가 생성된 후에는 액세스할 수 없음.
    // 괄호 () 내에 포함된 내용을 클래스 헤더라고 함.
    // 클래스 속성을 선언할 때 후행 쉼표를 사용 가능.
    // 함수 매개변수와 마찬가지로 클래스 속성에는 기본값을 지정할 수 있음.
    
    /* class ContactWithDefaultValue(val id: Int, var email: String = "example@gmail.com") {
        val category: String = "work"
    } */
    
    /* 인스턴스 생성 */
    // 클래스에서 객체를 생성하려면 생성자를 사용하여 클래스 인스턴스를 선언.
    // 기본적으로 Kotlin은 클래스 헤더에 선언된 매개변수로 생성자를 자동으로 생성.
    
    // 예를 들어:
    class Contact(var email: String)
    
    val contact = Contact("mary@gmail.com")
    
    // 예제에서:
    // Contact는 클래스.
    // contact는 Contact 클래스의 인스턴스.
    // id와 email은 프로퍼티입니다.
    // id와 email은 기본 생성자와 함께 사용하여 contact를 생성.
    // Kotlin 클래스에는 직접 정의한 것을 포함하여 여러 생성자가 있을 수 있음
    
    /* Access properties */
    // 인스턴스의 속성에 액세스하려면 인스턴스 이름 뒤에 마침표가 추가된 속성 이름을 작성.
    
    // Prints the value of the property: email
    println(contact.email)
    // mary@gmail.com
    // Updates the value of the property: email
    contact.email = "jane@gmail.com"
    // Prints the new value of the property: email
    println(contact.email)
    // jane@gmail.com
    
    // To concatenate the value of a property as part of a string, you can use string templates ($). For example:
    // 문자열의 일부로 속성의 값을 연결하려면 문자열 템플릿 ($)을 사용할 수 있음.
    
    println("Their email address is: ${contact.email}")
    // Their email address is: jane@gmailcom
    
    /* Member functions */
    // 객체의 특성의 일부로 속성을 선언하는 것 외에도 멤버 함수를 사용하여 객체의 동작을 정의할 수 있음.
    // 코틀린에서 멤버 함수는 클래스 본문 내에서 선언해야 함.
    // 인스턴스에서 멤버 함수를 호출하려면 인스턴스 이름 뒤에 마침표 (.)를 추가하여 함수 이름을 작성.
    
    // For example:
    //
    class ContactWithFunction(val id: Int, var email: String) {
        fun printId() {
            println(id)
        }
    }
    
    
    val contactWithFunction = ContactWithFunction(1, "mary@gmail.com")
    // Calls member function printId()
    contactWithFunction.printId()
    // 1
    
    /* Data classes */
    
    // 코틀린은 데이터를 저장하는 데 특히 유용한 데이터 클래스를 가지고 있음.
    // 데이터 클래스는 클래스와 동일한 기능을 가지고 있지만 추가 멤버 함수가 자동으로 제공됨.
    // 이러한 멤버 함수를 사용하면 인스턴스를 쉽게 읽을 수 있는 출력으로 인쇄하고 클래스의 인스턴스를 비교하고 인스턴스를 복사하고 기타 등등을 할 수 있음.
    // 이러한 함수들이 자동으로 사용 가능 하므로 각 클래스에 대해 동일한 보일러 플레이트 코드를 작성할 필요가 없음.
    
    // 데이터 클래스를 선언하려면 키워드 데이터를 사용.
    data class User(val name: String, val id: Int)
    
    // 데이터 클래스의 가장 유용한 미리 정의된 멤버 함수는 다음과 같음.
    
    /* Function */
    // .toString()
    // 클래스 인스턴스와 해당 속성의 읽기 쉬운 문자열을 출력.
    
    // .equals() or ==
    // 클래스의 인스턴스를 비교.
    
    // .copy()
    // 다른 클래스 인스턴스를 복사하여 클래스 인스턴스를 만듬. 일부 속성이 다를 수 있음.
    
    // Print as string
    // 클래스 인스턴스의 읽기 쉬운 문자열을 인쇄하려면 명시적으로 .toString() 함수를 호출하거나 .toString()을 자동으로 호출하는 인쇄 함수 (println() 및 print())를 사용할 수 있음.
    // 자동으로 toString() 함수를 사용하여 출력을 읽기 쉽게 만듭니다.
    
    // Compare instances
    // 데이터 클래스 인스턴스를 비교하려면 동등 연산자 ==를 사용.
    val user = User("Alex", 1)
    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)
    // user를 secondUser와 비교
    println("user == secondUser: ${user == secondUser}")
    // user == secondUser: true
    // user를 thirdUser와 비교
    println("user == thirdUser: ${user == thirdUser}")
    // user == thirdUser: false
    
    /* Copy instance */
    // 데이터 클래스 인스턴스의 정확한 사본을 만들려면 인스턴스에서 .copy() 함수를 호출.
    // 데이터 클래스 인스턴스의 사본을 만들고 일부 속성을 변경하려면 인스턴스에서 .copy() 함수를 호출하고 함수 매개변수로 속성에 대한 새 값을 추가.
    // 예를 들어:
    // user의 정확한 사본 생성.
    
    println(user.copy())
    // User(name = Alex, id = 1)
    // 이름이 "Max"인 user의 사본 생성.
    println(user.copy("Max"))
    // User(name=Max, id=1)
    
    // id가 3인 user의 사본 생성.
    println(user.copy(id = 3))
    // User(name=Alex, id=3)
    class Employee(s: String, i: Int) {
        var name = s
        var salary = i
    }
    
    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)
}

