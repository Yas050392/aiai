/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*    */ import java.io.PrintStream;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @XmlRootElement(name="initial")
/*    */ @XmlAccessorType(XmlAccessType.NONE)
/*    */ public class InitialPhase extends AbstractPhase
/*    */ {
/*    */   private static InitialPhase instance;
/*    */ 
/*    */   public static InitialPhase getInstance()
/*    */   {
/* 24 */     if (instance == null) {
/* 25 */       instance = new InitialPhase();
/*    */     }
/* 27 */     return instance;
/*    */   }
/*    */ 
/*    */   public void startPhase(Player player)
/*    */   {
/* 32 */     Game.getInstance().setCurrentPlayer(player);
/*    */ 
/* 35 */     System.out.println("Inicio da Initial Phase");
/*    */   }
/*    */ 
/*    */   public void endPhase()
/*    */   {
/* 43 */     System.out.println("Fim da Initial Phase");
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.InitialPhase
 * JD-Core Version:    0.6.2
 */