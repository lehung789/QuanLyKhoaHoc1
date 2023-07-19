package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.LoaiKhoaHoc;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface IKhoaHocServi {
    public KhoaHoc addNewKhoaHoc(KhoaHoc khM);
    public KhoaHoc remakeKhoaHoc(KhoaHoc khS);
    public KhoaHoc removeKhoaHoc(int khoaHocId);
    public List<KhoaHoc> getAllKhoaHoc();
    public List<KhoaHoc> getKhoaHoc(String tenKhocHoc);
    public List<KhoaHoc> getPaginatedKhoaHocList(int pageNo, int pageSize);
//    public int hocVien(int hv);
    public void capNhapHocVien(int khoaHocId);
}
