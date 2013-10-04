/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deckbuilder.view;


import br.com.mnemosyne.deck.Deck;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Yasmin
 */
public class CriaDeck extends javax.swing.JFrame {
            
            public DocumentBuilderFactory dbf;
/*     */   public DocumentBuilder db;
/*     */   public Document doc;
/*     */   public String nomeDeck;

/*     */   String arquivoLeitura;
/*     */   String arquivoSaida;
            String nomedodeck;



    public CriaDeck() {
        initComponents();
    
    this.dbf = DocumentBuilderFactory.newInstance();
/*     */     try {
/*  51 */       this.db = this.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/*  53 */       Logger.getLogger(CriaDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
    
    }
public void parse(String arquivoLeitura, String arquivoSaida)
/*     */     throws SAXException, IOException, TransformerException
/*     */   {
/*  66 */     DOMSource source = new DOMSource(this.doc);
/*  67 */     StreamResult result = new StreamResult(new FileOutputStream(arquivoSaida));
/*  68 */     TransformerFactory transFactory = TransformerFactory.newInstance();
/*  69 */     Transformer transformer = transFactory.newTransformer();
/*  70 */     transformer.transform(source, result);
/*     */   }
/*     */ 
/*     */   public static String obterValorElemento(Element elemento, String nomeElemento)
/*     */   {
/*  76 */     NodeList listaElemento = elemento.getElementsByTagName(nomeElemento);
/*  77 */     if (listaElemento == null) {
/*  78 */       return null;
/*     */     }
/*     */ 
/*  81 */     Element noElemento = (Element)listaElemento.item(0);
/*  82 */     if (noElemento == null) {
/*  83 */       return null;
/*     */     }
/*     */ 
/*  86 */     Node no = noElemento.getFirstChild();
/*  87 */     return no.getNodeValue();
/*     */   }
/*     */ 
/*     */   public Deck criaDeck(Element elemento)
/*     */   {
/*  92 */     Deck deck = new Deck();
/*  93 */     deck.setId(Integer.parseInt(elemento.getAttributeNode("id").getNodeValue()));
/*  94 */     deck.setNome(obterValorElemento(elemento, "name"));
/*  95 */     deck.setInformacoes(obterValorElemento(elemento, "information"));
/*  96 */     deck.setStrategy(obterValorElemento(elemento, "strategy"));
/*  97 */     deck.setQtdCards(obterValorElemento(elemento, "qtdCards"));
/*  98 */     return deck;
/*     */   }
/*     */ 
/*     */   public Element criaElementoAPartirCarta(Deck deck)
/*     */   {
/* 104 */     Element element = this.doc.createElement("deck");
/*     */ 
/* 107 */     element.setAttribute("id", "1");
/*     */ 
/* 109 */     Element nome = criaElementoGenerico("name", deck.getNome());
/* 110 */     Element informacoes = criaElementoGenerico("information", deck.getInformacoes());
/* 111 */     Element strategy = criaElementoGenerico("strategy", deck.getStrategy());
/* 112 */     Element qtdCards = criaElementoGenerico("qtdCards", deck.getQtdCards());
/*     */ 
/* 116 */     element.appendChild(nome);
/* 117 */     element.appendChild(informacoes);
/* 118 */     element.appendChild(strategy);
/* 119 */     element.appendChild(qtdCards);
/*     */ 
/* 121 */     return element;
/*     */   }
/*     */ 
/*     */   public Element criaElementoGenerico(String nomeElemento, String valorElemento)
/*     */   {
/* 127 */     Element elementoGenerico = this.doc.createElement(nomeElemento);
/* 128 */     Text valorElementoGenerico = this.doc.createTextNode(valorElemento);
/*     */ 
/* 130 */     elementoGenerico.appendChild(valorElementoGenerico);
/*     */ 
/* 132 */     return elementoGenerico;
/*     */   }
/*     */ 
/*     */   private Deck criaDeck()
/*     */   {
/* 137 */     Deck deck = new Deck();
/* 138 */     deck.setId(1);
/* 139 */     deck.setNome(this.lblDeckName.getText());
/* 140 */     deck.setInformacoes(this.txtInformation.getText());
/* 141 */     deck.setStrategy(this.txtStrategy.getText());
/* 142 */     deck.setQtdCards(this.txtQtdCartas.getText());
/* 143 */     return deck;
/*     */   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDeckName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQtdCartas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStrategy = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInformation = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        cmdvoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDeckName.setText("deck");
        getContentPane().add(lblDeckName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Criando o Deck");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 29, -1, -1));

        jLabel3.setText("Quantidade de Cartas:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        getContentPane().add(txtQtdCartas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 40, -1));

        jLabel4.setText("Estratégia:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtStrategy.setColumns(20);
        txtStrategy.setRows(5);
        jScrollPane1.setViewportView(txtStrategy);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 230, 70));

        jLabel5.setText("Comentários");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txtInformation.setColumns(20);
        txtInformation.setRows(5);
        jScrollPane2.setViewportView(txtInformation);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 230, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/disket.jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 60, 60));

        cmdvoltar.setLabel("Voltar");
        cmdvoltar.setName("cmdvoltar"); // NOI18N
        cmdvoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdvoltarMouseClicked(evt);
            }
        });
        getContentPane().add(cmdvoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
this.arquivoLeitura = "modelo.xml";
/* 225 */     this.arquivoSaida = "createDeck.xml";
/*     */     try
/*     */     {
/* 229 */       this.doc = this.db.parse(this.arquivoLeitura);
/*     */     } catch (SAXException ex) {
/* 231 */       Logger.getLogger(CriaDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 233 */       Logger.getLogger(CriaDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 235 */     Element raiz = this.doc.getDocumentElement();
/*     */ 
/* 241 */     Element novoDeck = criaElementoAPartirCarta(criaDeck());
/*     */ 
/* 243 */     raiz.appendChild(novoDeck);
/*     */ 
/* 245 */     String profeta = "modelo.xml";
/* 246 */     String arquivo = "createDeck";
/*     */     try {
/* 248 */       parse(profeta, arquivo + ".xml");
/*     */     } catch (SAXException ex) {
/* 250 */       Logger.getLogger(CriaDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 252 */       Logger.getLogger(CriaDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (TransformerException ex) {
/* 254 */       Logger.getLogger(CriaDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 257 */     JOptionPane.showMessageDialog(null, "Informações do Deck preenchidas com sucesso!");
/*     */ 
/* 259 */     CriaCarta createDeck1Form = new CriaCarta();
/* 260 */     createDeck1Form.setVisible(true);
/* 261 */     setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void cmdvoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdvoltarMouseClicked
TelaInicial startScreen = new TelaInicial();
/* 266 */     startScreen.setVisible(true);
/* 267 */     setVisible(false);
    }//GEN-LAST:event_cmdvoltarMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
            TelaInicial telaInicial = new TelaInicial();
            nomedodeck = telaInicial.deckName;
            System.out.println(nomedodeck);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(CriaDeck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriaDeck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriaDeck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriaDeck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriaDeck().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdvoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDeckName;
    private javax.swing.JTextArea txtInformation;
    private javax.swing.JTextField txtQtdCartas;
    private javax.swing.JTextArea txtStrategy;
    // End of variables declaration//GEN-END:variables
}
