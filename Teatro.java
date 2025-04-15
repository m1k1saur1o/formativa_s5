package teatro;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Teatro {

    //Justifico la cración de una clase anidada debido a que es mas
    //facil el manejo de la fila y el asiento y otras funcionalidades 
    //si es que estan dentro de un solo objeto 
    static class Entrada {

        int fila; //1 = vip, 2 = platea, 3 = general
        int descuento; // descuento segun corresponda
        int total; // total a pagar
        int tipo; // 3 = general, 1 = estudiante, 2 = adulto mayor

        Entrada(int fila, int total, int descuento, int tipo) {
            this.fila = fila;
            this.descuento = descuento;
            this.total = total;
            this.tipo = tipo;
        }

        void imprimir() {
            String nombreFila;

            switch (fila) {
                case 1 -> {
                    nombreFila = "Fila VIP";
                }

                case 2 -> {
                    nombreFila = "Fila PLATEA";
                }

                case 3 -> {
                    nombreFila = "Fila GENERAL";
                }

                default -> {
                    nombreFila = "ERROR";
                }
            }

            System.out.println("");
            System.out.println("********** BOLETA **********");
            System.out.println("** Ubicacion: " + nombreFila);
            System.out.println("** Descuento: " + descuento);
            System.out.println("** Total: " + total);
            System.out.println("****************************");
        }
    }

    static String nombreTeatro = "Tatro Moro";
    static int entradasVendidas = 0;
    static int capacidad = 30;
    static int precioEntradaVip = 50000;
    static int precioEntradaPlatea = 40000;
    static int precioEntradaGeneral = 20000;
    static int asientosFila = 10;

    public static void main(String[] args) {
        //10% estudantes 15% adultos mayores mas de 5 10%
        int filaVip = 0;
        int filaPlatea = 0;
        int filaGeneral = 0;
        //Justifico el uso de un arreglo dinamico
        //debido a que es facil el tema de eliminar
        //y agregar entradas
        ArrayList<Entrada> entradas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int edad;
        int cantidadEntradas = 0;
        int descuento;
        int total;
        int tipo;

        menu:
        while (true) {
            System.out.println("");
            System.out.println("******** " + nombreTeatro + " ********");
            System.out.println("** 1.- Comprar entrada.");
            System.out.println("** 2.- Promociones.");
            System.out.println("** 3.- Buscar entradas.");
            System.out.println("** 4.- Eliminar entrada.");
            System.out.println("** 5.- Salir.");
            System.out.println("****************************");
            System.out.print("\nElija una opcion (1 - 2 - 3 - 4 - 5): ");

            while (true) {
                try {
                    opcion = scanner.nextInt();
                    if (opcion > 0 && opcion < 6) {
                        break;
                    } else {
                        System.out.print("ERROR, Ingrese una opcion valida: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("ERROR, Ingrese una opcion valida: ");
                    scanner.next();
                }
            }

            switch (opcion) {

                case 1 -> {
                    ArrayList<Entrada> entradasCompradas = new ArrayList<>();

                    System.out.print("\nCuantas entradas desea comprar?: ");
                    while (true) {
                        try {
                            cantidadEntradas = scanner.nextInt();
                            if (cantidadEntradas > 0 && cantidadEntradas <= capacidad - entradasVendidas) {
                                break;
                            } else {
                                System.out.print("\nERROR, "
                                        + (!(cantidadEntradas > 0 && cantidadEntradas <= capacidad - entradasVendidas)
                                                ? "no quedan suficientes entradas.\n"
                                                : "ingrese un numero valido: "));
                                
                                if (capacidad == entradasVendidas) {
                                    continue menu;
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("ERROR, Ingrese una opcion valida: ");
                            scanner.next();
                        }
                    }

                    for (int i = 0; i < cantidadEntradas; i++) {
                        while (true) {
                            System.out.println("\n** ENTRADA " + (i + 1));
                            System.out.println("1.- Fila Vip.");
                            System.out.println("2.- Fila Platea.");
                            System.out.println("3.- Fila General.");

                            System.out.print("\nSeleccione una fila: ");
                            while (true) {
                                try {
                                    opcion = scanner.nextInt();
                                    if (opcion > 0 && opcion < 4) {

                                        switch (opcion) {
                                            case 1 -> {
                                                if (filaVip < asientosFila) {
                                                    filaVip++;
                                                    entradasVendidas++;
                                                    break;
                                                } else {
                                                    System.out.print("Fila Vip llena, seleccione otra fila: ");
                                                    continue;
                                                }
                                            }

                                            case 2 -> {
                                                if (filaPlatea < asientosFila) {
                                                    filaPlatea++;
                                                    entradasVendidas++;
                                                    break;
                                                } else {
                                                    System.out.print("Fila Platea llena, seleccione otra fila: ");
                                                    continue;
                                                }
                                            }

                                            case 3 -> {
                                                if (filaGeneral < asientosFila) {
                                                    filaGeneral++;
                                                    entradasVendidas++;
                                                    break;
                                                } else {
                                                    System.out.print("Fila General llena, seleccione otra fila: ");
                                                    continue;
                                                }
                                            }

                                            default -> {
                                                System.out.println("panico");
                                            }
                                        }

                                        break;
                                    } else {
                                        System.out.print("ERROR, Ingrese una opcion valida: ");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.print("ERROR, Ingrese una opcion valida: ");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("\nIngrese edad: ");
                                try {
                                    edad = scanner.nextInt();
                                    if (edad > 0) {
                                        break;
                                    } else {
                                        System.out.print("ERROR, Ingrese una opcion valida: ");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.print("ERROR, Ingrese una opcion valida: ");
                                    scanner.next();
                                }
                            }

                            switch (opcion) {

                                case 1 -> {

                                    if (edad < 18) {
                                        descuento = (int) Math.ceil(precioEntradaVip * 0.1);
                                        tipo = 1;
                                    } else if (edad > 60) {
                                        descuento = (int) Math.ceil(precioEntradaVip * 0.15);
                                        tipo = 2;
                                    } else {
                                        descuento = 0;
                                        tipo = 3;
                                    }

                                    total = precioEntradaVip - descuento;

                                    Entrada entrada = new Entrada(
                                            opcion,
                                            total,
                                            descuento,
                                            tipo
                                    );

                                    entradasCompradas.add(entrada);
                                }

                                case 2 -> {
                                    if (edad < 18) {
                                        descuento = (int) Math.ceil(precioEntradaPlatea * 0.1);
                                        tipo = 1;
                                    } else if (edad > 60) {
                                        descuento = (int) Math.ceil(precioEntradaPlatea * 0.15);
                                        tipo = 2;
                                    } else {
                                        descuento = 0;
                                        tipo = 3;
                                    }

                                    total = precioEntradaPlatea - descuento;

                                    Entrada entrada = new Entrada(
                                            opcion,
                                            total,
                                            descuento,
                                            tipo
                                    );

                                    entradasCompradas.add(entrada);
                                }

                                case 3 -> {
                                    if (edad < 18) {
                                        descuento = (int) Math.ceil(precioEntradaGeneral * 0.1);
                                        tipo = 1;
                                    } else if (edad > 60) {
                                        descuento = (int) Math.ceil(precioEntradaGeneral * 0.15);
                                        tipo = 2;
                                    } else {
                                        descuento = 0;
                                        tipo = 3;
                                    }

                                    total = precioEntradaGeneral - descuento;

                                    Entrada entrada = new Entrada(
                                            opcion,
                                            total,
                                            descuento,
                                            tipo
                                    );

                                    entradasCompradas.add(entrada);
                                }

                                default -> {
                                    System.out.println("panico");
                                }
                            }
                            break;
                        }
                    }
                    total = 0;
                    for (Entrada entrada : entradasCompradas) {
                        entrada.imprimir();
                        total += entrada.total;
                    }

                    if (cantidadEntradas >= 5) {
                        total = (int) Math.ceil(total * 0.9);
                    }

                    System.out.println("\nTotal a pagar: " + total + "$");

                    entradas.addAll(entradasCompradas);
                }

                case 2 -> {
                    System.out.println("");
                    System.out.println("******** PROMOCIONES ********");
                    System.out.println("** 1.- Estudiantes 10% de descuento");
                    System.out.println("** 2.- Adultos mayores 15% de descuento");
                    System.out.println("** 3.- 10% de descuento al comprar 5 o mas entradas");
                    System.out.println("****************************");
                }

                case 3 -> {
                    System.out.println("");
                    System.out.println("********* BUSQUEDAS ********");
                    System.out.println("** 1.- Buscar por numero.");
                    System.out.println("** 2.- Buscar por ubicacion.");
                    System.out.println("** 3.- Buscar por tipo.");
                    System.out.println("****************************");
                    System.out.print("\nIngrese una opcion: ");

                    while (true) {
                        try {
                            opcion = scanner.nextInt();
                            if (opcion > 0 && opcion < 4) {
                                break;
                            } else {
                                System.out.print("ERROR, Ingrese una opcion valida: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("ERROR, Ingrese una opcion valida: ");
                            scanner.next();
                        }
                    }

                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Ingrese un numero de entrada: ");

                            while (true) {
                                try {
                                    opcion = scanner.nextInt();
                                    if (opcion > 0) {
                                        break;
                                    } else {
                                        System.out.print("ERROR, Ingrese una opcion valida: ");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.print("ERROR, Ingrese una opcion valida: ");
                                    scanner.next();
                                }
                            }
                            try {
                                Entrada entrada = entradas.get(opcion - 1);
                                entrada.imprimir();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("\nERROR, no existe esa entrada.\n");
                            }
                        }

                        case 2 -> {
                            System.out.println("");
                            System.out.println("1.- Fila Vip.");
                            System.out.println("2.- Fila Platea.");
                            System.out.println("3.- Fila General.");
                            System.out.println("");
                            System.out.print("Ingrese una opcion: ");
                            while (true) {
                                try {
                                    opcion = scanner.nextInt();
                                    if (opcion > 0 && opcion < 4) {

                                        for (Entrada entrada : entradas) {
                                            if (opcion == entrada.fila) {
                                                entrada.imprimir();
                                            }
                                        }

                                        break;
                                    } else {
                                        System.out.print("ERROR, Ingrese una opcion valida: ");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.print("ERROR, Ingrese una opcion valida: ");
                                    scanner.next();
                                }
                            }
                        }

                        case 3 -> {
                            System.out.println("");
                            System.out.println("1.- Estudiante.");
                            System.out.println("2.- Adulto mayor.");
                            System.out.println("3.- General.");
                            System.out.println("");
                            System.out.print("Ingrese una opcion: ");
                            while (true) {
                                try {
                                    opcion = scanner.nextInt();
                                    if (opcion > 0 && opcion < 4) {

                                        for (Entrada entrada : entradas) {
                                            if (opcion == entrada.tipo) {
                                                entrada.imprimir();
                                            }
                                        }

                                        break;
                                    } else {
                                        System.out.print("ERROR, Ingrese una opcion valida: ");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.print("ERROR, Ingrese una opcion valida: ");
                                    scanner.next();
                                }
                            }
                        }

                        default -> {
                            System.out.println("panico");
                        }

                    }
                }

                case 4 -> {

                    if (!entradas.isEmpty()) {
                        for (int i = 0; i < entradas.size(); i++) {
                            System.out.println("\n** Entrada: " + (i + 1));
                            entradas.get(i).imprimir();
                        }
                        System.out.print("\nIngrese en numero de la entrada a eliminar: ");
                        while (true) {
                            try {
                                opcion = scanner.nextInt();
                                if (opcion > 0 && opcion < entradas.size() + 1) {
                                    entradasVendidas--;
                                    switch (entradas.get(opcion - 1).fila) {
                                        case 1 -> {
                                            filaVip--;
                                        }
                                        
                                        case 2 -> {
                                            filaPlatea--;
                                        }
                                        
                                        case 3 -> {
                                            filaGeneral--;
                                        }
                                        
                                        default -> {
                                            System.out.println("panico");
                                        }
                                    }
                                    entradas.remove(opcion - 1);
                                    
                                    break;
                                } else {
                                    System.out.print("ERROR, Ingrese una opcion valida: ");
                                }

                            } catch (InputMismatchException e) {
                                System.out.print("ERROR, Ingrese una opcion valida: ");
                                scanner.next();
                            }
                        }
                    } else {
                        System.out.println("\nNo hay entradas registradas.");
                    }

                }

                case 5 -> {
                    break menu;
                }

                default -> {
                    System.out.println("panico");
                }
            }
        }
        System.out.println("\n\n******** ADIOS ********");
        scanner.close();
    }
}