package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.LoaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhoaHocRepo extends JpaRepository<LoaiKhoaHoc,Integer> {
}
