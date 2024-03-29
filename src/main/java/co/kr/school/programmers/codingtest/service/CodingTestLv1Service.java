package co.kr.school.programmers.codingtest.service;

import co.kr.school.programmers.codingtest.lessons.lv1.*;
import org.springframework.stereotype.Component;

@Component
public class CodingTestLv1Service {

    /**
     * 코딩테스트 lv1: 완주하지 못한 선수
     */
    public void lesson_42576() { Lesson_42576 lesson_42576 = new Lesson_42576(); }

    /**
     * 코딩테스트 lv1: 체육복
     */
    public void lesson_42862() { Lesson_42862 lesson_42862 = new Lesson_42862(); }

    /**
     * 코딩테스트 lv1: 가장 가까운 같은 글자
     */
    public void lesson_142086() { Lesson_142086 lesson_142086 = new Lesson_142086(); }

    /**
     * 코딩테스트 lv1: 로또의 최고 순위와 최저 순위
     */
    public void lesson_77484() { Lesson_77484 lesson_77484 = new Lesson_77484(); }

    /**
     * 코딩테스트 lv1: [카카오 인턴] 키패드 누르기
     */
    public void lesson_67256() { Lesson_67256 lesson_67256 = new Lesson_67256(); }

    /**
     * 코딩테스트 lv1: 크레인 인형뽑기 게임
     */
    public void lesson_64061() { Lesson_64061 lesson_64061 = new Lesson_64061(); }

    /**
     * 코딩테스트 lv1: 신규 아이디 추천
     */
    public String lesson_72410(String new_id) { return new Lesson_72410(new_id).getResult(); }
    public String lesson_72410_bestAnswer_forStudy(String new_id) { return new Lesson_72410_bestAnswer_forStudy(new_id).getResult(); }

    /**
     * 코딩테스트 lv1: 신고 결과 받기
     */
    public int[] lesson_92334(String[] id_list, String[] report, int k) { return new Lesson_92334(id_list, report, k).getResult(); }

    /**
     * 코딩테스트 lv1: 개인정보 수집 유효기간
     */
    public int[] lesson_150370(String today, String[] terms, String[] privacies) { return new Lesson_150370(today, terms, privacies).getAnswer(); }

    /**
     * 코딩테스트 lv1: 성격 유형 검사하기
     */
    public String lesson_118666(String[] survey, int[] choices) { return new Lesson_118666(survey, choices).getAnswer(); }
}
