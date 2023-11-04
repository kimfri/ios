package org.kimfri.ios.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringUtilsTest {

  @BeforeEach
  void setUp() {
  }

  @Nested
  class Concatenate {
    @ParameterizedTest
    @MethodSource("possibleNullValues")
    void givenAnyArgumentIsNull_thenReturnNull(List<String> stringList, String delimiter) {
      assertNull(StringUtils.concatenate(stringList, delimiter));
    }

    @ParameterizedTest
    @MethodSource("nonNullValues")
    void givenNonNullValues_CorrectValueIsReturned(List<String> stringList,
                                                   String delimiter,
                                                   String expected) {
      assertEquals(StringUtils.concatenate(stringList, delimiter), expected);
    }

    private static Stream<Arguments> nonNullValues() {
      final String delimiter = ",";
      return Stream.of(
          arguments(List.of("abc", "def"), delimiter, "abc,def"),
          arguments(List.of("abc"), delimiter, "abc")
      );
    }

    private static Stream<Arguments> possibleNullValues() {
      return Stream.of(
          arguments(null, null),
          arguments(null, ","),
          arguments(List.of("abc"), null)
      );
    }
  }
}
