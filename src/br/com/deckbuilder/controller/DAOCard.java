package br.com.deckbuilder.controller;

import br.com.deckbuilder.model.Card;
import br.com.deckbuilder.view.AlteraCarta;
/*     */ //import br.com.deckbuilder.model.CardCreature;
          import br.com.deckbuilder.view.CriaCarta;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
          import javax.swing.ImageIcon;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.SAXException;
           // import org.jdom.Element;

public class DAOCard {
            public DocumentBuilderFactory dbf;
/*     */   public DocumentBuilder db;
/*     */   public Document doc;
private static DAOCard singleton;

public int flagCard = 0;

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
/*  87 */     Element element = doc.createElement("card");



/*     */ //FORM DO CRIA CARTA
/*  89 */     //element.setAttribute("id", Integer.toString(createDeck1.i));
/*  90 */     element.setAttribute("type", card1.getType());
/*     */   
/*  93 */     Element nome = criaElementoGenerico("name",card1.getNome());
/*  94 */     Element informacoes = criaElementoGenerico("information", card1.getInformacoes());
/*  95 */     Element custo = criaElementoGenerico("cost", card1.getCusto());
/*  96 */     Element forca = criaElementoGenerico("power", card1.getForca());
/*  97 */     Element defesa = criaElementoGenerico("defense", card1.getDefesa());
              Element image = criaElementoGenerico("image", card1.getImage());

/*     */ 
/* 101 */     element.appendChild(nome);
/* 102 */     element.appendChild(informacoes);
/* 103 */     element.appendChild(custo);
/* 104 */     element.appendChild(forca);
/* 105 */     element.appendChild(defesa);
              element.appendChild(image);
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
     Element event = criaElementoGenerico("event", "");

     
    element.appendChild(txtAbility);
     element.appendChild(target);
     element.appendChild(oper);
    element.appendChild(no);
       element.appendChild(event);
       
       event.setAttribute("type", card1.getEventItem(i));
      
          }

/* 106 */     return element;

/*     */   }
/*     */ 
/*     */   public void saveCard(Card card)
/*     */   {
    String arquivoLeitura="createDeck.xml";
    
   if(flagCard == 1){
/* 115 */      arquivoLeitura = "createDeck1.xml";
   }
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
            flagCard = 1;
/*     */     }
 // try {
//commitCards();
/* 150 */ //     parse(arquivoLeitura, arquivoSaida);
/*     */ //    } catch (SAXException | IOException | TransformerException ex) {
/* 152 */  //     Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */  //   }

