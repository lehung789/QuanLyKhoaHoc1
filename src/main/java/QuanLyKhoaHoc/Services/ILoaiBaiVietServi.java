package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.LoaiBaiViet;
import QuanLyKhoaHoc.Models.TaiKhoan;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ILoaiBaiVietServi {
    public LoaiBaiViet addNewLoaiBaiViet(LoaiBaiViet lbvM);
    public LoaiBaiViet remakeLoaiBaiViet(LoaiBaiViet lbvS);
    public LoaiBaiViet removeLoaiBaiViet(int loaiBaiVietId);
    public List<LoaiBaiViet> getAllLoaiBaiViet();
    public List<LoaiBaiViet> getPaginatedLoaiBaiVietList(@RequestParam int pageNo, @RequestParam int pageSize);
}
