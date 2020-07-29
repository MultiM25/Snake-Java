import javax.swing.*;
import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;
import java.util.ArrayList;
/**Classe principale qui créer un fenetre et y ajoute un Terrain pour jouer au jeu de la Chenille*/
public class Main{
  public static ArrayList<JCheckBox> check = new ArrayList<JCheckBox>();
  public static ArrayList<JCheckBox> touc = new ArrayList<JCheckBox>();
  public static ArrayList<JRadioButton> che = new ArrayList<JRadioButton>();
  public static ArrayList<JRadioButton> ter = new ArrayList<JRadioButton>();
  public static ButtonGroup gr2 = new ButtonGroup();
  public static ButtonGroup gr1 = new ButtonGroup();
  public static ButtonGroup gr = new ButtonGroup();
  public static JPanel fen = new JPanel();
  public static JFrame jeu = new JFrame("Jeu de la chenille");
  public static int[][] touches = {{39,40,37,38},{68,83,81,90},{77,76,75,79}};
/**Méthode principale qui lance le jeu*/
  public static void main(String args[]){
    //Création de la fenetre principale
    jeu.setBounds(300,100,Constantes.LARGEUR_FEN+400,Constantes.HAUTEUR_FEN);
    jeu.setUndecorated(true);
    jeu.getContentPane().setLayout(null);
    jeu.getContentPane().setBackground(new Color(71, 76, 105));

    fen.setBounds(0, 0,Constantes.LARGEUR_FEN+1, Constantes.HAUTEUR_FEN);
    jeu.getContentPane().add(fen);

    //Creation des différents JRadioButton,JCheckBox et JButton de la fenetre principale en les ajoutant dans des listes
    JRadioButton but = new JRadioButton(new ImageIcon(Main.class.getResource("images/Tore.png")));
    but.setBounds(900,150,100,100);
    but.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Tore_selected.png")));
    gr.add(but);
    ter.add(but);
    but.setToolTipText("Terrain Tore");
    but.setContentAreaFilled(false);

    JRadioButton but1 = new JRadioButton(new ImageIcon(Main.class.getResource("images/Rebond.png")));
    but1.setBounds(1000,150,100,100);
    but1.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Rebond_selected.png")));
    gr.add(but1);
    ter.add(but1);
    but1.setToolTipText("Terrain avec Rebonds");
    but1.setContentAreaFilled(false);
    but.setSelected(true);
    jeu.getContentPane().add(but);
    jeu.getContentPane().add(but1);

    JRadioButton butt = new JRadioButton(new ImageIcon(Main.class.getResource("images/All.png")));
    butt.setBounds(900,250,100,100);
    butt.setSelectedIcon(new ImageIcon(Main.class.getResource("images/All_selected.png")));
    gr1.add(butt);
    che.add(butt);
    butt.setToolTipText("Dernier anneau qui disparait si touche");
    butt.setContentAreaFilled(false);

    JRadioButton butt1 = new JRadioButton(new ImageIcon(Main.class.getResource("images/Last.png")));
    butt1.setBounds(1000,250,100,100);
    butt1.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Last_selected.png")));
    gr1.add(butt1);
    che.add(butt1);
    butt1.setToolTipText("Chenille qui disparait");
    butt1.setContentAreaFilled(false);
    butt.setSelected(true);
    jeu.getContentPane().add(butt);
    jeu.getContentPane().add(butt1);

    JButton button = new JButton("");
		 button.setBounds(1135,5,65,65);
		 button.setBorderPainted(false);
		 button.setContentAreaFilled(false);
		 button.setIcon(new ImageIcon(Main.class.getResource("images/Leave.png")));
     //Méthode qui permet la fermeture de la fenêtre via ce bouton
		 button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    jeu.getContentPane().add(button);

    JCheckBox box = new JCheckBox("");
		box.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Pom_selected.png")));
		box.setIcon(new ImageIcon(Main.class.getResource("images/Pom.png")));
    box.setToolTipText("Pomme qui ajoute 2 anneaux");
    box.setSelected(true);
		box.setContentAreaFilled(false);
		box.setBounds(870, 400, 70, 70);
		jeu.getContentPane().add(box);

    JCheckBox box1 = new JCheckBox("");
		box1.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Pom1_selected.png")));
		box1.setIcon(new ImageIcon(Main.class.getResource("images/Pom1.png")));
    box1.setToolTipText("Pomme qui accelere");
    box1.setSelected(true);
		box1.setContentAreaFilled(false);
		box1.setBounds(950, 400, 70, 70);
		jeu.getContentPane().add(box1);

    JCheckBox box2 = new JCheckBox("");
		box2.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Pom2_selected.png")));
		box2.setIcon(new ImageIcon(Main.class.getResource("images/Pom2.png")));
    box2.setSelected(true);
    box2.setToolTipText("Pomme qui ajoute un anneau");
		box2.setContentAreaFilled(false);
		box2.setBounds(1030, 400, 70, 70);
		jeu.getContentPane().add(box2);

    JCheckBox box3 = new JCheckBox("");
		box3.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Pom3_selected.png")));
		box3.setIcon(new ImageIcon(Main.class.getResource("images/Pom3.png")));
    box3.setToolTipText("Pomme qui enleve un anneau");
    box3.setSelected(true);
		box3.setContentAreaFilled(false);
		box3.setBounds(870, 480, 70, 70);
		jeu.getContentPane().add(box3);

    JCheckBox box4 = new JCheckBox("");
		box4.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Pom4_selected.png")));
		box4.setIcon(new ImageIcon(Main.class.getResource("images/Pom4.png")));
    box4.setToolTipText("Pomme qui enleve 2 anneaux");
    box4.setSelected(true);
		box4.setContentAreaFilled(false);
		box4.setBounds(950, 480, 70, 70);
		jeu.getContentPane().add(box4);

    JCheckBox box5 = new JCheckBox("");
		box5.setSelectedIcon(new ImageIcon(Main.class.getResource("images/Pom5_selected.png")));
		box5.setIcon(new ImageIcon(Main.class.getResource("images/Pom5.png")));
    box5.setToolTipText("Pomme qui ralentit");
    box5.setSelected(true);
		box5.setContentAreaFilled(false);
		box5.setBounds(1030, 480, 70, 70);
		jeu.getContentPane().add(box5);

    check.add(box);
    check.add(box1);
    check.add(box2);
    check.add(box3);
    check.add(box4);
    check.add(box5);

    JCheckBox bo = new JCheckBox("Fleches");
		bo.setBounds(870, 600, 70, 70);
    bo.setContentAreaFilled(false);
    bo.setToolTipText("Fleches");
    bo.setSelected(true);
		jeu.getContentPane().add(bo);

    JCheckBox bo1 = new JCheckBox("Z-Q-S-D");
		bo1.setBounds(950, 600, 70, 70);
    bo1.setContentAreaFilled(false);
    bo1.setToolTipText("Z-Q-S-D");
		jeu.getContentPane().add(bo1);

    JCheckBox bo2 = new JCheckBox("O-K-L-M");
		bo2.setBounds(1030, 600, 75, 70);
    bo2.setContentAreaFilled(false);
    bo2.setToolTipText("O-K-L-M");
		jeu.getContentPane().add(bo2);

    gr2.add(bo);
    gr2.add(bo1);
    gr2.add(bo2);

    touc.add(bo);
    touc.add(bo1);
    touc.add(bo2);

    JButton jouer = new JButton("Jouer");
    jouer.setBounds(950,750,100,100);
    jouer.setContentAreaFilled(false);
    jeu.getContentPane().add(jouer);
    //Fonction qui qui regarde les choix du joueurs pour gérer quelles pommes seront sur le terrain, quel terrain sera choisit, quel type de chenille et quelles touches sont utilisées
    jouer.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
       int ch = 0;
       for(JRadioButton b : che){
         if(b.getModel() == gr.getSelection()){
           if(b.getToolTipText() == "Dernier anneau qui disparait si touche"){
             ch = 2;
           }else{
             ch = 1;
           }
         }
       }
       int to = 0;
       for(JCheckBox b : touc){
        if(b.isSelected()){
          if(b.getToolTipText() == "Fleches"){
            to = 0;
          }else if(b.getToolTipText() == "Z-Q-S-D"){
            to = 1;
          }else if(b.getToolTipText() == "O-K-L-M"){
            to = 2;
          }
        }

       }
       ArrayList<Integer> po = new ArrayList<Integer>();
       for(JCheckBox b : check){
         if(b.isSelected()){
           if(b.getToolTipText() == "Pomme qui ajoute un anneau"){
             po.add(1);
           }
           else if(b.getToolTipText() == "Pomme qui ajoute 2 anneaux"){
             po.add(2);
           }
           else if(b.getToolTipText() == "Pomme qui enleve 2 anneaux"){
             po.add(4);
           }
           else if(b.getToolTipText() == "Pomme qui enleve un anneau"){
             po.add(3);
           }
           else if(b.getToolTipText() == "Pomme qui accelere"){
             po.add(0);
           }
           else if(b.getToolTipText() == "Pomme qui ralentit"){
             po.add(5);
           }
         }
       }
       if(po.size() == 0){
         po.add(2);
       }
       Terrain terr = new Terrain1(touches[0],1,po);
       for(JRadioButton b : ter){
         if(b.getModel() == gr.getSelection()){
           if(b.getToolTipText() == "Terrain Tore"){
             terr = new Terrain2(touches[to],ch,po);
           }else{
             terr = new Terrain1(touches[to],ch,po);
           }
         }
       }
       jeu.remove(fen);
       terr.setBounds(0, 0,Constantes.LARGEUR_FEN+1, Constantes.HAUTEUR_FEN);
       jeu.getContentPane().add(terr);
       JButton j = (JButton) e.getSource();
       j.setEnabled(false);
     }
   });
		jeu.setVisible(true);
  }
}
