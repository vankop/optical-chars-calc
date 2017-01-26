package ivan.kopeykin.opticalcharacteristicscalc.calc;

import ivan.kopeykin.opticalcharacteristicscalc.domain.Cable;
import ivan.kopeykin.opticalcharacteristicscalc.domain.CommunicationLine;

public final class Calc {
    /**
     * Удельная хроматическая дисперсия
     * @param cable
     * @return
     */
    public static double sigmaN(Cable cable) {
        return cable.getS0()/4.0*(cable.getL() - Math.pow(cable.getL0D(), 4.0)/Math.pow(cable.getL(),3.0));
    }

    /**
     * Хроматическая дисперсия волокна
     * @param communicationLine
     * @return
     */
    public static double dispersionChr(CommunicationLine communicationLine) {
        return Calc.sigmaN(communicationLine.getCable()) * communicationLine.delta() * communicationLine.getL();
    }
}
