/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ 
/*    */ public class Resource
/*    */ {
/*    */   private String type;
/*    */   private AbstractCard generator;
/*    */ 
/*    */   public String getType()
/*    */   {
/* 10 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 14 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public AbstractCard getGenerator() {
/* 18 */     return this.generator;
/*    */   }
/*    */ 
/*    */   public void setGenerator(AbstractCard generator) {
/* 22 */     this.generator = generator;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Resource
 * JD-Core Version:    0.6.2
 */