/*     */ package br.com.mnemosyne.console;
/*     */ 
/*     */ import br.com.mnemosyne.beans.Ability;
/*     */ import br.com.mnemosyne.beans.CharacterCard;
/*     */ import br.com.mnemosyne.beans.Game;
/*     */ import br.com.mnemosyne.beans.Graveyard;
/*     */ import br.com.mnemosyne.beans.Hand;
/*     */ import br.com.mnemosyne.beans.PlayZone;
/*     */ import br.com.mnemosyne.beans.Player;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*     */ import br.com.mnemosyne.interfaces.CallbackUserInterface;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Comandos
/*     */   implements CallbackUserInterface
/*     */ {
/*     */   private static Comandos instance;
/*     */ 
/*     */   public void echo(List<String> args)
/*     */     throws Exception
/*     */   {
/*  23 */     System.out.println("Disse: ");
/*  24 */     for (String string : args) {
/*  25 */       System.out.print(string + " ");
/*     */     }
/*  27 */     System.out.println();
/*     */   }
/*     */ 
/*     */   public void exit(List<String> args) throws Exception {
/*  31 */     System.out.println("Saindo...");
/*  32 */     Console.keepRuning = Boolean.valueOf(false);
/*     */   }
/*     */ 
/*     */   public void draw(List<String> args) throws Exception {
/*  36 */     if (args.size() == 1) {
/*  37 */       Game.getInstance().getCurrentPlayer().draw(Integer.parseInt((String)args.get(0)));
/*  38 */       myCards(null);
/*     */     } else {
/*  40 */       System.out.println("Utilize o parametro conforme exemplo: 'draw:1'");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void playCard(List<String> args) throws Exception {
/*  45 */     if (args.size() == 1) {
/*  46 */       Game.getInstance().getCurrentPlayer().playCard(((String)args.get(0)).replace("_", " "));
/*  47 */       System.out.println("PlayZone:");
/*  48 */       myPlayZone(null);
/*     */     } else {
/*  50 */       System.out.println("Utilize o comando conforme exemplo: 'playCard:Nome_Da_Carta'");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void attack(List<String> args) throws Exception {
/*  55 */     ((CharacterCard)Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(Integer.valueOf(Integer.parseInt((String)args.get(0))))).attack(Game.getInstance().getCurrentPlayer().getOpponent());
/*     */   }
/*     */ 
/*     */   public void attachCard(List<String> args) throws Exception
/*     */   {
/*  60 */     AbstractCard attachOn = Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(Integer.valueOf(Integer.parseInt((String)args.get(0))));
/*  61 */     AbstractCard toAttach = Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(Integer.valueOf(Integer.parseInt((String)args.get(1))));
/*  62 */     Game.getInstance().getCurrentPlayer().playCard(toAttach.getName());
/*  63 */     attachOn.associateCard(Integer.valueOf(Integer.parseInt((String)args.get(1))), toAttach);
/*     */   }
/*     */ 
/*     */   public void tapCard(List<String> args) throws Exception {
/*  67 */     Game.getInstance().getCurrentPlayer().tapCard(Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(Integer.valueOf((String)args.get(0))));
/*     */   }
/*     */ 
/*     */   public void useAbility(List<String> args)
/*     */     throws Exception
/*     */   {
/*  73 */     Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(Integer.valueOf(Integer.parseInt((String)args.get(0)))).useAbility(Integer.valueOf(Integer.parseInt((String)args.get(1)) - 1));
/*     */   }
/*     */ 
/*     */   public void myCards(List<String> args) throws Exception
/*     */   {
/*  78 */     Collection cards = ((Hand)Game.getInstance().getCurrentPlayer().getZone("HAND")).values();
/*  79 */     for (AbstractCard card : cards)
/*  80 */       if ((card instanceof CharacterCard))
/*  81 */         System.out.println(card);
/*     */       else
/*  83 */         System.out.println(card);
/*     */   }
/*     */ 
/*     */   public void nextPhase(List<String> args)
/*     */     throws Exception
/*     */   {
/*  89 */     Game.getInstance().nextPhase();
/*  90 */     System.out.println(Game.getInstance().getCurrentPlayer().getName() + " - " + Game.getInstance().getCurrentPhase().getName());
/*     */   }
/*     */ 
/*     */   public void myGraveyard(List<String> args) throws Exception
/*     */   {
/*  95 */     for (AbstractCard card : (Graveyard)Game.getInstance().getCurrentPlayer().getZone("GRAVEYARD"))
/*  96 */       System.out.println(card);
/*     */   }
/*     */ 
/*     */   public void opponentGraveyard(List<String> args) throws Exception
/*     */   {
/* 101 */     for (AbstractCard card : (Graveyard)Game.getInstance().getCurrentPlayer().getOpponent().getZone("GRAVEYARD"))
/* 102 */       System.out.println(card);
/*     */   }
/*     */ 
/*     */   public void myPlayZone(List<String> args) throws Exception
/*     */   {
/* 107 */     Collection values = ((PlayZone)Game.getInstance().getCurrentPlayer().getZone("PLAY")).values();
/* 108 */     for (AbstractCard card : values)
/* 109 */       System.out.println(card);
/*     */   }
/*     */ 
/*     */   public void opponentPlayZone(List<String> args) throws Exception
/*     */   {
/* 114 */     Collection values = ((PlayZone)Game.getInstance().getCurrentPlayer().getOpponent().getZone("PLAY")).values();
/* 115 */     for (AbstractCard card : values)
/* 116 */       System.out.println(card);
/*     */   }
/*     */ 
/*     */   public void resourcesQty(List<String> args) throws Exception
/*     */   {
/* 121 */     System.out.println("Numero de resources: " + Game.getInstance().getCurrentPlayer().resourcesQty());
/*     */   }
/*     */ 
/*     */   public void myScore(List<String> args) throws Exception {
/* 125 */     System.out.println("Meu score: " + Game.getInstance().getCurrentPlayer().getScore());
/*     */   }
/*     */ 
/*     */   public void myOpponentScore(List<String> args) throws Exception {
/* 129 */     System.out.println("Opponent score: " + Game.getInstance().getCurrentPlayer().getOpponent().getScore());
/*     */   }
/*     */ 
/*     */   public void abilities(List<String> args) throws Exception {
/* 133 */     AbstractCard card = Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(Integer.valueOf(Integer.parseInt((String)args.get(0))));
/* 134 */     if (card == null) {
/* 135 */       card = Game.getInstance().getCurrentPlayer().getZone("HAND").searchById(Integer.valueOf(Integer.parseInt((String)args.get(0))));
/*     */     }
/* 137 */     System.out.println("Habilidades: ");
/* 138 */     for (Ability ability : card.getAbilities())
/* 139 */       System.out.println(ability.getText());
/*     */   }
/*     */ 
/*     */   public void help(List<String> args) throws Exception
/*     */   {
/* 144 */     Method[] methods = getClass().getMethods();
/* 145 */     for (Method method : methods) {
/* 146 */       if (method.getName() == "wait") {
/*     */         break;
/*     */       }
/* 149 */       System.out.println(method.getName());
/*     */     }
/*     */   }
/*     */ 
/*     */   public CharacterCard defineBlocker()
/*     */   {
/* 155 */     System.out.println(Game.getInstance().getCurrentPlayer().getOpponent().getName());
/* 156 */     System.out.println(" escolha a carta que bloqueara o ataque: ");
/* 157 */     for (AbstractCard c : ((PlayZone)Game.getInstance().getCurrentPlayer().getOpponent().getZone("PLAY")).values()) {
/* 158 */       if ((c instanceof CharacterCard)) {
/* 159 */         System.out.println(c);
/*     */       }
/*     */     }
/*     */ 
/* 163 */     CharacterCard card = (CharacterCard)Game.getInstance().getCurrentPlayer().getOpponent().getZone("PLAY").searchById(Integer.valueOf(Integer.parseInt(Console.getParameter())));
/*     */ 
/* 170 */     return card;
/*     */   }
/*     */ 
/*     */   public CharacterCard defineCharTarget()
/*     */   {
/* 175 */     System.out.println(Game.getInstance().getCurrentPlayer().getOpponent().getName());
/* 176 */     System.out.print("Defina seu alvo: ");
/* 177 */     for (AbstractCard c : ((PlayZone)Game.getInstance().getCurrentPlayer().getOpponent().getZone("PLAY")).values()) {
/* 178 */       System.out.println(c.getName());
/* 179 */       if ((c instanceof CharacterCard)) {
/* 180 */         System.out.println(c);
/*     */       }
/*     */     }
/*     */ 
/* 184 */     for (AbstractCard c : ((PlayZone)Game.getInstance().getCurrentPlayer().getZone("PLAY")).values()) {
/* 185 */       if ((c instanceof CharacterCard)) {
/* 186 */         System.out.println(c);
/*     */       }
/*     */     }
/*     */ 
/* 190 */     Integer param = Integer.valueOf(Integer.parseInt(Console.getParameter()));
/* 191 */     CharacterCard card = (CharacterCard)Game.getInstance().getCurrentPlayer().getZone("PLAY").searchById(param);
/*     */ 
/* 193 */     if (card == null) {
/* 194 */       card = (CharacterCard)Game.getInstance().getOpponent().getZone("PLAY").searchById(param);
/*     */     }
/*     */ 
/* 197 */     return card;
/*     */   }
/*     */ 
/*     */   public static Comandos getInstance() {
/* 201 */     if (instance == null) {
/* 202 */       instance = new Comandos();
/*     */     }
/* 204 */     return instance;
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.console.Comandos
 * JD-Core Version:    0.6.2
 */