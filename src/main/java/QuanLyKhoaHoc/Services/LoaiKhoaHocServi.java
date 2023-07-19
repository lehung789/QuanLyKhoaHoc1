package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.LoaiKhoaHoc;
import QuanLyKhoaHoc.Repository.LoaiKhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiKhoaHocServi implements ILoaiKhocHocServi{
    @Autowired
    private LoaiKhoaHocRepo loaiKhoaHocRepo;

    @Override
    public LoaiKhoaHoc addNewLoaiKhoaHoc(LoaiKhoaHoc lkhm) {
        loaiKhoaHocRepo.save(lkhm);
        return lkhm;
    }

    @Override
    public LoaiKhoaHoc remakeLoaiKhoaHoc(LoaiKhoaHoc lkhS) {
        Optional<LoaiKhoaHoc> loaiKhoaHoc = loaiKhoaHocRepo.findById(lkhS.getLoaiKhoaHocId());
        if (loaiKhoaHoc.isEmpty())
            return null;
        LoaiKhoaHoc lkh =loaiKhoaHoc.get();
        lkh.setTenLoai(lkhS.getTenLoai());
        loaiKhoaHocRepo.save(lkh);
        return lkh;
    }

    @Override
    public LoaiKhoaHoc removeLoaiKhoaHoc(int loaiKhoaHocId) {
        Optional<LoaiKhoaHoc> loaiKhoaHoc = loaiKhoaHocRepo.findById(loaiKhoaHocId);
        if (loaiKhoaHoc.isEmpty())
            return null;
        loaiKhoaHocRepo.delete(loaiKhoaHoc.get());
        return loaiKhoaHoc.get();
    }
}