/*     */   }


       public void commitCards(){
           
           
           
           
            String arquivoLeitura = "createDeck.xml";
            String arquivoSaida = "createDeck1.xml";
/*     */ 

/*     */ 
/*     */     try {
/* 150 */       parse(arquivoLeitura, arquivoSaida);
/*     */     } catch (SAXException | IOException | TransformerException ex) {
/* 152 */       Logger.getLogger(CriaCarta.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
}
       
       /*     */   public void refreshCard()
/*     */   {
/* 115 */          Card card1 = new Card();
/*     */   }
       
        public void loadCard(String arquivoXML) throws ParserConfigurationException, SAXException, IOException
/*     */   {
            
            
/*  34 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/*  35 */     DocumentBuilder db = dbf.newDocumentBuilder();
/*  36 */     Document doc = db.parse(arquivoXML);
/*     */ 
/*  39 */     Element raiz = doc.getDocumentElement();
/*  40 */     System.out.println("O elemento raiz eh: " + raiz.getNodeName());
/*     */ 
/*  43 */     NodeList listaCharacterCards = raiz.getElementsByTagName("card");

/*     */ 
Card[] cartas = new Card[6]; 
               
/*     */ 
/*  46 */     for (int i = 0; i < listaCharacterCards.getLength(); i++) {
/*  47 */       System.out.println();
   
MinhaCartinha minhaCartinha = new  MinhaCartinha();
                 //Card card = new Card();
       cartas[i] = new Card();
/*  50 */       Element characterCard = (Element)listaCharacterCards.item(i);
/*     */ 
/*  52 */       Attr type = characterCard.getAttributeNode("type");
                cartas[i].setType(type.getNodeValue());
/*  53 */       System.out.println("Tipo da Carta: " + cartas[i].getType());
/*     */ 
/*  55 */       NodeList listaName = characterCard.getElementsByTagName("name");
/*  56 */       Node name = listaName.item(0).getFirstChild();
                cartas[i].setNome(name.getNodeValue());
/*  57 */       System.out.println("Nome da carta: " + cartas[i].getNome());
/*     */ 
/*  59 */       NodeList listaInformation = characterCard.getElementsByTagName("information");
/*  60 */       Node information = listaInformation.item(0).getFirstChild();
                cartas[i].setInformacoes(information.getNodeValue());
/*  61 */       System.out.println("Informacoes: " + cartas[i].getInformacoes());
/*     */ 
/*  63 */       NodeList listaCost = characterCard.getElementsByTagName("cost");
/*  64 */       Node cost = listaCost.item(0).getFirstChild();
                cartas[i].setCusto(cost.getNodeValue());
/*  65 */       System.out.println("Custo: " + cartas[i].getCusto());
/*     */ 
/*  67 */       NodeList listaPower = characterCard.getElementsByTagName("power");
/*  68 */       Node power = listaPower.item(0).getFirstChild();
                cartas[i].setForca(power.getNodeValue());
/*  69 */       System.out.println("Forca: " + cartas[i].getForca());
/*     */ 
/*  71 */       NodeList listaDefense = characterCard.getElementsByTagName("defense");
/*  72 */       Node defense = listaDefense.item(0).getFirstChild();
                cartas[i].setDefesa(defense.getNodeValue());
/*  73 */       System.out.println("Defesa: " + cartas[i].getDefesa());
/*     */ 
/*  71 */       NodeList listaImage = characterCard.getElementsByTagName("image");
/*  72 */       Node image = listaImage.item(0).getFirstChild();
                cartas[i].setImage(image.getNodeValue());
/*  73 */       System.out.println("ID da Imagem da Carta: " + cartas[i].getImage());
/*     */ 
/*  75 */       NodeList listaAbility = characterCard.getElementsByTagName("ability");
/*  76 */       Node ability = listaAbility.item(0).getFirstChild();
                cartas[i].setTxtAbility1Item(ability.getNodeValue(), 0);
/*  77 */       System.out.println("Habilidade 1: " + cartas[i].getTxtAbility1Item(0));
/*     */ 
/*     */ //HAB 1 
/*  83 */       NodeList listaOper = characterCard.getElementsByTagName("oper");
/*  84 */       Node oper = listaOper.item(0).getFirstChild();
                cartas[i].setOperItem(oper.getNodeValue(), 0);
/*  85 */       System.out.println("Operacao da habilidade 1: " + cartas[i].getOperItem(0));
/*     */ 
/*  87 */       NodeList listaNo = characterCard.getElementsByTagName("no");
/*  88 */       Node no = listaNo.item(0).getFirstChild();
                cartas[i].setNoItem(no.getNodeValue(), 0);
/*  89 */       System.out.println("Valor a ser operado da habilidade 1: " + cartas[i].getNoItem(0));

                //HAB 2
/*  75 */       NodeList listaAbility1 = characterCard.getElementsByTagName("ability");
/*  76 */       Node ability1 = listaAbility1.item(1).getFirstChild();
                cartas[i].setTxtAbility1Item(ability1.getNodeValue(), 1);
/*  77 */       System.out.println("Habilidade 2: " + cartas[i].getTxtAbility1Item(1));
/*     */ 
/*  83 */       NodeList listaOper1 = characterCard.getElementsByTagName("oper");
/*  84 */       Node oper1 = listaOper1.item(1).getFirstChild();
                cartas[i].setOperItem(oper1.getNodeValue(), 1);
/*  85 */       System.out.println("Operacao da habilidade 2: " + cartas[i].getOperItem(1));
/*     */ 
/*  87 */       NodeList listaNo1 = characterCard.getElementsByTagName("no");
/*  88 */       Node no1 = listaNo1.item(1).getFirstChild();
                cartas[i].setNoItem(no1.getNodeValue(), 1);
/*  89 */       System.out.println("Valor a ser operado da habilidade 2: " + cartas[i].getNoItem(1));

            //HAB 3
/*  75 */       NodeList listaAbility2 = characterCard.getElementsByTagName("ability");
/*  76 */       Node ability2 = listaAbility2.item(2).getFirstChild();
                cartas[i].setTxtAbility1Item(ability2.getNodeValue(), 2);
/*  77 */       System.out.println("Habilidade 3: " + cartas[i].getTxtAbility1Item(2));
/*     */ 
/*     */ 
/*  83 */       NodeList listaOper2 = characterCard.getElementsByTagName("oper");
/*  84 */       Node oper2 = listaOper2.item(2).getFirstChild();
                cartas[i].setOperItem(oper2.getNodeValue(), 2);
/*  85 */       System.out.println("Operacao da habilidade 3: " + cartas[i].getOperItem(2));
/*     */ 
/*  87 */       NodeList listaNo2 = characterCard.getElementsByTagName("no");
/*  88 */       Node no2 = listaNo2.item(2).getFirstChild();
                cartas[i].setNoItem(no2.getNodeValue(), 2);
/*  89 */       System.out.println("Valor a ser operado da habilidade 3: " + cartas[i].getNoItem(2));

minhaCartinha.setCartaCorresp(cartas[i]);

AlteraCarta alteraCarta = AlteraCarta.getInstance();
alteraCarta.setVisible(true);

//System.out.println("------> " + card.getNome());

alteraCarta.listaStr[i].setIcon(new ImageIcon(cartas[i].getImage() + ".jpg"));
alteraCarta.listaStr[i].setName(cartas[i].getImage());



/*     */     }


}    
}

