/*    */ package br.com.mnemosyne.interfaces;
/*    */ 
/*    */ import br.com.mnemosyne.beans.Effect;
/*    */ import br.com.mnemosyne.beans.Player;
/*    */ import br.com.mnemosyne.events.Event;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public abstract class AbstractPhase
/*    */ {
/*    */   private String name;
/*    */   private LinkedList<Effect> onStartEffects;
/*    */   private LinkedList<Effect> onEndEffects;
/*    */   private LinkedList<Event> permitedEvents;
/*    */   private LinkedList<Event> obligatedEvents;
/*    */ 
/*    */   public abstract void startPhase(Player paramPlayer);
/*    */ 
/*    */   public abstract void endPhase();
/*    */ 
/*    */   public String getName()
/*    */   {
/* 25 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 31 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public LinkedList<Effect> getOnStartEffects()
/*    */   {
/* 37 */     return this.onStartEffects;
/*    */   }
/*    */ 
/*    */   public void setOnStartEffects(LinkedList<Effect> onStartEffects)
/*    */   {
/* 43 */     this.onStartEffects = onStartEffects;
/*    */   }
/*    */ 
/*    */   public LinkedList<Effect> getOnEndEffects()
/*    */   {
/* 49 */     return this.onEndEffects;
/*    */   }
/*    */ 
/*    */   public void setOnEndEffects(LinkedList<Effect> onEndEffects)
/*    */   {
/* 55 */     this.onEndEffects = onEndEffects;
/*    */   }
/*    */ 
/*    */   public LinkedList<Event> getPermitedEvents()
/*    */   {
/* 61 */     return this.permitedEvents;
/*    */   }
/*    */ 
/*    */   public void setPermitedEvents(LinkedList<Event> permitedEvents)
/*    */   {
/* 67 */     this.permitedEvents = permitedEvents;
/*    */   }
/*    */ 
/*    */   public LinkedList<Event> getObligatedEvents()
/*    */   {
/* 73 */     return this.obligatedEvents;
/*    */   }
/*    */ 
/*    */   public void setObligatedEvents(LinkedList<Event> obligatedEvents)
/*    */   {
/* 79 */     this.obligatedEvents = obligatedEvents;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.interfaces.AbstractPhase
 * JD-Core Version:    0.6.2
 */