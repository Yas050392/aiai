/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.adapters.EventAdapter;
/*    */ import br.com.mnemosyne.events.Event;
/*    */ import br.com.mnemosyne.events.Filter;
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ import br.com.mnemosyne.interfaces.EnSourceAndTarget;
/*    */ import br.com.mnemosyne.interfaces.Zonneable;
/*    */ import java.lang.reflect.Method;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*    */ 
/*    */ @XmlRootElement(name="condition")
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ public class Condition
/*    */   implements Filter
/*    */ {
/*    */ 
/*    */   @XmlElement(name="source")
/*    */   private EnSourceAndTarget expectedSource;
/*    */ 
/*    */   @XmlJavaTypeAdapter(EventAdapter.class)
/*    */   @XmlElement(name="event")
/*    */   private Event expectedEvent;
/*    */   private Ability fromAbility;
/*    */ 
/*    */   public boolean apply(Event event)
/*    */   {
/* 28 */     if ((this.expectedEvent.getClass().isAssignableFrom(event.getClass())) && (event.getSource() == getExpectedSource()))
/*    */     {
/* 30 */       if ((event.respondTo("getOperation")) && (this.expectedEvent.respondTo("getOperation")))
/*    */         try
/*    */         {
/* 33 */           if (this.expectedEvent.getClass().getMethod("getOperation", null).invoke(this.expectedEvent, null).equals(event.getClass().getMethod("getOperation", null).invoke(this.expectedEvent, null)))
/*    */           {
/* 35 */             return true;
/*    */           }
/*    */         } catch (Exception e) {
/* 38 */           e.printStackTrace();
/*    */         }
/*    */       else {
/* 41 */         return true;
/*    */       }
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */   public Object getExpectedSource()
/*    */   {
/* 52 */     switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnSourceAndTarget[this.expectedSource.ordinal()]) {
/*    */     case 1:
/* 54 */       return getFromAbility().getFromCard().getCurrentLocation().getOwner();
/*    */     case 2:
/* 56 */       return getFromAbility().getFromCard();
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */ 
/*    */   public void setExpectedSource(EnSourceAndTarget source)
/*    */   {
/* 65 */     this.expectedSource = source;
/*    */   }
/*    */ 
/*    */   public Event getExpectedEvent()
/*    */   {
/* 71 */     return this.expectedEvent;
/*    */   }
/*    */ 
/*    */   public void setExpectedEvent(Event event)
/*    */   {
/* 77 */     this.expectedEvent = event;
/*    */   }
/*    */ 
/*    */   public Ability getFromAbility() {
/* 81 */     return this.fromAbility;
/*    */   }
/*    */   public void setFromAbility(Ability fromAbility) {
/* 84 */     this.fromAbility = fromAbility;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Condition
 * JD-Core Version:    0.6.2
 */