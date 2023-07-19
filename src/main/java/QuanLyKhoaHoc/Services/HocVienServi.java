package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.TaiKhoan;
import QuanLyKhoaHoc.Repository.HocVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HocVienServi implements IHocVienServi {
    @Autowired
    private HocVienRepo hocVienRepo;

    @Override
    public String addNewHocVien(HocVien hvM) {
        if (kiemTraEmai(hvM.getEmail()) == false) {
            return "trùng email. Xin vui lòng nhập lại!";
        }
        if (kiemTraSdt(hvM.getSdt()) == false) {
            return "trùng sdt. Xin vui lòng nhập lại!";
        }
        hvM.setHoTen(formatHoTen(hvM.getHoTen()));
        hocVienRepo.save(hvM);
        return "Thêm thành công.";
    }

    private boolean kiemTraEmai(String email) {
        for (HocVien hv : hocVienRepo.findAll()) {
            if (hv.getEmail().contains(email))
                return false;
        }
        return true;
    }

    private boolean kiemTraSdt(String sdt) {
        for (HocVien hv : hocVienRepo.findAll()) {
            if (hv.getSdt().contains(sdt))
                return false;
        }
        return true;
    }

    @Override
    public String remakeHocVien(HocVien hvS) {
        if (kiemTraEmai(hvS.getEmail()) == false) {
            return "trùng email. Xin vui lòng nhập lại!";
        }
        if (kiemTraSdt(hvS.getSdt()) == false) {
            return "trùng sdt. Xin vui lòng nhập lại!";
        }
        Optional<HocVien> hocVien = hocVienRepo.findById(hvS.getHocVienId());
        if (hocVien.isEmpty())
            return null;
        HocVien hv = hocVien.get();
        hv.setHinhAnh(hvS.getHinhAnh());
        hv.setHoTen(hvS.getHoTen());
        hv.setNgaySinh(hvS.getNgaySinh());
        hv.setSdt(hvS.getSdt());
        hv.setEmail(hvS.getEmail());
        hv.setTinhThanh(hvS.getTinhThanh());
        hv.setQuanHuyen(hvS.getQuanHuyen());
        hv.setPhuongXa(hvS.getPhuongXa());
        hv.setSoNha(hvS.getSoNha());
        hocVienRepo.save(hv);
        return "sửa thành công.";
    }

    @Override
    public HocVien removeHocVien(int hocVienId) {
        Optional<HocVien> hocVien = hocVienRepo.findById(hocVienId);
        if (hocVien.isEmpty())
            return null;
        hocVienRepo.delete(hocVien.get());
        return hocVien.get();
    }

    @Override
    public List<HocVien> getAllHocVien() {
        return hocVienRepo.findAll();
    }

    @Override
    public List<HocVien> getHocVien(String tenHv, String tenEm) {
        List<HocVien> hocViens = new ArrayList<>();
        for (HocVien hv : hocVienRepo.findAll()) {
            if (hv.getHoTen().toLowerCase().contains(tenHv.toLowerCase()) && hv.getEmail().toLowerCase().contains(tenEm.toLowerCase()))

                hocViens.add(hv);
        }

        return hocViens;
    }

    @Override
    public List<HocVien> getPaginatedHocVienList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        List<HocVien> hocViens = hocVienRepo.findAll(pageable).toList();
        return hocViens;
    }

    private String formatHoTen(String hoTen) {
        // Kiểm tra xem họ tên có giá trị không
        if (hoTen != null && !hoTen.isEmpty()) {
            // Chuyển đổi họ tên thành chữ viết hoa chữ cái đầu tiên của mỗi từ
            String[] words = hoTen.split("\\s+");
            StringBuilder formattedHoTen = new StringBuilder();

            for (String word : words) {
                if (!word.isEmpty()) {
                    String firstLetter = word.substring(0, 1).toUpperCase();
                    String restLetters = word.substring(1).toLowerCase();
                    String formattedWord = firstLetter + restLetters;
                    formattedHoTen.append(formattedWord).append(" ");
                }
            }
            // Xóa dấu cách thừa ở cuối chuỗi
            return formattedHoTen.toString().trim();
        }
        // Trả về họ tên ban đầu nếu không có gì để định dạng
        return hoTen;
    }

}
