/*     */ package br.com.deckbuilder.view;
/*     */ 
import br.com.deckbuilder.controller.DAOCard;
/*     */ import br.com.deckbuilder.controller.DAOCardCreature;
/*     */ import br.com.deckbuilder.controller.DAOCardMagic;
/*     */ import br.com.deckbuilder.controller.DAOCardResource;
import br.com.deckbuilder.model.Card;
/*     */ import br.com.deckbuilder.model.CardCreature;
/*     */ import br.com.deckbuilder.model.CardMagic;
/*     */ import br.com.deckbuilder.model.CardResource;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ 
/*     */ public class CriaCarta extends JFrame
/*     */ {
/*  16 */   String nome = "";
/*     */   public Object tipoCarta;
/*     */   public String tipoCartaS;
/*     */   public String custoS;
/*     */   public Object tipoCusto;
/*     */   public int i;
/*     */   public int qtdCartas;
/*     */   private static CriaCarta singleton;
/*     */   
/*     */ 
/*     */   public static CriaCarta getInstance()
/*     */   {
/*  27 */     if (singleton == null) {
/*  28 */       singleton = new CriaCarta();
/*     */     }
/*     */ 
/*  31 */     return singleton;
/*     */   }
/*     */ 
/*     */   private CriaCarta()
/*     */   {
/*  36 */     initComponents();
/*     */ 
/*  38 */     this.jLabel14.setVisible(false);
/*  39 */     this.jLabel15.setVisible(false);
/*  40 */     this.txtAtaque.setVisible(false);
/*  41 */     this.txtDefesa.setVisible(false);
/*     */ 
/*  43 */     this.jLabel9.setVisible(false);
/*  44 */     this.jLabel10.setVisible(false);
/*  45 */     this.jLabel11.setVisible(false);
/*  46 */     this.jLabel13.setVisible(false);
/*  47 */     this.cboCusto.setVisible(false);
/*  48 */     this.txtTipoCusto.setVisible(false);
/*  49 */     this.txtQtdCusto.setVisible(false);
/*     */ 
/*  51 */     DAOCardCreature daoCardCreature = new DAOCardCreature();
/*     */ 
/*  54 */     daoCardCreature.dbf = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/*  57 */       daoCardCreature.db = daoCardCreature.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/*  59 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */
/*     */ 
/*     */   public Card createCardMagic() {
/*  76 */     Card cardMagic = new Card();
/*  77 */     cardMagic.setType(this.tipoCartaS);
/*  78 */     cardMagic.setNome(this.txtNomeCarta.getText());
/*  79 */     cardMagic.setInformacoes(this.txtInformacoes.getText());
/*  80 */     cardMagic.setCusto(this.custoS);
/*  81 */     return cardMagic;
/*     */   }
/*     */ 
/*     */   public Card createCardResource() {
/*  85 */     Card cardResource = new Card();
/*  86 */     cardResource.setType(this.tipoCartaS);
/*  87 */     cardResource.setNome(this.txtNomeCarta.getText());
/*  88 */     cardResource.setInformacoes(this.txtInformacoes.getText());
/*  89 */     cardResource.setCusto(this.custoS);
/*  90 */     return cardResource;
/*     */   }

public CardCreature criaCartaCriatura()
/*     */   {
/*  65 */     CardCreature cardCreature1 = new CardCreature();
/*  66 */     cardCreature1.setType(this.tipoCartaS);
/*  67 */     cardCreature1.setNome(this.txtNomeCarta.getText());
/*  68 */     cardCreature1.setInformacoes(this.txtInformacoes.getText());
/*  69 */     cardCreature1.setCusto(this.custoS);
/*  70 */     cardCreature1.setForca(this.txtAtaque.getText());
/*  71 */     cardCreature1.setDefesa(this.txtDefesa.getText());
/*  72 */     return cardCreature1;
/*     */   }
/*     */ 
/*     */   public CardMagic criaCartaMagica() {
/*  76 */     CardMagic cardMagic = new CardMagic();
/*  77 */     cardMagic.setType(this.tipoCartaS);
/*  78 */     cardMagic.setNome(this.txtNomeCarta.getText());
/*  79 */     cardMagic.setInformacoes(this.txtInformacoes.getText());
/*  80 */     cardMagic.setCusto(this.custoS);
/*  81 */     return cardMagic;
/*     */   }
/*     */ 
/*     */   public CardResource criaCartaRecurso() {
/*  85 */     CardResource cardResource = new CardResource();
/*  86 */     cardResource.setType(this.tipoCartaS);
/*  87 */     cardResource.setNome(this.txtNomeCarta.getText());
/*  88 */     cardResource.setInformacoes(this.txtInformacoes.getText());
/*  89 */     cardResource.setCusto(this.custoS);
/*  90 */     return cardResource;
/*     */   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deckName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mskQtdCarta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboTipoCarta = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        PanImagem = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNomeCarta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboCusto = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtQtdCusto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTipoCusto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacoes = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtAtaque = new javax.swing.JFormattedTextField();
        txtDefesa = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setName("CreateDeckForm"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Criando o Deck");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        deckName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deckName.setText("deck");
        getContentPane().add(deckName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Características Gerais de nova carta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel5.setText("Quantidade:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));
        getContentPane().add(mskQtdCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 40, -1));

        jLabel6.setText("Tipo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cboTipoCarta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo", "Criatura", "Mágica", "Recurso" }));
        cboTipoCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboTipoCartaMouseEntered(evt);
            }
        });
        cboTipoCarta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoCartaItemStateChanged(evt);
            }
        });
        cboTipoCarta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboTipoCartaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboTipoCartaFocusLost(evt);
            }
        });
        getContentPane().add(cboTipoCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel7.setText("Imagem:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));
        getContentPane().add(PanImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 570, 480));

        jLabel8.setText("Nome:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        getContentPane().add(txtNomeCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, -1));

        jLabel9.setText("Custo para ser usada:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        cboCusto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Outro" }));
        cboCusto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCustoItemStateChanged(evt);
            }
        });
        cboCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustoActionPerformed(evt);
            }
        });
        getContentPane().add(cboCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jLabel10.setText("Quantidade");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));
        getContentPane().add(txtQtdCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 40, -1));

        jLabel11.setText("Tipo do Custo:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));
        getContentPane().add(txtTipoCusto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 130, -1));

        jLabel12.setText("Texto Descritivo:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txtInformacoes.setColumns(20);
        txtInformacoes.setRows(5);
        jScrollPane1.setViewportView(txtInformacoes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 260, 60));

        jLabel13.setText("de Custo:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel14.setText("Ataque:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel15.setText("Defesa:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        txtAtaque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtAtaque.setToolTipText("");
        getContentPane().add(txtAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 40, -1));

        txtDefesa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtDefesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 40, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/disket.jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, 60, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*     */ 
/*     */   private void cboTipoCartaFocusGained(FocusEvent evt){//GEN-FIRST:event_cboTipoCartaFocusGained

/*     */   }//GEN-LAST:event_cboTipoCartaFocusGained
/*     */ 
/*     */   private void cboTipoCartaFocusLost(FocusEvent evt) {//GEN-FIRST:event_cboTipoCartaFocusLost
/*     */   }//GEN-LAST:event_cboTipoCartaFocusLost
/*     */ 
/*     */   private void cboTipoCartaMouseEntered(MouseEvent evt) {//GEN-FIRST:event_cboTipoCartaMouseEntered

/*     */   }//GEN-LAST:event_cboTipoCartaMouseEntered
/*     */ 
/*     */   private void cboTipoCartaItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_cboTipoCartaItemStateChanged
/* 257 */     this.tipoCarta = this.cboTipoCarta.getSelectedItem();
/* 258 */     this.tipoCartaS = this.tipoCarta.toString();
/*     */ 
/* 260 */     if ((this.tipoCarta == "Mágica") || (this.tipoCarta == "Recurso")) {
/* 261 */       this.jLabel14.setVisible(false);
/* 262 */       this.jLabel15.setVisible(false);
/* 263 */       this.txtAtaque.setVisible(false);
/* 264 */       this.txtDefesa.setVisible(false);
/* 265 */       this.jLabel9.setVisible(true);
/* 266 */       this.cboCusto.setVisible(true);
/*     */     }
/*     */ 
/* 269 */     if (this.tipoCarta == "Criatura") {
/* 270 */       this.jLabel14.setVisible(true);
/* 271 */       this.jLabel15.setVisible(true);
/* 272 */       this.txtAtaque.setVisible(true);
/* 273 */       this.txtDefesa.setVisible(true);
/* 274 */       this.jLabel9.setVisible(true);
/* 275 */       this.cboCusto.setVisible(true);
/*     */     }
/*     */ 
/* 278 */     if (this.tipoCarta == "Criatura") {
/* 279 */       this.tipoCartaS = "character";
/*     */     }
/*     */ 
/* 282 */     if (this.tipoCarta == "Mágica") {
/* 283 */       this.tipoCartaS = "magic";
/*     */     }
/*     */ 
/* 286 */     if (this.tipoCarta == "Recurso")
/* 287 */       this.tipoCartaS = "resource";
/*     */   }//GEN-LAST:event_cboTipoCartaItemStateChanged
/*     */ 
/*     */   private void cboCustoItemStateChanged(ItemEvent evt){//GEN-FIRST:event_cboCustoItemStateChanged
/* 292 */     this.tipoCusto = this.cboCusto.getSelectedItem();
/*     */ 
/* 294 */     if (this.tipoCusto == "Outro") {
/* 295 */       this.jLabel10.setVisible(true);
/* 296 */       this.jLabel11.setVisible(true);
/* 297 */       this.jLabel13.setVisible(true);
/* 298 */       this.txtTipoCusto.setVisible(true);
/* 299 */       this.txtQtdCusto.setVisible(true);
/*     */     }
/*     */     else {
/* 302 */       this.jLabel10.setVisible(false);
/* 303 */       this.jLabel11.setVisible(false);
/* 304 */       this.jLabel13.setVisible(false);
/* 305 */       this.txtTipoCusto.setVisible(false);
/* 306 */       this.txtQtdCusto.setVisible(false);
/*     */     }
/*     */   }//GEN-LAST:event_cboCustoItemStateChanged
/*     */ 
/*     */   private void cboCustoActionPerformed(ActionEvent evt){//GEN-FIRST:event_cboCustoActionPerformed

/*     */   }//GEN-LAST:event_cboCustoActionPerformed
/*     */ 
/*     */   private void jButton1MouseClicked(MouseEvent evt){//GEN-FIRST:event_jButton1MouseClicked

    
    
    
    /* 316 */     this.tipoCusto = this.cboCusto.getSelectedItem();
/*     */ 
/* 318 */     if (this.tipoCusto == "Nenhum") {
/* 319 */       this.custoS = "none";
/*     */     }
/*     */     else {
/* 322 */       this.custoS = this.txtTipoCusto.getText();
/*     */     }
/*     */ 
/* 326 */     if (this.tipoCarta == "Criatura")
/*     */     {
/* 328 */       this.qtdCartas = Integer.parseInt(this.mskQtdCarta.getText());
/*     */ 
/* 330 */       for (this.i = 0; this.i <= this.qtdCartas; this.i += 1) {
                  criaCartaCriatura();//setter
                  
/* 331 */      //   DAOCardCreature daoCardCreature = new DAOCardCreature();
/*     */ 
/* 333 */      //   daoCardCreature.saveCardCreature();
                  
              Card cardCreature = new Card();
              
/*  66 */     cardCreature.setType(this.tipoCartaS);
/*  67 */     cardCreature.setNome(this.txtNomeCarta.getText());
/*  68 */     cardCreature.setInformacoes(this.txtInformacoes.getText());
/*  69 */     cardCreature.setCusto(this.custoS);
/*  70 */     cardCreature.setForca(this.txtAtaque.getText());
/*  71 */     cardCreature.setDefesa(this.txtDefesa.getText());

                  
                  DAOCard daoCard = new DAOCard();
                  daoCard.saveCardCreature(cardCreature);
/*     */       }
/*     */ 
/* 337 */       JOptionPane.showMessageDialog(null, "Informações da Carta Criatura '" + this.txtNomeCarta.getText() + "' preenchidas com sucesso!");
/*     */ 
/* 339 */       CriaHabilidade createDeck2Form = CriaHabilidade.getInstance();
/* 340 */       createDeck2Form.setVisible(true);
/* 341 */       setVisible(false);
/*     */     }
/*     */ 
/* 345 */     if (this.tipoCarta == "Mágica")
/*     */     {
/* 347 */       this.qtdCartas = Integer.parseInt(this.mskQtdCarta.getText());
/*     */ 
/* 349 */       for (this.i = 0; this.i <= this.qtdCartas; this.i += 1) {
/* 350 */         DAOCardMagic daoCardMagic = new DAOCardMagic();
/*     */ 
/* 352 */         daoCardMagic.saveCardMagic();
/*     */       }
/*     */ 
/* 356 */       JOptionPane.showMessageDialog(null, "Informações da Carta Mágica '" + this.txtNomeCarta.getText() + "' preenchidas com sucesso!");
/*     */ 
/* 358 */       CriaHabilidade createDeck2Form = CriaHabilidade.getInstance();
/* 359 */       createDeck2Form.setVisible(true);
/* 360 */       setVisible(false);
/*     */     }
/*     */ 
/* 365 */     if (this.tipoCarta == "Recurso")
/*     */     {
/* 367 */       this.qtdCartas = Integer.parseInt(this.mskQtdCarta.getText());
/*     */ 
/* 369 */       for (this.i = 0; this.i <= this.qtdCartas; this.i += 1) {
/* 370 */         DAOCardResource daoCardResource = new DAOCardResource();
/*     */ 
/* 372 */         daoCardResource.saveCardResource();
/*     */       }
/*     */ 
/* 376 */       JOptionPane.showMessageDialog(null, "Informações da Carta Recurso '" + this.txtNomeCarta.getText() + "' preenchidas com sucesso!");
/*     */ 
/* 378 */       CriaHabilidade createDeck2Form = CriaHabilidade.getInstance();
/* 379 */       createDeck2Form.setVisible(true);
/* 380 */       setVisible(false);
/*     */     }
/*     */   }//GEN-LAST:event_jButton1MouseClicked
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt){//GEN-FIRST:event_jButton1ActionPerformed

/*     */   }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
/*     */   public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriaCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
/* 389 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 391 */           // new teste().setVisible(true);
/* 392 */         CriaCarta createDeck1 = CriaCarta.getInstance();
 createDeck1.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanImagem;
    private javax.swing.JComboBox cboCusto;
    private javax.swing.JComboBox cboTipoCarta;
    private javax.swing.JLabel deckName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField mskQtdCarta;
    public javax.swing.JFormattedTextField txtAtaque;
    public javax.swing.JFormattedTextField txtDefesa;
    public javax.swing.JTextArea txtInformacoes;
    public javax.swing.JTextField txtNomeCarta;
    private javax.swing.JTextField txtQtdCusto;
    private javax.swing.JTextField txtTipoCusto;
    // End of variables declaration//GEN-END:variables
}

