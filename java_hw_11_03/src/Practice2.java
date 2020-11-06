import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice2
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 14:23
 */
public class Practice2 {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("java_hw_11_03/files/music/d1/林ゆうき - ROBOTICS;NOTES.mp3");
             DataInputStream dis = new DataInputStream(is);
             OutputStream os = new FileOutputStream("java_hw_11_03/files/music/d2/林ゆうき - ROBOTICS;NOTES(copied).mp3");
             DataOutputStream dos = new DataOutputStream(os)) {

            byte[] buffer = new byte[10240];
            while (dis.read(buffer, 0, buffer.length) != -1) {
                dos.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
