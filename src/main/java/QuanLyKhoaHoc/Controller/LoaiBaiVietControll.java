package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.LoaiBaiViet;
import QuanLyKhoaHoc.Models.LoaiKhoaHoc;
import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Services.LoaiBaiVietServi;
import QuanLyKhoaHoc.Services.LoaiKhoaHocServi;
import QuanLyKhoaHoc.Services.QuyenHanServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoaiBaiVietControll {
    @Autowired
    private LoaiBaiVietServi loaiBaiVietServi;
    @RequestMapping(value = "loaibaiviet/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet addNewLoaiBaiViet(@RequestBody LoaiBaiViet lbvM){
        return loaiBaiVietServi.addNewLoaiBaiViet(lbvM);
    }
    @RequestMapping(value = "loaibaiviet/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet remakeLoaiBaiViet(@RequestBody LoaiBaiViet lbvS){
        return loaiBaiVietServi.remakeLoaiBaiViet(lbvS);
    }
    @RequestMapping(value = "loaibaiviet/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet removeLoaiBaiViet(@RequestParam int loaiBaiVietId){
        return loaiBaiVietServi.removeLoaiBaiViet(loaiBaiVietId);
    }
    @RequestMapping(value = "loaibaiviet/laytatca", method = RequestMethod.GET)
    public List<LoaiBaiViet> getAllLoaiBaiViet(){
        return loaiBaiVietServi.getAllLoaiBaiViet();}
    @RequestMapping(value = "loaibaiviet/phantrang", method = RequestMethod.GET)
    public List<LoaiBaiViet> getPaginatedLoaiBaiVietList(@RequestParam int pageNo, @RequestParam int pageSize){
        return loaiBaiVietServi.getPaginatedLoaiBaiVietList(pageNo,pageSize);
    }
}
