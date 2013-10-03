/*     */ package br.com.deckbuilder.controller;
/*     */ 
/*     */ import br.com.deckbuilder.model.CardResource;
/*     */ import br.com.deckbuilder.view.CriaCarta;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class DAOCardResource
/*     */ {
/*     */   public DocumentBuilderFactory dbf;
/*     */   public DocumentBuilder db;
/*     */   public Document doc;
/*     */ 
/*     */   public void parse(String arquivoLeitura, String arquivoSaida)
/*     */     throws SAXException, IOException, TransformerException
/*     */   {
/*  33 */     DOMSource source = new DOMSource(this.doc);
/*  34 */     StreamResult result = new StreamResult(new FileOutputStream(arquivoSaida));
/*  35 */     TransformerFactory transFactory = TransformerFactory.newInstance();
/*  36 */     Transformer transformer = transFactory.newTransformer();
/*  37 */     transformer.transform(source, result);
/*     */   }
/*     */ 
/*     */   public String obterValorElemento(Element elemento, String nomeElemento)
/*     */   {
/*  44 */     NodeList listaElemento = elemento.getElementsByTagName(nomeElemento);
/*  45 */     if (listaElemento == null) {
/*  46 */       return null;
/*     */     }
/*     */ 
/*  49 */     Element noElemento = (Element)listaElemento.item(0);
/*  50 */     if (noElemento == null) {
/*  51 */       return null;
/*     */     }
/*     */ 
/*  54 */     Node no = noElemento.getFirstChild();
/*  55 */     return no.getNodeValue();
/*     */   }
/*     */ 
/*     */   public CardResource criaCartaRecurso(Element elemento)
/*     */   {
/*  60 */     CardResource cardResource = new CardResource();
/*  61 */     cardResource.setId(obterValorElemento(elemento, "id"));
/*  62 */     cardResource.setNome(obterValorElemento(elemento, "name"));
/*  63 */     cardResource.setInformacoes(obterValorElemento(elemento, "information"));
/*  64 */     cardResource.setCusto(obterValorElemento(elemento, "cost"));
/*  65 */     return cardResource;
/*     */   }
/*     */ 
/*     */   public Element criaElementoGenerico(String nomeElemento, String valorElemento)
/*     */   {
/*  71 */     Element elementoGenerico = this.doc.createElement(nomeElemento);
/*  72 */     Text valorElementoGenerico = this.doc.createTextNode(valorElemento);
/*     */ 
/*  74 */     elementoGenerico.appendChild(valorElementoGenerico);
/*     */ 
/*  76 */     return elementoGenerico;
/*     */   }
/*     */ 
/*     */   public Element criaElementoAPartirCartaRecurso(CardResource cardResource)
/*     */   {
/*  82 */     CriaCarta createDeck1 = CriaCarta.getInstance();
/*     */ 
/*  85 */     Element element = this.doc.createElement("card");
/*     */ 
/*  87 */     element.setAttribute("id", Integer.toString(createDeck1.i));
/*  88 */     element.setAttribute("type", createDeck1.tipoCartaS);
/*     */ 
/*  91 */     Element nome = criaElementoGenerico("name", cardResource.getNome());
/*  92 */     Element informacoes = criaElementoGenerico("information", cardResource.getInformacoes());
/*  93 */     Element custo = criaElementoGenerico("cost", cardResource.getCusto());
/*     */ 
/*  98 */     element.appendChild(nome);
/*  99 */     element.appendChild(informacoes);
/* 100 */     element.appendChild(custo);
/* 101 */     return element;
/*     */   }
/*     */ 
/*     */   public void saveCardResource()
/*     */   {
/* 110 */     String arquivoLeitura = "createDeck.xml";
/* 111 */     String arquivoSaida = "createDeck1.xml";
/*     */ 
/* 114 */     this.dbf = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/* 117 */       this.db = this.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/* 119 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 124 */       this.doc = this.db.parse(arquivoLeitura);
/*     */     } catch (SAXException ex) {
/* 126 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 128 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 132 */     Element raiz = this.doc.getDocumentElement();
/*     */ 
/* 134 */     CriaCarta createDeck1 = CriaCarta.getInstance();
/* 135 */     for (createDeck1.i = 1; createDeck1.i <= createDeck1.qtdCartas; createDeck1.i += 1)
/*     */     {
/* 137 */       Element novaCarta = criaElementoAPartirCartaRecurso(createDeck1.criaCartaRecurso());
/*     */ 
/* 139 */       raiz.appendChild(novaCarta);
/*     */     }
/*     */     try {
/* 142 */       parse(arquivoLeitura, arquivoSaida);
/*     */     } catch (SAXException ex) {
/* 144 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IOException ex) {
/* 146 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (TransformerException ex) {
/* 148 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.deckbuilder.controller.DAOCardResource
 * JD-Core Version:    0.6.2
 */