package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "loaibaiviet")
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaibaivietid")
    private int loaiBaiVietId;
    @Column(name = "tenloai")
    private String tebLoai;
    @OneToMany(mappedBy = "loaiBaiViet",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("loaiBaiViet")
    private List<ChuDe> chuDes;

    public int getLoaiBaiVietId() {
        return loaiBaiVietId;
    }

    public void setLoaiBaiVietId(int loaiBaiVietId) {
        this.loaiBaiVietId = loaiBaiVietId;
    }

    public String getTebLoai() {
        return tebLoai;
    }

    public void setTebLoai(String tebLoai) {
        this.tebLoai = tebLoai;
    }

    public List<ChuDe> getChuDes() {
        return chuDes;
    }

    public void setChuDes(List<ChuDe> chuDes) {
        this.chuDes = chuDes;
    }
}
