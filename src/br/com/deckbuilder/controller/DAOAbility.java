package br.com.deckbuilder.controller;

import br.com.deckbuilder.model.Ability;
import br.com.deckbuilder.view.CriaHabilidade;
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
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.SAXException;

public class DAOAbility {
    
     public DocumentBuilderFactory dbf;
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

/*     */   public Element criaElementoGenerico(String nomeElemento, String valorElemento)
/*     */   {
/*  73 */     Element elementoGenerico = doc.createElement(nomeElemento);
/*  74 */     Text valorElementoGenerico = doc.createTextNode(valorElemento);
/*     */ 
/*  76 */     elementoGenerico.appendChild(valorElementoGenerico);
/*     */ 
/*  78 */     return elementoGenerico;
/*     */   }
/*     */ 
/*     */   public Element criaElementoAPartirHabilidade(Ability ability)
/*     */   {
/*  84 */    // CriaDeck createDeck1 = CriaDeck.getInstance();

/*  87 */     Element element = this.doc.createElement("ability");
/*     */ 
/*  89 */     element.setAttribute("id", /*Integer.toString(criaHabilidade.i)*/"1");

             // element.setAttribute("event", "changeScore"); //teste para ver se funfa, alterar para receber da view a string
/*     */       //Primeira Hab
/*  93 */     Element text1 = criaElementoGenerico("text", "pokemon lindao");
/*  94 */     Element target1 = criaElementoGenerico("target", ability.getTarget1());
/*  95 */     Element no1 = criaElementoGenerico("no", ability.getNo1());
/*  96 */     Element oper1 = criaElementoGenerico("oper", ability.getAction1());

/* 101 */     element.appendChild(text1);
/* 102 */     element.appendChild(target1);
/* 103 */     element.appendChild(no1);
/* 104 */     element.appendChild(oper1);
/**
                //segunda Hab
              Element text2 = criaElementoGenerico("text", ability.getText1());
*     Element target2 = criaElementoGenerico("target", ability.getTarget1());
*    Element no2 = criaElementoGenerico("no", ability.getNo1());
*    Element oper2 = criaElementoGenerico("oper", ability.getAction1());

*  element.appendChild(text2);
*    element.appendChild(target2);
*    element.appendChild(no2);
*     element.appendChild(oper2);

                //terceira hab
*    Element text3 = criaElementoGenerico("text", ability.getText1());
*     Element target3 = criaElementoGenerico("target", ability.getTarget1());
*     Element no3 = criaElementoGenerico("no", ability.getNo1());
*     Element oper3 = criaElementoGenerico("oper", ability.getAction1());

*     element.appendChild(text3);
*    element.appendChild(target3);
*     element.appendChild(no3);
*     element.appendChild(oper3);
/* 106 */     return element;
/*     */   }
/*     */ 
/*     */   public void saveAbility()
/*     */   {
/* 115 */     String arquivoLeitura = "createDeck1.xml";
/* 116 */     String arquivoSaida = "createDeck2.xml";
/*     */ 
/* 119 */     this.dbf = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/* 122 */       this.db = this.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/* 124 */       Logger.getLogger(CriaHabilidade.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 129 */       this.doc = this.db.parse(arquivoLeitura);
/*     */     } catch ( SAXException | IOException ex) {
/* 131 */       Logger.getLogger(CriaHabilidade.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 137 */     Element raiz = this.doc.getDocumentElement();
/*     */ 
/* 142 */     CriaHabilidade criaHabilidade = CriaHabilidade.getInstance();

/* 143 */   //  for (createDeck1.i = 1; createDeck1.i <= createDeck1.qtdCartas; createDeck1.i += 1)
/*     */   //  {//primeira hab
/* 145 */       Element novaHabilidade1 = criaElementoAPartirHabilidade(criaHabilidade.criaHabilidade1());
/*     */ 
/* 147 */       raiz.appendChild(novaHabilidade1);
                //segunda hab
           //     Element novaHabilidade2 = criaElementoAPartirHabilidade(criaHabilidade.criaHabilidade2());
/*     */ 
/* 147 */ //      raiz.appendChild(novaHabilidade2);
                   //terceira hab
          //      Element novaHabilidade3 = criaElementoAPartirHabilidade(criaHabilidade.criaHabilidade3());
/*     */ 
/* 147 */ //      raiz.appendChild(novaHabilidade3);
/*     */   //  }
/*     */     try {
/* 150 */       parse(arquivoLeitura, arquivoSaida);
/*     */     } catch ( SAXException | IOException | TransformerException ex) {
/* 152 */       Logger.getLogger(CriaHabilidade.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }

/*     */   }

}
