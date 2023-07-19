package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.BaiViet;
import QuanLyKhoaHoc.Models.ChuDe;
import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.TaiKhoan;
import QuanLyKhoaHoc.Repository.BaiVietRepo;
import QuanLyKhoaHoc.Services.BaiVietServi;
import QuanLyKhoaHoc.Services.ChuDeServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaiVietControll {
    @Autowired
    private BaiVietServi baiVietServi;
    @RequestMapping(value = "baiviet/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaiViet addNewBaiViet(@RequestBody BaiViet bvM){
        return baiVietServi.addNewBaiViet(bvM);
    }
    @RequestMapping(value = "baiviet/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaiViet remakeBaiViet(@RequestBody BaiViet bvS){
        return baiVietServi.remakeBaiViet(bvS);
    }
    @RequestMapping(value = "baiviet/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaiViet removeBaiViet(@RequestParam int baiVietId){
        return baiVietServi.removeBaiViet(baiVietId);
    }
    @RequestMapping(value = "baiviet/laytatca", method = RequestMethod.GET)
    public List<BaiViet> getAllBaiViet(){
        return baiVietServi.getAllBaiViet();}
    @RequestMapping(value = "baiviet/phantrang", method = RequestMethod.GET)
    public List<BaiViet> getPaginatedBaiVietList(@RequestParam int pageNo, @RequestParam int pageSize){
        return baiVietServi.getPaginatedBaiVietList(pageNo,pageSize);
    }
    @RequestMapping(value = "baiviet/timkiem", method = RequestMethod.GET)
    public List<BaiViet> getBaiViet(@RequestParam String tenBaiViet){
        return baiVietServi.getBaiViet(tenBaiViet);
    }
}
