package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.TinhTrangHoc;
import QuanLyKhoaHoc.Repository.HocVienRepo;
import QuanLyKhoaHoc.Repository.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTrangHocServi implements ITinhTrangHocServi{
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;

    @Override
    public TinhTrangHoc addNewTinhTrangHoc(TinhTrangHoc tthM) {
        tinhTrangHocRepo.save(tthM);
        return tthM;
    }

    @Override
    public TinhTrangHoc remakeTinhTrangHoc(TinhTrangHoc tthS) {
        Optional<TinhTrangHoc> tinhTrangHoc = tinhTrangHocRepo.findById(tthS.getTinhTrangHocId());
        if (tinhTrangHoc.isEmpty())
            return null;
        TinhTrangHoc tth = tinhTrangHoc.get();
        tth.setTenTinhTrang(tthS.getTenTinhTrang());
        tinhTrangHocRepo.save(tth);
        return tth;
    }

    @Override
    public TinhTrangHoc removeTinhTrangHoc(int tinhTrangHocId) {
        Optional<TinhTrangHoc> tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHocId);
        if (tinhTrangHoc.isEmpty())
            return null;
        tinhTrangHocRepo.delete(tinhTrangHoc.get());
        return tinhTrangHoc.get();
    }

    @Override
    public List<TinhTrangHoc> getAllTinhTrangHoc() {
        return tinhTrangHocRepo.findAll();
    }
}
