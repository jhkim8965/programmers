package co.kr.school.programmers.codingtest.controller;

import co.kr.school.programmers.codingtest.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class CodingTestLv0Controller {

    @Autowired
    private static CodingTestLv0Service codingTestLv0Service;

    public static void main(String[] args) {

        System.out.println("this is BeginnerController");
    }
}
