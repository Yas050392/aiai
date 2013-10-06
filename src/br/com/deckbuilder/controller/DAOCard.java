package br.com.deckbuilder.controller;

import br.com.deckbuilder.model.Card;
/*     */ //import br.com.deckbuilder.model.CardCreature;
          import br.com.deckbuilder.view.CriaCarta;
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

public class DAOCard {
            public DocumentBuilderFactory dbf;
/*     */   public DocumentBuilder db;
/*     */   public Document doc;
private static DAOCard singleton;

public static DAOCard getInstance(){
            if(DAOCard.singleton == null){
            DAOCard.singleton = new DAOCard ();
        }
        return DAOCard.singleton;
    }

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

/*     */   public Element criaElementoGenerico(String nomeElemento, String valorElemento)
/*     */   {
/*  73 */     Element elementoGenerico = this.doc.createElement(nomeElemento);
/*  74 */     Text valorElementoGenerico = this.doc.createTextNode(valorElemento);
/*     */ 
/*  76 */     elementoGenerico.appendChild(valorElementoGenerico);
/*     */ 
/*  78 */     return elementoGenerico;
/*     */   }
/*     */ 
/*     */   public Element criaElementoAPartirCartaCriatura(Card card)
/*     */   {
     Card card1 = Card.getInstance();
/*  84 */    // CriaDeck createDeck1 = CriaDeck.getInstance();
/*     */ //Card createDeck1 = new Card();
/*  87 */     Element element = this.doc.createElement("card");



/*     */ //FORM DO CRIA CARTA
/*  89 */     //element.setAttribute("id", Integer.toString(createDeck1.i));
/*  90 */     element.setAttribute("type", card1.getType());
/*     */   
/*  93 */     Element nome = criaElementoGenerico("name",card1.getNome());
/*  94 */     Element informacoes = criaElementoGenerico("information", card1.getInformacoes());
/*  95 */     Element custo = criaElementoGenerico("cost", card1.getCusto());
/*  96 */     Element forca = criaElementoGenerico("power", card1.getForca());
/*  97 */     Element defesa = criaElementoGenerico("defense", card1.getDefesa());

/*     */ 
/* 101 */     element.appendChild(nome);
/* 102 */     element.appendChild(informacoes);
/* 103 */     element.appendChild(custo);
/* 104 */     element.appendChild(forca);
/* 105 */     element.appendChild(defesa);
//NodeList abilities = element.getElementsByTagName("name");
/*  82 */         //abilities.item(0).setTextContent("Profeta que abraça o fofinho");

           //FORM DO CRIA HABILIDADE
          for (int i = 0; i <= 2; i ++)
         {
             
            // Element raiz = doc.getDocumentElement();
             // raiz.getElementsByTagName("character");
             
             // elemento.setAttribute("type", "testinho");
             
              
    Element txtAbility = criaElementoGenerico("ability", card1.getTxtAbility1Item(i) + card1.getTxtAbility2Item(i) + card1.getTxtAbility3Item(i) + card1.getTxtAbility4Item(i) );
     Element target = criaElementoGenerico("target", card1.getTargetItem(i));
    Element oper = criaElementoGenerico("oper", card1.getOperItem(i));
     Element no = criaElementoGenerico("no", card1.getNoItem(i));

    element.appendChild(txtAbility);
     element.appendChild(target);
     element.appendChild(oper);
    element.appendChild(no);

          }

/* 106 */     return element;
/*     */   }
/*     */ 
/*     */   public void saveCard(Card card)
/*     */   {
/* 115 */     String arquivoLeitura = "modelo.xml";
     String arquivoSaida = "createDeck1.xml";

/* 119 */     this.dbf = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/* 122 */       this.db = this.dbf.newDocumentBuilder();
/*     */     } catch (ParserConfigurationException ex) {
/* 124 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 116 */     
/*     */     try
/*     */     {
/* 129 */       this.doc = this.db.parse(arquivoLeitura);
/*     */     } catch (SAXException | IOException ex) {
/* 131 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 137 */     Element raiz = this.doc.getDocumentElement();
/*     */ 
/* 142 */     //CriaCarta createDeck1 = new CriaCarta();

/* 143 */     for (int i = 1; i <= card.getQtd(); i ++)
/*     */     {
/* 145 */       Element novaCarta = criaElementoAPartirCartaCriatura(card);
/*     */ 
/* 147 */       raiz.appendChild(novaCarta);
/*     */     }
 // try {
//commitCards();
/* 150 */ //     parse(arquivoLeitura, arquivoSaida);
/*     */ //    } catch (SAXException | IOException | TransformerException ex) {
/* 152 */  //     Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */  //   }

/*     */   }


       public void commitCards(){
           
            String arquivoLeitura = "modelo.xml";
            String arquivoSaida = "createDeck1.xml";
/*     */ 

/*     */ 
/*     */     try {
/* 150 */       parse(arquivoLeitura, arquivoSaida);
/*     */     } catch (SAXException | IOException | TransformerException ex) {
/* 152 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
}
}

