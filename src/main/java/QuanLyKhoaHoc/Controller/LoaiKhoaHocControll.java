package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.LoaiKhoaHoc;
import QuanLyKhoaHoc.Services.LoaiKhoaHocServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaiKhoaHocControll {
    @Autowired
    private LoaiKhoaHocServi loaiKhoaHocServi;
    @RequestMapping(value = "them/loaikhoahoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc addNewLoaiKhoaHoc(@RequestBody LoaiKhoaHoc lkhm){
        return loaiKhoaHocServi.addNewLoaiKhoaHoc(lkhm);
    }
    @RequestMapping(value = "sua/loaikhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc remakeLoaiKhoaHoc(@RequestBody LoaiKhoaHoc lkhS){
        return loaiKhoaHocServi.remakeLoaiKhoaHoc(lkhS);
    }
    @RequestMapping(value = "xoa/loaikhoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc removeLoaiKhoaHoc(@RequestParam int loaiKhoaHocId){
        return loaiKhoaHocServi.removeLoaiKhoaHoc(loaiKhoaHocId);
    }
}
