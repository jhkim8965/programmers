package co.kr.school.programmers.beginner.controller;

import co.kr.school.programmers.beginner.service.BeginnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BeginnerControllerTest {

    @Autowired
    BeginnerService beginnerService;

    @Test
    @DisplayName("캐릭터의 좌표")
    void lesson_120861() {
        System.out.println("sadasd");
        beginnerService.lesson_120861();
    }
}