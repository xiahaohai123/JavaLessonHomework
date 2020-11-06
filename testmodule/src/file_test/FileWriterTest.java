package file_test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @PackageName:file_test
 * @ClassName:FileWriterTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/4 15:49
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("testmodule/files/testFile.txt");
            fw.write("学士后");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
