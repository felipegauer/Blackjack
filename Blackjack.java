import java.util.Random;
import java.util.Scanner;

/**
 * Escreva uma descrição da classe Blackjack aqui.
 * 
 * @author felipe.gattelli@edu.pucrs.br
 * @version (um número da versão ou uma data)
 */
public class Blackjack
{
    public static int gerarCarta(Random r) {
        int carta = r.nextInt(13)+ 1;
        String card="";
        if (carta>10||carta==1){
            card=mostrarCarta(carta);
            switch(card){
                case "J":
                    carta=10;
                    break;
                case "Q":
                    carta=10;
                    break;
                case "K":
                    carta=10;
                    break;
            }
        }
        mostrar(card,carta);
        return carta;
    }
    public static int gerarMesa(Random r){
        int carta = r.nextInt(13)+1;
        String card="";
        if (carta>10||carta==1){
            card=mostrarCarta(carta);
            switch(card){
                case "J":
                    carta=10;
                    break;
                case "Q":
                    carta=10;
                    break;
                case "K":
                    carta=10;
                    break;
            }
        }
        return carta;
    }
    public static String mostrarCarta(int carta){
        String card="";
       switch (carta){
           case 1:
               card="A";
               break;
            case 11:
                card="J";
                break;
            case 12:
                card="Q";
                break;
            case 13:
                card="K";
                break;
       }
       return card;
    }
    public static void mostrar(String card, int carta){
        if(card.equals(""))
            System.out.printf("Carta : %d%n", carta);
        else
            System.out.printf("Carta : %s%n", card);
        return;
    }
    public static int outracarta(int j1,int j2,int j3, Random r){
        Scanner in = new Scanner(System.in);
        String perg="";
        do{
            System.out.println("Quer outra carta?(s/n)");
            perg = in.nextLine(); 
            if(perg.equals("s") || perg.equals("S")){
                j3= j3 + gerarCarta(r);
            }
            System.out.printf("Total  : %d%n", j1 + j2 + j3);
        }while(perg.equals("s") || perg.equals("S"));
        in.close();
        return j3;
    }
    public static int outraCartaMesa(int c1,int c2,int j1,int j2,int j3,Random r){
        int c3=0;
        while(j1+j2+j3 > c1+c2 && j1+j2+j3<=21){
            if(c3>21 || c1+c2+c3>j1+j2+j3)
                break;
            else
                c3=c3 + gerarCarta(r);
        }
        return c3;
    }
    public static void main(String[] args) {
        Random r;
        int c1, c2,c3;
        int j1, j2,j3;
        j3=0;
        c3=0;
        String card="";
        
        r = new Random();
        System.out.printf("COMPUTADOR%n");        
        c1 = gerarCarta(r);
        
        System.out.printf("total(sem a segunda carta):%d%n",c1);
        
        System.out.printf("HUMANO%n");
        j1 = gerarCarta(r);
        j2 = gerarCarta(r);
        


        System.out.println("Total:"+(j1+j2));
        
        j3=outracarta(j1,j2,j3,r);
        System.out.println("-----------------------");
        System.out.println("Computador:");
        
        c2 = gerarMesa(r);
        mostrar(card,c2);
        
        if(j1+j2+j3 > c1+c2 && j1+j2+j3<=21){
            c3= outraCartaMesa(c1,c2,j1,j2,j3,r);
        }
        
        System.out.printf("total computador: %d%n", c1+c2+c3);
        System.out.println("-----------------------");
        
        if(j1+j2+j3 > c1+c2 && j1+j2+j3<=21 ){
            System.out.println("GANHOU!");
        }else{
             System.out.println("PERDEU!");
        }
        
        
    }
}