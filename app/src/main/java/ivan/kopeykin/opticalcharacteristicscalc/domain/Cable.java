package ivan.kopeykin.opticalcharacteristicscalc.domain;

public class Cable {

    private CableType type;
    private String mark;
    private CableStandard standard;
    private double l; //Длина волны нм
    private double dO; //Диаметр оболочки, мкм
    private double dZ; //Диаметр защитного покрытия, мкм
    private double s; //Эксцентриситет сердцевины, мкм
    private double l0D; //Длина волны нулевой дисперсии, нм
    private double s0; // Наклон нулевой дисперсии, S0 (пс/нм2⋅км)
    private double pmd; //pmd

    public CableType getType() {
        return type;
    }

    public void setType(CableType type) {
        this.type = type;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getL0D() {
        return l0D;
    }

    public void setL0D(double l0D) {
        this.l0D = l0D;
    }

    public double getS0() {
        return s0;
    }

    public void setS0(double s0) {
        this.s0 = s0;
    }

    public double getPmd() {
        return pmd;
    }

    public void setPmd(double pmd) {
        this.pmd = pmd;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getdZ() {
        return dZ;
    }

    public void setdZ(double dZ) {
        this.dZ = dZ;
    }

    public double getdO() {
        return dO;
    }

    public void setdO(double dO) {
        this.dO = dO;
    }

    public CableStandard getStandard() {
        return standard;
    }

    public void setStandard(CableStandard standard) {
        this.standard = standard;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
