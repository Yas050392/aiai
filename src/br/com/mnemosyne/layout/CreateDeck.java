/*     */ package br.com.mnemosyne.layout;
/*     */ 
/*     */ import br.com.mnemosyne.deck.Deck;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class CreateDeck extends JFrame
/*     */ {
/*     */   public DocumentBuilderFactory dbf;
/*     */   public DocumentBuilder db;
/*     */   public Document doc;
/*     */   String arquivoLeitura;
/*     */   String arquivoSaida;
/*     */   private JLabel deckName;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JTextArea txtInformation;
/*     */   private JTextField txtQtdCartas;
/*     */   private JTextArea txtStrategy;
/*     */ 
/*     */   public CreateDeck()
/*     */   {
/*  38 */     initComponents();
/*     */ 
/*  41 */     this.dbf = DocumentBuilderFactory.newInstance();
/*     */     try {
/*  43 */       this.db = this.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/*  45 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void parse(String arquivoLeitura, String arquivoSaida)
/*     */     throws SAXException, IOException, TransformerException
/*     */   {
/* 105 */     DOMSource source = new DOMSource(this.doc);
/* 106 */     StreamResult result = new StreamResult(new FileOutputStream(arquivoSaida));
/* 107 */     TransformerFactory transFactory = TransformerFactory.newInstance();
/* 108 */     Transformer transformer = transFactory.newTransformer();
/* 109 */     transformer.transform(source, result);
/*     */   }
/*     */ 
/*     */   public static String obterValorElemento(Element elemento, String nomeElemento)
/*     */   {
/* 124 */     NodeList listaElemento = elemento.getElementsByTagName(nomeElemento);
/* 125 */     if (listaElemento == null) {
/* 126 */       return null;
/*     */     }
/*     */ 
/* 129 */     Element noElemento = (Element)listaElemento.item(0);
/* 130 */     if (noElemento == null) {
/* 131 */       return null;
/*     */     }
/*     */ 
/* 134 */     Node no = noElemento.getFirstChild();
/* 135 */     return no.getNodeValue();
/*     */   }
/*     */ 
/*     */   public Deck criaDeck(Element elemento)
/*     */   {
/* 145 */     Deck deck = new Deck();
/* 146 */     deck.setId(Integer.parseInt(elemento.getAttributeNode("id").getNodeValue()));
/* 147 */     deck.setNome(obterValorElemento(elemento, "name"));
/* 148 */     deck.setInformacoes(obterValorElemento(elemento, "information"));
/* 149 */     deck.setStrategy(obterValorElemento(elemento, "strategy"));
/* 150 */     deck.setQtdCards(obterValorElemento(elemento, "qtdCards"));
/* 151 */     return deck;
/*     */   }
/*     */ 
/*     */   public Element criaElementoAPartirCarta(Deck deck)
/*     */   {
/* 162 */     Element element = this.doc.createElement("deck");
/*     */ 
/* 165 */     element.setAttribute("id", "1");
/*     */ 
/* 169 */     Element nome = criaElementoGenerico("name", deck.getNome());
/* 170 */     Element informacoes = criaElementoGenerico("information", deck.getInformacoes());
/* 171 */     Element strategy = criaElementoGenerico("strategy", deck.getStrategy());
/* 172 */     Element qtdCards = criaElementoGenerico("qtdCards", deck.getQtdCards());
/*     */ 
/* 176 */     element.appendChild(nome);
/* 177 */     element.appendChild(informacoes);
/* 178 */     element.appendChild(strategy);
/* 179 */     element.appendChild(qtdCards);
/*     */ 
/* 181 */     return element;
/*     */   }
/*     */ 
/*     */   public Element criaElementoGenerico(String nomeElemento, String valorElemento)
/*     */   {
/* 192 */     Element elementoGenerico = this.doc.createElement(nomeElemento);
/* 193 */     Text valorElementoGenerico = this.doc.createTextNode(valorElemento);
/*     */ 
/* 195 */     elementoGenerico.appendChild(valorElementoGenerico);
/*     */ 
/* 197 */     return elementoGenerico;
/*     */   }
/*     */ 
/*     */   private Deck criaDeck()
/*     */   {
/* 205 */     Deck deck = new Deck();
/* 206 */     deck.setId(1);
/* 207 */     deck.setNome(this.deckName.getText());
/* 208 */     deck.setInformacoes(this.txtInformation.getText());
/* 209 */     deck.setStrategy(this.txtStrategy.getText());
/* 210 */     deck.setQtdCards(this.txtQtdCartas.getText());
/* 211 */     return deck;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 225 */     this.jLabel1 = new JLabel();
/* 226 */     this.deckName = new JLabel();
/* 227 */     this.jLabel3 = new JLabel();
/* 228 */     this.txtQtdCartas = new JTextField();
/* 229 */     this.jLabel4 = new JLabel();
/* 230 */     this.jScrollPane1 = new JScrollPane();
/* 231 */     this.txtStrategy = new JTextArea();
/* 232 */     this.jLabel5 = new JLabel();
/* 233 */     this.jScrollPane2 = new JScrollPane();
/* 234 */     this.txtInformation = new JTextArea();
/* 235 */     this.jButton1 = new JButton();
/*     */ 
/* 237 */     setDefaultCloseOperation(3);
/* 238 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 240 */     this.jLabel1.setFont(new Font("Tahoma", 0, 12));
/* 241 */     this.jLabel1.setText("Criando o Deck");
/* 242 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(29, 29, -1, -1));
/*     */ 
/* 244 */     this.deckName.setText("deck");
/* 245 */     getContentPane().add(this.deckName, new AbsoluteConstraints(130, 30, -1, -1));
/*     */ 
/* 247 */     this.jLabel3.setText("Quantidade de Cartas:");
/* 248 */     getContentPane().add(this.jLabel3, new AbsoluteConstraints(20, 90, -1, -1));
/* 249 */     getContentPane().add(this.txtQtdCartas, new AbsoluteConstraints(20, 120, 40, -1));
/*     */ 
/* 251 */     this.jLabel4.setText("Estratégia:");
/* 252 */     getContentPane().add(this.jLabel4, new AbsoluteConstraints(30, 180, -1, -1));
/*     */ 
/* 254 */     this.txtStrategy.setColumns(20);
/* 255 */     this.txtStrategy.setRows(5);
/* 256 */     this.jScrollPane1.setViewportView(this.txtStrategy);
/*     */ 
/* 258 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(30, 210, 230, 70));
/*     */ 
/* 260 */     this.jLabel5.setText("Comentários");
/* 261 */     getContentPane().add(this.jLabel5, new AbsoluteConstraints(30, 310, -1, -1));
/*     */ 
/* 263 */     this.txtInformation.setColumns(20);
/* 264 */     this.txtInformation.setRows(5);
/* 265 */     this.jScrollPane2.setViewportView(this.txtInformation);
/*     */ 
/* 267 */     getContentPane().add(this.jScrollPane2, new AbsoluteConstraints(30, 340, 230, 70));
/*     */ 
/* 269 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/disket.jpg")));
/* 270 */     this.jButton1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 272 */         CreateDeck.this.jButton1MouseClicked(evt);
/*     */       }
/*     */     });
/* 275 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(650, 390, 60, 60));
/*     */ 
/* 277 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1MouseClicked(MouseEvent evt) {
/* 281 */     this.arquivoLeitura = "modelo.xml";
/* 282 */     this.arquivoSaida = "createDeck.xml";
/*     */     try
/*     */     {
/* 286 */       this.doc = this.db.parse(this.arquivoLeitura);
/*     */     } catch (SAXException ex) {
/* 288 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 290 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 292 */     Element raiz = this.doc.getDocumentElement();
/*     */ 
/* 341 */     Element novoDeck = criaElementoAPartirCarta(criaDeck());
/*     */ 
/* 343 */     raiz.appendChild(novoDeck);
/*     */     try {
/* 345 */       parse(this.arquivoLeitura, this.arquivoSaida);
/*     */     } catch (SAXException ex) {
/* 347 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 349 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (TransformerException ex) {
/* 351 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 354 */     JOptionPane.showMessageDialog(null, "Informações do Deck preenchidas com sucesso!");
/*     */ 
/* 356 */     CreateDeck createDeckForm = new CreateDeck();
/* 357 */     createDeckForm.setVisible(true);
/* 358 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 371 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 372 */         if ("Nimbus".equals(info.getName())) {
/* 373 */           UIManager.setLookAndFeel(info.getClassName());
/* 374 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 378 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 380 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 382 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 384 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 389 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 391 */         new CreateDeck().setVisible(true);
/*     */ 
/* 393 */         String profeta = "modelo.xml";
/* 394 */         String arquivo = "createDeck";
/*     */ 
/* 397 */         CreateDeck createDeck = new CreateDeck();
/*     */         try {
/* 399 */           createDeck.parse(profeta, arquivo + ".xml");
/*     */         } catch (SAXException ex) {
/* 401 */           Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */         } catch (IOException ex) {
/* 403 */           Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */         } catch (TransformerException ex) {
/* 405 */           Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.layout.CreateDeck
 * JD-Core Version:    0.6.2
 */