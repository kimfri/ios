package org.kimfri.ios.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
      assertThat(StringUtils.concatenate(stringList, delimiter)).isNull();
    }

    @ParameterizedTest
    @MethodSource("nonNullValues")
    void givenNonNullValues_CorrectValueIsReturned(List<String> stringList,
                                                   String delimiter,
                                                   String expected) {
      assertThat(StringUtils.concatenate(stringList, delimiter))
          .as("Returnvalue should have been: %s", expected)
          .isEqualTo(expected);
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
