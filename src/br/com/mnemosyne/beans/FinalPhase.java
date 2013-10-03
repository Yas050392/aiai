/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*    */ import java.io.PrintStream;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @XmlRootElement(name="final")
/*    */ @XmlAccessorType(XmlAccessType.NONE)
/*    */ public class FinalPhase extends AbstractPhase
/*    */ {
/*    */   private static FinalPhase instance;
/*    */ 
/*    */   public static FinalPhase getInstance()
/*    */   {
/* 20 */     if (instance == null) {
/* 21 */       instance = new FinalPhase();
/*    */     }
/* 23 */     return instance;
/*    */   }
/*    */ 
/*    */   public void startPhase(Player player)
/*    */   {
/* 28 */     Game.getInstance().setCurrentPlayer(player);
/*    */ 
/* 31 */     System.out.println("Inicio da Final Phase");
/*    */   }
/*    */ 
/*    */   public void endPhase()
/*    */   {
/* 38 */     System.out.println("Fim da Final Phase");
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.FinalPhase
 * JD-Core Version:    0.6.2
 */