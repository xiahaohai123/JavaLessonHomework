import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:XMLTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/4 14:06
 */
public class XMLCreateTest {
    public static void main(String[] args) {

        // service
        BookXmlOperator bookXmlOperator = new BookXmlOperator();

        File file = new File("java_hw_11_04/books.xml");
        if (file.exists()) {
            // 文件存在，读取(read) 修改(update) 删除(delete)
            /*
            读取操作
             */
            System.out.println("读取操作");
            Document document = null;
            try {
                document = bookXmlOperator.readDocument(file);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            // 读取并输出
            List<Book> bookList = bookXmlOperator.transferToBookList(document);
            System.out.println(bookList);
            System.out.println("读取完毕");

            /*
            改写操作
             */
            System.out.println("改写操作");
            Book book = bookList.get(0);
            book.setPrice(Math.random()*100);
            bookXmlOperator.update(document, book);
            bookXmlOperator.saveDocument(document, file);
            System.out.println("改写完毕，请打开文件查看，输入任意值继续程序");
            // 阻塞
            Scanner sc = new Scanner(System.in);
            sc.nextLine();


            /*
            删除操作
             */
            System.out.println("删除操作");
            bookXmlOperator.delete(document, book.getId());
            bookXmlOperator.saveDocument(document, file);
            System.out.println("删除操作，请打开文件查看，输入任意值继续程序");
            sc.nextLine();
            sc.close();

            /*
            删除文件
             */
            file.delete();
            System.out.println("文件已删除");
        } else {
            // 数据初始化
            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("T11", "thinking in java", 85.5));
            bookList.add(new Book("T15", "Spring in action", 39.0));
            bookList.add(new Book("T16", "Mysql数据库", 49.9));
            // 文件不存在，创建
            /*
             * create操作
             */
            // 创建初始文档，内容是作业的内容
            Document document = bookXmlOperator.createNewDocument(bookList);
            // 存储文档
            bookXmlOperator.saveDocument(document, file);
            System.out.println("新建成功");
        }
    }
}
