/*    */ package br.com.mnemosyne.beans;
/*    */ 
/*    */ import br.com.mnemosyne.interfaces.AbstractCard;
/*    */ import java.util.List;
/*    */ import java.util.Vector;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @XmlRootElement(name="ability")
/*    */ @XmlAccessorType(XmlAccessType.NONE)
/*    */ public class Ability
/*    */ {
/*    */   private String text;
/* 18 */   private List<String> cost = new Vector();
/*    */   private Condition condition;
/* 20 */   private List<Effect> effects = new Vector();
/*    */   private AbstractCard fromCard;
/*    */ 
/*    */   public String getText()
/*    */   {
/* 27 */     return this.text;
/*    */   }
/*    */ 
/*    */   @XmlElement(name="text")
/*    */   public void setText(String text)
/*    */   {
/* 34 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public List<String> getCost()
/*    */   {
/* 40 */     return this.cost;
/*    */   }
/*    */ 
/*    */   public void addCost(String resource)
/*    */   {
/* 46 */     this.cost.add(resource);
/*    */   }
/*    */ 
/*    */   public Condition getCondition()
/*    */   {
/* 52 */     return this.condition;
/*    */   }
/*    */ 
/*    */   @XmlElement(name="condition")
/*    */   public void setCondition(Condition condition)
/*    */   {
/* 59 */     condition.setFromAbility(this);
/* 60 */     this.condition = condition;
/*    */   }
/*    */ 
/*    */   @XmlElement(name="effect")
/*    */   public void setEffect(Effect effect)
/*    */   {
/* 67 */     effect.setAbility(this);
/* 68 */     this.effects.add(effect);
/*    */   }
/*    */ 
/*    */   public Effect getEffectFromIndex(Integer index)
/*    */   {
/* 75 */     return (Effect)this.effects.get(index.intValue());
/*    */   }
/*    */ 
/*    */   public Integer getNumberOfEffects() {
/* 79 */     return Integer.valueOf(this.effects.size());
/*    */   }
/*    */ 
/*    */   public AbstractCard getFromCard()
/*    */   {
/* 86 */     return this.fromCard;
/*    */   }
/*    */ 
/*    */   public void setFromCard(AbstractCard fromCard)
/*    */   {
/* 92 */     this.fromCard = fromCard;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.beans.Ability
 * JD-Core Version:    0.6.2
 */