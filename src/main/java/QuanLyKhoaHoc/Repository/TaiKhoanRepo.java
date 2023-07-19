package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.QuyenHan;
import QuanLyKhoaHoc.Models.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan,Integer> {
    @Query(value = "SELECT * FROM TaiKhoan ",nativeQuery = true)
    Page<TaiKhoan> findAll(Pageable pageable);
}
