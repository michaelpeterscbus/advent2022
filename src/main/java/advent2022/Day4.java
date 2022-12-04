package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day4 {
    @SneakyThrows
    public int getOverlapCount(String filename, boolean anyOverlapCounts) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day4/" + filename));
        String line;
        var count = 0;
        while ((line = reader.readLine()) != null) {
            var elves = line.split(",");
            var section1 = elves[0].split("-");
            var elf1Start = Integer.parseInt(section1[0]);
            var elf1End = Integer.parseInt(section1[1]);
            var section2 = elves[1].split("-");
            var elf2Start = Integer.parseInt(section2[0]);
            var elf2End = Integer.parseInt(section2[1]);

            if (anyOverlapCounts) {
                count = getAnyOverlapCount(count, elf1Start, elf1End, elf2Start, elf2End);
            } else {
                count = getFullyContainedCount(count, elf1Start, elf1End, elf2Start, elf2End);
            }

        }
        return count;
    }

    private int getAnyOverlapCount(int count, int elf1Start, int elf1End, int elf2Start, int elf2End) {
        if (elf1End >= elf2Start && elf1End <= elf2End) {
            count++;
        } else if (elf1Start >= elf2Start && elf1Start <= elf2End){
            count++;
        } else if (elf2End >= elf1Start && elf2End <= elf1End) {
            count++;
        } else if (elf2Start >= elf1Start && elf2Start <= elf1End) {
            count++;
        }
        return count;
    }

    private int getFullyContainedCount(int count, int elf1Start, int elf1End, int elf2Start, int elf2End) {
        if (elf1Start <= elf2Start && elf1End >= elf2End) {
            count++;
        } else if (elf2Start <= elf1Start && elf2End >= elf1End) {
            count++;
        }
        return count;
    }
}
