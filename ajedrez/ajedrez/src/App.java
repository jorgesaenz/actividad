import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        int tablero[][] =   {   
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}
        }; 

        int valorX;
        int valorY;
        for( int a=1; a<8; a++){
            System.out.println("Reyna #" + a );
            valorX = solicitarNumeroValido("Ingresa coordenada X: ", 1,8);
            valorY = solicitarNumeroValido("Ingresa coordenada Y: ", 1,8);

            tablero[valorX][valorY] = 1;

            if(validarAtaque(valorX, valorY, tablero)){
                System.out.println("Reyna Bajo ataque");
                System.exit(0);
            }
        }

    }

    public static int solicitarNumeroValido(String mensaje, int minimo, int maximo) {
        Scanner s = new Scanner(System.in);
        int numero;
        while (true) {
            System.out.println(mensaje);
            if (s.hasNextInt()) {
                numero = s.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    return numero-1;
                } else {
                    System.out.println("Número fuera de rango. Intente de nuevo");
                }
            } else {
                s.next();
            }
        }
    }


    public static Boolean validarAtaque(int valorX, int valorY,int tablero[][]){
        Boolean ataque = false;
        int auxx1 = 0;
        int auxy1 = 0;
        for( int i=0; i<8; i++ ){
            if(tablero[valorX][i] == 1 && i != valorY){
                ataque = true;
            }else if(tablero[i][valorY] == 1 && i != valorX){
                ataque = true;
            }
        }

        auxx1 = valorX;
        auxy1 = valorY;
        while(auxx1-1 >= 0 && auxy1-1 >= 0){
            auxx1 = auxx1 - 1 ;
            auxy1 = auxy1 - 1;

            if(tablero[auxx1][auxy1] == 1){
                ataque = true;
            }
        }
        auxx1 = valorX;
        auxy1 = valorY;
        while(auxx1+1 <= 7 && auxy1+1 <= 7){
            auxx1 = auxx1 + 1 ;
            auxy1 = auxy1 + 1;

            if(tablero[auxx1][auxy1] == 1){
                ataque = true;
            }
        }
        auxx1 = valorX;
        auxy1 = valorY;
        while(auxx1+1 <= 7 && auxy1-1 >= 0){
            auxx1 = auxx1 + 1 ;
            auxy1 = auxy1 - 1;

            if(tablero[auxx1][auxy1] == 1){
                ataque = true;
            }
        }
        auxx1 = valorX;
        auxy1 = valorY;
        while(auxx1-1 >= 0 && auxy1+1 <= 7){
            auxx1 = auxx1 - 1 ;
            auxy1 = auxy1 + 1;

            if(tablero[auxx1][auxy1] == 1){
                ataque = true;
            }
        }

        return ataque;
    }

}
