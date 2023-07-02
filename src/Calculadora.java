import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {

    public Numero somar(Numero num1, Numero num2) throws RemoteException;

    public Numero subtrair(Numero num1, Numero num2) throws RemoteException;

    public Numero multiplicar(Numero num1, Numero num2) throws RemoteException;

    public Numero dividir(Numero num1, Numero num2) throws RemoteException;

    public Numero calcularRestoDivisao(Numero num1, Numero num2) throws RemoteException;

    public Numero calcularPotencia(Numero base, Numero expoente) throws RemoteException;

    public Numero calcularRaizQuadrada(Numero num) throws RemoteException;

    public Numero calcularRaizNesima(Numero num, Numero n) throws RemoteException;

    public Numero calcularSeno(Numero angulo) throws RemoteException;

    public Numero calcularCosseno(Numero angulo) throws RemoteException;

    public Numero calcularTangente(Numero angulo) throws RemoteException;

    public Numero calcularCotangente(Numero angulo) throws RemoteException;

    public Numero calcularSecante(Numero angulo) throws RemoteException;

    public Numero calcularCossecante(Numero angulo) throws RemoteException;

    public Numero calcularLogaritmo(Numero num) throws RemoteException;

    public Numero calcularLogaritmoBase10(Numero num) throws RemoteException;

    public Numero calcularValorAbsoluto(Numero num) throws RemoteException;

    public Numero converterMoeda(Numero valor, String moedaOrigem, String moedaDestino) throws RemoteException;

    public Numero converterTempo(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException;

    public Numero converterComprimento(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException;

    public Numero converterPeso(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException;

    public Numero converterVolume(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException;

    public Numero converterTemperatura(Numero valor, String unidadeOrigem, String unidadeDestino) throws RemoteException;

    public Numero calcularFatorial(Numero num) throws RemoteException;

    public Numero calcularPorcentagem(Numero num, Numero porcentagem) throws RemoteException;

    public Numero calcularMaior(Numero num1, Numero num2) throws RemoteException;

    public Numero calcularMenor(Numero num1, Numero num2) throws RemoteException;

    public Numero arredondarParaCima(Numero num) throws RemoteException;

    public Numero arredondarParaBaixo(Numero num) throws RemoteException;

    public Numero arredondar(Numero num) throws RemoteException;

}

