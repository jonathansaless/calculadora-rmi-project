
// CÓDIGO CALCULADORA IMPL
import java.rmi.RemoteException;

public class CalculadoraImpl implements Calculadora {

    @Override
    public Numero somar(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Soma!");
        return new NumeroImpl(num1.getValor() + num2.getValor());
    }

    @Override
    public Numero subtrair(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Subtração!");
        return new NumeroImpl(num1.getValor() - num2.getValor());
    }

    @Override
    public Numero multiplicar(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Multiplicação!");
        return new NumeroImpl(num1.getValor() * num2.getValor());
    }

    @Override
    public Numero dividir(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Divisão!");
        return new NumeroImpl(num1.getValor() / num2.getValor());
    }

    @Override
    public Numero calcularRestoDivisao(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Resto de divisão!");
        return new NumeroImpl(num1.getValor() % num2.getValor());
    }

    @Override
    public Numero calcularPotencia(Numero base, Numero expoente) throws RemoteException {
        System.out.println("Potência!");
        return new NumeroImpl(Math.pow(base.getValor(), expoente.getValor()));
    }

    @Override
    public Numero calcularRaizQuadrada(Numero num) throws RemoteException {
        System.out.println("Raiz quadrada!");
        return new NumeroImpl(Math.sqrt(num.getValor()));
    }

    @Override
    public Numero calcularRaizCubica(Numero num) throws RemoteException {
        System.out.println("Raiz cúbica!");
        return new NumeroImpl(Math.cbrt(num.getValor()));
    }

    @Override
    public Numero calcularSeno(Numero angulo) throws RemoteException {
        System.out.println("Seno!");
        return new NumeroImpl(Math.sin(angulo.getValor()));
    }

    @Override
    public Numero calcularCosseno(Numero angulo) throws RemoteException {
        System.out.println("Cosseno!");
        return new NumeroImpl(Math.cos(angulo.getValor()));
    }

    @Override
    public Numero calcularTangente(Numero angulo) throws RemoteException {
        System.out.println("Tangente!");
        return new NumeroImpl(Math.tan(angulo.getValor()));
    }

    @Override
    public Numero calcularCotangente(Numero angulo) throws RemoteException {
        System.out.println("Cotangente!");
        return new NumeroImpl(1 / Math.tan(angulo.getValor()));
    }

    @Override
    public Numero calcularSecante(Numero angulo) throws RemoteException {
        System.out.println("Secante!");
        return new NumeroImpl(1 / Math.cos(angulo.getValor()));
    }

    @Override
    public Numero calcularCossecante(Numero angulo) throws RemoteException {
        System.out.println("Cossecante!");
        return new NumeroImpl(1 / Math.sin(angulo.getValor()));
    }

    @Override
    public Numero calcularLogaritmo(Numero num) throws RemoteException {
        System.out.println("Logaritmo!");
        return new NumeroImpl(Math.log(num.getValor()));
    }

    @Override
    public Numero calcularLogaritmoBase10(Numero num) throws RemoteException {
        System.out.println("Logaritmo na base 10!");
        return // double cotangente = 1 / Math.tan(angulo.getValor());
        new NumeroImpl(Math.log10(num.getValor()));
    }

    @Override
    public Numero calcularExponencial(Numero num) throws RemoteException {
        System.out.println("Exponencial!");
        return new NumeroImpl(Math.exp(num.getValor()));
    }

    @Override
    public Numero calcularValorAbsoluto(Numero num) throws RemoteException {
        System.out.println("Valor absoluto!");
        return new NumeroImpl(Math.abs(num.getValor()));
    }

    @Override
    public Numero calcularFatorial(Numero num) throws RemoteException {
        int valor = (int) num.getValor();
        int resultado = 1;
        for (int i = 2; i <= valor; i++) {
            resultado *= i;
        }
        System.out.println("Fatorial!");
        return new NumeroImpl(resultado);
    }

    @Override
    public Numero calcularPorcentagem(Numero num, Numero porcentagem) throws RemoteException {
        System.out.println("Porcentagem!");
        return new NumeroImpl(num.getValor() * (porcentagem.getValor() / 100));
    }

    @Override
    public Numero calcularMaior(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Valor máximo!");
        return new NumeroImpl(Math.max(num1.getValor(), num2.getValor()));
    }

    @Override
    public Numero calcularMenor(Numero num1, Numero num2) throws RemoteException {
        System.out.println("Valor mínimo!");
        return new NumeroImpl(Math.min(num1.getValor(), num2.getValor()));
    }

    @Override
    public Numero arredondarParaCima(Numero num) throws RemoteException {
        System.out.println("Arredondar pra cima!");
        return new NumeroImpl(Math.ceil(num.getValor()));
    }

    @Override
    public Numero arredondarParaBaixo(Numero num) throws RemoteException {
        System.out.println("Arredondar pra baixo!");
        return new NumeroImpl(Math.floor(num.getValor()));
    }

    @Override
    public Numero arredondar(Numero num) throws RemoteException {
        System.out.println("Arredondar!");
        return new NumeroImpl(Math.round(num.getValor()));
    }

    @Override
    public Numero converterGrauParaRadiano(Numero grau) throws RemoteException {
        System.out.println("Converter grau para radiano!");
        return new NumeroImpl(Math.toRadians(grau.getValor()));
    }

    @Override
    public Numero realParaDolar(Numero valor) throws RemoteException {
        System.out.println("Real p/ Dólar!");
        return new NumeroImpl(valor.getValor() / 4.84);
    }

    @Override
    public Numero dolarParaReal(Numero valor) throws RemoteException {
        System.out.println("Dólar p/ Real!");
        return new NumeroImpl(valor.getValor() * 4.84);
    }

    @Override
    public Numero segParaMinuto(Numero valor) throws RemoteException {
        System.out.println("Segundo p/ minuto!");
        return new NumeroImpl(valor.getValor() / 60);
    }

    @Override
    public Numero minutoParaSeg(Numero valor) throws RemoteException {
        System.out.println("Minuto p/ segundos!");
        return new NumeroImpl(valor.getValor() * 60);
    }

    @Override
    public Numero celsiusParaFahrenheit(Numero valor)
            throws RemoteException {
        System.out.println("Celsius p/ Fahrenheit!");
        return new NumeroImpl((valor.getValor() * 9 / 5) + 32);
    }

    @Override
    public Numero fahreinheitParaCelsius(Numero valor)
            throws RemoteException {
        System.out.println("Fahrenheit p/ Celsius!");
        return new NumeroImpl((valor.getValor() - 32) * 5 / 9);
    }

}