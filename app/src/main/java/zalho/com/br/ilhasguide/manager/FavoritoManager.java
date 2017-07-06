package zalho.com.br.ilhasguide.manager;

import android.content.Context;

import java.util.List;

import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.service.FavoritoService;

/**
 * Created by andrepereira on 15/06/17.
 */

public class FavoritoManager {

    private final Context context;
    private FavoritoService service;

    public FavoritoManager(Context context) {
        this.context = context;
        this.service = new FavoritoService(context);
    }

    public List<PontoTuristico> loadFavoritesList() {

        return service.getFavorites();
    }

    public boolean addToFavorites(PontoTuristico pontoTuristico) {
        return service.addToFavorites(pontoTuristico);
    }
}
