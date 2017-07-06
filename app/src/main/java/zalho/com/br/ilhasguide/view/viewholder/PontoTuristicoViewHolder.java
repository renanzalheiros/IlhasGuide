package zalho.com.br.ilhasguide.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import zalho.com.br.ilhasguide.databinding.AdapterPontoTuristicoRowBinding;
import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.viewmodel.PontoTuristicoHolderViewModel;

/**
 * Created by andrepereira on 14/06/17.
 */

public class PontoTuristicoViewHolder extends RecyclerView.ViewHolder {

    final AdapterPontoTuristicoRowBinding binding;

    public PontoTuristicoViewHolder(AdapterPontoTuristicoRowBinding itemView) {
        super(itemView.getRoot());

        binding = itemView;
    }

    public void bindData(PontoTuristico pontoTuristico){
        if(binding.getViewModel() == null){
            binding.setViewModel(new PontoTuristicoHolderViewModel(pontoTuristico));
        } else {
            binding.getViewModel().setPontoTuristico(pontoTuristico);
        }
    }
}
