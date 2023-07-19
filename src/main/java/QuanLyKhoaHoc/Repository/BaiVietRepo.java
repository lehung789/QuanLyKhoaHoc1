package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.BaiViet;
import QuanLyKhoaHoc.Models.LoaiBaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface BaiVietRepo extends JpaRepository<BaiViet,Integer> {
    @Query(value = "SELECT * FROM BaiViet ",nativeQuery = true)
    Page<BaiViet> findAll(Pageable pageable);
}
