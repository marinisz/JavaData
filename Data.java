package datapm;
import java.io.IOException;
import java.util.Scanner;
public class Data {

    private int ano;

    private int dia;

    private int mes;

    Data(){
        ano=2000;
        dia=1;
        mes=1;
    }

    Data(int diaA,int mesB,int anoC){
        dia=diaA;
        mes=mesB;
        ano=anoC;
    }

    void initData() throws IOException{//busca no arquivo texto a última data inserida como referencia e adiciona 1 dia
        Data dataAux= new Data();
        Arquivo novoArquivo = new Arquivo();
        novoArquivo.locate("C:\\Users\\Vinicius\\Desktop\\Importantes\\PUC\\3 semestre\\PM\\dataPm\\data.txt",dataAux);
        dataAux.adicionaDias(1);
        this.setDia(dataAux.getDia());
        this.setMes(dataAux.getMes());
        this.setAno(dataAux.getAno());
    }

    public int getAno() {
        return ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void dataEntrada(){//usuario informa a data
        Scanner lerEntrada = new Scanner(System.in);
        System.out.println("Digite sua data:");
        System.out.print("Ano: ");
        this.setAno(lerEntrada.nextInt());
        while(this.getAno()<1900){
            System.out.print("Favor inserir um ano após 1900: ");
            this.setAno(lerEntrada.nextInt());
        }
        System.out.print("Mes: ");
        this.setMes(lerEntrada.nextInt());
        while(this.getMes()<=0 || this.getMes()>12){
            System.out.print("Favor inserir um mes entre 1 e 12:");
            this.setMes(lerEntrada.nextInt());
        }
        System.out.print("Dia: ");
        this.setDia(lerEntrada.nextInt());
        while(this.getMes()>31||this.getMes()<=0){
            System.out.print("Favor inserir um dia válido: ");
            this.setAno(lerEntrada.nextInt());
        }
        if(!this.isBissexto() &&this.getMes()==2){
            if(this.getDia()>=29){
            System.out.print("Favor inserir um dia válido: ");
            this.setDia(lerEntrada.nextInt());
            }
        }
        if(this.getDia()>30){
            if(this.getMes()==4||this.getMes()==6||this.getMes()==9||this.getMes()==11){
            System.out.print("Favor inserir um dia válido: ");    
            }
        }       
    } //Usuário insere a data

    public boolean isBissexto(){
        boolean resposta=false;
        if (this.getAno()%4==0){
         if(this.getAno()%100==0){
             if(this.getAno()%400==0){
                 resposta = true;
             }
         }   
        }
        return resposta;
    }

    public boolean tem30(){//confere se o mês tem 30 dias;
        boolean resp=false;
       if(this.getMes()==4||this.getMes()==6||this.getMes()==9||this.getMes()==11){
           resp=true;
    }
       return resp;
    }

    public void adicionaDias(int quantDias){
        for(int i=0;i<quantDias;i++){
            this.setDia((this.getDia()+1));
            if(this.isBissexto() && this.getMes()==2){
                    if(this.getDia()>29){
                        this.setDia(1);
                        this.setMes(this.getMes()+1);
                    }
                    if (this.getMes()>12){
                        this.setMes(1);
                        this.setAno(this.getAno()+1);
                    }

            }else if(!this.isBissexto() && this.getMes()==2){
                if(this.getDia()>28){
                    this.setDia(1);
                    this.setMes(this.getMes()+1);
                }
                if (this.getMes()>12){
                    this.setMes(1);
                    this.setAno(this.getAno()+1);
                }
            }

            if(this.tem30()){
                if(this.getDia()>30){
                    this.setDia(1);
                    this.setMes(this.getMes()+1);
                    if (this.getMes()>12){
                        this.setMes(1);
                        this.setAno(this.getAno()+1);
                    }
                }
            }
            else if(this.getDia()>31){
                this.setDia(1);
                this.setMes(this.getMes()+1);
                if (this.getMes()>12){
                    this.setMes(1);
                    this.setAno(this.getAno()+1);
                }
            }

        }
    }

    public String voltaMes(){//Retorna o mês em string (toString)
        String[] mes ={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        return mes[this.getMes()-1];
    }

    public void imprimeData(){
        System.out.println(this.getDia()+" de "+this.voltaMes()+" "+this.getAno());
    }

    public int diferencaDatas(Data data1,Data data2){//calcula a diferença de dias entre datas
        int contador=0;
        Data dataAntiga = mostraAntiga(data1,data2);
        Data dataMaisRecente = mostraRecente(data1, data2);
        do{
            dataAntiga.adicionaDias(1);
            contador++;
        }while (dataAntiga.getAno()!=dataMaisRecente.getAno());

        do{
            dataAntiga.adicionaDias(1);
            contador++;
        }while (dataAntiga.getMes()!=dataMaisRecente.getMes());

        do{
            dataAntiga.adicionaDias(1);
            contador++;
        }while(dataAntiga.getDia()!=dataMaisRecente.getDia());

        return contador;
    }

    public boolean igualData(Data data1, Data data2){//confere se duas datas sao iguais
        boolean resposta=true;
        if(data1.getAno()==data2.getAno()){
            if(data1.getMes()==data2.getMes()){
                if(data1.getDia()==data2.getDia()){
                    resposta=true;
                }else{
                    resposta =false;
                }
            }else{
                resposta = false;
            }
        }else{
            resposta = false;
        }
        return resposta;
    }


    public Data mostraRecente(Data data1,Data data2){
        int resp;
        Data dataAux = new Data();
        if(data1.getAno()<data2.getAno()){
            resp=2;
        }else{
            resp=1;
        }

        if(data1.getAno()==data2.getAno()){
            if(data1.getMes()<data2.getMes()){
                resp=2;
            }else{
                resp=1;
            }
        }

        if(data1.getAno()==data2.getAno()){
            if(data1.getMes()==data2.getMes()){
                if(data1.getDia()<data2.getDia()){
                    resp=2;
                }
            }else{
                resp=1;
            }
        }

        if(resp==1){
            dataAux=data1;
        }else{
            dataAux=data2;
        }
        return dataAux;
    }

    public Data mostraAntiga(Data data1, Data data2){
        int resp;
        Data dataAux = new Data();
        if(data1.getAno()<data2.getAno()){
            resp=1;
        }else{
            resp=2;
        }

        if(data1.getAno()==data2.getAno()){
            if(data1.getMes()<data2.getMes()){
                resp=1;
            }else{
                resp=2;
            }
        }

        if(data1.getAno()==data2.getAno()){
            if(data1.getMes()==data2.getMes()){
                if(data1.getDia()<data2.getDia()){
                    resp=1;
                }
            }else{
                resp=2;
            }
        }

        if(resp==1){
            dataAux=data1;
        }else{
            dataAux=data2;
        }
        return dataAux;
    }
}
