package Empresa;

public class Repartidor extends Empleado {
    private int numeroRepartos;
    private long valorRepartosPagados;
    private Zona zona;

    public Repartidor(int identificacion, String nombre, int anioIngreso, double salarioBase, int numeroRepartos,
            Zona zona) {
        super(identificacion, nombre, anioIngreso, salarioBase);
        this.numeroRepartos = numeroRepartos;
        this.zona = zona;
        validarZona();
        this.valorRepartosPagados = calcularValorRepartos(numeroRepartos);
        this.descuentos = calcularDescuento((int) salarioBase);
    }

    public long calcularValorRepartos(int numeroRepartos) {
        return numeroRepartos * 10000L;
    }

    public void validarZona() {
        if (zona == null) {
            zona = Zona.C;
        }
    }

    @Override
    public double calcularDescuento(int salarioBase) {
        return (salarioBase + valorRepartosPagados) * ConstantesNomina.TASA_PRESTACIONES;
    }

    @Override
    public int calcularBonificacion(Empleado empleado) {
        boolean aplicaAntiguedad = ConstantesNomina.ANIO_ACTUAL - empleado.anioIngreso > 5;
        return aplicaAntiguedad && zona == Zona.C ? 50000 : 0;
    }

    @Override
    public double calcularPagoMensual(Empleado empleado) {
        return this.salarioBase + this.valorRepartosPagados - this.descuentos;
    }

    public int getNumeroRepartos() {
        return numeroRepartos;
    }

    public long getValorRepartosPagados() {
        return valorRepartosPagados;
    }

    public Zona getZona() {
        return zona;
    }
}
