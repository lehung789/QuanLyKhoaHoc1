package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dangkihoc")
public class DangKiHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dangkihocid")
    private int dangKiHocId;
    @Column(name = "ngaydangki")
    private LocalDate ngayDangKi;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khoahocid")
    @JsonIgnoreProperties("dangKiHocs")
    private KhoaHoc khoaHoc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tinhtranghocid")
    @JsonIgnoreProperties("dangKiHocs")
    private TinhTrangHoc tinhTrangHoc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hocvienid")
    @JsonIgnoreProperties("dangKiHocs")
    private HocVien hocVien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taikhoanid")
    @JsonIgnoreProperties("dangKiHocs")
    private TaiKhoan taiKhoan;

    public int getDangKiHocId() {
        return dangKiHocId;
    }

    public void setDangKiHocId(int dangKiHocId) {
        this.dangKiHocId = dangKiHocId;
    }

    public LocalDate getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(LocalDate ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
