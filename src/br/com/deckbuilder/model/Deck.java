/*    */ package br.com.deckbuilder.model;
/*    */ 
/*    */ public class Deck
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private String information;
/*    */   private String strategy;
/*    */   private String qtdCards;
/*    */ 
/*    */   public int getId()
/*    */   {
/* 17 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(int id) {
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
/*    */   public String getInformacoes() {
/* 33 */     return this.information;
/*    */   }
/*    */ 
/*    */   public void setInformacoes(String information) {
/* 37 */     this.information = information;
/*    */   }
/*    */ 
/*    */   public String getStrategy() {
/* 41 */     return this.strategy;
/*    */   }
/*    */ 
/*    */   public void setStrategy(String strategy) {
/* 45 */     this.strategy = strategy;
/*    */   }
/*    */ 
/*    */   public String getQtdCards() {
/* 49 */     return this.qtdCards;
/*    */   }
/*    */ 
/*    */   public void setQtdCards(String qtdCards) {
/* 53 */     this.qtdCards = qtdCards;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 57 */     StringBuffer st = new StringBuffer();
/* 58 */     st.append("Codigo: " + getId()).append("\n").append("Nome: " + getNome()).append("\n").append("Informacoeees: " + getInformacoes()).append("\n").append("Estrategia: " + getStrategy()).append("\n").append("Quantidade de Cartas: " + getQtdCards()).append("\n");
/*    */ 
/* 68 */     return st.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.deckbuilder.model.Deck
 * JD-Core Version:    0.6.2
 */