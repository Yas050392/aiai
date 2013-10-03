/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.Player;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class ChangeScoreEvent extends Event
/*    */ {
/*    */   private Integer parameter;
/*    */   private String operation;
/*    */ 
/*    */   public void run(Player p)
/*    */   {
/*    */     try
/*    */     {
/* 12 */       p.getClass().getMethod(getOperation() + "Score", new Class[] { Integer.class }).invoke(p, new Object[] { getParameter() });
/*    */     } catch (Exception e) {
/* 14 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public Integer getParameter()
/*    */   {
/* 22 */     return this.parameter;
/*    */   }
/*    */ 
/*    */   public void setParameter(Integer parameter)
/*    */   {
/* 29 */     this.parameter = parameter;
/*    */   }
/*    */ 
/*    */   public String getOperation()
/*    */   {
/* 36 */     return this.operation;
/*    */   }
/*    */ 
/*    */   public void setOperation(String operation)
/*    */   {
/* 43 */     this.operation = operation;
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 48 */     if ((o instanceof Player))
/* 49 */       run((Player)o);
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.ChangeScoreEvent
 * JD-Core Version:    0.6.2
 */