package QuanLyKhoaHoc.Controller;

import QuanLyKhoaHoc.Models.ChuDe;
import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.LoaiBaiViet;
import QuanLyKhoaHoc.Services.ChuDeServi;
import QuanLyKhoaHoc.Services.DangKiHocServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChuDeControll {
    @Autowired
    private ChuDeServi chuDeServi;
    @RequestMapping(value = "chude/them", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuDe addNewChuDe(@RequestBody ChuDe cdM){
        return chuDeServi.addNewChuDe(cdM);
    }
    @RequestMapping(value = "chude/sua", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuDe remakeChuDe(@RequestBody ChuDe cdS){
        return chuDeServi.remakeChuDe(cdS);
    }
    @RequestMapping(value = "chude/xoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuDe removeChuDe(@RequestParam int chuDeId){
        return chuDeServi.removeChuDe(chuDeId);
    }
    @RequestMapping(value = "chude/laytatca", method = RequestMethod.GET)
    public List<ChuDe> getAllChuDe(){
        return chuDeServi.getAllChuDe();}
    @RequestMapping(value = "chude/phantrang", method = RequestMethod.GET)
    public List<ChuDe> getPaginatedChuDeList(@RequestParam int pageNo, @RequestParam int pageSize){
        return chuDeServi.getPaginatedChuDeList(pageNo,pageSize);
    }
}
