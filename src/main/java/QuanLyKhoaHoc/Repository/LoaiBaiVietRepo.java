package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.LoaiBaiViet;
import QuanLyKhoaHoc.Models.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet,Integer> {
    @Query(value = "SELECT * FROM LoaiBaiViet ",nativeQuery = true)
    Page<LoaiBaiViet> findAll(Pageable pageable);
}
