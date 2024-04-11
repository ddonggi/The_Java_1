# 1강 자바 8 소개
## 자바 8 소개

자바 8

- LTS 버전
- 출시일: 2014년 3월
- 최근 업데이트: [2020년 4월, JDK 8u251](https://www.oracle.com/technetwork/java/javase/8u251-relnotes-5972664.html)
- 2014년 기준 자바 개발자 중 약 83%가 사용중.
    - https://www.jetbrains.com/lp/devecosystem-2019/java/
- 2023년 기준 : Java 8 50% / Java 17 45% / Java 11 38%
  - https://www.jetbrains.com/lp/devecosystem-2023/java/
  
LTS(Long-Term-Support)와 비-LTS 버전의 차이

- 비-LTS는 업데이트 제공 기간이 짧다.
- 비-LTS 배포 주기 6개월
- 비-LTS 지원 기간은 배포 이후 6개월
- LTS 배포 주기 3년 (매 6번째 배포판이 LTS가 된다.)
- LTS 지원 기간은 5년이상으로 JDK를 제공하는 밴더와 이용하는 서비스에 따라 다르다.
- 실제 서비스 운영 환경(production)에서는 LTS 버전을 권장한다.
- [Moving Java Forward Faster](https://mreinhold.org/blog/forward-faster)Mark Reinhold
- 다음 LTS: 자바 17
- 매년 3월과 9월에 새 버전 배포

“I propose that after Java 9 we adopt a strict, time-based model with a new feature release every six months, update releases every quarter, and a **long-term support** release every three years.”

주요 기능

- 람다 표현식
- 메소드 레퍼런스
- 스트림 API
- Optional<T>
- ...

JDK 다운로드

- 오라클 JDK
    - https://www.oracle.com/java/technologies/javase-downloads.html
- 오픈 JDK
    - 오라클: https://jdk.java.net/14/
    - AdoptOpenJDK: https://adoptopenjdk.net/
    - Amazon Corretto
    - Azul Zulu
    - ...
---
## Java 8로 무엇을 할 수 있을까?
2014년 3월에 처음 출시했고 6년이 넘게 지난 지금도 자바 개발자가 가장 많이 사용하고 있는 자바 버전인 자바 8에 대해 학습합니다.

자바 기초 공부는 마쳤지만 그래도 뭔가 아직 자바에 대해 잘 모르겠고 다른 사람이 작성한 코드를 볼 때 생소한 문법이 보인다면 아마도 자바 8에 추가된 기능을 제대로 이해하지 못했기 때문일 수도 있습니다.

---

자 보시죠! 여기 Chicken이라는 인터페이스를 구현한 기선닭이 있습니다.

```java
public class KeesunChicken implements Chicken {

}
```

보시다시피 인터페이스만 구현했을 뿐, 아무런 메소드도 오버라이딩하지 않았죠. 하지만 이런게 가능합니다.

```java
public class App {
	public static void main(String[] args) {
		Chicken keesun = new KeesunChicken();
		Egg egg = keesun.create();
	}
}
```

도대체 Egg를 리턴하는 create() 메소드는 어떻게 쓸 수 있게 된 걸까요?

---

자, 다음 코드를 보시죠. 여기 닭 한마리가 있습니다. 커서 반반 치킨이 되고 싶은 달걀을 보살피고 있네요.

```java
Chicken.takesCare(new Egg() {
	@Override
	public String wannaBe() {
		return "양념반 후라이드반";
	}
});
```

---

이 코드는 줄여서 이렇게 쓸 수도 있습니다.

```java
Chicken.takesCare(() -> "양념반 후라이드반");
```

어떻게 이렇게 Egg라는 타입을 쓰지도 않고 깔끔하게 줄일 수 있는지 궁금하신가요?

---

이번에는 달걀을 분류해 봅시다.

```java
List<EggWithColorAndSize> eggs = new ArrayList<>();
eggs.add(EggWithColorAndSize.of().size(3).color("yellow"));
eggs.add(EggWithColorAndSize.of().size(4).color("white"));
eggs.add(EggWithColorAndSize.of().size(3).color("white"));
eggs.add(EggWithColorAndSize.of().size(5).color("yellow"));
eggs.add(EggWithColorAndSize.of().size(3).color("brown"));
eggs.add(EggWithColorAndSize.of().size(4).color("yellow"));
```

---

여기 보이는 달걀들 중에 색이 yellow인 달걀만 골라서 사이즈 별로 정렬한 다음, 달걀의 wannaBe를 출력해 봅시다.

이 강의를 들으신다면 다음과 같이 코드를 작성할 수 있고 이해할 수 있습니다.

```java
eggs.stream().filter(e -> e.getColor().equals("yellow"))
.sorted(Comparator.comparingInt(EggWithColorAndSize::getSize))
.map(EggWithColorAndSize::wannaBe)
.forEach(System.out::println);
```

---

별도의 쓰레드로 알을 낳는 작업을 실행하고 알을 낳으면 (콜백으로) 맛있게 먹는 다음과 같은 코드도 이해하고 작성할 수 있습니다.

```java
CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
System.out.println("꼬기오~ 꼬꼬꼬꼬~ " + Thread.currentThread().getName());
return EggWithColorAndSize.of().size(5).color("white");
}).thenAccept((egg) -> {
System.out.println("냠냠냠: " + egg.wannaBe());
});
future.get();
```

---

이밖에도 자바 8이 제공하는 Date와 Time API, 애노테이션의 활용성을 증진 시킨 변화, 메모리 영역의 중요한 변화 등 중요하고 재미있는 내용이 많으니 수강 부탁드립니다.

감사합니다.



참고

- https://www.oracle.com/java/technologies/java-se-support-roadmap.html
- https://www.javacodegeeks.com/2019/07/long-term-support-mean-openjdk.html
- https://en.wikipedia.org/wiki/Java_version_history
