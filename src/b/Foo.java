package b;

/**
 * PackageName : two
 * FileName : Foo
 * Author : dglee
 * Create : 4/11/24 11:48 PM
 * Description :
 **/

public class Foo {
    public static void main(String[] args) {
        //Java 8 이전엔 구현체 생성 / 익명 내부 클래스 anonymous inner class
/*        RunSomething runSomething = new RunSomething(){
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };*/

        //Java 8 부터는 줄여서 쓸 수 있는 람다식
//        RunSomething runSomething = () -> System.out.println("Hello");
        //마치 함수를 정의한것 처럼 보이지만, 자바에서는 특수한 형태의 객체(오브젝트)라고 볼 수 있다.
        //변수에 할당하고, 메소드의 파라미터에 전달하거나, 리턴타입으로 리턴할 수도 있다.
        //고차 함수 : 함수가 함수를 매개변수로 받거나 함수가 함수를 리턴할 수 있다.

        RunSomething runSomething = () -> {
            System.out.println("Hello");
            System.out.println("Lambda");
        };
        runSomething.doIt();


        /*- 순수 함수 (Pure function)
        - 사이드 이팩트가 없다. (함수 밖에 있는 값을 변경하지 않는다.)
        - 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다.)
        */
/*        ReturnSomething returnSomething = new ReturnSomething() {
            int baseNumber = 10; // 상태값을 가지고 있다(즉 의존중이기에 퓨어한 함수라고 볼 수 없다)
            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };*/
//        ReturnSomething returnSomething = number -> number + 10;
        ReturnSomething returnSomething = number -> {
            return number + 10;
        };
        System.out.println(returnSomething.doIt(1)); //입력 받은 값이 동일한 경우, 결과값이 같아야 한다;
        System.out.println(returnSomething.doIt(1));
        System.out.println(returnSomething.doIt(2));
        System.out.println(returnSomething.doIt(3));
    }
}
