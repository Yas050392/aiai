/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.Ability;
/*    */ import br.com.mnemosyne.beans.Effect;
/*    */ import br.com.mnemosyne.beans.Player;
/*    */ import br.com.mnemosyne.beans.Resource;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class ChangeResourceEvent extends Event
/*    */ {
/*    */   private String operation;
/*    */   private String resourceType;
/*    */ 
/*    */   public void run(Player p)
/*    */   {
/* 12 */     Resource resource = new Resource();
/* 13 */     resource.setGenerator(((Effect)Effect.class.cast(getSource())).getAbility().getFromCard());
/* 14 */     resource.setType(getResourceType());
/*    */     try {
/* 16 */       p.getClass().getMethod(getOperation() + "Resource", new Class[] { Resource.class }).invoke(p, new Object[] { resource });
/*    */     } catch (Exception e) {
/* 18 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 25 */     if ((o instanceof Player))
/* 26 */       run((Player)o);
/*    */   }
/*    */ 
/*    */   public String getOperation() {
/* 30 */     return this.operation;
/*    */   }
/*    */   public void setOperation(String operation) {
/* 33 */     this.operation = operation;
/*    */   }
/*    */   public String getResourceType() {
/* 36 */     return this.resourceType;
/*    */   }
/*    */   public void setResourceType(String resourceType) {
/* 39 */     this.resourceType = resourceType;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.ChangeResourceEvent
 * JD-Core Version:    0.6.2
 */