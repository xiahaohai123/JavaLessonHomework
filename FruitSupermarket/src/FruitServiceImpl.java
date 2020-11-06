import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName:PACKAGE_NAME
 * @ClassName:FruitServiceImpl
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/28 11:18
 */
public class FruitServiceImpl implements FruitService {
    private List<Fruit> fruitList;
    /*
    上一次操作过的水果，减少查找的次数
    依据 局部性原理
     */
    private Fruit lastOperateFruit;

    /**
     * 无参构造器，初始化数据
     */
    public FruitServiceImpl() {
        fruitList = new ArrayList<>();
        fruitList.add(new Fruit("苹果", 5, 100, "山东红富士，味道杠杠的！"));
        fruitList.add(new Fruit("香蕉", 3, 110, "海南香蕉，香蕉中的战斗蕉！"));
        fruitList.add(new Fruit("西瓜", 2, 50, "好吃"));
        fruitList.add(new Fruit("黄瓜", 1, 30, "好"));
        fruitList.add(new Fruit("葡萄", 6, 90, "不错"));
    }

    /**
     * 展示所有水果信息的字符串
     *
     * @return
     */
    @Override
    public String getDisplayString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Fruit.getInfoHead()).append('\n');
        fruitList.forEach(fruit -> sb.append(fruit.toString()).append('\n'));
        return sb.toString();
    }

    @Override
    public String getDisplayStringOrderByAsc() {
        // copy一个列表出来
        List<Fruit> copyList = new LinkedList<>(fruitList);
        // 升序排序
        copyList.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));

        // 拼接字符串信息
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Fruit.getInfoHead()).append('\n');
        copyList.forEach(fruit -> stringBuilder.append(fruit.toString()).append('\n'));
        return stringBuilder.toString();
    }

    /**
     * 判断集合内是存在该名字对应的水果
     *
     * @param name
     * @return
     */
    @Override
    public boolean contains(String name) {
        for (Fruit fruit : fruitList) {
            if (fruit.getName().equals(name)) {
                // 局部性原理
                lastOperateFruit = fruit;
                return true;
            }
        }
        return false;
    }

    /**
     * 根据名字获取水果
     * <p>
     * 特殊：先判断上次操作过的水果是不是目标，不是则重新遍历查找，并修改上次操作过的水果
     *
     * @param name
     * @return 如果没有返回null, 如果有返回Fruit
     */
    private Fruit getFruit(String name) {
        // 上一个操作对象是null或不是目标
        if (lastOperateFruit == null || !lastOperateFruit.getName().equals(name)) {

            for (Fruit fruit : fruitList) {
                if (fruit.getName().equals(name)) {
                    lastOperateFruit = fruit;
                    return fruit;
                }
            }
        } else if (lastOperateFruit.getName().equals(name)) {
            return lastOperateFruit;
        }
        // 啥都没找着
        return null;
    }

    /**
     * 修改水果库存
     *
     * @param name
     * @param inventoryNum
     * @throws Fruit.AbnormalInventoryNumberException
     */
    @Override
    public void modifyInventory(String name, int inventoryNum) throws Fruit.AbnormalInventoryNumberException {
        Fruit fruit = getFruit(name);
        fruit.setInventory(inventoryNum);
    }

    /**
     * 新增水果
     *
     * @param name         水果名字
     * @param price        水果价格
     * @param inventoryNum 水果库存量
     * @param remark       水果备注
     * @return
     */
    @Override
    public boolean addFruit(String name, double price, int inventoryNum, String remark) throws Fruit.AbnormalInventoryNumberException, Fruit.AbnormalPriceException {
        Fruit fruit = new Fruit(name, price, inventoryNum, remark);
        fruitList.add(fruit);
        return true;
    }

    /**
     * 获取查询的水果的字符串
     *
     * @param name
     * @return
     */
    @Override
    public String getLookUpFruitString(String name) {
        Fruit fruit = getFruit(name);
        // 防止输入的找不到的水果
        if (fruit == null) return null;
        return fruit.getInfoCompleted();
    }

    /**
     * 删除对应名字的水果
     *
     * @param name
     * @return
     */
    @Override
    public boolean deleteFruit(String name) {
        Fruit fruit;
        // 迭代器删除
        Iterator<Fruit> iterator = fruitList.iterator();
        while (iterator.hasNext()) {
            fruit = iterator.next();
            if (fruit.getName().equals(name)) {
                // 删除
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
