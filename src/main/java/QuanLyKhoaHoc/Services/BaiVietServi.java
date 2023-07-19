package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.BaiViet;
import QuanLyKhoaHoc.Repository.BaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaiVietServi implements IBaiVietServi{
    @Autowired
    private BaiVietRepo baiVietRepo;

    @Override
    public BaiViet addNewBaiViet(BaiViet bvM) {
        LocalDate lc = LocalDate.now();
        bvM.setThoiGianTao(lc);
        return baiVietRepo.save(bvM);
    }

    @Override
    public BaiViet remakeBaiViet(BaiViet bvS) {
        Optional<BaiViet> baiViet = baiVietRepo.findById(bvS.getBaiVietId());
        if (baiViet.isEmpty())
            return null;
        BaiViet bv = baiViet.get();
        bv.setTenBaiViet(bvS.getTenBaiViet());
        bv.setThoiGianTao(bvS.getThoiGianTao());
        bv.setTenTacGia(bvS.getTenTacGia());
        bv.setNoiDung(bvS.getNoiDung());
        bv.setNoiDungNgan(bvS.getNoiDungNgan());
        bv.setHinhAnh(bvS.getHinhAnh());
        baiVietRepo.save(bv);
        return bv;

    }

    @Override
    public BaiViet removeBaiViet(int baiVietId) {
        Optional<BaiViet> baiViet = baiVietRepo.findById(baiVietId);
        if (baiViet.isEmpty())
            return null;
        BaiViet bv = baiViet.get();
        baiVietRepo.delete(bv);
        return bv;
    }

    @Override
    public List<BaiViet> getAllBaiViet() {
        return baiVietRepo.findAll();
    }

    @Override
    public List<BaiViet> getPaginatedBaiVietList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo,pageSize);
        List<BaiViet> baiViets = baiVietRepo.findAll(pageable).toList();
        return baiViets;
    }

    @Override
    public List<BaiViet> getBaiViet(String tenBaiViet) {
        List<BaiViet> baiViets = new ArrayList<>();
        for (BaiViet bv : baiVietRepo.findAll()) {
            if (bv.getTenBaiViet().toLowerCase().contains(tenBaiViet.toLowerCase()))
                baiViets.add(bv);
        }
        return baiViets;
    }
}
