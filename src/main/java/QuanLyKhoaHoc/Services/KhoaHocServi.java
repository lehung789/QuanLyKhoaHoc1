package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.HocVien;
import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.TinhTrangHoc;
import QuanLyKhoaHoc.Repository.DangKiHocRepo;
import QuanLyKhoaHoc.Repository.HocVienRepo;
import QuanLyKhoaHoc.Repository.KhoaHocRepo;
import QuanLyKhoaHoc.Repository.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KhoaHocServi implements IKhoaHocServi {
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private HocVienRepo hocVienRepo;
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    @Autowired
    private DangKiHocRepo dangKiHocRepo;

    @Override
    public KhoaHoc addNewKhoaHoc(KhoaHoc khM) {
        khoaHocRepo.save(khM);
        khM.setSoHocVien(0);
        //  khM.setSoHocVien(hocVien(khoaHocRepo.findById(khM.getKhoaHocId()).get().getSoHocVien()));
        return khM;
    }

    @Override
    public KhoaHoc remakeKhoaHoc(KhoaHoc khS) {
        Optional<KhoaHoc> khoaHoc = khoaHocRepo.findById(khS.getKhoaHocId());
        if (khoaHoc.isEmpty())
            return null;
        KhoaHoc kh = khoaHoc.get();
        kh.setTenKhoaHoc(khS.getTenKhoaHoc());
        kh.setThoiGianHoc(khS.getThoiGianHoc());
        kh.setGioiThieu(khS.getGioiThieu());
        kh.setNoiDung(khS.getNoiDung());
        kh.setHocPhi(khS.getHocPhi());
        kh.setSoHocVien(khS.getSoHocVien());
        kh.setSoLuongMon(khS.getSoLuongMon());
        kh.setHinhAnh(khS.getHinhAnh());
        khoaHocRepo.save(kh);
        return kh;
    }

    @Override
    public KhoaHoc removeKhoaHoc(int khoaHocId) {
        Optional<KhoaHoc> khoaHoc = khoaHocRepo.findById(khoaHocId);
        if (khoaHoc.isEmpty())
            return null;
        khoaHocRepo.delete(khoaHoc.get());
        return khoaHoc.get();
    }

    @Override
    public List<KhoaHoc> getAllKhoaHoc() {
        return khoaHocRepo.findAll();
    }

    @Override
    public List<KhoaHoc> getKhoaHoc(String tenKhoaHoc) {
        List<KhoaHoc> khoaHocs = new ArrayList<>();
        for (KhoaHoc kh : khoaHocRepo.findAll()) {
            if (kh.getTenKhoaHoc().toLowerCase().contains(tenKhoaHoc.toLowerCase()))
                khoaHocs.add(kh);
        }
        return khoaHocs;
    }

    @Override
    public List<KhoaHoc> getPaginatedKhoaHocList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        List<KhoaHoc> khoaHocs = khoaHocRepo.findAll(pageable).toList();
        return khoaHocs;
    }

//    @Override
//    public int hocVien(int hv) {
//        List<HocVien> hocViens = hocVienRepo.findAll();
//        List<KhoaHoc> khoaHocs = khoaHocRepo.findAll();
//        List<TinhTrangHoc> tinhTrangHocs = tinhTrangHocRepo.findAll();
//        int count = 0;
//        for (int i = 0; i < hocViens.size(); i++) {
//            if (tinhTrangHocs.get(i).getTenTinhTrang().equals("đang học") || tinhTrangHocs.get(i).getTenTinhTrang().equals("chưa hoàn thành")) {
//                count += khoaHocs.get(i).getSoHocVien();
//            }
//
//        }
//        return count;
//    }

    @Override
    public void capNhapHocVien(int khoaHocId) {
        Optional<KhoaHoc> khoaHoc = khoaHocRepo.findById(khoaHocId);
        int soHocVien = 0;
        List<DangKiHoc> dangKiHocList = dangKiHocRepo.findAll();
        List<TinhTrangHoc> tinhTrangHoc = tinhTrangHocRepo.findAll();
        for (TinhTrangHoc tth : tinhTrangHoc) {
            if (tth.getTenTinhTrang().equals("đang học") || tth.getTenTinhTrang().equals("học xong") || tth.getTenTinhTrang().equals("chưa hoàn thành")) {
                //        int idtth =  tth.getTinhTrangHocId();
                for (DangKiHoc dk : dangKiHocList) {
                    if (dk.getTinhTrangHoc().getTinhTrangHocId() == tth.getTinhTrangHocId() && dk.getKhoaHoc().getKhoaHocId() == khoaHocId)
                        soHocVien++;
                }
            }
        }
        khoaHoc.get().setSoHocVien(soHocVien);
        khoaHocRepo.save(khoaHoc.get());
    }


}
