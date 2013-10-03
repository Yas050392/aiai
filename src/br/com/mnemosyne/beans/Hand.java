/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.events.DrawEvent;
/*     */ import br.com.mnemosyne.events.EventService;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ @XmlRootElement(name="hand")
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ public class Hand extends HashMap<Integer, AbstractCard>
/*     */   implements Zonneable
/*     */ {
/*     */ 
/*     */   @XmlAttribute
/*     */   private Integer maxCards;
/*     */ 
/*     */   @XmlAttribute
/*     */   private Integer minCards;
/*     */ 
/*     */   @XmlAttribute
/*     */   private String name;
/*     */   private Player owner;
/*     */   private static final long serialVersionUID = -7240276306277137840L;
/*     */ 
/*     */   public AbstractCard getCard(EnLocalPositions fromPosition)
/*     */   {
/*  31 */     AbstractCard card = null;
/*     */     Iterator iterator;
/*  33 */     switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnLocalPositions[fromPosition.ordinal()]) {
/*     */     case 1:
/*  35 */       card = (AbstractCard)values().iterator().next();
/*  36 */       break;
/*     */     case 2:
/*  39 */       for (iterator = values().iterator(); iterator.hasNext(); ) {
/*  40 */         card = (AbstractCard)iterator.next();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  45 */     return (AbstractCard)remove(card.getUniqId());
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(AbstractCard card)
/*     */   {
/*     */     Iterator iterator;
/*  50 */     if (containsValue(card)) {
/*  51 */       for (iterator = values().iterator(); iterator.hasNext(); ) {
/*  52 */         AbstractCard a = (AbstractCard)iterator.next();
/*  53 */         if (a.equals(card)) {
/*  54 */           return (AbstractCard)remove(a.getUniqId());
/*     */         }
/*     */       }
/*     */     }
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(Integer uniqId)
/*     */   {
/*  63 */     return (AbstractCard)remove(uniqId);
/*     */   }
/*     */ 
/*     */   public AbstractCard searchCard(String cardName)
/*     */   {
/*  69 */     for (Iterator iterator = values().iterator(); iterator.hasNext(); ) {
/*  70 */       AbstractCard a = (AbstractCard)iterator.next();
/*  71 */       if (a.getName().equalsIgnoreCase(cardName)) {
/*  72 */         return (AbstractCard)get(a.getUniqId());
/*     */       }
/*     */     }
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard searchById(Integer uniqId)
/*     */   {
/*  80 */     return (AbstractCard)get(uniqId);
/*     */   }
/*     */ 
/*     */   public void putCard(EnLocalPositions toPosition, AbstractCard card)
/*     */   {
/*  85 */     DrawEvent de = new DrawEvent(); de.setSource(getOwner());
/*  86 */     EventService.instance().publish(de);
/*  87 */     put(card.getUniqId(), card);
/*  88 */     card.setCurrentLocation(this);
/*     */   }
/*     */ 
/*     */   public Zonneable shuffle()
/*     */   {
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   public Boolean canCardsReturnToGame()
/*     */   {
/*  98 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   public Player getOwner()
/*     */   {
/* 103 */     return this.owner;
/*     */   }
/*     */ 
/*     */   public void setOwner(Player p)
/*     */   {
/* 108 */     this.owner = p;
/*     */   }
/*     */ 
/*     */   public Integer getMaxCards() {
/* 112 */     return this.maxCards;
/*     */   }
/*     */ 
/*     */   public void setMaxCards(Integer maxCards) {
/* 116 */     this.maxCards = maxCards;
/*     */   }
/*     */ 
/*     */   public Integer getMinCards()
/*     */   {
/* 123 */     return this.minCards;
/*     */   }
/*     */ 
/*     */   public void setMinCards(Integer minCards)
/*     */   {
/* 130 */     this.minCards = minCards;
/*     */   }
/*     */ 
/*     */   public String getZoneName()
/*     */   {
/* 137 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 144 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Integer getSize()
/*     */   {
/* 149 */     return Integer.valueOf(size());
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Hand
 * JD-Core Version:    0.6.2
 */