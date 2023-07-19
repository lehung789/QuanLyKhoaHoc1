package QuanLyKhoaHoc.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chude")
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeId;
    @Column(name = "tenchude")
    private String tenChuDe;
    @Column(name = "noidung")
    private String noiDung;
    @OneToMany(mappedBy = "chuDe",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("chuDe")
    private List<BaiViet> baiViets;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaibaivietid")
    @JsonIgnoreProperties("chuDes")
    private LoaiBaiViet loaiBaiViet;

    public int getChuDeId() {
        return chuDeId;
    }

    public void setChuDeId(int chuDeId) {
        this.chuDeId = chuDeId;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(List<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }

    public LoaiBaiViet getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }
}
