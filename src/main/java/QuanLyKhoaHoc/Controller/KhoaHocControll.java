package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Services.KhoaHocServi;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
public class KhoaHocControll {
    @Autowired
    private KhoaHocServi khoaHocServi;
    @RequestMapping(value = "khoahoc/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc addNewKhoaHoc(@RequestBody KhoaHoc khM){
        return khoaHocServi.addNewKhoaHoc(khM);
    }
    @RequestMapping(value = "khoahoc/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc remakeKhoaHoc(@RequestBody KhoaHoc khS){
        return khoaHocServi.remakeKhoaHoc(khS);
    }
    @RequestMapping(value = "khoahoc/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public KhoaHoc removeKhoaHoc(@RequestParam int khoaHocId){
        return khoaHocServi.removeKhoaHoc(khoaHocId);
    }
    @RequestMapping(value = "khoahoc/timkiem", method = RequestMethod.GET)
    public List<KhoaHoc> getKhoaHoc(@RequestParam String tenKhoaHoc){
        return khoaHocServi.getKhoaHoc(tenKhoaHoc);
    }
    @RequestMapping(value = "khoahoc/laytatca", method = RequestMethod.GET)
    public List<KhoaHoc> getAllKhoaHoc(){
        return khoaHocServi.getAllKhoaHoc();}
    @RequestMapping(value = "khoahoc/phantrang", method = RequestMethod.GET)
    public List<KhoaHoc> getPaginatedKhoaHocList(@RequestParam int pageNo, @RequestParam int pageSize){
        return khoaHocServi.getPaginatedKhoaHocList(pageNo,pageSize);
    }
    @RequestMapping(value = "khoahoc/capnhap", method = RequestMethod.GET)
    public void capNhapHocVien(@RequestParam int khoaHocId){
         khoaHocServi.capNhapHocVien(khoaHocId);
    }

}
