package zalho.com.br.ilhasguide.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.manager.FavoritoManager;
import zalho.com.br.ilhasguide.view.MainActivity;

/**
 * Created by andrepereira on 14/06/17.
 */

public class PontoTuristicoHolderViewModel extends BaseObservable {

    public PontoTuristico pontoTuristico;

    public ObservableField<String> ptName = new ObservableField<>();
    public ObservableField<String> ptDescription = new ObservableField<>();
    public ObservableField<String> ptPrice = new ObservableField<>();
    public ObservableField<String> ptImagePath = new ObservableField<>();
    public ObservableField<Integer> ptFlFavorito = new ObservableField<>(0);

    private FavoritoManager manager;

    public PontoTuristicoHolderViewModel(PontoTuristico pontoTuristico){
        this.pontoTuristico = pontoTuristico;
        ptName.set(pontoTuristico.getNomePT());
        ptDescription.set(pontoTuristico.getDescricaoPT());
        ptPrice.set("R$ " + String.valueOf(pontoTuristico.getPrecoPT()));
        ptImagePath.set(pontoTuristico.getImagePathPT());
        ptFlFavorito.set(pontoTuristico.isFavorito() ? 1 : 0);
    }

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }

    public void mapa(View view){
        ((MainActivity) view.getContext()).vaiParaMapa();
    }

    public void onFavorites(View view){
        manager = new FavoritoManager(view.getContext());
        if(pontoTuristico.isFavorito()){
            pontoTuristico.setFavorito(false);
        } else {
            pontoTuristico.setFavorito(true);
        }
        boolean b = manager.addToFavorites(this.pontoTuristico);
        if(b){
            Toast.makeText(view.getContext(), "Add nos favoritos", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(view.getContext(), "erro ao adicionar nos favoritos", Toast.LENGTH_LONG).show();
        }
    }

    @BindingAdapter("productImage")
    public static void bindProductImage(final ImageView imageView, String imagePath){
//        Picasso.with(imageView.getContext()).load("http://192.168.0.16:9090/mypan/img/products/" + imagePath).into(imageView);
    }

}
