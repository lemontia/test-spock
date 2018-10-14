package demonic.testspock

import spock.lang.Specification

// Specification 를 extends 하면 테스트클래스가 된다.
class TestSpockApplicationTest extends Specification {

    def "Spock 테스트 입니다"(){
        // given: 테스트 하기 위한 기본 설정작업
        given:
        List<Integer> list = new ArrayList<>();

        // 테스트할 대상 코드를 실행
        when:
        list.add(2)

        // 테스트 결과 검증
        then:
        2==list.get(0)
    }

    // when, then 대신 expect 사용하기.
    def "Spock expect 테스트"() {

        // 대상 코드를 실행 + 검증합니다.
        // a와 b를 메서드에 넣은 후 결과값을 c에 저장합니다.
        expect:
        Math.max(a, b) == c

        // feature 메소드를 파라미터로 삼아 실행시킵니다.
        // a라인과 b라인 c라인이 각각 변수이며
        // a=4, b=1, c=4 로 실행한 후 다음줄을 또 실행합니다.
        // feature 메소드를 파라미터로 변환하여 실행합니다.
        where:
        a | b | c
        4 | 1 | 4
        3 | 9 | 9
        7 | 4 | 7
    }

    def "Exception 테스트"(){
        given:
        def testExceptionClass = new TestExceptionClass();
        def a = 0;
        println "=== Exception 테스트 Start "

        when:
        a = testExceptionClass.testValue(1)

        then:
        def e = thrown(RuntimeException.class)
        println "exception message: " + e.message
        // exception 이 발생했기 때문에 아래 a 는 0 이 들어있다.
        1 == a
    }
}


class TestExceptionClass {
    // 1 값을 return 함
    public static int testValue(int a){
        throw new RuntimeException("테스트 Exception 입니다");
        return a;
    }
}
