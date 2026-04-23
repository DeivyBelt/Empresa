package Empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> listaEmpleados;

    public Empresa() {
        this.listaEmpleados = new ArrayList<>();
    }

    public Empresa(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleado buscarEmpleado(int id) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getIdentificacion() == id) {
                return empleado;
            }
        }
        return null;
    }

    public void liquidarNomina(List<Empleado> lista) {
        for (Empleado empleado : lista) {
            double neto = empleado.calcularPagoMensual(empleado) + empleado.calcularBonificacion(empleado);
            empleado.setPagoNeto(neto);
        }
    }

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Vendedor(101, "Laura Perez", 2000, 1800000, 12000000));
        empleados.add(new Vendedor(102, "Carlos Ruiz", 2012, 1600000, 8500000));
        empleados.add(new Vendedor(103, "Ana Gomez", 2021, 1500000, 5000000));

        empleados.add(new Repartidor(201, "Luis Mora", 2017, 1400000, 80, Zona.A));
        empleados.add(new Repartidor(202, "Sofia Rios", 2018, 1450000, 95, Zona.C));
        empleados.add(new Repartidor(203, "Mateo Diaz", 2023, 1350000, 60, null));

        Empresa empresa = new Empresa(empleados);
        empresa.liquidarNomina(empleados);

        for (Empleado empleado : empleados) {
            imprimirEmpleado(empleado);
        }
    }

    private static void imprimirEmpleado(Empleado empleado) {
        if (empleado instanceof Vendedor vendedor) {
            System.out.println(
                    "Vendedor, " + vendedor.getIdentificacion() + ", " + vendedor.getNombre() + ", "
                            + vendedor.getAnioIngreso() + ", " + vendedor.getSalarioBase() + ", "
                            + vendedor.getTotalVentas() + ", " + vendedor.getValorComision() + ", "
                            + vendedor.getDescuentos() + ", " + vendedor.getPagoNeto());
            return;
        }

        if (empleado instanceof Repartidor repartidor) {
            System.out.println(
                    "Repartidor, " + repartidor.getIdentificacion() + ", " + repartidor.getNombre() + ", "
                            + repartidor.getAnioIngreso() + ", " + repartidor.getSalarioBase() + ", "
                            + repartidor.getNumeroRepartos() + ", " + repartidor.getValorRepartosPagados() + ", "
                            + repartidor.getDescuentos() + ", " + repartidor.getPagoNeto());
        }
    }
}
