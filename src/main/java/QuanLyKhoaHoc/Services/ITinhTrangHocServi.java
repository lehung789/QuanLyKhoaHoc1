package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.TinhTrangHoc;

import java.util.List;

public interface ITinhTrangHocServi {
    public TinhTrangHoc addNewTinhTrangHoc(TinhTrangHoc tthM);
    public TinhTrangHoc remakeTinhTrangHoc(TinhTrangHoc tthS);
    public TinhTrangHoc removeTinhTrangHoc(int tinhTrangHocId);
    public List<TinhTrangHoc> getAllTinhTrangHoc();
}
