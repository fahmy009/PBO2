/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.anggotahimasifcontrol;
import control.pendaftarcontrol;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Muhammad Fahmy
 */
public class pendaftarview extends javax.swing.JFrame {

    /**
     * Creates new form datamahasiswaview
     */
    pendaftarcontrol dmc = new pendaftarcontrol(this);

    public pendaftarview() {
        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        tNIM = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        tTanggalLahir = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        cbDivisi = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAlasan = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlamat = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        lalasan = new javax.swing.JLabel();

        jMenuItem1.setText("Hapus");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Refresh");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tNIM.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tNIM.setForeground(new java.awt.Color(153, 153, 153));
        tNIM.setBorder(null);
        tNIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNIMKeyReleased(evt);
            }
        });
        getContentPane().add(tNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 250, 30));

        tNama.setEditable(false);
        tNama.setBackground(new java.awt.Color(255, 255, 255));
        tNama.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tNama.setForeground(new java.awt.Color(153, 153, 153));
        tNama.setBorder(null);
        tNama.setEnabled(false);
        getContentPane().add(tNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 340, 250, 30));

        tTanggalLahir.setEditable(false);
        tTanggalLahir.setBackground(new java.awt.Color(255, 255, 255));
        tTanggalLahir.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tTanggalLahir.setForeground(new java.awt.Color(153, 153, 153));
        tTanggalLahir.setBorder(null);
        tTanggalLahir.setEnabled(false);
        getContentPane().add(tTanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 420, 160, 30));

        btnSimpan.setBorder(null);
        btnSimpan.setBorderPainted(false);
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 120, 50));

        cbDivisi.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        cbDivisi.setForeground(new java.awt.Color(153, 153, 153));
        cbDivisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Konsumsi", "Humas", "Pubdekdok", "Perlengkapan" }));
        cbDivisi.setBorder(null);
        getContentPane().add(cbDivisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, 210, 30));

        btnBatal.setBorder(null);
        btnBatal.setBorderPainted(false);
        btnBatal.setContentAreaFilled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 110, 50));

        jButton1.setBackground(new java.awt.Color(237, 237, 237));
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 180, 120, 50));

        jScrollPane2.setBorder(null);

        tAlasan.setColumns(20);
        tAlasan.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tAlasan.setForeground(new java.awt.Color(153, 153, 153));
        tAlasan.setRows(5);
        jScrollPane2.setViewportView(tAlasan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 230, 100));

        jScrollPane1.setBorder(null);

        tAlamat.setColumns(20);
        tAlamat.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tAlamat.setForeground(new java.awt.Color(153, 153, 153));
        tAlamat.setRows(5);
        tAlamat.setBorder(null);
        jScrollPane1.setViewportView(tAlamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 190, 100));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 40, 30));

        lalasan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/daftar.png"))); // NOI18N
        getContentPane().add(lalasan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        dmc.insert();
        dmc.back();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:;
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tNIMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNIMKeyReleased
        // TODO add your handling code here:
        dmc.cari();
    }//GEN-LAST:event_tNIMKeyReleased

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        dmc.back();
    }//GEN-LAST:event_btnBatalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pendaftarview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pendaftarview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pendaftarview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pendaftarview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pendaftarview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbDivisi;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lalasan;
    private javax.swing.JTextArea tAlamat;
    private javax.swing.JTextArea tAlasan;
    private javax.swing.JTextField tNIM;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tTanggalLahir;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getCbDivisi() {
        return cbDivisi;
    }

    public void setCbDivisi(JComboBox<String> cbDivisi) {
        this.cbDivisi = cbDivisi;
    }

    public JTextArea gettAlamat() {
        return tAlamat;
    }

    public void settAlamat(JTextArea tAlamat) {
        this.tAlamat = tAlamat;
    }

    public JTextArea gettAlasan() {
        return tAlasan;
    }

    public void settAlasan(JTextArea tAlasan) {
        this.tAlasan = tAlasan;
    }

    public JTextField gettNIM() {
        return tNIM;
    }

    public void settNIM(JTextField tNIM) {
        this.tNIM = tNIM;
    }

    public JTextField gettNama() {
        return tNama;
    }

    public void settNama(JTextField tNama) {
        this.tNama = tNama;
    }

    public JTextField gettTanggalLahir() {
        return tTanggalLahir;
    }

    public void settTanggalLahir(JTextField tTanggalLahir) {
        this.tTanggalLahir = tTanggalLahir;
    }

    public void keyNIM(KeyListener ls) {
        this.tNIM.addKeyListener(ls);
    }

    public void setBtnSimpan(boolean btnSimpan) {
        this.btnSimpan.setEnabled(btnSimpan);
    }

    public void setNIM(boolean btnSimpan) {
        this.tNIM.setEnabled(btnSimpan);
    }
}
