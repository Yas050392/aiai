/*    */ package br.com.deckbuilder.model;
/*    */ 
/*    */ public class CardMagic
/*    */ {
/*    */   private String id;
/*    */   private String name;
/*    */   private String information;
/*    */   private String cost;
/*    */   private String txtAbility;
/*    */   private String target;
/*    */   private String oper;
/*    */   private String type;
/*    */   private boolean gravado;
/*    */ 
/*    */   public String getId()
/*    */   {
/* 17 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(String id) {
/* 21 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getNome() {
/* 25 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setNome(String name) {
/* 29 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getCusto() {
/* 33 */     return this.cost;
/*    */   }
/*    */ 
/*    */   public void setCusto(String cost) {
/* 37 */     this.cost = cost;
/*    */   }
/*    */ 
/*    */   public String getTxtAbility() {
/* 41 */     return this.txtAbility;
/*    */   }
/*    */ 
/*    */   public void setTxtAbility(String txtAbility) {
/* 45 */     this.txtAbility = txtAbility;
/*    */   }
/*    */ 
/*    */   public String getInformacoes() {
/* 49 */     return this.information;
/*    */   }
/*    */ 
/*    */   public void setInformacoes(String information) {
/* 53 */     this.information = information;
/*    */   }
/*    */ 
/*    */   public String getTarget() {
/* 57 */     return this.target;
/*    */   }
/*    */ 
/*    */   public void setTarget(String target) {
/* 61 */     this.target = target;
/*    */   }
/*    */ 
/*    */   public String getHabilidade() {
/* 65 */     return this.txtAbility;
/*    */   }
/*    */ 
/*    */   public void setHabilidade(String txtAbility) {
/* 69 */     this.txtAbility = txtAbility;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 73 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 77 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getOperHab() {
/* 81 */     return this.oper;
/*    */   }
/*    */ 
/*    */   public void setOperHab(String oper) {
/* 85 */     this.oper = oper;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.deckbuilder.model.CardMagic
 * JD-Core Version:    0.6.2
 */