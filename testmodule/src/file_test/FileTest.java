package file_test;

import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FileTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/2 14:47
 */
public class FileTest {
    public static void main(String[] args) throws FileNotFoundException {
//        new BufferedReader(new FileInputStream("a")); //错误
//        Input
        System.out.println(System.getProperty("file.encoding"));
        try (FileOutputStream fos = new FileOutputStream("testmodule/files/testFile.txt")) {
            fos.write(98);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileReader fileReader = new FileReader("a");
    }
}
