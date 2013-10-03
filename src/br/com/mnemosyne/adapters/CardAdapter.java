/*    */ package br.com.mnemosyne.adapters;
/*    */ 
/*    */ import br.com.mnemosyne.beans.Ability;
/*    */ import br.com.mnemosyne.beans.CharacterCard;
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ import javax.xml.bind.JAXBContext;
/*    */ import javax.xml.bind.Unmarshaller;
/*    */ import javax.xml.bind.annotation.adapters.XmlAdapter;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class CardAdapter extends XmlAdapter<Object, AbstractCard>
/*    */ {
/*    */   public Object marshal(AbstractCard arg0)
/*    */     throws Exception
/*    */   {
/* 17 */     return null;
/*    */   }
/*    */ 
/*    */   public AbstractCard unmarshal(Object arg0) throws Exception
/*    */   {
/* 22 */     Element curr = (Element)arg0;
/* 23 */     String cardName = curr.getAttribute("type");
/* 24 */     cardName = "br.com.mnemosyne.beans." + cardName.replaceFirst(String.valueOf(cardName.charAt(0)), String.valueOf(cardName.toUpperCase().charAt(0))) + "Card";
/* 25 */     AbstractCard c = (AbstractCard)Thread.currentThread().getContextClassLoader().loadClass(cardName).newInstance();
/* 26 */     c.setName(curr.getElementsByTagName("name").item(0).getTextContent());
/*    */ 
/* 28 */     if (curr.getElementsByTagName("cost").item(0) != null) {
/* 29 */       for (String cost : curr.getElementsByTagName("cost").item(0).getTextContent().split(",")) {
/* 30 */         c.addCost(cost);
/*    */       }
/*    */     }
/*    */ 
/* 34 */     NodeList abilities = curr.getElementsByTagName("ability");
/* 35 */     for (int i = 0; i < abilities.getLength(); i++) {
/* 36 */       Ability a = (Ability)JAXBContext.newInstance(new Class[] { Ability.class }).createUnmarshaller().unmarshal((Element)abilities.item(i));
/* 37 */       c.addAbility(a);
/*    */     }
/*    */ 
/* 40 */     if (c.getClass() == CharacterCard.class) {
/* 41 */       ((CharacterCard)c).incrementPower(Integer.valueOf(Integer.parseInt(curr.getElementsByTagName("power").item(0).getTextContent())));
/* 42 */       ((CharacterCard)c).incrementDefense(Integer.valueOf(Integer.parseInt(curr.getElementsByTagName("defense").item(0).getTextContent())));
/*    */     }
/*    */ 
/* 45 */     return c;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.adapters.CardAdapter
 * JD-Core Version:    0.6.2
 */