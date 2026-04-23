package Empresa;

public class Vendedor extends Empleado {
    private int totalVentas;
    private long valorComision;

    public Vendedor(int identificacion, String nombre, int anioIngreso, double salarioBase, int totalVentas) {
        super(identificacion, nombre, anioIngreso, salarioBase);
        this.totalVentas = totalVentas;
        this.valorComision = calcularComision(totalVentas);
        this.descuentos = calcularDescuento((int) salarioBase);
    }

    public long calcularComision(int totalVentas) {
        return (long) (totalVentas * 0.15);
    }

    @Override
    public double calcularDescuento(int salarioBase) {
        return (salarioBase + valorComision) * ConstantesNomina.TASA_PRESTACIONES;
    }

    @Override
    public int calcularBonificacion(Empleado empleado) {
        return ConstantesNomina.ANIO_ACTUAL - empleado.anioIngreso > 20 ? 100000 : 0;
    }

    @Override
    public double calcularPagoMensual(Empleado empleado) {
        return this.salarioBase + this.valorComision - this.descuentos;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public long getValorComision() {
        return valorComision;
    }
}
