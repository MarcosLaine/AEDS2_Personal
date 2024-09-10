import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BubbleOtimizado extends JPanel {

    private final int[] array;  // Array que será ordenado
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final int BAR_WIDTH = 20;

    public BubbleOtimizado(int[] array) {
        this.array = array;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha cada barra de acordo com os valores do array
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] * 3;  // Multiplica por 3 para ajustar a altura
            g.setColor(Color.BLUE);
            g.fillRect(i * BAR_WIDTH, HEIGHT - barHeight, BAR_WIDTH, barHeight);
        }
    }

    // Função para realizar o Bubble Sort e atualizar a visualização
    public void bubbleSort() {
        int n = array.length;
        int lastUnsorted = n - 1;

        for (int i = 0; i < n - 1; i++) {
            int ultimoTroca = 0;
            for (int j = 0; j < lastUnsorted; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    ultimoTroca = j + 1;
                }
                // Atualiza a visualização após cada troca
                repaint();
                try {
                    Thread.sleep(100);  // Pausa para visualizar a troca
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Atualiza o limite do próximo loop para a última posição trocada
            lastUnsorted = ultimoTroca;

            // Se não houver trocas, a lista está ordenada
            if (ultimoTroca == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Gera um array aleatório
        int[] array = new Random().ints(30, 1, 100).toArray();  // 30 elementos entre 1 e 100

        // Cria o frame da aplicação
        JFrame frame = new JFrame("Bubble Sort - Visualização");
        BubbleOtimizado visualizer = new BubbleOtimizado(array);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(visualizer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Executa o Bubble Sort com visualização
        new Thread(() -> visualizer.bubbleSort()).start();
    }
}
