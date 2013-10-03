/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ @XmlRootElement(name="deck")
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ public class Deck extends LinkedList<AbstractCard>
/*     */   implements Zonneable
/*     */ {
/*     */   private static final long serialVersionUID = -8837239758511973726L;
/*     */ 
/*     */   @XmlAttribute
/*     */   private Integer minCards;
/*     */ 
/*     */   @XmlAttribute
/*     */   private Integer maxCards;
/*     */ 
/*     */   @XmlAttribute
/*     */   private String name;
/*     */   private Player owner;
/*     */ 
/*     */   public AbstractCard getCard(EnLocalPositions fromPosition)
/*     */   {
/*  29 */     if (fromPosition == EnLocalPositions.LAST) {
/*  30 */       return (AbstractCard)removeLast();
/*     */     }
/*     */ 
/*  33 */     return (AbstractCard)removeFirst();
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(AbstractCard card)
/*     */   {
/*  38 */     return (AbstractCard)remove(indexOf(card));
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(Integer uniqId)
/*     */   {
/*  43 */     for (AbstractCard c : this) {
/*  44 */       if (c.getUniqId() == uniqId) {
/*  45 */         return (AbstractCard)remove(indexOf(c));
/*     */       }
/*     */     }
/*  48 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard searchCard(String cardName)
/*     */   {
/*  53 */     for (AbstractCard c : this) {
/*  54 */       if (c.getName().equalsIgnoreCase(cardName)) {
/*  55 */         return (AbstractCard)get(indexOf(c));
/*     */       }
/*     */     }
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard searchById(Integer uniqId)
/*     */   {
/*  63 */     for (AbstractCard c : this) {
/*  64 */       if (c.getUniqId() == uniqId) {
/*  65 */         return (AbstractCard)get(indexOf(c));
/*     */       }
/*     */     }
/*  68 */     return null;
/*     */   }
/*     */ 
/*     */   public void putCard(EnLocalPositions toPosition, AbstractCard card)
/*     */   {
/*  73 */     card.setCurrentLocation(this);
/*  74 */     if (toPosition == EnLocalPositions.FIRST)
/*  75 */       addFirst(card);
/*     */     else
/*  77 */       addLast(card);
/*     */   }
/*     */ 
/*     */   public Zonneable shuffle()
/*     */   {
/*  83 */     Collections.shuffle(this);
/*  84 */     return this;
/*     */   }
/*     */ 
/*     */   public Integer getMinCards() {
/*  88 */     return this.minCards;
/*     */   }
/*     */   public void setMinCards(Integer minCards) {
/*  91 */     this.minCards = minCards;
/*     */   }
/*     */   public Integer getMaxCards() {
/*  94 */     return this.maxCards;
/*     */   }
/*     */   public void setMaxCards(Integer maxCards) {
/*  97 */     this.maxCards = maxCards;
/*     */   }
/*     */ 
/*     */   public Boolean canCardsReturnToGame() {
/* 101 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   public String getZoneName() {
/* 105 */     return this.name;
/*     */   }
/*     */ 
/*     */   public Player getOwner() {
/* 109 */     return this.owner;
/*     */   }
/*     */   public void setOwner(Player p) {
/* 112 */     this.owner = p;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 119 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 125 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Integer getSize() {
/* 129 */     return Integer.valueOf(size());
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Deck
 * JD-Core Version:    0.6.2
 */