/*     */ package br.com.mnemosyne.interfaces;
/*     */ 
/*     */ import br.com.mnemosyne.beans.Ability;
/*     */ import br.com.mnemosyne.beans.Condition;
/*     */ import br.com.mnemosyne.beans.Effect;
/*     */ import br.com.mnemosyne.beans.Player;
/*     */ import br.com.mnemosyne.events.Event;
/*     */ import br.com.mnemosyne.events.Subscriber;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public abstract class AbstractCard
/*     */   implements Subscriber
/*     */ {
/*  16 */   private List<String> cost = new Vector();
/*     */   private Zonneable currentLocation;
/*     */   private String name;
/*     */   private Integer uniqId;
/*  20 */   private static Integer currId = Integer.valueOf(1);
/*     */   private String information;
/*  22 */   private EnOrientation orientation = EnOrientation.UNTAPPED;
/*     */   private List<Ability> abilities;
/*     */   private EnAssociationAction onAssociatedDestroy;
/*     */   private EnAssociationAction onAssociatedMove;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  28 */     return this.name;
/*     */   }
/*     */   public void setName(String name) {
/*  31 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public AbstractCard() {
/*  35 */     this.uniqId = currId;
/*  36 */     Integer localInteger1 = currId; Integer localInteger2 = AbstractCard.currId = Integer.valueOf(currId.intValue() + 1);
/*     */   }
/*     */ 
/*     */   public void inform(Event event)
/*     */   {
/*     */     Iterator iterator;
/*  41 */     if (this.abilities != null)
/*  42 */       for (iterator = this.abilities.iterator(); iterator.hasNext(); ) {
/*  43 */         Ability ability = (Ability)iterator.next();
/*     */         Integer localInteger2;
/*  45 */         for (Integer i = Integer.valueOf(0); i.intValue() < ability.getNumberOfEffects().intValue(); localInteger2 = i = Integer.valueOf(i.intValue() + 1)) {
/*  46 */           if (ability.getCondition().getExpectedEvent().getClass().isAssignableFrom(event.getClass()))
/*  47 */             ability.getEffectFromIndex(i).getEvent().run(ability.getEffectFromIndex(i).getTarget());
/*  45 */           localInteger1 = i;
/*     */         }
/*     */       }
/*     */     Integer localInteger1;
/*     */   }
/*     */ 
/*     */   public String getInformation()
/*     */   {
/*  59 */     return this.information;
/*     */   }
/*     */ 
/*     */   public void setInformation(String information)
/*     */   {
/*  65 */     this.information = information;
/*     */   }
/*     */ 
/*     */   public List<Ability> getAbilities()
/*     */   {
/*  71 */     return this.abilities;
/*     */   }
/*     */ 
/*     */   public void addAbility(Ability ability)
/*     */   {
/*  77 */     ability.setFromCard(this);
/*  78 */     if (this.abilities == null) {
/*  79 */       this.abilities = new Vector();
/*     */     }
/*  81 */     this.abilities.add(ability);
/*     */   }
/*     */ 
/*     */   public void useAbility(Integer index) {
/*  85 */     Ability ability = (Ability)this.abilities.get(index.intValue());
/*     */ 
/*  87 */     if (this.currentLocation.getOwner().verifyCost(ability.getCost())) {
/*  88 */       this.currentLocation.getOwner().removeResources(ability.getCost());
/*  89 */       for (int i = 0; i < ability.getNumberOfEffects().intValue(); i++)
/*  90 */         ability.getEffectFromIndex(Integer.valueOf(i)).getEvent().run(ability.getEffectFromIndex(Integer.valueOf(i)).getTarget());
/*     */     }
/*     */     else {
/*  93 */       System.out.println("Voce nao possui resources suficientes para usar esta habilidade!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public Zonneable getCurrentLocation()
/*     */   {
/* 101 */     return this.currentLocation;
/*     */   }
/*     */ 
/*     */   public void setCurrentLocation(Zonneable currentLocation)
/*     */   {
/* 107 */     this.currentLocation = currentLocation;
/*     */   }
/*     */   public EnOrientation getOrientation() {
/* 110 */     return this.orientation;
/*     */   }
/*     */   public void setOrientation(EnOrientation orientation) {
/* 113 */     this.orientation = orientation;
/*     */   }
/*     */ 
/*     */   public List<String> getCost()
/*     */   {
/* 120 */     return this.cost;
/*     */   }
/*     */ 
/*     */   public void addCost(String costType)
/*     */   {
/* 128 */     this.cost.add(costType);
/*     */   }
/*     */ 
/*     */   public EnAssociationAction getOnAssociatedDestroy() {
/* 132 */     return this.onAssociatedDestroy;
/*     */   }
/*     */ 
/*     */   public void setOnAssociatedDestroy(EnAssociationAction associationAction)
/*     */   {
/* 137 */     this.onAssociatedDestroy = associationAction;
/*     */   }
/*     */ 
/*     */   public EnAssociationAction getOnAssociatedMove()
/*     */   {
/* 142 */     return this.onAssociatedMove;
/*     */   }
/*     */ 
/*     */   public void setOnAssociatedMove(EnAssociationAction associationAction) {
/* 146 */     this.onAssociatedMove = associationAction;
/*     */   }
/*     */ 
/*     */   public Integer getUniqId()
/*     */   {
/* 151 */     return this.uniqId;
/*     */   }
/*     */ 
/*     */   public static void resetCurrId() {
/* 155 */     currId = Integer.valueOf(1);
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 160 */     return getUniqId() + "-" + getName() + " - Custo: " + getCost().toString() + " Habilidades: " + getAbilities().size();
/*     */   }
/*     */ 
/*     */   public abstract List<AbstractCard> getAssociatedCards();
/*     */ 
/*     */   public abstract void associateCard(Integer paramInteger, AbstractCard paramAbstractCard);
/*     */ 
/*     */   public abstract void deassociateCard(AbstractCard paramAbstractCard);
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.interfaces.AbstractCard
 * JD-Core Version:    0.6.2
 */