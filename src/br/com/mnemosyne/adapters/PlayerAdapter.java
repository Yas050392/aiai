/*    */ package br.com.mnemosyne.adapters;
/*    */ 
/*    */ import br.com.mnemosyne.beans.Deck;
/*    */ import br.com.mnemosyne.beans.Graveyard;
/*    */ import br.com.mnemosyne.beans.Hand;
/*    */ import br.com.mnemosyne.beans.PlayZone;
/*    */ import br.com.mnemosyne.beans.Player;
/*    */ import javax.xml.bind.JAXBContext;
/*    */ import javax.xml.bind.Unmarshaller;
/*    */ import javax.xml.bind.annotation.adapters.XmlAdapter;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.NamedNodeMap;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class PlayerAdapter extends XmlAdapter<Object, Player>
/*    */ {
/*    */   public Object marshal(Player player)
/*    */     throws Exception
/*    */   {
/* 17 */     return null;
/*    */   }
/*    */ 
/*    */   public Player unmarshal(Object arg0)
/*    */     throws Exception
/*    */   {
/* 23 */     Element element = (Element)arg0;
/* 24 */     Player player = new Player();
/*    */ 
/* 26 */     player.incrementScore(Integer.valueOf(Integer.parseInt(element.getElementsByTagName("score").item(0).getAttributes().getNamedItem("initial").getNodeValue())));
/* 27 */     player.setToLose(Integer.valueOf(Integer.parseInt(element.getElementsByTagName("score").item(0).getAttributes().getNamedItem("toLose").getNodeValue())));
/*    */ 
/* 29 */     for (int i = 0; i < element.getElementsByTagName("deck").getLength(); i++) {
/* 30 */       Deck deck = (Deck)JAXBContext.newInstance(new Class[] { Deck.class }).createUnmarshaller().unmarshal(element.getElementsByTagName("deck").item(i));
/* 31 */       deck.setOwner(player);
/* 32 */       player.setZone(deck.getName(), deck);
/* 33 */       if (i == 0) {
/* 34 */         player.setZone("DECK", deck);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 39 */     for (int i = 0; i < element.getElementsByTagName("graveyard").getLength(); i++) {
/* 40 */       Graveyard grave = (Graveyard)JAXBContext.newInstance(new Class[] { Graveyard.class }).createUnmarshaller().unmarshal(element.getElementsByTagName("graveyard").item(i));
/* 41 */       player.setZone(grave.getZoneName(), grave);
/* 42 */       grave.setOwner(player);
/* 43 */       if (i == 0) {
/* 44 */         player.setZone("GRAVEYARD", grave);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 49 */     for (int i = 0; i < element.getElementsByTagName("hand").getLength(); i++) {
/* 50 */       Hand hand = (Hand)JAXBContext.newInstance(new Class[] { Hand.class }).createUnmarshaller().unmarshal(element.getElementsByTagName("hand").item(i));
/* 51 */       player.setZone(hand.getZoneName(), hand);
/* 52 */       hand.setOwner(player);
/* 53 */       if (i == 0) {
/* 54 */         player.setZone("HAND", hand);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 59 */     for (int i = 0; i < element.getElementsByTagName("playzone").getLength(); i++) {
/* 60 */       PlayZone play = (PlayZone)JAXBContext.newInstance(new Class[] { PlayZone.class }).createUnmarshaller().unmarshal(element.getElementsByTagName("playzone").item(i));
/* 61 */       player.setZone(play.getZoneName(), play);
/* 62 */       play.setOwner(player);
/* 63 */       if (i == 0) {
/* 64 */         player.setZone("PLAY", play);
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 70 */     return player;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.adapters.PlayerAdapter
 * JD-Core Version:    0.6.2
 */