package advent2022.day7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private Directory subject = new Directory("/", null);


    @Test
    void getSize_returnsCorrectSize() {
        var file = new File("b", 1);
        var file2 = new File("b", 2);
        var file3 = new File("b", 3);
        var file4 = new File("b", 4);
        var file5 = new File("b", 5);
        var file6 = new File("b", 6);
        subject.getFiles().add(file);
        subject.getFiles().add(file2);
        var sub = new Directory("sub", subject);
        subject.getSubdirectories().add(sub);
        sub.getFiles().add(file3);
        sub.getFiles().add(file4);
        var subsub = new Directory("subsub", sub);
        sub.getSubdirectories().add(subsub);
        subsub.getFiles().add(file5);
        subsub.getFiles().add(file6);

        var size = subject.getSize();

        assertThat(size).isEqualTo(21);
    }
}