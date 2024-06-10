import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        double sumaNotas=0;
        HashMap<String, Double> diccionario = new HashMap<>();
        byte cantidadEstudiantes;

        while (true) {
            try {

                System.out.println("BIENVENIDO");
                System.out.println("Digite la cantidad de estudiantes que registrara: ");
                cantidadEstudiantes = scanner.nextByte();
                scanner.nextLine();
                break;

            }catch(InputMismatchException e){
                System.out.println("DIGITE UNA CANTIDAD NUMERICA");
            }
            catch(Exception e){
                System.out.println("HA OCURRIDO UN ERROR INESPERADO");
            }
            scanner.nextLine();
        }

        for(byte i=0; i<cantidadEstudiantes; i++){
            String nombreEstudiante;
            double nota;
            
            while (true) {
                try {
                    System.out.println("DIGITE EL NOMBRE: ");
                    nombreEstudiante = scanner.next();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("INGRESE SU NOMBRE DE NUEVO!!!");
                } catch(Exception e){
                    System.out.println("HA OCURRIDO UN ERROR INESPERADO");
                }
                scanner.nextLine();
            }

            while (true) {
                try {
                    System.out.println("DIGITE SU CALIFICACION: ");
                    nota = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                }catch(InputMismatchException e){
                    System.out.println("ENTRADA NO VALIDA!!!");
                }
                catch(Exception e){
                    System.out.println("HA OCURRIDO UN ERROR INESPERADO");
                }
                scanner.nextLine();
            }
            
            diccionario.put(nombreEstudiante, nota);
            sumaNotas += nota;
            System.out.println("\n=============\n\n");
        }

        double promedio = ((double)Math.round((sumaNotas/(double)cantidadEstudiantes) * 100d) / 100d);   //Redondeo la nota a 2 cifras decimales
        
        Iterator <String> iterador = diccionario.keySet().iterator();  //para acceder a cada estudiante dentro del diccionario
        while (iterador.hasNext()) {
            String Nombre = iterador.next();
            if (diccionario.get(Nombre) > promedio){
                System.out.println("============\n" + Nombre + " ha obtenido una nota superior al promedio\n");
            }
        }

        scanner.close();
    }
}
