/*
 * Syncany, www.syncany.org
 * Copyright (C) 2011 Philipp C. Heckel <philipp.heckel@gmail.com> 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.syncany.connection.plugins.sftp;

import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ResourceBundle;

import org.syncany.config.Config;
import org.syncany.connection.plugins.ConfigPanel;
import org.syncany.util.FileUtil;

/**
 *
 * @author Philipp C. Heckel <philipp.heckel@gmail.com>
 * @author Thomas Tschager <dontpanic@tschager.net>
 */
public class SftpConfigPanel extends ConfigPanel {

	private ResourceBundle resourceBundle;
	
    /** Creates new form SftpConnectionPanel */ 
    public SftpConfigPanel(SftpConnection connection) {
        super(connection);
        resourceBundle = Config.getInstance().getResourceBundle();
        initComponents();
    }

    @Override
    public void load() {
        txtHost.setText(getConnection().getHost());
        spnPort.setValue(new Integer( (getConnection().getPort() == 0) ? 22 : getConnection().getPort() ));
        txtUsername.setText(getConnection().getUsername());
        txtPassword.setText(getConnection().getPassword());
        txtFolder.setText(getConnection().getPath());
        keyAuth.setEnabled(getConnection().isKeyAuth());
        txtPrivateKeyPath.setText(getConnection().getKeyPath());
        txtPassphrase.setText(getConnection().getPassphrase());
        txtPrivateKeyPath.setEnabled(false);
        txtPassphrase.setEnabled(false);
        btnBrowse.setEnabled(false);
    }

    @Override
    public void save() {
        getConnection().setHost(txtHost.getText());
        getConnection().setPort((Integer) spnPort.getValue());
        getConnection().setUsername(txtUsername.getText());
        getConnection().setPassword(new String(txtPassword.getPassword()));
        getConnection().setPath(txtFolder.getText());
        getConnection().setKeyAuth(keyAuth.isSelected());
        getConnection().setKeyPath(txtPrivateKeyPath.getText());
        getConnection().setPassphrase(txtPassphrase.getText());
    }

    @Override
    public SftpConnection getConnection() {
        return (SftpConnection) super.getConnection();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnPort = new javax.swing.JSpinner();
        txtPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtFolder = new javax.swing.JTextField();
        keyAuth = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        txtPrivateKeyPath = new javax.swing.JTextField();
        txtPassphrase = new javax.swing.JPasswordField();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(resourceBundle.getString("sftp_server_name"));
        jLabel1.setName("jLabel1"); // NOI18N

        txtHost.setName("txtHost"); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText(resourceBundle.getString("sftp_username"));
        jLabel2.setName("jLabel2"); // NOI18N

        txtUsername.setName("txtUsername"); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText(resourceBundle.getString("sftp_password"));
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceBundle.getString("sftp_port"));
        jLabel4.setName("jLabel4"); // NOI18N

        spnPort.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(22), Integer.valueOf(1), null, Integer.valueOf(1)));
        spnPort.setName("spnPort"); // NOI18N

        txtPassword.setName("txtPassword"); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText(resourceBundle.getString("sftp_path"));
        jLabel7.setName("jLabel7"); // NOI18N

        txtFolder.setName("txtFolder"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(SftpConfigPanel.class, this);
        keyAuth.setAction(actionMap.get("keyAuthCheck")); // NOI18N
        keyAuth.setText(resourceBundle.getString("sftp_key_auth"));
        keyAuth.setName("keyAuth"); // NOI18N
        keyAuth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                keyAuthItemStateChanged(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText(resourceBundle.getString("sftp_private_key_path"));
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Passphrase");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Public Key Authentification");
        jLabel8.setName("jLabel8"); // NOI18N

        btnBrowse.setText("Browse ...");
        btnBrowse.setEnabled(false);
        btnBrowse.setName("btnBrowse"); // NOI18N
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        txtPrivateKeyPath.setEnabled(false);
        txtPrivateKeyPath.setName("txtPrivateKeyPath"); // NOI18N

        txtPassphrase.setEnabled(false);
        txtPassphrase.setName("txtPassphrase"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(spnPort, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(txtPassphrase, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtPrivateKeyPath, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(keyAuth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spnPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(keyAuth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBrowse)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrivateKeyPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassphrase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void keyAuthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_keyAuthItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            txtPassword.setEnabled(false);
            txtPrivateKeyPath.setEnabled(true);
            txtPassphrase.setEnabled(true);
            btnBrowse.setEnabled(true);
        } else if (evt.getStateChange()  == ItemEvent.DESELECTED) {
            txtPassword.setEnabled(true);
            txtPrivateKeyPath.setEnabled(false);
            txtPassphrase.setEnabled(false);
            btnBrowse.setEnabled(false);
        }
    }//GEN-LAST:event_keyAuthItemStateChanged

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        File selectedFolder = FileUtil.showBrowseFileDialog();

        if (selectedFolder != null) {
            txtPrivateKeyPath.setText(selectedFolder.getAbsolutePath());
        }
}//GEN-LAST:event_btnBrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JCheckBox keyAuth;
    private javax.swing.JSpinner spnPort;
    private javax.swing.JTextField txtFolder;
    private javax.swing.JTextField txtHost;
    private javax.swing.JPasswordField txtPassphrase;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPrivateKeyPath;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
