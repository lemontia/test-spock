package demonic.testspock

import demonic.testspock.service.TestCntClass
import demonic.testspock.service.TestService
import spock.lang.Specification

// Mock 테스트 클래스
class SpockMockTest extends Specification {
    def "Mock 테스트 클래스"(){
        given:
        def testService = Mock(TestService.class);
        println testService

        when:
        int a = testService.serviceValue()

        then:
        // 거짓으로 객체반환을 99로 함. when 에서 a 로 넣게 했으므로 삽입
        testService.serviceValue() >> 3
        3==a
        println "result: " + a
    }
}