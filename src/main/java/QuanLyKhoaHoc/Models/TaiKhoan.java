package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoanid")
    private int taiKhoanId;
    @Column(name = "tennguoidung")
    private String tenNguoiDung;
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;
    @OneToMany(mappedBy = "taiKhoan",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("taiKhoan")
    private List<DangKiHoc> dangKiHocs;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quyenhanid")
    @JsonIgnoreProperties("taiKhoans")
    private QuyenHan quyenHan;
    @OneToMany(mappedBy = "taiKhoan",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("taiKhoan")
    private List<BaiViet> baiViets;

    public int getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(int taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }


    public QuyenHan getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(QuyenHan quyenHan) {
        this.quyenHan = quyenHan;
    }

    public List<DangKiHoc> getDangKiHocs() {
        return dangKiHocs;
    }

    public void setDangKiHocs(List<DangKiHoc> dangKiHocs) {
        this.dangKiHocs = dangKiHocs;
    }

    public List<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(List<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }
}
