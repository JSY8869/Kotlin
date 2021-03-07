# Kotlin
모든것이 객체
## Basic Syntax
### 패키지 정의
- 최상위에 정의
- 디렉터리와 패키지 일치시킬 필요X
### 함수 정의
- fun 키워드로 정의
```kotlin
fun sum(a: Int, b: Int): Int {
    return a+b
}

fun sum(a: Int, b: Int) = a+b
```
- 리턴 할 값이 없는 경우 Unit(Object)으로 리턴
- Unit은 Java에서 void 리턴 역할
- Unit은 생략 가능
### 지역 변수
- val: 읽기전용 변수, 즉시 할당
- Java의 final과 유사
- var: Mutable 변수
```kotlin
val a: Int = 1
val b = 2
var x = 5
x += 1
```
### 주석
```kotlin
// 주석
/* 주석
주석 */
```

### 문자열 템플릿
- 문자열 보간법
```kotlin
var a = 1
val s1 = "a is $a"
a = 2
val s2 = "${s1.replace("is","was")}, but now is $a"
```

### 조건문
```kotlin
fun maxOf(a: Int, b: Int) = if (a>b) a else b
```

### nullable
- 값이 null일 수 있는 경우 타입에 nullable 마트를 명시 해야 함
- `?` 사용
```kotlin
fun parseInt(str: String): Int? {
    // 정수가 아닌 경우 null을 리턴함
}
```

### 자동 타입 변환
- `Any` 사용
```kotlin
fun getStringLength(obj: Any): Int? {
    if(obj is String) {
        return obj.length
    }
    return null
}
```

### when
- 조건문 종합버전
```kotlin
fun describe(obj: Any): String =
    when(obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "LONG"
        !is String -> "Not a String"
        else -> "Unknown"
    }
```

### ranges
- `in` 사용
- `for (x in 1..5)`
```kotlin
val x = 3
if (x in 1..10) {
    println("fits in range")
}
```

### Collections
- list는 `lisOf`, `setOf` 사용해서 선언
- filter, map등의 연산 가능
## Basic Types
### 배열
- 배열은 Array 클래스로 표현
- get, set
```kotlin
var array: Array<String> = arrayOf("코틀린", "강의")
println(array.get(0))
println(array[0])

val b = Array(5, {i -> i.toString() })
// b = [0, 1, 2, 3, 4]
```

### 문자열 리터럴
- raw String("""Kotlin""")
- \n사용하지 않고 그냥 엔터로 입력 가능
```kotlin
val s = """
"'이것은 코틀린의
raw String
입니다.'"
"""
```

## Control Flow
### when
- when 사용 시 else 필수
- 여러개의 조건 사용 시 `,` 사용
- 조건에 함수나 식 사용 가느
## Packages, Return and Jumps
### Packages
- import as 사용 가능
- Package 미선언시 기본 Package에 들어감
### Return and Jumps
- Label -> 식별자 + @ 사용
- return continue break 사용 가능
- 암시적 레이블 (람다가 사용된 함수의 이름과 동일)

## Class
### 기본생성자
- `class 이름 constructor(Name: String){}`
- 초기화는 초기화 블록 안에서 작성
- init 블록 안에서 작성
```kotlin
class Customer(name: String){
    init{
        logger.info(")
    }
}
```

### 보조생성자
- 클래스가 기본생성자를 가지고 있다면, 보조생성자들은 기본생성자를 직접 or 간접적으로 위임해 주어야 함
```kotlin
class Person(val name: String){
    constructor(naem: String, parent: Person) : this(name){}
    // 직접

    constructor() : this("홍길동", Person()){}
    // 간접
}
```

### 인스턴스 생성
- new 키워드 없음
- 생성자를 함수처럼 호출 하면 됨

## Inheritance
### 상속
- 코틀린의 최상위 클래스는 Any
- 상위타입을 선언하지 않으면 Any가 상속됨
- 부모를 open으로 선언 해줘야 상속 가능
### 오버라이딩
- open으로 선언된 함수만 override 가능
- open으로 선언된 프로퍼티만 override 가능
### 추상 클래스
- 구현 x
- abstract 클래스
- 추상 메서드 생성 가능
- open 필요 x

## Properties and Fields
### 프로퍼티
- var(mutable), val(read-only)로 선언
- getter, setter 사용(생략가능)
### Field
- 코틀린은 자동으로 생성해줌
- 프로퍼티의 accessor에서만 field라는 식별자를 사용
- accessor중 1개라도 기본 구현을 하는 경우, custom accessor에서 참조한 경우 생성됨

## Data Classes
### Data 클래스
- DB
- equals, hashCode, copy, toString, comonentN 자동으로 생성해 줌
- 기본생성자에 1개 이상의 파라매터 있어야 함(var, val)
```kotlin
data class User(var value: String)

val obj = User("Kotlin")
val obj2 = obj.copy("Kotlin!!")
```
- `var(name, age) = "1", 1` 이렇게도 선언 가능
- `pair`, `Triple` 스탠다드 라이브러리도 있음
### 중첩 클래스
- 클래스 내에 클래스 선언 및 사용 가능
- 내부 클래스는 아니고 중첩일 뿐임
- `Outer.inner().function()`
### 내부 클래스
- 클래스 내에 inner로 새로운 클래스 선언
- `Outer().inner().function()`
## Object
### 용도
- 어떤 class에서 조금 변경된 객체를 생성 할 때
- 새로운 subclass의 명시적인 선언 없이 객체 생성
- private으로 사용하는게 좋음
- 객체 몸체에서 외부의 변수에도 접근 가능
- Companion Object -> static
```kotlin
fun main() {
    val t = Thread(object : Runnable {
        override fun run() {
            println("Hi")
        }
    })
    t.run()

    val data = object{
    var x = 1
    var y = 2
    }
}
```
### 객체 선언
- object 키워드 뒤에 이름
### Companion Object
- companion object의 멤버는 클래스 이름을 통해서 호출 가능