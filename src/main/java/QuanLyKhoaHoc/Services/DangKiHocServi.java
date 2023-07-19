package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.TinhTrangHoc;
import QuanLyKhoaHoc.Repository.DangKiHocRepo;
import QuanLyKhoaHoc.Repository.KhoaHocRepo;
import QuanLyKhoaHoc.Repository.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DangKiHocServi implements IDangKiHocServi {
    @Autowired
    private DangKiHocRepo dangKiHocRepo;
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    @Autowired
    private KhoaHocRepo khoaHocRepo;

    @Override
    public DangKiHoc addNewDangKiHoc(DangKiHoc dkhM) {
        KhoaHoc khoaHoc = dkhM.getKhoaHoc();
        TinhTrangHoc tinhTrangHoc = dkhM.getTinhTrangHoc();
        HocVien hocVien = dkhM.getHocVien();
        if (khoaHoc != null && tinhTrangHoc != null && hocVien != null) {
            dkhM.setNgayDangKi(LocalDate.now());
            if (tinhTrangHoc.getTenTinhTrang().equals("đang học chính")) {
                LocalDate ngayBatDau = LocalDate.now();
                dkhM.setNgayBatDau(ngayBatDau);
                dkhM.setNgayKetThuc(ngayBatDau.plusDays(khoaHocRepo.findById(dkhM.getKhoaHoc().getKhoaHocId()).get().getThoiGianHoc()));
            }
            dangKiHocRepo.save(dkhM);
            return dkhM;
        } else {
            return null;
        }
    }

    @Override
    public DangKiHoc remakeDangKiHoc(DangKiHoc dkhS) {
        Optional<DangKiHoc> dangKiHoc = dangKiHocRepo.findById(dkhS.getDangKiHocId());
        if (dangKiHoc.isEmpty())
            return null;
        TinhTrangHoc tinhTrangHoc = dkhS.getTinhTrangHoc();
        DangKiHoc dkh = dangKiHoc.get();
        dkh.setTinhTrangHoc(dkhS.getTinhTrangHoc());
        dkh.setNgayDangKi(dkhS.getNgayDangKi());
        dkh.setKhoaHoc(dkhS.getKhoaHoc());
    //    if (tinhTrangHoc.getTenTinhTrang().equals("đang học chính")) {
      //      LocalDate ngayBatDau = LocalDate.now();
            dkh.setNgayBatDau(ngayBatDau(dangKiHoc.get().getDangKiHocId()));
            dkh.setNgayKetThuc(ngayBatDau(dangKiHoc.get().getDangKiHocId()).plusDays(khoaHocRepo.findById(dkhS.getKhoaHoc().getKhoaHocId()).get().getThoiGianHoc()));
    //    }

        dangKiHocRepo.save(dkh);
        return dkh;
    }

    @Override
    public DangKiHoc removeDangKiHoc(int dangKiHocId) {
        Optional<DangKiHoc> dangKiHoc = dangKiHocRepo.findById(dangKiHocId);
        if (dangKiHoc.isEmpty())
            return null;
        dangKiHocRepo.delete(dangKiHoc.get());
        return dangKiHoc.get();
    }

    @Override
    public List<DangKiHoc> getAllDangKiHoc() {
        return dangKiHocRepo.findAll();
    }

    @Override
    public List<DangKiHoc> getPaginatedDangKiHocList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        List<DangKiHoc> dangKiHocs = dangKiHocRepo.findAll(pageable).toList();
        return dangKiHocs;
    }

    public LocalDate ngayBatDau(int dangKiHocId) {
        Optional<DangKiHoc> dangKiHocs = dangKiHocRepo.findById(dangKiHocId);
        for (TinhTrangHoc tth : tinhTrangHocRepo.findAll()) {
            if (tth.getTenTinhTrang().equals("đang học chính"))
                return dangKiHocs.get().getNgayBatDau();
        }
        return null;
    }

}
