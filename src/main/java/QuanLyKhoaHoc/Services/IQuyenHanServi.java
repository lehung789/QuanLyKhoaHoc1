package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.QuyenHan;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IQuyenHanServi {
    public QuyenHan addNewQuyenHan(QuyenHan qhM);
    public QuyenHan remakeQuyenHan(QuyenHan qhS);

    public QuyenHan removeQuyenHan(int quyenHanId);
    public List<QuyenHan> getAllQuyenHan();
    public List<QuyenHan> getPaginatedQuyenHanList(@RequestParam int pageNo, @RequestParam int pageSize);
}
