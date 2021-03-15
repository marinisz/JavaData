package datapm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
    public boolean write(String Caminho,String Texto) throws IOException{
        try{
            FileWriter arquivo = new FileWriter(Caminho,true);
            PrintWriter gravaArquivo = new PrintWriter(arquivo);
            gravaArquivo.println(Texto);
            arquivo.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
        return false;
    }
    
}
    public String read(String caminho) throws FileNotFoundException, IOException{
        String conteudo ="";
        try{
            FileReader arq=new FileReader(caminho);
            BufferedReader lerArq=new BufferedReader(arq);
            String linha;
            try{
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo+=linha;
                    linha=lerArq.readLine();
                    conteudo+="\n";
                }
                arq.close();
            }catch(IOException ex){
                conteudo="erro: não foi possivel ler o arquivo";
            }
        }catch (FileNotFoundException ex){
            conteudo="Não encontrei o arquivo";
        return conteudo;
    }
        return conteudo;
    }
    public void locate(String caminho, Data dataAux) throws FileNotFoundException, IOException{
        FileReader arq=new FileReader(caminho);
        BufferedReader lerArq=new BufferedReader(arq);
        String dataEncontrada="";
            String linha = lerArq.readLine();
            int i =0;
            while((linha = lerArq.readLine())!=null){
                dataEncontrada=linha;
            }
            String campos[]=dataEncontrada.split("/");
            dataAux.setDia(Integer.parseInt(campos[0]));
            dataAux.setMes(Integer.parseInt(campos[1]));
            dataAux.setAno(Integer.parseInt(campos[2]));
            arq.close();
           }

}
