package zalho.com.br.ilhasguide.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.manager.FavoritoManager;
import zalho.com.br.ilhasguide.view.adapter.PontoTuristicoAdapter;

/**
 * Created by andrepereira on 15/06/17.
 */

public class MeusFavoritosFragmentViewModel extends BaseObservable{

    public ObservableArrayList<PontoTuristico> favoritos = new ObservableArrayList<>();
    private final FavoritoManager manager;

    public MeusFavoritosFragmentViewModel(Context context){
        manager = new FavoritoManager(context);
        favoritos.clear();
        List<PontoTuristico> pontoTuristicos = manager.loadFavoritesList();
        favoritos.addAll(pontoTuristicos);
    }

    @BindingAdapter("itemsFavoritos")
    public static void bindList(RecyclerView view, ObservableArrayList<PontoTuristico> favoritos){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(linearLayoutManager);
        view.setAdapter(new PontoTuristicoAdapter(favoritos));
    }

    public void onResume() {
        favoritos.clear();
        favoritos.addAll(manager.loadFavoritesList());
    }
}
