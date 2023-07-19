package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Services.DangKiHocServi;
import QuanLyKhoaHoc.Services.HocVienServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DangKiHocControll {
    @Autowired
    private DangKiHocServi dangKiHocServi;
    @RequestMapping(value = "dangkihoc/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DangKiHoc addNewDangKiHoc(@RequestBody DangKiHoc dkhM){
        return dangKiHocServi.addNewDangKiHoc(dkhM);
    }
    @RequestMapping(value = "dangkihoc/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public DangKiHoc remakeDangKiHoc(@RequestBody DangKiHoc dkhS){
        return dangKiHocServi.remakeDangKiHoc(dkhS);
    }
    @RequestMapping(value = "dangkihoc/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DangKiHoc removeDangKiHoc(@RequestParam int dangKiHocId){
        return dangKiHocServi.removeDangKiHoc(dangKiHocId);
    }
    @RequestMapping(value = "dangkihoc/laytatca", method = RequestMethod.GET)
    public List<DangKiHoc> getAllDangKiHoc(){
        return dangKiHocServi.getAllDangKiHoc();}
    @RequestMapping(value = "dangkihoc/phantrang", method = RequestMethod.GET)
    public List<DangKiHoc> getPaginatedDangKiHocList(@RequestParam int pageNo, @RequestParam int pageSize){
        return dangKiHocServi.getPaginatedDangKiHocList(pageNo,pageSize);
    }
}
