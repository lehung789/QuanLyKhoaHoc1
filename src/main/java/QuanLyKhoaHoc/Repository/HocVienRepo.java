package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.HocVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien,Integer> {
    @Query(value = "SELECT * FROM HocVien", nativeQuery = true)
    Page<HocVien> findAll(Pageable pageable);


}
