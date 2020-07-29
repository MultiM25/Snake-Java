import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
/**Classe abstraite qui gère la création d'une base de Pomme*/

public abstract class Pomme extends Component{
  private int x;
  private int y;
  private Timer timer;
  private Random rand = new Random();
  private ImageIcon image;
  private Terrain ter;
/**Constructeur de la classe Pomme
@param image : image de la pomme a affichée
@param ter : Terrain sur lequel sera posé la pomme
*/
  public Pomme(ImageIcon image,Terrain ter){
    super();
    this.ter = ter;
    timer = new Timer(5000,new ActionListener(){
      public void actionPerformed(ActionEvent evt){
        reset();
        ter.rater();
        timer.stop();
        bouge();
      }
    });
    this.x = rand.nextInt(Constantes.TAILLE);
    this.y = rand.nextInt(Constantes.TAILLE);
    this.image = image;
    this.setLocation(x*10+5,y*10+5);
    bouge();
  }
  /**Methode qui affiche les composants du jeu a l'écran
  @param g : L'objet ou l'on va poser les composants
  */
  public void paint(Graphics g){
    image.paintIcon(this,g,this.x*10,this.y*10);
  }
  /**Méthode qui retourne la coordonnée x de la pomme
  @return x : coordonnée x de la pomme*/
  public int getX(){
    return this.x;
  }
  /**Méthode qui retourne la coordonnée y de la pomme
  @return y : coordonnée y de la pomme*/
  public int getY(){
    return this.y;
  }
  /**Méthode qui retourne le type de la pomme pour les différents effets*/
  public abstract int getTypePomme();
  
  /**Méthode qui fait bouger la pomme a la fin du timer*/
  public void reset(){
    this.x = rand.nextInt(Constantes.TAILLE);
    this.y = rand.nextInt(Constantes.TAILLE);
    this.setLocation(x*10+5,y*10+5);
  }
  /** Méthode qui gère si une pomme bougera apres un certain temps ou non*/
  public void bouge(){
    int i = rand.nextInt(10);
    if(i == 0){
      timer.start();
    }
  }
}
