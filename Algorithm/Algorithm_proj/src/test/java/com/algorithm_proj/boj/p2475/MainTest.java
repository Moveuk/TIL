package com.algorithm_proj.boj.p2475;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @CsvSource({
            "'0 4 2 5 6', '1'"
    })
    void mainTest(String input, String expectedOutput) throws IOException {
        // 입력값 설정
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 출력 캡처 설정
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // main 메서드 실행
        Main.main(new String[]{});

        // 실제 출력값과 비교
        assertEquals(expectedOutput, outContent.toString().trim());

        // 테스트 후 원래대로 복원
        System.setIn(System.in);
        System.setOut(System.out);
    }

}