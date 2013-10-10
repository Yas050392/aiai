/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deckbuilder.controller;

import br.com.deckbuilder.model.Card;
import javax.swing.JButton;

/**
 *
 * @author Yasmin
 */
public class MinhaCartinha extends JButton{
 
        private Card cartaCorresp;
        
         public Card getCartaCorresp() {
/*  29 */     return this.cartaCorresp;
/*     */   }
/*     */ 
/*     */   public void setCartaCorresp(Card cartaCorresp) {
/*  33 */     this.cartaCorresp = cartaCorresp;
/*     */   }

private static MinhaCartinha singleton;



public static MinhaCartinha getInstance(){
            if(MinhaCartinha.singleton == null){
            MinhaCartinha.singleton = new MinhaCartinha ();
        }
        return MinhaCartinha.singleton;
    }
}
