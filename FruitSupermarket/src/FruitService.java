public interface FruitService {


    // 获取展示的String字符串
    String getDisplayString();

    // 根据名字判断是否存在当前水果类
    boolean contains(String fruitName);

    // 仅修改库存
    void modifyInventory(String name, int inventoryNum);

    // 新增水果
    boolean addFruit(String name, double price, int inventoryNum, String remark);

    // 获取查询水果的信息
    String getLookUpFruitString(String name);

    // 删除水果
    boolean deleteFruit(String name);

    // 获取水果展示信息（升序）
    String getDisplayStringOrderByAsc();
}
