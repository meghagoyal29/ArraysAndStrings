import java.util.*;

// Write your Checker class here
class Checker implements Comparator{
  public int compare(Object a, Object b){
      
      Player p1  = (Player)a;
      Player p2  = (Player)b;
           
      if(p1.score>p2.score){
          return 1;
      }else if(p1.score<p2.score)
          return -1;
      else{
         char[] name1 = p1.name.toCharArray();
          char[] name2 = p2.name.toCharArray();
          if(name1.length >= name2.length)
             return comapreNames(name2, name1);
          else
              return comapreNames(name1, name2);
          
      }
  }
    private int comapreNames(char[] name1, char[] name2){
        for(int i=0; i< name1.length; i++){
            if(name1[i]<name1[i])
                return -1;
            else
                return 1;
        }
        return 1;
    }
}
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class ComparatorExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}