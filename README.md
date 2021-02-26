# Kotlin
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
주석 /*
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