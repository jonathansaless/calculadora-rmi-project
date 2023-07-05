import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteCalculadora {
  private static Calculadora calc;
  private static JTextField resultField;
  private static JTextField inputField1;
  private static JTextField inputField2;

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Uso: java ClienteCalculadora <ip_servidor> <porta>");
      return;
    }

    String serverIP = args[0];
    int serverPort = Integer.parseInt(args[1]);

    try {
      Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
      calc = (Calculadora) registry.lookup("calculadora");
    } catch (Exception e) {
      System.err.println("Ocorreu um erro ao obter o stub da calculadora: " + e.toString());
      return;
    }

    SwingUtilities.invokeLater(() -> createAndShowGUI());
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("Calculadora");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setSize(850, 350);

    resultField = new JTextField();
    resultField.setEditable(false);
    frame.add(resultField, BorderLayout.CENTER);

    JPanel inputPanel = new JPanel(new GridLayout(2, 2));

    JLabel inputLabel1 = new JLabel("x:");
    inputPanel.add(inputLabel1);

    inputField1 = new JTextField();
    inputPanel.add(inputField1);

    JLabel inputLabel2 = new JLabel("y:");
    inputPanel.add(inputLabel2);

    inputField2 = new JTextField();
    inputPanel.add(inputField2);

    frame.add(inputPanel, BorderLayout.NORTH);

    JPanel buttonPanel = new JPanel(new GridLayout(6, 4));

    JButton sumButton = new JButton("+");
    sumButton.addActionListener(new ButtonClickListener("somar"));
    buttonPanel.add(sumButton);

    JButton subtractButton = new JButton("-");
    subtractButton.addActionListener(new ButtonClickListener("subtrair"));
    buttonPanel.add(subtractButton);

    JButton multiplyButton = new JButton("*");
    multiplyButton.addActionListener(new ButtonClickListener("multiplicar"));
    buttonPanel.add(multiplyButton);

    JButton divideButton = new JButton("/");
    divideButton.addActionListener(new ButtonClickListener("dividir"));
    buttonPanel.add(divideButton);

    JButton powerButton = new JButton("^");
    powerButton.addActionListener(new ButtonClickListener("potencia"));
    buttonPanel.add(powerButton);

    JButton percentageButton = new JButton("%");
    percentageButton.addActionListener(new ButtonClickListener("calcularPorcentagem"));
    buttonPanel.add(percentageButton);

    JButton maxButton = new JButton("max");
    maxButton.addActionListener(new ButtonClickListener("calcularMaior"));
    buttonPanel.add(maxButton);

    JButton minButton = new JButton("min");
    minButton.addActionListener(new ButtonClickListener("calcularMenor"));
    buttonPanel.add(minButton);

    JButton squareRootButton = new JButton("√");
    squareRootButton.addActionListener(new ButtonClickListener("raizQuadrada"));
    buttonPanel.add(squareRootButton);

    JButton calcularRaizCubicaButton = new JButton("³√");
    calcularRaizCubicaButton.addActionListener(new ButtonClickListener("calcularRaizCubica"));
    buttonPanel.add(calcularRaizCubicaButton);

    JButton sineButton = new JButton("sin");
    sineButton.addActionListener(new ButtonClickListener("seno"));
    buttonPanel.add(sineButton);

    JButton cosineButton = new JButton("cos");
    cosineButton.addActionListener(new ButtonClickListener("cosseno"));
    buttonPanel.add(cosineButton);

    JButton tangentButton = new JButton("tan");
    tangentButton.addActionListener(new ButtonClickListener("tangente"));
    buttonPanel.add(tangentButton);

    JButton cotangentButton = new JButton("cotan");
    cotangentButton.addActionListener(new ButtonClickListener("cotangente"));
    buttonPanel.add(cotangentButton);

    JButton secantButton = new JButton("sec");
    secantButton.addActionListener(new ButtonClickListener("secante"));
    buttonPanel.add(secantButton);

    JButton cosecantButton = new JButton("cosec");
    cosecantButton.addActionListener(new ButtonClickListener("cossecante"));
    buttonPanel.add(cosecantButton);

    JButton logButton = new JButton("ln");
    logButton.addActionListener(new ButtonClickListener("logaritmo"));
    buttonPanel.add(logButton);

    JButton log10Button = new JButton("log10");
    log10Button.addActionListener(new ButtonClickListener("logaritmoBase10"));
    buttonPanel.add(log10Button);

    JButton absButton = new JButton("|x|");
    absButton.addActionListener(new ButtonClickListener("valorAbsoluto"));
    buttonPanel.add(absButton);

    JButton factorialButton = new JButton("!");
    factorialButton.addActionListener(new ButtonClickListener("calcularFatorial"));
    buttonPanel.add(factorialButton);

    JButton ceilButton = new JButton("ceil");
    ceilButton.addActionListener(new ButtonClickListener("arredondarParaCima"));
    buttonPanel.add(ceilButton);

    JButton floorButton = new JButton("floor");
    floorButton.addActionListener(new ButtonClickListener("arredondarParaBaixo"));
    buttonPanel.add(floorButton);

    JButton roundButton = new JButton("arredondar");
    roundButton.addActionListener(new ButtonClickListener("arredondar"));
    buttonPanel.add(roundButton);

    JButton converterGrauParaRadianoButton = new JButton("°->rad");
    converterGrauParaRadianoButton.addActionListener(new ButtonClickListener("converterGrauParaRadiano"));
    buttonPanel.add(converterGrauParaRadianoButton);

    JButton calcularExponencialButton = new JButton("e^x");
    calcularExponencialButton.addActionListener(new ButtonClickListener("calcularExponencial"));
    buttonPanel.add(calcularExponencialButton);

    JButton realParaDolarButton = new JButton("R$->USD");
    realParaDolarButton.addActionListener(new ButtonClickListener("realParaDolar"));
    buttonPanel.add(realParaDolarButton);

    JButton dolarParaRealButton = new JButton("USD->R$");
    dolarParaRealButton.addActionListener(new ButtonClickListener("dolarParaReal"));
    buttonPanel.add(dolarParaRealButton);

    JButton segParaMinutoButton = new JButton("Seg->Min");
    segParaMinutoButton.addActionListener(new ButtonClickListener("segParaMinuto"));
    buttonPanel.add(segParaMinutoButton);

    JButton minutoParaSegButton = new JButton("Min->Seg");
    minutoParaSegButton.addActionListener(new ButtonClickListener("minutoParaSeg"));
    buttonPanel.add(minutoParaSegButton);

    JButton celsiusParaFahrenheitButton = new JButton("ºC->ºF");
    celsiusParaFahrenheitButton.addActionListener(new ButtonClickListener("celsiusParaFahrenheit"));
    buttonPanel.add(celsiusParaFahrenheitButton);

    JButton fahrenheitParaCelsiusButton = new JButton("ºF->ºC");
    fahrenheitParaCelsiusButton.addActionListener(new ButtonClickListener("fahrenheitParaCelsius"));
    buttonPanel.add(fahrenheitParaCelsiusButton);

    JButton quilometrosParaMilhasButton = new JButton("km->mi");
    quilometrosParaMilhasButton.addActionListener(new ButtonClickListener("quilometrosParaMilhas"));
    buttonPanel.add(quilometrosParaMilhasButton);

    JButton milhasParaQuilometrosButton = new JButton("mi->km");
    milhasParaQuilometrosButton.addActionListener(new ButtonClickListener("milhasParaQuilometros"));
    buttonPanel.add(milhasParaQuilometrosButton);

    JButton quilogramasParaLibrasButton = new JButton("kg->lb");
    quilogramasParaLibrasButton.addActionListener(new ButtonClickListener("quilogramasParaLibras"));
    buttonPanel.add(quilogramasParaLibrasButton);

    JButton librasParaQuilogramasButton = new JButton("lb->kg");
    librasParaQuilogramasButton.addActionListener(new ButtonClickListener("librasParaQuilogramas"));
    buttonPanel.add(librasParaQuilogramasButton);

    frame.add(buttonPanel, BorderLayout.SOUTH);
    frame.setVisible(true);
  }

  private static class ButtonClickListener implements ActionListener {
    private String operation;

    public ButtonClickListener(String operation) {
      this.operation = operation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        double value1 = Double.parseDouble(inputField1.getText());
        Numero num1 = new NumeroImpl(value1);
        Numero num2 = null; // Valor padrão para num2

        if (!inputField2.getText().isEmpty()) {
          double value2 = Double.parseDouble(inputField2.getText());
          num2 = new NumeroImpl(value2);
        }

        Numero result = null;

        switch (operation) {
          case "somar":
            result = calc.somar(num1, num2);
            break;
          case "subtrair":
            result = calc.subtrair(num1, num2);
            break;
          case "multiplicar":
            result = calc.multiplicar(num1, num2);
            break;
          case "dividir":
            result = calc.dividir(num1, num2);
            break;
          case "potencia":
            result = calc.calcularPotencia(num1, num2);
            break;
          case "raizQuadrada":
            result = calc.calcularRaizQuadrada(num1);
            break;
          case "seno":
            result = calc.calcularSeno(num1);
            break;
          case "cosseno":
            result = calc.calcularCosseno(num1);
            break;
          case "tangente":
            result = calc.calcularTangente(num1);
            break;
          case "cotangente":
            result = calc.calcularCotangente(num1);
            break;
          case "secante":
            result = calc.calcularSecante(num1);
            break;
          case "cossecante":
            result = calc.calcularCossecante(num1);
            break;
          case "logaritmo":
            result = calc.calcularLogaritmo(num1);
            break;
          case "logaritmoBase10":
            result = calc.calcularLogaritmoBase10(num1);
            break;
          case "valorAbsoluto":
            result = calc.calcularValorAbsoluto(num1);
            break;
          case "calcularFatorial":
            result = calc.calcularFatorial(num1);
            break;
          case "calcularPorcentagem":
            result = calc.calcularPorcentagem(num1, num2);
            break;
          case "calcularMaior":
            result = calc.calcularMaior(num1, num2);
            break;
          case "calcularMenor":
            result = calc.calcularMenor(num1, num2);
            break;
          case "arredondarParaCima":
            result = calc.arredondarParaCima(num1);
            break;
          case "arredondarParaBaixo":
            result = calc.arredondarParaBaixo(num1);
            break;
          case "arredondar":
            result = calc.arredondar(num1);
            break;
          case "converterGrauParaRadiano":
            result = calc.converterGrauParaRadiano(num1);
            break;
          case "calcularExponencial":
            result = calc.calcularExponencial(num1);
            break;
          case "calcularRaizCubica":
            result = calc.calcularRaizCubica(num1);
            break;
          case "realParaDolar":
            result = calc.realParaDolar(num1);
            break;
          case "dolarParaReal":
            result = calc.dolarParaReal(num1);
            break;
          case "segParaMinuto":
            result = calc.segParaMinuto(num1);
            break;
          case "minutoParaSeg":
            result = calc.minutoParaSeg(num1);
            break;
          case "celsiusParaFahrenheit":
            result = calc.celsiusParaFahrenheit(num1);
            break;
          case "fahrenheitParaCelsius":
            result = calc.fahreinheitParaCelsius(num1);
            break;
          case "quilometrosParaMilhas":
            result = calc.quilometrosParaMilhas(num1);
            break;

          case "milhasParaQuilometros":
            result = calc.milhasParaQuilometros(num1);
            break;

          case "quilogramasParaLibras":
            result = calc.quilogramasParaLibras(num1);
            break;

          case "librasParaQuilogramas":
            result = calc.librasParaQuilogramas(num1);
            break;

        }

        if (result != null) {
          resultField.setText(Double.toString(result.getValor()));
        }
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a operação: " + ex.getMessage());
      }
    }
  }
}
