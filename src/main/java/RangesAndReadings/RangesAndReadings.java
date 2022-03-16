package RangesAndReadings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RangesAndReadings {

  private final int start;
  private int end;

  public RangesAndReadings(final int value) {
    this.start = value;
    this.end = value;
  }

  public boolean add(final int value) {
    if (value != (this.end + 1)) {
      return false;
    }
    this.end = value;
    return true;
  }

  public int lenOfRange(final int startValue, final int endValue) {
    List<Integer> range = IntStream.rangeClosed(startValue, endValue).boxed().collect(Collectors.toList());
    return range.size();
  }

  @Override
  public String toString() {
    return this.start == this.end ? Integer.toString(this.start) : this.start + "-" + this.end;
  }

  public static List<RangesAndReadings> checkForRanges(final int[] values) {
    System.out.println("Range, Readings");
    if (values.length == 0) {
      return List.of();
    }

    List<Integer> sortedInt = IntStream.of(values).boxed().collect(Collectors.toList());
    Collections.sort(sortedInt);
    Integer[] listLen = new Integer[sortedInt.size()];
    Integer[] sortedValues = sortedInt.toArray(listLen);

    List<RangesAndReadings> ranges = new ArrayList<>();

    RangesAndReadings range = new RangesAndReadings(sortedValues[0]);

    range = detectContinuousRanges(sortedValues, ranges, range);

    ranges.add(range);

    printRangeAndReadings(ranges);

    return ranges;

  }

  private static RangesAndReadings detectContinuousRanges(final Integer[] values, final List<RangesAndReadings> ranges,
      RangesAndReadings range) {
    for (int i = 1; i < values.length; i++) {
      int value = values[i];
      range = splitContinuousRange(ranges, range, value);
    }
    return range;
  }

  private static RangesAndReadings splitContinuousRange(final List<RangesAndReadings> ranges, RangesAndReadings range,
      final int value) {
    if (!range.add(value)) {
      ranges.add(range);
      range = new RangesAndReadings(value);
    }
    return range;
  }

  private static void printRangeAndReadings(final List<RangesAndReadings> ranges) {
    ranges.forEach(a -> {
      System.out.println(a + ", " + a.lenOfRange(a.start, a.end));
    });
  }

}
