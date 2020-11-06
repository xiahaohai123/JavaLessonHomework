package ppt.practice2;

/**
 * @PackageName:practice2
 * @ClassName:Computer
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 14:57
 */
public class Computer {
    // CPU 接口
    private CPU cpu;
    // EMS 接口
    private EMS ems;
    // 硬盘接口
    private HardDisk hardDisk;

    public Computer(CPU cpu, EMS ems, HardDisk hardDisk) {
        this.cpu = cpu;
        this.ems = ems;
        this.hardDisk = hardDisk;
    }

    public void showInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("该电脑使用的CPU品牌为").append(cpu.getBrand()).append("，主频为").append(cpu.getMainFrequency()).append('\n');
        sb.append("使用的内存型号是").append(ems.getType()).append("，容量为").append(ems.getCapacity()).append('\n');
        sb.append("使用的硬盘容量为").append(hardDisk.getCapacity());

        System.out.println(sb);
    }
}
