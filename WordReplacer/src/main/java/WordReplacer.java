import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.*;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:WorldReplacer
 * @Description: 更换world文档内的内容
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/17 19:22
 */
public class WordReplacer {
    public static void main(String[] args) throws IOException {

        File file = new File("WordReplacer/files/2019-12-10_试卷分析.docx");
        //文件名
        String fileName = file.getName();
        String parentPath = file.getParent();
        String name = fileName.substring(0, fileName.lastIndexOf('.'));
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        System.out.println(name);

        InputStream is = new FileInputStream(file);
        XWPFDocument xwpfDocument = new XWPFDocument(is);
        is.close();

        int count = 0;

        for (XWPFTable table : xwpfDocument.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell tableCell : row.getTableCells()) {
                    if (tableCell.getText().equals("题干")) {
                        tableCell.removeParagraph(0);
                        tableCell.setText("题干" + ++count);
                    }
                }
            }
        }
//        for (IBodyElement bodyElement : xwpfDocument.getBodyElements()) {
////            System.out.println(bodyElement.getElementType());
//            if (bodyElement.getElementType().equals(BodyElementType.TABLE)) {
//                System.out.println(((XWPFTable) bodyElement).getText());
//            }
//        }

//        for (IBodyElement bodyElement : xwpfDocument.getBodyElements()) {
//            System.out.println(bodyElement);
//        }

//        XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(xwpfDocument);
//        System.out.println(xwpfWordExtractor.getText());

        String newFileName = name + "改" + suffix;
        String newPath = parentPath + "/" + newFileName;
        System.out.println(newPath);
        File newWordFile = new File(newPath);
        OutputStream os = new FileOutputStream(newWordFile);
        xwpfDocument.write(os);
        os.close();

        xwpfDocument.close();

    }
}
