/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public abstract class Event
/*    */ {
/*    */   private Object source;
/*    */ 
/*    */   public abstract void run(Object paramObject);
/*    */ 
/*    */   public Object getSource()
/*    */   {
/* 21 */     return this.source;
/*    */   }
/*    */ 
/*    */   public void setSource(Object source)
/*    */   {
/* 28 */     this.source = source;
/*    */   }
/*    */ 
/*    */   public boolean respondTo(String methodName)
/*    */   {
/* 33 */     for (Method method : getClass().getMethods()) {
/* 34 */       if (method.getName().contains(methodName)) {
/* 35 */         return true;
/*    */       }
/*    */     }
/* 38 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.Event
 * JD-Core Version:    0.6.2
 */