package zalho.com.br.ilhasguide.service;

import android.content.Context;

import java.util.List;

import zalho.com.br.ilhasguide.dao.PontoTuristicoDao;
import zalho.com.br.ilhasguide.entities.PontoTuristico;

/**
 * Created by andrepereira on 15/06/17.
 */

public class FavoritoService {

    private PontoTuristicoDao pontoTuristicoDao;

    public FavoritoService(Context context){
        pontoTuristicoDao = new PontoTuristicoDao(context);
    }

    public List<PontoTuristico> getFavorites() {
        return pontoTuristicoDao.getFavorites();
    }

    public boolean addToFavorites(PontoTuristico pontoTuristico) {
        return pontoTuristicoDao.addToFavirotes(pontoTuristico);
    }
}
