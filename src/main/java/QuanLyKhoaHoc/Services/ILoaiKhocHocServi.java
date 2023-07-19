package QuanLyKhoaHoc.Services;

import QuanLyKhoaHoc.Models.LoaiKhoaHoc;

public interface ILoaiKhocHocServi {
    public LoaiKhoaHoc addNewLoaiKhoaHoc(LoaiKhoaHoc lkhm);
    public LoaiKhoaHoc remakeLoaiKhoaHoc(LoaiKhoaHoc lkhS);
    public LoaiKhoaHoc removeLoaiKhoaHoc(int loaiKhoaHocId);
}
