package org.kimfri.ios.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringUtilsTest {

  @BeforeEach
  void setUp() {
  }

  @Nested
  class Concatenate {
    @Test
    void givenNullAsList_thenReturnNull() {
      assertNull(StringUtils.concatenate(null, ""));
    }

    @Test
    void givenNullAsDelimiter_thenReturnNull() {
      assertNull(StringUtils.concatenate(List.of(""), null));
    }

    @Test
    void givenNullForBothArguments_thenReturnNull() {
      assertNull(StringUtils.concatenate(null, null));
    }

    @Test
    void givenOneString_thenReturnStringWithoutDelimiter() {
      String content = "abc";
      String delimiter = ",";
      assertEquals(content, StringUtils.concatenate(List.of(content), delimiter));
    }

    @Test
    void givenTwoStrings_thenReturnStringsWithDelimiter() {
      final String first = "abc";
      final String second = "def";
      final List<String> list = List.of(first, second);
      final String delimiter = ",";
      final String expected = first + delimiter + second;
      assertEquals(expected, StringUtils.concatenate(list, delimiter));
    }
  }
}
