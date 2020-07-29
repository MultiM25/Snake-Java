import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**Classe abstraite servant de base a la création de Chenille
*/
public abstract class Chenille extends Component{

  private Random rand = new Random();
  protected ArrayList<Anneau> corps = new ArrayList<Anneau>();
  private int x;
  private int y;
  private int dir;
  private int[] dir_x = {1,0,-1,0};
  private int[] dir_y = {0,1,0,-1};
  private int last_x;
  private int last_y;
  /**Constructeur d'une chenille*/
  public Chenille(){
    this.x = rand.nextInt(Constantes.TAILLE) ;
    this.y = rand.nextInt(Constantes.TAILLE) ;
    this.dir = 0;
    corps.add(new Anneau(x,y,new Color(255,0,0)));
    corps.add(new Anneau(x+this.dir_x[2],y+this.dir_y[2],new Color(245, 93, 174)));
    corps.add(new Anneau(x+this.dir_x[2]*2,y+this.dir_y[2]*2,new Color(245, 93, 174)));
    last_x = corps.get(corps.size()-1).getX() - corps.get(corps.size()-2).getX();
    last_y = corps.get(corps.size()-1).getY() - corps.get(corps.size()-2).getY();
  }

  /**Methode qui affiche la chenille a l'écran
  @param g : L'objet ou l'on va poser les composants
  */
  public void paint(Graphics g){
    for(Anneau an : corps){
      an.paint(g);
    }
  }
  /**Méthode qui fait bouger la chenille et regarde si elle est traverse un mur ou si elle doit rebondir
  @param rebondir : Si true la chenille rebondit si proche d'un mur, passes a travers sinon*/
  public void bouge(boolean rebondir){

    if(corps.get(0).depasse(this.dir_x[this.dir],this.dir_y[this.dir]) && rebondir){
      corps.get(0).setPos(corps.get(corps.size()-1).getX() + this.last_x,corps.get(corps.size()-1).getY() + this.last_y);
      changeDir();
      ArrayList<Anneau> ex = new ArrayList<Anneau>();
      ex.add(corps.get(0));
      for(int j = corps.size()-1; j > 0 ; j--){
        ex.add(corps.get(j));
      }
      corps = ex;
      return;
    }
    for(int i = corps.size()-1; i >=0 ; i--){
      if(i == 0){
        if(corps.size() == 1){
          this.last_x = corps.get(0).getX();
          this.last_y = corps.get(0).getY();
        }
        corps.get(0).bouge(this.dir_x[this.dir],this.dir_y[this.dir]);
      }else{
        corps.get(i).setPos(corps.get(i-1).getX(),corps.get(i-1).getY());
      }
    }
    if(corps.size() > 1){
      this.last_x = corps.get(corps.size()-1).getX() - corps.get(corps.size()-2).getX();
      this.last_y = corps.get(corps.size()-1).getY() - corps.get(corps.size()-2).getY();
    }
  }
  /**Méthode qui change la direction de la chenille en vérifiant qu'elle ne se rentre pas dedans avec le changement
  @param dir : la nouvelle direction de la chenille */
  public void changeDir(int dir){
    switch(dir){
      case 0:
        if(this.dir != 2){
          this.dir = 0;
        }
        break;
      case 1:
      if(this.dir != 3){
        this.dir = 1;
      }
        break;
      case 2:
      if(this.dir != 0){
        this.dir = 2;
      }
        break;
      case 3:
      if(this.dir != 1){
        this.dir = 3;
      }
        break;
    }
  }
  /**Méthode qui change la direction de la chenille lorsqu'elle rebondit*/
  public void changeDir(){
    switch(this.dir){
      case 0:
          this.dir = 2;
        break;
      case 1:
        this.dir = 3;
        break;
      case 2:
        this.dir = 0;
        break;
      case 3:
        this.dir = 1;
        break;
    }
  }
  /**Méthode qui vérifie si une pomme n'est pas en contact avec un anneau de la chenille
  @param pomme : la pomme avec laquelle on vérifie les collisions
  @return true si il ya collisions
  */
  public boolean collisionPomme(Pomme pomme){
    int x = pomme.getX();
    int y = pomme.getY();
    for(Anneau an : corps){
      if(an.getX() == x && an.getY() == y){
        if(pomme.getTypePomme() == 1 || pomme.getTypePomme() == 2){
          this.ajouteAnneau(pomme.getTypePomme());
        }if(pomme.getTypePomme() == -1 || pomme.getTypePomme() == -2){
          this.retireAnneau(pomme.getTypePomme());
        }
        return true;
      }
    }
    return false;
  }
  /**Méthode qui ajoute des anneaux a la chenille
  @param nb : le nombre d'anneaux a ajouter*/
  public void ajouteAnneau(int nb){
    switch(nb){
      case 1:
        if(corps.size() == 1){
          corps.add(new Anneau(0,0,new Color(245, 93, 174)));
          corps.get(corps.size()-1).setPos(this.last_x,this.last_y);
        }else{
          corps.add(new Anneau(corps.get(corps.size()-1).getX() + this.last_x,corps.get(corps.size()-1).getY() + this.last_y,new Color(245, 93, 174)));
        }
        break;
      case 2:
      if(corps.size() == 1){
        corps.add(new Anneau(0,0,new Color(245, 93, 174)));
        corps.get(corps.size()-1).setPos(this.last_x,this.last_y);
        corps.add(new Anneau(0,0,new Color(245, 93, 174)));
        this.last_x = corps.get(corps.size()-2).getX() - corps.get(corps.size()-3).getX();
        this.last_y = corps.get(corps.size()-2).getY() - corps.get(corps.size()-3).getY();
        corps.get(corps.size()-1).setPos(corps.get(corps.size()-2).getX() + this.last_x,corps.get(corps.size()-2).getY() + this.last_y);
      }else{
        corps.add(new Anneau(corps.get(corps.size()-1).getX() + this.last_x,corps.get(corps.size()-1).getY() + this.last_y,new Color(245, 93, 174)));
        corps.add(new Anneau(corps.get(corps.size()-1).getX() + this.last_x,corps.get(corps.size()-1).getY() + this.last_y,new Color(245, 93, 174)));
      }
        break;
    }
  }
  /**Méthode qui retire des anneaux a la chenille
  @param nb : le nombre d'anneaux a retirer*/
  public void retireAnneau(int nb){
    switch(nb){
      case -1:
      if(corps.size() > 1){
        corps.remove(corps.get(corps.size()-1));
      }
        break;
      case -2:
      if(corps.size() > 2){
        corps.remove(corps.get(corps.size()-1));
        corps.remove(corps.get(corps.size()-1));
      }
        break;
    }
  }
  /**Méthodes abstraite qui gère les collisions entre les différents anneaux de la chenille*/
  public abstract boolean collisionAnneau();
}
