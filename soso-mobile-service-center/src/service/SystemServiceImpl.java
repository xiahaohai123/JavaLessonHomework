package service;

import entity.ConsumptionInfo;
import entity.MobileCard;
import entity.Scene;
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

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

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

    // 场景列表
    private static List<Scene> sceneList;
    // 卡表
    private Map<String, MobileCard> cardMap;
    // 消费列表表
    private Map<String, LinkedList<ConsumptionInfo>> consumptionInfoListMap;

    public SystemServiceImpl() {
        cardMap = new HashMap<>();
        consumptionInfoListMap = new HashMap<>();
        sceneList = new ArrayList<>();

        initData();
    }

    /**
     * 初始化一些数据方便使用
     */
    private void initData() {
        getDataFromFiles();

        sceneList.add(new Scene(30, 0, 0, "和妈妈聊天，聊了30分钟。"));
        sceneList.add(new Scene(10, 2, 0, "做志愿活动，沟通了10分钟，发了2条短信。"));
        sceneList.add(new Scene(0, 0, 24, "用热点玩了一局英雄联盟，消耗了24MB流量。"));
        sceneList.add(new Scene(0, 0, 5126, "用热点下载了一会GTA5，消耗了5126MB流量。"));
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
        return "\n您的卡号：" + card.getCardNumber() +
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
        if (mobileCardFile.length() == 0 || consumption.length() == 0) {
            // 初始化数据和文件
            try {
                initDataAndInitFile();
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
    private void initDataAndInitFile() throws ParseException {
        // 直接初始化map数据
        MobileCard[] mobileCards = new MobileCard[3];
        mobileCards[0] = new MobileCard("13888888888", "甲", "123456");
        mobileCards[1] = new MobileCard("13777777777", "乙", "123456");
        mobileCards[2] = new MobileCard("13666666666", "丙", "123456");
        mobileCards[0].setNextServicePackage(ServicePackageFactory.getServicePackage("话唠套餐"));
        mobileCards[0].changeServicePackage();
        mobileCards[1].setNextServicePackage(ServicePackageFactory.getServicePackage("超人套餐"));
        mobileCards[1].changeServicePackage();
        mobileCards[2].setNextServicePackage(ServicePackageFactory.getServicePackage("网虫套餐"));
        mobileCards[2].changeServicePackage();

        cardMap.put(mobileCards[0].getCardNumber(), mobileCards[0]);
        cardMap.put(mobileCards[1].getCardNumber(), mobileCards[1]);
        cardMap.put(mobileCards[2].getCardNumber(), mobileCards[2]);

        // 保存到文件
        saveMobileCardToXMLFile();

        LinkedList<ConsumptionInfo> lists0 = new LinkedList<>();
        lists0.add(new ConsumptionInfo(mobileCards[0].getCardNumber(), 1024, 65, 80, DateUtil.StringToMills("2020-9-1")));
        lists0.add(new ConsumptionInfo(mobileCards[0].getCardNumber(), 505, 310, 90, DateUtil.StringToMills("2020-10-1")));

        LinkedList<ConsumptionInfo> lists1 = new LinkedList<>();
        lists1.add(new ConsumptionInfo(mobileCards[1].getCardNumber(), 654, 65, 80, DateUtil.StringToMills("2020-9-1")));
        lists1.add(new ConsumptionInfo(mobileCards[1].getCardNumber(), 505, 28, 60, DateUtil.StringToMills("2020-10-1")));

        LinkedList<ConsumptionInfo> lists2 = new LinkedList<>();
        lists2.add(new ConsumptionInfo(mobileCards[2].getCardNumber(), 6548, 32, 3, DateUtil.StringToMills("2020-9-1")));
        lists2.add(new ConsumptionInfo(mobileCards[2].getCardNumber(), 8540, 10, 4, DateUtil.StringToMills("2020-10-1")));

        consumptionInfoListMap.put(mobileCards[0].getCardNumber(), lists0);
        consumptionInfoListMap.put(mobileCards[1].getCardNumber(), lists1);
        consumptionInfoListMap.put(mobileCards[2].getCardNumber(), lists2);

        saveConsumptionToXMLFile();
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
                mobileCardElement.addElement("nextServicePackage").setText(mobileCard.getNextServicePackage() == null ? "无" : mobileCard.getNextServicePackage().getSelectString());
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
     * 保存consumption到文件
     */
    private void saveConsumptionToXMLFile() {
        new Thread(() -> {
            File file = getExistsFile(CONSUMPTION_SAVE_PATH);

            Document document = DocumentHelper.createDocument();
            Element mobileCardsElement = document.addElement("mobileCards");

            consumptionInfoListMap.forEach((cardNumber, consumptionList) -> {
                Element mobileCardElement = mobileCardsElement.addElement("mobileCard");
                // 标记属性
                mobileCardElement.addAttribute("cardNumber", cardNumber);
                // 添加消费清单
                Element consumptionsElement = mobileCardElement.addElement("consumptions");
                for (ConsumptionInfo consumptionInfo : consumptionList) {
                    // 遍历写入消费清单
                    Element consumptionElement = consumptionsElement.addElement("consumption");
                    consumptionElement.addAttribute("time", DateUtil.millsToYyyyMM(consumptionInfo.getYyyyMMMills()));
                    consumptionElement.addElement("consumedFlow").addText(String.valueOf(consumptionInfo.getConsumedFlow()));
                    consumptionElement.addElement("consumedTalkTime").addText(String.valueOf(consumptionInfo.getConsumedTalkTime()));
                    consumptionElement.addElement("consumedSMSCount").addText(String.valueOf(consumptionInfo.getConsumedSMSCount()));
                }

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
            // 用户文档
            Document cardFileDocument = saxReader.read(file);
            // 获取根节点 mobileCards
            Element mobileCardsElement = cardFileDocument.getRootElement();
            // 遍历数据加入map
            for (Element element : mobileCardsElement.elements()) {
                String cardNumber = element.attributeValue("cardNumber");
                String username = element.elementText("username");
                String password = element.elementText("password");
                ServicePackage servicePackage = ServicePackageFactory.getServicePackage(element.elementText("servicePackage"));
                ServicePackage nextServicePackage = ServicePackageFactory.getServicePackage(element.elementText("nextServicePackage"));
                Double consumAmount = Double.parseDouble(element.elementText("consumAmount"));
                Double money = Double.parseDouble(element.elementText("money"));
                Integer realTalkTime = Integer.parseInt(element.elementText("realTalkTime"));
                Integer realSMSCount = Integer.parseInt(element.elementText("realSMSCount"));
                Integer realFlow = Integer.parseInt(element.elementText("realFlow"));
                Long registerTime = DateUtil.StringToMills(element.elementText("registerTime"));

                cardMap.put(cardNumber, new MobileCard(cardNumber, username, password,
                        servicePackage, nextServicePackage, consumAmount, money, realTalkTime, realSMSCount, realFlow,
                        registerTime));
            }

            // 消费文档
            Document consumptionDocument = saxReader.read(getExistsFile(CONSUMPTION_SAVE_PATH));
            mobileCardsElement = consumptionDocument.getRootElement();
            // 遍历用户数据
            for (Element mobileCardElement : mobileCardsElement.elements()) {
                String cardNumber = mobileCardElement.attributeValue("cardNumber");
                LinkedList<ConsumptionInfo> consumptionInfoList = new LinkedList<>();
                for (Element consumptionElement : mobileCardElement.element("consumptions").elements()) {
                    consumptionInfoList.add(new ConsumptionInfo(cardNumber,
                            Integer.parseInt(consumptionElement.elementText("consumedFlow")),
                            Integer.parseInt(consumptionElement.elementText("consumedTalkTime")),
                            Integer.parseInt(consumptionElement.elementText("consumedSMSCount")),
                            DateUtil.yyyyMMToMills(consumptionElement.attributeValue("time"))));
                }
                // 排序 必须要除以1000防止精度丢失
                consumptionInfoList.sort((o1, o2) -> (int) ((o2.getYyyyMMMills() - o1.getYyyyMMMills()) / 1000));
                // 加入到map
                consumptionInfoListMap.put(cardNumber, consumptionInfoList);
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

        StringBuilder sb = new StringBuilder();
        sb.append("您的卡号是").append(card.getCardNumber()).append('\n');
        sb.append("套餐内剩余:\n");
        int talkTime = map.getOrDefault("talkTime", 0);
        sb.append('\t').append("通话时长：").append(talkTime <= card.getRealTalkTime() ? 0 : talkTime - card.getRealTalkTime()).append("分钟\n");
        int smsCount = map.getOrDefault("smsCount", 0);
        sb.append('\t').append("短信条数：").append(smsCount <= card.getRealSMSCount() ? 0 : smsCount - card.getRealSMSCount()).append("条\n");
        int flow = map.getOrDefault("flow", 0);
        flow = flow <= card.getRealFlow() ? 0 : flow - card.getRealFlow();
        sb.append('\t').append("上网流量：");
        // 超出1GB按GB显示
        if (flow > 1024) {
            sb.append(new DecimalFormat("0.0").format(flow / 1024.0)).append("GB\n");
        } else {
            sb.append(flow).append("MB\n");
        }


        return sb.toString();
    }

    /**
     * @param card card
     * @return 返回消费详单
     */
    @Override
    public String getConsumptionInfoList(MobileCard card) {
        // 获取消费详单列表
        List<ConsumptionInfo> consumptionInfoList = consumptionInfoListMap.get(card.getCardNumber());
        StringBuilder sb = new StringBuilder();

        // 如果没有清单则返回null
        if (consumptionInfoList == null) {
            return sb.append("最近无消费\n").toString();
        }


        sb.append("用户").append(card.getCardNumber()).append('\n');
        sb.append("您的消费详单：\n");

        // 排序，输出为最近在上方
        consumptionInfoList.sort((o1, o2) -> (int) (o1.getYyyyMMMills() - o2.getYyyyMMMills()));
        for (ConsumptionInfo consumptionInfo : consumptionInfoList) {
            sb.append("\t时间：").append(DateUtil.millsToYyyyMM(consumptionInfo.getYyyyMMMills())).append('\n');

            sb.append("\t消费流量：");
            // 显示单位控制
            if (consumptionInfo.getConsumedFlow() > 1024) {
                sb.append(new DecimalFormat("0.0").format(consumptionInfo.getConsumedFlow() / 1024.0)).append("GB\n");
            } else {
                sb.append(consumptionInfo.getConsumedFlow()).append("MB\n");
            }
            sb.append("\t已用短信：").append(consumptionInfo.getConsumedSMSCount()).append("条\n");
            sb.append("\t已用通话时间：").append(consumptionInfo.getConsumedTalkTime()).append("分\n\n");
        }

        return sb.toString();
    }

    @Override
    public boolean changeNextMenu(MobileCard card, ServicePackage servicePackage) {
        card.setNextServicePackage(servicePackage);

        // 因为card是引用对象，所以其实修改的就是内存中原始对象的值，所以直接保存就行
        saveMobileCardToXMLFile();
        return true;
    }

    @Override
    public String getExpensesDescription() {
        File file = new File("soso-mobile-service-center/套餐资费说明.txt");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(fis);
                 BufferedReader br = new BufferedReader(isr)) {
                // 流拼接字符串
                return br.lines().collect(Collectors.joining("\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "无资费说明";
    }

    @Override
    public boolean withdrawFromTheNet(MobileCard card) {
        // 删除卡号
        cardMap.remove(card.getCardNumber());
        saveMobileCardToXMLFile();
        // 删除消费详单
        consumptionInfoListMap.remove(card.getCardNumber());
        saveConsumptionToXMLFile();
        return true;
    }

    /**
     * 充值话费
     *
     * @param card card
     * @param fee  充值费用
     * @return 成功与否
     */
    @Override
    public boolean chargeCard(MobileCard card, double fee) {
        // 添加费用
        card.chargeMoney(fee);
        // 保存
        saveMobileCardToXMLFile();
        return true;
    }

    @Override
    public String useSoSo(MobileCard card) {
        Scene scene = sceneList.get((int) (Math.random() * sceneList.size()));
        // 新东西 computeIfAbsent
        // 如果没有消费详单列表则创建一个并加入map
        LinkedList<ConsumptionInfo> consumptionInfoList = consumptionInfoListMap.computeIfAbsent(card.getCardNumber(), k -> new LinkedList<>());


        ConsumptionInfo consumptionInfo;
        // 如果没有消费详单或没有当月消费详单
        // 判断的时候顺便取到消费详单
        // get(0)是因为列表按时间降序排序，0为最近的时间
        if (consumptionInfoList.size() == 0 || !(DateUtil.millsToYyyyMM((consumptionInfo = (consumptionInfoList.get(0))).getYyyyMMMills())).equals(DateUtil.millsToYyyyMM(System.currentTimeMillis()))) {
            consumptionInfo = new ConsumptionInfo(card.getCardNumber());
            consumptionInfoList.addFirst(consumptionInfo);
        }

        // 打电话
        if (scene.getTalkTime() != 0) {
            card.call(scene.getTalkTime());
            consumptionInfo.addConsumedTalkTime(scene.getTalkTime());
        }
        // 发信息
        int smsCount;
        if ((smsCount = scene.getSmsCount()) != 0) {
            while (smsCount-- > 0) {
                card.send();
            }
            consumptionInfo.addConsumedSMSCount(smsCount);
        }
        // 用流量
        if (scene.getFlow() != 0) {
            card.netPlay(scene.getFlow());
            consumptionInfo.addConsumedflow(scene.getFlow());
        }

        // 保存到文件
        saveConsumptionToXMLFile();
        saveMobileCardToXMLFile();

        return scene.getDescription();
    }
}
