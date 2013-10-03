/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.events.Event;
/*     */ import br.com.mnemosyne.events.EventService;
/*     */ import br.com.mnemosyne.events.Filter;
/*     */ import br.com.mnemosyne.events.Subscriber;
/*     */ import br.com.mnemosyne.events.Subscription;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.EventProxy;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ @XmlRootElement(name="playzone")
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ public class PlayZone extends HashMap<Integer, AbstractCard>
/*     */   implements Zonneable, Subscriber, EventProxy
/*     */ {
/*     */ 
/*     */   @XmlAttribute
/*     */   private String name;
/*     */   private List subscriptions;
/*     */   private Player owner;
/*     */   private static final long serialVersionUID = 3145647566458401746L;
/*     */ 
/*     */   public void subscribe(Class<? extends Event> eventType, Filter filter, Subscriber subscriber)
/*     */   {
/*  34 */     if (this.subscriptions == null) {
/*  35 */       this.subscriptions = new Vector();
/*     */     }
/*     */ 
/*  38 */     if (this.subscriptions.isEmpty()) {
/*     */       try {
/*  40 */         EventService.instance().subscribe(Event.class, null, this);
/*     */       } catch (Exception e) {
/*  42 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  47 */     Subscription subscription = new Subscription(eventType, filter, subscriber);
/*  48 */     if (!this.subscriptions.contains(subscription))
/*  49 */       ((Vector)this.subscriptions).addElement(subscription);
/*     */   }
/*     */ 
/*     */   public void unsubscribe(Class<? extends Event> eventType, Filter filter, Subscriber subscriber)
/*     */   {
/*  55 */     ((Vector)this.subscriptions).removeElement(new Subscription(eventType, filter, subscriber));
/*     */ 
/*  57 */     if (this.subscriptions.isEmpty())
/*     */       try {
/*  59 */         EventService.instance().unsubscribe(eventType, filter, this);
/*     */       } catch (Exception e) {
/*  61 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   public void publish(Event event)
/*     */   {
/*  67 */     for (Enumeration elems = ((Vector)this.subscriptions).elements(); elems.hasMoreElements(); ) {
/*  68 */       Subscription subscription = (Subscription)elems.nextElement();
/*  69 */       if ((subscription.getEventType().isAssignableFrom(event.getClass())) && ((subscription.getFilter() == null) || (subscription.getFilter().apply(event))))
/*     */       {
/*  71 */         subscription.getSubscriber().inform(event);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void inform(Event event)
/*     */   {
/*  78 */     publish(event);
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(EnLocalPositions fromPosition)
/*     */   {
/*  83 */     AbstractCard card = null;
/*     */     Iterator iterator;
/*  84 */     switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnLocalPositions[fromPosition.ordinal()]) {
/*     */     case 1:
/*  86 */       card = (AbstractCard)values().iterator().next();
/*  87 */       break;
/*     */     case 2:
/*  89 */       for (iterator = values().iterator(); iterator.hasNext(); ) {
/*  90 */         card = (AbstractCard)iterator.next();
/*     */       }
/*     */     }
/*     */ 
/*  94 */     return (AbstractCard)remove(card.getUniqId());
/*     */   }
/*     */ 
/*     */   public Integer subscriptions()
/*     */   {
/*  99 */     return Integer.valueOf(this.subscriptions.size());
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(AbstractCard card)
/*     */   {
/*     */     Iterator iterator;
/* 104 */     if (containsValue(card)) {
/* 105 */       for (iterator = values().iterator(); iterator.hasNext(); ) {
/* 106 */         AbstractCard a = (AbstractCard)iterator.next();
/* 107 */         if (a.equals(card)) {
/* 108 */           return (AbstractCard)remove(a.getUniqId());
/*     */         }
/*     */       }
/*     */     }
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(Integer uniqId)
/*     */   {
/* 117 */     return (AbstractCard)remove(uniqId);
/*     */   }
/*     */ 
/*     */   public AbstractCard searchCard(String cardName)
/*     */   {
/* 122 */     for (Iterator iterator = values().iterator(); iterator.hasNext(); ) {
/* 123 */       AbstractCard a = (AbstractCard)iterator.next();
/* 124 */       if (a.getName().equalsIgnoreCase(cardName)) {
/* 125 */         return (AbstractCard)get(a.getUniqId());
/*     */       }
/*     */     }
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard searchById(Integer uniqId)
/*     */   {
/* 133 */     return (AbstractCard)get(uniqId);
/*     */   }
/*     */ 
/*     */   public void putCard(EnLocalPositions toPosition, AbstractCard card)
/*     */   {
/*     */     Iterator iterator;
/* 138 */     if (card.getAbilities() != null) {
/* 139 */       for (iterator = card.getAbilities().iterator(); iterator.hasNext(); ) {
/* 140 */         Ability ability = (Ability)iterator.next();
/* 141 */         if (ability.getCondition() != null) {
/* 142 */           subscribe(ability.getCondition().getExpectedEvent().getClass(), ability.getCondition(), card);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 147 */     put(card.getUniqId(), card);
/* 148 */     card.setCurrentLocation(this);
/*     */   }
/*     */ 
/*     */   public Zonneable shuffle()
/*     */   {
/* 153 */     return this;
/*     */   }
/*     */ 
/*     */   public Boolean canCardsReturnToGame()
/*     */   {
/* 158 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   public Player getOwner()
/*     */   {
/* 163 */     return this.owner;
/*     */   }
/*     */ 
/*     */   public void setOwner(Player p)
/*     */   {
/* 168 */     this.owner = p;
/*     */   }
/*     */ 
/*     */   public String getZoneName()
/*     */   {
/* 175 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String zoneName)
/*     */   {
/* 182 */     this.name = zoneName;
/*     */   }
/*     */ 
/*     */   public Integer getSize()
/*     */   {
/* 187 */     return Integer.valueOf(size());
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.PlayZone
 * JD-Core Version:    0.6.2
 */