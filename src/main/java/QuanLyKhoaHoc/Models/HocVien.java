package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienId;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(unique = true)
    private String sdt;
    @Column(unique = true)
    private String email;
    @Column(name = "tinhthanh")
    private String tinhThanh;
    @Column(name = "quanhuyen")
    private String quanHuyen;
    @Column(name = "phuongxa")
    private String phuongXa;
    @Column(name = "sonha")
    private String soNha;
    @OneToMany(mappedBy = "hocVien",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("hocVien")
    private List<DangKiHoc> dangKiHocs;

    public int getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(int hocVienId) {
        this.hocVienId = hocVienId;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public List<DangKiHoc> getDangKiHocs() {
        return dangKiHocs;
    }

    public void setDangKiHocs(List<DangKiHoc> dangKiHocs) {
        this.dangKiHocs = dangKiHocs;
    }
}
