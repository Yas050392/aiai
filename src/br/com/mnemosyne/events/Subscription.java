/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ public class Subscription
/*    */ {
/*    */   private Class<? extends Event> eventType;
/*    */   private Filter filter;
/*    */   private Subscriber subscriber;
/*    */ 
/*    */   public Subscription(Class<? extends Event> anEventType, Filter aFilter, Subscriber aSubscriber)
/*    */   {
/*  9 */     this.eventType = anEventType;
/* 10 */     this.filter = aFilter;
/* 11 */     this.subscriber = aSubscriber;
/*    */   }
/*    */ 
/*    */   public Subscription()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Class<? extends Event> getEventType()
/*    */   {
/* 21 */     return this.eventType;
/*    */   }
/*    */   public void setEventType(Class<? extends Event> eventType) {
/* 24 */     this.eventType = eventType;
/*    */   }
/*    */   public Filter getFilter() {
/* 27 */     return this.filter;
/*    */   }
/*    */   public void setFilter(Filter filter) {
/* 30 */     this.filter = filter;
/*    */   }
/*    */   public Subscriber getSubscriber() {
/* 33 */     return this.subscriber;
/*    */   }
/*    */   public void setSubscriber(Subscriber subscriber) {
/* 36 */     this.subscriber = subscriber;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 41 */     boolean a = false;
/* 42 */     Subscription s = (Subscription)obj;
/* 43 */     if ((this.eventType == s.eventType) && (this.filter == s.filter) && (this.subscriber == s.subscriber))
/*    */     {
/* 46 */       a = true;
/*    */     }
/* 48 */     return a;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.Subscription
 * JD-Core Version:    0.6.2
 */