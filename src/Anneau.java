import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**Classe servant a créer des anneaux de la Chenille*/
public class Anneau extends Component{
    private int x;
    private int y;
    private Color couleur;
    /**Constructeur de la classe Anneau
    @param x : coordonnées x de l'anneau
    @param y : coordonnées y de l'anneau
    @param couleur : couleur de l'anneaux
    */
    public Anneau(int x,int y,Color couleur){
      super();
      this.couleur = couleur;
      this.x = x;
      this.y = y;
      this.setLocation(this.x*Constantes.TAILLE_ANN,this.y*Constantes.TAILLE_ANN);
      this.setSize(Constantes.HAUTEUR_ANN,Constantes.LARGEUR_ANN);
    }
    /**Methode qui affiche la chenille a l'écran
    @param g : L'objet ou l'on va poser les composants
    */
    public void paint(Graphics g){
      g.setColor(this.couleur);
      g.fillOval(this.x*Constantes.TAILLE_ANN,this.y*Constantes.TAILLE_ANN,Constantes.TAILLE_ANN,Constantes.TAILLE_ANN);
    }
    /**Méthode qui fait bouger un anneau et vérifie si il ne traverse pas un mur
    @param x : distance à parcourir en x
    @param y : distance à parcourir en y
    */
    public void bouge(int x,int y){
        this.x += x;
        this.y += y;
        if(this.x > Constantes.TAILLE-1){
          this.x = 0 ;
        }else if(this.x < 0){
          this.x = Constantes.TAILLE-1 ;
        }
        else if(this.y > Constantes.TAILLE-1){
          this.y = 0 ;
        }else if(this.y < 0){
          this.y = Constantes.TAILLE-1 ;
        }
        this.setLocation(this.x*Constantes.TAILLE_ANN,this.y*Constantes.TAILLE_ANN);
    }
    /**Méthode qui retourne la coordonnées x de l'anneau
    @return x = coordonnées x de l'anneau*/
    public int getX(){
      return this.x;
    }
    /**Méthode qui retourne la coordonnées y de l'anneau
    @return y = coordonnées y de l'anneau
    */
    public int getY(){
      return this.y;
    }
    /**Méthode qui met le change le x et y de cet anneau et le positionne correctement a l'écran
    @param x = nouvelle coordonnées x de l'anneau
    @param y = nouvelle coordonnées y de l'anneau
    */
    public void setPos(int x ,int y ){
      this.x = x;
      this.y = y;
      this.setLocation(this.x*Constantes.TAILLE_ANN,this.y*Constantes.TAILLE_ANN);
    }
    /**Méthode qui vérifie si un anneau est touché par d'autres anneaux
    @param c : liste d'anneau a vérifier
    @param indice : indice de l'anneau dans la liste
    @return true si il touche un autre anneau
    */
    public boolean estTouche(ArrayList<Anneau> c, int indice){
      for(int i = 0; i < c.size(); i++){
        if(i != indice){
          if(c.get(i).getX() == this.x && c.get(i).getY() == this.y){
            return true;
          }
        }
      }
        return false;
    }
    /**Méthod qui vérifie si un anneau dépasse des murs
    @return true si il dépasse*/
    public boolean depasse(int x, int y){
      return (this.x+x > Constantes.TAILLE-1 ||this.y+y > Constantes.TAILLE-1||this.x+x < 0|this.y+y < 0);
    }
}
