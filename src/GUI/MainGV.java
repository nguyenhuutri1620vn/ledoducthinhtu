/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class MainGV extends javax.swing.JFrame {

    public static String nameLogin;
    public Date today = new Date();
    Locale local = new Locale("vi", "VI");
    DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    public String date = d.format(today);

    /**
     * Creates new form Main
     */
    public MainGV() {
        initComponents();
        setUser();
        Timer dongho = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar lich = Calendar.getInstance();
                int gio = lich.get(Calendar.HOUR);
                int phut = lich.get(Calendar.MINUTE);
                int giay = lich.get(Calendar.SECOND);
            }
        });
        dongho.start();
    }

    private void setUser() {
        nameLogin = Login.nameLogin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jtpContent = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmHeThong = new javax.swing.JMenu();
        jmidoimatkhau = new javax.swing.JMenuItem();
        jmiLogOff = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();
        xemlichday = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jmTimKiem = new javax.swing.JMenu();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" GIẢNG VIÊN");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtpContent.setMinimumSize(new java.awt.Dimension(1106, 638));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(102, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gv.jpg"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jtpContent.addTab("Trang Chủ", jPanel6);

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));

        jmHeThong.setBackground(new java.awt.Color(186, 216, 219));
        jmHeThong.setBorder(null);
        jmHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/taikhoan.png"))); // NOI18N
        jmHeThong.setText("Tài Khoản");
        jmHeThong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jmHeThong.setPreferredSize(new java.awt.Dimension(145, 32));

        jmidoimatkhau.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmidoimatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doimatkhau.png"))); // NOI18N
        jmidoimatkhau.setText("Đổi Mật Khẩu");
        jmidoimatkhau.setPreferredSize(new java.awt.Dimension(213, 30));
        jmidoimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmidoimatkhauActionPerformed(evt);
            }
        });
        jmHeThong.add(jmidoimatkhau);

        jmiLogOff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiLogOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangxuat.png"))); // NOI18N
        jmiLogOff.setText("Đăng Xuất");
        jmiLogOff.setPreferredSize(new java.awt.Dimension(213, 30));
        jmiLogOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogOffActionPerformed(evt);
            }
        });
        jmHeThong.add(jmiLogOff);

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thoat.png"))); // NOI18N
        jmiExit.setText("Thoát");
        jmiExit.setPreferredSize(new java.awt.Dimension(213, 30));
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmHeThong.add(jmiExit);

        jMenuBar2.add(jmHeThong);

        xemlichday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangkyday.png"))); // NOI18N
        xemlichday.setText("Đăng Ký Dạy");
        xemlichday.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        xemlichday.setPreferredSize(new java.awt.Dimension(145, 32));
        xemlichday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xemlichdayMouseClicked(evt);
            }
        });
        jMenuBar2.add(xemlichday);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemlichday.png"))); // NOI18N
        jMenu1.setText("Xem Lịch Dạy");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(145, 32));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        jmTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/seach.png"))); // NOI18N
        jmTimKiem.setText("Tìm Kiếm            ");
        jmTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jmTimKiem.setPreferredSize(new java.awt.Dimension(145, 32));
        jmTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmTimKiemMouseClicked(evt);
            }
        });
        jmTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTimKiemActionPerformed(evt);
            }
        });
        jMenuBar2.add(jmTimKiem);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jtpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpContent.getAccessibleContext().setAccessibleName("Trang Chủ");

        setSize(new java.awt.Dimension(1122, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jmiLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogOffActionPerformed
        dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jmiLogOffActionPerformed

    private void jmTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTimKiemActionPerformed
        TimKiem timkiem = new TimKiem();
        jtpContent.removeAll();
        jtpContent.add("Tìm Kiếm", timkiem);
    }//GEN-LAST:event_jmTimKiemActionPerformed

    private void jmTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmTimKiemMouseClicked
        TimKiem timkiem = new TimKiem();
        jtpContent.removeAll();
        jtpContent.add("Tìm Kiếm", timkiem);
    }//GEN-LAST:event_jmTimKiemMouseClicked

    private void jmidoimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmidoimatkhauActionPerformed
        DoiMatKhau ld=new DoiMatKhau();
           ld.show();
    }//GEN-LAST:event_jmidoimatkhauActionPerformed

    private void xemlichdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xemlichdayMouseClicked
       
       frmDangKyDay dkd =new frmDangKyDay();
       jtpContent.removeAll();
       jtpContent.add("Đăng Ký Dạy",dkd);
       
       
    }//GEN-LAST:event_xemlichdayMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        try {
            frmLichDay ld=new frmLichDay();
           ld.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lịch dạy trống !", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
        }
 
    }//GEN-LAST:event_jMenu1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGV().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JMenu jmHeThong;
    private javax.swing.JMenu jmTimKiem;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiLogOff;
    private javax.swing.JMenuItem jmidoimatkhau;
    private javax.swing.JTabbedPane jtpContent;
    private javax.swing.JMenu xemlichday;
    // End of variables declaration//GEN-END:variables
}
