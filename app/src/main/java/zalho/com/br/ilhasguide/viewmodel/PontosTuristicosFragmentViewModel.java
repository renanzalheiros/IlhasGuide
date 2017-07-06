package zalho.com.br.ilhasguide.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.manager.PontosTuristicosManager;
import zalho.com.br.ilhasguide.view.adapter.PontoTuristicoAdapter;

/**
 * Created by andrepereira on 12/06/17.
 */

public class PontosTuristicosFragmentViewModel extends BaseObservable {

    public ObservableArrayList<PontoTuristico> pontosTuristicos = new ObservableArrayList<>();
    private PontosTuristicosManager manager;

    public PontosTuristicosFragmentViewModel(){
    }

    @BindingAdapter("itemsPontosTuristicos")
    public static void bindList(final RecyclerView view, ObservableArrayList<PontoTuristico> pontos){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(linearLayoutManager);
        view.setAdapter(new PontoTuristicoAdapter(pontos));
    }

    public void onResume(Context context) {
        manager = new PontosTuristicosManager(context);
        pontosTuristicos.clear();
        pontosTuristicos.addAll(manager.loadList());
    }
}
