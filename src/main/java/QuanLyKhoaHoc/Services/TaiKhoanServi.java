package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Models.TaiKhoan;
import QuanLyKhoaHoc.Repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanServi implements ITaiKhoanServi {
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @Override
    public String addNewTaiKhoan(TaiKhoan tkM) {
        if (kiemTra(tkM.getTaiKhoan()) == false)
            return "tài khoản đã tồn tại";
        String matKhau = tkM.getMatKhau();
        if (!matKhau.matches(".*\\d.*") || !matKhau.matches(".*[^\\w\\s].*")) {
            return "mật khẩu phải có cả ít nhất 1 số và 1 kí tự";
        }
         taiKhoanRepo.save(tkM);
        return "đã thêm";
    }

    private boolean kiemTra(String taikhoan) {
        for (TaiKhoan tk : taiKhoanRepo.findAll()) {
            if (tk.getTaiKhoan().contains(taikhoan))
                return false;
        }
        return true;
    }

    @Override
    public String remakeTaiKhoan(TaiKhoan tkS) {
        if (kiemTra(tkS.getTaiKhoan()) == false)
            return "tài khoản đã tồn tại";
        Optional<TaiKhoan> taiKhoan = taiKhoanRepo.findById(tkS.getTaiKhoanId());
        if (taiKhoan.isEmpty())
            return "null";
        TaiKhoan tk = taiKhoan.get();
        tk.setTenNguoiDung(tkS.getTenNguoiDung());
        tk.setTaiKhoan(tkS.getTaiKhoan());
        tk.setMatKhau(tkS.getMatKhau());
        String matKhau = tk.getMatKhau();
        if (!matKhau.matches(".*\\d.*") || !matKhau.matches(".*[^\\w\\s].*")) {
            return "mật khẩu phải có cả ít nhất 1 số và 1 kí tự";
        }
        taiKhoanRepo.save(tk);
        return "đã Sửa";
    }

    @Override
    public TaiKhoan removeTaiKhoan(int taiKhoanId) {
        Optional<TaiKhoan> taiKhoan = taiKhoanRepo.findById(taiKhoanId);
        if (taiKhoan.isEmpty())
            return null;
        TaiKhoan tk = taiKhoan.get();
        taiKhoanRepo.delete(tk);
        return tk;
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepo.findAll();
    }

    @Override
    public List<TaiKhoan> getTaiKhoan(String tenTaiKhoan) {
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        for (TaiKhoan tk : taiKhoanRepo.findAll()) {
            if (tk.getTaiKhoan().toLowerCase().contains(tenTaiKhoan.toLowerCase()))
                taiKhoans.add(tk);
        }
        return taiKhoans;
    }


    @Override
    public List<TaiKhoan> getPaginatedTaiKhoanList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        List<TaiKhoan> taiKhoans = taiKhoanRepo.findAll(pageable).toList();
        return taiKhoans;
    }
//    @Override
//    public Page<TaiKhoan> getTaiKhoanWithPaging(String tenTaiKhoan, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return taiKhoanRepo.findByTaiKhoanContainingIgnoreCase(tenTaiKhoan, pageable);
//    }
}
