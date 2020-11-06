import java.io.File;
import java.io.IOException;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Practice1
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/2 13:48
 */
public class Practice1 {

    public static void main(String[] args) {
        // 查看文件属性
        File file = new File("java_hw_11_2/test.txt");
        System.out.println("名称：" + file.getName());
        System.out.println("相对路径：" + file.getPath());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("文件大小：" + file.length() + "字节");

        // 创建文件
        File createFile = new File("java_hw_11_2/createFileTest.txt");
        try {
            if (createFile.createNewFile()) {
                System.out.println("创建文件成功");
                // 睡个几秒好看到文件已被创建
                Thread.sleep(3000);
            } else {
                System.out.println("创建文件失败");
            }
            // 新奇的写法 为啥2个类可以位或？？
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // 删除文件
        if (createFile.exists()) {
            if (createFile.delete()) {
                System.out.println("删除文件成功");
            } else {
                System.out.println("删除文件失败");
            }
        } else {
            System.out.println("找不到文件");
        }
    }
}
