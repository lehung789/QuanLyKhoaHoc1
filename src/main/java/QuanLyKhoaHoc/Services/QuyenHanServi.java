package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.KhoaHoc;
import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Repository.QuyenHanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuyenHanServi implements IQuyenHanServi{
    @Autowired
    private QuyenHanRepo quyenHanRepo;

    @Override
    public QuyenHan addNewQuyenHan(QuyenHan qhM) {
        return quyenHanRepo.save(qhM);
    }

    @Override
    public QuyenHan remakeQuyenHan(QuyenHan qhS) {
        Optional<QuyenHan> quyenHan = quyenHanRepo.findById(qhS.getQuyenHanId());
        if (quyenHan.isEmpty())
            return null;
        QuyenHan qh = quyenHan.get();
        qh.setTenQuyenHan(qhS.getTenQuyenHan());
        quyenHanRepo.save(qh);
        return qh;
    }

    @Override
    public QuyenHan removeQuyenHan(int quyenHanId) {
        Optional<QuyenHan> quyenHan = quyenHanRepo.findById(quyenHanId);
        if (quyenHan.isEmpty())
            return null;
        QuyenHan qh = quyenHan.get();
        quyenHanRepo.delete(qh);
        return qh;
    }

    @Override
    public List<QuyenHan> getAllQuyenHan() {
        return quyenHanRepo.findAll();
    }

    @Override
    public List<QuyenHan> getPaginatedQuyenHanList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        List<QuyenHan> quyenHans = quyenHanRepo.findAll(pageable).toList();
        return quyenHans;
    }
}
