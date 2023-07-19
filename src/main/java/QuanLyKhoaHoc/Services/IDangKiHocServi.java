package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.HocVien;

import java.util.List;

public interface IDangKiHocServi {
    public DangKiHoc addNewDangKiHoc(DangKiHoc dkhM);
    public DangKiHoc remakeDangKiHoc(DangKiHoc dkhS);

    public DangKiHoc removeDangKiHoc(int dangKiHocId);
    public List<DangKiHoc> getAllDangKiHoc();
    public List<DangKiHoc> getPaginatedDangKiHocList(int pageNo, int pageSize);
}
