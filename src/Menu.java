import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:12 SA
 */

public class Menu {
    private Scanner scanner;
    private DanhBaManager danhBaManager;
    private FormValidator formValidator = new FormValidator();
    private DanhBaFileIO danhBaFileIO = new DanhBaFileIO();

    public Menu(Scanner scanner, DanhBaManager danhBaManager) {
        this.scanner = scanner;
        this.danhBaManager = danhBaManager;
    }

    void show() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    void danhDachDanhBa() {
        tieuDe("---- DANH SÁCH DANH BẠ ----");
        if (danhBaManager.getAll().size() > 0) {
            for (DanhBa danhBa: danhBaManager.getAll()) {
                System.out.println(danhBa.toString());
                System.out.println("Nhấn enter để hiển thị Danh bạ tiếp theo");
                scanner.nextLine();
            }
        } else {
            System.out.println("Danh bạ trống!");
        }
    }

    void themMoiDanhBa() {
        tieuDe("---- ADMIN/THÊM MỚI ----");
        DanhBa danhBa = new DanhBa();
        danhBa.setSoDienThoai(nhapSoDienThoai("Nhập số điện thoại: "));
        danhBa.setFacebook(inputStr("Nhập Nhóm: "));
        danhBa.setHoTen(inputStr("Nhập Họ tên: "));
        danhBa.setGioiTinh(inputStr("Nhập Giới tính [M, F]: "));
        danhBa.setDiaChi(inputStr("Nhập Địa chỉ: "));
        danhBa.setNgaySinh(inputStr("Nhập Ngày sinh [dd/mm/yyy]: "));
        danhBa.setEmail(nhapEmail("Nhập Email: "));
        if (danhBaManager.add(danhBa)) {
            System.out.println("Thêm danh bạ thành công!");
        } else {
            showMsg("Có lỗi xảy ra, vui lòng thử lại!");
        }
    }

