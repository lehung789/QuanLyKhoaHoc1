package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.TinhTrangHoc;
import QuanLyKhoaHoc.Services.HocVienServi;
import QuanLyKhoaHoc.Services.TinhTrangHocServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TinhTrangHocControll {
    @Autowired
    private TinhTrangHocServi tinhTrangHocServi;
    @RequestMapping(value = "tinhtranghoc/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public TinhTrangHoc addNewTinhTrangHoc(@RequestBody TinhTrangHoc tthM){
        return tinhTrangHocServi.addNewTinhTrangHoc(tthM);
    }
    @RequestMapping(value = "tinhtranghoc/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public TinhTrangHoc remakeTinhTrangHoc(@RequestBody TinhTrangHoc tthS){
        return tinhTrangHocServi.remakeTinhTrangHoc(tthS);
    }
    @RequestMapping(value = "tinhtranghoc/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TinhTrangHoc removeTinhTrangHoc(@RequestParam int tinhTrangHocId){
        return tinhTrangHocServi.removeTinhTrangHoc(tinhTrangHocId);
    }
    @RequestMapping(value = "tinhtranghoc/laytatca", method = RequestMethod.GET)
    public List<TinhTrangHoc> getAllTinhTrangHoc(){
        return tinhTrangHocServi.getAllTinhTrangHoc();}
}
