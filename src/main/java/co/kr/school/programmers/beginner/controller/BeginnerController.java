package co.kr.school.programmers.beginner.controller;

import co.kr.school.programmers.beginner.service.BeginnerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

public class BeginnerController {

    @Autowired
    private static BeginnerService beginnerService;

    public static void main(String[] args) {

        System.out.println("this is BeginnerController");
    }
}
