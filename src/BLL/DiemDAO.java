/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import ConnectDatabase.DBConnect;
import Entity.Diem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anonymous
 */
public class DiemDAO implements IDiemDAO {

    @Override
    public ArrayList<Diem> getAll() {
       
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblDiem");
                rs = ps.executeQuery();
                list = new ArrayList<Diem>();
                while (rs.next()) {
                    Diem bd = new Diem();
                    bd.setMaLop(rs.getString(1));
                    bd.setMaSV(rs.getString(2));
                    bd.setMaMH(rs.getString(3));
                    bd.setDiemTK(rs.getString(4));
                    bd.setDiemGK(rs.getString(5));
                    bd.setDiemCK(rs.getString(6));
                    bd.setDiemTB(rs.getFloat(7));
                    bd.setXepLoai(rs.getString(8));

                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }


    @Override
    public ArrayList<Diem> findByMaMonHoc(String maMH) {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblDiem where fldMaMH = ?");
                ps.setString(1, maMH);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Diem bd = new Diem();
                   bd.setMaLop(rs.getString(1));
                    bd.setMaSV(rs.getString(2));
                    bd.setMaMH(rs.getString(3));
                    bd.setDiemTK(rs.getString(4));
                    bd.setDiemGK(rs.getString(5));
                    bd.setDiemCK(rs.getString(6));
                    bd.setDiemTB(rs.getFloat(7));
                    bd.setXepLoai(rs.getString(8));
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public Diem addNew(Diem bd) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into tblDiem values (?,?,?,?,?,?,?,?)");
                ps.setString(1, bd.getMaLop());
                ps.setString(2, bd.getMaSV());
                ps.setString(3, bd.getMaMH());
                ps.setString(4, bd.getDiemTK());
                ps.setString(5, bd.getDiemGK());
                ps.setString(6, bd.getDiemCK());
                ps.setFloat(7, bd.getDiemTB());
                ps.setString(8, bd.getXepLoai());
               
                int row = ps.executeUpdate();
                if (row < 1) {
                    bd = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps);
            }
        }
        return bd;
    }

    @Override
    public Diem upDate(Diem bd) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblDiem set fldDiemTK = ?,fldDiemGK = ?,fldDiemCK = ?,fldDiemTB = ?,fldXepLoai=? where fldMaLop =? and fldMaSV =? and fldMaMH=?");

                
                ps.setString(1, bd.getDiemTK());
                ps.setString(2, bd.getDiemGK());
                ps.setString(3, bd.getDiemCK());
                ps.setFloat(4, bd.getDiemTB());
                ps.setString(5, bd.getXepLoai());
                ps.setString(6, bd.getMaLop());  
                ps.setString(7, bd.getMaSV());
                ps.setString(8, bd.getMaMH());
               
              
                int row = ps.executeUpdate();
                if (row < 1) {
                    bd = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close();
            }
        }
        return bd;
    }

    public void delDiem( String MaSV, String MaMH) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblDiem where fldMaSV =? and fldMaMH =?");
            
            ps.setString(1, MaSV);
            ps.setString(2, MaMH);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public boolean CheckThongTin(String maSV, String maMH) {
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        boolean result = true;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select * from tblDiem where fldMaSV =? and fldMaMH =?");
                
                psCheck.setString(1, maSV);
                psCheck.setString(2, maMH);
                rs = psCheck.executeQuery();
                result = rs.next();
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Diem> findByMaMH(String maMH) {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblDiem where fldMaMH=?");
                ps.setString(1, maMH);
                rs = ps.executeQuery();
                list = new ArrayList<Diem>();
                while (rs.next()) {
                    Diem bd = new Diem();
                    bd.setMaSV(rs.getString(1));
                    bd.setMaMH(rs.getString("fldMaMH"));

                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }


    public ArrayList<Diem> BangDiem(String masv) {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblDiem where fldMaSV =?");
                ps.setString(1, masv);
               
                rs = ps.executeQuery();
                list = new ArrayList<Diem>();
                while (rs.next()) {
                    Diem bd = new Diem();
                    bd.setMaLop(rs.getString(1));                   
                    bd.setMaSV(rs.getString(1));                   
                    bd.setMaMH(rs.getString(1));                   
                    bd.setDiemTK(rs.getString(2));
                    bd.setDiemGK(rs.getString(3));
                    bd.setDiemCK(rs.getString(4));
                    bd.setDiemTB(rs.getFloat(5));
                    bd.setXepLoai(rs.getString(6));
                   
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Diem> findByMaSV(String maSV) {
          ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from tblDiem where  fldMaSV = ?");
                ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<Diem>();
                while (rs.next()) {
                    Diem bd = new Diem();
                    bd.setMaLop(rs.getString(1));
                    bd.setMaSV(rs.getString(2));
                    bd.setMaMH(rs.getString(3));
                    bd.setDiemTK(rs.getString(4));
                    bd.setDiemGK(rs.getString(5));
                    bd.setDiemCK(rs.getString(6));
                    bd.setDiemTB(rs.getFloat(7));
                    bd.setXepLoai(rs.getString(8));
                    
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new DiemDAO().findByMaMH("MH001").get(0).getMaSV());
    }

   
}
