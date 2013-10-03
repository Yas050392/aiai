/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.events.AttackEvent;
/*     */ import br.com.mnemosyne.events.AttackEvent.AttackTarget;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class CharacterCard extends AbstractCard
/*     */   implements AttackEvent.AttackTarget
/*     */ {
/*  12 */   private HashMap<Integer, AbstractCard> associatedCards = new HashMap();
/*  13 */   private Integer power = Integer.valueOf(0);
/*  14 */   private Integer defense = Integer.valueOf(0);
/*  15 */   private Boolean surpassDefense = Boolean.valueOf(false);
/*     */ 
/*     */   public AbstractCard getAssociatedCard(String name) {
/*  18 */     return (AbstractCard)this.associatedCards.get(name);
/*     */   }
/*     */ 
/*     */   public List<AbstractCard> getAssociatedCards()
/*     */   {
/*  23 */     return new Vector(this.associatedCards.values());
/*     */   }
/*     */ 
/*     */   public void associateCard(Integer uniqId, AbstractCard card)
/*     */   {
/*  28 */     this.associatedCards.put(uniqId, card);
/*  29 */     if (!card.getAssociatedCards().contains(this))
/*  30 */       card.associateCard(getUniqId(), this);
/*     */   }
/*     */ 
/*     */   public void deassociateCard(AbstractCard card)
/*     */   {
/*  36 */     if (this.associatedCards.containsValue(card)) {
/*  37 */       this.associatedCards.remove(card.getUniqId());
/*  38 */       card.deassociateCard(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   public CharacterCard(String name) {
/*  43 */     setName(name);
/*     */   }
/*     */ 
/*     */   public CharacterCard()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void incrementPower(Integer power) {
/*  51 */     CharacterCard localCharacterCard = this; (localCharacterCard.power = Integer.valueOf(localCharacterCard.power.intValue() + power.intValue()));
/*     */   }
/*     */ 
/*     */   public void decrementPower(Integer power) {
/*  55 */     CharacterCard localCharacterCard = this; (localCharacterCard.power = Integer.valueOf(localCharacterCard.power.intValue() - power.intValue()));
/*     */   }
/*     */ 
/*     */   public Integer getPower() {
/*  59 */     return this.power;
/*     */   }
/*     */ 
/*     */   public void incrementDefense(Integer defense) {
/*  63 */     CharacterCard localCharacterCard = this; (localCharacterCard.defense = Integer.valueOf(localCharacterCard.defense.intValue() + defense.intValue()));
/*     */   }
/*     */ 
/*     */   public void decrementDefense(Integer defense) {
/*  67 */     CharacterCard localCharacterCard = this; (localCharacterCard.defense = Integer.valueOf(localCharacterCard.defense.intValue() - defense.intValue()));
/*  68 */     if (this.defense.intValue() <= 0)
/*  69 */       getCurrentLocation().getOwner().destroyCard(this);
/*     */   }
/*     */ 
/*     */   public Integer getDefense()
/*     */   {
/*  74 */     return this.defense;
/*     */   }
/*     */ 
/*     */   public void attack(CharacterCard target)
/*     */   {
/*  79 */     AttackEvent event = new AttackEvent();
/*  80 */     event.setSource(this);
/*  81 */     event.run(target);
/*     */   }
/*     */ 
/*     */   public void attack(Player target) {
/*  85 */     AttackEvent event = new AttackEvent();
/*  86 */     event.setSource(this);
/*  87 */     event.run(target);
/*     */   }
/*     */ 
/*     */   public void decrementScore(Integer score)
/*     */   {
/*  92 */     decrementDefense(score);
/*     */   }
/*     */ 
/*     */   public Boolean getSurpassDefense() {
/*  96 */     return this.surpassDefense;
/*     */   }
/*     */ 
/*     */   public void setSurpassDefense(Boolean surpassDefense) {
/* 100 */     this.surpassDefense = surpassDefense;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 105 */     return super.toString() + " - " + getPower() + "/" + getDefense() + " " + getOrientation();
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.CharacterCard
 * JD-Core Version:    0.6.2
 */