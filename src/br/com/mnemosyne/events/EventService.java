/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class EventService
/*    */ {
/* 13 */   private static EventService singleton = null;
/*    */   private Class<? extends Event> eventClass;
/*    */   protected Vector<Subscription> subscriptions;
/*    */ 
/*    */   private EventService()
/*    */   {
/*  9 */     this.eventClass = Event.class;
/* 10 */     this.subscriptions = new Vector();
/*    */   }
/*    */ 
/*    */   public static synchronized EventService instance()
/*    */   {
/* 17 */     if (singleton == null)
/* 18 */       singleton = new EventService();
/* 19 */     return singleton;
/*    */   }
/*    */ 
/*    */   public static synchronized void dispose() {
/* 23 */     singleton = null;
/*    */   }
/*    */ 
/*    */   public void publish(Event event)
/*    */   {
/* 28 */     for (Enumeration elems = this.subscriptions.elements(); elems.hasMoreElements(); ) {
/* 29 */       Subscription subscription = (Subscription)elems.nextElement();
/* 30 */       if ((subscription.getEventType().isAssignableFrom(event.getClass())) && ((subscription.getFilter() == null) || (subscription.getFilter().apply(event))))
/*    */       {
/* 32 */         subscription.getSubscriber().inform(event);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void subscribe(Class<? extends Event> eventType, Filter filter, Subscriber subscriber) throws Exception {
/* 38 */     if (!this.eventClass.isAssignableFrom(eventType)) {
/* 39 */       throw new Exception();
/*    */     }
/*    */ 
/* 42 */     Subscription subscription = new Subscription(eventType, filter, subscriber);
/* 43 */     if (!this.subscriptions.contains(subscription))
/* 44 */       this.subscriptions.addElement(subscription);
/*    */   }
/*    */ 
/*    */   public void unsubscribe(Class<? extends Event> eventType, Filter filter, Subscriber subscriber) throws Exception
/*    */   {
/* 49 */     if (!this.eventClass.isAssignableFrom(eventType))
/* 50 */       throw new Exception();
/* 51 */     this.subscriptions.removeElement(new Subscription(eventType, filter, subscriber));
/*    */   }
/*    */ 
/*    */   public Integer subscriptions() {
/* 55 */     return Integer.valueOf(this.subscriptions.size());
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.EventService
 * JD-Core Version:    0.6.2
 */