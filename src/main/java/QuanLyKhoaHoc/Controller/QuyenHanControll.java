package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Repository.QuyenHanRepo;
import QuanLyKhoaHoc.Services.HocVienServi;
import QuanLyKhoaHoc.Services.QuyenHanServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuyenHanControll {
    @Autowired
    private QuyenHanServi quyenHanServi;
    @RequestMapping(value = "quyenhan/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan addNewQuyenHan(@RequestBody QuyenHan qhM){
        return quyenHanServi.addNewQuyenHan(qhM);
    }
    @RequestMapping(value = "quyenhan/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan remakeQuyenHan(@RequestBody QuyenHan qhS){
        return quyenHanServi.remakeQuyenHan(qhS);
    }
    @RequestMapping(value = "quyenhan/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan removeQuyenHan(@RequestParam int quyenHanId){
        return quyenHanServi.removeQuyenHan(quyenHanId);
    }
    @RequestMapping(value = "quyenhan/laytatca", method = RequestMethod.GET)
    public List<QuyenHan> getAllQuyenHan(){
        return quyenHanServi.getAllQuyenHan();}
    @RequestMapping(value = "quyenhan/phantrang", method = RequestMethod.GET)
    public List<QuyenHan> getPaginatedQuyenHanList(@RequestParam int pageNo, @RequestParam int pageSize){
        return quyenHanServi.getPaginatedQuyenHanList(pageNo,pageSize);
    }
}
