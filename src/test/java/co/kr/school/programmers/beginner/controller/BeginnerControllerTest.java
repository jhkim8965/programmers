package co.kr.school.programmers.beginner.controller;

import co.kr.school.programmers.beginner.service.BeginnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("로또의 최고 순위와 최저 순위")
    void lesson_77484() {
        System.out.println("로또의 최고 순위와 최저 순위");
        beginnerService.lesson_77484();
    }

    @Test
    @DisplayName("[카카오 인턴] 키패드 누르기")
    void lesson_67256() {
        System.out.println("[카카오 인턴] 키패드 누르기");
        beginnerService.lesson_67256();
    }

    @Test
    @DisplayName("크레인 인형뽑기 게임")
    void lesson_64061() {
        System.out.println("크레인 인형뽑기 게임");
        beginnerService.lesson_64061();
    }

    @Test
    @DisplayName("신규 아이디 추천")
    void lesson_72410() {
        System.out.println("신규 아이디 추천");
        String answer = beginnerService.lesson_72410("...!@BaT#*..y.abcdefghijklm");
        assertThat(answer).isEqualTo("bat.y.abcdefghi");

        answer = beginnerService.lesson_72410("z-+.^.");
        assertThat(answer).isEqualTo("z--");

        answer = beginnerService.lesson_72410("=.=");
        assertThat(answer).isEqualTo("aaa");
    }

    @Test
    @DisplayName("신규 아이디 추천 - 공부 참고용")
    void lesson_72410_bestAnswer_forStudy() {
        System.out.println("신규 아이디 추천 - 공부 참고용");
        String answer = beginnerService.lesson_72410_bestAnswer_forStudy("...!@BaT#*..y.abcdefghijklm");
        assertThat(answer).isEqualTo("bat.y.abcdefghi");

        answer = beginnerService.lesson_72410_bestAnswer_forStudy("z-+.^.");
        assertThat(answer).isEqualTo("z--");

        answer = beginnerService.lesson_72410_bestAnswer_forStudy("=.=");
        assertThat(answer).isEqualTo("aaa");
    }

    @Test
    @DisplayName("신고 결과 받기")
    void lesson_92334() {
        System.out.println("신고 결과 받기");

        // given
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        // when
        int[] answer = beginnerService.lesson_92334(id_list, report, k);
        for (int aswr : answer) {
            System.out.println("aswr = " + aswr);
        }

        // then
        assertThat(answer).isEqualTo(new int[]{2, 1, 1, 0});
    }

    @Test
    @DisplayName("개인정보 수집 유효기간")
    void lesson_150370() {
        System.out.println("개인정보 수집 유효기간");

        // given
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
////        String today = "2021.01.01";              // 파기
////        String today = "2020.12.27";              //
////        String today = "2020.12.01";              //
//        String today = "2020.11.28";              // 파기
////        String today = "2020.11.27";                //
//        String[] terms = {"A 12"};
//        String[] privacies = {"2019.12.01 A"};      // ~ 2020.11.28

        // when
        int[] answer = beginnerService.lesson_150370(today, terms, privacies);
        for (int aswr : answer) {
            System.out.println("파기대상 = " + aswr);
        }

        // then
        assertThat(answer).isEqualTo(new int[]{1, 3});
    }
}