/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.CharacterCard;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class ChangePowerEvent extends Event
/*    */ {
/*    */   private Integer parameter;
/*    */   private String operation;
/*    */   private CharacterCard target;
/*    */ 
/*    */   public void run(CharacterCard card)
/*    */   {
/*    */     try
/*    */     {
/* 14 */       this.target.getClass().getMethod(getOperation() + "Power", new Class[] { Integer.class }).invoke(this.target, new Object[] { getParameter() });
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 19 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 25 */     if (o == null) {
/* 26 */       run((CharacterCard)o);
/* 27 */     } else if ((o instanceof CharacterCard)) {
/* 28 */       setTarget((CharacterCard)o);
/* 29 */       run(this.target);
/*    */     }
/*    */   }
/*    */ 
/*    */   public Integer getParameter() {
/* 34 */     return this.parameter;
/*    */   }
/*    */ 
/*    */   public void setParameter(Integer parameter)
/*    */   {
/* 41 */     this.parameter = parameter;
/*    */   }
/*    */ 
/*    */   public String getOperation()
/*    */   {
/* 48 */     return this.operation;
/*    */   }
/*    */ 
/*    */   public void setOperation(String operation)
/*    */   {
/* 55 */     this.operation = operation;
/*    */   }
/*    */ 
/*    */   public CharacterCard getTarget() {
/* 59 */     return this.target;
/*    */   }
/*    */ 
/*    */   public void setTarget(CharacterCard target) {
/* 63 */     this.target = target;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.ChangePowerEvent
 * JD-Core Version:    0.6.2
 */