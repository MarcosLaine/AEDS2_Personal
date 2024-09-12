public class Lab03Q01_ContadorDeParentesis {
    public static void main(String[] args) {
        String equacao = MyIO.readLine();

        while (!equacao.equals("FIM")) {
            int abreParentesis = 0, fechaParentesis = 0;

            for (int i = 0; i < equacao.length(); i++) {
                if (equacao.charAt(i) == '(') {
                    abreParentesis++;
                } else if (equacao.charAt(i) == ')') {
                    fechaParentesis++;
                    if (fechaParentesis > abreParentesis) {
                        System.out.println("incorreto");
                        break;
                    }
                }
            }

            if (abreParentesis == fechaParentesis) {
                System.out.println("correto");
            } else if (fechaParentesis <= abreParentesis) { 
                System.out.println("incorreto");
            }

            equacao = MyIO.readLine();
        }
    }
}
