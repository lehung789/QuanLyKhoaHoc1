package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.ChuDe;
import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.LoaiBaiViet;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IChuDeServi {
    public ChuDe addNewChuDe(ChuDe cdM);
    public ChuDe remakeChuDe(ChuDe cdS);

    public ChuDe removeChuDe(int chuDeId);
    public List<ChuDe> getAllChuDe();
    public List<ChuDe> getPaginatedChuDeList(@RequestParam int pageNo, @RequestParam int pageSize);
}
