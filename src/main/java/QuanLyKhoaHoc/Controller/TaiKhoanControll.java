package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Models.TaiKhoan;
import QuanLyKhoaHoc.Services.QuyenHanServi;
import QuanLyKhoaHoc.Services.TaiKhoanServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaiKhoanControll {
    @Autowired
    private TaiKhoanServi taiKhoanServi;
    @RequestMapping(value = "taikhoan/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addNewTaiKhoan(@RequestBody TaiKhoan tkM){
        return taiKhoanServi.addNewTaiKhoan(tkM);
    }
    @RequestMapping(value = "taikhoan/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeTaiKhoan(@RequestBody TaiKhoan tkS){
        return taiKhoanServi.remakeTaiKhoan(tkS);
    }
    @RequestMapping(value = "taikhoan/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TaiKhoan removeTaiKhoan(@RequestParam int taiKhoanId){
        return taiKhoanServi.removeTaiKhoan(taiKhoanId);
    }
    @RequestMapping(value = "taikhoan/laytatca", method = RequestMethod.GET)
    public List<TaiKhoan> getAllTaiKhoan(){
        return taiKhoanServi.getAllTaiKhoan();}
    @RequestMapping(value = "taikhoan/timkiem", method = RequestMethod.GET)
    public List<TaiKhoan> getTaiKhoan(@RequestParam String tenTaiKhoan){
        return taiKhoanServi.getTaiKhoan(tenTaiKhoan);
    }
    @RequestMapping(value = "taikhoan/phantrang", method = RequestMethod.GET)
    public List<TaiKhoan> getPaginatedTaiKhoanList(@RequestParam int pageNo, @RequestParam int pageSize){
        return taiKhoanServi.getPaginatedTaiKhoanList(pageNo,pageSize);
    }
}
