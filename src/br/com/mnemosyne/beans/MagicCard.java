/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class MagicCard extends AbstractCard
/*    */ {
/*    */   private AbstractCard associatedCard;
/*    */ 
/*    */   public List<AbstractCard> getAssociatedCards()
/*    */   {
/* 14 */     if (this.associatedCard != null) {
/* 15 */       return Arrays.asList(new AbstractCard[] { this.associatedCard });
/*    */     }
/* 17 */     return new Vector();
/*    */   }
/*    */ 
/*    */   public void associateCard(Integer uniqId, AbstractCard card)
/*    */   {
/* 22 */     if (card != this.associatedCard)
/* 23 */       this.associatedCard = card;
/*    */   }
/*    */ 
/*    */   public void deassociateCard(AbstractCard card)
/*    */   {
/* 29 */     if (this.associatedCard != null) {
/* 30 */       this.associatedCard = null;
/* 31 */       card.deassociateCard(this);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.MagicCard
 * JD-Core Version:    0.6.2
 */