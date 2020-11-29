/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.HocPhanDAO;
import GUI.MainGV;
import BLL.IHocPhanDAO;
import BLL.IKhoaDAO;
import BLL.ILopHocPhanDAO;
import Check.Check;
import BLL.IMonHocDAO;
import BLL.LopHocPhanDAO;
import BLL.MonHocDAO;
import BLL.PhieuDangKyDayDAO;
import BLL.SinhVienDAO;
import ConnectDatabase.DBConnect;
import Entity.HocPhan;
import Entity.Khoa;
import Entity.LopHocPhan;
import Entity.MonHoc;
import Entity.PhieuDangKyDay;
import Entity.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anonymous
 */
public class frmDangKyDay extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private ArrayList<LopHocPhan> listLHP=null;
    private ArrayList<PhieuDangKyDay> ListPhieuDKD=null;
    private DefaultComboBoxModel dcbmNamHoc;

    public frmDangKyDay() {
        initComponents();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã Lớp Học Phần");
        dtm.addColumn("Mã Học Phần");
        dtm.addColumn("Tên Môn Học");
        dtm.addColumn("Tiết Học");
        dtm.addColumn("Phòng Học");
        dtm.addColumn("Thứ");          
        dtm.addColumn("Học Kỳ");     
        dtm.addColumn("Năm Học");
        
        dcbmNamHoc = new DefaultComboBoxModel();
        dcbmNamHoc.addElement("2016");
        dcbmNamHoc.addElement("2017");
        dcbmNamHoc.addElement("2018");
        dcbmNamHoc.addElement("2019");
        dcbmNamHoc.addElement("2020");
        dcbmNamHoc.addElement("2021");
        dcbmNamHoc.addElement("2022");
        dcbmNamHoc.addElement("2023");
        dcbmNamHoc.addElement("2024");
        
       
        
        
        loaddata();
       
    }
    

    private void loaddata() {
        try {
            
            
            ListPhieuDKD =new PhieuDangKyDayDAO().getAll();
            ILopHocPhanDAO lopHocPhanDAO = (ILopHocPhanDAO) Class.forName("BLL.LopHocPhanDAO").newInstance();
            listLHP = new LopHocPhanDAO().getAll();
            for (LopHocPhan lhp : listLHP) {
                dtm.addRow(toObjectsData(lhp));
            }
            jtbDSLopHocPhan.setModel(dtm);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmDangKyDay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmDangKyDay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmDangKyDay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

 
    public static Object[] toObjectsData(LopHocPhan lhp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MonHoc mh =new MonHoc();
        IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("BLL.MonHocDAO").newInstance();
        ArrayList<MonHoc> listMH = new MonHocDAO().findIDMaMH(lhp.getMaMH());
        Object[] objectsData = {lhp.getMaLHP(), lhp.getMaHP(),listMH.get(0).getTenMH(), lhp.getTietHoc(),lhp.getPhongHoc(),lhp.getThu(),lhp.getHocKy(),lhp.getNamHoc()};
        return objectsData;
    }
   

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbDSLopHocPhan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaLHP = new javax.swing.JTextField();
        txtMaHP = new javax.swing.JTextField();
        txtTenMH = new javax.swing.JTextField();
        txtPhongHoc = new javax.swing.JTextField();
        txtThu = new javax.swing.JTextField();
        txtTietHoc = new javax.swing.JTextField();
        txtHocKy = new javax.swing.JTextField();
        txtNamHoc = new javax.swing.JTextField();
        btndangky = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnxemlich = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" ĐĂNG KÝ DẠY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(533, 533, 533)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(575, 575, 575))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jtbDSLopHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Lớp Học Phần", "Mã Học Phần", "Tên Môn Học", "Tiết Học", "Phòng Học", "Thứ", "Học Kỳ", "Năm Học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDSLopHocPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDSLopHocPhanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbDSLopHocPhan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Mã Lớp Học Phần");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Mã Học Phần");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Tên Môn Học");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Tiết Học");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Phòng Học");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Thứ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Học Kỳ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Năm Học");

        btndangky.setText("Đăng Ký");
        btndangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangkyActionPerformed(evt);
            }
        });

        btnHuy.setText(" Hủy Đăng Ký");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnxemlich.setText("Xem Lịch");
        btnxemlich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemlichActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaLHP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btndangky, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnxemlich, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtThu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTietHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamHoc)
                            .addComponent(txtHocKy, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtMaLHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)
                                .addComponent(txtMaHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTietHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndangky)
                    .addComponent(btnHuy)
                    .addComponent(btnxemlich))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbDSLopHocPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDSLopHocPhanMouseClicked
      txtMaLHP.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 0).toString());
      txtMaHP.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 1).toString());
      txtTenMH.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 2).toString());
      txtTietHoc.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 3).toString());
      txtPhongHoc.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 4).toString());
      txtThu.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 5).toString());
      txtHocKy.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 6).toString());
      txtNamHoc.setText(jtbDSLopHocPhan.getValueAt(jtbDSLopHocPhan.getSelectedRow(), 7).toString());
       
       txtMaLHP.setEnabled(false);
       txtMaHP.setEnabled(false);
       txtTenMH.setEnabled(false);
       txtTietHoc.setEnabled(false);
       txtPhongHoc.setEnabled(false);
       txtThu.setEnabled(false);
       txtHocKy.setEnabled(false);
       txtNamHoc.setEnabled(false);
     
    }//GEN-LAST:event_jtbDSLopHocPhanMouseClicked
    private void dangky(){
       String MaLHP=txtMaLHP.getText();
       String MaGV=Login.nameLogin;
       String HocKy=txtHocKy.getText();
       String NamHoc=txtNamHoc.getText();     
       Date today = new Date();
       Locale local = new Locale("vi", "VI");
       DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
       String NgayDangKy=d.format(today);
       
       PhieuDangKyDay pdkd = new PhieuDangKyDay(MaLHP, MaGV, HocKy, NamHoc, NgayDangKy);
     
        if (!check()) {
            return;
        }
     
        ArrayList<PhieuDangKyDay> listCheck = new PhieuDangKyDayDAO().checkMaLHP(MaLHP);
       
        if (listCheck.size() > 0) {
            JOptionPane.showMessageDialog(this, "Lớp học phần này đã có giáo viên đăng ký !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
        }
        
        else
            {
           PhieuDangKyDay insert=new PhieuDangKyDayDAO().dangkyday(pdkd);
           
           JOptionPane.showMessageDialog(this, "Đăng ký thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
           resetForm();
    }
    }
    private void huydangky(){
       
       String MaLHP=txtMaLHP.getText();
       ArrayList<PhieuDangKyDay> listCheck = new PhieuDangKyDayDAO().checkMaLHP(MaLHP);
       if (listCheck.size() == 0) {
            JOptionPane.showMessageDialog(this, "Lịch dạy không tồn tại lớp học phần này !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            resetForm();
        }
       else{
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn hủy đăng ký lớp học phần này ?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                String maLHP = txtMaLHP.getText();
                new PhieuDangKyDayDAO().huydangkyday(maLHP);
                JOptionPane.showMessageDialog(this, "Hủy đăng ký thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
            }catch (SQLException ex) {}        
    }
    }
    }
    
    private void btndangkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangkyActionPerformed
       dangky();
    }//GEN-LAST:event_btndangkyActionPerformed

    private void btnxemlichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemlichActionPerformed
  try {
            frmLichDay ld=new frmLichDay();
           ld.show();
        } catch (Exception ex) {
            Logger.getLogger(frmDangKyDay.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lịch dạy trống !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
        }
           
    }//GEN-LAST:event_btnxemlichActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        huydangky();
    }//GEN-LAST:event_btnHuyActionPerformed

  
    private boolean check() {
            ListPhieuDKD =new PhieuDangKyDayDAO().getLHP_MaGV(Login.nameLogin);/*Load danh sách lớp học phần giáo viên đã đăng ký theo mã GV*/
            ArrayList<LopHocPhan> LHP = new ArrayList<LopHocPhan>();
            //Tìm danh sách lớp học phần đã đăng ký
            for(int i=0;i<ListPhieuDKD.size();i++){
                ArrayList<LopHocPhan> listLHP_DaDangKy = new LopHocPhanDAO().findByMaLHP(ListPhieuDKD.get(i).getMaLHP());
          
            LHP.add(listLHP_DaDangKy.get(0));
          
            }
        
       for(int i=0;i<LHP.size();i++){
           if(txtThu.getText().equals(LHP.get(i).getThu())&&txtTietHoc.getText().equals(LHP.get(i).getTietHoc())&&txtHocKy.getText().equals(LHP.get(i).getHocKy())&&txtNamHoc.getText().equals(LHP.get(i).getNamHoc())){
               JOptionPane.showMessageDialog(this, "Trùng lịch vào  "+txtThu.getText()+" tiết "+txtTietHoc.getText()+" học kỳ "+txtHocKy.getText()+" năm học "+txtNamHoc.getText() +" !" , "Lỗi", JOptionPane.ERROR_MESSAGE);
               return false;
           }
           return true;
       }
       
       if(txtMaLHP.getText().equals("")&&txtNamHoc.getText().equals("")&&txtHocKy.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Chưa chọn lớp học phần", "Lỗi", JOptionPane.ERROR_MESSAGE);
               return false;
           }
      else{
          return true;
      }
//    
      
      
   
    }
    private void resetForm(){
       txtMaLHP.setEnabled(true);
       txtMaHP.setEnabled(true);
       txtTenMH.setEnabled(true);
       txtTietHoc.setEnabled(true);
       txtPhongHoc.setEnabled(true);
       txtThu.setEnabled(true);
       txtHocKy.setEnabled(true);
       txtNamHoc.setEnabled(true);
       txtMaLHP.setText("");
       txtMaHP.setText("");
       txtMaLHP.setText("");
       txtTenMH.setText("");
       txtTietHoc.setText("");
       txtThu.setText("");
       txtPhongHoc.setText("");
       txtHocKy.setText("");
       txtNamHoc.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btndangky;
    private javax.swing.JButton btnxemlich;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbDSLopHocPhan;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaHP;
    private javax.swing.JTextField txtMaLHP;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtPhongHoc;
    private javax.swing.JTextField txtTenMH;
    private javax.swing.JTextField txtThu;
    private javax.swing.JTextField txtTietHoc;
    // End of variables declaration//GEN-END:variables
}
