package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.BaiViet;
import QuanLyKhoaHoc.Models.ChuDe;
import QuanLyKhoaHoc.Models.LoaiBaiViet;
import QuanLyKhoaHoc.Models.TaiKhoan;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public interface IBaiVietServi {
    public BaiViet addNewBaiViet(BaiViet bvM);
    public BaiViet remakeBaiViet(BaiViet bvS);

    public BaiViet removeBaiViet(int baiVietId);
    public List<BaiViet> getAllBaiViet();
    public List<BaiViet> getPaginatedBaiVietList(@RequestParam int pageNo, @RequestParam int pageSize);

    public List<BaiViet> getBaiViet(String tenBaiViet);
}
