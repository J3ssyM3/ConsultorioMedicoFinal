package Sistema;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Loader loader = new Loader();
        loader.load();
        Scanner lectura = new Scanner(System.in);
        String usuario;
        String contraseña;
        String usuarioRegistroC;

        System.out.print("-->  Ingresé el usuario para poder acceder al sistema <-- : ");
        usuario = lectura.nextLine();

        if(loader.usuariosHash.containsKey(usuario)){

            System.out.print("-->  Ingresé la contraseña <-- : ");
            contraseña = lectura.nextLine();

            usuarioRegistroC = loader.usuariosHash.get(usuario);

            if (contraseña.equals(usuarioRegistroC)){
                boolean exit = true;
                int opc;

                do{
                    try{
                        opc = Menu();
                        switch (opc){
                            case 1:
                                String DocID = String.format("   * DOCTOR - " + (loader.doctoresArrayList.size()+1));
                                System.out.print("--> Ingresé su Nombre Doctor <-- : ");
                                String docNombre = lectura.nextLine();

                                System.out.print("--> Ingresé su Especialidad <--: ");
                                String docEspecialidad = lectura.nextLine();


                                Doctores doctor = new Doctores();
                                doctor.setDocID(DocID);
                                doctor.setDocNombre(docNombre);
                                doctor.setDocEspecialidad(docEspecialidad);
                                loader.doctoresArrayList.add(doctor);
                                break;

                            case 2:
                                String pacID = String.format("   * PACIENTE - " + (loader.pacientesArrayList.size()+1));
                                System.out.print("--> Ingresé su Nombre Paciente: ");
                                String pacNombre = lectura.nextLine();

                                Paciente paciente = new Paciente();
                                paciente.setPacID(pacID);
                                paciente.setPacNombre(pacNombre);
                                loader.pacientesArrayList.add(paciente);
                                break;

                            case 3:
                                String citaID = String.format("   * CITA - " +  (loader.citasArrayList.size()+1));
                                System.out.print("--> Ingresé la fecha de la cita como se muestra aqui --> dd/mm/aa: <-- ");
                                String citaFecha = lectura.nextLine();

                                System.out.print("--> Ingresé la Hora de la cita en formato 24h: <-- ");
                                String citaHora = lectura.nextLine();

                                System.out.println("---- Selecciona el número de paciente para la cita: ----");
                                System.out.println("|NÚMERO  |    ID DEL PACIENTE    |       NOMBRE DEL PACIENTE       | ");

                                for (int i=0; i<loader.pacientesArrayList.size(); i++){
                                    String p = String.format((i+1) +"  \t\t\t  " + loader.pacientesArrayList.get(i).getPacID() + " \t\t\t\t "
                                            + loader.pacientesArrayList.get(i).getPacNombre());
                                    System.out.println(p);
                                }
                                String selecID = lectura.nextLine();
                                int SelecID = Integer.parseInt(selecID);
                                SelecID = SelecID-1;
                                String citaPacienteID = loader.pacientesArrayList.get(SelecID).getPacID();

                                System.out.println("---- Selecciona el número de Doctor para la cita: ----");
                                System.out.println("|NÚMERO   |    ID DEL DOCTOR    |      NOMBRE DEL DOCTOR      |        ESPECIALIDAD     | ");

                                for (int i=0; i<loader.doctoresArrayList.size(); i++){
                                    String p = String.format((i+1) +" \t\t\t " + loader.doctoresArrayList.get(i).getDocID() + "\t\t\t"
                                            +loader.doctoresArrayList.get(i).getDocNombre() + "\t\t" +
                                            loader.doctoresArrayList.get(i).getDocEspecialidad());
                                    System.out.println(p);
                                }
                                selecID = lectura.nextLine();
                                SelecID = Integer.parseInt(selecID);
                                SelecID = SelecID-1;
                                String citaDoctorID = loader.doctoresArrayList.get(SelecID).getDocID();

                                System.out.print("--> Ingresé el Motivo de la Cita: <--");
                                String citaMotivo = lectura.nextLine();

                                Cita cita = new Cita(citaID,citaFecha,citaHora,citaPacienteID,citaDoctorID,citaMotivo);
                                loader.citasArrayList.add(cita);
                                break;
                            case 4:
                                System.out.println("------------------------------- DOCTORES ------------------------------------ ");
                                System.out.println("|NÚMERO   |    ID DEL DOCTOR    |    NOMBRE DEL DOCTOR    |     ESPECIALIDAD     |");

                                for (int i=0; i<loader.doctoresArrayList.size(); i++){
                                    String p = String.format((i+1) + "\t\t\t" +loader.doctoresArrayList.get(i).getDocID() + "\t\t\t"
                                            +loader.doctoresArrayList.get(i).getDocNombre() +"\t\t" +
                                            loader.doctoresArrayList.get(i).getDocEspecialidad());
                                    System.out.println(p);
                                }
                                break;
                            case 5:
                                System.out.println("--------------------------- PACIENTES -------------------------");
                                System.out.println("|NÚMERO  |   ID DE PACIENTE   |    NOMBRE DEL PACIENTE    | ");

                                for (int i=0; i<loader.pacientesArrayList.size(); i++){
                                    String p= String.format((i+1) + "\t\t\t" + loader.pacientesArrayList.get(i).getPacID() + "\t\t\t\t"
                                            + loader.pacientesArrayList.get(i).getPacNombre());
                                    System.out.println(p);
                                }
                                break;
                            case 6:
                                System.out.println("---------------------------------------------- CITAS --------------------------------------------------");
                                System.out.println("|NÚMERO  |   ID DE CITA  |  FECHA  | HORA |    ID PACIENTE   |    ID DOCTOR    |      MOTIVO     | ");

                                for (int i=0; i<loader.citasArrayList.size(); i++){
                                    String output= String.format((i+1) +"\t\t\t" +loader.citasArrayList.get(i).getCitaID() +"\t\t"
                                            +loader.citasArrayList.get(i).getCitaFecha() + "\t"
                                            +loader.citasArrayList.get(i).getCitaHora() + "\t\t"
                                            +loader.citasArrayList.get(i).getCitaPacienteID() + "\t\t\t"
                                            +loader.citasArrayList.get(i).getCitaDoctorID() + "\t\t"
                                            +loader.citasArrayList.get(i).getCitaMotivo());
                                    System.out.println(output);
                                }
                                break;
                            case 7:
                                System.out.println("Saliendo...");
                                System.out.println("¡LISTO!");
                                exit = false;
                                break;
                            default:
                                System.out.println("¡Error! --> Opción no válida.");
                                break;
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                } while (exit);
            } else{
                System.out.println(" ¡CONTRASEÑA INCORRECTA!--> intentalo de nuevo");
            }
        } else{
            System.out.println(" ¡EL USUARIO NO EXISTE! ");
        }
        loader.save();
    }
    public static int Menu() throws Exception{
        Scanner lectura = new Scanner(System.in);
        int opcion;

        System.out.println("---> BIENVENIDO AL SISTEMA DE ADMINIDTRACIÓN DE CITAS <---");
        System.out.println("----------> Elige la opción que desees realizar <---------");
        System.out.println("Dar de alta Doctores---------> [1]");
        System.out.println("Dar de alta Pacientes--------> [2]");
        System.out.println("Crear Cita-------------------> [3]");
        System.out.println("Ver Doctores-----------------> [4]");
        System.out.println("Ver Pacientes----------------> [5]");
        System.out.println("Ver Citas--------------------> [6]");
        System.out.println("Salir------------------------> [7]");
        opcion = lectura.nextInt();

        if ((opcion<0)||(opcion>7)){
            throw new Exception(" ¡Opción no válida! --> Por favor Ingresa un número del 1 al 7.");
        }
        return opcion;
    }


}