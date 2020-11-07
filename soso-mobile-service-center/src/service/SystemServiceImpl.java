package service;

import entity.ConsumInfo;
import entity.MobileCard;
import entity.service_package.ServicePackage;
import factory.ServicePackageFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import utils.DateUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: service
 * @ClassName: SystemServiceImpl
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/11/6 14:34
 */
public class SystemServiceImpl implements SystemService {
    private static final String MOBILE_CARD_SAVE_PATH = "soso-mobile-service-center/save/mobile-card.xml";
    private static final String CONSUMPTION_SAVE_PATH = "soso-mobile-service-center/save/consumption.xml";

    // 卡表
    private Map<String, MobileCard> cardMap;
    // 消费列表表
    private Map<String, List<ConsumInfo>> consumptionInfoListMap;

    public SystemServiceImpl() {
        cardMap = new HashMap<>();
        consumptionInfoListMap = new HashMap<>();

        initData();
    }

    /**
     * 初始化一些数据方便使用
     */
    private void initData() {
        getDataFromFiles();
    }

    /**
     * 注册卡号
     *
     * @param card card
     * @return 如果已存在则返回false 加入成功则返回true
     */
    @Override
    public boolean registerMobileCard(MobileCard card) {
        if (cardMap.containsKey(card.getCardNumber())) {
            return false;
        } else {
            cardMap.put(card.getCardNumber(), card);
            saveMobileCardToXMLFile();
            return true;
        }
    }

    /**
     * 卡是否已存在
     *
     * @param cardNum 卡号
     * @return boolean
     */
    @Override
    public boolean isExist(String cardNum) {
        return cardMap.containsKey(cardNum);
    }

    /**
     * 登录
     *
     * @param cardNum  卡号
     * @param password 密码
     * @return MobileCard
     */
    @Override
    public MobileCard login(String cardNum, String password) {
        MobileCard card = cardMap.get(cardNum);

        if (card == null) {
            // 如果不存在此卡号
            return null;
        } else if (card.getPassword().equals(password)) {
            // 密码正确
            return card;
        } else {
            // 密码不正确
            return null;
        }
    }

    /**
     * 查看本月度账单
     *
     * @param card MobileCard
     * @return String 账单数据
     */
    @Override
    public String lookupBillCurMonth(MobileCard card) {
        return "*****本月账单查询*****" +
                "\n您的卡号：" + card.getCardNumber() +
                "\n当月账单：\n" +
                "\t套餐资费：" + (card.getServicePackage() == null ? "0.0" : card.getServicePackage().getPrice()) +
                "\n\t合计：" + card.getConsumAmount() +
                "\n\t账户余额：" + card.getMoney();
    }

    /**
     * 从文件中读取数据
     */
    private void getDataFromFiles() {
        // 获取存在的文件
        File mobileCardFile = getExistsFile(MOBILE_CARD_SAVE_PATH);
        File consumption = getExistsFile(CONSUMPTION_SAVE_PATH);


        // 如果文件是空的，刚被建立的
        if (mobileCardFile.length() == 0) {
            // 初始化数据和文件
            initDataAndInitFileWithMobileCard();
        } else {
            // 如果文件非空
            loadMobileCardFromXMLFile();
        }
    }

