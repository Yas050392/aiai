/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deckbuilder.view;
import br.com.deckbuilder.controller.UtilsCarta;
import br.com.deckbuilder.model.Card;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Yasmin
 */
public class AlteraCarta extends javax.swing.JFrame {
    
 public JButton[] listaStr = new JButton[73];


private static AlteraCarta singleton;



public static AlteraCarta getInstance(){
            if(AlteraCarta.singleton == null){
            AlteraCarta.singleton = new AlteraCarta ();
        }
        return AlteraCarta.singleton;
    }

    
    public AlteraCarta() {
        initComponents();
         criaVetor();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCard1 = new javax.swing.JButton();
        btnCard2 = new javax.swing.JButton();
        btnCard3 = new javax.swing.JButton();
        btnCard4 = new javax.swing.JButton();
        btnCard5 = new javax.swing.JButton();
        btnCard6 = new javax.swing.JButton();
        btnCard7 = new javax.swing.JButton();
        btnCard8 = new javax.swing.JButton();
        btnCard9 = new javax.swing.JButton();
        btnCard10 = new javax.swing.JButton();
        btnCard11 = new javax.swing.JButton();
        btnCard12 = new javax.swing.JButton();
        btnCard13 = new javax.swing.JButton();
        btnCard14 = new javax.swing.JButton();
        btnCard15 = new javax.swing.JButton();
        btnCard16 = new javax.swing.JButton();
        btnCard17 = new javax.swing.JButton();
        btnCard18 = new javax.swing.JButton();
        btnCard19 = new javax.swing.JButton();
        btnCard20 = new javax.swing.JButton();
        btnCard21 = new javax.swing.JButton();
        btnCard22 = new javax.swing.JButton();
        btnCard23 = new javax.swing.JButton();
        btnCard25 = new javax.swing.JButton();
        btnCard26 = new javax.swing.JButton();
        btnCard27 = new javax.swing.JButton();
        btnCard28 = new javax.swing.JButton();
        btnCard29 = new javax.swing.JButton();
        btnCard30 = new javax.swing.JButton();
        btnCard31 = new javax.swing.JButton();
        btnCard32 = new javax.swing.JButton();
        btnCard33 = new javax.swing.JButton();
        btnCard34 = new javax.swing.JButton();
        btnCard35 = new javax.swing.JButton();
        btnCard36 = new javax.swing.JButton();
        btnCard37 = new javax.swing.JButton();
        btnCard38 = new javax.swing.JButton();
        btnCard39 = new javax.swing.JButton();
        btnCard40 = new javax.swing.JButton();
        btnCard41 = new javax.swing.JButton();
        btnCard42 = new javax.swing.JButton();
        btnCard43 = new javax.swing.JButton();
        btnCard44 = new javax.swing.JButton();
        btnCard45 = new javax.swing.JButton();
        btnCard46 = new javax.swing.JButton();
        btnCard47 = new javax.swing.JButton();
        btnCard48 = new javax.swing.JButton();
        btnCard49 = new javax.swing.JButton();
        btnCard50 = new javax.swing.JButton();
        btnCard51 = new javax.swing.JButton();
        btnCard52 = new javax.swing.JButton();
        btnCard53 = new javax.swing.JButton();
        btnCard54 = new javax.swing.JButton();
        btnCard55 = new javax.swing.JButton();
        btnCard56 = new javax.swing.JButton();
        btnCard57 = new javax.swing.JButton();
        btnCard58 = new javax.swing.JButton();
        btnCard59 = new javax.swing.JButton();
        btnCard60 = new javax.swing.JButton();
        btnCard61 = new javax.swing.JButton();
        btnCard62 = new javax.swing.JButton();
        btnCard63 = new javax.swing.JButton();
        btnCard64 = new javax.swing.JButton();
        btnCard65 = new javax.swing.JButton();
        btnCard66 = new javax.swing.JButton();
        btnCard67 = new javax.swing.JButton();
        btnCard68 = new javax.swing.JButton();
        btnCard69 = new javax.swing.JButton();
        btnCard70 = new javax.swing.JButton();
        btnCard71 = new javax.swing.JButton();
        btnCard72 = new javax.swing.JButton();
        btnCard73 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Selecione a carta do Deck que deseja alterar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard1.setName("btnCard1"); // NOI18N
        btnCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 110));

        btnCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard2.setName("btnCard2"); // NOI18N
        btnCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 110));

        btnCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard3.setName("btnCard3"); // NOI18N
        btnCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        btnCard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCard3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 80, 110));

        btnCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard4.setName("btnCard4"); // NOI18N
        btnCard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 110));

        btnCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard5.setName("btnCard5"); // NOI18N
        btnCard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 80, 110));

        btnCard6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard6.setName("btnCard6"); // NOI18N
        btnCard6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 80, 110));

        btnCard7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 80, 110));

        btnCard8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 80, 110));

        btnCard9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 80, 110));

        btnCard10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 80, 110));

        btnCard11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 80, 110));

        btnCard12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 80, 110));

        btnCard13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, 110));

        btnCard14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 80, 110));

        btnCard15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 80, 110));

        btnCard16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 80, 110));

        btnCard17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 80, 110));

        btnCard18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 80, 110));

        btnCard19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 80, 110));

        btnCard20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        btnCard20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBorder(evt);
            }
        });
        jPanel1.add(btnCard20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 80, 110));

        btnCard21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard21, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 80, 110));

        btnCard22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 80, 110));

        btnCard23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 80, 110));

        btnCard25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard25, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 80, 110));

        btnCard26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, 110));

        btnCard27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 80, 110));

        btnCard28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 80, 110));

        btnCard29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 80, 110));

        btnCard30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard30, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 80, 110));

        btnCard31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard31, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 80, 110));

        btnCard32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 80, 110));

        btnCard33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 80, 110));

        btnCard34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard34, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 80, 110));

        btnCard35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard35, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 80, 110));

        btnCard36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard36, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 80, 110));

        btnCard37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard37, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 80, 110));

        btnCard38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 80, 110));

        btnCard39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 110));

        btnCard40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard40, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 80, 110));

        btnCard41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard41, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 80, 110));

        btnCard42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard42, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 80, 110));

        btnCard43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard43, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 80, 110));

        btnCard44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard44, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 80, 110));

        btnCard45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard45, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 80, 110));

        btnCard46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard46, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 80, 110));

        btnCard47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard47, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 80, 110));

        btnCard48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard48, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, 80, 110));

        btnCard49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard49, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 80, 110));

        btnCard50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 80, 110));

        btnCard51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard51, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 80, 110));

        btnCard52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard52, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 80, 110));

        btnCard53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard53, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 80, 110));

        btnCard54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard54, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 80, 110));

        btnCard55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard55, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 80, 110));

        btnCard56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard56, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 80, 110));

        btnCard57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard57, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 80, 110));

        btnCard58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard58, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 80, 110));

        btnCard59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard59, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 80, 110));

        btnCard60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard60, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 80, 110));

        btnCard61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard61, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 80, 110));

        btnCard62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 80, 110));

        btnCard63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard63, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 80, 110));

        btnCard64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard64, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 80, 110));

        btnCard65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard65, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 80, 110));

        btnCard66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard66, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 80, 110));

        btnCard67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard67, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 80, 110));

        btnCard68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard68, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 80, 110));

        btnCard69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard69, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, 80, 110));

        btnCard70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard70, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 80, 110));

        btnCard71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard71, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 80, 110));

        btnCard72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard72, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 560, 80, 110));

        btnCard73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/fundo_carta2.jpg"))); // NOI18N
        jPanel1.add(btnCard73, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 560, 80, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 980, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void btnCard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCard3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCard3ActionPerformed

    private void changeBorder(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeBorder
JButton btn = (JButton)evt.getSource();
//TelaInicial telaInicial = TelaInicial.getInstance();
Card card = new Card();
     try {
         card = UtilsCarta.retornaCard("yasminFinal.xml", "image", btn.getName());
     } catch (ParserConfigurationException | SAXException | IOException ex) {
         Logger.getLogger(AlteraCarta.class.getName()).log(Level.SEVERE, null, ex);
     }
    
CriaCarta criaCarta = new CriaCarta(card);
criaCarta.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_changeBorder

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
            java.util.logging.Logger.getLogger(AlteraCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraCarta().setVisible(true);
            }
        });
    }
 public void criaVetor() {

        listaStr[0] = btnCard1;
        listaStr[1] = btnCard2;
        listaStr[2] = btnCard3;
        listaStr[3] = btnCard4;
        listaStr[4] = btnCard5;
        listaStr[5] = btnCard6;
        
        listaStr[6] = btnCard7;
        listaStr[7] = btnCard8;
        listaStr[8] = btnCard9;
        listaStr[9] = btnCard10;
        listaStr[10] = btnCard11;
        listaStr[11] = btnCard12;

        listaStr[12] = btnCard13;
        listaStr[13] = btnCard14;
        listaStr[14] = btnCard15;
        listaStr[15] = btnCard16;
        listaStr[16] = btnCard17;
        listaStr[17] = btnCard18;
        
        listaStr[18] = btnCard19;
        listaStr[19] = btnCard20;
        listaStr[20] = btnCard21;
        listaStr[21] = btnCard22;
        listaStr[22] = btnCard23;
        listaStr[23] = btnCard25;

        listaStr[24] = btnCard26;
        listaStr[25] = btnCard27;
        listaStr[26] = btnCard28;
        listaStr[27] = btnCard29;
        listaStr[28] = btnCard30;
        listaStr[29] = btnCard31;
        
        listaStr[30] = btnCard32;
        listaStr[31] = btnCard33;
        listaStr[32] = btnCard34;
        listaStr[33] = btnCard35;
        listaStr[34] = btnCard36;
        listaStr[35] = btnCard37;

        listaStr[36] = btnCard38;
        listaStr[37] = btnCard39;
        listaStr[38] = btnCard40;
        listaStr[39] = btnCard41;
        listaStr[40] = btnCard42;
        listaStr[41] = btnCard43;

        listaStr[42] = btnCard44;
        listaStr[43] = btnCard45;
        listaStr[44] = btnCard46;
        listaStr[45] = btnCard47;
        listaStr[46] = btnCard48;
        listaStr[47] = btnCard49;
        
        listaStr[48] = btnCard50;
        listaStr[49] = btnCard51;
        listaStr[50] = btnCard52;
        listaStr[51] = btnCard53;
        listaStr[52] = btnCard54;
        listaStr[53] = btnCard55;
        
        listaStr[54] = btnCard56;
        listaStr[55] = btnCard57;
        listaStr[56] = btnCard58;
        listaStr[57] = btnCard59;
        listaStr[58] = btnCard60;
        listaStr[59] = btnCard61;

        listaStr[60] = btnCard62;
        listaStr[61] = btnCard63;
        listaStr[62] = btnCard64;
        listaStr[63] = btnCard65;
        listaStr[64] = btnCard66;
        listaStr[65] = btnCard67;

        listaStr[66] = btnCard68;
        listaStr[67] = btnCard69;
        listaStr[68] = btnCard70;
        listaStr[69] = btnCard71;
        listaStr[70] = btnCard72;
        listaStr[71] = btnCard73;
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCard1;
    private javax.swing.JButton btnCard10;
    private javax.swing.JButton btnCard11;
    private javax.swing.JButton btnCard12;
    private javax.swing.JButton btnCard13;
    private javax.swing.JButton btnCard14;
    private javax.swing.JButton btnCard15;
    private javax.swing.JButton btnCard16;
    private javax.swing.JButton btnCard17;
    private javax.swing.JButton btnCard18;
    private javax.swing.JButton btnCard19;
    private javax.swing.JButton btnCard2;
    private javax.swing.JButton btnCard20;
    private javax.swing.JButton btnCard21;
    private javax.swing.JButton btnCard22;
    private javax.swing.JButton btnCard23;
    private javax.swing.JButton btnCard25;
    private javax.swing.JButton btnCard26;
    private javax.swing.JButton btnCard27;
    private javax.swing.JButton btnCard28;
    private javax.swing.JButton btnCard29;
    private javax.swing.JButton btnCard3;
    private javax.swing.JButton btnCard30;
    private javax.swing.JButton btnCard31;
    private javax.swing.JButton btnCard32;
    private javax.swing.JButton btnCard33;
    private javax.swing.JButton btnCard34;
    private javax.swing.JButton btnCard35;
    private javax.swing.JButton btnCard36;
    private javax.swing.JButton btnCard37;
    private javax.swing.JButton btnCard38;
    private javax.swing.JButton btnCard39;
    private javax.swing.JButton btnCard4;
    private javax.swing.JButton btnCard40;
    private javax.swing.JButton btnCard41;
    private javax.swing.JButton btnCard42;
    private javax.swing.JButton btnCard43;
    private javax.swing.JButton btnCard44;
    private javax.swing.JButton btnCard45;
    private javax.swing.JButton btnCard46;
    private javax.swing.JButton btnCard47;
    private javax.swing.JButton btnCard48;
    private javax.swing.JButton btnCard49;
    private javax.swing.JButton btnCard5;
    private javax.swing.JButton btnCard50;
    private javax.swing.JButton btnCard51;
    private javax.swing.JButton btnCard52;
    private javax.swing.JButton btnCard53;
    private javax.swing.JButton btnCard54;
    private javax.swing.JButton btnCard55;
    private javax.swing.JButton btnCard56;
    private javax.swing.JButton btnCard57;
    private javax.swing.JButton btnCard58;
    private javax.swing.JButton btnCard59;
    private javax.swing.JButton btnCard6;
    private javax.swing.JButton btnCard60;
    private javax.swing.JButton btnCard61;
    private javax.swing.JButton btnCard62;
    private javax.swing.JButton btnCard63;
    private javax.swing.JButton btnCard64;
    private javax.swing.JButton btnCard65;
    private javax.swing.JButton btnCard66;
    private javax.swing.JButton btnCard67;
    private javax.swing.JButton btnCard68;
    private javax.swing.JButton btnCard69;
    private javax.swing.JButton btnCard7;
    private javax.swing.JButton btnCard70;
    private javax.swing.JButton btnCard71;
    private javax.swing.JButton btnCard72;
    private javax.swing.JButton btnCard73;
    private javax.swing.JButton btnCard8;
    private javax.swing.JButton btnCard9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
