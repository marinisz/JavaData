package datapm;

import java.io.IOException;

public class DataPm {
    public static void main(String[] args) throws IOException {
        Data dataUsuario = new Data(21,9,2018);
        Data dataTeste= new Data();
        dataTeste.initData();
        //String caminho = "C:\\Users\\Vinicius\\Desktop\\Importantes\\PUC\\3 semestre\\PM\\dataPm\\data.txt";
        //Arquivo novoArquivo = new Arquivo();
        dataTeste.imprimeData();
        dataUsuario.imprimeData();

        int contador=dataTeste.diferencaDatas(dataUsuario,dataTeste);
        System.out.println("Diferença de "+contador+" dias");
        //novoArquivo.write(caminho,dataUsuario.getDia()+"/"+dataUsuario.getMes()+"/"+dataUsuario.getAno());
        //System.out.println("Diferença de: "+dataUsuario.diferencaDatas(dataTeste, dataUsuario)+" dias");
    }
}
