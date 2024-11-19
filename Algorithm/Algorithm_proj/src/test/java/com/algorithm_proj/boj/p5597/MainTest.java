package com.algorithm_proj.boj.p5597;

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
            "'1\n3\n4\n5\n7\n9\n6\n10\n11\n12\n13\n14\n15\n16\n17\n18\n19\n20\n21\n22\n23\n24\n25\n26\n27\n28\n29\n30', '2\n8\n'",
            "'30\n9\n6\n12\n10\n20\n21\n11\n7\n5\n28\n4\n18\n29\n17\n19\n27\n13\n16\n26\n14\n23\n22\n15\n3\n1\n24\n25', '2\n8\n'"
    })
    void mainTest(String input, String expectedOutput) throws IOException {
        // 입력값 설정
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 출력 캡처 설정
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // main 메서드 실행
        Main.main(new String[]{}); // main 메서드 실행

        // 실제 출력값과 비교
        assertEquals(expectedOutput, outContent.toString());

        // 테스트 후 원래대로 복원
        System.setIn(System.in);
        System.setOut(System.out);
    }

}