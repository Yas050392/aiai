/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.CharacterCard;
/*    */ import br.com.mnemosyne.beans.Player;
/*    */ import br.com.mnemosyne.interfaces.EnOrientation;
/*    */ import br.com.mnemosyne.interfaces.Zonneable;
/*    */ 
/*    */ public class AttackEvent extends Event
/*    */ {
/*    */   private CharacterCard source;
/*    */   private AttackTarget target;
/*    */ 
/*    */   public void run(Player p)
/*    */   {
/* 13 */     this.target = p;
/* 14 */     EventService.instance().publish(this);
/* 15 */     this.target.decrementScore(this.source.getPower());
/*    */ 
/* 17 */     if ((this.target instanceof CharacterCard))
/* 18 */       switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnSurpassableDefense[br.com.mnemosyne.beans.Game.getInstance().getSurpassableDefense().ordinal()]) {
/*    */       case 1:
/* 20 */         if (((CharacterCard)this.target).getOrientation() == EnOrientation.TAPPED)
/* 21 */           ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense()); break;
/*    */       case 2:
/* 26 */         if (((CharacterCard)this.target).getOrientation() == EnOrientation.UNTAPPED)
/* 27 */           ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense()); break;
/*    */       case 3:
/* 32 */         if (this.source.getSurpassDefense().booleanValue())
/* 33 */           ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense()); break;
/*    */       case 4:
/* 38 */         ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense());
/*    */       }
/*    */   }
/*    */ 
/*    */   public void run(CharacterCard card)
/*    */   {
/* 46 */     this.target = card;
/* 47 */     EventService.instance().publish(this);
/* 48 */     this.target.decrementScore(this.source.getPower());
/*    */ 
/* 50 */     if ((this.target instanceof CharacterCard))
/* 51 */       switch (1.$SwitchMap$br$com$mnemosyne$interfaces$EnSurpassableDefense[br.com.mnemosyne.beans.Game.getInstance().getSurpassableDefense().ordinal()]) {
/*    */       case 1:
/* 53 */         if (((CharacterCard)this.target).getOrientation() == EnOrientation.TAPPED)
/* 54 */           ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense()); break;
/*    */       case 2:
/* 59 */         if (((CharacterCard)this.target).getOrientation() == EnOrientation.UNTAPPED)
/* 60 */           ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense()); break;
/*    */       case 3:
/* 65 */         if (this.source.getSurpassDefense().booleanValue())
/* 66 */           ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense()); break;
/*    */       case 4:
/* 71 */         ((CharacterCard)this.target).getCurrentLocation().getOwner().incrementScore(((CharacterCard)this.target).getDefense());
/*    */       }
/*    */   }
/*    */ 
/*    */   public CharacterCard getSource()
/*    */   {
/* 79 */     return this.source;
/*    */   }
/*    */ 
/*    */   public void setSource(CharacterCard source) {
/* 83 */     this.source = source;
/*    */   }
/*    */ 
/*    */   public void setTarget(AttackTarget target) {
/* 87 */     this.target = target;
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 96 */     if ((o instanceof Player))
/* 97 */       run((Player)o);
/* 98 */     else if ((o instanceof CharacterCard))
/* 99 */       run((CharacterCard)o);
/*    */   }
/*    */ 
/*    */   public static abstract interface AttackTarget
/*    */   {
/*    */     public abstract void decrementScore(Integer paramInteger);
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.AttackEvent
 * JD-Core Version:    0.6.2
 */