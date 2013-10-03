/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.adapters.EventAdapter;
/*    */ import br.com.mnemosyne.console.Comandos;
/*    */ import br.com.mnemosyne.events.Event;
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ import br.com.mnemosyne.interfaces.CallbackUserInterface;
/*    */ import br.com.mnemosyne.interfaces.EnSourceAndTarget;
/*    */ import br.com.mnemosyne.interfaces.Zonneable;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*    */ 
/*    */ @XmlRootElement(name="effect")
/*    */ @XmlAccessorType(XmlAccessType.NONE)
/*    */ public class Effect
/*    */ {
/*    */ 
/*    */   @XmlElement(name="target")
/*    */   private EnSourceAndTarget target;
/*    */   private Event event;
/*    */   private Ability fromAbility;
/*    */   private Integer remainingLifetime;
/*    */ 
/*    */   public Object getTarget()
/*    */   {
/* 31 */     switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnSourceAndTarget[this.target.ordinal()]) {
/*    */     case 1:
/* 33 */       return getAbility().getFromCard().getCurrentLocation().getOwner();
/*    */     case 2:
/* 35 */       return getAbility().getFromCard().getCurrentLocation().getOwner().getOpponent();
/*    */     case 3:
/* 37 */       return getAbility().getFromCard();
/*    */     case 4:
/* 39 */       CallbackUserInterface cInterface = Comandos.getInstance();
/* 40 */       return cInterface.defineCharTarget();
/*    */     }
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   public void setTarget(EnSourceAndTarget target)
/*    */   {
/* 47 */     this.target = target;
/*    */   }
/*    */ 
/*    */   public Event getEvent()
/*    */   {
/* 53 */     return this.event;
/*    */   }
/*    */ 
/*    */   @XmlJavaTypeAdapter(EventAdapter.class)
/*    */   @XmlElement(name="event")
/*    */   public void setEvent(Event event)
/*    */   {
/* 62 */     event.setSource(this);
/* 63 */     this.event = event;
/*    */   }
/*    */ 
/*    */   public Ability getAbility()
/*    */   {
/* 70 */     return this.fromAbility;
/*    */   }
/*    */ 
/*    */   public void setAbility(Ability ability)
/*    */   {
/* 76 */     this.fromAbility = ability;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Effect
 * JD-Core Version:    0.6.2
 */