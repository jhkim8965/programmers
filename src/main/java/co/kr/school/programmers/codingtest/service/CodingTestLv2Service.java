package co.kr.school.programmers.codingtest.service;

import co.kr.school.programmers.codingtest.lessons.lv2.Lesson_42583;
import org.springframework.stereotype.Component;

@Component
public class CodingTestLv2Service {

    /**
     * 코딩테스트 Lv2: 다리를 지나는 트럭
     */
    public int lesson_42583(int bridge_length, int weight, int[] truck_weights) { return new Lesson_42583(bridge_length, weight, truck_weights).getAnswer(); }
}