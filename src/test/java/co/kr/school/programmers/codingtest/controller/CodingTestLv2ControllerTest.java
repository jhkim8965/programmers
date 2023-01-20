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
}