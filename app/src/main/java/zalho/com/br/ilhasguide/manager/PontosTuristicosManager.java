package zalho.com.br.ilhasguide.manager;

import android.content.Context;

import java.util.List;

import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.service.PontosTuristicosService;

/**
 * Created by andrepereira on 16/06/17.
 */

public class PontosTuristicosManager {

    PontosTuristicosService service;

    public PontosTuristicosManager(Context context){
        service = new PontosTuristicosService(context);
    }

    public List<PontoTuristico> loadList() {
        return service.getPontosTuristicos();
    }
}
