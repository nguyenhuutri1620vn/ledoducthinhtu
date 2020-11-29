/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import ConnectDatabase.DBConnect;
import Entity.LopHocPhan;
import Entity.PhieuDangKyHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ND
 */
public class PhieuDangKyHocDAO {

    
    public PhieuDangKyHoc dangkyhoc(PhieuDangKyHoc dkd){
   
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into tblPhieuDangKyHoc(fldMaLHP,fldMaSV,fldHocKy,fldNamHoc,fldNgayDangKy) values(?,?,?,?,?)");
                ps.setString(1, dkd.getMaLHP());
                ps.setString(2, dkd.getMaSV());
                ps.setString(3, dkd.getHocKy());
                ps.setString(4, dkd.getNamHoc());
                ps.setString(5, dkd.getNgayDangKy());
               
                int row = ps.executeUpdate();
                if (row < 1) {
                    dkd = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuDangKyHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                dkd = null;
            } finally {
                DBConnect.close(ps);
            }
        }
       return dkd;
    }
    public void huydangkyhoc(String maLHP,String maSV) throws SQLException{
   
       PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblPhieuDangKyHoc where fldMaLHP= ? and fldMaSV =?");
            ps.setString(1, maLHP);
            ps.setString(2, maSV);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    public ArrayList<PhieuDangKyHoc> getAll() {
        ArrayList<PhieuDangKyHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblPhieuDangKyHoc");
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyHoc>();
                while (rs.next()) {
                    PhieuDangKyHoc dkd = new PhieuDangKyHoc();   
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    dkd.setHocKy(rs.getString(3));
                    dkd.setNamHoc(rs.getString(4));
                    dkd.setNgayDangKy(rs.getString(5));
                    list.add(dkd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocPhanDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
    public ArrayList<PhieuDangKyHoc> checkID(String maLHP) {
      ArrayList<PhieuDangKyHoc> list = null;
      PreparedStatement psCheck = null;
      ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblPhieuDangKyHoc where fldMaLHP=?");
                psCheck.setString(1, maLHP);
                rs = psCheck.executeQuery();
                list = new ArrayList<PhieuDangKyHoc>();
                while (rs.next()) {
                    PhieuDangKyHoc lh = new PhieuDangKyHoc();
                    lh.setMaLHP(rs.getString(1));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            }finally{
            DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    public ArrayList<PhieuDangKyHoc> sapxeptheoNamHoc(String namHoc) {
        ArrayList<PhieuDangKyHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblPhieuDangKyHoc where fldNamHoc = ?");
               ps.setString(1, namHoc);
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyHoc>();
                while (rs.next()) {
                    PhieuDangKyHoc dkd = new PhieuDangKyHoc();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    dkd.setHocKy(rs.getString(3));
                    dkd.setNamHoc(rs.getString(4));
                    dkd.setNgayDangKy(rs.getString(5));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
   public ArrayList<PhieuDangKyHoc> getAll_LHP_ByMaSV(String maSV) {
        ArrayList<PhieuDangKyHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblPhieuDangKyHoc where fldMaSV = ?");
               ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyHoc>();
                while (rs.next()) {
                    PhieuDangKyHoc dkd = new PhieuDangKyHoc();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    dkd.setHocKy(rs.getString(3));
                    dkd.setNamHoc(rs.getString(4));
                    dkd.setNgayDangKy(rs.getString(5));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
   public ArrayList<PhieuDangKyHoc> getOne_LHP_By_MaLHP_MaSV(String maLHP,String maSV) {
        ArrayList<PhieuDangKyHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblPhieuDangKyHoc where fldMaLHP = ? and fldMaSV=?");
               ps.setString(1, maLHP);
               ps.setString(2, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyHoc>();
                while (rs.next()) {
                    PhieuDangKyHoc dkd = new PhieuDangKyHoc();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaSV(rs.getString(2));
                    dkd.setHocKy(rs.getString(3));
                    dkd.setNamHoc(rs.getString(4));
                    dkd.setNgayDangKy(rs.getString(5));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                list=null;
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
 
}

