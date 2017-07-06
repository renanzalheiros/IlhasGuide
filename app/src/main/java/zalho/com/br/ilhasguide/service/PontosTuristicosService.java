package zalho.com.br.ilhasguide.service;

import android.content.Context;

import java.math.BigDecimal;
import java.util.List;

import zalho.com.br.ilhasguide.dao.PontoTuristicoDao;
import zalho.com.br.ilhasguide.entities.PontoTuristico;

/**
 * Created by andrepereira on 16/06/17.
 */

public class PontosTuristicosService {

    private PontoTuristicoDao dao;

    public PontosTuristicosService(Context context){
        dao = new PontoTuristicoDao(context);
//        dao.dropTable();
//        dao.insere(new PontoTuristico("Ponte Hercílio Luz", "Ponte cartão postal da cidade de Florianópolis", "", new BigDecimal("13.75"), "Centro, Florianópolis - SC, 88010-400"));
//        dao.insere(new PontoTuristico("Igreja do Centro", "Igreja cartão postal da cidade de Florianópolis", "", new BigDecimal("0.00"), "Centro, Florianópolis - SC, 88010-400"));
//        dao.insere(new PontoTuristico("Museu Cruz e Souza", "Museu cartão postal da cidade de Florianópolis", "", new BigDecimal("15.00"), "Centro, Florianópolis - SC, 88010-400"));
//        dao.insere(new PontoTuristico("UFSC", "Universidade Federal De Santa Catarina", "", new BigDecimal("0.00"), "Centro, Florianópolis - SC, 88010-400"));
    }

    public List<PontoTuristico> getPontosTuristicos() {
        return dao.getAll();
    }
}
