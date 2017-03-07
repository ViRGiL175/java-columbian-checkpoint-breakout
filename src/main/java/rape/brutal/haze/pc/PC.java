package rape.brutal.haze.pc;

import rape.brutal.haze.pc.constructor.Hardware;
import rape.brutal.haze.pc.constructor.TechItem;
import rape.brutal.haze.pc.hardware.PowerSupply;
import rape.brutal.haze.pc.hardware.cpu.CPU;
import rape.brutal.haze.pc.hardware.gpu.GPU;
import rape.brutal.haze.pc.hardware.motherboard.Motherboard;
import rape.brutal.haze.pc.hardware.ram.RAM;
import rape.brutal.haze.pc.hardware.rom.ROM;

import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class PC extends TechItem {

    public static final String NAME = "PC";
    public static final int COST = 10000;

    private Motherboard motherboard;
    private CPU cpu;
    private RAM ram;
    private ROM rom;
    private GPU gpu;
    private PowerSupply powerSupply;

    public PC() {

    }


    public PC(Motherboard motherboard, CPU cpu, RAM ram, ROM rom, PowerSupply powerSupply) {

        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        //this.gpu = gpu;
        this.powerSupply = powerSupply;
    }


    Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    ROM getRom() {
        return rom;
    }

    public void setRom(ROM rom) {
        this.rom = rom;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    void turnOn() {
        powerSupply.powerOn();
    }

    void startBios() {
        if ((cpu == null) | (ram == null)) {
            System.exit(0);
        }
        if (!Objects.equals(cpu.getSocket(), motherboard.getSocket())) {
            System.exit(0);
        }

        if (!Objects.equals(motherboard.getRamType(), ram.getType())) {
            System.exit(0);
        }
        cpu.powerOn();
        ram.powerOn();
        rom.powerOn();
        if (gpu != null) {
            gpu.powerOn();
        }
    }


    void turnOff() {
        rom.powerOff();
        if (gpu != null) {
            gpu.powerOff();
        }
        ram.powerOff();
        cpu.powerOff();
        powerSupply.powerOff();

    }

    void work() {
        cpu.turboBoost();
    }


    void testingPerfomance(PC pc) {

        Scanner in = new Scanner(System.in);
        System.out.println("Хотите протестировать систему на производительность? (y/n)");

        String userSelection = in.nextLine();

        if (userSelection.matches("y")) {


            int scorePoint = (pc.cpu.scorePoint() + pc.ram.scorePoint() + pc.rom.scorePoint());

            System.out.print("Ваша система набрала\nПроцессор: ");
            System.out.println(Math.round(pc.cpu.scorePoint()) + " очков.");

            System.out.print("Оперативная память: ");
            System.out.println(Math.round(pc.ram.scorePoint()) + " очков.");

            System.out.print("Дисковая система: ");
            System.out.println(Math.round(pc.rom.scorePoint()) + " очков.\n");

            System.out.print("Система в целом: ");
            System.out.println(Math.round(scorePoint) + " очков.\n");
        }
    }

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public String getItemName() {
        return NAME;
    }

    @Override
    public void assignHardware() {
        Collection<Hardware> values = hardwareHashMap.values();
        for (Hardware hardware : values) {
            if (hardware instanceof CPU) {
                cpu = (CPU) hardware;
            } else if (hardware instanceof Motherboard) {
                motherboard = (Motherboard) hardware;
            } else if (hardware instanceof RAM) {
                ram = (RAM) hardware;
            } else if (hardware instanceof ROM) {
                rom = (ROM) hardware;
            } else if (hardware instanceof GPU) {
                gpu = (GPU) hardware;
            }
        }
    }

}


