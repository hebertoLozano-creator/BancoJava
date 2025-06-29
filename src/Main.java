//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

class CuentaBancaria {
    private String titular;
    private String clave;
    private double saldo;

    CuentaBancaria(String titular, String clave, double saldoInicial) {
        this.titular = titular;
        this.clave = clave;
        this.saldo = saldoInicial;
    }

    public boolean verificarClave(String claveIngresada) {
        return this.clave.equals(claveIngresada);
    }

    public void consignar(double cantidad) {
        saldo += cantidad;
        System.out.println("✅ Consignación exitosa. Nuevo saldo: " + saldo);
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("⚠️ Saldo insuficiente.");
        } else {
            saldo -= cantidad;
            System.out.println("✅ Retiro exitoso. Nuevo saldo: " + saldo);
        }
    }

    public void mostrarSaldo() {
        System.out.println("👤 Titular: " + titular + " | 💰 Saldo: " + saldo);
    }

    public String getTitular() {
        return titular;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENÚ BANCO =====");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Consignar");
            System.out.println("3. Retirar");
            System.out.println("4. Ver saldo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del titular: ");
                    String nombre = sc.nextLine();
                    System.out.print("Clave: ");
                    String clave = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    cuentas.add(new CuentaBancaria(nombre, clave, saldo));
                    System.out.println("✅ Cuenta creada exitosamente.");
                    break;

                case 2:
                    System.out.print("Nombre del titular: ");
                    String titularConsig = sc.nextLine();
                    CuentaBancaria cuentaC = buscarCuenta(cuentas, titularConsig);
                    if (cuentaC != null) {
                        System.out.print("Ingrese su clave: ");
                        String claveC = sc.nextLine();
                        if (cuentaC.verificarClave(claveC)) {
                            System.out.print("Cantidad a consignar: ");
                            double cantidad = sc.nextDouble();
                            cuentaC.consignar(cantidad);
                        } else {
                            System.out.println("❌ Clave incorrecta.");
                        }
                    } else {
                        System.out.println("❌ Cuenta no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del titular: ");
                    String titularRetiro = sc.nextLine();
                    CuentaBancaria cuentaR = buscarCuenta(cuentas, titularRetiro);
                    if (cuentaR != null) {
                        System.out.print("Ingrese su clave: ");
                        String claveR = sc.nextLine();
                        if (cuentaR.verificarClave(claveR)) {
                            System.out.print("Cantidad a retirar: ");
                            double retiro = sc.nextDouble();
                            cuentaR.retirar(retiro);
                        } else {
                            System.out.println("❌ Clave incorrecta.");
                        }
                    } else {
                        System.out.println("❌ Cuenta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre del titular: ");
                    String titularSaldo = sc.nextLine();
                    CuentaBancaria cuentaS = buscarCuenta(cuentas, titularSaldo);
                    if (cuentaS != null) {
                        System.out.print("Ingrese su clave: ");
                        String claveS = sc.nextLine();
                        if (cuentaS.verificarClave(claveS)) {
                            cuentaS.mostrarSaldo();
                        } else {
                            System.out.println("❌ Clave incorrecta.");
                        }
                    } else {
                        System.out.println("❌ Cuenta no encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Gracias por usar el banco.");
                    return;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        }
    }

    public static CuentaBancaria buscarCuenta(ArrayList<CuentaBancaria> cuentas, String nombre) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getTitular().equalsIgnoreCase(nombre)) {
                return cuenta;
            }
        }
        return null;
    }
}