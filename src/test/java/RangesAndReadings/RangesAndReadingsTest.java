package RangesAndReadings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangesAndReadingsTest {

  @Test
  public void testRangesAndReadings() {
    int[] firstArray = { 4, 5, 6, 7, 10, 11, 12 };
    int[] secondArray = { 10, 13, 12, 11, 15, 14, 20 };
    assertEquals("[4-7, 10-12]", RangesAndReadings.checkForRanges(firstArray).toString());
    assertEquals("[10-15, 20]", RangesAndReadings.checkForRanges(secondArray).toString());
  }
}
