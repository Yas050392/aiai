/*     */ package br.com.deckbuilder.model;
/*     */ 
/*     */ public class CardResource
/*     */ {
/*     */   private String id;
/*     */   private String name;
/*     */   private String txtAbility;
/*     */   private String information;
/*     */   private String cost;
/*     */   private String target;
/*     */   private String oper;
/*     */   private String type;
/*     */   private boolean gravado;
/*     */ 
/*     */   public String getId()
/*     */   {
/*  18 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/*  22 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  26 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setNome(String name) {
/*  30 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getCusto() {
/*  34 */     return this.cost;
/*     */   }
/*     */ 
/*     */   public void setCusto(String cost) {
/*  38 */     this.cost = cost;
/*     */   }
/*     */ 
/*     */   public String getTxtAbility() {
/*  42 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setTxtAbility(String txtAbility) {
/*  46 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getInformacoes() {
/*  50 */     return this.information;
/*     */   }
/*     */ 
/*     */   public void setInformacoes(String information) {
/*  54 */     this.information = information;
/*     */   }
/*     */ 
/*     */   public String getTarget() {
/*  58 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/*  62 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public String getHabilidade() {
/*  66 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setHabilidade(String txtAbility) {
/*  70 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  74 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  78 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getOperHab() {
/*  82 */     return this.oper;
/*     */   }
/*     */ 
/*     */   public void setOperHab(String oper) {
/*  86 */     this.oper = oper;
/*     */   }
/*     */ 
/*     */   public boolean isGravado() {
/*  90 */     return this.gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(boolean gravado) {
/*  94 */     this.gravado = gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(String gravado) {
/*  98 */     if (gravado.equalsIgnoreCase("SIM"))
/*  99 */       this.gravado = true;
/* 100 */     else if (gravado.equalsIgnoreCase("NAO"))
/* 101 */       this.gravado = false;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 106 */     StringBuffer st = new StringBuffer();
/* 107 */     st.append("Codigo: " + getId()).append(" gravado: " + isGravado()).append("\n").append("Nome: " + getNome()).append("\n").append("Informacoeees: " + getInformacoes()).append("\n").append("Habilidade: " + getHabilidade()).append("\n").append("Origem da Habilidade: " + getTarget()).append("\n").append("Operacao da Habilidade: " + getOperHab()).append("\n").append("Valor de Operacao: " + getType()).append("\n");
/*     */ 
/* 122 */     return st.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.deckbuilder.model.CardResource
 * JD-Core Version:    0.6.2
 */