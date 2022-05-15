
package Pestañas;

import Programa.Connect;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tap4_1 extends javax.swing.JPanel {
    static String month;

    public Tap4_1() {
        initComponents();
        for (int i = 1; i < 31 ; i++) {
        T4Dia.addItem(String.valueOf(i));}}
       
    public static boolean ModificarCita(int idCita, String Nombre, String Cedula, String Dia, String mes, String Hora) throws SQLException {
        try { 
             Connect.con = (Connection) DriverManager.getConnection(Connect.url, Connect.user, Connect.pass);
            PreparedStatement pst = Connect.con.prepareStatement("UPDATE citas SET idCita=?, Nombre=?, Fecha=?, Hora=? WHERE Cedula=?");
            pst.setInt(1, idCita);
            pst.setString(2, Nombre);
            pst.setDate(3, Date.valueOf("2020-"+mes+"-"+Dia));
            pst.setString(4, Hora);
            pst.setString(5, Cedula);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "cita pospuesta correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;}
        return true;}

    public static void AccionBtAceptar() {
        String hora = T4Hora.getItemAt(T4Hora.getSelectedIndex()) + ":" + T4Minuto.getItemAt(T4Minuto.getSelectedIndex()) + " " + T4ampm.getItemAt(T4ampm.getSelectedIndex());
        if (T4ampm.getItemAt(T4ampm.getSelectedIndex()).equals("AM")) {
            if (Integer.parseInt(T4Hora.getItemAt(T4Hora.getSelectedIndex())) > 7) {
                try {
            ModificarCita(Tap3.id, Tap3.T3Nombre, Tap3.T3Cedula, T4Dia.getItemAt(T4Dia.getSelectedIndex()), month, hora);
        } catch (SQLException ex) {
            Logger.getLogger(Tap4.class.getName()).log(Level.SEVERE, null, ex);}
            } else {JOptionPane.showMessageDialog(null, "Es demasiado temprano");}
        } else {
            if (Integer.parseInt(T4Hora.getItemAt(T4Hora.getSelectedIndex())) < 10) {
               try {
            ModificarCita(Tap3.id, Tap3.T3Nombre, Tap3.T3Cedula, T4Dia.getItemAt(T4Dia.getSelectedIndex()), month, hora);
        } catch (SQLException ex) {
            Logger.getLogger(Tap4.class.getName()).log(Level.SEVERE, null, ex);}
            } else {JOptionPane.showMessageDialog(null, "Es demasiado tarde"); }
        }
        
        }
      
    public static void AccionBtActualizar() {
        try {Connect.con = (Connection) DriverManager.getConnection(Connect.url, Connect.user, Connect.pass);
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); }}
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        T4Hora = new javax.swing.JComboBox<>();
        BtAg = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        T4Minuto = new javax.swing.JComboBox<>();
        T4ampm = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        T4Dia = new javax.swing.JComboBox<>();
        T4mes = new javax.swing.JComboBox<>();
        BtActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Posponer Cita");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        T4Hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hora:", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        BtAg.setText("Aceptar");
        BtAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAgActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");

        T4Minuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minuto:", "00", "30" }));
        T4Minuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T4MinutoActionPerformed(evt);
            }
        });

        T4ampm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "AM", "PM" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(T4Hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(T4Minuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(T4ampm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtAg, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T4Hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(T4Minuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T4ampm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtAg)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 330, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 20));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 130, 20));

        T4Dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día" }));
        T4Dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T4DiaActionPerformed(evt);
            }
        });
        jPanel3.add(T4Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 50, -1));

        T4mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes:", "Noviembre", "Diciembre" }));
        T4mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                T4mesItemStateChanged(evt);
            }
        });
        jPanel3.add(T4mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 150, -1));

        BtActualizar.setText("Actualizar");
        BtActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(BtActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 330, 110));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Horarios ocupados");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jTbH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Fecha", "Hora"
            }
        ));
        jScrollPane3.setViewportView(jTbH);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 220));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 250, 270));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 620, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sin título.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void T4MinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T4MinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T4MinutoActionPerformed

    private void T4DiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T4DiaActionPerformed

    }//GEN-LAST:event_T4DiaActionPerformed

    private void BtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtActualizarActionPerformed
          DefaultTableModel modelo = (DefaultTableModel)jTbH.getModel();
        try{
                Connect.con = Connect.con = (Connection) DriverManager.getConnection(Connect.url, Connect.user, Connect.pass);
                Statement pst = Connect.con.createStatement();
                ResultSet rs = pst.executeQuery("SELECT * FROM citas WHERE Fecha='2020-"+month+"-"+T4Dia.getItemAt(T4Dia.getSelectedIndex())+"'");
                rs.first(); 
                        do{
                            String[] tabla = {rs.getString(4),rs.getString(5)};
                            modelo.addRow(tabla);
                         }while(rs.next());
                }
                catch (SQLException ex) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_BtActualizarActionPerformed

    private void T4mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_T4mesItemStateChanged
    if(T4mes.getItemAt(T4mes.getSelectedIndex()).equals("Noviembre")){month="11";}
        if(T4mes.getItemAt(T4mes.getSelectedIndex()).equals("Diciembre")){month="12";}
    }//GEN-LAST:event_T4mesItemStateChanged

    private void BtAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAgActionPerformed
          Calendar Calendario = new GregorianCalendar();
        if(month.equals("11")){
        if(Integer.parseInt(T4Dia.getItemAt(T4Dia.getSelectedIndex()))>(Calendario.get(Calendar.DATE))){
            AccionBtAceptar();
        }else{
            JOptionPane.showMessageDialog(null, "No se puede Agendar cita para esa fecha");
        }
    }else{
            AccionBtAceptar();
        }          

    }//GEN-LAST:event_BtAgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtActualizar;
    private javax.swing.JButton BtAg;
    private static javax.swing.JComboBox<String> T4Dia;
    private static javax.swing.JComboBox<String> T4Hora;
    private static javax.swing.JComboBox<String> T4Minuto;
    private static javax.swing.JComboBox<String> T4ampm;
    private static javax.swing.JComboBox<String> T4mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTbH;
    // End of variables declaration//GEN-END:variables
}
