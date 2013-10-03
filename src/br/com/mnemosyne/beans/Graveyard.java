/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.events.DieEvent;
/*     */ import br.com.mnemosyne.events.EventService;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ @XmlRootElement(name="graveyard")
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ public class Graveyard extends ArrayList<AbstractCard>
/*     */   implements Zonneable
/*     */ {
/*     */ 
/*     */   @XmlAttribute
/*     */   private Boolean backToGame;
/*     */ 
/*     */   @XmlAttribute
/*     */   private String name;
/*     */   private Player owner;
/*     */   private static final long serialVersionUID = 6681554711869139176L;
/*     */ 
/*     */   public AbstractCard getCard(EnLocalPositions fromPosition)
/*     */   {
/*  29 */     if (fromPosition == EnLocalPositions.LAST) {
/*  30 */       return (AbstractCard)remove(size() - 1);
/*     */     }
/*     */ 
/*  33 */     return (AbstractCard)remove(0);
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(AbstractCard card)
/*     */   {
/*  39 */     return (AbstractCard)remove(indexOf(card));
/*     */   }
/*     */ 
/*     */   public AbstractCard getCard(Integer uniqId)
/*     */   {
/*  44 */     for (AbstractCard c : this) {
/*  45 */       if (c.getUniqId() == uniqId) {
/*  46 */         return (AbstractCard)remove(indexOf(c));
/*     */       }
/*     */     }
/*  49 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard searchById(Integer uniqId)
/*     */   {
/*  54 */     for (AbstractCard c : this) {
/*  55 */       if (c.getUniqId() == uniqId) {
/*  56 */         return (AbstractCard)get(indexOf(c));
/*     */       }
/*     */     }
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   public AbstractCard searchCard(String cardName)
/*     */   {
/*  64 */     for (AbstractCard c : this) {
/*  65 */       if (c.getName().equalsIgnoreCase(cardName)) {
/*  66 */         return (AbstractCard)get(indexOf(c));
/*     */       }
/*     */     }
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */   public void putCard(EnLocalPositions toPosition, AbstractCard card)
/*     */   {
/*  74 */     card.setCurrentLocation(this);
/*  75 */     if (toPosition == EnLocalPositions.FIRST)
/*  76 */       add(0, card);
/*     */     else {
/*  78 */       add(size() - 1, card);
/*     */     }
/*  80 */     if ((card instanceof CharacterCard))
/*  81 */       EventService.instance().publish(new DieEvent());
/*     */   }
/*     */ 
/*     */   public Boolean canCardsReturnToGame()
/*     */   {
/*  88 */     return this.backToGame;
/*     */   }
/*     */ 
/*     */   public Zonneable shuffle()
/*     */   {
/*  93 */     Collections.shuffle(this);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   public Player getOwner()
/*     */   {
/*  99 */     return this.owner;
/*     */   }
/*     */ 
/*     */   public void setOwner(Player p) {
/* 103 */     this.owner = p;
/*     */   }
/*     */ 
/*     */   public void setBackToGame(Boolean backToGame) {
/* 107 */     this.backToGame = backToGame;
/*     */   }
/*     */ 
/*     */   public String getZoneName()
/*     */   {
/* 114 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 121 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Integer getSize()
/*     */   {
/* 126 */     return Integer.valueOf(size());
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Graveyard
 * JD-Core Version:    0.6.2
 */