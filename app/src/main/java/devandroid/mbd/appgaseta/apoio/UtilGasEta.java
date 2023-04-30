package devandroid.mbd.appgaseta.apoio;

public class UtilGasEta {

    public void metodoNaoEstatico(){}

    public static void metodoEstatico(){}

    public static String mensagem(){

        return "qualquer mensagem";
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal){
            mensagemDeRetorno = "Abastecer com Etanol";
        }else {
            mensagemDeRetorno = "Abasteçer com Gasolina";
        }
        return mensagemDeRetorno;
    }

}
