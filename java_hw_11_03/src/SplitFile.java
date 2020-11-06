import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SplitFile
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 15:18
 */
public class SplitFile {
    public static void main(String[] args) {
        String path = "java_hw_11_03/files/split/src/src.png";
        String splitParentPath = "java_hw_11_03/files/split/split";
        File file = new File(path);
        if (file.exists()) {
            // 文件名
            String filename = file.getName();
            // 父目录
            try (FileInputStream fis = new FileInputStream(file);
                 DataInputStream dis = new DataInputStream(fis)) {

                byte[] buff = new byte[102400];
                // 文件计数器
                int count = 0;
                int available = 0;
                while ((available = fis.available()) != 0) {
                    int validLength = available < buff.length ? available : buff.length;
                    fis.read(buff, 0, validLength);
                    // 写文件
                    try (FileOutputStream fos = new FileOutputStream(splitParentPath + "/" + filename.replaceAll("\\.", "-" + (count++) + '.'));
                         DataOutputStream dos = new DataOutputStream(fos)) {
                        // 写入
                        dos.write(buff, 0, validLength);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("找不到文件");
        }


    }
}
