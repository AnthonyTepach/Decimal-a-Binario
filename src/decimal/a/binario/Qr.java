package decimal.a.binario;

public class Qr {

    private String ObtieneQRBinario(String Cadeniux, int inicio, int fin) {
        char myCharcero = (char) 14;
        char myCharuno = (char) 15;
        Cadeniux = Cadeniux.replace(myCharcero, '0');
        Cadeniux = Cadeniux.replace(myCharuno, '1');
        Cadeniux = Cadeniux.substring(inicio, fin);
        return Cadeniux;
    }

    private int decimal(String bin) {
        int num = Integer.parseInt(bin, 2);
        return num;
    }

    private String binario(int decimal) {
        String data = Integer.toBinaryString(decimal);
        return data;
    }

    public int getFolio(String text) {
        String folioB = ObtieneQRBinario(text, 0, 30);
        return decimal(folioB);
    }

    public int getTipo(String text) {
        String tip = ObtieneQRBinario(text, 59, 63);
        return decimal(tip);
    }

    public static void main(String[] args) {
        Qr R = new Qr();
        //int a= R.getFolio("http://www.guadalajara.gob.mx");
        //System.out.println(a);
        System.out.println(R.toJadenCase("most trees are blue"));

    }

    public String toJadenCase(String phrase) {
        String txtNew = "";
        // TODO put your code below this comment
        String[] space = phrase.split(" ");
        for (int i = 0; i < space.length; i++) {
            txtNew = txtNew + space[i].substring(0, 1).toUpperCase() + space[i].substring(1);
           
        }
        return txtNew;
    }
}
