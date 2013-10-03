/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.events.AttackEvent.AttackTarget;
/*     */ import br.com.mnemosyne.events.ChangeCardOrientationEvent;
/*     */ import br.com.mnemosyne.events.DieEvent;
/*     */ import br.com.mnemosyne.events.EventService;
/*     */ import br.com.mnemosyne.events.GameEndEvent;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.EnOrientation;
/*     */ import br.com.mnemosyne.interfaces.Status;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class Player
/*     */   implements AttackEvent.AttackTarget
/*     */ {
/*     */   private String name;
/*  23 */   private Integer score = Integer.valueOf(0);
/*  24 */   private Integer toLose = Integer.valueOf(0);
/*  25 */   private Integer playedResources = Integer.valueOf(0);
/*     */   private Status status;
/*  27 */   private HashMap<String, Zonneable> zones = new HashMap();
/*  28 */   private HashMap<String, Resource> resourcesPool = new HashMap();
/*     */ 
/*     */   public void draw(int qty) {
/*  31 */     if (getZone("HAND") == null) {
/*  32 */       setZone("HAND", new Hand());
/*     */     }
/*  34 */     for (int i = 0; i < qty; i++)
/*  35 */       move("DECK", "HAND", EnLocalPositions.FIRST, EnLocalPositions.LAST);
/*     */   }
/*     */ 
/*     */   public void playCard(String cardName)
/*     */   {
/*  40 */     AbstractCard card = getZone("HAND").searchCard(cardName);
/*  41 */     if ((card instanceof CharacterCard))
/*  42 */       playCharCard((CharacterCard)card);
/*  43 */     else if ((card instanceof EquipCard))
/*  44 */       playEquipCard((EquipCard)card);
/*  45 */     else if ((card instanceof MagicCard))
/*  46 */       playMagicCard((MagicCard)card);
/*  47 */     else if ((card instanceof ResourceCard))
/*  48 */       playResourceCard((ResourceCard)card);
/*     */   }
/*     */ 
/*     */   private void playCharCard(CharacterCard card)
/*     */   {
/*  54 */     if (verifyCost(card.getCost())) {
/*  55 */       removeResources(card.getCost());
/*  56 */       move("HAND", "PLAY", card.getUniqId(), EnLocalPositions.FIRST);
/*     */     } else {
/*  58 */       System.out.println("Voce nao tem recursos suficiente!");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void playEquipCard(EquipCard card)
/*     */   {
/*  64 */     if (verifyCost(card.getCost())) {
/*  65 */       removeResources(card.getCost());
/*  66 */       move("HAND", "PLAY", card.getUniqId(), EnLocalPositions.FIRST);
/*     */     } else {
/*  68 */       System.out.println("Voce nao tem recursos suficiente!");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void playMagicCard(MagicCard card) {
/*  73 */     if (verifyCost(card.getCost())) {
/*  74 */       removeResources(card.getCost());
/*  75 */       move("HAND", "PLAY", card.getUniqId(), EnLocalPositions.FIRST);
/*     */     } else {
/*  77 */       System.out.println("Voce nao tem recursos suficiente!");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void playResourceCard(ResourceCard card)
/*     */   {
/*     */     Integer localInteger1;
/*  82 */     if (this.playedResources.intValue() < Game.getInstance().getResourceLimit().intValue()) {
/*  83 */       move("HAND", "PLAY", card.getUniqId(), EnLocalPositions.FIRST);
/*  84 */       localInteger1 = this.playedResources; Integer localInteger2 = this.playedResources = Integer.valueOf(this.playedResources.intValue() + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void resetPlayedResources() {
/*  89 */     this.playedResources = Integer.valueOf(0);
/*     */   }
/*     */ 
/*     */   public void destroyCard(AbstractCard card)
/*     */   {
/*  94 */     for (AbstractCard associatedCard : card.getAssociatedCards()) {
/*  95 */       card.deassociateCard(associatedCard);
/*  96 */       switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnAssociationAction[associatedCard.getOnAssociatedDestroy().ordinal()]) {
/*     */       case 1:
/*  98 */         break;
/*     */       case 2:
/* 100 */         if ((card instanceof CharacterCard))
/* 101 */           destroyCard(associatedCard); break;
/*     */       case 3:
/* 105 */         if ((card instanceof CharacterCard))
/* 106 */           destroyCard(associatedCard); break;
/*     */       default:
/* 110 */         destroyCard(associatedCard);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 115 */     move("PLAY", "GRAVEYARD", card.getUniqId(), EnLocalPositions.FIRST);
/* 116 */     if ((card instanceof CharacterCard)) {
/* 117 */       DieEvent event = new DieEvent(); event.setSource(card);
/* 118 */       EventService.instance().publish(event);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void tapCard(AbstractCard card) {
/* 123 */     if (card.getOrientation() != EnOrientation.TAPPED) {
/* 124 */       card.setOrientation(EnOrientation.TAPPED);
/* 125 */       ChangeCardOrientationEvent cco = new ChangeCardOrientationEvent();
/* 126 */       cco.setCard(card); cco.setOperation("tap"); cco.setSource(card);
/* 127 */       EventService.instance().publish(cco);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void untapCard(AbstractCard card) {
/* 132 */     if (card.getOrientation() != EnOrientation.UNTAPPED) {
/* 133 */       card.setOrientation(EnOrientation.UNTAPPED);
/* 134 */       ChangeCardOrientationEvent cco = new ChangeCardOrientationEvent();
/* 135 */       cco.setCard(card); cco.setOperation("untap"); cco.setSource(card);
/* 136 */       EventService.instance().publish(cco);
/*     */     }
/*     */   }
/*     */ 
/* 140 */   public void move(String fromZone, String toZone, Integer uniqId, EnLocalPositions toPosition) { Zonneable zoneFrom = (Zonneable)this.zones.get(fromZone);
/* 141 */     Zonneable zoneTo = (Zonneable)this.zones.get(toZone);
/* 142 */     AbstractCard card = zoneFrom.searchById(uniqId);
/* 143 */     zoneTo.putCard(toPosition, zoneFrom.getCard(card));
/*     */ 
/* 145 */     if (card.getAssociatedCards().size() > 0)
/* 146 */       for (AbstractCard associatedCard : card.getAssociatedCards())
/* 147 */         switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnAssociationAction[associatedCard.getOnAssociatedMove().ordinal()])
/*     */         {
/*     */         case 4:
/* 150 */           card.deassociateCard(associatedCard);
/* 151 */           move(fromZone, toZone, associatedCard.getUniqId(), toPosition);
/* 152 */           break;
/*     */         case 3:
/* 154 */           if ((card instanceof CharacterCard)) {
/* 155 */             card.deassociateCard(associatedCard);
/* 156 */             move(fromZone, toZone, associatedCard.getUniqId(), toPosition); } break;
/*     */         case 5:
/* 161 */           destroyCard(associatedCard);
/* 162 */           break;
/*     */         case 2:
/* 164 */           if ((card instanceof CharacterCard))
/* 165 */             destroyCard(associatedCard); break;
/*     */         case 1:
/* 170 */           card.deassociateCard(associatedCard);
/*     */         }
/*     */   }
/*     */ 
/*     */   public void move(String fromZone, String toZone, EnLocalPositions fromPosition, EnLocalPositions toPosition)
/*     */   {
/* 178 */     Zonneable zoneFrom = (Zonneable)this.zones.get(fromZone);
/* 179 */     Zonneable zoneTo = (Zonneable)this.zones.get(toZone);
/* 180 */     zoneTo.putCard(toPosition, zoneFrom.getCard(fromPosition));
/*     */   }
/*     */   public void shuffleZone(String zoneKey) {
/* 183 */     ((Zonneable)this.zones.get(zoneKey)).shuffle();
/*     */   }
/*     */   public Player getOpponent() {
/* 186 */     return Game.getInstance().getOpponent(this);
/*     */   }
/*     */   public void incrementScore(Integer num) {
/* 189 */     this.score = Integer.valueOf(this.score.intValue() + num.intValue());
/*     */   }
/*     */   public void decrementScore(Integer num) {
/* 192 */     this.score = Integer.valueOf(this.score.intValue() - num.intValue());
/* 193 */     if (this.score.intValue() <= this.toLose.intValue()) {
/* 194 */       this.status = Status.Lost;
/* 195 */       EventService.instance().publish(new GameEndEvent());
/*     */     }
/*     */   }
/*     */ 
/* 199 */   public Zonneable getZone(String name) { return (Zonneable)this.zones.get(name); }
/*     */ 
/*     */   public void setZone(String name, Zonneable zone) {
/* 202 */     this.zones.put(name, zone);
/* 203 */     zone.setOwner(this);
/*     */   }
/*     */   public Status getStatus() {
/* 206 */     return this.status;
/*     */   }
/*     */   public void setStatus(Status status) {
/* 209 */     this.status = status;
/*     */   }
/*     */   public HashMap<String, Zonneable> getZones() {
/* 212 */     return this.zones;
/*     */   }
/*     */   public String getName() {
/* 215 */     return this.name;
/*     */   }
/*     */   public void setName(String name) {
/* 218 */     this.name = name;
/*     */   }
/*     */   public Integer getScore() {
/* 221 */     return this.score;
/*     */   }
/*     */   public void setToLose(Integer toLose) {
/* 224 */     this.toLose = toLose;
/*     */   }
/*     */   public void removeResources(List<String> costList) {
/* 227 */     for (String cost : costList)
/*     */     {
/* 229 */       costValue = null;
/* 230 */       for (String key : this.resourcesPool.keySet()) {
/* 231 */         if (key.contains(cost)) {
/* 232 */           costValue = (Resource)this.resourcesPool.get(key);
/* 233 */           break;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 238 */       for (costIterator = this.resourcesPool.entrySet().iterator(); costIterator.hasNext(); ) {
/* 239 */         Map.Entry entry = (Map.Entry)costIterator.next();
/* 240 */         Resource currValue = (Resource)entry.getValue();
/* 241 */         if (currValue.equals(costValue))
/* 242 */           costIterator.remove(); 
/*     */       }
/*     */     }
/*     */     Resource costValue;
/*     */     Iterator costIterator;
/*     */   }
/*     */ 
/* 250 */   public void addResource(Resource resource) { this.resourcesPool.put(resource.getType() + resource.getGenerator().getUniqId().toString(), resource);
/* 251 */     this.resourcesPool.put("any" + resource.getGenerator().getUniqId().toString(), resource); }
/*     */ 
/*     */   public Integer resourcesQty() {
/* 254 */     return Integer.valueOf(this.resourcesPool.size());
/*     */   }
/*     */ 
/*     */   public boolean verifyCost(List<String> costs)
/*     */   {
/* 259 */     if ((costs.size() > 0) && (resourcesPoolContainsAll(costs)))
/* 260 */       return true;
/* 261 */     if (costs.size() == 0) {
/* 262 */       return true;
/*     */     }
/* 264 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean resourcesPoolContainsAll(List<String> costs) {
/* 268 */     Integer b = Integer.valueOf(0);
/* 269 */     for (Iterator i$ = costs.iterator(); i$.hasNext(); ) { cost = (String)i$.next();
/* 270 */       for (String key : this.resourcesPool.keySet())
/* 271 */         if (key.contains(cost)) {
/* 272 */           localInteger1 = b; Integer localInteger2 = b = Integer.valueOf(b.intValue() + 1);
/*     */         }
/*     */     }
/*     */     String cost;
/*     */     Integer localInteger1;
/* 278 */     if (b.intValue() >= costs.size()) {
/* 279 */       return true;
/*     */     }
/* 281 */     return false;
/*     */   }
/*     */ 
/*     */   public Integer getToLose() {
/* 285 */     return this.toLose;
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Player
 * JD-Core Version:    0.6.2
 */