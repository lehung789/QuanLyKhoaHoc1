package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.HocVien;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IHocVienServi {
    public String addNewHocVien(HocVien hvM);
    public String remakeHocVien(HocVien hvS);
    public HocVien removeHocVien(int HocVienId);
    public List<HocVien> getAllHocVien();
    public List<HocVien> getHocVien (String tenHv, String tenEm);
    public List<HocVien> getPaginatedHocVienList(@RequestParam int pageNo, @RequestParam int pageSize);
}
