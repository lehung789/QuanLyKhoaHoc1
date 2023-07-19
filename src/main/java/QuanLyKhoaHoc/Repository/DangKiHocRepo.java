package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.DangKiHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKiHocRepo extends JpaRepository<DangKiHoc,Integer> {
    @Query(value = "SELECT * FROM DangKiHoc ",nativeQuery = true)
    Page<DangKiHoc> findAll(Pageable pageable);
}
