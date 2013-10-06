/*     */ package br.com.mnemosyne.adapters;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class LeitorXMLDOM
/*     */ {
/*     */   public void realizaLeituraXML(String arquivoXML)
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  34 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/*  35 */     DocumentBuilder db = dbf.newDocumentBuilder();
/*  36 */     Document doc = db.parse(arquivoXML);
/*     */ 
/*  39 */     Element raiz = doc.getDocumentElement();
/*  40 */     System.out.println("O elemento raiz eh: " + raiz.getNodeName());
/*     */ 
/*  43 */     NodeList listaCharacterCards = raiz.getElementsByTagName("character");
/*     */ 
/*  46 */     for (int i = 0; i < listaCharacterCards.getLength(); i++) {
/*  47 */       System.out.println();
/*     */ 
/*  50 */       Element characterCard = (Element)listaCharacterCards.item(i);
/*     */ 
/*  52 */       Attr id = characterCard.getAttributeNode("id");
/*  53 */       System.out.println("Character Id: " + id.getNodeValue());
/*     */ 
/*  55 */       NodeList listaName = characterCard.getElementsByTagName("name");
/*  56 */       Node name = listaName.item(0).getFirstChild();
/*  57 */       System.out.println("Nome da carta: " + name.getNodeValue());
/*     */ 
/*  59 */       NodeList listaInformation = characterCard.getElementsByTagName("information");
/*  60 */       Node information = listaInformation.item(0).getFirstChild();
/*  61 */       System.out.println("Informacoes: " + information.getNodeValue());
/*     */ 
/*  63 */       NodeList listaCost = characterCard.getElementsByTagName("cost");
/*  64 */       Node cost = listaCost.item(0).getFirstChild();
/*  65 */       System.out.println("Custo: " + cost.getNodeValue());
/*     */ 
/*  67 */       NodeList listaPower = characterCard.getElementsByTagName("power");
/*  68 */       Node power = listaPower.item(0).getFirstChild();
/*  69 */       System.out.println("Forca: " + power.getNodeValue());
/*     */ 
/*  71 */       NodeList listaDefense = characterCard.getElementsByTagName("defense");
/*  72 */       Node defense = listaDefense.item(0).getFirstChild();
/*  73 */       System.out.println("Defesa: " + defense.getNodeValue());
/*     */ 
/*  75 */       NodeList listaAbility = characterCard.getElementsByTagName("text");
/*  76 */       Node ability = listaAbility.item(0).getFirstChild();
/*  77 */       System.out.println("Habilidade: " + ability.getNodeValue());
/*     */ 
/*  79 */       NodeList listaSource = characterCard.getElementsByTagName("source");
/*  80 */       Node source = listaSource.item(0).getFirstChild();
/*  81 */       System.out.println("Origem da habilidade: " + source.getNodeValue());
/*     */ 
/*  83 */       NodeList listaOper = characterCard.getElementsByTagName("oper");
/*  84 */       Node oper = listaOper.item(0).getFirstChild();
/*  85 */       System.out.println("Operacao da habilidade: " + oper.getNodeValue());
/*     */ 
/*  87 */       NodeList listaNo = characterCard.getElementsByTagName("no");
/*  88 */       Node no = listaNo.item(0).getFirstChild();
/*  89 */       System.out.println("Valor a ser operado: " + no.getNodeValue());
/*     */ 
/*  91 */       NodeList listaOnAssociatedDestroy = characterCard.getElementsByTagName("onAssociatedDestroy");
/*  92 */       Node onAssociatedDestroy = listaOnAssociatedDestroy.item(0).getFirstChild();
/*  93 */       System.out.println("Acao quando a carta e destruida: " + onAssociatedDestroy.getNodeValue());
/*     */ 
/*  95 */       NodeList listaOnAssociatedMove = characterCard.getElementsByTagName("onAssociatedMove");
/*  96 */       Node onAssociatedMove = listaOnAssociatedMove.item(0).getFirstChild();
/*  97 */       System.out.println("Acao quando a carta e movida de zona: " + onAssociatedMove.getNodeValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 103 */     LeitorXMLDOM parser = new LeitorXMLDOM();
/*     */     try {
/* 105 */       parser.realizaLeituraXML("resources/cards/deck1/profeta.xml");
/*     */     }
/*     */     catch (ParserConfigurationException e) {
/* 108 */       System.out.println("O parser nao foi configurado corretamente.");
/* 109 */       e.printStackTrace();
/*     */     } catch (SAXException e) {
/* 111 */       System.out.println("Problema ao fazer o parse do arquivo.");
/* 112 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 114 */       System.out.println("O arquivo nao pode ser lido.");
/* 115 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.adapters.LeitorXMLDOM
 * JD-Core Version:    0.6.2
 */