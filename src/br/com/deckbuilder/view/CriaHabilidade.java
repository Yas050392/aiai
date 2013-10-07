/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deckbuilder.view;

import br.com.deckbuilder.controller.DAOCard;
import br.com.deckbuilder.model.Card;
import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasmin
 */
public class CriaHabilidade extends javax.swing.JFrame implements MouseMotionListener{

/*   21 */   static int posicaoXAumentar = 0;
/*   22 */   static int posicaoYAumentar = 0;
/*      */ 
/*   24 */   static int posicaoXDiminuir = 0;
/*   25 */   static int posicaoYDiminuir = 0;
/*      */ 
/*   27 */   static int posicaoXValor = 0;
/*   28 */   static int posicaoYValor = 0;
/*      */ 
/*   30 */   static int posicaoXAtaque = 0;
/*   31 */   static int posicaoYAtaque = 0;
/*      */ 
/*   33 */   static int posicaoXDefesa = 0;
/*   34 */   static int posicaoYDefesa = 0;
/*      */ 
/*   36 */   static int posicaoXPV = 0;
/*   37 */   static int posicaoYPV = 0;
/*      */ 
/*   39 */   static int posicaoXDestaCarta = 0;
/*   40 */   static int posicaoYDestaCarta = 0;
/*      */ 
/*   42 */   static int posicaoXOutraCartaJogador = 0;
/*   43 */   static int posicaoYOutraCartaJogador = 0;
/*      */ 
/*   45 */   static int posicaoXOutraCartaOponente = 0;
/*   46 */   static int posicaoYOutraCartaOponente = 0;
/*      */ 
/*   48 */   static int posicaoXJogador = 0;
/*   49 */   static int posicaoYJogador = 0;
/*      */ 
/*   51 */   static int posicaoXOponente = 0;
/*   52 */   static int posicaoYOponente = 0;
/*      */ 
/*   55 */   public int flagPrimeiraHab = 0;
/*   56 */   public int flagPrimeiraHab1 = 0;
/*   57 */   public int flagPrimeiraHab2 = 0;
/*   58 */   public int flagPrimeiraHabDiminuir = 0;
/*   59 */   public int flagPrimeiraHabAumentar = 0;
/*   60 */   public int flagPrimeiraHabAtaque = 0;
/*   61 */   public int flagPrimeiraHabDefesa = 0;
/*   62 */   public int flagPrimeiraHabPV = 0;
/*   63 */   public int flagPrimeiraHabDestaCarta = 0;
/*   64 */   public int flagPrimeiraHabOutraCartaJogador = 0;
/*   65 */   public int flagPrimeiraHabOutraCartaOponente = 0;
/*   66 */   public int flagPrimeiraHabJogador = 0;
/*   67 */   public int flagPrimeiraHabOponente = 0;
/*      */ 
/*   70 */   public int flagSegundaHab = 0;
/*   71 */   public int flagSegundaHab1 = 0;
/*   72 */   public int flagSegundaHab2 = 0;
/*   73 */   public int flagSegundaHabDiminuir = 0;
/*   74 */   public int flagSegundaHabAumentar = 0;
/*   75 */   public int flagSegundaHabAtaque = 0;
/*   76 */   public int flagSegundaHabDefesa = 0;
/*   77 */   public int flagSegundaHabPV = 0;
/*   78 */   public int flagSegundaHabDestaCarta = 0;
/*   79 */   public int flagSegundaHabOutraCartaJogador = 0;
/*   80 */   public int flagSegundaHabOutraCartaOponente = 0;
/*   81 */   public int flagSegundaHabJogador = 0;
/*   82 */   public int flagSegundaHabOponente = 0;
/*      */ 
/*   84 */   public int flagTerceiraHab = 0;
/*   85 */   public int flagTerceiraHab1 = 0;
/*   86 */   public int flagTerceiraHab2 = 0;
/*   87 */   public int flagTerceiraHabDiminuir = 0;
/*   88 */   public int flagTerceiraHabAumentar = 0;
/*   89 */   public int flagTerceiraHabAtaque = 0;
/*   90 */   public int flagTerceiraHabDefesa = 0;
/*   91 */   public int flagTerceiraHabPV = 0;
/*   92 */   public int flagTerceiraHabDestaCarta = 0;
/*   93 */   public int flagTerceiraHabOutraCartaJogador = 0;
/*   94 */   public int flagTerceiraHabOutraCartaOponente = 0;
/*   95 */   public int flagTerceiraHabJogador = 0;
/*   96 */   public int flagTerceiraHabOponente = 0;

int baseX = -1;
/*      */ 
/* 1950 */   int baseY = -1;



