package zalho.com.br.ilhasguide.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.ilhasguide.R;
import zalho.com.br.ilhasguide.databinding.FragmentPontosTuristicosBinding;
import zalho.com.br.ilhasguide.viewmodel.PontosTuristicosFragmentViewModel;

/**
 * Created by andrepereira on 12/06/17.
 */

public class PontosTuristicosFragment extends Fragment {

    PontosTuristicosFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new PontosTuristicosFragmentViewModel();

        FragmentPontosTuristicosBinding viewRoot = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_pontos_turisticos,
                container,
                false);
        viewRoot.setViewModel(viewModel);

        return viewRoot.getRoot();
    }

    @Override
    public void onResume() {
        viewModel.onResume(getContext());
        super.onResume();
    }
}
