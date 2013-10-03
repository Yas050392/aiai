/*     */ package br.com.mnemosyne.tests;
/*     */ 
/*     */ import br.com.mnemosyne.adapters.CardAdapter;
/*     */ import br.com.mnemosyne.adapters.GameAdapter;
/*     */ import br.com.mnemosyne.adapters.PlayerAdapter;
/*     */ import br.com.mnemosyne.beans.Ability;
/*     */ import br.com.mnemosyne.beans.BattlePhase;
/*     */ import br.com.mnemosyne.beans.CharacterCard;
/*     */ import br.com.mnemosyne.beans.Condition;
/*     */ import br.com.mnemosyne.beans.Effect;
/*     */ import br.com.mnemosyne.beans.FinalPhase;
/*     */ import br.com.mnemosyne.beans.Game;
/*     */ import br.com.mnemosyne.beans.InitialPhase;
/*     */ import br.com.mnemosyne.beans.MainPhase;
/*     */ import br.com.mnemosyne.beans.Player;
/*     */ import br.com.mnemosyne.beans.ResourceCard;
/*     */ import br.com.mnemosyne.events.ChangeCardOrientationEvent;
/*     */ import br.com.mnemosyne.events.ChangeResourceEvent;
/*     */ import br.com.mnemosyne.interfaces.AbstractCard;
/*     */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.junit.Assert;
/*     */ import org.junit.Test;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class ParsingTests
/*     */ {
/*     */   @Test
/*     */   public void cardParsingTeste()
/*     */   {
/*     */     try
/*     */     {
/*  29 */       AbstractCard c = new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/sample-card.xml").getElementsByTagName("card").item(0));
/*     */ 
/*  32 */       Assert.assertTrue(CharacterCard.class.equals(c.getClass()));
/*  33 */       Assert.assertFalse(Integer.valueOf(c.getAbilities().size()).equals(Integer.valueOf(0)));
/*  34 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getFromCard());
/*  35 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)));
/*  36 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getAbility());
/*  37 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getCondition().getFromAbility());
/*  38 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)));
/*  39 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getEvent());
/*  40 */       Assert.assertEquals(2.0D, c.getCost().size(), 0.0D);
/*     */     }
/*     */     catch (Exception e) {
/*  43 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void resourceCardParsing()
/*     */   {
/*     */     try {
/*  50 */       AbstractCard c = new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/resource.xml").getElementsByTagName("card").item(0));
/*     */ 
/*  53 */       Assert.assertTrue(ResourceCard.class.equals(c.getClass()));
/*  54 */       Assert.assertFalse(Integer.valueOf(c.getAbilities().size()).equals(Integer.valueOf(0)));
/*  55 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getFromCard());
/*  56 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getAbility());
/*  57 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)));
/*  58 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getEvent());
/*  59 */       Assert.assertTrue(ChangeCardOrientationEvent.class.equals(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getEvent().getClass()));
/*  60 */       Assert.assertTrue(ChangeResourceEvent.class.equals(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(1)).getEvent().getClass()));
/*     */     } catch (Exception e) {
/*  62 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void playerParsing()
/*     */   {
/*     */     try {
/*  69 */       Player p = new PlayerAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/game.xml").getElementsByTagName("player").item(0));
/*     */ 
/*  72 */       Assert.assertNotNull(p);
/*  73 */       Assert.assertTrue(p.getScore().equals(Integer.valueOf(20)));
/*  74 */       Assert.assertTrue(p.getToLose().equals(Integer.valueOf(0)));
/*     */     } catch (Exception e) {
/*  76 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void resourceCardWithTwoAbilitiesTest()
/*     */   {
/*     */     try {
/*  83 */       AbstractCard c = new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/resource-card-test.xml").getElementsByTagName("card").item(0));
/*     */ 
/*  86 */       Assert.assertTrue(ResourceCard.class.equals(c.getClass()));
/*  87 */       Assert.assertTrue(Integer.valueOf(c.getAbilities().size()).equals(Integer.valueOf(2)));
/*  88 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getFromCard());
/*  89 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getAbility());
/*  90 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)));
/*  91 */       Assert.assertNotNull(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getEvent());
/*  92 */       Assert.assertTrue(ChangeCardOrientationEvent.class.equals(((Ability)c.getAbilities().get(0)).getEffectFromIndex(Integer.valueOf(0)).getEvent().getClass()));
/*  93 */       Assert.assertTrue(ChangeResourceEvent.class.equals(((Ability)c.getAbilities().get(1)).getEffectFromIndex(Integer.valueOf(0)).getEvent().getClass()));
/*     */     } catch (Exception e) {
/*  95 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void gameParsingTest()
/*     */   {
/*     */     try {
/* 102 */       Game game = new GameAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/magic.xml").getElementsByTagName("game").item(0));
/*     */ 
/* 105 */       Assert.assertEquals(4L, game.getPhases().size());
/* 106 */       Assert.assertEquals(InitialPhase.class, ((AbstractPhase)game.getPhases().get(0)).getClass());
/* 107 */       Assert.assertEquals(MainPhase.class, ((AbstractPhase)game.getPhases().get(1)).getClass());
/* 108 */       Assert.assertEquals(BattlePhase.class, ((AbstractPhase)game.getPhases().get(2)).getClass());
/* 109 */       Assert.assertEquals(FinalPhase.class, ((AbstractPhase)game.getPhases().get(3)).getClass());
/*     */ 
/* 111 */       Assert.assertEquals(ChangeCardOrientationEvent.class, ((Effect)((AbstractPhase)game.getPhases().get(0)).getOnStartEffects().get(0)).getEvent().getClass());
/* 112 */       Assert.assertEquals(ChangeResourceEvent.class, ((Effect)((AbstractPhase)game.getPhases().get(3)).getOnEndEffects().get(0)).getEvent().getClass());
/* 113 */       Assert.assertEquals(BattlePhase.class, ((AbstractPhase)game.getPhases().get(2)).getClass());
/* 114 */       Assert.assertEquals(FinalPhase.class, ((AbstractPhase)game.getPhases().get(3)).getClass());
/*     */ 
/* 116 */       Assert.assertEquals(MainPhase.getInstance().getPermitedEvents().size(), 2L);
/* 117 */       Assert.assertEquals(BattlePhase.getInstance().getPermitedEvents().size(), 1L);
/* 118 */       Assert.assertEquals(InitialPhase.getInstance().getObligatedEvents().size(), 1L);
/*     */     }
/*     */     catch (Exception e) {
/* 121 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void parsingCharCardTest()
/*     */   {
/*     */     try {
/* 128 */       AbstractCard c = new CardAdapter().unmarshal((Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("resources/cards/deck1/sample-card.xml").getElementsByTagName("card").item(0));
/*     */ 
/* 131 */       Assert.assertTrue(c.getClass().equals(CharacterCard.class));
/* 132 */       Assert.assertEquals(((CharacterCard)c).getPower().intValue(), 10.0D, 0.0D);
/* 133 */       Assert.assertEquals(((CharacterCard)c).getDefense().intValue(), 5.0D, 0.0D);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 137 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.tests.ParsingTests
 * JD-Core Version:    0.6.2
 */