
// CÓDIGO CALCULADORA IMPL
import java.rmi.RemoteException;

public class CalculadoraImpl implements Calculadora {

    @Override
    public Numero somar(Numero num1, Numero num2) throws RemoteException {
        return new NumeroImpl(num1.getValor() + num2.getValor());
    }

    @Override
    public Numero subtrair(Numero num1, Numero num2) throws RemoteException {
        return new NumeroImpl(num1.getValor() - num2.getValor());
    }

    @Override
    public Numero multiplicar(Numero num1, Numero num2) throws RemoteException {
        return new NumeroImpl(num1.getValor() * num2.getValor());
    }

    @Override
    public Numero dividir(Numero num1, Numero num2) throws RemoteException {
        return new NumeroImpl(num1.getValor() / num2.getValor());
    }

    @Override
    public Numero calcularRestoDivisao(Numero num1, Numero num2) throws RemoteException {
        double resto = num1.getValor() % num2.getValor();
        return new NumeroImpl(resto);
    }

    @Override
    public Numero calcularPotencia(Numero base, Numero expoente) throws RemoteException {
        return new NumeroImpl(Math.pow(base.getValor(), expoente.getValor()));
    }

    @Override
    public Numero calcularRaizQuadrada(Numero num) throws RemoteException {
        return new NumeroImpl(Math.sqrt(num.getValor()));
    }

    @Override
    public Numero calcularRaizNesima(Numero num, Numero n) throws RemoteException {
        double resultado = Math.pow(num.getValor(), 1 / n.getValor());
        return new NumeroImpl(resultado);
    }

    @Override
    public Numero calcularSeno(Numero angulo) throws RemoteException {
        return new NumeroImpl(Math.sin(angulo.getValor()));
    }

    @Override
    public Numero calcularCosseno(Numero angulo) throws RemoteException {
        return new NumeroImpl(Math.cos(angulo.getValor()));
    }

    @Override
    public Numero calcularTangente(Numero angulo) throws RemoteException {
        return new NumeroImpl(Math.tan(angulo.getValor()));
    }

    @Override
    public Numero calcularCotangente(Numero angulo) throws RemoteException {
        double cotangente = 1 / Math.tan(angulo.getValor());
        return new NumeroImpl(cotangente);
    }

    @Override
    public Numero calcularSecante(Numero angulo) throws RemoteException {
        double secante = 1 / Math.cos(angulo.getValor());
        return new NumeroImpl(secante);
    }

    @Override
    public Numero calcularCossecante(Numero angulo) throws RemoteException {
        double cossecante = 1 / Math.sin(angulo.getValor());
        return new NumeroImpl(cossecante);
    }

    @Override
    public Numero calcularLogaritmo(Numero num) throws RemoteException {
        return new NumeroImpl(Math.log(num.getValor()));
    }

    @Override
    public Numero calcularLogaritmoBase10(Numero num) throws RemoteException {
        return new NumeroImpl(Math.log10(num.getValor()));
    }

    @Override
    public Numero calcularValorAbsoluto(Numero num) throws RemoteException {
        return new NumeroImpl(Math.abs(num.getValor()));
    }

    @Override
    public Numero converterMoeda(Numero valor, String moedaOrigem, String moedaDestino) throws RemoteException {

        double valorConvertido = 0;
        if (moedaOrigem.equals("USD") && moedaDestino.equals("BRL")) {
            valorConvertido = valor.getValor() * 5.5; // Exemplo: 1 dólar para real
        } else if (moedaOrigem.equals("BRL") && moedaDestino.equals("USD")) {
            valorConvertido = valor.getValor() / 5.5; // Exemplo: 1 real para dólar
        }
        return new NumeroImpl(valorConvertido);
    }

