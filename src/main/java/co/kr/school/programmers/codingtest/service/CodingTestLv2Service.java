package co.kr.school.programmers.codingtest.service;

import co.kr.school.programmers.codingtest.lessons.lv2.*;
import org.springframework.stereotype.Component;

@Component
public class CodingTestLv2Service {

    /**
     * 코딩테스트 Lv2: 다리를 지나는 트럭
     */
    public int lesson_42583(int bridge_length, int weight, int[] truck_weights) { return new Lesson_42583(bridge_length, weight, truck_weights).getAnswer(); }

    /**
     * 코딩테스트 Lv2: 빛의 경로 사이클
     */
    public int[] lesson_86052(String[] grid) { return new Lesson_86052_new(grid).getAnswer(); }

    /**
     * 코딩테스트 Lv2: 택배 배달과 수거하기
     */
    public long lesson_150369(int cap, int n, int[] deliveries, int[] pickups) { return new Lesson_150369(cap, n, deliveries, pickups).getAnswer(); }

    /**
     * 코딩테스트 Lv2: 택배 배달과 수거하기
     */
    public long lesson_150369_greedy(int cap, int n, int[] deliveries, int[] pickups) { return new Lesson_150369_greedy(cap, n, deliveries, pickups).getAnswer(); }
}