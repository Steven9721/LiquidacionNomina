import java.util.Scanner;

public class LiquidacionNomina {
    private static final double TARIFA_SEGURIDAD_SOCIAL = 0.08;
    private static final double TARIFA_PENSION = 0.04;
    private static final double TARIFA_SALUD = 0.04;
    private static final double TARIFA_ARL = 0.005;
    private static final double TARIFA_CESANTIAS = 0.0833;
    private static final double TARIFA_INT_CESANTIAS = 0.01;
    private static final double TARIFA_PRIMA = 0.0833;
    private static final double TARIFA_VACACIONES = 0.0417;
    private static final double TARIFA_SEGURO_VIDA = 0.01;
    private static final double VALOR_SUBSIDIO_TRANSPORTE = 106454;
    private static final double SALARIO_MINIMO = 1300000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de empleados: ");
        int numEmpleados = scanner.nextInt();

        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("Empleado " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Apellido: ");
            String apellido = scanner.next();
            System.out.print("Documento: ");
            String documento = scanner.next();
            System.out.print("Días trabajados: ");
            int diasTrabajados = scanner.nextInt();
            System.out.print("¿Recibe subsidio de transporte? (S/N): ");
            String tieneSubsidioTransporte = scanner.next();

            double proporcionDiasTrabajados = (double) diasTrabajados / 30.0;
            double devengos = SALARIO_MINIMO * proporcionDiasTrabajados;

            double subsidioTransporte = 0;
            if (tieneSubsidioTransporte.equalsIgnoreCase("S")) {
                subsidioTransporte = VALOR_SUBSIDIO_TRANSPORTE * proporcionDiasTrabajados;
            }

            double salarioBruto = devengos + subsidioTransporte;
            double descuentos = calcularDescuentos(salarioBruto);
            double salarioNeto = salarioBruto - descuentos;

            System.out.println("\nInformación de liquidación para " + nombre + " " + apellido + " (Documento: " + documento + "):");
            System.out.println("Total bruto: " + salarioBruto);
            System.out.println("Descuentos: " + descuentos);
            System.out.println("Devengos: " + devengos);
            System.out.println("Valor neto a pagar: " + salarioNeto);
        }

        scanner.close();
    }

    private static double calcularDescuentos(double salarioBruto) {
        double seguridadSocial = salarioBruto * TARIFA_SEGURIDAD_SOCIAL;
        double pension = salarioBruto * TARIFA_PENSION;
        double salud = salarioBruto * TARIFA_SALUD;
        double arl = salarioBruto * TARIFA_ARL;
        double cesantias = salarioBruto * TARIFA_CESANTIAS;
        double interesesCesantias = salarioBruto * TARIFA_INT_CESANTIAS;
        double prima = salarioBruto * TARIFA_PRIMA;
        double vacaciones = salarioBruto * TARIFA_VACACIONES;
        double seguroVida = salarioBruto * TARIFA_SEGURO_VIDA;

        return seguridadSocial + pension + salud + arl + cesantias + interesesCesantias + prima + vacaciones + seguroVida;
    }
}
