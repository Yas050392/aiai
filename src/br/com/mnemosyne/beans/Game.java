/*     */ package br.com.mnemosyne.beans;
/*     */ 
/*     */ import br.com.mnemosyne.events.AttackEvent;
/*     */ import br.com.mnemosyne.events.BlockEvent;
/*     */ import br.com.mnemosyne.events.EventService;
/*     */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*     */ import br.com.mnemosyne.interfaces.EnSurpassableDefense;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class Game
/*     */ {
/*     */   private static Game instance;
/*     */   private String name;
/*     */   private Player playerOne;
/*     */   private Player playerTwo;
/*     */   private String resourceOwner;
/*     */   private Integer resourceLimitPerTurn;
/*     */   private LinkedList<AbstractPhase> phases;
/*     */   private Integer currentPhaseIndex;
/*     */   private Integer currentTurn;
/*     */   private Player currentPlayer;
/*  25 */   private Boolean canDefineBlocker = Boolean.valueOf(false);
/*  26 */   private EnSurpassableDefense surpassableDefense = EnSurpassableDefense.NEVER;
/*     */ 
/*     */   public EnSurpassableDefense getSurpassableDefense() {
/*  29 */     return this.surpassableDefense;
/*     */   }
/*     */ 
/*     */   public void setSurpassableDefense(EnSurpassableDefense surpassableDefense) {
/*  33 */     this.surpassableDefense = surpassableDefense;
/*     */   }
/*     */ 
/*     */   public Boolean canDefineBlocker() {
/*  37 */     return this.canDefineBlocker;
/*     */   }
/*     */ 
/*     */   public void defineBlocker(Boolean canChangeAttackTarget) {
/*  41 */     this.canDefineBlocker = canChangeAttackTarget;
/*     */   }
/*     */ 
/*     */   public Player getOpponent(Player from) {
/*  45 */     if (from == getPlayerOne()) {
/*  46 */       return getPlayerTwo();
/*     */     }
/*  48 */     return getPlayerOne();
/*     */   }
/*     */ 
/*     */   public Player getOpponent()
/*     */   {
/*  53 */     if (this.currentPlayer == getPlayerOne()) {
/*  54 */       return getPlayerTwo();
/*     */     }
/*  56 */     return getPlayerOne();
/*     */   }
/*     */ 
/*     */   public static synchronized Game getInstance()
/*     */   {
/*  61 */     if (instance == null) {
/*  62 */       instance = new Game();
/*     */     }
/*  64 */     return instance;
/*     */   }
/*     */ 
/*     */   public static synchronized void dispose() {
/*  68 */     instance = null;
/*     */   }
/*     */ 
/*     */   private Game() {
/*  72 */     this.currentTurn = Integer.valueOf(1);
/*  73 */     this.currentPhaseIndex = Integer.valueOf(0);
/*  74 */     this.phases = new LinkedList(Arrays.asList(new AbstractPhase[] { InitialPhase.getInstance(), MainPhase.getInstance(), BattlePhase.getInstance(), FinalPhase.getInstance() }));
/*     */     try
/*     */     {
/*  80 */       EventService.instance().subscribe(AttackEvent.class, null, new BlockEvent());
/*     */     }
/*     */     catch (Exception e) {
/*  83 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void start() {
/*  88 */     getPlayerOne().getZone("DECK").shuffle();
/*  89 */     getPlayerTwo().getZone("DECK").shuffle();
/*  90 */     ((AbstractPhase)this.phases.getFirst()).startPhase(this.currentPlayer);
/*     */   }
/*     */ 
/*     */   public Player getPlayerOne() {
/*  94 */     return this.playerOne;
/*     */   }
/*     */   public void setPlayerOne(Player playerOne) {
/*  97 */     this.playerOne = playerOne;
/*     */   }
/*     */   public Player getPlayerTwo() {
/* 100 */     return this.playerTwo;
/*     */   }
/*     */   public void setPlayerTwo(Player playerTwo) {
/* 103 */     this.playerTwo = playerTwo;
/*     */   }
/*     */   public String getResourceOwner() {
/* 106 */     return this.resourceOwner;
/*     */   }
/*     */   public void setResourceOwner(String resourceOwner) {
/* 109 */     this.resourceOwner = resourceOwner;
/*     */   }
/*     */   public Integer getResourceLimit() {
/* 112 */     return this.resourceLimitPerTurn;
/*     */   }
/*     */   public void setResourceLimit(Integer resourceLimit) {
/* 115 */     this.resourceLimitPerTurn = resourceLimit;
/*     */   }
/*     */ 
/*     */   public Integer getCurrentPhaseIndex() {
/* 119 */     return this.currentPhaseIndex;
/*     */   }
/*     */ 
/*     */   public AbstractPhase getCurrentPhase() {
/* 123 */     return (AbstractPhase)this.phases.get(this.currentPhaseIndex.intValue());
/*     */   }
/*     */ 
/*     */   public void setCurrentPhaseIndex(Integer currentPhase) {
/* 127 */     this.currentPhaseIndex = currentPhase;
/*     */   }
/*     */ 
/*     */   public void nextPhase() {
/* 131 */     if (this.currentPhaseIndex.intValue() == this.phases.size() - 1) {
/* 132 */       getCurrentPhase().endPhase();
/* 133 */       incrementCurrentTurn();
/* 134 */       this.currentPlayer.resetPlayedResources();
/*     */ 
/* 136 */       getCurrentPhase().startPhase(getOpponent(this.currentPlayer));
/*     */     }
/*     */     else {
/* 139 */       getCurrentPhase().endPhase();
/* 140 */       this.currentPhaseIndex = Integer.valueOf(this.currentPhaseIndex.intValue() + 1);
/* 141 */       getCurrentPhase().startPhase(this.currentPlayer);
/*     */     }
/*     */   }
/*     */ 
/*     */   public Integer getCurrentTurn() {
/* 146 */     return this.currentTurn;
/*     */   }
/*     */ 
/*     */   public void incrementCurrentTurn() {
/* 150 */     this.currentPhaseIndex = Integer.valueOf(0);
/* 151 */     Game localGame = this; (localGame.currentTurn = Integer.valueOf(localGame.currentTurn.intValue() + 1));
/*     */   }
/*     */ 
/*     */   public LinkedList<AbstractPhase> getPhases() {
/* 155 */     return this.phases;
/*     */   }
/*     */ 
/*     */   public void setPhases(LinkedList<AbstractPhase> phases) {
/* 159 */     this.phases = phases;
/*     */   }
/*     */ 
/*     */   public Player getCurrentPlayer() {
/* 163 */     return this.currentPlayer;
/*     */   }
/*     */ 
/*     */   public void setCurrentPlayer(Player currentPlayer) {
/* 167 */     this.currentPlayer = currentPlayer;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 174 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 181 */     this.name = name;
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Game
 * JD-Core Version:    0.6.2
 */