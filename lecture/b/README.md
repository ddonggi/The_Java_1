# 2부 함수형 인터페이스와 람다 표현식

## 함수형 인터페이스와 람다 표현식 소개

함수형 인터페이스 (Functional Interface)

- **추상 메소드** 를 딱 하나만 가지고 있는 인터페이스
- SAM (Single Abstract Method) 인터페이스
- [@FuncationInterface 애노테이션](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)을 가지고 있는 인터페이스

람다 표현식 (Lambda Expressions)

- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.

자바에서 함수형 프로그래밍

- 함수를 First class object로 사용할 수 있다.
- 순수 함수 (Pure function)
    - 사이드 이팩트가 없다. (함수 밖에 있는 값을 변경하지 않는다.)
    - 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다.)
- 고차 함수 (Higher-Order Function)
    - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
- 불변성

## 자바에서 제공하는 함수형 인터페이스

Java가 기본으로 제공하는 함수형 인터페이스

- [java.util.function 패키지](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
- 자바에서 미리 정의해둔 자주 사용할만한 함수 인터페이스
- Function<T, R>
- BiFunction<T, U, R>
- Consumer<T>
- Supplier<T>
- Predicate<T>
- UnaryOperator<T>
- BinaryOperator<T>

Function<T, R>

- T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
    - R apply(T t)
- 함수 조합용 메소드
    - andThen
    - compose

BiFunction<T, U, R>

- 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
    - R apply(T t, U u)

Consumer<T>

- T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
    - void Accept(T t)
- 함수 조합용 메소드
    - andThen

Supplier<T>

- T 타입의 값을 제공하는 함수 인터페이스
    - T get()

Predicate<T>

- T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
    - boolean test(T t)
- 함수 조합용 메소드
    - And
    - Or
    - Negate

UnaryOperator<T>

- Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스

BinaryOperator<T>

- BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스

## 람다 표현식

람다

- (인자 리스트) -> {바디}

인자 리스트

- 인자가 없을 때: ()
- 인자가 한개일 때: (one) 또는 one
- 인자가 여러개 일 때: (one, two)
- 인자의 타입은 생략 가능, 컴파일러가 추론(infer)하지만 명시할 수도 있다. (Integer one, Integer two)

바디

- 화상표 오른쪽에 함수 본문을 정의한다.
- 여러 줄인 경우에 { }를 사용해서 묶는다.
- 한 줄인 경우에 생략 가능, return도 생략 가능.

변수 캡처 (Variable Capture)

- 로컬 변수 캡처
    - final이거나 effective final 인 경우에만 참조할 수 있다.
    - 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일가 방지한다.
- effective final
    - 이것도 역시 자바 8부터 지원하는 기능으로 “사실상" final인 변수.
    - final 키워드 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조할 수 있다.
- 익명 클래스 구현체와 달리 ‘쉐도윙’하지 않는다.
    - 익명 클래스는 새로 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.

참고

- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#shadowing
- https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

## 메소드 레퍼런스

람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현할 수 있다.

메소드 참조하는 방법

| 스태틱 메소드 참조 | 타입::스태틱 메소드 |
| --- | --- |
| 특정 객체의 인스턴스 메소드 참조 | 객체 레퍼런스::인스턴스 메소드 |
| 임의 객체의 인스턴스 메소드 참조 | 타입::인스턴스 메소드 |
| 생성자 참조 | 타입::new |
- 메소드 또는 생성자의 매개변수로 람다의 입력값을 받는다.
- 리턴값 또는 생성한 객체는 람다의 리턴값이다.

참고

- https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
