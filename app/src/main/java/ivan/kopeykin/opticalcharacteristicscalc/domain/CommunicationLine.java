package ivan.kopeykin.opticalcharacteristicscalc.domain;

/**
 * Created by Developer on 26.01.2017.
 */

public class CommunicationLine {
    private double deltaF; //ГГц
    private double f; //ГГц
    private static final double c = 3e8;
    private double L;
    private Cable cable;

    public double getDeltaF() {
        return deltaF;
    }

    public void setDeltaF(double deltaF) {
        this.deltaF = deltaF;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public double delta() {
        return c * deltaF / (f*f*1e9);
    }

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public Cable getCable() {
        return cable;
    }

    public void setCable(Cable cable) {
        this.cable = cable;
    }
}
