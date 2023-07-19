package QuanLyKhoaHoc.Repository;
import QuanLyKhoaHoc.Models.ChuDe;
import QuanLyKhoaHoc.Models.LoaiBaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepo extends JpaRepository<ChuDe,Integer> {
    @Query(value = "SELECT * FROM ChuDe ",nativeQuery = true)
    Page<ChuDe> findAll(Pageable pageable);
}
