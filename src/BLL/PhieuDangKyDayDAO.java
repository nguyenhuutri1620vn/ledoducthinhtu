/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import ConnectDatabase.DBConnect;
import Entity.PhieuDangKyDay;
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
public class PhieuDangKyDayDAO {

    
    public PhieuDangKyDay dangkyday(PhieuDangKyDay dkd){
   
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into tblPhieuDangKyDay(fldMaLHP,fldMaGV,fldHocKy,fldNamHoc,fldNgayDangKy) values(?,?,?,?,?)");
                ps.setString(1, dkd.getMaLHP());
                ps.setString(2, dkd.getMaGV());
                ps.setString(3, dkd.getHocKy());
                ps.setString(4, dkd.getNamHoc());
                ps.setString(5, dkd.getNgayDangKy());
               
                int row = ps.executeUpdate();
                if (row < 1) {
                    dkd = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuDangKyDayDAO.class.getName()).log(Level.SEVERE, null, ex);
                dkd = null;
            } finally {
                DBConnect.close(ps);
            }
        }
       return dkd;
    }
    public void huydangkyday(String maLHP) throws SQLException{
   
       PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblPhieuDangKyDay where fldMaLHP= ?");
            ps.setString(1, maLHP);
            ps.executeUpdate();
            DBConnect.close();
        }
    }
    public ArrayList<PhieuDangKyDay> getAll() {
        ArrayList<PhieuDangKyDay> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblPhieuDangKyDay");
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyDay>();
                while (rs.next()) {
                    PhieuDangKyDay dkd = new PhieuDangKyDay();   
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaGV(rs.getString(2));
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
    public ArrayList<PhieuDangKyDay> checkMaLHP(String maLHP) {
      ArrayList<PhieuDangKyDay> list = null;
      PreparedStatement psCheck = null;
      ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblPhieuDangKyDay where fldMaLHP=?");
                psCheck.setString(1, maLHP);
                rs = psCheck.executeQuery();
                list = new ArrayList<PhieuDangKyDay>();
                while (rs.next()) {
                    PhieuDangKyDay lh = new PhieuDangKyDay();
                    lh.setMaLHP(rs.getString(1));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            DBConnect.close(psCheck, rs);
            }
            
        }
        return list;
    }
    public ArrayList<PhieuDangKyDay> sapxeptheoNamHoc(String namHoc) {
        ArrayList<PhieuDangKyDay> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblPhieuDangKyDay where fldNamHoc = ?");
               ps.setString(1, namHoc);
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyDay>();
                while (rs.next()) {
                    PhieuDangKyDay dkd = new PhieuDangKyDay();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaGV(rs.getString(2));
                    dkd.setHocKy(rs.getString(3));
                    dkd.setNamHoc(rs.getString(4));
                    dkd.setNgayDangKy(rs.getString(5));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
     public ArrayList<PhieuDangKyDay> getLHP_MaGV(String maGV) {
        ArrayList<PhieuDangKyDay> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblPhieuDangKyDay where fldMaGV = ?");
               ps.setString(1, maGV);
                rs = ps.executeQuery();
                list = new ArrayList<PhieuDangKyDay>();
                while (rs.next()) {
                    PhieuDangKyDay dkd = new PhieuDangKyDay();
                    dkd.setMaLHP(rs.getString(1));
                    dkd.setMaGV(rs.getString(2));
                    dkd.setHocKy(rs.getString(3));
                    dkd.setNamHoc(rs.getString(4));
                    dkd.setNgayDangKy(rs.getString(5));
                    list.add(dkd);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
   
   
}

