package br.com.deckbuilder.model;

public class Ability { 
    
            private String id;
            
            //Primeira Habilidade
/*     */   public String text1;
/*     */   public String target1;//alvo da habilidade - OWNER, TARGETCREATURE, OPPONENT, PLAYER
/*     */   public String no1; //valor da operação
/*     */   public String attr1;//tipo do atributo a ser alterado - changeScore, changePower ou changeDefense
/*     */   public String action1;//tipo da ação a ser feita com a habilidade - increment ou decrement

            //Segunda Habilidade
/*     */   public String text2;
/*     */   public String target2;//alvo da habilidade - OWNER, TARGETCREATURE, OPPONENT, PLAYER
/*     */   public String no2; //valor da operação
/*     */   public String attr2;//tipo do atributo a ser alterado - changeScore, changePower ou changeDefense
/*     */   public String action2;//tipo da ação a ser feita com a habilidade - increment ou decrement

            //Terceira Habilidade
/*     */   public String text3;
/*     */   public String target3;//alvo da habilidade - OWNER, TARGETCREATURE, OPPONENT, PLAYER
/*     */   public String no3; //valor da operação
/*     */   public String attr3;//tipo do atributo a ser alterado - changeScore, changePower ou changeDefense
/*     */   public String action3;//tipo da ação a ser feita com a habilidade - increment ou decrement

            public String getId()
/*     */   {
/*  21 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/*  25 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getText1() {
/*  29 */     return this.text1;
/*     */   }
/*     */ 
/*     */   public void setText1(String text1) {
/*  33 */     this.text1 = text1;
/*     */   }
/*     */   public String getTarget1() {
/*  29 */     return this.target1;
/*     */   }
/*     */ 
/*     */   public void setTarget1(String target1) {
/*  33 */     this.target1 = target1;
/*     */   }

/*     */   public String getNo1() {
/*  29 */     return this.no1;
/*     */   }
/*     */ 
/*     */   public void setNo1(String no1) {
/*  33 */     this.no1 = no1;
/*     */   }

/*     */   public String getAttr1() {
/*  29 */     return this.attr1;
/*     */   }
/*     */ 
/*     */   public void setAttr1(String attr1) {
/*  33 */     this.attr1 = attr1;
/*     */   }

/*     */   public String getAction1() {
/*  29 */     return this.action1;
/*     */   }
/*     */ 
/*     */   public void setAction1(String action1) {
/*  33 */     this.action1 = action1;
/*     */   }

/*     */   public String getText2() {
/*  29 */     return this.text2;
/*     */   }
/*     */ 
/*     */   public void setText2(String text2) {
/*  33 */     this.text2 = text2;
/*     */   }
/*     */   public String getTarget2() {
/*  29 */     return this.target2;
/*     */   }
/*     */ 
/*     */   public void setTarget2(String target2) {
/*  33 */     this.target2 = target2;
/*     */   }

/*     */   public String getNo2() {
/*  29 */     return this.no2;
/*     */   }
/*     */ 
/*     */   public void setNo2(String no2) {
/*  33 */     this.no2 = no2;
/*     */   }

/*     */   public String getAttr2() {
/*  29 */     return this.attr2;
/*     */   }
/*     */ 
/*     */   public void setAttr2(String attr2) {
/*  33 */     this.attr2 = attr2;
/*     */   }

/*     */   public String getAction2() {
/*  29 */     return this.action2;
/*     */   }
/*     */ 
/*     */   public void setAction2(String action2) {
/*  33 */     this.action2 = action2;
/*     */   }

/*     */   public String getText3() {
/*  29 */     return this.text3;
/*     */   }
/*     */ 
/*     */   public void setText3(String text3) {
/*  33 */     this.text3 = text3;
/*     */   }
/*     */   public String getTarget3() {
/*  29 */     return this.target3;
/*     */   }
/*     */ 
/*     */   public void setTarget3(String target3) {
/*  33 */     this.target3 = target3;
/*     */   }

/*     */   public String getNo3() {
/*  29 */     return this.no3;
/*     */   }
/*     */ 
/*     */   public void setNo3(String no3) {
/*  33 */     this.no3 = no3;
/*     */   }

/*     */   public String getAttr3() {
/*  29 */     return this.attr3;
/*     */   }
/*     */ 
/*     */   public void setAttr3(String attr3) {
/*  33 */     this.attr3 = attr3;
/*     */   }

/*     */   public String getAction3() {
/*  29 */     return this.action3;
/*     */   }
/*     */ 
/*     */   public void setAction3(String action3) {
/*  33 */     this.action3 = action3;
/*     */   }

 private static Ability singleton;
/*     */   
/*     */ 
/*     */   public static Ability getInstance()
/*     */   {
/*  27 */     if (singleton == null) {
/*  28 */       singleton = new Ability();
/*     */     }
/*     */ 
/*  31 */     return singleton;
/*     */   }

}
