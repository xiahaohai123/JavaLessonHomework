import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice2
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/2 14:06
 */
public class Practice2 {
    public static void main(String[] args) {
        File file = new File("java_hw_11_2/disk_d_simulator/我的青春我做主.txt");
        if (file.exists()) {
            try ( // 字节输入流
                  InputStream is = new FileInputStream(file);
                  OutputStream os = new FileOutputStream("java_hw_11_2/disk_c_simulator/myFile/my Prime.txt")) {
                // buff设置大小为目标文件的字节长度
                byte[] buff = new byte[(int) file.length()];

                // 读取内容
                while (is.read(buff, 0, buff.length) != -1) ;

                // 输出内容到文件
                os.write(buff);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("找不到目标文件");
        }
    }
}
