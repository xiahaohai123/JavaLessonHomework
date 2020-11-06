import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:MergeFile
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 15:46
 */
public class MergeFile {
    public static void main(String[] args) {
        String splitParentPath = "java_hw_11_03/files/split/split";
        String targetPath = "java_hw_11_03/files/split/merged/src_merged.png";
        String srcFilename = "src.png";

        // 输出目标文件
        try (FileOutputStream fos = new FileOutputStream(targetPath);
             DataOutputStream dos = new DataOutputStream(fos)) {

            int count = 0;
            // 循环读取所有文件并写入
            // 死循环推荐for格式，操作码只有一行没有比较
            for (; ; ) {
                // 读取文件
                File file = new File(splitParentPath + "/" + srcFilename.replaceAll("\\.", "-" + (count++) + "."));
                if (file.exists()) {
                    try (FileInputStream fis = new FileInputStream(file);
                         DataInputStream dis = new DataInputStream(fis)) {

                        byte[] buff = new byte[(int) file.length()];

                        // 读取
                        dis.read(buff);

                        // 写入
                        dos.write(buff);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("合成文件：" + file.getName());

                } else {
                    System.out.println("合成完毕！");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
