package br.com.deckbuilder.controller;

import br.com.deckbuilder.model.Card;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yasmin
 */
public class UtilsCarta {
    
    public static Card retornaCard(String xml, String parametroDeBusca, String valorDaBusca) throws ParserConfigurationException, SAXException, IOException{
        Card card = new Card();
        int i = 0;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xml);
        
        Element raiz = doc.getDocumentElement();
        NodeList listaCharacterCards = raiz.getElementsByTagName("card");
        
        while(i++ < listaCharacterCards.getLength()){
            Element e = (Element)listaCharacterCards.item(i);
            NodeList att = e.getElementsByTagName(parametroDeBusca); //fazer outro for para localizar o no com o valor da image q eu quero, se for igual ele entra nesse for
            Node imagem = att.item(0).getFirstChild();
            if(imagem.getTextContent().equals(valorDaBusca)){
                
                Attr type = e.getAttributeNode("type");
                card.setType(type.getNodeValue());
/*  53 */       System.out.println("Tipo da Carta: " + card.getType());
/*     */ 
/*  55 */       NodeList listaName = e.getElementsByTagName("name");
/*  56 */       Node name = listaName.item(0).getFirstChild();
                card.setNome(name.getNodeValue());
/*  57 */       System.out.println("Nome da carta: " + card.getNome());
/*     */ 
/*  59 */       NodeList listaInformation = e.getElementsByTagName("information");
/*  60 */       Node information = listaInformation.item(0).getFirstChild();
                card.setInformacoes(information.getNodeValue());
/*  61 */       System.out.println("Informacoes: " + card.getInformacoes());
/*     */ 
/*  63 */       NodeList listaCost = e.getElementsByTagName("cost");
/*  64 */       Node cost = listaCost.item(0).getFirstChild();
                card.setCusto(cost.getNodeValue());
/*  65 */       System.out.println("Custo: " + card.getCusto());
/*     */ 
/*  67 */       NodeList listaPower = e.getElementsByTagName("power");
/*  68 */       Node power = listaPower.item(0).getFirstChild();
                card.setForca(power.getNodeValue());
/*  69 */       System.out.println("Forca: " + card.getForca());
/*     */ 
/*  71 */       NodeList listaDefense = e.getElementsByTagName("defense");
/*  72 */       Node defense = listaDefense.item(0).getFirstChild();
                card.setDefesa(defense.getNodeValue());
/*  73 */       System.out.println("Defesa: " + card.getDefesa());
/*     */ 
/*  71 */       NodeList listaImage = e.getElementsByTagName("image");
/*  72 */       Node image = listaImage.item(0).getFirstChild();
                card.setImage(image.getNodeValue());
/*  73 */       System.out.println("ID da Imagem da Carta: " + card.getImage());
/*     */ 
/*  75 */       NodeList listaAbility = e.getElementsByTagName("ability");
/*  76 */       Node ability = listaAbility.item(0).getFirstChild();
                card.setTxtAbility1Item(ability.getNodeValue(), 0);
/*  77 */       System.out.println("Habilidade 1: " + card.getTxtAbility1Item(0));
/*     */ 
/*     */ //HAB 1 
/*  83 */       NodeList listaOper = e.getElementsByTagName("oper");
/*  84 */       Node oper = listaOper.item(0).getFirstChild();
                card.setOperItem(oper.getNodeValue(), 0);
/*  85 */       System.out.println("Operacao da habilidade 1: " + card.getOperItem(0));
/*     */ 
/*  87 */       NodeList listaNo = e.getElementsByTagName("no");
/*  88 */       Node no = listaNo.item(0).getFirstChild();
                card.setNoItem(no.getNodeValue(), 0);
/*  89 */       System.out.println("Valor a ser operado da habilidade 1: " + card.getNoItem(0));

                //HAB 2
/*  75 */       NodeList listaAbility1 = e.getElementsByTagName("ability");
/*  76 */       Node ability1 = listaAbility1.item(1).getFirstChild();
                card.setTxtAbility1Item(ability1.getNodeValue(), 1);
/*  77 */       System.out.println("Habilidade 2: " + card.getTxtAbility1Item(1));
/*     */ 
/*  83 */       NodeList listaOper1 = e.getElementsByTagName("oper");
/*  84 */       Node oper1 = listaOper1.item(1).getFirstChild();
                card.setOperItem(oper1.getNodeValue(), 1);
/*  85 */       System.out.println("Operacao da habilidade 2: " + card.getOperItem(1));
/*     */ 
/*  87 */       NodeList listaNo1 = e.getElementsByTagName("no");
/*  88 */       Node no1 = listaNo1.item(1).getFirstChild();
                card.setNoItem(no1.getNodeValue(), 1);
/*  89 */       System.out.println("Valor a ser operado da habilidade 2: " + card.getNoItem(1));

            //HAB 3
/*  75 */       NodeList listaAbility2 = e.getElementsByTagName("ability");
/*  76 */       Node ability2 = listaAbility2.item(2).getFirstChild();
                card.setTxtAbility1Item(ability2.getNodeValue(), 2);
/*  77 */       System.out.println("Habilidade 3: " + card.getTxtAbility1Item(2));
/*     */ 
/*     */ 
/*  83 */       NodeList listaOper2 = e.getElementsByTagName("oper");
/*  84 */       Node oper2 = listaOper2.item(2).getFirstChild();
                card.setOperItem(oper2.getNodeValue(), 2);
/*  85 */       System.out.println("Operacao da habilidade 3: " + card.getOperItem(2));
/*     */ 
/*  87 */       NodeList listaNo2 = e.getElementsByTagName("no");
/*  88 */       Node no2 = listaNo2.item(2).getFirstChild();
                card.setNoItem(no2.getNodeValue(), 2);
/*  89 */       System.out.println("Valor a ser operado da habilidade 3: " + card.getNoItem(2));
                
                break;
            }
            
        }
        
        
        return card;
    }
    
    public static String converteCarta(String tipoCarta){
         if (tipoCarta == "Criatura") {
/* 279 */       tipoCarta = "character";
/*     */     }
/*     */ 
/* 282 */     if (tipoCarta == "Mágica") {
/* 283 */       tipoCarta = "magic";
/*     */     }
/*     */ 
/* 286 */     if (tipoCarta == "Recurso")
/* 287 */       tipoCarta = "resource";

        return tipoCarta;
    }
}
