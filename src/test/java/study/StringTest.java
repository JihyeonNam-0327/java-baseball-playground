package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Nested
    @DisplayName("String 함수 테스트")
    class stringMethodTest {
        @Test
        @DisplayName("repace 테스트")
        void replace() {
            String actual = "abc".replace("b", "d");
            assertThat(actual).isEqualTo("adc");
        }

        @Test
        @DisplayName("split 테스트")
        void splitArray() {
            String testValue = "1,2";
            String[] splittedArray = testValue.split(",");
            assertThat(splittedArray).containsExactly("1","2");
        }

        @Test
        @DisplayName("없는 String으로 split 테스트")
        void split() {
            String testValue = "1";
            String[] splittedArray = testValue.split(",");
            assertThat(splittedArray).containsExactly("1");
        }

        @Test
        @DisplayName("substring 테스트")
        void substring() {
            String testValue = "(1,2)";
            String substringValue = testValue.substring(1,testValue.length() - 1);
            assertThat(substringValue).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("String 예외 테스트")
    class stringExceptionTest {
        @Test
        @DisplayName("Exception 테스트")
        void charAt() {
            String testValue = "abc";
            assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                        int index = testValue.charAt(5);
                    }).withMessageMatching("String index out of range: \\d+");
        }
    }
}
