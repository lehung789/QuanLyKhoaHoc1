package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.ChuDe;
import QuanLyKhoaHoc.Repository.ChuDeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ChuDeServi implements IChuDeServi{
    @Autowired
    private ChuDeRepo chuDeRepo;

    @Override
    public ChuDe addNewChuDe(ChuDe cdM) {
         chuDeRepo.save(cdM);
         return cdM;
    }

    @Override
    public ChuDe remakeChuDe(ChuDe cdS) {
        Optional<ChuDe> chuDe = chuDeRepo.findById(cdS.getChuDeId());
        if (chuDe.isEmpty())
            return null;
        ChuDe cd = chuDe.get();
        cd.setTenChuDe(cdS.getTenChuDe());
        cd.setNoiDung(cdS.getNoiDung());
        chuDeRepo.save(cd);
        return cd;
    }

    @Override
    public ChuDe removeChuDe(int chuDeId) {
        Optional<ChuDe> chuDe = chuDeRepo.findById(chuDeId);
        if (chuDe.isEmpty())
            return null;
        ChuDe cd = chuDe.get();
        chuDeRepo.delete(cd);
        return cd;
    }

    @Override
    public List<ChuDe> getAllChuDe() {
        return chuDeRepo.findAll();
    }

    @Override
    public List<ChuDe> getPaginatedChuDeList(int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo,pageSize);
        List<ChuDe> chuDes = chuDeRepo.findAll(pageable).toList();
        return chuDes;
    }
}
