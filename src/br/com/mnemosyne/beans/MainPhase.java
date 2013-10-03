/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*    */ import java.io.PrintStream;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @XmlRootElement(name="main")
/*    */ @XmlAccessorType(XmlAccessType.NONE)
/*    */ public class MainPhase extends AbstractPhase
/*    */ {
/*    */   private static MainPhase instance;
/*    */ 
/*    */   public static MainPhase getInstance()
/*    */   {
/* 18 */     if (instance == null) {
/* 19 */       instance = new MainPhase();
/*    */     }
/* 21 */     return instance;
/*    */   }
/*    */ 
/*    */   public void startPhase(Player player)
/*    */   {
/* 26 */     Game.getInstance().setCurrentPlayer(player);
/*    */ 
/* 29 */     System.out.println("Inicio da Main Phase");
/*    */   }
/*    */ 
/*    */   public void endPhase()
/*    */   {
/* 36 */     System.out.println("Fim da Main Phase");
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.MainPhase
 * JD-Core Version:    0.6.2
 */