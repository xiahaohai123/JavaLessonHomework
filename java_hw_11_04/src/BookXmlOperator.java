import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:Dom4JOperater
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/4 13:45
 */
public class BookXmlOperator {

    /**
     * 根据输入的list创建对应的dom对象
     * <p>
     * 待改：利用反射机制根据对象属性名来添加节点
     *
     * @param bookList
     * @return
     */
    public Document createNewDocument(List<Book> bookList) {
        // 创建一个dom对象
        Document document = DocumentHelper.createDocument();
        // 增加一个根节点
        Element books = document.addElement("books");

        // 循环增加新的节点
        for (Book book : bookList) {
            Element bookElement = books.addElement("book");
            // 设置id属性
            bookElement.addAttribute("id", book.getId());
            bookElement.addElement("name").addText(book.getName());
            bookElement.addElement("price").addText(String.valueOf(book.getPrice()));
        }

        return document;
    }

    /**
     * 根据输入的list创建对应的dom对象
     * 反射练习
     *
     * @return
     */
    public Document createNewDocumentByReflection(List<Book> bookList) {
        // 创建一个dom对象
        Document document = DocumentHelper.createDocument();
        // 增加一个根节点
        Element booksElement = document.addElement("books");


        // 循环增加新的节点
        for (Book book : bookList) {
            createNewDocumentByReflection(booksElement, book);
        }

        return document;

    }

    /**
     * 反射方法来增加
     *
     * @param book
     * @return
     */
    private void createNewDocumentByReflection(Element root, Book book) {
        Element bookElement = root.addElement("book");
        Class c = Book.class;
        // 获取所有声明的变量并遍历
        for (Field declaredField : c.getDeclaredFields()) {
            // 获取变量名
            String fieldName = declaredField.getName();

            // 变量名首字母大写
            char[] cs = fieldName.toCharArray();
            cs[0] -= 32;
            try {
                Method getMethod = c.getDeclaredMethod("get" + String.valueOf(cs));
                if (fieldName.equals("id")) {
                    // 添加属性
                    bookElement.addAttribute("id", String.valueOf(getMethod.invoke(book)));
                } else {
                    // 添加内容
                    bookElement.addElement(fieldName).addText(String.valueOf(getMethod.invoke(book)));
                }
            } catch (NoSuchMethodException e) {
                System.out.println("找不到对应get方法");
                e.printStackTrace();
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 存储document为xml对象到目标路径
     *
     * @param document
     * @param file
     */
    public void saveDocument(Document document, File file) {
        try (FileWriter fw = new FileWriter(file)) {
            // 格式化器
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(fw, format);
            xmlWriter.write(document);
            // 关闭输出流
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDocument(Document document, String path) {
        File file = new File(path);
        saveDocument(document, file);
    }

    /**
     * 读取文档
     *
     * @param file
     * @return
     * @throws DocumentException
     */
    public Document readDocument(File file) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        return saxReader.read(file);
    }

    /**
     * 文档转Book数组
     *
     * @param document
     * @return
     */
    public List<Book> transferToBookList(Document document) {
        Element books = document.getRootElement();
        List<Book> res = new ArrayList<>();
        // 迭代解析
        for (Iterator<Element> it = books.elementIterator(); it.hasNext(); ) {
            Element book = it.next();
            res.add(new Book(book.attributeValue("id"),
                    book.elementText("name"),
                    Double.parseDouble(book.elementText("price"))));
        }
        return res;
    }

    /**
     * 修改文档中对应book的属性
     *
     * @param document
     * @param book
     */
    public void update(Document document, Book book) {
        Element books = document.getRootElement();
        for (Element element : books.elements()) {
            if (element.attributeValue("id").equals(book.getId())) {
                element.element("name").setText(book.getName());
                element.element("price").setText(String.valueOf(book.getPrice()));
            }
        }
    }

    public void delete(Document document, String id) {
        Element books = document.getRootElement();
        for (Element element : books.elements()) {
            if (element.attributeValue("id").equals(id)) {
                books.remove(element);
            }
        }
    }
}
