/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenNganhDAO;
import BLL.DiemDAO;
import BLL.IDiemDAO;
import Check.Check;
import BLL.ILopHocDAO;
import Entity.LopHoc;
import BLL.IMonHocDAO;
import Entity.MonHoc;
import BLL.ISinhVienDAO;
import BLL.LopHocDAO;
import BLL.SinhVienDAO;
import Entity.Diem;
import Entity.SinhVien;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class frmQuanLyDiem extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbmHS;
   
    private DefaultButtonModel dbm;
    private DefaultComboBoxModel dcbmMaSV;
    private DefaultComboBoxModel dcbmMaMH;
    private DefaultComboBoxModel dcbmMaLop;
 
    ArrayList<SinhVien> listsv = null;
    ArrayList<MonHoc> listmh = null;
    ArrayList<Diem> listbdiem = null;
    ArrayList<LopHoc> listLH = null;

    public frmQuanLyDiem() {
        try {
            initComponents();
            dtm = new DefaultTableModel();
            dcbmHS = new DefaultComboBoxModel();
           
            dcbmMaSV = new DefaultComboBoxModel();
            dcbmMaLop = new DefaultComboBoxModel();
            dcbmMaMH = new DefaultComboBoxModel();
           
            dbm = new DefaultButtonModel();

            //Load Tên Môn Học
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("BLL.MonHocDAO").newInstance();
            listmh = monHocDAO.getAll();
            for (MonHoc mh : listmh) {
                dcbmMaMH.addElement(mh.getMaMH());
            }
            menuMonHoc.setModel(dcbmMaMH);
            //Load Mã Lớp Học
            ILopHocDAO lopHocDAO = (ILopHocDAO) Class.forName("BLL.LopHocDAO").newInstance();
            listLH = lopHocDAO.getAll();
            for (LopHoc lh : listLH) {
                dcbmMaLop.addElement(lh.getMalop());
            }
            menuMaLop.setModel(dcbmMaLop);
            
            
            //Tên Bảng
            dtm.addColumn("Mã Lớp Học");
            dtm.addColumn("Mã Sinh Viên");
            dtm.addColumn("Mã Môn Học");
            dtm.addColumn("Điểm Thường Kỳ");
            dtm.addColumn("Điểm Giữa Kỳ");
            dtm.addColumn("Điểm Cuối Kỳ");
            dtm.addColumn("Điểm Trung Bình");
            dtm.addColumn("Xếp Loại");
           
            loadData();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadData() {

        try {
            IDiemDAO bangDiemDAO = (IDiemDAO) Class.forName("BLL.DiemDAO").newInstance();
            listbdiem = bangDiemDAO.getAll();
            for (Diem bd : listbdiem) {
                dtm.addRow(toObjectData(bd));

            }
            tblBangDiem.setModel(dtm);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Object[] toObjectData(Diem bd) {
        Object[] objects = {bd.getMaLop(), bd.getMaSV(), bd.getMaMH(), bd.getDiemTK(), bd.getDiemGK(), bd.getDiemCK(),bd.getDiemTB(),bd.getXepLoai()};
        return objects;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menuMonHoc = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtdiemThuongKy = new javax.swing.JTextField();
        txtdiemGiuaKy = new javax.swing.JTextField();
        txtdiemCuoiKy = new javax.swing.JTextField();
        menuMaLop = new javax.swing.JComboBox();
        menuMaSV = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jbNew = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setPreferredSize(new java.awt.Dimension(1030, 504));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ ĐIỂM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(414, 414, 414))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 240));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Môn Học");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Điểm Thường Kỳ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Điểm Giữa Kỳ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Điểm Cuối Kỳ");

        menuMonHoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        menuMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMonHocActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Mã Lớp Học");

        menuMaLop.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        menuMaLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMaLopActionPerformed(evt);
            }
        });

        menuMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMaSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuMonHoc, 0, 200, Short.MAX_VALUE)
                    .addComponent(menuMaLop, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuMaSV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdiemThuongKy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdiemGiuaKy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtdiemCuoiKy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(menuMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(menuMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtdiemThuongKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiemGiuaKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiemCuoiKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 153, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbUpdate.setForeground(new java.awt.Color(255, 0, 0));
        jbUpdate.setText("Sửa");
        jbUpdate.setEnabled(false);
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbDelete.setForeground(new java.awt.Color(255, 0, 0));
        jbDelete.setText("Xóa");
        jbDelete.setEnabled(false);
        jbDelete.setIconTextGap(2);
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        jbNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbNew.setForeground(new java.awt.Color(255, 0, 0));
        jbNew.setText("Thêm");
        jbNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewActionPerformed(evt);
            }
        });

        jbExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit.setForeground(new java.awt.Color(255, 0, 0));
        jbExit.setText("Làm Mới");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNew, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Lớp Học", "Mã Sinh Viên", "Mã Môn Học", "Điểm Thường Kỳ", "Điểm Giữa Kỳ", "Điểm Cuối Kỳ", "Điểm Trung Bình", "Xếp Loại"
            }
        ));
        tblBangDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblBangDiem.setMinimumSize(new java.awt.Dimension(120, 240));
        tblBangDiem.setPreferredSize(new java.awt.Dimension(600, 240));
        tblBangDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblBangDiemMouseReleased(evt);
            }
        });
        tblBangDiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBangDiemKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblBangDiem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        if (!checkinfo()) {
            return;
        }
        String diemTK = txtdiemThuongKy.getText();
        String diemGK = txtdiemGiuaKy.getText();
        String diemCK = txtdiemCuoiKy.getText();
        Float diemTB = ((Float.parseFloat(diemTK)*20)/100)+((Float.parseFloat(diemGK)*30)/100)+((Float.parseFloat(diemCK)*50)/100);
        String xepLoai;
        if(diemTB>=0&&diemTB<4){ xepLoai="F";}else
            if(diemTB>=4.0&&diemTB<=5.4){ xepLoai="D";}else
                if(diemTB>=5.4&&diemTB<=6.9){ xepLoai="C";}else
                    if(diemTB>=6.9&&diemTB<=8.4){ xepLoai="B";}else
                        if(diemTB>=8.4&&diemTB<=10){ xepLoai="A";}else{ xepLoai="N";}
        //Tìm thông tin sinh viên từ danh sách sinh viên
       // ArrayList<SinhVien> CheckSinhVien = new SinhVienDAO().findByMaSV(txtMaSV.getText());
        String maSV = listsv.get(menuMaSV.getSelectedIndex()).getMaSV();
        String maMH = listmh.get(menuMonHoc.getSelectedIndex()).getMaMH();
        String maLop= listLH.get(menuMaLop.getSelectedIndex()).getMalop();

       
        
        
        Diem bd = new Diem(maLop, maSV, maMH, diemTK, diemGK, diemCK,diemTB, xepLoai);
        //Kiểm tra thông tin trùng
        boolean result = new DiemDAO().CheckThongTin(maSV, maMH);
        if (result) {
            JOptionPane.showMessageDialog(this, "Dữ liệu bị trùng ! Vui lòng kiểm tra lại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else
           
        
        
        
       
        {
            Diem insert = new DiemDAO().addNew(bd);
             JOptionPane.showMessageDialog(this, "Thêm thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            if (insert != null) {
                showAll();
            }


        }


    }//GEN-LAST:event_jbNewActionPerformed
    public void showAll() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        ArrayList<Diem> bangDiems = new DiemDAO().getAll();
        for (Diem bd : bangDiems) {
            Vector v = new Vector();
            v.add(bd.getMaLop());
            v.add(bd.getMaSV());
            v.add(bd.getMaMH());
            v.add(bd.getDiemTK());
            v.add(bd.getDiemGK());
            v.add(bd.getDiemCK());
            v.add(bd.getDiemTB());
            v.add(bd.getXepLoai());
            
            dtm.addRow(v);
        }
        resetForm();
    }

    public void resetForm() {
        
        txtdiemThuongKy.setText("");
        txtdiemGiuaKy.setText("");
        txtdiemCuoiKy.setText("");
        jbNew.setEnabled(true);
        jbUpdate.setEnabled(false);
        jbDelete.setEnabled(false);
        
        menuMonHoc.setEnabled(true);
        menuMaLop.setEnabled(true);
        menuMaSV.setEnabled(true);
        

    }
    private void tblBangDiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBangDiemKeyReleased
    }//GEN-LAST:event_tblBangDiemKeyReleased

    private void tblBangDiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangDiemMouseReleased
        menuMaLop.setSelectedItem(tblBangDiem.getValueAt(tblBangDiem.getSelectedRow(), 0).toString());
        menuMaSV.setSelectedItem(tblBangDiem.getValueAt(tblBangDiem.getSelectedRow(), 1).toString());
        menuMonHoc.setSelectedItem(tblBangDiem.getValueAt(tblBangDiem.getSelectedRow(), 2).toString());
        txtdiemThuongKy.setText(tblBangDiem.getValueAt(tblBangDiem.getSelectedRow(), 3).toString());
        txtdiemGiuaKy.setText(tblBangDiem.getValueAt(tblBangDiem.getSelectedRow(), 4).toString());
        txtdiemCuoiKy.setText(tblBangDiem.getValueAt(tblBangDiem.getSelectedRow(), 5).toString());
        
        jbNew.setEnabled(false);
        jbUpdate.setEnabled(true);
        jbDelete.setEnabled(true);
        
        menuMonHoc.setEnabled(false);
        menuMaSV.setEnabled(false);
        menuMaLop.setEnabled(false);
       
        
    }//GEN-LAST:event_tblBangDiemMouseReleased

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
             String maSV = listsv.get(menuMaSV.getSelectedIndex()).getMaSV();
        String maMH = listmh.get(menuMonHoc.getSelectedIndex()).getMaMH();
        String maLop= listLH.get(menuMaLop.getSelectedIndex()).getMalop();
            
            try {
                new DiemDAO().delDiem(maSV, maMH);
                 JOptionPane.showMessageDialog(this, "Xóa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            resetForm();
            loadData();
            jbNew.setEnabled(true);
            jbUpdate.setEnabled(false);
            jbDelete.setEnabled(false);
           
            txtdiemThuongKy.setText("");
            txtdiemGiuaKy.setText("");
            txtdiemCuoiKy.setText("");
            menuMonHoc.setEnabled(true);
            
            
        }
    }//GEN-LAST:event_jbDeleteActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        resetForm();
    }//GEN-LAST:event_jbExitActionPerformed
    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkSpace(txtdiemThuongKy.getText())||c.checkMark(txtdiemThuongKy.getText())==false) {
            JOptionPane.showMessageDialog(this, "Nhập điểm sai (ví dụ : 9 hoặc 9.5)", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtdiemThuongKy.setText("");
            txtdiemThuongKy.requestFocus();
            return false;
        }
        if (!c.checkSpace(txtdiemGiuaKy.getText())||c.checkMark(txtdiemGiuaKy.getText())==false) {
            JOptionPane.showMessageDialog(this, "Nhập điểm sai (ví dụ : 9 hoặc 9.5)", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtdiemGiuaKy.setText("");
            txtdiemGiuaKy.requestFocus();
            return false;
        }
        if (!c.checkSpace(txtdiemCuoiKy.getText())||c.checkMark(txtdiemCuoiKy.getText())==false) {
            JOptionPane.showMessageDialog(this, "Nhập điểm sai (ví dụ : 9 hoặc 9.5)", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtdiemCuoiKy.setText("");
            txtdiemCuoiKy.requestFocus();
            return false;
        }
        return true;
    }
    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        if (!checkinfo()) {
            return;
        }
        String diemTK = txtdiemThuongKy.getText();
        String diemGK = txtdiemGiuaKy.getText();
        String diemCK = txtdiemCuoiKy.getText();
        Float diemTB = (Float.parseFloat(diemTK)*20+Float.parseFloat(diemGK)*30+Float.parseFloat(diemCK)*50)/100;
        String xepLoai;
        if(diemTB>=0&&diemTB<4){ xepLoai="F";}else
            if(diemTB>=4&&diemTB<=5.4){ xepLoai="D";}else
                if(diemTB>=5.4&&diemTB<=6.9){ xepLoai="C";}else
                    if(diemTB>=6.9&&diemTB<=8.4){ xepLoai="B";}else
                        if(diemTB>=8.4&&diemTB<=10){ xepLoai="A";}else{ xepLoai="N";}
        //Tìm thông tin sinh viên từ danh sách sinh viên
      //  ArrayList<SinhVien> CheckSinhVien = new SinhVienDAO().findByMaSV(txtMaSV.getText());
        String maSV = listsv.get(menuMaSV.getSelectedIndex()).getMaSV();
        String maMH = listmh.get(menuMonHoc.getSelectedIndex()).getMaMH();
        String maLop= listLH.get(menuMaLop.getSelectedIndex()).getMalop();

       

        Diem bd = new Diem(maLop, maSV, maMH, diemTK, diemGK, diemCK, diemTB, xepLoai);
       
            Diem update = new DiemDAO().upDate(bd);
             JOptionPane.showMessageDialog(this, "Sửa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            if (update != null) {
                showAll();
            }

       
        

    }//GEN-LAST:event_jbUpdateActionPerformed

    private void menuMaLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMaLopActionPerformed
       /*Load Dữ liệu mã sinh viên của lớn học đã chọn*/
        menuMaSV.setSelectedItem("");
        try {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("BLL.SinhVienDAO").newInstance();
            listsv = sinhVienDAO.findByMaLopHoc(listLH.get(menuMaLop.getSelectedIndex()).getMalop());
            dcbmMaSV.removeAllElements();
            for (SinhVien sv : listsv) {
                dcbmMaSV.addElement(sv.getMaSV());


            }
       
            menuMaSV.setModel(dcbmMaSV);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frmQuanLyDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  /*Một sinh viên có thể học môn học của chuyên ngành khác,khoa khác => không cần load dữ liệu 1 chuyên ngành riêng biệt */
    }//GEN-LAST:event_menuMaLopActionPerformed

    private void menuMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMonHocActionPerformed
       
    }//GEN-LAST:event_menuMonHocActionPerformed

    private void menuMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMaSVActionPerformed
        
    }//GEN-LAST:event_menuMaSVActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbNew;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JComboBox menuMaLop;
    private javax.swing.JComboBox<String> menuMaSV;
    private javax.swing.JComboBox menuMonHoc;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTextField txtdiemCuoiKy;
    private javax.swing.JTextField txtdiemGiuaKy;
    private javax.swing.JTextField txtdiemThuongKy;
    // End of variables declaration//GEN-END:variables
}
