package Empresa;

public abstract class Empleado {
    protected int identificacion;
    protected String nombre;
    protected int anioIngreso;
    protected double salarioBase;
    protected double descuentos;
    protected double pagoNeto;

    protected Empleado(int identificacion, String nombre, int anioIngreso, double salarioBase) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.anioIngreso = anioIngreso;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularPagoMensual(Empleado empleado);

    public abstract double calcularDescuento(int salarioBase);

    public abstract int calcularBonificacion(Empleado empleado);

    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public double getPagoNeto() {
        return pagoNeto;
    }

    public void setPagoNeto(double pagoNeto) {
        this.pagoNeto = pagoNeto;
    }
}
