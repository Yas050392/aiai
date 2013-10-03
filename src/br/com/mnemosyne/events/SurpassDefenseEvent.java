/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.CharacterCard;
/*    */ 
/*    */ public class SurpassDefenseEvent extends Event
/*    */ {
/*    */   private String oper;
/*    */ 
/*    */   public void run(CharacterCard card)
/*    */   {
/* 10 */     if (this.oper.equalsIgnoreCase("true"))
/* 11 */       card.setSurpassDefense(Boolean.valueOf(true));
/*    */     else
/* 13 */       card.setSurpassDefense(Boolean.valueOf(false));
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 18 */     if (o == null)
/* 19 */       run((CharacterCard)o);
/* 20 */     else if ((o instanceof CharacterCard))
/* 21 */       run((CharacterCard)o);
/*    */   }
/*    */ 
/*    */   public String getOperation()
/*    */   {
/* 26 */     return this.oper;
/*    */   }
/*    */   public void setOperation(String oper) {
/* 29 */     this.oper = oper;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.SurpassDefenseEvent
 * JD-Core Version:    0.6.2
 */