import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice1
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 13:59
 */

/**
 * 按照刚才读取的模板文件pet. template的模板格式保存宠物数据到文本文件，即把{name}、{type}、{master}替换为具体的宠物信息，将替换后的内容写入到C:\myDoc\pet.txt中
 */
public class Practice1 {
    public static void main(String[] args) {
        String templatePath = "java_hw_11_03/files/pets/pet.template";
        String targetPath = "java_hw_11_03/files/pets/pet.txt";
        try (
                // 输入流
                InputStream is = new FileInputStream(templatePath);
                // 字节流转字符流
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                // 用BufferedReader提升效率
                BufferedReader br = new BufferedReader(isr);
                // 输出流
                OutputStream os = new FileOutputStream(targetPath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw)) {
            // 读取模板
            String s = br.readLine();

            // 直接用替换函数，因为要替换大括号使用转义字符
            s = s.replaceFirst("\\{name}", "旺财");
            s = s.replaceFirst("\\{type}", "猫");
            s = s.replaceFirst("\\{master}", "sea");

            // 写入数据
            bw.write(s);

            System.out.println("写入完成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