    /**
     * 确保获取存在的文件，如果不存在则新建文件
     * 不负责初始化文件内容
     *
     * @param path 路径
     * @return File 存在的文件
     */
    private File getExistsFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            File dir = new File(path.substring(0, path.lastIndexOf("/")));
            // 确保文件夹存在
            if (!dir.exists()) {
                System.out.println("没有文件夹！");
                if (dir.mkdirs()) {
                    System.out.println("创建文件夹成功！");
                }
            }
            //  创建文件
            try {
                if (file.createNewFile()) {
                    System.out.println("创建文件成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 初始化数据和文件
     * 针对MobileCard
     */
    private void initDataAndInitFileWithMobileCard() {
        // 直接初始化map数据
        MobileCard[] mobileCards = new MobileCard[3];
        mobileCards[0] = new MobileCard("13888888888", "甲", "123456");
        mobileCards[1] = new MobileCard("13777777777", "乙", "123456");
        mobileCards[2] = new MobileCard("13666666666", "丙", "123456");
        mobileCards[0].setServicePackage(ServicePackageFactory.getServicePackage("话唠套餐"));
        mobileCards[1].setServicePackage(ServicePackageFactory.getServicePackage("超人套餐"));
        mobileCards[2].setServicePackage(ServicePackageFactory.getServicePackage("网虫套餐"));

        cardMap.put(mobileCards[0].getCardNumber(), mobileCards[0]);
        cardMap.put(mobileCards[1].getCardNumber(), mobileCards[1]);
        cardMap.put(mobileCards[2].getCardNumber(), mobileCards[2]);

        // 保存到文件
        saveMobileCardToXMLFile();
    }

    /**
     * 保存mobileCard到文件
     */
    private void saveMobileCardToXMLFile() {
        new Thread(() -> {
            File file = getExistsFile(MOBILE_CARD_SAVE_PATH);
            // 初始化文档
            Document document = DocumentHelper.createDocument();
            // 设置根节点
            Element mobileCardsElement = document.addElement("mobileCards");

            cardMap.forEach((cardNumber, mobileCard) -> {
                // 增加子节点
                Element mobileCardElement = mobileCardsElement.addElement("mobileCard");
                // 子节点attribute
                mobileCardElement.addAttribute("cardNumber", mobileCard.getCardNumber());
                // 子节点的子元素
                mobileCardElement.addElement("username").setText(mobileCard.getUsername());
                mobileCardElement.addElement("password").setText(mobileCard.getPassword());
                mobileCardElement.addElement("servicePackage").setText(mobileCard.getServicePackage() == null ? "无" : mobileCard.getServicePackage().getSelectString());
                mobileCardElement.addElement("consumAmount").setText(String.valueOf(mobileCard.getConsumAmount()));
                mobileCardElement.addElement("money").setText(String.valueOf(mobileCard.getMoney()));
                mobileCardElement.addElement("realTalkTime").setText(String.valueOf(mobileCard.getRealTalkTime()));
                mobileCardElement.addElement("realSMSCount").setText(String.valueOf(mobileCard.getRealSMSCount()));
                mobileCardElement.addElement("realFlow").setText(String.valueOf(mobileCard.getRealFlow()));
                mobileCardElement.addElement("registerTime").setText(DateUtil.millsToString(mobileCard.getRegisterTime()));
            });

            //写入文件，保存数据
            try (FileWriter fw = new FileWriter(file)) {
                OutputFormat format = OutputFormat.createPrettyPrint();
                XMLWriter xmlWriter = new XMLWriter(fw, format);
                xmlWriter.write(document);
                // 关闭输出流
                xmlWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 从文件里取出数据加载类MobileCard并加入map
     */
    private void loadMobileCardFromXMLFile() {
        File file = getExistsFile(MOBILE_CARD_SAVE_PATH);

        SAXReader saxReader = new SAXReader();
        try {
            Document cardFileDocument = saxReader.read(file);
            // 获取根节点 mobileCards
            Element mobileCardsElement = cardFileDocument.getRootElement();
            // 遍历数据加入map
            for (Element element : mobileCardsElement.elements()) {
                String cardNumber = element.attributeValue("cardNumber");
                String username = element.elementText("username");
                String password = element.elementText("password");
                ServicePackage servicePackage = ServicePackageFactory.getServicePackage(element.elementText("servicePackage"));
                Double consumAmount = Double.parseDouble(element.elementText("consumAmount"));
                Double money = Double.parseDouble(element.elementText("money"));
                Integer realTalkTime = Integer.parseInt(element.elementText("realTalkTime"));
                Integer realSMSCount = Integer.parseInt(element.elementText("realSMSCount"));
                Integer realFlow = Integer.parseInt(element.elementText("realFlow"));
                Long registerTime = DateUtil.StringToMills(element.elementText("registerTime"));

                cardMap.put(cardNumber, new MobileCard(cardNumber, username, password,
                        servicePackage, consumAmount, money, realTalkTime, realSMSCount, realFlow,
                        registerTime));
            }
        } catch (DocumentException e) {
            System.out.println("读取用户文档失败！");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String lookupMealAllowance(MobileCard card) {
        // 获取套餐资源量化map
        Map<String, Integer> map = card.getServicePackage() == null ? new HashMap<>() : card.getServicePackage().getAllowanceMap();

        StringBuilder sb = new StringBuilder("*****本月账单查询*****\n");
        sb.append("您的卡号是").append(card.getCardNumber()).append('\n');
        sb.append("套餐内剩余:\n");
        int talkTime = map.getOrDefault("talkTime", 0);
        sb.append('\t').append("通话时长：").append(talkTime <= card.getRealTalkTime() ? 0 : talkTime - card.getRealTalkTime()).append('\n');
        int smsCount = map.getOrDefault("smsCount", 0);
        sb.append('\t').append("短信条数：").append(smsCount <= card.getRealSMSCount() ? 0 : smsCount - card.getRealSMSCount()).append('\n');
        int flow = map.getOrDefault("flow", 0);
        sb.append('\t').append("上网流量：").append(flow <= card.getRealFlow() ? 0 : flow - card.getRealFlow()).append('\n');

        return sb.toString();
    }
}
