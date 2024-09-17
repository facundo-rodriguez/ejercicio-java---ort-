
package alumno;

import java.util.Scanner;

public class Comision {
    
    private String id;
    private Alumno[] alumnos;
    private char[][] asistencias;

    public Comision(String id) {
        this.id = id;
    }
    
    
    public String getId() {
        return id;
    }

  
    public Alumno[] getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(int cantidadAlumnos) {
        
        Scanner scanner = new Scanner(System.in);
        
        this.alumnos= new Alumno[cantidadAlumnos];
        
        for( int j=0; j<cantidadAlumnos; j++){
            
            System.out.println("Ingrese los datos del alumno " + j);
            
            System.out.println("Ingrese su legajo: ");
            String legajo = scanner.nextLine();

            System.out.println("Ingrese su apellido: ");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la edad: ");
            int edad = scanner.nextInt();

            scanner.nextLine();

            this.alumnos[j]=new Alumno(legajo, apellido, edad);
        }
    }
    
    

    public char[][] getAsistencia() {
        return asistencias;
    }
    

    public void setAsistencia(int cantidadClases) {
        
        Scanner scanner = new Scanner(System.in);
        
        this.asistencias=new char[cantidadClases][this.alumnos.length];
        
          for( int i=0; i<cantidadClases; i++){
              
              for(int j=0; j<this.alumnos.length; j++){

                  System.out.println("Ingrese la asistencia del alumno " + this.alumnos[j].getLegajo() + " para la clase "+ (i+1) );
                  
                  String asistencia = scanner.nextLine();
                  
                  char char_asistencia=asistencia.charAt(0);

                 // scanner.nextLine();
                  
                  this.asistencias[i][j]=char_asistencia;

                  
              
              }

        
        }
        
        
    }
    
    
}