    public CriaHabilidade() {
        initComponents();
        
        posicaoXAumentar = this.btnAumentar.getX();
/*  103 */     posicaoYAumentar = this.btnAumentar.getY();
/*      */ 
/*  105 */     posicaoXDiminuir = this.btnDiminuir.getX();
/*  106 */     posicaoYDiminuir = this.btnDiminuir.getY();
/*      */ 
/*  108 */     posicaoXValor = this.txtValor.getX();
/*  109 */     posicaoYValor = this.txtValor.getY();
/*      */ 
/*  111 */     posicaoXAtaque = this.btnAtaque.getX();
/*  112 */     posicaoYAtaque = this.btnAtaque.getY();
/*      */ 
/*  114 */     posicaoXDefesa = this.btnDefesa.getX();
/*  115 */     posicaoYDefesa = this.btnDefesa.getY();
/*      */ 
/*  117 */     posicaoXPV = this.btnPV.getX();
/*  118 */     posicaoYPV = this.btnPV.getY();
/*      */ 
/*  120 */     posicaoXDestaCarta = this.btnDestaCarta.getX();
/*  121 */     posicaoYDestaCarta = this.btnDestaCarta.getY();
/*      */ 
/*  123 */     posicaoXOutraCartaJogador = this.btnOutraCartaJogador.getX();
/*  124 */     posicaoYOutraCartaJogador = this.btnOutraCartaJogador.getY();
/*      */ 
/*  126 */     posicaoXOutraCartaOponente = this.btnOutraCartaOponente.getX();
/*  127 */     posicaoYOutraCartaOponente = this.btnOutraCartaOponente.getY();
/*      */ 
/*  129 */     posicaoXJogador = this.btnJogador.getX();
/*  130 */     posicaoYJogador = this.btnJogador.getY();
/*      */ 
/*  132 */     posicaoXOponente = this.btnOponente.getX();
/*  133 */     posicaoYOponente = this.btnOponente.getY();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDiminuir = new javax.swing.JButton();
        btnAtaque = new javax.swing.JButton();
        btnDefesa = new javax.swing.JButton();
        btnPV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnDestaCarta = new javax.swing.JButton();
        btnOutraCartaJogador = new javax.swing.JButton();
        txtValor = new javax.swing.JTextField();
        btnAumentar = new javax.swing.JButton();
        btnOutraCartaOponente = new javax.swing.JButton();
        btnJogador = new javax.swing.JButton();
        btnOponente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        segundaHab = new javax.swing.JPanel();
        lblDiminuir1 = new javax.swing.JLabel();
        lblAumentar1 = new javax.swing.JLabel();
        seta2 = new javax.swing.JLabel();
        lblValor1 = new javax.swing.JLabel();
        seta5 = new javax.swing.JLabel();
        seta8 = new javax.swing.JLabel();
        lblAtaque1 = new javax.swing.JLabel();
        lblDefesa1 = new javax.swing.JLabel();
        lblPV1 = new javax.swing.JLabel();
        lblDestaCarta1 = new javax.swing.JLabel();
        lblOutraCartaJogador1 = new javax.swing.JLabel();
        lblOutraCartaOponente1 = new javax.swing.JLabel();
        lblJogador1 = new javax.swing.JLabel();
        lblOponente1 = new javax.swing.JLabel();
        terceiraHab = new javax.swing.JPanel();
        lblAumentar2 = new javax.swing.JLabel();
        lblDiminuir2 = new javax.swing.JLabel();
        seta3 = new javax.swing.JLabel();
        lblValor2 = new javax.swing.JLabel();
        seta6 = new javax.swing.JLabel();
        seta9 = new javax.swing.JLabel();
        lblAtaque2 = new javax.swing.JLabel();
        lblDefesa2 = new javax.swing.JLabel();
        lblPV2 = new javax.swing.JLabel();
        lblDestaCarta2 = new javax.swing.JLabel();
        lblOutraCartaJogador2 = new javax.swing.JLabel();
        lblOutraCartaOponente2 = new javax.swing.JLabel();
        lblJogador2 = new javax.swing.JLabel();
        lblOponente2 = new javax.swing.JLabel();
        primeiraHab = new javax.swing.JPanel();
        lblAumentar = new javax.swing.JLabel();
        seta1 = new javax.swing.JLabel();
        lblDiminuir = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        seta4 = new javax.swing.JLabel();
        seta7 = new javax.swing.JLabel();
        lblAtaque = new javax.swing.JLabel();
        lblDefesa = new javax.swing.JLabel();
        lblPV = new javax.swing.JLabel();
        lblDestaCarta = new javax.swing.JLabel();
        lblOutraCartaJogador = new javax.swing.JLabel();
        lblOutraCartaOponente = new javax.swing.JLabel();
        lblJogador = new javax.swing.JLabel();
        lblOponente = new javax.swing.JLabel();
        btnSalvarHab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Habilidades da carta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, -1));

        jLabel3.setText("carta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 60, -1));

        jLabel4.setText("Você pode escolher até 3 habilidades para cada carta.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel5.setText("Ação:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jLabel6.setText("Atributos a serem modificados:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));

        jLabel7.setText("Alvo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        btnDiminuir.setText("Diminuir");
        btnDiminuir.setName("btnDiminuir"); // NOI18N
        btnDiminuir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDiminuirMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDiminuirMousePressed(evt);
            }
        });
        btnDiminuir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnDiminuirMouseDragged(evt);
            }
        });
        getContentPane().add(btnDiminuir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        btnAtaque.setText("de Força");
        btnAtaque.setName("btnAtaque"); // NOI18N
        btnAtaque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAtaqueMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAtaqueMousePressed(evt);
            }
        });
        btnAtaque.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnAtaqueMouseDragged(evt);
            }
        });
        getContentPane().add(btnAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, -1, -1));

        btnDefesa.setText("de Defesa");
        btnDefesa.setName("btnDefesa"); // NOI18N
        btnDefesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDefesaMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDefesaMousePressed(evt);
            }
        });
        btnDefesa.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnDefesaMouseDragged(evt);
            }
        });
        getContentPane().add(btnDefesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, -1, -1));

        btnPV.setText("Pontos de Vida");
        btnPV.setName("btnPV"); // NOI18N
        btnPV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPVMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPVMousePressed(evt);
            }
        });
        btnPV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnPVMouseDragged(evt);
            }
        });
        getContentPane().add(btnPV, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        jLabel8.setText("Valor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, 20));

        btnDestaCarta.setLabel("Desta Carta");
        btnDestaCarta.setName("btnDestaCarta"); // NOI18N
        btnDestaCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDestaCartaMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDestaCartaMousePressed(evt);
            }
        });
        btnDestaCarta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnDestaCartaMouseDragged(evt);
            }
        });
        getContentPane().add(btnDestaCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        btnOutraCartaJogador.setLabel("de Outra Carta do Jogador");
        btnOutraCartaJogador.setName("btnOutraCartaJogador"); // NOI18N
        btnOutraCartaJogador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOutraCartaJogadorMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOutraCartaJogadorMousePressed(evt);
            }
        });
        btnOutraCartaJogador.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnOutraCartaJogadorMouseDragged(evt);
            }
        });
        getContentPane().add(btnOutraCartaJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        txtValor.setName("txtValor"); // NOI18N
        txtValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtValorMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtValorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtValorMousePressed(evt);
            }
        });
        txtValor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txtValorMouseDragged(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 30, -1));

        btnAumentar.setText("Aumentar");
        btnAumentar.setName("btnAumentar"); // NOI18N
        btnAumentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAumentarMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAumentarMousePressed(evt);
            }
        });
        btnAumentar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnAumentarMouseDragged(evt);
            }
        });
        getContentPane().add(btnAumentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        btnOutraCartaOponente.setLabel("de Outra Carta do Oponente");
        btnOutraCartaOponente.setName("btnOutraCartaOponente"); // NOI18N
        btnOutraCartaOponente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOutraCartaOponenteMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOutraCartaOponenteMousePressed(evt);
            }
        });
        btnOutraCartaOponente.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnOutraCartaOponenteMouseDragged(evt);
            }
        });
        getContentPane().add(btnOutraCartaOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, -1, -1));

        btnJogador.setLabel("do Jogador");
        btnJogador.setName("btnJogador"); // NOI18N
        btnJogador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnJogadorMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnJogadorMousePressed(evt);
            }
        });
        btnJogador.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnJogadorMouseDragged(evt);
            }
        });
        getContentPane().add(btnJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, -1, -1));

        btnOponente.setLabel("do Oponente");
        btnOponente.setName("btnOponente"); // NOI18N
        btnOponente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnOponenteMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnOponenteMousePressed(evt);
            }
        });
        btnOponente.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnOponenteMouseDragged(evt);
            }
        });
        getContentPane().add(btnOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, -1, -1));

        jLabel9.setText("Primeira Habilidade");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel10.setText("Segunda Habilidade");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel11.setText("Terceira Habilidade");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        segundaHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        segundaHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDiminuir1.setText("Diminuir");
        lblDiminuir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDiminuir1MouseClicked(evt);
            }
        });
        segundaHab.add(lblDiminuir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblAumentar1.setText("Aumentar");
        lblAumentar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAumentar1MouseClicked(evt);
            }
        });
        segundaHab.add(lblAumentar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        seta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta2.setText(">");
        segundaHab.add(seta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        lblValor1.setText("valor");
        lblValor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblValor1MouseClicked(evt);
            }
        });
        segundaHab.add(lblValor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        seta5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta5.setText(">");
        segundaHab.add(seta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        seta8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta8.setText(">");
        segundaHab.add(seta8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        lblAtaque1.setText("de Ataque");
        lblAtaque1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtaque1MouseClicked(evt);
            }
        });
        segundaHab.add(lblAtaque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblDefesa1.setText("de Defesa");
        lblDefesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDefesa1MouseClicked(evt);
            }
        });
        segundaHab.add(lblDefesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblPV1.setText("Pontos de Vida");
        lblPV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPV1MouseClicked(evt);
            }
        });
        segundaHab.add(lblPV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lblDestaCarta1.setText("Desta Carta");
        lblDestaCarta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDestaCarta1MouseClicked(evt);
            }
        });
        segundaHab.add(lblDestaCarta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOutraCartaJogador1.setText("de Outra Carta do Jogador");
        lblOutraCartaJogador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutraCartaJogador1MouseClicked(evt);
            }
        });
        segundaHab.add(lblOutraCartaJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOutraCartaOponente1.setText("de Outra Carta do Oponente");
        lblOutraCartaOponente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutraCartaOponente1MouseClicked(evt);
            }
        });
        segundaHab.add(lblOutraCartaOponente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblJogador1.setText("do Jogador");
        lblJogador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJogador1MouseClicked(evt);
            }
        });
        segundaHab.add(lblJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOponente1.setText("do Oponente");
        lblOponente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOponente1MouseClicked(evt);
            }
        });
        segundaHab.add(lblOponente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        getContentPane().add(segundaHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 440, 30));

        terceiraHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        terceiraHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAumentar2.setText("Aumentar");
        lblAumentar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAumentar2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblAumentar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblDiminuir2.setText("Diminuir");
        lblDiminuir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDiminuir2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblDiminuir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        seta3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta3.setText(">");
        terceiraHab.add(seta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        lblValor2.setText("valor");
        lblValor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblValor2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblValor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        seta6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta6.setText(">");
        terceiraHab.add(seta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        seta9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta9.setText(">");
        terceiraHab.add(seta9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        lblAtaque2.setText("de Ataque");
        lblAtaque2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtaque2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblAtaque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblDefesa2.setText("de Defesa");
        lblDefesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDefesa2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblDefesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblPV2.setText("Pontos de Vida");
        lblPV2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPV2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblPV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lblDestaCarta2.setText("Desta Carta");
        lblDestaCarta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDestaCarta2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblDestaCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOutraCartaJogador2.setText("de Outra Carta do Jogador");
        lblOutraCartaJogador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutraCartaJogador2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblOutraCartaJogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOutraCartaOponente2.setText("de Outra Carta do Oponente");
        lblOutraCartaOponente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutraCartaOponente2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblOutraCartaOponente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblJogador2.setText("do Jogador");
        lblJogador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJogador2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblJogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOponente2.setText("do Oponente");
        lblOponente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOponente2MouseClicked(evt);
            }
        });
        terceiraHab.add(lblOponente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        getContentPane().add(terceiraHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 440, 30));

        primeiraHab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        primeiraHab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAumentar.setText("Aumentar");
        lblAumentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAumentarMouseClicked(evt);
            }
        });
        primeiraHab.add(lblAumentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        seta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta1.setText(">");
        primeiraHab.add(seta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        lblDiminuir.setText("Diminuir");
        lblDiminuir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDiminuirMouseClicked(evt);
            }
        });
        primeiraHab.add(lblDiminuir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblValor.setText("valor");
        lblValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblValorMouseClicked(evt);
            }
        });
        primeiraHab.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        seta4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta4.setText(">");
        primeiraHab.add(seta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 10, -1));

        seta7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seta7.setText(">");
        primeiraHab.add(seta7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        lblAtaque.setText("de Ataque");
        lblAtaque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtaqueMouseClicked(evt);
            }
        });
        primeiraHab.add(lblAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblDefesa.setText("de Defesa");
        lblDefesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDefesaMouseClicked(evt);
            }
        });
        primeiraHab.add(lblDefesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblPV.setText("Pontos de Vida");
        lblPV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPVMouseClicked(evt);
            }
        });
        primeiraHab.add(lblPV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        lblDestaCarta.setText("Desta Carta");
        lblDestaCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDestaCartaMouseClicked(evt);
            }
        });
        primeiraHab.add(lblDestaCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOutraCartaJogador.setText("de Outra Carta do Jogador");
        lblOutraCartaJogador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutraCartaJogadorMouseClicked(evt);
            }
        });
        primeiraHab.add(lblOutraCartaJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOutraCartaOponente.setText("de Outra Carta do Oponente");
        lblOutraCartaOponente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutraCartaOponenteMouseClicked(evt);
            }
        });
        primeiraHab.add(lblOutraCartaOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblJogador.setText("do Jogador");
        lblJogador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJogadorMouseClicked(evt);
            }
        });
        primeiraHab.add(lblJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        lblOponente.setText("do Oponente");
        lblOponente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOponenteMouseClicked(evt);
            }
        });
        primeiraHab.add(lblOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        getContentPane().add(primeiraHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 440, 30));

        btnSalvarHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/disket.jpg"))); // NOI18N
        btnSalvarHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarHabMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarHabMouseClicked(evt);
            }
        });
        getContentPane().add(btnSalvarHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 60, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiminuirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiminuirMouseReleased
    Card action = Card.getInstance();

    
        Component bDiminuir = evt.getComponent();
/*      */ 
/*  863 */     int x = bDiminuir.getX();
/*  864 */     int y = bDiminuir.getY();
/*      */ 
/*  870 */     if ((x > 15) && (x < 30) && (y > 120) && (y < 135)) {
/*  871 */       if (this.flagPrimeiraHab == 0) {
/*  872 */         if (this.flagPrimeiraHabDiminuir == 0) {
/*  873 */           this.lblDiminuir.setForeground(Color.red);
/*  874 */           this.lblDiminuir.setVisible(true);
/*  875 */           this.seta1.setVisible(true);
/*  876 */           bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*  877 */           this.flagPrimeiraHab = 1;
/*  878 */           this.flagPrimeiraHabDiminuir = 1;
                      action.setOperItem("DECREMENT",0);
                      action.setTxtAbility1Item("Diminui", 0);
                    
/*      */         }
/*      */       }
/*      */       else {
/*  882 */         bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*      */       }
/*      */     }
/*      */     else {
/*  886 */       bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*      */     }
/*      */ 
/*  890 */     if ((x > 15) && (x < 30) && (y > 200) && (y < 213)) {
/*  891 */       if (this.flagSegundaHab == 0) {
/*  892 */         if (this.flagSegundaHabDiminuir == 0) {
/*  893 */           this.lblDiminuir1.setForeground(Color.red);
/*  894 */           this.lblDiminuir1.setVisible(true);
/*  895 */           this.seta2.setVisible(true);
/*  896 */           bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*  897 */           this.flagSegundaHab = 1;
/*  898 */           this.flagSegundaHabDiminuir = 1;
//action.action2 = "DECREMENT";
action.setOperItem("DECREMENT",1);
                      action.setTxtAbility1Item("Diminui", 1);
/*      */         }
/*      */       }
/*      */       else {
/*  902 */         bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  908 */     if ((x > 15) && (x < 30) && (y > 289) && (y < 297)) {
/*  909 */       if (this.flagTerceiraHab == 0) {
/*  910 */         if (this.flagTerceiraHabDiminuir == 0) {
/*  911 */           this.lblDiminuir2.setForeground(Color.red);
/*  912 */           this.lblDiminuir2.setVisible(true);
/*  913 */           this.seta3.setVisible(true);
/*  914 */           bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*  915 */           this.flagTerceiraHab = 1;
/*  916 */           this.flagTerceiraHabDiminuir = 1;
//action.action3 = "DECREMENT";
action.setOperItem("DECREMENT",2);
                      action.setTxtAbility1Item("Diminui ", 2);
/*      */         }
/*      */       }
/*      */       else {
/*  920 */         bDiminuir.setLocation(posicaoXDiminuir, posicaoYDiminuir);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  925 */     mouseReleased(evt);
    }//GEN-LAST:event_btnDiminuirMouseReleased

    private void btnDiminuirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiminuirMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnDiminuirMousePressed

    private void btnDiminuirMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiminuirMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnDiminuirMouseDragged

    private void btnAtaqueMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtaqueMouseReleased

 Card attr = Card.getInstance();

        Component bAtaque = evt.getComponent();
/*      */ 
/* 1104 */     int x = bAtaque.getX();
/* 1105 */     int y = bAtaque.getY();
/*      */ 
/* 1111 */     if ((x > 153) && (x < 215) && (y > 123) && (y < 140)) {
/* 1112 */       if (this.flagPrimeiraHab1 == 0) {
/* 1113 */         if (this.flagPrimeiraHabAtaque == 0) {
/* 1114 */           this.lblAtaque.setForeground(Color.red);
/* 1115 */           this.lblAtaque.setVisible(true);
/* 1116 */           this.seta7.setVisible(true);
/* 1117 */           bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/* 1118 */           this.flagPrimeiraHab1 = 1;
/* 1119 */           this.flagPrimeiraHabAtaque = 1;
//attr.attr1 = "changePower";
                      attr.setEventItem("changePower",0);
                                            attr.setTxtAbility3Item(" de Força", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1123 */         bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/*      */       }
/*      */     }
/*      */     else {
/* 1127 */       bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/*      */     }
/*      */ 
/* 1131 */     if ((x > 150) && (x < 215) && (y > 202) && (y < 220)) {
/* 1132 */       if (this.flagSegundaHab1 == 0) {
/* 1133 */         if (this.flagSegundaHabAtaque == 0) {
/* 1134 */           this.lblAtaque1.setForeground(Color.red);
/* 1135 */           this.lblAtaque1.setVisible(true);
/* 1136 */           this.seta8.setVisible(true);
/* 1137 */           bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/* 1138 */           this.flagSegundaHab1 = 1;
/* 1139 */           this.flagSegundaHabAtaque = 1;
//attr.attr2 = "changePower";
 attr.setEventItem("changePower",1);
                       attr.setTxtAbility3Item(" de Força", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1143 */         bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1149 */     if ((x > 150) && (x < 215) && (y > 284) && (y < 300)) {
/* 1150 */       if (this.flagTerceiraHab1 == 0) {
/* 1151 */         if (this.flagTerceiraHabAtaque == 0) {
/* 1152 */           this.lblAtaque2.setForeground(Color.red);
/* 1153 */           this.lblAtaque2.setVisible(true);
/* 1154 */           this.seta9.setVisible(true);
/* 1155 */           bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/* 1156 */           this.flagTerceiraHab1 = 1;
/* 1157 */           this.flagTerceiraHabAtaque = 1;
//attr.attr3 = "changePower";
 attr.setEventItem("changePower",2);
                       attr.setTxtAbility3Item(" de Força", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1161 */         bAtaque.setLocation(posicaoXAtaque, posicaoYAtaque);
/*      */       }
/*      */     }
/*      */ 
/* 1165 */     mouseReleased(evt);
    }//GEN-LAST:event_btnAtaqueMouseReleased

    private void btnAtaqueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtaqueMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnAtaqueMousePressed

    private void btnAtaqueMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtaqueMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnAtaqueMouseDragged

    private void btnDefesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefesaMouseReleased

 Card attr = Card.getInstance();

 
        Component bDefesa = evt.getComponent();
/*      */ 
/* 1258 */     int x = bDefesa.getX();
/* 1259 */     int y = bDefesa.getY();
/*      */ 
/* 1265 */     if ((x > 153) && (x < 215) && (y > 123) && (y < 140)) {
/* 1266 */       if (this.flagPrimeiraHab1 == 0) {
/* 1267 */         if (this.flagPrimeiraHabDefesa == 0) {
/* 1268 */           this.lblDefesa.setForeground(Color.red);
/* 1269 */           this.lblDefesa.setVisible(true);
/* 1270 */           this.seta7.setVisible(true);
/* 1271 */           bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/* 1272 */           this.flagPrimeiraHab1 = 1;
/* 1273 */           this.flagPrimeiraHabDefesa = 1;
//attr.attr1 = "changeDefense";
 attr.setEventItem("changeDefense",0);
 attr.setTxtAbility3Item(" de Defesa", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1277 */         bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/*      */       }
/*      */     }
/*      */     else {
/* 1281 */       bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/*      */     }
/*      */ 
/* 1285 */     if ((x > 150) && (x < 215) && (y > 202) && (y < 220)) {
/* 1286 */       if (this.flagSegundaHab1 == 0) {
/* 1287 */         if (this.flagSegundaHabDefesa == 0) {
/* 1288 */           this.lblDefesa1.setForeground(Color.red);
/* 1289 */           this.lblDefesa1.setVisible(true);
/* 1290 */           this.seta8.setVisible(true);
/* 1291 */           bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/* 1292 */           this.flagSegundaHab1 = 1;
/* 1293 */           this.flagSegundaHabDefesa = 1;
//attr.attr2 = "changeDefense";
 attr.setEventItem("changeDefense",1);
  attr.setTxtAbility3Item(" de Defesa", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1297 */         bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1303 */     if ((x > 150) && (x < 215) && (y > 284) && (y < 300)) {
/* 1304 */       if (this.flagTerceiraHab1 == 0) {
/* 1305 */         if (this.flagTerceiraHabDefesa == 0) {
/* 1306 */           this.lblDefesa2.setForeground(Color.red);
/* 1307 */           this.lblDefesa2.setVisible(true);
/* 1308 */           this.seta9.setVisible(true);
/* 1309 */           bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/* 1310 */           this.flagTerceiraHab1 = 1;
/* 1311 */           this.flagTerceiraHabDefesa = 1;
//attr.attr3 = "changeDefense";
 attr.setEventItem("changeDefense",2);
  attr.setTxtAbility3Item(" de Defesa", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1315 */         bDefesa.setLocation(posicaoXDefesa, posicaoYDefesa);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1320 */     mouseReleased(evt);
    }//GEN-LAST:event_btnDefesaMouseReleased

    private void btnDefesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefesaMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnDefesaMousePressed

    private void btnDefesaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDefesaMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnDefesaMouseDragged

    private void btnPVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPVMouseReleased

 Card attr = Card.getInstance();

        Component bPV = evt.getComponent();
/*      */ 
/* 1326 */     int x = bPV.getX();
/* 1327 */     int y = bPV.getY();
/*      */ 
/* 1333 */     if ((x > 153) && (x < 215) && (y > 123) && (y < 140)) {
/* 1334 */       if (this.flagPrimeiraHab1 == 0) {
/* 1335 */         if (this.flagPrimeiraHabPV == 0) {
/* 1336 */           this.lblPV.setForeground(Color.red);
/* 1337 */           this.lblPV.setVisible(true);
/* 1338 */           this.seta7.setVisible(true);
/* 1339 */           bPV.setLocation(posicaoXPV, posicaoYPV);
/* 1340 */           this.flagPrimeiraHab1 = 1;
/* 1341 */           this.flagPrimeiraHabPV = 1;
//attr.attr1 = "changeScore";
 attr.setEventItem("changeScore",0);
  attr.setTxtAbility3Item(" dos Pontos de Vida", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1345 */         bPV.setLocation(posicaoXPV, posicaoYPV);
/*      */       }
/*      */     }
/*      */     else {
/* 1349 */       bPV.setLocation(posicaoXPV, posicaoYPV);
/*      */     }
/*      */ 
/* 1353 */     if ((x > 150) && (x < 215) && (y > 202) && (y < 220)) {
/* 1354 */       if (this.flagSegundaHab1 == 0) {
/* 1355 */         if (this.flagSegundaHabPV == 0) {
/* 1356 */           this.lblPV1.setForeground(Color.red);
/* 1357 */           this.lblPV1.setVisible(true);
/* 1358 */           this.seta8.setVisible(true);
/* 1359 */           bPV.setLocation(posicaoXPV, posicaoYPV);
/* 1360 */           this.flagSegundaHab1 = 1;
/* 1361 */           this.flagSegundaHabPV = 1;
//attr.attr2 = "changeScore";
 attr.setEventItem("changeScore",1);
   attr.setTxtAbility3Item(" dos Pontos de Vida", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1365 */         bPV.setLocation(posicaoXPV, posicaoYPV);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1371 */     if ((x > 150) && (x < 215) && (y > 284) && (y < 300)) {
/* 1372 */       if (this.flagTerceiraHab1 == 0) {
/* 1373 */         if (this.flagTerceiraHabPV == 0) {
/* 1374 */           this.lblPV2.setForeground(Color.red);
/* 1375 */           this.lblPV2.setVisible(true);
/* 1376 */           this.seta9.setVisible(true);
/* 1377 */           bPV.setLocation(posicaoXPV, posicaoYPV);
/* 1378 */           this.flagTerceiraHab1 = 1;
/* 1379 */           this.flagTerceiraHabPV = 1;
//attr.attr3 = "changeScore";
 attr.setEventItem("changeScore",2);
   attr.setTxtAbility3Item(" dos Pontos de Vida", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1383 */         bPV.setLocation(posicaoXPV, posicaoYPV);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1388 */     mouseReleased(evt);
    }//GEN-LAST:event_btnPVMouseReleased

    private void btnPVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPVMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnPVMousePressed

    private void btnPVMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPVMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnPVMouseDragged

    private void btnDestaCartaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDestaCartaMouseReleased
Card target = Card.getInstance();
 
        Component bDestaCarta = evt.getComponent();
/*      */ 
/* 1434 */     int x = bDestaCarta.getX();
/* 1435 */     int y = bDestaCarta.getY();
/*      */ 
/* 1441 */     if ((x > 260) && (x < 280) && (y > 127) && (y < 135)) {
/* 1442 */       if (this.flagPrimeiraHab2 == 0) {
/* 1443 */         if (this.flagPrimeiraHabDestaCarta == 0) {
/* 1444 */           this.lblDestaCarta.setForeground(Color.red);
/* 1445 */           this.lblDestaCarta.setVisible(true);
/* 1446 */           bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/* 1447 */           this.flagPrimeiraHab2 = 1;
/* 1448 */           this.flagPrimeiraHabDestaCarta = 1;
//target.target1 = "OWNER";
 target.setTargetItem("OWNER",0);
 target.setTxtAbility4Item(" desta carta", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1452 */         bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/*      */       }
/*      */     }
/*      */     else {
/* 1456 */       bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/*      */     }
/*      */ 
/* 1460 */     if ((x > 260) && (x < 280) && (y > 204) && (y < 215)) {
/* 1461 */       if (this.flagSegundaHab2 == 0) {
/* 1462 */         if (this.flagSegundaHabDestaCarta == 0) {
/* 1463 */           this.lblDestaCarta1.setForeground(Color.red);
/* 1464 */           this.lblDestaCarta1.setVisible(true);
/* 1465 */           bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/* 1466 */           this.flagSegundaHab2 = 1;
/* 1467 */           this.flagSegundaHabDestaCarta = 1;
//target.target2 = "OWNER";
target.setTargetItem("OWNER",1);
 target.setTxtAbility4Item(" desta Carta", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1471 */         bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1477 */     if ((x > 260) && (x < 285) && (y > 287) && (y < 300)) {
/* 1478 */       if (this.flagTerceiraHab2 == 0) {
/* 1479 */         if (this.flagTerceiraHabDestaCarta == 0) {
/* 1480 */           this.lblDestaCarta2.setForeground(Color.red);
/* 1481 */           this.lblDestaCarta2.setVisible(true);
/* 1482 */           bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/* 1483 */           this.flagTerceiraHab2 = 1;
/* 1484 */           this.flagTerceiraHabDestaCarta = 1;
//target.target3 = "OWNER";
target.setTargetItem("OWNER",2);
 target.setTxtAbility4Item(" desta Carta", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1488 */         bDestaCarta.setLocation(posicaoXDestaCarta, posicaoYDestaCarta);
/*      */       }
/*      */     }
/*      */ 
/* 1492 */     mouseReleased(evt);
    }//GEN-LAST:event_btnDestaCartaMouseReleased

    private void btnDestaCartaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDestaCartaMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnDestaCartaMousePressed

    private void btnDestaCartaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDestaCartaMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnDestaCartaMouseDragged

    private void btnOutraCartaJogadorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutraCartaJogadorMouseReleased
 Card target = Card.getInstance();
 
 Component bOutraCartaJogador = evt.getComponent();
/*      */ 
/* 1498 */     int x = bOutraCartaJogador.getX();
/* 1499 */     int y = bOutraCartaJogador.getY();
/*      */ 
/* 1505 */     if ((x > 260) && (x < 280) && (y > 127) && (y < 135)) {
/* 1506 */       if (this.flagPrimeiraHab2 == 0) {
/* 1507 */         if (this.flagPrimeiraHabOutraCartaJogador == 0) {
/* 1508 */           this.lblOutraCartaJogador.setForeground(Color.red);
/* 1509 */           this.lblOutraCartaJogador.setVisible(true);
/* 1510 */           bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/* 1511 */           this.flagPrimeiraHab2 = 1;
/* 1512 */           this.flagPrimeiraHabOutraCartaJogador = 1;
//target.target1 = "TARGETCREATURE";
target.setTargetItem("TARGETCREATURE",0);
target.setTxtAbility4Item(" de outra carta do Jogador", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1516 */         bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/*      */       }
/*      */     }
/*      */     else {
/* 1520 */       bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/*      */     }
/*      */ 
/* 1524 */     if ((x > 260) && (x < 280) && (y > 204) && (y < 215)) {
/* 1525 */       if (this.flagSegundaHab2 == 0) {
/* 1526 */         if (this.flagSegundaHabOutraCartaJogador == 0) {
/* 1527 */           this.lblOutraCartaJogador1.setForeground(Color.red);
/* 1528 */           this.lblOutraCartaJogador1.setVisible(true);
/* 1529 */           bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/* 1530 */           this.flagSegundaHab2 = 1;
/* 1531 */           this.flagSegundaHabOutraCartaJogador = 1;
//target.target2 = "TARGETCREATURE";
target.setTargetItem("TARGETCREATURE",1);
target.setTxtAbility4Item(" de outra carta do Jogador", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1535 */         bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1541 */     if ((x > 260) && (x < 285) && (y > 287) && (y < 300)) {
/* 1542 */       if (this.flagTerceiraHab2 == 0) {
/* 1543 */         if (this.flagTerceiraHabOutraCartaJogador == 0) {
/* 1544 */           this.lblOutraCartaJogador2.setForeground(Color.red);
/* 1545 */           this.lblOutraCartaJogador2.setVisible(true);
/* 1546 */           bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/* 1547 */           this.flagTerceiraHab2 = 1;
/* 1548 */           this.flagTerceiraHabOutraCartaJogador = 1;
//target.target3 = "TARGETCREATURE";
target.setTargetItem("TARGETCREATURE",2);
target.setTxtAbility4Item(" de outra carta do Jogador", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1552 */         bOutraCartaJogador.setLocation(posicaoXOutraCartaJogador, posicaoYOutraCartaJogador);
/*      */       }
/*      */     }
/*      */ 
/* 1556 */     mouseReleased(evt);
    }//GEN-LAST:event_btnOutraCartaJogadorMouseReleased

    private void btnOutraCartaJogadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutraCartaJogadorMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnOutraCartaJogadorMousePressed

    private void btnOutraCartaJogadorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutraCartaJogadorMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnOutraCartaJogadorMouseDragged

    private void txtValorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorMouseReleased

    private void txtValorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorMouseExited
 Card attr = Card.getInstance();
        Component bValor = evt.getComponent();
/*      */ 
/* 1042 */     int x = bValor.getX();
/* 1043 */     int y = bValor.getY();
/*      */ 
/* 1047 */     if ((x > 100) && (x < 130) && (y > 100) && (y < 140)) {
/* 1048 */       this.lblValor.setForeground(Color.red);
/* 1049 */       this.lblValor.setVisible(true);
/* 1050 */       this.lblValor.setText(this.txtValor.getText());
/* 1051 */       this.txtValor.setText("");
/* 1052 */       this.seta4.setVisible(true);
/* 1053 */       bValor.setLocation(posicaoXValor, posicaoYValor);
                    //attr.no1 = lblValor.getText();
                    attr.setNoItem(lblValor.getText(),0);
                    attr.setTxtAbility2Item(lblValor.getText() + " pontos", 0);
/*      */     }
/*      */     else {
/* 1056 */       bValor.setLocation(posicaoXValor, posicaoYValor);
/*      */     }
/*      */ 
/* 1060 */     if ((x > 100) && (x < 120) && (y > 200) && (y < 225)) {
/* 1061 */       this.lblValor1.setForeground(Color.red);
/* 1062 */       this.lblValor1.setVisible(true);
/* 1063 */       this.lblValor1.setText(this.txtValor.getText());
/* 1064 */       this.txtValor.setText("");
/* 1065 */       this.seta5.setVisible(true);
/* 1066 */       bValor.setLocation(posicaoXValor, posicaoYValor);
 //attr.no2 = lblValor1.getText();
attr.setNoItem(lblValor1.getText(),1);
 attr.setTxtAbility2Item(lblValor.getText() + " pontos", 1);
/*      */     }
/*      */     else {
/* 1069 */       bValor.setLocation(posicaoXValor, posicaoYValor);
/*      */     }
/*      */ 
/* 1073 */     if ((x > 100) && (x < 120) && (y > 283) && (y < 300)) {
/* 1074 */       this.lblValor2.setForeground(Color.red);
/* 1075 */       this.lblValor2.setVisible(true);
/* 1076 */       this.lblValor2.setText(this.txtValor.getText());
/* 1077 */       this.txtValor.setText("");
/* 1078 */       this.seta6.setVisible(true);
/* 1079 */       bValor.setLocation(posicaoXValor, posicaoYValor);
 //attr.no3 = lblValor2.getText();
attr.setNoItem(lblValor2.getText(),2);
 attr.setTxtAbility2Item(lblValor.getText() + " pontos", 2);
/*      */     }
/*      */     else {
/* 1082 */       bValor.setLocation(posicaoXValor, posicaoYValor);
/*      */     }
    }//GEN-LAST:event_txtValorMouseExited

    private void txtValorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorMousePressed
mousePressed(evt);
    }//GEN-LAST:event_txtValorMousePressed

    private void txtValorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_txtValorMouseDragged

    private void btnAumentarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAumentarMouseReleased
                    Card action = Card.getInstance();

        Component bAumentar = evt.getComponent();
/*      */ 
/*  787 */     int x = bAumentar.getX();
/*  788 */     int y = bAumentar.getY();
/*      */ 
/*  794 */     if ((x > 15) && (x < 30) && (y > 120) && (y < 135)) {
/*  795 */       if (this.flagPrimeiraHab == 0) {
/*  796 */         if (this.flagPrimeiraHabAumentar == 0) {
/*  797 */           this.lblAumentar.setForeground(Color.red);
/*  798 */           this.lblAumentar.setVisible(true);
/*  799 */           this.seta1.setVisible(true);
/*  800 */           bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*  801 */           this.flagPrimeiraHab = 1;
/*  802 */           this.flagPrimeiraHabAumentar = 1;
//action.action1 = "INCREMENT";
action.setOperItem("INCREMENT", 0);
                      action.setTxtAbility1Item("Aumenta ", 0);
/*      */         }
/*      */       }
/*      */       else {
/*  806 */         bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*      */       }
/*      */     }
/*      */     else {
/*  810 */       bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*      */     }
/*      */ 
/*  814 */     if ((x > 15) && (x < 30) && (y > 200) && (y < 213)) {
/*  815 */       if (this.flagSegundaHab == 0) {
/*  816 */         if (this.flagSegundaHabAumentar == 0) {
/*  817 */           this.lblAumentar1.setForeground(Color.red);
/*  818 */           this.lblAumentar1.setVisible(true);
/*  819 */           this.seta2.setVisible(true);
/*  820 */           bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*  821 */           this.flagSegundaHab = 1;
/*  822 */           this.flagSegundaHabAumentar = 1;
//action.action2 = "INCREMENT";
action.setOperItem("INCREMENT", 1);
                      action.setTxtAbility1Item("Aumenta ", 1);
/*      */         }
/*      */       }
/*      */       else {
/*  826 */         bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  831 */     if ((x > 15) && (x < 30) && (y > 289) && (y < 297)) {
/*  832 */       if (this.flagTerceiraHab == 0) {
/*  833 */         if (this.flagTerceiraHabAumentar == 0) {
/*  834 */           this.lblAumentar2.setForeground(Color.red);
/*  835 */           this.lblAumentar2.setVisible(true);
/*  836 */           this.seta3.setVisible(true);
/*  837 */           bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*  838 */           this.flagTerceiraHab = 1;
/*  839 */           this.flagTerceiraHabAumentar = 1;
//action.action3 = "INCREMENT";
action.setOperItem("INCREMENT", 2);
                      action.setTxtAbility1Item("Aumenta ", 2);
/*      */         }
/*      */       }
/*      */       else {
/*  843 */         bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*      */       }
/*      */     }
/*      */     else {
/*  847 */       bAumentar.setLocation(posicaoXAumentar, posicaoYAumentar);
/*      */     }

    mouseReleased(evt);
    }//GEN-LAST:event_btnAumentarMouseReleased

    private void btnAumentarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAumentarMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnAumentarMousePressed

    private void btnAumentarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAumentarMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnAumentarMouseDragged

    private void btnOutraCartaOponenteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutraCartaOponenteMouseReleased
 Card target = Card.getInstance();
 
        Component bOutraCartaOponente = evt.getComponent();
/*      */ 
/* 1562 */     int x = bOutraCartaOponente.getX();
/* 1563 */     int y = bOutraCartaOponente.getY();
/*      */ 
/* 1569 */     if ((x > 260) && (x < 280) && (y > 127) && (y < 135)) {
/* 1570 */       if (this.flagPrimeiraHab2 == 0) {
/* 1571 */         if (this.flagPrimeiraHabOutraCartaOponente == 0) {
/* 1572 */           this.lblOutraCartaOponente.setForeground(Color.red);
/* 1573 */           this.lblOutraCartaOponente.setVisible(true);
/* 1574 */           bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/* 1575 */           this.flagPrimeiraHab2 = 1;
/* 1576 */           this.flagPrimeiraHabOutraCartaOponente = 1;
//target.target1 = "TARGETCREATURE";
target.setTargetItem("TARGETCREATURE", 0);
target.setTxtAbility4Item(" de outra carta do Oponente", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1580 */         bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/*      */       }
/*      */     }
/*      */     else {
/* 1584 */       bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/*      */     }
/*      */ 
/* 1588 */     if ((x > 260) && (x < 280) && (y > 204) && (y < 215)) {
/* 1589 */       if (this.flagSegundaHab2 == 0) {
/* 1590 */         if (this.flagSegundaHabOutraCartaOponente == 0) {
/* 1591 */           this.lblOutraCartaOponente1.setForeground(Color.red);
/* 1592 */           this.lblOutraCartaOponente1.setVisible(true);
/* 1593 */           bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/* 1594 */           this.flagSegundaHab2 = 1;
/* 1595 */           this.flagSegundaHabOutraCartaOponente = 1;
//target.target2 = "TARGETCREATURE";
target.setTargetItem("TARGETCREATURE", 1);
target.setTxtAbility4Item(" de outra carta do Oponente", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1599 */         bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1605 */     if ((x > 260) && (x < 285) && (y > 287) && (y < 300)) {
/* 1606 */       if (this.flagTerceiraHab2 == 0) {
/* 1607 */         if (this.flagTerceiraHabOutraCartaOponente == 0) {
/* 1608 */           this.lblOutraCartaOponente2.setForeground(Color.red);
/* 1609 */           this.lblOutraCartaOponente2.setVisible(true);
/* 1610 */           bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/* 1611 */           this.flagTerceiraHab2 = 1;
/* 1612 */           this.flagTerceiraHabOutraCartaOponente = 1;
//target.target3 = "TARGETCREATURE";
target.setTargetItem("TARGETCREATURE", 2);
target.setTxtAbility4Item(" de outra carta do Oponente", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1616 */         bOutraCartaOponente.setLocation(posicaoXOutraCartaOponente, posicaoYOutraCartaOponente);
/*      */       }
/*      */     }
/*      */ 
/* 1620 */     mouseReleased(evt);
    }//GEN-LAST:event_btnOutraCartaOponenteMouseReleased

    private void btnOutraCartaOponenteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutraCartaOponenteMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnOutraCartaOponenteMousePressed

    private void btnOutraCartaOponenteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutraCartaOponenteMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnOutraCartaOponenteMouseDragged

    private void btnJogadorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJogadorMouseReleased
 Card target = Card.getInstance();
 
        Component bJogador = evt.getComponent();
/*      */ 
/* 1626 */     int x = bJogador.getX();
/* 1627 */     int y = bJogador.getY();
/*      */ 
/* 1633 */     if ((x > 260) && (x < 280) && (y > 127) && (y < 135)) {
/* 1634 */       if (this.flagPrimeiraHab2 == 0) {
/* 1635 */         if (this.flagPrimeiraHabJogador == 0) {
/* 1636 */           this.lblJogador.setForeground(Color.red);
/* 1637 */           this.lblJogador.setVisible(true);
/* 1638 */           bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/* 1639 */           this.flagPrimeiraHab2 = 1;
/* 1640 */           this.flagPrimeiraHabJogador = 1;
//target.target1 = "PLAYER";
target.setTargetItem("PLAYER", 0);
target.setTxtAbility4Item(" do Jogador", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1644 */         bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/*      */       }
/*      */     }
/*      */     else {
/* 1648 */       bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/*      */     }
/*      */ 
/* 1652 */     if ((x > 260) && (x < 280) && (y > 204) && (y < 215)) {
/* 1653 */       if (this.flagSegundaHab2 == 0) {
/* 1654 */         if (this.flagSegundaHabJogador == 0) {
/* 1655 */           this.lblJogador1.setForeground(Color.red);
/* 1656 */           this.lblJogador1.setVisible(true);
/* 1657 */           bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/* 1658 */           this.flagSegundaHab2 = 1;
/* 1659 */           this.flagSegundaHabJogador = 1;
//target.target2 = "PLAYER";
target.setTargetItem("PLAYER", 1);
target.setTxtAbility4Item(" do Jogador", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1663 */         bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1669 */     if ((x > 260) && (x < 285) && (y > 287) && (y < 300)) {
/* 1670 */       if (this.flagTerceiraHab2 == 0) {
/* 1671 */         if (this.flagTerceiraHabJogador == 0) {
/* 1672 */           this.lblJogador2.setForeground(Color.red);
/* 1673 */           this.lblJogador2.setVisible(true);
/* 1674 */           bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/* 1675 */           this.flagTerceiraHab2 = 1;
/* 1676 */           this.flagTerceiraHabJogador = 1;
//target.target3 = "PLAYER";
target.setTargetItem("PLAYER", 2);
target.setTxtAbility4Item(" do Jogador", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1680 */         bJogador.setLocation(posicaoXJogador, posicaoYJogador);
/*      */       }
/*      */     }
/*      */ 
/* 1684 */     mouseReleased(evt);
    }//GEN-LAST:event_btnJogadorMouseReleased

    private void btnJogadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJogadorMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnJogadorMousePressed

    private void btnJogadorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJogadorMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnJogadorMouseDragged

    private void btnOponenteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOponenteMouseReleased
Card target = Card.getInstance();
 
        Component bOponente = evt.getComponent();
/*      */ 
/* 1690 */     int x = bOponente.getX();
/* 1691 */     int y = bOponente.getY();
/*      */ 
/* 1697 */     if ((x > 260) && (x < 280) && (y > 127) && (y < 135)) {
/* 1698 */       if (this.flagPrimeiraHab2 == 0) {
/* 1699 */         if (this.flagPrimeiraHabOponente == 0) {
/* 1700 */           this.lblOponente.setForeground(Color.red);
/* 1701 */           this.lblOponente.setVisible(true);
/* 1702 */           bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/* 1703 */           this.flagPrimeiraHab2 = 1;
/* 1704 */           this.flagPrimeiraHabOponente = 1;
//target.target1 = "OPPONENT";
target.setTargetItem("OPPONENT", 0);
target.setTxtAbility4Item(" do Oponente", 0);
/*      */         }
/*      */       }
/*      */       else {
/* 1708 */         bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/*      */       }
/*      */     }
/*      */     else {
/* 1712 */       bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/*      */     }
/*      */ 
/* 1716 */     if ((x > 260) && (x < 280) && (y > 204) && (y < 215)) {
/* 1717 */       if (this.flagSegundaHab2 == 0) {
/* 1718 */         if (this.flagSegundaHabOponente == 0) {
/* 1719 */           this.lblOponente1.setForeground(Color.red);
/* 1720 */           this.lblOponente1.setVisible(true);
/* 1721 */           bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/* 1722 */           this.flagSegundaHab2 = 1;
/* 1723 */           this.flagSegundaHabOponente = 1;
//target.target2 = "OPPONENT";
target.setTargetItem("OPPONENT", 1);
target.setTxtAbility4Item(" do Oponente", 1);
/*      */         }
/*      */       }
/*      */       else {
/* 1727 */         bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1733 */     if ((x > 260) && (x < 285) && (y > 287) && (y < 300)) {
/* 1734 */       if (this.flagTerceiraHab2 == 0) {
/* 1735 */         if (this.flagTerceiraHabOponente == 0) {
/* 1736 */           this.lblOponente2.setForeground(Color.red);
/* 1737 */           this.lblOponente2.setVisible(true);
/* 1738 */           bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/* 1739 */           this.flagTerceiraHab2 = 1;
/* 1740 */           this.flagTerceiraHabOponente = 1;
//target.target3 = "OPPONENT";
target.setTargetItem("OPPONENT", 2);
target.setTxtAbility4Item(" do Oponente", 2);
/*      */         }
/*      */       }
/*      */       else {
/* 1744 */         bOponente.setLocation(posicaoXOponente, posicaoYOponente);
/*      */       }
/*      */     }
/*      */ 
/* 1748 */     mouseReleased(evt);
    }//GEN-LAST:event_btnOponenteMouseReleased

    private void btnOponenteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOponenteMousePressed
mousePressed(evt);
    }//GEN-LAST:event_btnOponenteMousePressed

    private void btnOponenteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOponenteMouseDragged
 mouseDragged(evt);
    }//GEN-LAST:event_btnOponenteMouseDragged

    private void lblDiminuir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDiminuir1MouseClicked
this.lblDiminuir1.setVisible(false);
/* 1007 */     this.seta2.setVisible(false);
/* 1008 */     this.flagSegundaHab = 0;
/* 1009 */     this.flagSegundaHabDiminuir = 0;
    }//GEN-LAST:event_lblDiminuir1MouseClicked

    private void lblAumentar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAumentar1MouseClicked
this.lblAumentar1.setVisible(false);
/* 1000 */     this.seta2.setVisible(false);
/* 1001 */     this.flagSegundaHab = 0;
/* 1002 */     this.flagSegundaHabAumentar = 0;
    }//GEN-LAST:event_lblAumentar1MouseClicked

    private void lblValor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblValor1MouseClicked
this.lblValor1.setVisible(false);
/* 1093 */     this.seta5.setVisible(false);
    }//GEN-LAST:event_lblValor1MouseClicked

    private void lblAtaque1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtaque1MouseClicked
this.lblAtaque1.setVisible(false);
/* 1185 */     this.seta8.setVisible(false);
/* 1186 */     this.flagSegundaHab1 = 0;
/* 1187 */     this.flagSegundaHabAtaque = 0;
    }//GEN-LAST:event_lblAtaque1MouseClicked

    private void lblDefesa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDefesa1MouseClicked
this.lblDefesa1.setVisible(false);
/* 1206 */     this.seta8.setVisible(false);
/* 1207 */     this.flagSegundaHab1 = 0;
/* 1208 */     this.flagSegundaHabDefesa = 0;
    }//GEN-LAST:event_lblDefesa1MouseClicked

    private void lblPV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPV1MouseClicked
this.lblPV1.setVisible(false);
/* 1227 */     this.seta8.setVisible(false);
/* 1228 */     this.flagSegundaHab1 = 0;
/* 1229 */     this.flagSegundaHabPV = 0;
    }//GEN-LAST:event_lblPV1MouseClicked

    private void lblDestaCarta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDestaCarta1MouseClicked
this.lblDestaCarta1.setVisible(false);
/* 1759 */     this.flagSegundaHab2 = 0;
/* 1760 */     this.flagSegundaHabDestaCarta = 0;
    }//GEN-LAST:event_lblDestaCarta1MouseClicked

    private void lblOutraCartaJogador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutraCartaJogador1MouseClicked
this.lblOutraCartaJogador1.setVisible(false);
/* 1777 */     this.flagSegundaHab2 = 0;
/* 1778 */     this.flagSegundaHabOutraCartaJogador = 0;
    }//GEN-LAST:event_lblOutraCartaJogador1MouseClicked

    private void lblOutraCartaOponente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutraCartaOponente1MouseClicked
this.lblOutraCartaOponente1.setVisible(false);
/* 1795 */     this.flagSegundaHab2 = 0;
/* 1796 */     this.flagSegundaHabOutraCartaOponente = 0;
    }//GEN-LAST:event_lblOutraCartaOponente1MouseClicked

    private void lblJogador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJogador1MouseClicked
this.lblJogador1.setVisible(false);
/* 1813 */     this.flagSegundaHab2 = 0;
/* 1814 */     this.flagSegundaHabJogador = 0;
    }//GEN-LAST:event_lblJogador1MouseClicked

    private void lblOponente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOponente1MouseClicked
 this.lblOponente1.setVisible(false);
/* 1831 */     this.flagSegundaHab2 = 0;
/* 1832 */     this.flagSegundaHabOponente = 0;
    }//GEN-LAST:event_lblOponente1MouseClicked

    private void lblAumentar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAumentar2MouseClicked
 this.lblAumentar2.setVisible(false);
/*  993 */     this.seta3.setVisible(false);
/*  994 */     this.flagTerceiraHab = 0;
/*  995 */     this.flagTerceiraHabAumentar = 0;
    }//GEN-LAST:event_lblAumentar2MouseClicked

    private void lblDiminuir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDiminuir2MouseClicked
this.lblDiminuir2.setVisible(false);
/*  986 */     this.seta3.setVisible(false);
/*  987 */     this.flagTerceiraHab = 0;
/*  988 */     this.flagTerceiraHabDiminuir = 0;
    }//GEN-LAST:event_lblDiminuir2MouseClicked

    private void lblValor2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblValor2MouseClicked
 this.lblValor2.setVisible(false);
/* 1098 */     this.seta6.setVisible(false);
    }//GEN-LAST:event_lblValor2MouseClicked

    private void lblAtaque2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtaque2MouseClicked
this.lblAtaque2.setVisible(false);
/* 1192 */     this.seta9.setVisible(false);
/* 1193 */     this.flagTerceiraHab1 = 0;
/* 1194 */     this.flagTerceiraHabAtaque = 0;
    }//GEN-LAST:event_lblAtaque2MouseClicked

    private void lblDefesa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDefesa2MouseClicked
this.lblDefesa2.setVisible(false);
/* 1213 */     this.seta9.setVisible(false);
/* 1214 */     this.flagTerceiraHab1 = 0;
/* 1215 */     this.flagTerceiraHabDefesa = 0;
    }//GEN-LAST:event_lblDefesa2MouseClicked

    private void lblPV2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPV2MouseClicked
this.lblPV2.setVisible(false);
/* 1220 */     this.seta9.setVisible(false);
/* 1221 */     this.flagTerceiraHab1 = 0;
/* 1222 */     this.flagTerceiraHabPV = 0;
    }//GEN-LAST:event_lblPV2MouseClicked

    private void lblDestaCarta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDestaCarta2MouseClicked
this.lblDestaCarta2.setVisible(false);
/* 1765 */     this.flagTerceiraHab2 = 0;
/* 1766 */     this.flagTerceiraHabDestaCarta = 0;
    }//GEN-LAST:event_lblDestaCarta2MouseClicked

    private void lblOutraCartaJogador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutraCartaJogador2MouseClicked
this.lblOutraCartaJogador2.setVisible(false);
/* 1783 */     this.flagTerceiraHab2 = 0;
/* 1784 */     this.flagTerceiraHabOutraCartaJogador = 0;
    }//GEN-LAST:event_lblOutraCartaJogador2MouseClicked

    private void lblOutraCartaOponente2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutraCartaOponente2MouseClicked
this.lblOutraCartaOponente2.setVisible(false);
/* 1801 */     this.flagTerceiraHab2 = 0;
/* 1802 */     this.flagTerceiraHabOutraCartaOponente = 0;
    }//GEN-LAST:event_lblOutraCartaOponente2MouseClicked

    private void lblJogador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJogador2MouseClicked
this.lblJogador2.setVisible(false);
/* 1819 */     this.flagTerceiraHab2 = 0;
/* 1820 */     this.flagTerceiraHabJogador = 0;
    }//GEN-LAST:event_lblJogador2MouseClicked

    private void lblOponente2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOponente2MouseClicked
this.lblOponente2.setVisible(false);
/* 1837 */     this.flagTerceiraHab2 = 0;
/* 1838 */     this.flagTerceiraHabOponente = 0;
    }//GEN-LAST:event_lblOponente2MouseClicked

    private void lblAumentarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAumentarMouseClicked
 this.lblAumentar.setVisible(false);
/* 1021 */     this.seta1.setVisible(false);
/* 1022 */     this.flagPrimeiraHab = 0;
/* 1023 */     this.flagPrimeiraHabAumentar = 0;
    }//GEN-LAST:event_lblAumentarMouseClicked

    private void lblDiminuirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDiminuirMouseClicked
this.lblDiminuir.setVisible(false);
/* 1014 */     this.seta1.setVisible(false);
/* 1015 */     this.flagPrimeiraHab = 0;
/* 1016 */     this.flagPrimeiraHabDiminuir = 0;
    }//GEN-LAST:event_lblDiminuirMouseClicked

    private void lblValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblValorMouseClicked
this.lblValor.setVisible(false);
/* 1088 */     this.seta4.setVisible(false);
    }//GEN-LAST:event_lblValorMouseClicked

    private void lblAtaqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtaqueMouseClicked
this.lblAtaque.setVisible(false);
/* 1178 */     this.seta7.setVisible(false);
/* 1179 */     this.flagPrimeiraHab1 = 0;
/* 1180 */     this.flagPrimeiraHabAtaque = 0;
    }//GEN-LAST:event_lblAtaqueMouseClicked

    private void lblDefesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDefesaMouseClicked
this.lblDefesa.setVisible(false);
/* 1199 */     this.seta7.setVisible(false);
/* 1200 */     this.flagPrimeiraHab1 = 0;
/* 1201 */     this.flagPrimeiraHabDefesa = 0;
    }//GEN-LAST:event_lblDefesaMouseClicked

    private void lblPVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPVMouseClicked
 this.lblPV.setVisible(false);
/* 1234 */     this.seta7.setVisible(false);
/* 1235 */     this.flagPrimeiraHab1 = 0;
/* 1236 */     this.flagPrimeiraHabPV = 0;
    }//GEN-LAST:event_lblPVMouseClicked

    private void lblDestaCartaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDestaCartaMouseClicked
this.lblDestaCarta.setVisible(false);
/* 1753 */     this.flagPrimeiraHab2 = 0;
/* 1754 */     this.flagPrimeiraHabDestaCarta = 0;
    }//GEN-LAST:event_lblDestaCartaMouseClicked

    private void lblOutraCartaJogadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutraCartaJogadorMouseClicked
this.lblOutraCartaJogador.setVisible(false);
/* 1771 */     this.flagPrimeiraHab2 = 0;
/* 1772 */     this.flagPrimeiraHabOutraCartaJogador = 0;
    }//GEN-LAST:event_lblOutraCartaJogadorMouseClicked

    private void lblOutraCartaOponenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutraCartaOponenteMouseClicked
this.lblOutraCartaOponente.setVisible(false);
/* 1789 */     this.flagPrimeiraHab2 = 0;
/* 1790 */     this.flagPrimeiraHabOutraCartaOponente = 0;
    }//GEN-LAST:event_lblOutraCartaOponenteMouseClicked

    private void lblJogadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJogadorMouseClicked
 this.lblJogador.setVisible(false);
/* 1807 */     this.flagPrimeiraHab2 = 0;
/* 1808 */     this.flagPrimeiraHabJogador = 0;
    }//GEN-LAST:event_lblJogadorMouseClicked

    private void lblOponenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOponenteMouseClicked
this.lblOponente.setVisible(false);
/* 1825 */     this.flagPrimeiraHab2 = 0;
/* 1826 */     this.flagPrimeiraHabOponente = 0;
    }//GEN-LAST:event_lblOponenteMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
               this.lblDiminuir.setVisible(false);
/*  930 */     this.lblDiminuir1.setVisible(false);
/*  931 */     this.lblDiminuir2.setVisible(false);
/*      */ 
/*  933 */     this.lblAumentar.setVisible(false);
/*  934 */     this.lblAumentar1.setVisible(false);
/*  935 */     this.lblAumentar2.setVisible(false);
/*      */ 
/*  937 */     this.lblValor.setVisible(false);
/*  938 */     this.lblValor1.setVisible(false);
/*  939 */     this.lblValor2.setVisible(false);
/*      */ 
/*  941 */     this.seta1.setVisible(false);
/*  942 */     this.seta2.setVisible(false);
/*  943 */     this.seta3.setVisible(false);
/*  944 */     this.seta4.setVisible(false);
/*  945 */     this.seta5.setVisible(false);
/*  946 */     this.seta6.setVisible(false);
/*  947 */     this.seta7.setVisible(false);
/*  948 */     this.seta8.setVisible(false);
/*  949 */     this.seta9.setVisible(false);
/*      */ 
/*  951 */     this.lblAtaque.setVisible(false);
/*  952 */     this.lblAtaque1.setVisible(false);
/*  953 */     this.lblAtaque2.setVisible(false);
/*      */ 
/*  955 */     this.lblDefesa.setVisible(false);
/*  956 */     this.lblDefesa1.setVisible(false);
/*  957 */     this.lblDefesa2.setVisible(false);
/*      */ 
/*  959 */     this.lblPV.setVisible(false);
/*  960 */     this.lblPV1.setVisible(false);
/*  961 */     this.lblPV2.setVisible(false);
/*      */ 
/*  963 */     this.lblDestaCarta.setVisible(false);
/*  964 */     this.lblDestaCarta1.setVisible(false);
/*  965 */     this.lblDestaCarta2.setVisible(false);
/*      */ 
/*  967 */     this.lblOutraCartaJogador.setVisible(false);
/*  968 */     this.lblOutraCartaJogador1.setVisible(false);
/*  969 */     this.lblOutraCartaJogador2.setVisible(false);
/*      */ 
/*  971 */     this.lblOutraCartaOponente.setVisible(false);
/*  972 */     this.lblOutraCartaOponente1.setVisible(false);
/*  973 */     this.lblOutraCartaOponente2.setVisible(false);
/*      */ 
/*  975 */     this.lblJogador.setVisible(false);
/*  976 */     this.lblJogador1.setVisible(false);
/*  977 */     this.lblJogador2.setVisible(false);
/*      */ 
/*  979 */     this.lblOponente.setVisible(false);
/*  980 */     this.lblOponente1.setVisible(false);
/*  981 */     this.lblOponente2.setVisible(false);

Card card = Card.getInstance();
jLabel3.setText(card.getNome());
    }//GEN-LAST:event_formWindowActivated

    private void btnSalvarHabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarHabMouseClicked
DAOCard daoCard = DAOCard.getInstance();
Card card = Card.getInstance();

daoCard.saveCard(card);
//daoCard.refreshCard();

/* 337 */       JOptionPane.showMessageDialog(null, "Informações da carta '" + card.getNome() + "' preenchidas com sucesso!");

CriaCarta criaCarta = new CriaCarta();
criaCarta.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_btnSalvarHabMouseClicked

    private void btnSalvarHabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarHabMouseEntered


    }//GEN-LAST:event_btnSalvarHabMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriaHabilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriaHabilidade().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtaque;
    private javax.swing.JButton btnAumentar;
    private javax.swing.JButton btnDefesa;
    private javax.swing.JButton btnDestaCarta;
    private javax.swing.JButton btnDiminuir;
    private javax.swing.JButton btnJogador;
    private javax.swing.JButton btnOponente;
    private javax.swing.JButton btnOutraCartaJogador;
    private javax.swing.JButton btnOutraCartaOponente;
    private javax.swing.JButton btnPV;
    private javax.swing.JButton btnSalvarHab;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAtaque;
    private javax.swing.JLabel lblAtaque1;
    private javax.swing.JLabel lblAtaque2;
    private javax.swing.JLabel lblAumentar;
    private javax.swing.JLabel lblAumentar1;
    private javax.swing.JLabel lblAumentar2;
    private javax.swing.JLabel lblDefesa;
    private javax.swing.JLabel lblDefesa1;
    private javax.swing.JLabel lblDefesa2;
    private javax.swing.JLabel lblDestaCarta;
    private javax.swing.JLabel lblDestaCarta1;
    private javax.swing.JLabel lblDestaCarta2;
    private javax.swing.JLabel lblDiminuir;
    private javax.swing.JLabel lblDiminuir1;
    private javax.swing.JLabel lblDiminuir2;
    private javax.swing.JLabel lblJogador;
    private javax.swing.JLabel lblJogador1;
    private javax.swing.JLabel lblJogador2;
    private javax.swing.JLabel lblOponente;
    private javax.swing.JLabel lblOponente1;
    private javax.swing.JLabel lblOponente2;
    private javax.swing.JLabel lblOutraCartaJogador;
    private javax.swing.JLabel lblOutraCartaJogador1;
    private javax.swing.JLabel lblOutraCartaJogador2;
    private javax.swing.JLabel lblOutraCartaOponente;
    private javax.swing.JLabel lblOutraCartaOponente1;
    private javax.swing.JLabel lblOutraCartaOponente2;
    private javax.swing.JLabel lblPV;
    private javax.swing.JLabel lblPV1;
    private javax.swing.JLabel lblPV2;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblValor2;
    private javax.swing.JPanel primeiraHab;
    private javax.swing.JPanel segundaHab;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel seta3;
    private javax.swing.JLabel seta4;
    private javax.swing.JLabel seta5;
    private javax.swing.JLabel seta6;
    private javax.swing.JLabel seta7;
    private javax.swing.JLabel seta8;
    private javax.swing.JLabel seta9;
    private javax.swing.JPanel terceiraHab;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

public void mouseDragged(MouseEvent e)
/*      */   {
/* 1954 */     Component b = e.getComponent();
/* 1955 */     if ((this.baseX != -1) && (this.baseY != -1)) {
/* 1956 */       int x = b.getX() + e.getX() - this.baseX;
/* 1957 */       int y = b.getY() + e.getY() - this.baseY;
/* 1958 */       b.setLocation(x, y);
/* 1959 */       b.getParent().repaint();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void mousePressed(MouseEvent e)
/*      */   {
/* 1967 */     this.baseX = e.getX();
/* 1968 */     this.baseY = e.getY();
/*      */   }
/*      */ 
/*      */   public void mouseReleased(MouseEvent e)
/*      */   {
/* 1975 */     this.baseX = -1;
/* 1976 */     this.baseY = -1;
/*      */   }
/*      */ 
/*      */   public void mouseMoved(MouseEvent e)
/*      */   {
/* 1981 */     throw new UnsupportedOperationException("Not supported yet.");
/*      */   }
}
