/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.CharacterCard;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class ChangeDefenseEvent extends Event
/*    */ {
/*    */   private Integer parameter;
/*    */   private String operation;
/*    */   private CharacterCard target;
/*    */ 
/*    */   public void run(CharacterCard card)
/*    */   {
/*    */     try
/*    */     {
/* 13 */       this.target.getClass().getMethod(getOperation() + "Defense", new Class[] { Integer.class }).invoke(this.target, new Object[] { getParameter() });
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 18 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 24 */     if (o == null) {
/* 25 */       run((CharacterCard)o);
/* 26 */     } else if ((o instanceof CharacterCard)) {
/* 27 */       setTarget((CharacterCard)o);
/* 28 */       run(this.target);
/*    */     }
/*    */   }
/*    */ 
/*    */   public Integer getParameter() {
/* 33 */     return this.parameter;
/*    */   }
/*    */ 
/*    */   public void setParameter(Integer parameter)
/*    */   {
/* 40 */     this.parameter = parameter;
/*    */   }
/*    */ 
/*    */   public String getOperation()
/*    */   {
/* 47 */     return this.operation;
/*    */   }
/*    */ 
/*    */   public void setOperation(String operation)
/*    */   {
/* 54 */     this.operation = operation;
/*    */   }
/*    */ 
/*    */   public CharacterCard getTarget() {
/* 58 */     return this.target;
/*    */   }
/*    */ 
/*    */   public void setTarget(CharacterCard target) {
/* 62 */     this.target = target;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.ChangeDefenseEvent
 * JD-Core Version:    0.6.2
 */