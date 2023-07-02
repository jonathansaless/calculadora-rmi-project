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
    try {
      Registry registry = LocateRegistry.getRegistry(null);
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

    // Obtém as dimensões da tela do meu dispositivo
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    // Define o tamanho da janela para ocupar a tela do dispositivo
    frame.setSize(screenWidth, screenHeight);

    resultField = new JTextField();
    resultField.setEditable(false);
    frame.add(resultField, BorderLayout.CENTER);

    JPanel inputPanel = new JPanel(new GridLayout(2, 2));

    JLabel inputLabel1 = new JLabel("Valor 1:");
    inputPanel.add(inputLabel1);

    inputField1 = new JTextField();
    inputPanel.add(inputField1);

    JLabel inputLabel2 = new JLabel("Valor 2:");
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

    JButton squareRootButton = new JButton("√");
    squareRootButton.addActionListener(new ButtonClickListener("raizQuadrada"));
    buttonPanel.add(squareRootButton);

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

    JButton logButton = new JButton("log");
    logButton.addActionListener(new ButtonClickListener("logaritmo"));
    buttonPanel.add(logButton);

    JButton log10Button = new JButton("log10");
    log10Button.addActionListener(new ButtonClickListener("logaritmoBase10"));
    buttonPanel.add(log10Button);

    JButton absButton = new JButton("|x|");
    absButton.addActionListener(new ButtonClickListener("valorAbsoluto"));
    buttonPanel.add(absButton);

    JButton currencyButton = new JButton("Moeda (BR->USD)");
    currencyButton.addActionListener(new ButtonClickListener("converterMoeda"));
    buttonPanel.add(currencyButton);

    JButton timeButton = new JButton("Tempo (Min->Seg)");
    timeButton.addActionListener(new ButtonClickListener("converterTempo"));
    buttonPanel.add(timeButton);

    JButton lengthButton = new JButton("Comprimento (km->m)");
    lengthButton.addActionListener(new ButtonClickListener("converterComprimento"));
    buttonPanel.add(lengthButton);

    JButton weightButton = new JButton("Peso (g->kg)");
    weightButton.addActionListener(new ButtonClickListener("converterPeso"));
    buttonPanel.add(weightButton);

    JButton volumeButton = new JButton("Volume (l->ml)");
    volumeButton.addActionListener(new ButtonClickListener("converterVolume"));
    buttonPanel.add(volumeButton);

    JButton temperatureButton = new JButton("Temperatura (ºC->ºF)");
    temperatureButton.addActionListener(new ButtonClickListener("converterTemperatura"));
    buttonPanel.add(temperatureButton);

    JButton factorialButton = new JButton("!");
    factorialButton.addActionListener(new ButtonClickListener("calcularFatorial"));
    buttonPanel.add(factorialButton);

    JButton percentageButton = new JButton("%");
    percentageButton.addActionListener(new ButtonClickListener("calcularPorcentagem"));
    buttonPanel.add(percentageButton);

    JButton maxButton = new JButton("max");
    maxButton.addActionListener(new ButtonClickListener("calcularMaior"));
    buttonPanel.add(maxButton);

    JButton minButton = new JButton("min");
    minButton.addActionListener(new ButtonClickListener("calcularMenor"));
    buttonPanel.add(minButton);

    JButton ceilButton = new JButton("ceil");
    ceilButton.addActionListener(new ButtonClickListener("arredondarParaCima"));
    buttonPanel.add(ceilButton);

    JButton floorButton = new JButton("floor");
    floorButton.addActionListener(new ButtonClickListener("arredondarParaBaixo"));
    buttonPanel.add(floorButton);

    JButton roundButton = new JButton("round");
    roundButton.addActionListener(new ButtonClickListener("arredondar"));
    buttonPanel.add(roundButton);

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
          case "converterMoeda":
            result = calc.converterMoeda(num1, "BRL", "USD");
            break;
          case "converterTempo":
            result = calc.converterTempo(num1, "minutos", "segundos");
            break;
          case "converterComprimento":
            result = calc.converterComprimento(num1, "quilometros", "metros");
            break;
          case "converterPeso":
            result = calc.converterPeso(num1, "gramas", "quilogramas");
            break;
          case "converterVolume":
            result = calc.converterVolume(num1, "litros", "mililitros");
            break;
          case "converterTemperatura":
            result = calc.converterTemperatura(num1, "Celsius", "Fahrenheit");
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
        }

        if (result != null) {
          resultField.setText("Resultado: " + result.getValor());
        } else {
          resultField.setText("Ocorreu um erro ao calcular.");
        }
      } catch (Exception ex) {
        resultField.setText("Ocorreu um erro ao calcular.");
      }
    }
  }
}
