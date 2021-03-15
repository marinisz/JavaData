package datapm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataPmTestTest {

    @Test
    void getMes() {
        Data data1 = new Data(12,12,2010);
        assertEquals(12,data1.getMes());
    }

    @Test
    void getDia(){
        Data data1 = new Data(12,12,2010);
        assertEquals(12,data1.getDia());
    }

    @Test
    void adicionaDiasBissexto(){
        int a=1;
        Data data1 = new Data(29,02,2020);
        data1.adicionaDias(a);
        assertEquals(03,data1.getMes());
    }

    @Test
    void adicionaDiasNBissexto(){
        int a=1;
        Data data1 = new Data(28,02,2021);
        data1.adicionaDias(a);
        assertEquals(03,data1.getMes());
    }

    @Test
    void testa1anoNBissexto(){
        int a=365;
        Data data1 = new Data(28,02,2021);
        data1.adicionaDias(a);
        assertEquals(28,data1.getDia());
    }

    @Test
    void testa1anoBissexto(){
        int a=366;
        Data data1 = new Data(28,02,2020);
        data1.adicionaDias(a);
        assertEquals(28,data1.getDia());
    }

    @Test
    void diferencadatas(){
        Data data1 = new Data(28,02,2020);
        Data data2 = new Data(28,02,2021);
        assertEquals(365,data1.diferencaDatas(data1,data2));
    }

    @Test
    void diferencaDatasGrande(){
        Data data1 = new Data(21,10,2020);
        Data data2 = new Data(21,9,2026);
        assertEquals(2161,data1.diferencaDatas(data1,data2));
    }

    @Test
    void voltaMes(){
        Data data1 = new Data(21,10,2020);
        assertEquals("Outubro",data1.voltaMes());
    }

    @Test
    void voltaAntiga(){
        Data data1 = new Data(21,10,2020);
        Data data2 = new Data(21,10,2010);
        assertEquals(data2,data1.mostraAntiga(data1,data2));
    }

    @Test
    void voltaRecente(){
        Data data1 = new Data(21,10,2020);
        Data data2 = new Data(21,10,2010);
        assertEquals(data1,data1.mostraRecente(data1,data2));
    }

}