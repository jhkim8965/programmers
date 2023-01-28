package co.kr.school.programmers.codingtest.controller;

import co.kr.school.programmers.codingtest.service.CodingTestLv2Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CodingTestLv2ControllerTest {

    @Autowired
    CodingTestLv2Service codingTestLv2Service;

    @Test
    @DisplayName("다리를 지나는 트럭")
    void lesson_42583(){
        // given
//        int bridge_length = 2;
        int bridge_length = 100;
//        int weight = 10;
        int weight = 100;
//        int[] truck_weights = {7, 4, 5, 6};
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        // when
        int answer = codingTestLv2Service.lesson_42583(bridge_length, weight, truck_weights);
        System.out.println("answer = " + answer);

        // then
//        assertThat(answer).isEqualTo(8);
        assertThat(answer).isEqualTo(110);
    }

    @Test
    @DisplayName("빛의 경로 사이클")
    void lesson_86052(){
        // given
//        String[] grid = {"SL", "LR"};
//        String[] grid = {"S"};
//        String[] grid = {"R", "R"};
        String[] grid = {"S", "S"};

        // when
        int[] answer = codingTestLv2Service.lesson_86052(grid);
        for (int aswr : answer) System.out.println("aswr = " + aswr);

        // then
//        assertThat(answer).isEqualTo(new int[]{16});
//        assertThat(answer).isEqualTo(new int[]{1, 1, 1, 1});
//        assertThat(answer).isEqualTo(new int[]{4, 4});
        assertThat(answer).isEqualTo(new int[]{1,1,1,1,2,2});
    }

    @Test
    @DisplayName("택배 배달과 수거하기")
    void lesson_150369() {
        // given
//        int cap = 4;
//        int n = 5;
//        int[] deliveries = {1, 0, 3, 1, 2};
//        int[] pickups = {0, 3, 0, 4, 0};
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};

        // when
        long answer = codingTestLv2Service.lesson_150369(cap, n, deliveries, pickups);
        System.out.println("answer = " + answer);

        // then
//        assertThat(answer).isEqualTo(16);
        assertThat(answer).isEqualTo(30);
    }
}