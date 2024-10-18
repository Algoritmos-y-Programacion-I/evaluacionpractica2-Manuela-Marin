package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {

        System.out.println("Seleccione el Tipo de pilar: (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energia: )");
        int pillarType = reader.nextInt();
        reader.nextLine();

        System.out.println("Ingrese el ID del Proyecto: ");
        String id = reader.nextLine();
        System.out.println("Ingrese el nombre del Proyecto: ");
        String name = reader.nextLine();
        System.out.println("Ingrese la descripcion del Proyecto: ");
        String description = reader.nextLine();
        System.out.println("El proyecto esta activo? (true/false): ");
        boolean status = reader.nextBoolean();

        boolean success = control.registerProjectInPillar(pillarType, id, name, description, status);

        if (success) {
            System.out.println("Proyecto registrado con exito");
        }else{
            System.out.println("Error al registrar el proyecto. Revise los datos o si el pilar ya tiene 50 proyectos");
        }


    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {
        System.out.println("Seleccione le tipo de pilar a consultar: (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energia: )");
        int pillarType = reader.nextInt();
        reader.nextLine();

        String result = control.queryProjectsByPillar(pillarType);
        System.out.println(result);

    }

}