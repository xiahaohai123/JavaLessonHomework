package ppt.practice2;

/**
 * @PackageName:practice2
 * @ClassName:ComputerTest
 * @Description:
 * @Version V1.0
 * @Author 夏浩海
 * @Date 2020/10/23 15:13
 */
public class ComputerTest {
    public static void main(String[] args) {
        // INTEL CPU
        CPU intelCPU = new IntelCPU();
        // AMD CPU
        CPU amdCPU = new AMDCPU();
        EMS ems = new SamsunEMS();
        HardDisk hardDisk = new SeagateHardDisk();

        Computer computer = new Computer(intelCPU, ems, hardDisk);

        computer.showInfo();
        System.out.println();

        computer = new Computer(amdCPU, ems, hardDisk);
        computer.showInfo();
    }
}
