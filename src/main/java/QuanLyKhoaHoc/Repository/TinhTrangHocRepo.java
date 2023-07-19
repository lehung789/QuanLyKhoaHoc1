package QuanLyKhoaHoc.Repository;

import QuanLyKhoaHoc.Models.TinhTrangHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhTrangHocRepo extends JpaRepository<TinhTrangHoc,Integer> {
}
