package br.com.deckbuilder.model;


public class Card {
    
            private String id;
/*     */   private String name;
/*     */   private String information;
/*     */   private String cost;
/*     */   private String type;
/*     */   private String power;
/*     */   private String defense;

/*     */ 
/*     */   public String getId()
/*     */   {
/*  21 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/*  25 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  29 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setNome(String name) {
/*  33 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  37 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  41 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getInformacoes() {
/*  45 */     return this.information;
/*     */   }
/*     */ 
/*     */   public void setInformacoes(String information) {
/*  49 */     this.information = information;
/*     */   }
/*     */ 
/*     */   public String getCusto()
/*     */   {
/*  54 */     return this.cost;
/*     */   }
/*     */ 
/*     */   public void setCusto(String cost) {
/*  58 */     this.cost = cost;
/*     */   }
/*     */ 
/*     */   public String getForca() {
/*  62 */     return this.power;
/*     */   }
/*     */ 
/*     */   public void setForca(String power) {
/*  66 */     this.power = power;
/*     */   }
/*     */ 
/*     */   public String getDefesa() {
/*  70 */     return this.defense;
/*     */   }
/*     */ 
/*     */   public void setDefesa(String defense) {
/*  74 */     this.defense = defense;
/*     */   }

}
