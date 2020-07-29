import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
/**Classe abstraite servant de base a la création de Terrain
*/
public abstract class Terrain extends JPanel implements ActionListener,KeyListener{
  protected Chenille che;
  private Random rand = new Random();
  protected Timer timer;
  private int[] touches;
  private ImageIcon ic = new ImageIcon(Terrain.class.getResource("images/Mangee.png"));
  private ImageIcon ic1 = new ImageIcon(Terrain.class.getResource("images/Ratee.png"));
  protected int mangees = 0;
  protected int ratee = 0;
  protected int chenille;
  protected ArrayList<Pomme> pom = new ArrayList<Pomme>();
  private ArrayList<Integer> tab;

  /**Constructeur d'un Terrain

  @param touches : tableau comportant les codes des touches utilisées
  @param chenille : code correspondant a la chenille choisit
  @param tab : tableau correspondant aux pommes selectionnées
  */

  public Terrain(int[] touches,int chenille,ArrayList<Integer> tab){
    super();
    this.chenille = chenille;
    this.tab = tab;
    if(chenille == 1){
      che = new Chenille1();
    }else{
      che = new Chenille2();
    }
    this.touches = touches;

    this.setFocusable(true);

    timer = new Timer(100,this);
    this.timer.start();
    this.addKeyListener(this);

    for(int i = 0; i < 5;i++){
      int r = rand.nextInt(tab.size());
      switch(tab.get(r)){
        case 0:
          pom.add(new Pomme1(this));
          break;
        case 1:
          pom.add(new Pomme2(this));
          break;
        case 2:
          pom.add(new Pomme3(this));
          break;
        case 3:
          pom.add(new Pomme4(this));
          break;
        case 4:
          pom.add(new Pomme5(this));
          break;
        case 5:
          pom.add(new Pomme6(this));
          break;
      }
    }
  }
  /**Methode qui affiche les composants du jeu a l'écran
  @param g : L'objet ou l'on va poser les composants
  */
  public void paintComponent(Graphics g){

      g.setColor(new Color(136, 141, 168));
      g.fillRect(0, 0, getWidth(), getHeight());
      che.paint(g);
      for(Pomme pomme : pom){
        pomme.paint(g);
      }

      g.setColor(Color.BLACK);
      g.drawLine(0,800,800,800);
      g.drawLine(800,0,800,800);
      ic.paintIcon(this,g,20,810);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
      String msg = ": " + this.mangees;
      g.drawString(msg,90,850);
      ic1.paintIcon(this,g,160,810);
      msg = ": " + this.ratee;
      g.drawString(msg,220,850);
  }
  /**Méthode abstraite qui gère le déplacement de la chenille et les collisions */
  public abstract void actionPerformed(ActionEvent actionEvent);

  public void keyReleased(KeyEvent e){
  }

  /**Methode qui gères les touches de claviers et change la direction de la chenille en fonction
  @param e : variable lancé des qu'une touche est pressée
  */
  public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == this.touches[0]){
      che.changeDir(0);
    }else if(e.getKeyCode() == this.touches[1]){
      che.changeDir(1);
    }else if(e.getKeyCode() == this.touches[2]){
      che.changeDir(2);
    }else if(e.getKeyCode() == this.touches[3]){
      che.changeDir(3);
    }
  }

  public void keyTyped(KeyEvent e){
  }

  /**Méthode qui augmente le nombre de pommes ratées*/
  public void rater(){
    this.ratee++;
  }
  /**Méthode qui supprime une pomme et la remplace par une nouvelle
  @param pomme : la pomme a remplacée*/
  public void changePomme(Pomme pomme){
    pom.remove(pomme);
    int r = rand.nextInt(tab.size());
    switch(tab.get(r)){
      case 0:
        pom.add(new Pomme1(this));
        break;
      case 1:
        pom.add(new Pomme2(this));
        break;
      case 2:
        pom.add(new Pomme3(this));
        break;
      case 3:
        pom.add(new Pomme4(this));
        break;
      case 4:
        pom.add(new Pomme5(this));
        break;
      case 5:
        pom.add(new Pomme6(this));
        break;
    }
  }
}
