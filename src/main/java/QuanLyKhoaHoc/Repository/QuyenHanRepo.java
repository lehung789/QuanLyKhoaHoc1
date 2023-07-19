package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.DangKiHoc;
import QuanLyKhoaHoc.Models.QuyenHan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan,Integer> {
    @Query(value = "SELECT * FROM QuyenHan ",nativeQuery = true)
    Page<QuyenHan> findAll(Pageable pageable);
}
