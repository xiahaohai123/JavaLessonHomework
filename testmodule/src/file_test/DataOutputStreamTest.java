package file_test;

import java.io.*;

/**
 * @PackageName:file_test
 * @ClassName:DataOutputStreamTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/4 15:42
 */
public class DataOutputStreamTest {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("testmodule/files/testFile.txt");
             DataOutputStream dos = new DataOutputStream(outputStream)) {
            dos.writeUTF("世界");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("testmodule/files/testFile.txt");
             DataInputStream dis = new DataInputStream(is)) {
            System.out.println(dis.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
