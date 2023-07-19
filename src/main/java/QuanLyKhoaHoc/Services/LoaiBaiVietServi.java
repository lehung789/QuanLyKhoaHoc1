package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.LoaiBaiViet;
import QuanLyKhoaHoc.Repository.LoaiBaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiBaiVietServi implements ILoaiBaiVietServi{
    @Autowired
    private LoaiBaiVietRepo loaiBaiVietRepo;

    @Override
    public LoaiBaiViet addNewLoaiBaiViet(LoaiBaiViet lbvM) {
        return loaiBaiVietRepo.save(lbvM);
    }

    @Override
    public LoaiBaiViet remakeLoaiBaiViet(LoaiBaiViet lbvS) {
        Optional<LoaiBaiViet> loaiBaiViet = loaiBaiVietRepo.findById(lbvS.getLoaiBaiVietId());
        if (loaiBaiViet.isEmpty())
            return null;
        LoaiBaiViet lbv = loaiBaiViet.get();
        lbv.setTebLoai(lbvS.getTebLoai());
        loaiBaiVietRepo.save(lbv);
        return lbv;
    }

    @Override
    public LoaiBaiViet removeLoaiBaiViet(int loaiBaiVietId) {
        Optional<LoaiBaiViet> loaiBaiViet = loaiBaiVietRepo.findById(loaiBaiVietId);
        if (loaiBaiViet.isEmpty())
            return null;
        LoaiBaiViet lbv = loaiBaiViet.get();
        loaiBaiVietRepo.delete(lbv);
        return lbv;
    }

    @Override
    public List<LoaiBaiViet> getAllLoaiBaiViet() {
        return loaiBaiVietRepo.findAll();
    }

    @Override
    public List<LoaiBaiViet> getPaginatedLoaiBaiVietList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo,pageSize);
        List<LoaiBaiViet> loaiBaiViets = loaiBaiVietRepo.findAll(pageable).toList();
        return loaiBaiViets;
    }
}
