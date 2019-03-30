// Kristen Brandt 171482
// HDT8
//Colas con prioridad + Heap
// Este es el programa hacho por mi no es utilizando el Java Colection FrameWork

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void print(Vector<Paciente> v){
        for(int i =0; i<v.size(); i++){
            System.out.println(v.get(i).toString());
        }
    }

    static String pacientesmenu = "\n Lectura de archivo de pacientes : \n" +
            "\t Ingresar la direccion del archivo de pacientes que quiere:\n" +
            "\t La direccion del archivo tiene que ser en formato C:\\\\Users\\\\try\\\\Desktop\\\\intento.txt\n" +
            "\t Si la direccion no es aceptada al primer intento ponga la direccion de nuevo, es por un problema de cache ";

    static String siguientemenu = "\n Desea ir con el siguiente paciente?(y/n) :" ;

    public static void main(String[] args) {
        boolean deleviaje = true;
        boolean siga = true;
        Scanner input = new Scanner(System.in);
        VectorHeap orden = new VectorHeap();

        do {
            System.out.print(pacientesmenu);
            System.out.println("\n");
            String archivo = input.nextLine();
            if (!archivo.equals("2")) {
                File archivoUsuarios = new File(archivo);
                //El codigo de buffered reader es tomado de la siguiente pagina.
                //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
                try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
                    String line;
                    System.out.print("Se esta guardando la lista de los pacientes... \n");
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(", ");
                        // este es el nombre del paciente
                        String part1 = parts[0];
                        String part2 = parts[1];
                        String part3 = parts[2];
                        Paciente paciente = new Paciente(part1,part2,part3);
                        //System.out.print(paciente.nombre);
                        //System.out.print(paciente.problema);
                        //System.out.print(paciente.prioridad);
                        orden.add(paciente);

                    }
                } catch (Exception e) {
                    System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                }
                print(orden.getData());
                siga = true;
                deleviaje = false;
            }
        } while (deleviaje);
        do {
            System.out.print(siguientemenu);
            System.out.println("\n");
            String respuesta = input.nextLine();
            switch (respuesta){
                case "y":
                    orden.remove();
                    print(orden.data);
                    break;
                case "n":
                    siga = false;
                    break;
                default:
                    siga = false;

            }
        }while(siga);
        System.out.print("\nSe esta apagando el programa...");
    }
}
