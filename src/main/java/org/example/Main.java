package org.example;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();

        Boolean esAdministrador;
        String respuetaPerfil;
        Double tarifaEnergia;
        Integer opcion;
        final String contrasena = "admin123*";
        String contrasenaUsuario;
        Integer contadorDeEnergia = 0;



        System.out.println("BIENVENIDO");
        System.out.print("¿Eres administrador?: ");
        respuetaPerfil = teclado.nextLine();

        //PROCESO PARA EL LOGIN
        if (respuetaPerfil.equalsIgnoreCase("si")) {
            //admin y me van a pedir la contraseña
            System.out.print("Digita tu contraseña: ");
            contrasenaUsuario = teclado.nextLine();
            //COMPARAMOS LA CONTRASEÑA QUE ESCRIBIMOS CON LA CONSTANTE ALMACENADA
            if (contrasenaUsuario.equals(contrasena)) {
                //FELICITACIONES USTED ES ADMINISTRADOR
                System.out.println("Usted es un admin");
                System.out.print("Ingresa el valor de KWH: ");
                tarifaEnergia = teclado.nextDouble();
                System.out.println("La tarifa energia quedo en: $" + tarifaEnergia);
                //GENERANDO DATOS PARA UNA EMPRESA
                //GENERAR UN CICLO QUE DE 30 VUELTAS
                Integer numeroVueltas = 0; //CONTADOR
                Integer contadorPicos = 0;
                do {
                    numeroVueltas = numeroVueltas + 1;
                    Integer numeroGenerado = generador.nextInt(400) + 1;
                    contadorDeEnergia = contadorDeEnergia + numeroGenerado;

                    System.out.println(numeroGenerado);

                    if (numeroGenerado > 300) {
                        System.out.println("pico detectado");
                        contadorPicos = contadorPicos + 1;
                    } else {
                        System.out.println("operando normalmente ");
                    }
                } while (numeroVueltas <= 30);
                System.out.println(numeroVueltas);
                System.out.println(contadorPicos);

                //MENU
                System.out.println("1. Ver tarifa ");
                System.out.println("2. Mostrar consumo promedio");
                System.out.println("3. Mostrar consumo picos");
                System.out.println("4. Mostrar factura");
                System.out.println("5. SALIR");

                //REPITIENDO EL MENU
                do {

                    System.out.print("Apreciado cliente, digite una opción: ");
                    opcion = teclado.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("La tarifa KHW es: " + tarifaEnergia);
                            break;

                        case 2:
                            System.out.println("El consumo total fue: " + contadorDeEnergia);
                            Double promedioConsumo = contadorDeEnergia / 30.0;
                            break;

                        case 3:
                            System.out.println("La cantidad de picos fue: " + contadorPicos);
                            break;
                        case 4:
                            System.out.println("El resumen de tu factura es: ");
                            Double totalPagar=contadorDeEnergia*tarifaEnergia;
                            System.out.println("$......"+totalPagar);
                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;

                    }
                } while (opcion != 5);


            } else {
                System.out.println("Usted es un hacker....");
            }
        } else {
                //empresa
                System.out.println("Usted es una empresa");
            }


        }
    }