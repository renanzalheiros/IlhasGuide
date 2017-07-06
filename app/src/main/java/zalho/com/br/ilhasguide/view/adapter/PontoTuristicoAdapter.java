package zalho.com.br.ilhasguide.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import zalho.com.br.ilhasguide.R;
import zalho.com.br.ilhasguide.databinding.AdapterPontoTuristicoRowBinding;
import zalho.com.br.ilhasguide.entities.PontoTuristico;
import zalho.com.br.ilhasguide.view.viewholder.PontoTuristicoViewHolder;

/**
 * Created by andrepereira on 14/06/17.
 */

public class PontoTuristicoAdapter extends RecyclerView.Adapter<PontoTuristicoViewHolder> {

    private final List<PontoTuristico> pontosTuristicos;

    public PontoTuristicoAdapter(List<PontoTuristico> pontosTuristicos) {
        this.pontosTuristicos = pontosTuristicos;
    }

    @Override
    public PontoTuristicoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterPontoTuristicoRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.adapter_ponto_turistico_row, viewGroup, false);

        return new PontoTuristicoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PontoTuristicoViewHolder pontoTuristicoViewHolder, int i) {
        pontoTuristicoViewHolder.bindData(pontosTuristicos.get(i));
    }

    @Override
    public int getItemCount() {
        return pontosTuristicos.size();
    }
}
