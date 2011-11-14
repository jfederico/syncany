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
package org.syncany.gui.wizard;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

import org.syncany.config.Config;
import org.syncany.config.Profile;
import org.syncany.exceptions.ConfigException;
import org.syncany.gui.settings.SettingsPanel;

/**
 *
 * @author Philipp C. Heckel <philipp.heckel@gmail.com>
 */
public class WizardDialog extends javax.swing.JDialog {
    private static final Config config = Config.getInstance();
    
    private int currentPanelIndex;
    private SettingsPanel[] panels;
    private NewOrExistingPanel panelNewOrExisting;
    private ConnectionPanel panelProfileBasics;
    private EncryptionPanel panelEncryption;
    private RepositoryTestPanel panelRepositoryTest;
    private FoldersPanel panelFolders;
    private Thread preloadPanelsThread = null;

    private boolean newRepository;
    private Profile profile;
    
    private ResourceBundle resourceBundle;

    /** Creates new form WizardDialog */
    private WizardDialog(Frame parent, boolean modal) {
        super(parent, modal); 
        resourceBundle = Config.getInstance().getResourceBundle();
        initComponents();
        initDialog();
        initWizard();
    }

    private void initDialog() {
        setLocationRelativeTo(null); // center
        getRootPane().setDefaultButton(btnNext);

        // Image
        lblLeftImage.setText("");
        lblLeftImage.setIcon(new ImageIcon(config.getResDir()+File.separator+"wizard-left.png"));
    }

    private void initWizard() {
        // Profile
        newRepository = true;
        profile = new Profile(); // set if successfully created!

        // Panels
        currentPanelIndex = 0;

        panelNewOrExisting = new NewOrExistingPanel();

        preloadPanelsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                panelProfileBasics = new ConnectionPanel(profile);
                panelEncryption = new EncryptionPanel(profile);
                panelRepositoryTest = new RepositoryTestPanel(profile);
                panelFolders = new FoldersPanel(profile); 
            }
        }, "PreloadPanels");

	preloadPanelsThread.start();


        panels = new SettingsPanel[] {
            panelNewOrExisting,
            null,
            // The rest is set after clicking NEXT
        };

        // Listeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                profile = null;
            }

        });

        showCurrentPanel(true);
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLeftImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        scrMain = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(null);
        jPanel1.setName("jPanel1"); // NOI18N

        lblLeftImage.setText(resourceBundle.getString("wizard_image"));
        lblLeftImage.setName("lblLeftImage"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLeftImage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLeftImage, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setName("jPanel2"); // NOI18N

        btnNext.setFont(btnNext.getFont());
        btnNext.setText(resourceBundle.getString("wizard_next"));
        btnNext.setName("btnNext"); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setFont(btnBack.getFont());
        btnBack.setText(resourceBundle.getString("wizard_back"));
        btnBack.setName("btnBack"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(284, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 431, 520, -1));

        scrMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrMain.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrMain.setName("scrMain"); // NOI18N
        getContentPane().add(scrMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 0, 520, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        backClicked();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        nextClicked();
    }//GEN-LAST:event_btnNextActionPerformed

    public static Profile showWizard() {
        return showWizard(new JFrame());
    }

    public static Profile showWizard(JFrame parent) {
        WizardDialog dialog = new WizardDialog(parent, true);

        dialog.setVisible(true);
        return dialog.getProfile();
    }

    private Profile getProfile() {
        return profile;
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ConfigException {
        config.load();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Wizard opened");
                System.out.println("RESULT = "+WizardDialog.showWizard());
                /*WizardDialog dialog = new WizardDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);*/
            }
        });
    }

    private void showCurrentPanel(boolean enableNext) {
        btnBack.setEnabled(true);
        btnNext.setEnabled(enableNext);

        if (currentPanelIndex == 0) {
            btnBack.setText(resourceBundle.getString("wizard_cancel"));
            btnNext.setText(resourceBundle.getString("wizard_next"));
        }
        else if (panels[currentPanelIndex] == panelFolders && panelNewOrExisting.isNewRepository() ) {
            btnBack.setText(resourceBundle.getString("wizard_back"));
            btnNext.setText(resourceBundle.getString("wizard_create_profile"));
        }
        else if (currentPanelIndex == panels.length-1) {
            if (panelNewOrExisting.isNewRepository()) {
                btnBack.setText(resourceBundle.getString("wizard_cancel"));
                btnBack.setEnabled(false);
                btnNext.setText(resourceBundle.getString("wizard_activate_profile"));
            }
            else {
                btnBack.setText(resourceBundle.getString("wizard_back"));
                btnNext.setText(resourceBundle.getString("wizard_activate_profile"));                
            }
        }
        else {
            btnBack.setText(resourceBundle.getString("wizard_back"));
            btnNext.setText(resourceBundle.getString("wizard_next"));
        }

        panels[currentPanelIndex].load();        
        scrMain.setViewportView(panels[currentPanelIndex]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLeftImage;
    private javax.swing.JScrollPane scrMain;
    // End of variables declaration//GEN-END:variables

    private void backClicked() {
        switch (currentPanelIndex) {
            case 0: // "Cancel"
                profile = null; // Nullify!
                dispose();
                break;

            default:
                currentPanelIndex--;
                showCurrentPanel(true);
        }
    }

    private void nextClicked() {
        SettingsPanel lastPanel = panels[currentPanelIndex];
        if (lastPanel != null) lastPanel.save();

        // Choose dynamic panel!
        if (lastPanel == panelNewOrExisting) {
            // NEW

            // SNM 6/01/11 
            // If we don't wait for this thread to finish, we'll end up with some
	    // panels that are still null
            if(preloadPanelsThread!=null){
                try{
                    preloadPanelsThread.join();
		}catch(InterruptedException e){
                    // Not sure how this would happen
		}
	    }
            if (panelNewOrExisting.isNewRepository()) {
                panels = new SettingsPanel[] {
                    panelNewOrExisting,
                    panelProfileBasics,
                    panelEncryption,
                    panelFolders,
                    panelRepositoryTest
                };
            }

            // EXISTING
            else {
                panels = new SettingsPanel[] {
                    panelNewOrExisting,
                    panelProfileBasics,
                    panelEncryption,
                    panelRepositoryTest,
                    panelFolders
                };
            }
        }

        else if ((panelNewOrExisting.isNewRepository() && lastPanel == panelFolders)
            || (panelNewOrExisting.isExistingRepository() && lastPanel == panelEncryption)) {
            
            currentPanelIndex++;
            showCurrentPanel(false);

            panelRepositoryTest.doRepoAction(panelNewOrExisting.isNewRepository(), new RepositoryTestPanel.TestListener() {
                @Override
                public void actionCompleted(boolean success) {
                    if (success) {
                        btnBack.setEnabled(false);
                        btnNext.setEnabled(true);                        
                    }
                    
                    else {
                        btnBack.setEnabled(true);
                        btnNext.setEnabled(false);                                                
                    }                    
                }
            });
            
            return;
        }

        // Last panel done!
        else if (currentPanelIndex == panels.length-1) {
            //panelRepository.save();
            System.out.println("profiles = "+config.getProfiles() + " -- profile = "+profile);
            /*config.getProfiles().add(profile);
            
            try {
                config.save(new File("/home/pheckel/.syncany/config-new.xml"));
            } catch (ConfigException ex) {
                Logger.getLogger(WizardDialog.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            setVisible(false);
            return;
        }

        currentPanelIndex++;
        showCurrentPanel(true);	
    }


}