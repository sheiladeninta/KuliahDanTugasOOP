import java.util.Scanner;
import Model.Layout;
import Model.Position;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args) {
        new RobotApp();
    }

    /*
     * Perintah Soal:
     * Anggap 'o' adalah sebuah robot yang berada didalam area permainan.
     * Buat robot dapat bergerak ke kiri/kanan/atas/bawah sesuai jumlah langkah yang diinstruksikan.
     * Format instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah} dan 'x' untuk keluar aplikasi *case sensitive
     * Robot tidak boleh keluar dari area permainan dan buat pesan kesalahannya.
     * Buat pesan kesalahan jika pengguna tidak menulis instruksi dengan benar.
     * Lanjut pada perintah soal dibawah.
     */

    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    public RobotApp() {
        this.layout = new Layout(10, 10, '*');
        this.scanner = new Scanner(System.in);
        String instruction = "";

        System.out.println("-------- Permainan Dimulai --------");
        draw();

        do {
            instruction = waitInstruction();

            if (instruction.equals("x")) {
                System.out.println("-------- Permainan Selesai --------");
                break;
            }

            char direction = instruction.charAt(0);
            int step = Integer.parseInt(instruction.substring(1));

            switch (direction) {
                case 'd':
                    moveRobot(1, 0, step);
                    break;
                case 'a':
                    moveRobot(-1, 0, step);
                    break;
                case 'w':
                    moveRobot(0, -1, step);
                    break;
                case 's':
                    moveRobot(0, 1, step);
                    break;
                default:
                    System.out.println("Instruksi tidak dikenali, permainan selesai");
                    break;
            }

        } while (true);
    }

    private void moveRobot(int dx, int dy, int step) {
        Position newPosition = new Position(robot.getPosition().getX() + dx * step, robot.getPosition().getY() + dy * step);

        if (isWithinBounds(newPosition)) {
            robot.setPosition(newPosition);
            redraw();
        } else {
            System.out.println("Robot keluar dari area permainan, permainan selesai");
            System.exit(0);
        }
    }

    private boolean isWithinBounds(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x < layout.getMaxX() && y >= 0 && y < layout.getMaxY();
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukkan instruksi: ");
        return scanner.nextLine();
    }

    private void draw() {
        System.out.println("------ Posisi Awal ------");
        this.robot = new Robot('o', new Position(0, 0));

        redraw();
    }

    private void redraw() {
        for (int y = 0; y < layout.getMaxY(); y++) {
            for (int x = 0; x < layout.getMaxX(); x++) {
                if (x == robot.getPosition().getX() && y == robot.getPosition().getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(layout.getArea()[x][y]);
                }
            }
            System.out.println();
        }
    }

        /*
        Gambar layout:
        Contoh:
        - Posisi robot di 1,1
        - Area permainan luasnya 10,10
        sehingga gambar layout akan menjadi:

            o*********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********

            - konfigurasi (icon robot, posisi robot, luas area dan icon area permainan yang tidak ditempati robot) silahkan gunakan prinsip OOP
            - icon cukup menggunakan karakter yang ada di keyboard.
         */

}
