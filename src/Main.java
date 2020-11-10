import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:25 SA
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DanhBaManager danhBaManager = new DanhBaManager();
        Menu menu = new Menu(scanner, danhBaManager);
        try {
            do {
                menu.show();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        menu.danhDachDanhBa();
                    break;
                    case 2:
                        menu.themMoiDanhBa();
                        break;
                    case 3:
                        menu.capNhatDanhBa();
                        break;
                    case 4:
                        menu.xoaDanhBa();
                        break;
                    case 5:
                        menu.timKiemDanhBa();
                        break;
                    case 6:
                        menu.docTuFile();
                        break;
                    case 7:
                        menu.ghiVaoFile();
                        break;
                    case 8:
                        menu.thoat();
                        break;
                    default:
                        System.out.println("No choice!");
                }
            } while (true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
