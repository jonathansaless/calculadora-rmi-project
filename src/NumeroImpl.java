public class NumeroImpl implements Numero {

    private double num;

    public NumeroImpl (double val) {
        num = val;
    }

    @Override
    public double getValor() {
        return num;
    }

}
