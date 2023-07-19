package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Models.TaiKhoan;
import QuanLyKhoaHoc.Models.TinhTrangHoc;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ITaiKhoanServi {
    public String addNewTaiKhoan(TaiKhoan tkM);
    public String remakeTaiKhoan(TaiKhoan tkS);
    public TaiKhoan removeTaiKhoan(int taiKhoanId);
    public List<TaiKhoan> getAllTaiKhoan();
    public List<TaiKhoan> getTaiKhoan(String tenTaiKhoan);
    public List<TaiKhoan> getPaginatedTaiKhoanList(@RequestParam int pageNo, @RequestParam int pageSize);
}
