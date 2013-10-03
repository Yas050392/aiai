/*     */ package br.com.mnemosyne.adapters;
/*     */ 
/*     */ import br.com.mnemosyne.deck.CardCreature;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class EditandoXMLDOM
/*     */ {
/*     */   private DocumentBuilderFactory dbf;
/*     */   private DocumentBuilder db;
/*     */   private Document doc;
/*     */ 
/*     */   public EditandoXMLDOM()
/*     */     throws ParserConfigurationException
/*     */   {
/*  32 */     this.dbf = DocumentBuilderFactory.newInstance();
/*  33 */     this.db = this.dbf.newDocumentBuilder();
/*     */   }
/*     */ 
/*     */   public void parse(String arquivoLeitura, String arquivoSaida)
/*     */     throws SAXException, IOException, TransformerException
/*     */   {
/*  47 */     this.doc = this.db.parse(arquivoLeitura);
/*     */ 
/*  50 */     Element raiz = this.doc.getDocumentElement();
/*     */ 
/*  53 */     NodeList listaCartas = raiz.getElementsByTagName("carta");
/*     */ 
/*  56 */     for (int i = 0; i < listaCartas.getLength(); i++)
/*     */     {
/*  59 */       Element elementoCarta = (Element)listaCartas.item(i);
/*     */ 
/*  62 */       CardCreature carta = criaCarta(elementoCarta);
/*  63 */       System.out.println(carta);
/*     */ 
/*  67 */       if (carta.isGravado()) {
/*  68 */         raiz.removeChild(elementoCarta);
/*  69 */         i--;
/*     */       } else {
/*  71 */         elementoCarta.setAttribute("gravado", "SIM");
/*     */       }
/*     */ 
/*  75 */       if (carta.getId() == 2)
/*     */       {
/*  81 */         NodeList abilities = elementoCarta.getElementsByTagName("name");
/*  82 */         abilities.item(0).setTextContent("Profeta que abraça o fofinho");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  88 */     Element novoCarta = criaElementoAPartirCarta(criaCartaFicticio());
/*     */ 
/*  90 */     raiz.appendChild(novoCarta);
/*     */ 
/*  94 */     DOMSource source = new DOMSource(this.doc);
/*  95 */     StreamResult result = new StreamResult(new FileOutputStream(arquivoSaida));
/*  96 */     TransformerFactory transFactory = TransformerFactory.newInstance();
/*  97 */     Transformer transformer = transFactory.newTransformer();
/*  98 */     transformer.transform(source, result);
/*     */   }
/*     */ 
/*     */   public static String obterValorElemento(Element elemento, String nomeElemento)
/*     */   {
/* 111 */     NodeList listaElemento = elemento.getElementsByTagName(nomeElemento);
/* 112 */     if (listaElemento == null) {
/* 113 */       return null;
/*     */     }
/*     */ 
/* 116 */     Element noElemento = (Element)listaElemento.item(0);
/* 117 */     if (noElemento == null) {
/* 118 */       return null;
/*     */     }
/*     */ 
/* 121 */     Node no = noElemento.getFirstChild();
/* 122 */     return no.getNodeValue();
/*     */   }
/*     */ 
/*     */   public CardCreature criaCarta(Element elemento)
/*     */   {
/* 132 */     CardCreature carta = new CardCreature();
/* 133 */     carta.setId(Integer.parseInt(elemento.getAttributeNode("id").getNodeValue()));
/* 134 */     carta.setGravado(elemento.getAttributeNode("gravado").getNodeValue());
/* 135 */     carta.setNome(obterValorElemento(elemento, "name"));
/* 136 */     carta.setInformacoes(obterValorElemento(elemento, "information"));
/* 137 */     carta.setCusto(obterValorElemento(elemento, "cost"));
/* 138 */     carta.setForca(obterValorElemento(elemento, "power"));
/* 139 */     carta.setDefesa(obterValorElemento(elemento, "defense"));
/* 140 */     carta.setHabilidade(obterValorElemento(elemento, "txtAbility"));
/* 141 */     carta.setOrigemHab(obterValorElemento(elemento, "source"));
/* 142 */     carta.setValorOper(obterValorElemento(elemento, "no"));
/* 143 */     return carta;
/*     */   }
/*     */ 
/*     */   public Element criaElementoAPartirCarta(CardCreature carta)
/*     */   {
/* 154 */     Element element = this.doc.createElement("carta");
/*     */ 
/* 157 */     element.setAttribute("id", "2");
/* 158 */     element.setAttribute("gravado", "SIM");
/*     */ 
/* 161 */     Element nome = criaElementoGenerico("name", carta.getNome());
/* 162 */     Element informacoes = criaElementoGenerico("information", carta.getInformacoes());
/* 163 */     Element custo = criaElementoGenerico("custo", carta.getCusto());
/* 164 */     Element forca = criaElementoGenerico("power", carta.getForca());
/* 165 */     Element defesa = criaElementoGenerico("defense", carta.getDefesa());
/* 166 */     Element habilidade = criaElementoGenerico("txtAbility", carta.getHabilidade());
/* 167 */     Element origemHab = criaElementoGenerico("source", carta.getOrigemHab());
/* 168 */     Element operHab = criaElementoGenerico("oper", carta.getOperHab());
/* 169 */     Element valorOper = criaElementoGenerico("no", carta.getValorOper());
/*     */ 
/* 172 */     element.appendChild(nome);
/* 173 */     element.appendChild(informacoes);
/* 174 */     element.appendChild(custo);
/* 175 */     element.appendChild(forca);
/* 176 */     element.appendChild(defesa);
/* 177 */     element.appendChild(habilidade);
/* 178 */     element.appendChild(origemHab);
/* 179 */     element.appendChild(operHab);
/* 180 */     element.appendChild(valorOper);
/*     */ 
/* 182 */     return element;
/*     */   }
/*     */ 
/*     */   public Element criaElementoGenerico(String nomeElemento, String valorElemento)
/*     */   {
/* 193 */     Element elementoGenerico = this.doc.createElement(nomeElemento);
/* 194 */     Text valorElementoGenerico = this.doc.createTextNode(valorElemento);
/*     */ 
/* 196 */     elementoGenerico.appendChild(valorElementoGenerico);
/*     */ 
/* 198 */     return elementoGenerico;
/*     */   }
/*     */ 
/*     */   private CardCreature criaCartaFicticio()
/*     */   {
/* 206 */     CardCreature carta = new CardCreature();
/* 207 */     carta.setId(5);
/* 208 */     carta.setGravado(true);
/* 209 */     carta.setNome("Tiago da Silva");
/* 210 */     carta.setInformacoes("Endereco qualquer de teste");
/* 211 */     carta.setCusto("two water");
/* 212 */     carta.setForca("99");
/* 213 */     carta.setDefesa("99");
/* 214 */     carta.setHabilidade("abraca o fofinho 50 vezes");
/* 215 */     carta.setOrigemHab("owner");
/* 216 */     carta.setOperHab("increment");
/* 217 */     carta.setValorOper("50");
/* 218 */     return carta;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 226 */     String profeta = "profeta.xml";
/* 227 */     String arquivo = "teste66";
/*     */     try {
/* 229 */       EditandoXMLDOM editingXMLDOM = new EditandoXMLDOM();
/* 230 */       editingXMLDOM.parse(profeta, arquivo + ".xml");
/*     */     } catch (ParserConfigurationException e) {
/* 232 */       System.out.println("O parser nao foi configurado corretamente.");
/* 233 */       e.printStackTrace();
/*     */     } catch (SAXException e) {
/* 235 */       System.out.println("Problema ao fazer o parse do arquivo.");
/* 236 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 238 */       System.out.println("O arquivo nao pode ser lido.");
/* 239 */       e.printStackTrace();
/*     */     } catch (TransformerException e) {
/* 241 */       System.out.println("Problema ao fazer a serializacao do arquivo.");
/* 242 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.adapters.EditandoXMLDOM
 * JD-Core Version:    0.6.2
 */