    void capNhatDanhBa() {
        tieuDe("---- CẬP NHẬT ----");
        String soDienThoai = inputStr("Nhập vào số điện thoại của danh bạ cần sửa: ");
        DanhBa danhBa = danhBaManager.findByPhone(soDienThoai);
        if (danhBa != null) {
            danhBa.setSoDienThoai(nhapSoDienThoai("Nhập số điện thoại: "));
            danhBa.setFacebook(inputStr("Nhập Nhóm: "));
            danhBa.setHoTen(inputStr("Nhập Họ tên: "));
            danhBa.setGioiTinh(inputStr("Nhập Giới tính [M, F]: "));
            danhBa.setDiaChi(inputStr("Nhập Địa chỉ: "));
            danhBa.setNgaySinh(inputStr("Nhập Ngày sinh [dd/mm/yyy]: "));
            danhBa.setEmail(nhapEmail("Nhập Email: "));
            for (int i = 0; i < danhBaManager.getAll().size(); i++) {
                danhBaManager.edit(i, danhBa);
                System.out.println("Sửa danh bạ thành công!");
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    void xoaDanhBa() {
        tieuDe("---- XÓA DANH BẠ ----");
        String soDienThoai = inputStr("Nhập vào số điện thoại của danh bạ cần xóa: ");
        DanhBa danhBa = danhBaManager.findByPhone(soDienThoai);
        if (danhBa != null) {
            String confirm = inputStr("Bạn thực sự muốn xóa danh bạ này? [Y/n]: ");
            if (confirm.toUpperCase().equals("Y")) {
                if (danhBaManager.remove(danhBa)) {
                    showMsg("Xóa danh bạ thành công!");
                } else {
                    showMsg("Có lỗi xảy ra, vui lòng thử lại!");
                }
            } else {
                return;
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    void timKiemDanhBa() throws InputMismatchException {
        tieuDe("---- TÌM KIẾM DANH BẠ ----");
        int choiceSearch;
        do {
            System.out.println("1. Tìm theo số điện thoại");
            System.out.println("2. Tìm theo họ tên");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choiceSearch = scanner.nextInt();
            scanner.nextLine();
            switch (choiceSearch) {
                case 1:
                    timTheoSoDienThoai();
                    break;
                case 2:
                    timTheoHoTen();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("No choice!");
            }
        } while (choiceSearch != 0);
    }

    private void timTheoHoTen() {
        tieuDe("---- TÌM THEO HỌ TÊN ----");
        String hoTen = inputStr("Nhập họ tên: ");
        List<DanhBa> danhBaList = danhBaManager.searchByName(hoTen);
        if (danhBaList.size() > 0) {
            for (DanhBa danhBa: danhBaList) {
                System.out.println(danhBa.toString());
            }
        } else {
            System.out.println("Không tìm được danh bạ với họ tên trên");
        }
    }

    private void timTheoSoDienThoai() {
        tieuDe("---- TÌM THEO SỐ ĐIỆN THOẠI ----");
        String soDienThoai = inputStr("Nhập số điện thoại: ");
        List<DanhBa> danhBaList = danhBaManager.searchByPhone(soDienThoai);
        if (danhBaList.size() > 0) {
            System.out.println("Tìm thấy " + danhBaList.size() + " kết quả cho: " + soDienThoai);
            for (DanhBa danhBa: danhBaList) {
                System.out.println(danhBa.toString());
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    void docTuFile() {
        tieuDe("---- ĐỌC TỪ FILE ----");
        String confirm = inputStr("Cảnh báo: Lựa chọn này sẽ xóa toàn bộ bộ nhớ! [Y/n]: ");
        if (confirm.toUpperCase().equals("Y")) {
            List<DanhBa> docFileList = danhBaFileIO.readCSV("12contacts.csv");
            if (docFileList.size() > 0) {
                System.out.println("Đọc từ file \"data/contacts.csv\" thành công!");
                danhBaManager.setDanhBaList(docFileList);
            } else {
                showMsg("Đã xảy ra lỗi đọc file!");
            }
        }
    }

    void ghiVaoFile() {
        tieuDe("---- GHI VÀO FILE ----");
        String confirm = inputStr("Cảnh báo: Lựa chọn này sẽ ghi đè nội dung mới! [Y/n]: ");
        if (confirm.toUpperCase().equals("Y")) {
            if (danhBaFileIO.writeCSVFile(danhBaManager.getAll(), "contacts.csv")) {
                System.out.println("Ghi vào file \"data/contacts.csv\" thành công!");
            } else {
                showMsg("Đã xảy ra lỗi ghi file!");
            }
        }
    }

    void thoat() {
        tieuDe("---- THOÁT CHƯƠNG TRÌNH ----");
        System.exit(0);
    }

    void tieuDe(String title) {
        System.out.println(title);
    }

    private String inputStr(String title) {
        String str;
        while (true) {
            System.out.print(title);
            str = scanner.nextLine();
            if (str == "") {
                System.out.println("Trường dữ liệu không được bỏ trống. Vui lòng nhập lại!");
                continue;
            } else {
                break;
            }
        }
        return str;
    }

    public String nhapSoDienThoai(String title) {
        String str;
        while (true) {
            System.out.print(title);
            str = scanner.nextLine();
            if (str == "") {
                System.out.println("Trường dữ liệu không được bỏ trống. Vui lòng nhập lại!");
                continue;
            } else if (!formValidator.phone(str)) {
                System.out.println("Nhập sai định dạng. Vui lòng nhập lại");
                continue;
            } else {
                break;
            }
        }
        return str;
    }

    public String nhapEmail(String title) {
        String str;
        while (true) {
            System.out.print(title);
            str = scanner.nextLine();
            if (str == "") {
                System.out.println("Trường dữ liệu không được bỏ trống. Vui lòng nhập lại!");
                continue;
            } else if (!formValidator.email(str)) {
                System.out.println("Nhập sai định dạng. Vui lòng nhập lại");
                continue;
            } else {
                break;
            }
        }
        return str;
    }

    private void showMsg(String s) {
        System.out.println(s);
    }
}
