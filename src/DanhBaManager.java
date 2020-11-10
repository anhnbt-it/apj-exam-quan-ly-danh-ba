import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/11/2020
 * Time: 9:38 SA
 */

public class DanhBaManager implements Manager<DanhBa> {
    private List<DanhBa> danhBaList = new ArrayList<>();

    @Override
    public boolean add(DanhBa obj) {
        return danhBaList.add(obj);
    }

    @Override
    public boolean remove(DanhBa obj) {
        return danhBaList.remove(obj);
    }

    @Override
    public DanhBa remove(int index) {
        return danhBaList.remove(index);
    }

    @Override
    public DanhBa edit(int index, DanhBa obj) {
        return danhBaList.set(index, obj);
    }

    public List<DanhBa> getAll() {
        return danhBaList;
    }

    public void setDanhBaList(List<DanhBa> danhBaList) {
        this.danhBaList = danhBaList;
    }

    public DanhBa findByPhone(String soDienThoai) {
        for (DanhBa danhBa: danhBaList) {
            if (danhBa.getSoDienThoai().equals(soDienThoai)) {
                return danhBa;
            }
        }
        return null;
    }

    public List<DanhBa> searchByName(String hoTen) {
        List<DanhBa> searchList = new ArrayList<>();
        for (DanhBa danhBa: danhBaList) {
            if (danhBa.getHoTen().contains(hoTen)) {
                searchList.add(danhBa);
            }
        }
        return searchList;
    }

    public List<DanhBa> searchByPhone(String soDienThoai) {
        List<DanhBa> searchList = new ArrayList<>();
        for (DanhBa danhBa: danhBaList) {
            if (danhBa.getSoDienThoai().contains(soDienThoai)) {
                searchList.add(danhBa);

            }
        }
        return searchList;
    }
}
