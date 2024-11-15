package com.challengealura.modelos;

import com.challengealura.conexiones.ConexionApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMoneda {
    private final String API_KEY = "b2a8f68fdcdb8b9ec9d24bac";
    private String URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    private Scanner teclado;
    private ConexionApi conexion;
    private Gson gson;
    private int opcion;
    private int opcionSalida;
    private String menu;
    private String[] codigoMonedas;
    private Moneda moneda;

    public ConversorDeMoneda() {
        this.teclado = new Scanner(System.in);
        this.conexion = new ConexionApi();
        this.gson = new GsonBuilder().create();
        this.opcionSalida = 6;
        this.menu = """
                
                1) Dólar
                2) Peso argentino
                3) Real brasileño
                4) Peso colombiano
                5) Ingresar codigo de moneda
                6) Salir
                
                Seleccione una opción:
                """;
    }

    public void ejecutar() throws IOException, InterruptedException {
        double monto;
        System.out.println("************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Móneda :]");
        do {
            this.generarMenu();
            if (this.opcion == this.opcionSalida) {
                break;
            }
            System.out.println("\nIngrese el monto a convertir (Decimales con punto):");
            monto = teclado.nextDouble();
            if (this.moneda == null || !this.moneda.getCodigoMoneda().equals(this.codigoMonedas[0])) {
                this.moneda = this.obtenerDatosMoneda(this.codigoMonedas[0]);
            }

            this.realizarConversion(monto);
            this.pausa();

            System.out.println("************************************************\n");
        } while (true);
        System.out.println("\n¡¡¡Muchas gracias por usar!!!");
    }

    private Moneda obtenerDatosMoneda(String codigoMoneda) {
        String direccionAux = URL + codigoMoneda;
        String json = this.conexion.obtenerMoneda(direccionAux);
        MonedaExchangeRate monedaER = this.gson.fromJson(json, MonedaExchangeRate.class);
        return new Moneda(monedaER);
    }

    private void generarMenu() {
        while (true) {
            System.out.println("¿Desde que moneda desea convertir?");
            System.out.println(menu);
            this.opcion = teclado.nextInt();
            if (this.opcionInvalida()) {
                this.informarError("¡Opción Inválida, intente nuevamente!");
                continue;
            } else if (this.opcion == this.opcionSalida) {
                return;
            }
            break;
        }
        this.limpiarBufferTeclado();
        String codigoMonedaOrigen = this.determinarCodigoMoneda();
        while (true) {
            System.out.println("\n¿Convertir a que moneda?");
            System.out.println(menu);
            this.opcion = teclado.nextInt();
            if (this.opcionInvalida()) {
                this.informarError("¡Opción Inválida, intente nuevamente!");
                continue;
            } else if (this.opcion == this.opcionSalida) {
                return;
            }
            break;
        }
        this.limpiarBufferTeclado();
        String codigoMonedaDestino = this.determinarCodigoMoneda();
        this.codigoMonedas = new String[]{codigoMonedaOrigen, codigoMonedaDestino};
    }

    private String determinarCodigoMoneda() {
        switch (this.opcion) {
            case 1: {
                return "USD";
            }
            case 2: {
                return "ARS";
            }
            case 3: {
                return "BRL";
            }
            case 4: {
                return "COP";
            }
            default: {
                return this.ingresoDeCodigoManual();
            }
        }

    }

    private void pausa() {
        System.out.println("\nPresione ENTER para continuar...");
        this.limpiarBufferTeclado();
        String enter = this.teclado.nextLine();
    }

    private void limpiarBufferTeclado() {
        this.teclado.nextLine();
    }

    private boolean opcionInvalida() {
        return this.opcion > this.opcionSalida;
    }

    private void realizarConversion(double monto) {
        double montoConvertido = this.moneda.convertir(monto, this.codigoMonedas[1]);
        System.out.println("\nMonto ingresado: $" + monto + " [" + this.codigoMonedas[0] + "]");
        System.out.println("Monto convertido: $" + montoConvertido + " [" + this.codigoMonedas[1] + "]");
    }

    private String ingresoDeCodigoManual() {
        while (true) {
            System.out.println("""
                    
                    Puede ingresar a https://www.exchangerate-api.com/docs/supported-currencies
                    para un listado completo de los códigos de monedas aceptados.
                    """);
            System.out.println("Ingrese el código de moneda que desee:");
            String codigoMonedaManual = this.teclado.nextLine();
            if (!this.verificarCodigo(codigoMonedaManual)) {
                this.informarError("\n¡Código inválido, intente nuevamente!");
                continue;
            }
            return codigoMonedaManual;
        }
    }

    private boolean verificarCodigo(String codigo) {
        return codigo.length() == 3 && codigo.matches("[A-Z]{3}");
    }

    private void informarError(String mensaje) {
        System.out.println(mensaje);
        this.pausa();
    }
}
