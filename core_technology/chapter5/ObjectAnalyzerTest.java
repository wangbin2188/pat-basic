package core_technology.chapter5;

import java.util.ArrayList;

/**
 * Created by wangbin10 on 2019/1/3.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(squares);
        System.out.println(new ObjectAnalyzerTest().toString());
//        System.out.println(new ObjectAnalyzer().toString(squares));

    }

    public String toString() {
        return  new ObjectAnalyzer().toString(this);
    }
}
