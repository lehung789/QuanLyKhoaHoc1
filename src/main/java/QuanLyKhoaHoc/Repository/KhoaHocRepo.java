package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.KhoaHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc,Integer> {
    @Query(value = "SELECT * FROM KhoaHoc", nativeQuery = true)
    Page<KhoaHoc> findAll(Pageable pageable);
}
