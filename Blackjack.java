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
        if (carta>10||carta==1)
            card=mostrarCarta(carta);
        mostrar(card,carta);
        return carta;
    }
    public static String mostrarCarta(int carta){
        Scanner in = new Scanner(System.in);
        int A;
        String card="";
        if(carta==11)
            card="J";
        else if(carta ==12)
            card="Q";
        else if(carta == 13)
            card="K";
        else if(carta==1){
            System.out.println("Você pegou um ÁS, quer que seja 1 ou 11?");
            A=in.nextInt();
            if(A==1)
                card="A(1)";
            else if(A==11)
                card="A(11)";    
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
            perg = in.nextLine(); 
            if(perg.equals("s") || perg.equals("S")){
                j3= j3 + gerarCarta(r);
            }
            System.out.printf("Total  : %d%n", j1 + j2 + j3);
        }while(perg.equals("s") || perg.equals("S"));
        in.close();
        return j3;
    }
    
    public static void main(String[] args) {
        Random r;
        int c1, c2;
        int j1, j2,j3;
        j3=0;
        
        r = new Random();
        System.out.printf("COMPUTADOR%n");        
        c1 = gerarCarta(r);
        c2 = gerarCarta(r);
        System.out.printf("total(sem a segunda carta):%d%n",c1);
        
        System.out.printf("HUMANO%n");
        j1 = gerarCarta(r);
        j2 = gerarCarta(r);
        


        System.out.println("Total:"+(j1+j2));
        System.out.println("Quer outra carta?");
        
        j3=outracarta(j1,j2,j3,r);
        if(j1+j2+j3 > c1+c2 && j1+j2+j3<=21 ){
            System.out.println("GANHOU!");
        }else{
             System.out.println("PERDEU!");
        }
        
        
    }
}