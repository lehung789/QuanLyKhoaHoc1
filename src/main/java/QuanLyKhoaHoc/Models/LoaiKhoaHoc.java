package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "loaikhoahoc")
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaikhoahocid")
    private int loaiKhoaHocId;
    @Column(name = "tenloai")
    private String tenLoai;
    @OneToMany(mappedBy = "loaiKhoaHoc",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("loaiKhoaHoc")
    private List<KhoaHoc> khoaHocs;

    public int getLoaiKhoaHocId() {
        return loaiKhoaHocId;
    }

    public void setLoaiKhoaHocId(int loaiKhoaHocId) {
        this.loaiKhoaHocId = loaiKhoaHocId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<KhoaHoc> getKhoaHocs() {
        return khoaHocs;
    }

    public void setKhoaHocs(List<KhoaHoc> khoaHocs) {
        this.khoaHocs = khoaHocs;
    }
}
