package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Services.HocVienServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HocVienControll {
    @Autowired
    private HocVienServi hocVienServi;
    @RequestMapping(value = "hocvien/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addNewHocVien(@RequestBody HocVien hvM){
        return hocVienServi.addNewHocVien(hvM);
    }
    @RequestMapping(value = "hocvien/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String remakeHocVien(@RequestBody HocVien hvS){
        return hocVienServi.remakeHocVien(hvS);
    }
    @RequestMapping(value = "hocvien/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien removeHocVien(@RequestParam int hocVienId){
        return hocVienServi.removeHocVien(hocVienId);
    }
    @RequestMapping(value = "hocvien/laytatca", method = RequestMethod.GET)
    public List<HocVien> getAllHocVien(){
        return hocVienServi.getAllHocVien();}
    @RequestMapping(value = "hocvien/timkiem", method = RequestMethod.GET)
    public List<HocVien> getHocVien(@RequestParam String tenHv, @RequestParam String tenEm){
        return hocVienServi.getHocVien(tenHv,tenEm);
    }
    @RequestMapping(value = "hocvien/phantrang", method = RequestMethod.GET)
    public List<HocVien> getPaginatedHocVienList(@RequestParam int pageNo, @RequestParam int pageSize){
        return hocVienServi.getPaginatedHocVienList(pageNo,pageSize);
    }

}
