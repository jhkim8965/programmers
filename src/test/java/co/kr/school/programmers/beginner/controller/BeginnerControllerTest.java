package co.kr.school.programmers.beginner.controller;

import co.kr.school.programmers.beginner.service.BeginnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BeginnerControllerTest {

    @Autowired
    BeginnerService beginnerService;

    @Test
    @DisplayName("캐릭터의 좌표")
    void lesson_120861() {
        System.out.println("캐릭터의 좌표 테스트");
        beginnerService.lesson_120861();
    }

    @Test
    @DisplayName("평행")
    void lesson_120875() {
        System.out.println("평행 테스트");
        beginnerService.lesson_120875();
    }

    @Test
    @DisplayName("옹알이")
    void lesson_120956() {
        System.out.println("옹알이 테스트");
        beginnerService.lesson_120956();
    }

    @Test
    @DisplayName("완주하지 못한 선수")
    void lesson_42576() {
        System.out.println("완주하지 못한 선수 테스트");
        beginnerService.lesson_42576();
    }

    @Test
    @DisplayName("체육복")
    void lesson_42862() {
        System.out.println("체육복");
        beginnerService.lesson_42862();
    }

    @Test
    @DisplayName("가장 가까운 같은 글자")
    void lesson_142086() {
        System.out.println("가장 가까운 같은 글자");
        beginnerService.lesson_142086();
    }
}