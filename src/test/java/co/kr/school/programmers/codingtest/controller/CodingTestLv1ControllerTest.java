package co.kr.school.programmers.codingtest.controller;

import co.kr.school.programmers.codingtest.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CodingTestLv1ControllerTest {

    @Autowired
    CodingTestLv1Service codingTestLv1Service;

    @Test
    @DisplayName("완주하지 못한 선수")
    void lesson_42576() {
        System.out.println("완주하지 못한 선수 테스트");
        codingTestLv1Service.lesson_42576();
    }

    @Test
    @DisplayName("체육복")
    void lesson_42862() {
        System.out.println("체육복");
        codingTestLv1Service.lesson_42862();
    }

    @Test
    @DisplayName("가장 가까운 같은 글자")
    void lesson_142086() {
        System.out.println("가장 가까운 같은 글자");
        codingTestLv1Service.lesson_142086();
    }

    @Test
    @DisplayName("로또의 최고 순위와 최저 순위")
    void lesson_77484() {
        System.out.println("로또의 최고 순위와 최저 순위");
        codingTestLv1Service.lesson_77484();
    }

    @Test
    @DisplayName("[카카오 인턴] 키패드 누르기")
    void lesson_67256() {
        System.out.println("[카카오 인턴] 키패드 누르기");
        codingTestLv1Service.lesson_67256();
    }

    @Test
    @DisplayName("크레인 인형뽑기 게임")
    void lesson_64061() {
        System.out.println("크레인 인형뽑기 게임");
        codingTestLv1Service.lesson_64061();
    }

    @Test
    @DisplayName("신규 아이디 추천")
    void lesson_72410() {
        System.out.println("신규 아이디 추천");
        String answer = codingTestLv1Service.lesson_72410("...!@BaT#*..y.abcdefghijklm");
        assertThat(answer).isEqualTo("bat.y.abcdefghi");

        answer = codingTestLv1Service.lesson_72410("z-+.^.");
        assertThat(answer).isEqualTo("z--");

        answer = codingTestLv1Service.lesson_72410("=.=");
        assertThat(answer).isEqualTo("aaa");
    }

    @Test
    @DisplayName("신규 아이디 추천 - 공부 참고용")
    void lesson_72410_bestAnswer_forStudy() {
        System.out.println("신규 아이디 추천 - 공부 참고용");
        String answer = codingTestLv1Service.lesson_72410_bestAnswer_forStudy("...!@BaT#*..y.abcdefghijklm");
        assertThat(answer).isEqualTo("bat.y.abcdefghi");

        answer = codingTestLv1Service.lesson_72410_bestAnswer_forStudy("z-+.^.");
        assertThat(answer).isEqualTo("z--");

        answer = codingTestLv1Service.lesson_72410_bestAnswer_forStudy("=.=");
        assertThat(answer).isEqualTo("aaa");
    }

    @Test
    @DisplayName("신고 결과 받기")
    void lesson_92334() {
        System.out.println("신고 결과 받기");

        // given
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        // when
        int[] answer = codingTestLv1Service.lesson_92334(id_list, report, k);
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

        // when
        int[] answer = codingTestLv1Service.lesson_150370(today, terms, privacies);
        for (int aswr : answer) {
            System.out.println("파기대상 = " + aswr);
        }

        // then
        assertThat(answer).isEqualTo(new int[]{1, 3});
    }

    @Test
    @DisplayName("성격 유형 검사하기")
    void lesson_118666() {
        // given
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        // when
        String answer = codingTestLv1Service.lesson_118666(survey, choices);
        System.out.println("answer = " + answer);

        // then
        assertThat(answer).isEqualTo("TCMA");
    }
}