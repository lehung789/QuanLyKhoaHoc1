package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "baiviet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    private int baiVietId;
    @Column(name = "tenbaiviet")
    private String tenBaiViet;
    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao;
    @Column(name = "tentacgia")
    private String tenTacGia;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "noidungngan")
    private String noiDungNgan;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taikhoanid")
    @JsonIgnoreProperties("baiViets")
    private TaiKhoan taiKhoan;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chudeid")
    @JsonIgnoreProperties("baiViets")
    private ChuDe chuDe;

    public int getBaiVietId() {
        return baiVietId;
    }

    public void setBaiVietId(int baiVietId) {
        this.baiVietId = baiVietId;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public LocalDate getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDate thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungNgan() {
        return noiDungNgan;
    }

    public void setNoiDungNgan(String noiDungNgan) {
        this.noiDungNgan = noiDungNgan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public ChuDe getChuDe() {
        return chuDe;
    }

    public void setChuDe(ChuDe chuDe) {
        this.chuDe = chuDe;
    }
}
