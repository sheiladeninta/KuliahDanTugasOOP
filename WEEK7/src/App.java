public class App {
    public static void main(String[] args) {
        // for (int i = 0; i < 5; i++){
        //   System.out.println(i);
        int i = 0; int j=0;
        for (i=0; i<2; i++){
          for (j=i; j<3; j++){
            continue;
          }
          System.out.println("i:"+ i + "j:"+ j);
        }
        }
    }
