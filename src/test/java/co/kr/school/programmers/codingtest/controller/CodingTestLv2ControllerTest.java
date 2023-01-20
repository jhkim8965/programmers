package co.kr.school.programmers.codingtest.controller;

import co.kr.school.programmers.codingtest.service.CodingTestLv2Service;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CodingTestLv2ControllerTest {

    @Autowired
    CodingTestLv2Service codingTestLv2Service;
}