/*     */ package br.com.mnemosyne.console;
/*     */ 
/*     */ import br.com.mnemosyne.adapters.CardAdapter;
/*     */ import br.com.mnemosyne.adapters.GameAdapter;
/*     */ import br.com.mnemosyne.beans.Game;
/*     */ import br.com.mnemosyne.beans.Player;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class Console
/*     */ {
/*  22 */   public static Boolean keepRuning = Boolean.valueOf(true);
/*  23 */   static String consolePrefix = "mnemosyne>";
/*     */ 
/*     */   public static void main(String[] args) {
/*  26 */     Comandos c = Comandos.getInstance();
/*  27 */     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*     */ 
/*  29 */     System.out.print(consolePrefix);
/*     */ 
/*  32 */     boolean gameLoaded = false;
/*     */     Integer localInteger2;
/*  33 */     while (!gameLoaded) {
/*     */       try {
/*  35 */         System.out.println("Escolha o jogo desejado: ");
/*  36 */         File gameFolder = new File("resources/games");
/*  37 */         File[] files = gameFolder.listFiles();
/*  38 */         Integer counter = Integer.valueOf(0);
/*     */         Integer localInteger1;
/*  39 */         for (File file : files) {
/*  40 */           System.out.println("\t" + counter + "\t" + file.getName());
/*  41 */           localInteger1 = counter; localInteger2 = counter = Integer.valueOf(counter.intValue() + 1);
/*     */         }
/*  43 */         System.out.print(consolePrefix);
/*  44 */         Integer choice = Integer.valueOf(Integer.parseInt(reader.readLine()));
/*  45 */         new GameAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(files[choice.intValue()]).getElementsByTagName("game").item(0));
/*  46 */         gameLoaded = true;
/*     */       }
/*     */       catch (Exception e) {
/*  49 */         System.out.println("Coloque o numero indice do jogo desejado");
/*     */       }
/*     */     }
/*  52 */     consolePrefix = consolePrefix.replaceAll(">", "") + "@" + Game.getInstance().getName() + ">";
/*  53 */     System.out.print(consolePrefix);
/*     */ 
/*  56 */     boolean deckOneChosen = false;
/*     */     Integer localInteger3;
/*  57 */     while (!deckOneChosen) {
/*     */       try {
/*  59 */         System.out.println("Primeiro jogador, escolha o deck de sua preferencia: ");
/*  60 */         File cardsFolder = new File("resources/cards");
/*  61 */         File[] files = cardsFolder.listFiles();
/*  62 */         Integer counter = Integer.valueOf(0);
/*  63 */         for (File file : files) {
/*  64 */           System.out.println("\t" + counter + "\t" + file.getName());
/*  65 */           localInteger2 = counter; localInteger3 = counter = Integer.valueOf(counter.intValue() + 1);
/*     */         }
/*  67 */         System.out.print(consolePrefix);
/*  68 */         Integer choice = Integer.valueOf(Integer.parseInt(reader.readLine()));
/*     */ 
/*  70 */         for (File card : files[choice.intValue()].listFiles()) {
/*  71 */           Game.getInstance().getPlayerOne().getZone("DECK").putCard(EnLocalPositions.FIRST, new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(card).getElementsByTagName("card").item(0)));
/*     */         }
/*     */ 
/*  75 */         System.out.print(consolePrefix);
/*  76 */         deckOneChosen = true;
/*     */       } catch (Exception e) {
/*  78 */         System.out.println(e);
/*  79 */         System.out.println("Digite o numero indice do deck desejado");
/*     */       }
/*     */     }
/*     */ 
/*  83 */     boolean deckTwoChosen = false;
/*  84 */     while (!deckTwoChosen) {
/*     */       try {
/*  86 */         System.out.println("Segundo jogador, escolha o deck de sua preferencia: ");
/*  87 */         File cardsFolder = new File("resources/cards");
/*  88 */         File[] files = cardsFolder.listFiles();
/*  89 */         Integer counter = Integer.valueOf(0);
/*  90 */         for (File file : files) {
/*  91 */           System.out.println("\t" + counter + "\t" + file.getName());
/*  92 */           localInteger3 = counter; Integer localInteger4 = counter = Integer.valueOf(counter.intValue() + 1);
/*     */         }
/*  94 */         System.out.print(consolePrefix);
/*  95 */         Integer choice = Integer.valueOf(Integer.parseInt(reader.readLine()));
/*  96 */         for (File card : files[choice.intValue()].listFiles()) {
/*  97 */           Game.getInstance().getPlayerTwo().getZone("DECK").putCard(EnLocalPositions.FIRST, new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(card).getElementsByTagName("card").item(0)));
/*     */         }
/*     */ 
/* 101 */         System.out.print(consolePrefix);
/* 102 */         deckTwoChosen = true;
/*     */       } catch (Exception e) {
/* 104 */         System.out.println("Digite o numero indice do deck desejado");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 109 */     boolean whoStartsChosen = false;
/* 110 */     while (!whoStartsChosen) {
/*     */       try {
/* 112 */         System.out.println("Escolha qual jogador iniciara a partida: ");
/* 113 */         System.out.println("\t1\t" + Game.getInstance().getPlayerOne().getName());
/* 114 */         System.out.println("\t2\t" + Game.getInstance().getPlayerTwo().getName());
/* 115 */         System.out.print(consolePrefix);
/* 116 */         Integer choice = Integer.valueOf(Integer.parseInt(reader.readLine()));
/* 117 */         if (choice.intValue() == 1) {
/* 118 */           Game.getInstance().setCurrentPlayer(Game.getInstance().getPlayerOne());
/* 119 */           consolePrefix = consolePrefix.replaceAll(">", "");
/* 120 */           whoStartsChosen = true;
/* 121 */         } else if (choice.intValue() == 2) {
/* 122 */           Game.getInstance().setCurrentPlayer(Game.getInstance().getPlayerTwo());
/* 123 */           consolePrefix = consolePrefix.replaceAll(">", "");
/* 124 */           whoStartsChosen = true;
/*     */         }
/*     */       } catch (Exception e) {
/* 127 */         System.out.println("Digite '1' ou '2'");
/*     */       }
/*     */     }
/*     */ 
/* 131 */     Game.getInstance().start();
/* 132 */     System.out.print(consolePrefix + "@" + Game.getInstance().getCurrentPlayer().getName() + ">");
/* 133 */     String comando = "";
/* 134 */     while (keepRuning.booleanValue())
/*     */     {
/*     */       try
/*     */       {
/* 138 */         String texto = reader.readLine();
/* 139 */         comando = texto.split(">")[0];
/*     */       } catch (Exception e) {
/* 141 */         e.printStackTrace();
/*     */       }
/* 143 */       String[] partes = comando.split(":");
/* 144 */       String nome = partes[0];
/* 145 */       if (partes.length > 1) {
/* 146 */         partes = partes[1].split(" ");
/*     */       }
/* 148 */       List parametros = new ArrayList();
/* 149 */       for (int i = 0; i < partes.length; i++)
/* 150 */         parametros.add(partes[i]);
/*     */       try
/*     */       {
/* 153 */         Method meth = Class.forName("br.com.mnemosyne.console.Comandos").getMethod(nome, new Class[] { List.class });
/* 154 */         meth.invoke(c, new Object[] { parametros });
/*     */       } catch (NoSuchMethodException e) {
/* 156 */         if (nome.length() != 0)
/* 157 */           System.out.println("Comando nao conhecido");
/*     */       }
/*     */       catch (ClassNotFoundException e) {
/* 160 */         e.printStackTrace();
/*     */       } catch (IllegalAccessException e) {
/* 162 */         e.printStackTrace();
/*     */       } catch (InvocationTargetException e) {
/* 164 */         if (e.getCause().getClass() == NumberFormatException.class)
/* 165 */           System.out.println("Um numero era esperado. Tente novamente.");
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 168 */         System.out.println("Um numero era esperado. Tente novamente.");
/*     */       }
/* 170 */       System.out.print((consolePrefix + "@" + Game.getInstance().getCurrentPlayer().getName() + ">").replaceAll(" ", "_"));
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String getParameter()
/*     */   {
/* 176 */     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*     */     try
/*     */     {
/* 179 */       System.out.println(">");
/* 180 */       return reader.readLine();
/*     */     }
/*     */     catch (IOException e) {
/* 183 */       e.printStackTrace();
/*     */     }
/* 185 */     return "";
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.console.Console
 * JD-Core Version:    0.6.2
 */