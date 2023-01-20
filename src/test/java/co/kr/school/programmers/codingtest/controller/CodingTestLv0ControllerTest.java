package co.kr.school.programmers.codingtest.controller;

import co.kr.school.programmers.codingtest.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CodingTestLv0ControllerTest {

    @Autowired
    CodingTestLv0Service codingTestLv0Service;

    @Test
    @DisplayName("캐릭터의 좌표")
    void lesson_120861() {
        System.out.println("캐릭터의 좌표 테스트");
        codingTestLv0Service.lesson_120861();
    }

    @Test
    @DisplayName("평행")
    void lesson_120875() {
        System.out.println("평행 테스트");
        codingTestLv0Service.lesson_120875();
    }

    @Test
    @DisplayName("옹알이")
    void lesson_120956() {
        System.out.println("옹알이 테스트");
        codingTestLv0Service.lesson_120956();
    }
}