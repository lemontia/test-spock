package demonic.testspock.service;

public class TestService {

    // 임의 값 리턴
    public int serviceValue(){
        return 2;
    }

    // 횟수점검 메서드
    public static boolean testCnt(){
        System.out.println("do TestService.testCnt");
        TestCntClass t = new TestCntClass();
        t.setValue(1);
        t.setValue(1);

        return true;
    }
}


class TestCntClass {
    private int value = 0;
    public void setValue(int a){
        System.out.println("do TestCntClass.setValue");
        this.value = a;
    }
}
