
package ort;

import alumno.Alumno;
import alumno.Comision;
import java.util.Scanner;


public class Ort {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de comisiones: ");
        int cantidadComisiones = scanner.nextInt();
        scanner.nextLine();
        
        Comision[] comisiones= new Comision[cantidadComisiones];
        
        
        for( int i=0; i<cantidadComisiones; i++){
        
            System.out.println("Ingrese el id de la comision: ");
            String idComision = scanner.nextLine();
            //scanner.nextLine();

            System.out.println("Ingrese la cantidad de clases para la comision " + idComision + ": ");
            int clases = scanner.nextInt();
            scanner.nextLine();


            System.out.println("Ingrese la cantidad de alumnos para la comision " + idComision + ": ");
            int cantidadAlumnos = scanner.nextInt();
            scanner.nextLine();

            Comision comision=new Comision(idComision);
           
            comision.setAlumnos(cantidadAlumnos);
            comision.setAsistencia(clases);

            comisiones[i]=comision;    
        
        }
            
        
        
        int tarde=0;
        
        for(int i=0; i< comisiones.length ; i++){
            
            int cantidad_clases= comisiones[i].getAsistencia().length;
            int edad=0;
            int cant_alumnos=0;
            
            for(int j=0; j<comisiones[i].getAlumnos().length ; j++ ){
                
                System.out.println(comisiones[i].getAlumnos()[j]);
                
                double presente=0;
                double falta=0;
                
                
                
                for(int k=0; k<comisiones[i].getAsistencia().length ; k++ ){
                
                    System.out.println(comisiones[i].getAsistencia()[k][j] +" " );
                    
                    if(comisiones[i].getAsistencia()[k][j]=='P'){
                        
                        presente+=1;
                    }
                    else if(comisiones[i].getAsistencia()[k][j]=='T'){
                        
                        falta+=0.5;
                        presente+=0.5;
                        
                        tarde+=1;
                    }
                    else{
                        falta+=1;
                    }
                    
                    double porcentaje= (presente*100)/cantidad_clases;
                    
                    if(porcentaje<75){
                       edad+= comisiones[i].getAlumnos()[j].getEdad();
                       cant_alumnos+=1;
                    }
                    
                    if(porcentaje >=75){
                        System.out.println("alumnos habilitados para rendir final, junto al porcentaje de presentismo");
                        System.out.println("el alumno es: " + comisiones[i].getAlumnos()[j].getApellido() + ", su presentismo es de "+ porcentaje+ "%" );
                    }
     
                }
                
            }
            double promedio;
            
            if(cant_alumnos!=0){
                 promedio=edad/cant_alumnos;
            }
            else{
                promedio=edad;
            }
            System.out.println("el promedio de edad de los alumnos inhabilitados para rendir final de la comision " +  comisiones[i].getId() + " es: " + promedio);
        }
        
        System.out.println("el número total de llegadas tarde es: "+ tarde);
        
        /*
            La condición para rendir el examen final es haber obtenido una asistencia mayor o igual al 75%.
        
            2. Obtener el promedio de edad de los alumnos inhabilitados para rendir final.
            3. Mostrar los apellidos de los alumnos habilitados para rendir final, junto al porcentaje de
            presentismo de cada uno.
            4. Obtener el número total de llegadas tarde para todo el período de cursada.
            5. Mostrar el porcentaje de presentismo por cada clase. (Las llegadas tarde cuentan como
            presente).
            6. Obtener la cantidad de clases con asistencia perfecta. (Las llegadas tarde cuentan como
            presente).
            7. Obtener la cantidad de faltas que hubo por cada clase.
        */
        
        for(int i=0; i< comisiones.length ; i++){
        
            int cantidad_clases=0;
            
            for(int j=0; j<comisiones[i].getAsistencia().length ; j++ ){ // la j es la clase
                
                System.out.println("la clase "+ (j+1));
                
                int presente=0;
                int cantidad_alumnos=comisiones[i].getAlumnos().length;
                
                int faltas=0;
                    
                for(int k=0; k < comisiones[i].getAsistencia()[j].length; k++ ){

                    char asistencia=comisiones[i].getAsistencia()[k][j];
                    
                    if(asistencia=='P' || asistencia=='T'){
                        
                        presente+=1;
                    }
                    else{
                        faltas+=1;
                    }
                    
                }
                
                System.out.println("la clase " + (j+1) + " tuvo " + faltas + " faltas");
                
                if(comisiones[i].getAsistencia().length == presente ){
                    
                    cantidad_clases+=1;
                }
            
                double porcentaje= (presente*100)/cantidad_alumnos;
                System.out.println("el porcentaje de presentismo de la clase "+ (j+1)+ " es de: " + porcentaje);
            }
            
            System.out.println("la cantidad de clases con presentismo perfecto es de: " + cantidad_clases);
            
        }
        
        
        //8. Mostrar los apellidos de los alumnos que dejaron la cursada (más de 5 ausencias seguidas)
        
        
        for(int i=0; i< comisiones.length ; i++){
            
            for(int j=0; j<comisiones[i].getAlumnos().length ; j++ ){
            
                for(int k=0; k<comisiones[i].getAsistencia().length ; k++ ){
                
                   if( (j+4) <= (comisiones[i].getAsistencia().length - 1) ){
                   
                      if( comisiones[i].getAsistencia()[k][j]=='A' &&    
                          comisiones[i].getAsistencia()[k][j+1]=='A' && 
                          comisiones[i].getAsistencia()[k][j+2]=='A'&&
                          comisiones[i].getAsistencia()[k][j+3]=='A' &&
                          comisiones[i].getAsistencia()[k][j+4]=='A' ){
                          
                          System.out.println("el alumno dejo la cursada: "+ comisiones[i].getAlumnos()[j]);
                      }
                      
                      
                   }
                    
                }
            }
            
        }
        
        
       
    }
    
}
