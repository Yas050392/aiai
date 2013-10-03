/*     */ package br.com.mnemosyne.tests;
/*     */ 
/*     */ import br.com.mnemosyne.adapters.CardAdapter;
/*     */ import br.com.mnemosyne.adapters.GameAdapter;
/*     */ import br.com.mnemosyne.beans.Ability;
/*     */ import br.com.mnemosyne.beans.BattlePhase;
/*     */ import br.com.mnemosyne.beans.CharacterCard;
/*     */ import br.com.mnemosyne.beans.Condition;
/*     */ import br.com.mnemosyne.beans.Deck;
/*     */ import br.com.mnemosyne.beans.Effect;
/*     */ import br.com.mnemosyne.beans.EquipCard;
/*     */ import br.com.mnemosyne.beans.FinalPhase;
/*     */ import br.com.mnemosyne.beans.Game;
/*     */ import br.com.mnemosyne.beans.Graveyard;
/*     */ import br.com.mnemosyne.beans.Hand;
/*     */ import br.com.mnemosyne.beans.InitialPhase;
/*     */ import br.com.mnemosyne.beans.MagicCard;
/*     */ import br.com.mnemosyne.beans.MainPhase;
/*     */ import br.com.mnemosyne.beans.PlayZone;
/*     */ import br.com.mnemosyne.beans.Player;
/*     */ import br.com.mnemosyne.beans.ResourceCard;
/*     */ import br.com.mnemosyne.events.AttackEvent;
/*     */ import br.com.mnemosyne.events.BlockEvent;
/*     */ import br.com.mnemosyne.events.ChangeCardOrientationEvent;
/*     */ import br.com.mnemosyne.events.ChangeDefenseEvent;
/*     */ import br.com.mnemosyne.events.ChangePowerEvent;
/*     */ import br.com.mnemosyne.events.ChangeResourceEvent;
/*     */ import br.com.mnemosyne.events.ChangeScoreEvent;
/*     */ import br.com.mnemosyne.events.DieEvent;
/*     */ import br.com.mnemosyne.events.DrawEvent;
/*     */ import br.com.mnemosyne.events.Event;
/*     */ import br.com.mnemosyne.events.EventService;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.EnAssociationAction;
/*     */ import br.com.mnemosyne.interfaces.EnLocalPositions;
/*     */ import br.com.mnemosyne.interfaces.EnOrientation;
/*     */ import br.com.mnemosyne.interfaces.EnSourceAndTarget;
/*     */ import br.com.mnemosyne.interfaces.Zonneable;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.hamcrest.CoreMatchers;
/*     */ import org.junit.Assert;
/*     */ import org.junit.Before;
/*     */ import org.junit.Test;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class Testes
/*     */ {
/*     */   @Before
/*     */   public void limpaTudo()
/*     */   {
/*  58 */     EventService.dispose();
/*  59 */     Game.dispose();
/*  60 */     AbstractCard.resetCurrId();
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testeEmbaralhar() {
/*  65 */     Player p = new Player();
/*  66 */     p.setZone("DECK", new Deck());
/*  67 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta a"));
/*  68 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta b"));
/*  69 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta c"));
/*  70 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta d"));
/*  71 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta e"));
/*  72 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta f"));
/*     */ 
/*  74 */     Deck d = (Deck)((Deck)p.getZone("DECK")).clone();
/*     */ 
/*  76 */     Collections.shuffle(d);
/*     */ 
/*  78 */     Assert.assertThat(d, CoreMatchers.not(CoreMatchers.equalTo((Deck)p.getZone("DECK"))));
/*     */ 
/*  80 */     for (AbstractCard card : d) {
/*  81 */       System.out.println(card.getName());
/*     */     }
/*     */ 
/*  84 */     System.out.println("-----");
/*  85 */     for (AbstractCard card : (Deck)p.getZone("DECK"))
/*  86 */       System.out.println(card.getName());
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testeComprar()
/*     */   {
/*  92 */     Player p = new Player();
/*  93 */     p.setZone("DECK", new Deck());
/*  94 */     AbstractCard f = new CharacterCard("Carta f");
/*  95 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta a"));
/*  96 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta b"));
/*  97 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta c"));
/*  98 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta d"));
/*  99 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, new CharacterCard("Carta e"));
/* 100 */     p.getZone("DECK").putCard(EnLocalPositions.FIRST, f);
/*     */ 
/* 102 */     p.draw(1);
/*     */ 
/* 104 */     Assert.assertEquals(1L, ((Hand)p.getZone("HAND")).size());
/* 105 */     Assert.assertTrue(((Hand)p.getZone("HAND")).containsKey(f.getUniqId()));
/*     */ 
/* 112 */     Assert.assertTrue(((Hand)p.getZone("HAND")).containsValue(f));
/* 113 */     Assert.assertEquals(5L, ((Deck)p.getZone("DECK")).size());
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testePontuacao()
/*     */   {
/* 120 */     Player p = new Player();
/* 121 */     Assert.assertEquals(0.0D, p.getScore().intValue(), 0.0D);
/*     */ 
/* 123 */     p.incrementScore(Integer.valueOf(20));
/* 124 */     Assert.assertEquals(20.0D, p.getScore().intValue(), 0.0D);
/*     */ 
/* 126 */     p.decrementScore(Integer.valueOf(20));
/* 127 */     Assert.assertEquals(0.0D, p.getScore().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testSubscription()
/*     */   {
/* 135 */     AbstractCard c = new CharacterCard(); c.setName("Carta");
/* 136 */     PlayZone pz = new PlayZone(); pz.subscribe(Event.class, null, c);
/* 137 */     Assert.assertEquals(1.0D, pz.subscriptions().intValue(), 0.0D);
/* 138 */     Assert.assertEquals(1.0D, EventService.instance().subscriptions().intValue(), 0.0D);
/*     */ 
/* 140 */     AbstractCard c2 = new CharacterCard(); c2.setName("Carta");
/* 141 */     pz.subscribe(Event.class, null, c2);
/* 142 */     Assert.assertEquals(2.0D, pz.subscriptions().intValue(), 0.0D);
/* 143 */     Assert.assertEquals(1.0D, EventService.instance().subscriptions().intValue(), 0.0D);
/*     */ 
/* 145 */     pz.subscribe(Event.class, null, c);
/* 146 */     Assert.assertEquals(2.0D, pz.subscriptions().intValue(), 0.0D);
/* 147 */     Assert.assertEquals(1.0D, EventService.instance().subscriptions().intValue(), 0.0D);
/*     */ 
/* 149 */     pz.unsubscribe(Event.class, null, c);
/* 150 */     Assert.assertEquals(1.0D, pz.subscriptions().intValue(), 0.0D);
/* 151 */     Assert.assertEquals(1.0D, EventService.instance().subscriptions().intValue(), 0.0D);
/*     */ 
/* 153 */     pz.unsubscribe(Event.class, null, c2);
/* 154 */     Assert.assertEquals(0.0D, pz.subscriptions().intValue(), 0.0D);
/* 155 */     Assert.assertEquals(0.0D, EventService.instance().subscriptions().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testPublish()
/*     */   {
/* 163 */     AbstractCard c = new CharacterCard(); c.setName("Carta Assinante"); c.setInformation("Toda vez que algu�m compra, recebe um de vida");
/* 164 */     PlayZone pz = new PlayZone(); pz.subscribe(DrawEvent.class, null, c);
/* 165 */     Assert.assertEquals(1.0D, pz.subscriptions().intValue(), 0.0D);
/* 166 */     Assert.assertEquals(1.0D, EventService.instance().subscriptions().intValue(), 0.0D);
/*     */ 
/* 168 */     Hand h = new Hand();
/* 169 */     AbstractCard c2 = new CharacterCard(); c2.setName("Carta Noticia"); c2.setInformation("");
/* 170 */     h.putCard(EnLocalPositions.FIRST, c2);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testRun() {
/* 175 */     Player p = new Player();
/* 176 */     p.incrementScore(Integer.valueOf(10));
/* 177 */     AbstractCard c = new CharacterCard();
/* 178 */     c.setName("Carta Assinante");
/* 179 */     Ability a = new Ability();
/* 180 */     Effect e = new Effect();
/* 181 */     e.setTarget(EnSourceAndTarget.OWNER);
/* 182 */     Event event = new ChangeScoreEvent();
/* 183 */     ((ChangeScoreEvent)event).setOperation("increment");
/* 184 */     ((ChangeScoreEvent)event).setParameter(Integer.valueOf(1));
/* 185 */     e.setEvent(event);
/* 186 */     a.setEffect(e);
/* 187 */     Condition cond = new Condition();
/* 188 */     cond.setExpectedEvent(new DrawEvent());
/* 189 */     cond.setExpectedSource(EnSourceAndTarget.OWNER);
/* 190 */     a.setCondition(cond);
/* 191 */     c.addAbility(a);
/* 192 */     p.setZone("play", new PlayZone());
/*     */ 
/* 194 */     Deck tDeck = new Deck();
/* 195 */     p.setZone("deck", tDeck);
/*     */ 
/* 197 */     c.setCurrentLocation(p.getZone("play"));
/* 198 */     ((PlayZone)p.getZone("play")).subscribe(DrawEvent.class, cond, c);
/*     */ 
/* 200 */     Hand h = new Hand();
/* 201 */     h.setOwner(p);
/* 202 */     AbstractCard c2 = new MagicCard(); c2.setName("Carta Noticia"); c2.setInformation("");
/* 203 */     h.putCard(EnLocalPositions.FIRST, c2);
/*     */ 
/* 205 */     Assert.assertEquals(11.0D, p.getScore().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void testGain1Life() {
/* 210 */     Player p = new Player();
/* 211 */     p.setZone("hand", new Hand());
/* 212 */     p.setZone("playZone", new PlayZone());
/* 213 */     AbstractCard c = new CharacterCard(); c.setName("Carta assinante");
/* 214 */     AbstractCard cc = new CharacterCard(); cc.setName("Carta comprada");
/*     */ 
/* 217 */     Ability ab = new Ability();
/*     */ 
/* 219 */     Condition cond = new Condition();
/* 220 */     cond.setExpectedEvent(new DrawEvent());
/* 221 */     cond.setExpectedSource(EnSourceAndTarget.OWNER);
/* 222 */     ab.setCondition(cond);
/*     */ 
/* 224 */     Effect eff = new Effect();
/* 225 */     ChangeScoreEvent cse = new ChangeScoreEvent(); cse.setOperation("increment"); cse.setParameter(Integer.valueOf(1));
/* 226 */     eff.setEvent(cse);
/* 227 */     eff.setTarget(EnSourceAndTarget.OWNER);
/* 228 */     ab.setEffect(eff);
/* 229 */     ab.setText("Quando voce comprar um card, ganhe um de vida");
/*     */ 
/* 231 */     c.addAbility(ab);
/*     */ 
/* 233 */     p.getZone("playZone").putCard(EnLocalPositions.FIRST, c);
/* 234 */     p.getZone("hand").putCard(EnLocalPositions.FIRST, cc);
/*     */   }
/*     */ 
/*     */   public void testParseCardAndGame()
/*     */   {
/*     */     try {
/* 240 */       Game game = new GameAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("resources/magic.xml")).getElementsByTagName("game").item(0));
/*     */ 
/* 242 */       for (int i = 0; i < 3; i++) {
/* 243 */         game.getPlayerOne().getZone("DECK").putCard(EnLocalPositions.FIRST, new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/sample-card.xml").getElementsByTagName("card").item(0)));
/* 244 */         game.getPlayerTwo().getZone("DECK").putCard(EnLocalPositions.FIRST, new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/sample-card.xml").getElementsByTagName("card").item(0)));
/*     */       }
/*     */ 
/* 247 */       Assert.assertNotNull(game);
/* 248 */       Assert.assertNotNull(game.getPlayerOne().getZone("HAND"));
/* 249 */       Assert.assertEquals(game.getPlayerOne().getScore().longValue(), 20L);
/* 250 */       Assert.assertEquals(game.getPlayerTwo().getScore().longValue(), 20L);
/* 251 */       Assert.assertEquals(game.getPlayerOne().getZone("DECK").getSize().longValue(), 3L);
/* 252 */       Assert.assertEquals(game.getPlayerTwo().getZone("DECK").getSize().longValue(), 3L);
/*     */ 
/* 254 */       game.getPlayerOne().draw(1);
/* 255 */       game.getPlayerTwo().draw(1);
/*     */ 
/* 257 */       Assert.assertEquals(game.getPlayerOne().getZone("DECK").getSize().longValue(), 2L);
/* 258 */       Assert.assertEquals(game.getPlayerTwo().getZone("DECK").getSize().longValue(), 2L);
/*     */ 
/* 260 */       Assert.assertEquals(game.getPlayerOne().getZone("HAND").getSize().longValue(), 1L);
/* 261 */       Assert.assertEquals(game.getPlayerTwo().getZone("HAND").getSize().longValue(), 1L);
/*     */ 
/* 263 */       game.getPlayerOne().playCard("Profeta");
/*     */ 
/* 265 */       game.getPlayerOne().draw(2);
/*     */ 
/* 267 */       Assert.assertEquals(game.getPlayerOne().getScore().longValue(), 22L);
/* 268 */       Assert.assertEquals(game.getPlayerTwo().getScore().longValue(), 20L);
/*     */ 
/* 270 */       Assert.assertNull(game.getPlayerOne().getZone("DECK").getCard(EnLocalPositions.FIRST));
/* 271 */       Assert.assertNotNull(game.getPlayerTwo().getZone("DECK").getCard(EnLocalPositions.FIRST));
/*     */ 
/* 273 */       System.out.println(game.getPlayerOne().getName());
/* 274 */       System.out.println(game.getPlayerTwo().getName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 278 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void ResourceTest() {
/* 284 */     Game.getInstance().setResourceLimit(Integer.valueOf(2));
/*     */ 
/* 286 */     Player p = new Player();
/* 287 */     PlayZone pz = new PlayZone(); p.setZone("PLAY", pz);
/* 288 */     Hand h = new Hand(); p.setZone("HAND", h);
/* 289 */     ResourceCard rc = new ResourceCard(); rc.setName("Montanha");
/* 290 */     Ability a = new Ability(); a.setText("Gera uma montanha");
/*     */ 
/* 292 */     Condition condition = new Condition();
/* 293 */     ChangeCardOrientationEvent cco = new ChangeCardOrientationEvent(); cco.setOperation("tap"); cco.setCard(rc);
/* 294 */     condition.setExpectedEvent(cco); condition.setExpectedSource(EnSourceAndTarget.SELF);
/* 295 */     a.setCondition(condition);
/*     */ 
/* 297 */     Effect effect = new Effect();
/* 298 */     ChangeResourceEvent cre = new ChangeResourceEvent(); cre.setSource(rc);
/* 299 */     cre.setOperation("add"); cre.setResourceType("mountain");
/* 300 */     effect.setEvent(cre);
/* 301 */     effect.setTarget(EnSourceAndTarget.OWNER);
/* 302 */     a.setEffect(effect);
/*     */ 
/* 304 */     rc.addAbility(a);
/*     */ 
/* 306 */     h.putCard(EnLocalPositions.FIRST, rc);
/* 307 */     Assert.assertEquals(1.0D, h.getSize().intValue(), 0.0D);
/* 308 */     p.playCard("Montanha");
/*     */ 
/* 311 */     Assert.assertNotNull(p.getZone("PLAY").searchCard("Montanha"));
/*     */ 
/* 313 */     CharacterCard chara = new CharacterCard(); chara.setName("monstro"); chara.addCost("mountain");
/* 314 */     h.putCard(EnLocalPositions.FIRST, chara);
/* 315 */     p.playCard("monstro");
/*     */ 
/* 317 */     Assert.assertNull(p.getZone("PLAY").searchCard("monstro"));
/*     */ 
/* 320 */     p.tapCard(rc);
/* 321 */     Assert.assertEquals(2.0D, p.resourcesQty().intValue(), 0.0D);
/*     */ 
/* 324 */     p.playCard("monstro");
/* 325 */     Assert.assertNotNull(p.getZone("PLAY").searchCard("monstro"));
/*     */ 
/* 328 */     Assert.assertEquals(0.0D, p.resourcesQty().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void twoResourcesTest() {
/* 333 */     Game.getInstance().setResourceLimit(Integer.valueOf(2));
/*     */ 
/* 335 */     Player p = new Player();
/* 336 */     PlayZone pz = new PlayZone(); p.setZone("PLAY", pz);
/* 337 */     Hand h = new Hand(); p.setZone("HAND", h);
/* 338 */     ResourceCard rc = new ResourceCard(); rc.setName("Montanha");
/* 339 */     Ability a = new Ability(); a.setText("Gera uma montanha");
/*     */ 
/* 341 */     Condition condition = new Condition();
/* 342 */     ChangeCardOrientationEvent cco = new ChangeCardOrientationEvent(); cco.setOperation("tap"); cco.setCard(rc);
/* 343 */     condition.setExpectedEvent(cco); condition.setExpectedSource(EnSourceAndTarget.SELF);
/* 344 */     a.setCondition(condition);
/*     */ 
/* 346 */     Effect effect = new Effect();
/* 347 */     ChangeResourceEvent cre = new ChangeResourceEvent(); cre.setSource(rc);
/* 348 */     cre.setOperation("add"); cre.setResourceType("mountain");
/* 349 */     effect.setEvent(cre);
/* 350 */     effect.setTarget(EnSourceAndTarget.OWNER);
/* 351 */     a.setEffect(effect);
/*     */ 
/* 353 */     rc.addAbility(a);
/*     */ 
/* 355 */     h.putCard(EnLocalPositions.FIRST, rc);
/* 356 */     Assert.assertEquals(1.0D, h.getSize().intValue(), 0.0D);
/* 357 */     p.playCard("Montanha");
/* 358 */     Assert.assertEquals(1.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/*     */ 
/* 360 */     ResourceCard rc2 = new ResourceCard(); rc2.setName("Montanha");
/* 361 */     Ability a2 = new Ability(); a2.setText("Gera uma montanha");
/*     */ 
/* 363 */     Condition condition2 = new Condition();
/* 364 */     ChangeCardOrientationEvent cco2 = new ChangeCardOrientationEvent(); cco2.setOperation("tap"); cco2.setCard(rc2);
/* 365 */     condition2.setExpectedEvent(cco2); condition2.setExpectedSource(EnSourceAndTarget.SELF);
/* 366 */     a2.setCondition(condition2);
/*     */ 
/* 368 */     Effect effect2 = new Effect();
/* 369 */     ChangeResourceEvent cre2 = new ChangeResourceEvent(); cre2.setSource(rc2);
/* 370 */     cre2.setOperation("add"); cre2.setResourceType("mountain");
/* 371 */     effect2.setEvent(cre2);
/* 372 */     effect2.setTarget(EnSourceAndTarget.OWNER);
/* 373 */     a2.setEffect(effect2);
/*     */ 
/* 375 */     rc2.addAbility(a2);
/*     */ 
/* 377 */     h.putCard(EnLocalPositions.FIRST, rc2);
/* 378 */     Assert.assertEquals(1.0D, h.getSize().intValue(), 0.0D);
/* 379 */     p.playCard("Montanha");
/* 380 */     Assert.assertEquals(2.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/*     */ 
/* 382 */     CharacterCard chara = new CharacterCard(); chara.setName("monstro"); chara.addCost("mountain");
/* 383 */     h.putCard(EnLocalPositions.FIRST, chara);
/* 384 */     p.playCard("monstro");
/*     */ 
/* 386 */     Assert.assertNull(p.getZone("PLAY").searchCard("monstro"));
/*     */ 
/* 389 */     p.tapCard(rc);
/* 390 */     Assert.assertEquals(2.0D, p.resourcesQty().intValue(), 0.0D);
/* 391 */     p.tapCard(rc2);
/* 392 */     Assert.assertEquals(4.0D, p.resourcesQty().intValue(), 0.0D);
/*     */ 
/* 395 */     p.playCard("monstro");
/* 396 */     Assert.assertNotNull(p.getZone("PLAY").searchCard("monstro"));
/*     */ 
/* 399 */     Assert.assertEquals(2.0D, p.resourcesQty().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void resourceLimitTest() {
/* 404 */     Game.getInstance().setResourceLimit(Integer.valueOf(1));
/*     */ 
/* 406 */     Player p = new Player();
/* 407 */     PlayZone pz = new PlayZone(); p.setZone("PLAY", pz);
/* 408 */     Hand h = new Hand(); p.setZone("HAND", h);
/* 409 */     ResourceCard rc = new ResourceCard(); rc.setName("Montanha");
/* 410 */     Ability a = new Ability(); a.setText("Gera uma montanha");
/*     */ 
/* 412 */     Condition condition = new Condition();
/* 413 */     ChangeCardOrientationEvent cco = new ChangeCardOrientationEvent(); cco.setOperation("tap"); cco.setCard(rc);
/* 414 */     condition.setExpectedEvent(cco); condition.setExpectedSource(EnSourceAndTarget.SELF);
/* 415 */     a.setCondition(condition);
/*     */ 
/* 417 */     Effect effect = new Effect();
/* 418 */     ChangeResourceEvent cre = new ChangeResourceEvent(); cre.setSource(rc);
/* 419 */     cre.setOperation("add"); cre.setResourceType("mountain");
/* 420 */     effect.setEvent(cre);
/* 421 */     effect.setTarget(EnSourceAndTarget.OWNER);
/* 422 */     a.setEffect(effect);
/*     */ 
/* 424 */     rc.addAbility(a);
/*     */ 
/* 426 */     h.putCard(EnLocalPositions.FIRST, rc);
/* 427 */     Assert.assertEquals(1.0D, h.getSize().intValue(), 0.0D);
/* 428 */     p.playCard("Montanha");
/* 429 */     Assert.assertEquals(1.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/*     */ 
/* 432 */     ResourceCard rc2 = new ResourceCard(); rc2.setName("Montanha");
/* 433 */     Ability a2 = new Ability(); a2.setText("Gera uma montanha");
/*     */ 
/* 435 */     Condition condition2 = new Condition();
/* 436 */     ChangeCardOrientationEvent cco2 = new ChangeCardOrientationEvent(); cco2.setOperation("tap"); cco2.setCard(rc2);
/* 437 */     condition2.setExpectedEvent(cco2); condition2.setExpectedSource(EnSourceAndTarget.SELF);
/* 438 */     a2.setCondition(condition2);
/*     */ 
/* 440 */     Effect effect2 = new Effect();
/* 441 */     ChangeResourceEvent cre2 = new ChangeResourceEvent(); cre2.setSource(rc2);
/* 442 */     cre2.setOperation("add"); cre2.setResourceType("mountain");
/* 443 */     effect2.setEvent(cre2);
/* 444 */     effect2.setTarget(EnSourceAndTarget.OWNER);
/* 445 */     a2.setEffect(effect2);
/*     */ 
/* 447 */     rc2.addAbility(a2);
/*     */ 
/* 449 */     h.putCard(EnLocalPositions.FIRST, rc2);
/* 450 */     Assert.assertEquals(1.0D, h.getSize().intValue(), 0.0D);
/* 451 */     p.playCard("Montanha");
/* 452 */     Assert.assertEquals(1.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void associateCardTest() {
/* 457 */     Player p = new Player();
/* 458 */     PlayZone pz = new PlayZone(); p.setZone("PLAY", pz);
/* 459 */     Hand h = new Hand(); p.setZone("HAND", h);
/* 460 */     Graveyard g = new Graveyard(); p.setZone("GRAVEYARD", g);
/*     */ 
/* 462 */     CharacterCard mago = new CharacterCard("Mago");
/* 463 */     mago.setOnAssociatedDestroy(EnAssociationAction.DESTROYIFCHAR);
/* 464 */     mago.setOnAssociatedMove(EnAssociationAction.SAMEACTIONIFCHAR);
/*     */ 
/* 466 */     CharacterCard mago2 = new CharacterCard("Mago2");
/* 467 */     mago2.setOnAssociatedDestroy(EnAssociationAction.DESTROYIFCHAR);
/* 468 */     mago2.setOnAssociatedMove(EnAssociationAction.SAMEACTIONIFCHAR);
/*     */ 
/* 470 */     EquipCard cajado = new EquipCard(); cajado.setName("Cajado");
/* 471 */     cajado.setOnAssociatedDestroy(EnAssociationAction.DESTROY);
/* 472 */     cajado.setOnAssociatedMove(EnAssociationAction.SAMEACTIONIFCHAR);
/*     */ 
/* 474 */     MagicCard bola = new MagicCard(); bola.setName("Bola de fogo");
/* 475 */     bola.setOnAssociatedDestroy(EnAssociationAction.DESTROY);
/* 476 */     bola.setOnAssociatedMove(EnAssociationAction.DESTROY);
/*     */ 
/* 478 */     h.put(mago.getUniqId(), mago); h.put(cajado.getUniqId(), cajado);
/* 479 */     h.put(bola.getUniqId(), bola); h.put(mago2.getUniqId(), mago2);
/*     */ 
/* 481 */     Assert.assertEquals(0.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 482 */     Assert.assertEquals(4.0D, p.getZone("HAND").getSize().intValue(), 0.0D);
/*     */ 
/* 484 */     p.playCard(mago.getName()); p.playCard(cajado.getName());
/* 485 */     mago.associateCard(cajado.getUniqId(), cajado);
/*     */ 
/* 488 */     Assert.assertEquals(2.0D, p.getZone("HAND").getSize().intValue(), 0.0D);
/* 489 */     Assert.assertEquals(2.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 490 */     Assert.assertEquals(1.0D, mago.getAssociatedCards().size(), 0.0D);
/* 491 */     Assert.assertEquals(1.0D, cajado.getAssociatedCards().size(), 0.0D);
/*     */ 
/* 494 */     p.move("PLAY", "HAND", mago.getUniqId(), EnLocalPositions.FIRST);
/* 495 */     Assert.assertEquals(0.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 496 */     Assert.assertEquals(4.0D, p.getZone("HAND").getSize().intValue(), 0.0D);
/* 497 */     Assert.assertEquals(0.0D, mago.getAssociatedCards().size(), 0.0D);
/* 498 */     Assert.assertEquals(0.0D, cajado.getAssociatedCards().size(), 0.0D);
/*     */ 
/* 501 */     p.playCard(mago.getName()); p.playCard(cajado.getName());
/* 502 */     mago.associateCard(cajado.getUniqId(), cajado);
/*     */ 
/* 504 */     p.destroyCard(mago);
/* 505 */     Assert.assertEquals(0.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 506 */     Assert.assertEquals(2.0D, p.getZone("GRAVEYARD").getSize().intValue(), 0.0D);
/* 507 */     Assert.assertEquals(0.0D, mago.getAssociatedCards().size(), 0.0D);
/* 508 */     Assert.assertEquals(0.0D, cajado.getAssociatedCards().size(), 0.0D);
/*     */ 
/* 510 */     p.move("GRAVEYARD", "HAND", EnLocalPositions.FIRST, EnLocalPositions.FIRST);
/* 511 */     Assert.assertEquals(1.0D, p.getZone("GRAVEYARD").getSize().intValue(), 0.0D);
/* 512 */     p.move("GRAVEYARD", "HAND", EnLocalPositions.FIRST, EnLocalPositions.FIRST);
/* 513 */     Assert.assertEquals(0.0D, p.getZone("GRAVEYARD").getSize().intValue(), 0.0D);
/* 514 */     Assert.assertEquals(0.0D, mago.getAssociatedCards().size(), 0.0D);
/* 515 */     Assert.assertEquals(0.0D, cajado.getAssociatedCards().size(), 0.0D);
/*     */ 
/* 518 */     p.playCard(mago.getName()); p.playCard(bola.getName());
/* 519 */     mago.associateCard(bola.getUniqId(), bola);
/*     */ 
/* 521 */     p.destroyCard(bola);
/* 522 */     Assert.assertEquals(1.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 523 */     Assert.assertEquals(1.0D, p.getZone("GRAVEYARD").getSize().intValue(), 0.0D);
/* 524 */     Assert.assertEquals(0.0D, mago.getAssociatedCards().size(), 0.0D);
/* 525 */     Assert.assertEquals(0.0D, bola.getAssociatedCards().size(), 0.0D);
/*     */ 
/* 528 */     p.playCard(mago2.getName());
/* 529 */     mago.associateCard(mago2.getUniqId(), mago2);
/* 530 */     Assert.assertEquals(1.0D, mago.getAssociatedCards().size(), 0.0D);
/* 531 */     Assert.assertEquals(1.0D, mago2.getAssociatedCards().size(), 0.0D);
/* 532 */     p.playCard(cajado.getName());
/* 533 */     mago.associateCard(cajado.getUniqId(), cajado);
/* 534 */     Assert.assertEquals(2.0D, mago.getAssociatedCards().size(), 0.0D);
/* 535 */     Assert.assertEquals(1.0D, cajado.getAssociatedCards().size(), 0.0D);
/* 536 */     Assert.assertEquals(1.0D, mago2.getAssociatedCards().size(), 0.0D);
/*     */ 
/* 539 */     p.destroyCard(cajado);
/* 540 */     Assert.assertEquals(1.0D, mago.getAssociatedCards().size(), 0.0D);
/* 541 */     Assert.assertEquals(0.0D, cajado.getAssociatedCards().size(), 0.0D);
/* 542 */     Assert.assertEquals(1.0D, mago2.getAssociatedCards().size(), 0.0D);
/* 543 */     Assert.assertEquals(2.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 544 */     Assert.assertEquals(2.0D, p.getZone("GRAVEYARD").getSize().intValue(), 0.0D);
/*     */ 
/* 547 */     p.destroyCard(mago2);
/* 548 */     Assert.assertEquals(0.0D, mago.getAssociatedCards().size(), 0.0D);
/* 549 */     Assert.assertEquals(0.0D, mago2.getAssociatedCards().size(), 0.0D);
/* 550 */     Assert.assertEquals(0.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/* 551 */     Assert.assertEquals(4.0D, p.getZone("GRAVEYARD").getSize().intValue(), 0.0D);
/*     */ 
/* 553 */     p.move("GRAVEYARD", "PLAY", EnLocalPositions.FIRST, EnLocalPositions.FIRST);
/* 554 */     p.move("GRAVEYARD", "PLAY", EnLocalPositions.FIRST, EnLocalPositions.FIRST);
/* 555 */     p.move("GRAVEYARD", "PLAY", EnLocalPositions.FIRST, EnLocalPositions.FIRST);
/* 556 */     p.move("GRAVEYARD", "PLAY", EnLocalPositions.FIRST, EnLocalPositions.FIRST);
/*     */ 
/* 559 */     cajado.associateCard(mago.getUniqId(), mago);
/* 560 */     p.move("PLAY", "HAND", cajado.getUniqId(), EnLocalPositions.FIRST);
/* 561 */     Assert.assertEquals(3.0D, p.getZone("PLAY").getSize().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void twoTurnsTest() {
/* 566 */     Player p = new Player(); Player p2 = new Player();
/* 567 */     Game.getInstance().setPlayerOne(p); Game.getInstance().setPlayerTwo(p2);
/* 568 */     Game.getInstance().setCurrentPlayer(Game.getInstance().getPlayerOne());
/*     */ 
/* 571 */     Game.getInstance().start();
/*     */ 
/* 574 */     Assert.assertEquals(1.0D, Game.getInstance().getCurrentTurn().intValue(), 0.0D);
/* 575 */     Assert.assertEquals(p, Game.getInstance().getCurrentPlayer());
/* 576 */     Assert.assertEquals(InitialPhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 578 */     Game.getInstance().nextPhase();
/* 579 */     Assert.assertEquals(MainPhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 581 */     Game.getInstance().nextPhase();
/* 582 */     Assert.assertEquals(BattlePhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 584 */     Game.getInstance().nextPhase();
/* 585 */     Assert.assertEquals(FinalPhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 588 */     Game.getInstance().nextPhase();
/* 589 */     Assert.assertEquals(InitialPhase.getInstance(), Game.getInstance().getCurrentPhase());
/* 590 */     Assert.assertEquals(2.0D, Game.getInstance().getCurrentTurn().intValue(), 0.0D);
/* 591 */     Assert.assertEquals(p2, Game.getInstance().getCurrentPlayer());
/*     */ 
/* 593 */     Game.getInstance().nextPhase();
/* 594 */     Assert.assertEquals(MainPhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 596 */     Game.getInstance().nextPhase();
/* 597 */     Assert.assertEquals(BattlePhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 599 */     Game.getInstance().nextPhase();
/* 600 */     Assert.assertEquals(FinalPhase.getInstance(), Game.getInstance().getCurrentPhase());
/*     */ 
/* 603 */     Game.getInstance().nextPhase();
/* 604 */     Assert.assertEquals(InitialPhase.getInstance(), Game.getInstance().getCurrentPhase());
/* 605 */     Assert.assertEquals(3.0D, Game.getInstance().getCurrentTurn().intValue(), 0.0D);
/* 606 */     Assert.assertEquals(p, Game.getInstance().getCurrentPlayer());
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void uniqIdCardTest() {
/* 611 */     AbstractCard ac = new ResourceCard();
/* 612 */     Assert.assertEquals(1.0D, ac.getUniqId().intValue(), 0.0D);
/* 613 */     AbstractCard ac2 = new CharacterCard();
/* 614 */     Assert.assertEquals(2.0D, ac2.getUniqId().intValue(), 0.0D);
/* 615 */     AbstractCard ac3 = new MagicCard();
/* 616 */     Assert.assertEquals(3.0D, ac3.getUniqId().intValue(), 0.0D);
/* 617 */     AbstractCard ac4 = new EquipCard();
/* 618 */     Assert.assertEquals(4.0D, ac4.getUniqId().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void simpleAttackTest() {
/* 623 */     Player p = new Player(); p.incrementScore(Integer.valueOf(20));
/* 624 */     PlayZone pz = new PlayZone(); p.setZone("PLAY", pz);
/*     */     try
/*     */     {
/* 627 */       EventService.instance().subscribe(AttackEvent.class, null, new BlockEvent());
/*     */     }
/*     */     catch (Exception e) {
/* 630 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 633 */     CharacterCard a = new CharacterCard(); a.incrementPower(Integer.valueOf(5)); a.incrementDefense(Integer.valueOf(1));
/* 634 */     CharacterCard b = new CharacterCard(); b.incrementPower(Integer.valueOf(2)); b.incrementDefense(Integer.valueOf(3));
/*     */ 
/* 636 */     pz.putCard(EnLocalPositions.FIRST, a);
/* 637 */     pz.putCard(EnLocalPositions.FIRST, b);
/*     */ 
/* 639 */     a.attack(b);
/* 640 */     Assert.assertEquals(-2.0D, b.getDefense().intValue(), 0.0D);
/*     */ 
/* 642 */     a.attack(p);
/* 643 */     Assert.assertEquals(15.0D, p.getScore().intValue(), 0.0D);
/*     */ 
/* 645 */     Game.getInstance().defineBlocker(Boolean.valueOf(true));
/* 646 */     a.attack(b);
/* 647 */     Assert.assertEquals(-2.0D, b.getDefense().intValue(), 0.0D);
/* 648 */     Assert.assertEquals(10.0D, p.getScore().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void useAbilityTest()
/*     */   {
/* 655 */     Player p = new Player();
/* 656 */     PlayZone pz = new PlayZone(); p.setZone("PLAY", pz);
/* 657 */     ResourceCard rc = new ResourceCard(); rc.setName("Montanha");
/* 658 */     Ability a = new Ability(); a.setText("Gera uma montanha");
/*     */ 
/* 660 */     Effect effect = new Effect();
/* 661 */     ChangeResourceEvent cre = new ChangeResourceEvent(); cre.setSource(effect);
/* 662 */     cre.setOperation("add"); cre.setResourceType("mountain");
/* 663 */     effect.setEvent(cre);
/* 664 */     effect.setTarget(EnSourceAndTarget.OWNER);
/* 665 */     a.setEffect(effect);
/*     */ 
/* 667 */     Effect effect2 = new Effect();
/* 668 */     ChangeCardOrientationEvent ccd = new ChangeCardOrientationEvent(); ccd.setSource(effect2);
/* 669 */     ccd.setOperation("tap"); ccd.setCard(rc);
/* 670 */     effect2.setEvent(ccd);
/* 671 */     effect2.setTarget(EnSourceAndTarget.SELF);
/* 672 */     a.setEffect(effect2);
/*     */ 
/* 674 */     rc.addAbility(a);
/* 675 */     pz.putCard(EnLocalPositions.FIRST, rc);
/* 676 */     Assert.assertEquals(EnOrientation.UNTAPPED, rc.getOrientation());
/* 677 */     Assert.assertEquals(2.0D, a.getNumberOfEffects().intValue(), 0.0D);
/* 678 */     Assert.assertEquals(1.0D, rc.getAbilities().size(), 0.0D);
/* 679 */     rc.useAbility(Integer.valueOf(0));
/* 680 */     Assert.assertEquals(EnOrientation.TAPPED, rc.getOrientation());
/* 681 */     Assert.assertEquals(2.0D, p.resourcesQty().intValue(), 0.0D);
/*     */   }
/*     */ 
/*     */   @Test
/*     */   public void pickTargetTest() {
/* 686 */     Player p = new Player();
/* 687 */     p.setZone("PLAY", new PlayZone());
/* 688 */     p.setZone("GRAVEYARD", new Graveyard());
/* 689 */     AbstractCard c = new CharacterCard(); c.setName("Carta assinante");
/* 690 */     CharacterCard cc = new CharacterCard(); c.setName("Carta assinante");
/* 691 */     cc.incrementPower(Integer.valueOf(2)); cc.incrementDefense(Integer.valueOf(2));
/*     */ 
/* 694 */     Ability ab = new Ability();
/*     */ 
/* 696 */     Condition cond = new Condition();
/* 697 */     cond.setExpectedEvent(new DieEvent());
/* 698 */     cond.setExpectedSource(EnSourceAndTarget.SELF);
/* 699 */     ab.setCondition(cond);
/*     */ 
/* 701 */     Effect eff = new Effect();
/* 702 */     ChangePowerEvent cpe = new ChangePowerEvent(); cpe.setOperation("decrement"); cpe.setParameter(Integer.valueOf(1)); cpe.setTarget(cc);
/* 703 */     eff.setEvent(cpe);
/* 704 */     eff.setTarget(EnSourceAndTarget.TARGETCREATURE);
/*     */ 
/* 706 */     ab.setEffect(eff);
/* 707 */     Effect eff2 = new Effect();
/* 708 */     ChangeDefenseEvent cde = new ChangeDefenseEvent(); cde.setOperation("decrement"); cde.setParameter(Integer.valueOf(1)); cde.setTarget(cc);
/* 709 */     eff2.setEvent(cde);
/* 710 */     eff2.setTarget(EnSourceAndTarget.TARGETCREATURE);
/*     */ 
/* 712 */     ab.setEffect(eff2);
/* 713 */     ab.setText("Quando morrer, -1/-1 para outra criatura");
/*     */ 
/* 715 */     c.addAbility(ab);
/* 716 */     p.getZone("PLAY").putCard(EnLocalPositions.FIRST, c);
/* 717 */     p.destroyCard(c);
/* 718 */     Assert.assertEquals(1.0D, cc.getPower().intValue(), 0.0D);
/* 719 */     Assert.assertEquals(1.0D, cc.getDefense().intValue(), 0.0D);
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.tests.Testes
 * JD-Core Version:    0.6.2
 */