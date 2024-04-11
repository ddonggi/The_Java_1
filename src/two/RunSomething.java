package two;

/**
 * PackageName : two
 * FileName : RunSomthing
 * Author : dglee
 * Create : 4/11/24 11:34PM
 * Description :
 **/

//함수형 인터페이스를 정의할 때는 @FunctionalInterface 어노테이션을 사용하면 좋다. -> 추상 메소드를 2개 이상 쓰면 Compile 할때 체크해준다.
@FunctionalInterface
public interface RunSomething {
    abstract void doIt(); //추상 메소드(abstract 생략 가능)가 하나만 있으면 함수형 인터페이스 이다.

//    void doItAgain(); //추상 메소드가 하나 더 있으면 함수형 인터페이스가 아니다.

    //Java 8 부터 public(생략가능) static 메소드와 default 메소드를 정의할 수 있다.
    public static void printName() {
        System.out.println("dglee");
    }

    //인터페이스에 정의할 수 있는 메소드의 형태 (접근제어자 활용이)가 다양해졌다
    public default void printAge() {
        System.out.println("30");
    }

    // 다른 형태의 메소드가 있더라도, 추상 메소드가 하나라면 함수형 인터페이스 이다.
}
