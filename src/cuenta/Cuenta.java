/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author julis
 */
public class Cuenta {
    
    private long numero;
    private String titular;
    private float saldo;
    private float interesAnual;
    //Librireria a utilizar
    Scanner num = new Scanner(System.in);
    Scanner un = new Scanner(System.in);
    
    public void Datos(){//ESTE MÉTOD NOS PERMITE INGRESAR LOS DATOS DEL CLIENTE
        System.out.println("*****Bienvenido a tu banco AVVC****");
        System.out.println("Ingresa los datos del cliente: ");
        System.out.println("Nombre del nuevo cliente: ");
        titular = num.next();
        System.out.println("Numero de la cuenta: ");
        numero = num.nextLong();
        System.out.println("El interes anual: ");
        interesAnual = num.nextFloat();
    }
     public void Datos2(){//ESTE MÉTOD NOS PERMITE INGRESAR LOS DATOS DEL CLIENTE
        System.out.println("Ingrese los datos del nuevo cliente: ");
        System.out.println("Nombre del nuevo cliente: ");
        titular = un.next();
        System.out.println("Numero de la cuenta: ");
        numero = un.nextLong();
        System.out.println("El interes anual: ");
        interesAnual = un.nextFloat();
    }
     public void Menu(){
         System.out.println("****BIENVENIDO AL MENU DE OPCUONES****** ");
         System.out.println("1.- Igresar saldo.  ");
         System.out.println("2.- Retirar saldo.  ");
         System.out.println("3.- Interes mensual.");
         System.out.println("4.- Mostrar saldo.  ");
         System.out.println("5.- Dar de alta a cliente.");
         System.out.println("6.- Igresar saldo.  ");
         System.out.println("7.- Retirar saldo.  ");
         System.out.println("8.- Interes mensual.");
         System.out.println("9.- Mostrar saldo.  ");
     }
    public Cuenta(long aNumero, String aTitular,float aInteresAnual){
        numero = aNumero;
        titular = aTitular;
        saldo = 0;
        interesAnual = aInteresAnual;
    }
    public void ingreso(float cantidad){
        saldo = saldo +cantidad;
    }
    public void reintegro(float cantidad){//SE RETIRA EL DINERO
        saldo = saldo - cantidad;
    }
    public float IngresoMensual(){
        //SE CALCULA EL INGTERES ANUAL Y SE LE SUMA AL SALDO
        interesAnual = ((interesAnual/100)*saldo);
        
        saldo = interesAnual +saldo;
        return interesAnual;
    }
    public void ingreso2(float cantidad){
        saldo = saldo +cantidad;
    }
    public void reintegro2(float cantidad){
        saldo = saldo - cantidad;
    }
     public float IngresoMensual2(){
        //SE CALCULA EL INGTERES ANUAL Y SE LE SUMA AL SALDO
        interesAnual = ((interesAnual/100)*saldo);
        
        saldo = interesAnual +saldo;
        return interesAnual;
    }
    public boolean enRojos(){return saldo < 0;}
    public float leerSaldo(){return saldo;}
    public float leerSaldo2(){return saldo;}
    
    
    public static void main(String[] args) {
        //VARIABLES
      long numeroC = 0;
    String titular = "";
    float saldo, interesesAnual = 0;
    Scanner uno = new Scanner(System.in);
    //SECREA EL OBJETO PARA LA CLASE
    Cuenta ob = new Cuenta(numeroC, titular, interesesAnual);
    //SE MANDA LLAMAR EL MÉTODO DE LA CLASE CUENTA
    ob.Datos();
    
    //SE INICIALIZA LA VARIABLE PARA ENTRAR AL CICLO
    int ingresar = 1;
    do{//SE INIC EL CICLO LLAMANDO EL MENU
        ob.Menu();
        //SE ALMACENA EL VALOR DE LA VARIABLE
        //DE LA OPCUON DESEADA
        ingresar = uno.nextInt();
        //SEGUN LA OPCION SELECCIONADA ES EL CASO
        //QUE SE EJECUTARA EN EL SWITCH
        switch(ingresar){
            //MUESTRA EL MENSAJE Y EL ALAMACENA EL SALDO
            //QUE INGRESAMOS
            case 1: 
                System.out.println("Monto a ingresar: ");
                saldo = uno.nextFloat();
                //SE MANDA LLAMAR EL MÉTODO PARA INGRESAR
                ob.ingreso(saldo);
                break;   
            case 2:
                //SE RETIRA EL DINERO QUE DESEA 
                    System.out.println("Monto a retirar: ");
                    //VARIABLE DE ALMACENAMIENTO
                    saldo = uno.nextFloat();
                    //SI EL VALOR DEL RETIRO ES MAYOR QUE EL DEL
                    //SALDO NO SE PUEDE RETIRAR EL MONTO INGRESADO
                    if(ob.leerSaldo() < saldo)
                    System.out.println("Saldo insufuciente ");
                    else{//SI EL VALOR DEL RETIRO ES MENOR QUE EL 
                        //SALDO SI SE PUEDE RETIRAR
                        System.out.println("Retiro exitoso ");
                        ob.reintegro(saldo);
                    }
                    break;
            case 3: 
                //SE CALCULA EL INTERES ANUAL Y SE SUMA AL SALDO
                System.out.println("Interes Mensual " + ob.IngresoMensual());
                //SE MUESTRA EL SALDO TOTAL
                System.out.println("Saldo total: " + ob.leerSaldo());
                break;
            case 4:
                //SE REVISA EL SALDO SI NO HAY SALDO DISPONIBLE
                //MANDA ESTE MENSAJE
                if(ob.leerSaldo() <= 0)
                    System.out.println("Saldo insuficiente");
                else{//SI HAY SALDO DISPONIBLE MANDA EL TOTAL
                    //DE SALDO QUE TIENES
                    System.out.println("El saldo es de: " + ob.leerSaldo());
                    ob.leerSaldo();
                    break;
                }
            case 5:
                ob.Datos2();
                break;
            case 6:
                System.out.println("Monto a ingresar: ");
                saldo = uno.nextFloat();
                //SE MANDA LLAMAR EL MÉTODO PARA INGRESAR
                ob.ingreso2(saldo);
                break;
            case 7:
                //SE RETIRA EL DINERO QUE DESEA 
                    System.out.println("Monto a retirar: ");
                    //VARIABLE DE ALMACENAMIENTO
                    saldo = uno.nextFloat();
                    //SI EL VALOR DEL RETIRO ES MAYOR QUE EL DEL
                    //SALDO NO SE PUEDE RETIRAR EL MONTO INGRESADO
                    if(ob.leerSaldo2() < saldo)
                    System.out.println("Saldo insufuciente ");
                    else{//SI EL VALOR DEL RETIRO ES MENOR QUE EL 
                        //SALDO SI SE PUEDE RETIRAR
                        System.out.println("Retiro exitoso ");
                        ob.reintegro2(saldo);
                    }
                    break;
            case 8: 
                //SE CALCULA EL INTERES ANUAL Y SE SUMA AL SALDO
                System.out.println("Interes Mensual " + ob.IngresoMensual2());
                //SE MUESTRA EL SALDO TOTAL
                System.out.println("Saldo total: " + ob.leerSaldo2());
                break;
            case 9:
                //SE REVISA EL SALDO SI NO HAY SALDO DISPONIBLE
                //MANDA ESTE MENSAJE
                if(ob.leerSaldo2() <= 0)
                    System.out.println("Saldo insuficiente");
                else{//SI HAY SALDO DISPONIBLE MANDA EL TOTAL
                    //DE SALDO QUE TIENES
                    System.out.println("El saldo es de: " + ob.leerSaldo2());
                    ob.leerSaldo();
                    break;
                }
        }
    }while(ingresar < 9);   
    }
    
}

