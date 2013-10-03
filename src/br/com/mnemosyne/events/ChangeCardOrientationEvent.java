/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ import br.com.mnemosyne.interfaces.Zonneable;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class ChangeCardOrientationEvent extends Event
/*    */ {
/*    */   private String operation;
/*    */   private AbstractCard card;
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 13 */     if ((o instanceof AbstractCard))
/* 14 */       run((AbstractCard)o);
/*    */   }
/*    */ 
/*    */   public void run(AbstractCard card)
/*    */   {
/*    */     try {
/* 20 */       card.getCurrentLocation().getOwner().getClass().getMethod(getOperation() + "Card", new Class[] { AbstractCard.class }).invoke(card.getCurrentLocation().getOwner(), new Object[] { card });
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 24 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getOperation() {
/* 29 */     return this.operation;
/*    */   }
/*    */ 
/*    */   public void setOperation(String operation) {
/* 33 */     this.operation = operation;
/*    */   }
/*    */ 
/*    */   public AbstractCard getCard() {
/* 37 */     return this.card;
/*    */   }
/*    */ 
/*    */   public void setCard(AbstractCard card) {
/* 41 */     this.card = card;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.ChangeCardOrientationEvent
 * JD-Core Version:    0.6.2
 */