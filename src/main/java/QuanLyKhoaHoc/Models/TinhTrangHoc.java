package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tinhtranghoc")
public class TinhTrangHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tinhtranghocid")
    private int tinhTrangHocId;
    @Column(name = "tentinhtrang")
    private String tenTinhTrang;
    @OneToMany(mappedBy = "tinhTrangHoc",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tinhTrangHoc")
    private List<DangKiHoc> dangKiHocs;

    public int getTinhTrangHocId() {
        return tinhTrangHocId;
    }

    public void setTinhTrangHocId(int tinhTrangHocId) {
        this.tinhTrangHocId = tinhTrangHocId;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public List<DangKiHoc> getDangKiHocs() {
        return dangKiHocs;
    }

    public void setDangKiHocs(List<DangKiHoc> dangKiHocs) {
        this.dangKiHocs = dangKiHocs;
    }
}