    @Override
    public Numero converterTempo(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException {

        double valorConvertido = 0;
        if (unidadeOrigem.equals("segundos") && unidadeDestino.equals("minutos")) {
            valorConvertido = valor.getValor() / 60; // Exemplo: converter segundos para minutos
        } else if (unidadeOrigem.equals("minutos") && unidadeDestino.equals("segundos")) {
            valorConvertido = valor.getValor() * 60; // Exemplo: converter minutos para segundos
        }
        return new NumeroImpl(valorConvertido);
    }

    @Override
    public Numero converterComprimento(Numero valor, String unidadeOrigem, String unidadeDestino)
            throws RemoteException {

        double valorConvertido = 0;
        if (unidadeOrigem.equals("metros") && unidadeDestino.equals("quilômetros")) {
            valorConvertido = valor.getValor() / 1000; // Exemplo: converter metros para quilômetros
        } else if (unidadeOrigem.equals("quilometros") && unidadeDestino.equals("metros")) {
            valorConvertido = valor.getValor() * 1000; // Exemplo: converter quilômetros para metros
        }
        return new NumeroImpl(valorConvertido);
    }

    @Override
    public Numero converterPeso(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException {

        double valorConvertido = 0;
        if (unidadeOrigem.equals("quilogramas") && unidadeDestino.equals("gramas")) {
            valorConvertido = valor.getValor() * 1000; // Exemplo: converter quilogramas para gramas
        } else if (unidadeOrigem.equals("gramas") && unidadeDestino.equals("quilogramas")) {
            valorConvertido = valor.getValor() / 1000; // Exemplo: converter gramas para quilogramas
        }
        return new NumeroImpl(valorConvertido);
    }

    @Override
    public Numero converterVolume(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException {

        double valorConvertido = 0;
        if (unidadeOrigem.equals("litros") && unidadeDestino.equals("mililitros")) {
            valorConvertido = valor.getValor() * 1000; // Exemplo: converter litros para mililitros
        } else if (unidadeOrigem.equals("mililitros") && unidadeDestino.equals("litros")) {
            valorConvertido = valor.getValor() / 1000; // Exemplo: converter mililitros para litros
        }
        return new NumeroImpl(valorConvertido);
    }

    @Override
    public Numero converterTemperatura(Numero valor, String unidadeOrigem, String unidadeDestino)
            throws RemoteException {

        double valorConvertido = 0;
        if (unidadeOrigem.equals("Celsius") && unidadeDestino.equals("Fahrenheit")) {
            valorConvertido = (valor.getValor() * 9 / 5) + 32; // Exemplo: converter Celsius para Fahrenheit
        } else if (unidadeOrigem.equals("Fahrenheit") && unidadeDestino.equals("Celsius")) {
            valorConvertido = (valor.getValor() - 32) * 5 / 9; // Exemplo: converter Fahrenheit para Celsius
        }
        return new NumeroImpl(valorConvertido);
    }

    @Override
    public Numero calcularFatorial(Numero num) throws RemoteException {
        int valor = (int) num.getValor();
        int resultado = 1;
        for (int i = 2; i <= valor; i++) {
            resultado *= i;
        }
        return new NumeroImpl(resultado);
    }

    @Override
    public Numero calcularPorcentagem(Numero num, Numero porcentagem) throws RemoteException {
        double resultado = num.getValor() * (porcentagem.getValor() / 100);
        return new NumeroImpl(resultado);
    }

    @Override
    public Numero calcularMaior(Numero num1, Numero num2) throws RemoteException {
        double maior = Math.max(num1.getValor(), num2.getValor());
        return new NumeroImpl(maior);
    }

    @Override
    public Numero calcularMenor(Numero num1, Numero num2) throws RemoteException {
        double menor = Math.min(num1.getValor(), num2.getValor());
        return new NumeroImpl(menor);
    }

    @Override
    public Numero arredondarParaCima(Numero num) throws RemoteException {
        double arredondado = Math.ceil(num.getValor());
        return new NumeroImpl(arredondado);
    }

    @Override
    public Numero arredondarParaBaixo(Numero num) throws RemoteException {
        double arredondado = Math.floor(num.getValor());
        return new NumeroImpl(arredondado);
    }

    @Override
    public Numero arredondar(Numero num) throws RemoteException {
        double arredondado = Math.round(num.getValor());
        return new NumeroImpl(arredondado);
    }

}
