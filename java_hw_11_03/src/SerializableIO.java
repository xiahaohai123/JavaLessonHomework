import java.io.*;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SerializableIO
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 14:42
 */
public class SerializableIO {
    public void objectListSerializableOut(List<Student> studentList, File outputFile) {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             // 对象流
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // 写入对象
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object objectListSerializableIn(File inputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return ois.readObject();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
