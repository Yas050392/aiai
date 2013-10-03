/*     */ package br.com.mnemosyne.layout;
/*     */ 
/*     */ import br.com.mnemosyne.deck.CardCreature;
/*     */ import br.com.mnemosyne.deck.Deck;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.text.DefaultFormatterFactory;
/*     */ import javax.swing.text.NumberFormatter;
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
/*     */ public class CreateDeck1 extends JFrame
/*     */ {
/*     */   public DocumentBuilderFactory dbf;
/*     */   public DocumentBuilder db;
/*     */   public Document doc;
/*     */   String arquivoLeitura;
/*     */   String arquivoSaida;
/*     */   private JPanel PanImagem;
/*     */   private JComboBox cboCusto;
/*     */   private JComboBox cboTipoCarta;
/*     */   private JLabel deckName;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTextField mskQtdCarta;
/*     */   private JFormattedTextField txtAtaque;
/*     */   private JFormattedTextField txtDefesa;
/*     */   private JTextArea txtInformacoes;
/*     */   private JTextField txtNomeCarta;
/*     */   private JTextField txtQtdCusto;
/*     */   private JTextField txtTipoCusto;
/*     */ 
/*     */   public CreateDeck1()
/*     */   {
/*  38 */     initComponents();
/*     */ 
/*  41 */     this.dbf = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/*  44 */       this.db = this.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/*  46 */       Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
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
/*     */   private CardCreature criaCartaCriatura()
/*     */   {
/* 205 */     CardCreature cardCreature = new CardCreature();
/* 206 */     cardCreature.setId(1);
/* 207 */     cardCreature.setNome(this.deckName.getText());
/*     */ 
/* 211 */     return cardCreature;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 237 */     this.jLabel1 = new JLabel();
/* 238 */     this.jLabel2 = new JLabel();
/* 239 */     this.deckName = new JLabel();
/* 240 */     this.jLabel4 = new JLabel();
/* 241 */     this.jLabel5 = new JLabel();
/* 242 */     this.mskQtdCarta = new JTextField();
/* 243 */     this.jLabel6 = new JLabel();
/* 244 */     this.cboTipoCarta = new JComboBox();
/* 245 */     this.jLabel7 = new JLabel();
/* 246 */     this.PanImagem = new JPanel();
/* 247 */     this.jLabel8 = new JLabel();
/* 248 */     this.txtNomeCarta = new JTextField();
/* 249 */     this.jLabel9 = new JLabel();
/* 250 */     this.cboCusto = new JComboBox();
/* 251 */     this.jLabel10 = new JLabel();
/* 252 */     this.txtQtdCusto = new JTextField();
/* 253 */     this.jLabel11 = new JLabel();
/* 254 */     this.txtTipoCusto = new JTextField();
/* 255 */     this.jLabel12 = new JLabel();
/* 256 */     this.jScrollPane1 = new JScrollPane();
/* 257 */     this.txtInformacoes = new JTextArea();
/* 258 */     this.jLabel13 = new JLabel();
/* 259 */     this.jLabel14 = new JLabel();
/* 260 */     this.jLabel15 = new JLabel();
/* 261 */     this.txtAtaque = new JFormattedTextField();
/* 262 */     this.txtDefesa = new JFormattedTextField();
/* 263 */     this.jButton1 = new JButton();
/*     */ 
/* 265 */     setName("CreateDeckForm");
/* 266 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/* 268 */     this.jLabel1.setFont(new Font("Tahoma", 0, 18));
/* 269 */     this.jLabel1.setText("Criando o Deck");
/* 270 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(30, 20, -1, -1));
/*     */ 
/* 272 */     this.jLabel2.setFont(new Font("Tahoma", 0, 18));
/* 273 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(150, 30, -1, -1));
/*     */ 
/* 275 */     this.deckName.setFont(new Font("Tahoma", 0, 18));
/* 276 */     this.deckName.setText("deck");
/* 277 */     getContentPane().add(this.deckName, new AbsoluteConstraints(160, 20, 120, -1));
/*     */ 
/* 279 */     this.jLabel4.setFont(new Font("Tahoma", 0, 12));
/* 280 */     this.jLabel4.setText("Características Gerais de nova carta");
/* 281 */     getContentPane().add(this.jLabel4, new AbsoluteConstraints(30, 60, -1, -1));
/*     */ 
/* 283 */     this.jLabel5.setText("Quantidade:");
/* 284 */     getContentPane().add(this.jLabel5, new AbsoluteConstraints(20, 110, -1, -1));
/* 285 */     getContentPane().add(this.mskQtdCarta, new AbsoluteConstraints(20, 140, 40, -1));
/*     */ 
/* 287 */     this.jLabel6.setText("Tipo:");
/* 288 */     getContentPane().add(this.jLabel6, new AbsoluteConstraints(110, 110, -1, -1));
/*     */ 
/* 290 */     this.cboTipoCarta.setModel(new DefaultComboBoxModel(new String[] { "Tipo", "Criatura", "Mágica", "Recurso" }));
/* 291 */     this.cboTipoCarta.addMouseListener(new MouseAdapter() {
/*     */       public void mouseEntered(MouseEvent evt) {
/* 293 */         CreateDeck1.this.cboTipoCartaMouseEntered(evt);
/*     */       }
/*     */     });
/* 296 */     this.cboTipoCarta.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 298 */         CreateDeck1.this.cboTipoCartaItemStateChanged(evt);
/*     */       }
/*     */     });
/* 301 */     this.cboTipoCarta.addFocusListener(new FocusAdapter() {
/*     */       public void focusLost(FocusEvent evt) {
/* 303 */         CreateDeck1.this.cboTipoCartaFocusLost(evt);
/*     */       }
/*     */       public void focusGained(FocusEvent evt) {
/* 306 */         CreateDeck1.this.cboTipoCartaFocusGained(evt);
/*     */       }
/*     */     });
/* 309 */     getContentPane().add(this.cboTipoCarta, new AbsoluteConstraints(110, 140, -1, -1));
/*     */ 
/* 311 */     this.jLabel7.setText("Imagem:");
/* 312 */     getContentPane().add(this.jLabel7, new AbsoluteConstraints(250, 110, -1, -1));
/* 313 */     getContentPane().add(this.PanImagem, new AbsoluteConstraints(300, 110, 570, 480));
/*     */ 
/* 315 */     this.jLabel8.setText("Nome:");
/* 316 */     getContentPane().add(this.jLabel8, new AbsoluteConstraints(20, 180, -1, -1));
/* 317 */     getContentPane().add(this.txtNomeCarta, new AbsoluteConstraints(20, 210, 140, -1));
/*     */ 
/* 319 */     this.jLabel9.setText("Custo para ser usada:");
/* 320 */     getContentPane().add(this.jLabel9, new AbsoluteConstraints(30, 450, -1, -1));
/*     */ 
/* 322 */     this.cboCusto.setModel(new DefaultComboBoxModel(new String[] { "Nenhum", "Outro" }));
/* 323 */     this.cboCusto.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 325 */         CreateDeck1.this.cboCustoItemStateChanged(evt);
/*     */       }
/*     */     });
/* 328 */     this.cboCusto.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 330 */         CreateDeck1.this.cboCustoActionPerformed(evt);
/*     */       }
/*     */     });
/* 333 */     getContentPane().add(this.cboCusto, new AbsoluteConstraints(30, 480, -1, -1));
/*     */ 
/* 335 */     this.jLabel10.setText("Quantidade");
/* 336 */     getContentPane().add(this.jLabel10, new AbsoluteConstraints(30, 520, -1, -1));
/* 337 */     getContentPane().add(this.txtQtdCusto, new AbsoluteConstraints(30, 560, 40, -1));
/*     */ 
/* 339 */     this.jLabel11.setText("Tipo do Custo:");
/* 340 */     getContentPane().add(this.jLabel11, new AbsoluteConstraints(150, 520, -1, -1));
/* 341 */     getContentPane().add(this.txtTipoCusto, new AbsoluteConstraints(150, 560, 130, -1));
/*     */ 
/* 343 */     this.jLabel12.setText("Texto Descritivo:");
/* 344 */     getContentPane().add(this.jLabel12, new AbsoluteConstraints(20, 250, -1, -1));
/*     */ 
/* 346 */     this.txtInformacoes.setColumns(20);
/* 347 */     this.txtInformacoes.setRows(5);
/* 348 */     this.jScrollPane1.setViewportView(this.txtInformacoes);
/*     */ 
/* 350 */     getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(20, 280, 260, 60));
/*     */ 
/* 352 */     this.jLabel13.setText("de Custo:");
/* 353 */     getContentPane().add(this.jLabel13, new AbsoluteConstraints(30, 540, -1, -1));
/*     */ 
/* 355 */     this.jLabel14.setText("Ataque:");
/* 356 */     getContentPane().add(this.jLabel14, new AbsoluteConstraints(20, 360, -1, -1));
/*     */ 
/* 358 */     this.jLabel15.setText("Defesa:");
/* 359 */     getContentPane().add(this.jLabel15, new AbsoluteConstraints(120, 360, -1, -1));
/*     */ 
/* 361 */     this.txtAtaque.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
/* 362 */     this.txtAtaque.setToolTipText("");
/* 363 */     getContentPane().add(this.txtAtaque, new AbsoluteConstraints(20, 390, 40, -1));
/*     */ 
/* 365 */     this.txtDefesa.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
/* 366 */     getContentPane().add(this.txtDefesa, new AbsoluteConstraints(130, 390, 40, -1));
/*     */ 
/* 368 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/disket.jpg")));
/* 369 */     this.jButton1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 371 */         CreateDeck1.this.jButton1MouseClicked(evt);
/*     */       }
/*     */     });
/* 374 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(790, 600, 60, 60));
/*     */ 
/* 376 */     pack();
/*     */   }
/*     */ 
/*     */   private void cboTipoCartaFocusGained(FocusEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void cboTipoCartaFocusLost(FocusEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void cboTipoCartaMouseEntered(MouseEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void cboTipoCartaItemStateChanged(ItemEvent evt) {
/* 392 */     Object tipoCarta = this.cboTipoCarta.getSelectedItem();
/*     */ 
/* 394 */     if ((tipoCarta == "Mágica") || (tipoCarta == "Recurso")) {
/* 395 */       this.jLabel14.setVisible(false);
/* 396 */       this.jLabel15.setVisible(false);
/* 397 */       this.txtAtaque.setVisible(false);
/* 398 */       this.txtDefesa.setVisible(false);
/*     */     }
/* 400 */     if (tipoCarta == "Criatura") {
/* 401 */       this.jLabel14.setVisible(true);
/* 402 */       this.jLabel15.setVisible(true);
/* 403 */       this.txtAtaque.setVisible(true);
/* 404 */       this.txtDefesa.setVisible(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void cboCustoItemStateChanged(ItemEvent evt) {
/* 409 */     Object tipoCusto = this.cboCusto.getSelectedItem();
/*     */ 
/* 411 */     if (tipoCusto == "Outro") {
/* 412 */       this.jLabel10.setVisible(true);
/* 413 */       this.jLabel11.setVisible(true);
/* 414 */       this.jLabel13.setVisible(true);
/* 415 */       this.txtTipoCusto.setVisible(true);
/* 416 */       this.txtQtdCusto.setVisible(true);
/*     */     }
/*     */     else {
/* 419 */       this.jLabel10.setVisible(false);
/* 420 */       this.jLabel11.setVisible(false);
/* 421 */       this.jLabel13.setVisible(false);
/* 422 */       this.txtTipoCusto.setVisible(false);
/* 423 */       this.txtQtdCusto.setVisible(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void cboCustoActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton1MouseClicked(MouseEvent evt) {
/* 432 */     CreateDeck2 createDeckForm1 = new CreateDeck2();
/* 433 */     createDeckForm1.setVisible(true);
/* 434 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 448 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 450 */         new CreateDeck1().setVisible(true);
/*     */ 
/* 453 */         String profeta = "modelo.xml";
/* 454 */         String arquivo = "createDeck";
/*     */ 
/* 457 */         CreateDeck createDeck = new CreateDeck();
/*     */         try {
/* 459 */           createDeck.parse(profeta, arquivo + ".xml");
/*     */         } catch (SAXException ex) {
/* 461 */           Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */         } catch (IOException ex) {
/* 463 */           Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */         } catch (TransformerException ex) {
/* 465 */           Logger.getLogger(CreateDeck.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.layout.CreateDeck1
 * JD-Core Version:    0.6.2
 */