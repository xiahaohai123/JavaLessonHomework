import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:SerializableTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/3 14:52
 */
public class SerializableTest {
    public static void main(String[] args) {
        SerializableIO serializableIO = new SerializableIO();

        File file = new File("java_hw_11_03/files/serializable/students.jobda");

        //如果文件存在则读取对象
        if (file.exists()) {

            List<Student> studentList = (List<Student>) serializableIO.objectListSerializableIn(file);
            System.out.println(studentList);
        } else {
            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student(Gender.男, "甲甲", 13));
            studentList.add(new Student(Gender.男, "乙乙", 16));
            studentList.add(new Student(Gender.男, "丙丙", 19));

            serializableIO.objectListSerializableOut(studentList, file);
        }
    }
}
