import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice3
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/2 14:26
 */
public class Practice3 {
    public static void main(String[] args) {
        String srcPath = "java_hw_11_2/disk_d_simulator/林ゆうき - ROBOTICS;NOTES.mp3";
        String targetPath = "java_hw_11_2/林ゆうき - ROBOTICS;NOTES.mp3";
        try (InputStream is = new FileInputStream(srcPath);
             OutputStream os = new FileOutputStream(targetPath)) {
            byte[] buff = new byte[1024];
            // 循环到源文件末尾
            // 读取
            while (is.read(buff, 0, buff.length) != -1) {
                // 把buff的内容写到输入流 -> 新文件里
                os.write(buff);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
