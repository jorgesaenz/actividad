import java.util.Arrays;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        String cubo[] = new String[6];
        System.out.println("Valores aceptados: G, R, B, O, W, Y");

        for( int i=0; i<6;i++){
            Boolean caraValida = true;
            String cara[] = new String[9];

            for(int j=0;j<9;j++){
                
                cara[j] = solicitarValorValido(j+1, i+1);

                if(j > 0){
                    if(caraValida && cara[j].equals(cara[j-1])){
                        caraValida = true;
                    }else{
                        caraValida = false;
                        System.out.println("ERROR: Cara ingresada no resuelta");
                        System.exit(0);
                    }
                }
            }
            if(caraValida){
                if(validarColorRepetido(cubo, cara)){
                    System.out.println("ERROR: Cara ingresada repetida");
                    System.exit(0);
                }else{
                    cubo[i] = cara[0];
                }
            }
                
        }
        System.out.println("EXITO: Cubo ingresado resuelto");
    }

    public static String solicitarValorValido(int indiceCara, int indiceCubo) {
        String valor = "";
        Boolean valorValido = true;
        Scanner lectura = new Scanner (System.in);
        String[] valores = {"G", "R", "B", "O", "W", "Y"};

        do{
            System.out.println("Ingrese valor[" + indiceCara + "] de la cara " + indiceCubo);
            valor = lectura.next();

            valorValido = Arrays.asList(valores).contains(valor);
            if(!valorValido){
                System.out.println("Favor de ingresar un valor aceptado");
                System.out.println("Valores Aceptados: G, R, B, O, W, Y");
            }

        }while(!valorValido);
        return valor;
    }

    public static Boolean validarColorRepetido(String caras[], String cara[]) {
        return Arrays.asList(caras).contains(cara[0]);
    }
    
}
