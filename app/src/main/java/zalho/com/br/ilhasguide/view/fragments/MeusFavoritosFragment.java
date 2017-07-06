package zalho.com.br.ilhasguide.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zalho.com.br.ilhasguide.R;
import zalho.com.br.ilhasguide.databinding.FragmentFavoritosBinding;
import zalho.com.br.ilhasguide.viewmodel.MeusFavoritosFragmentViewModel;

/**
 * Created by andrepereira on 12/06/17.
 */

public class MeusFavoritosFragment extends Fragment {

    MeusFavoritosFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new MeusFavoritosFragmentViewModel(getContext());

        FragmentFavoritosBinding viewRoot = DataBindingUtil.inflate(inflater, R.layout.fragment_favoritos, container, false);
        viewRoot.setViewModel(viewModel);

        return viewRoot.getRoot();
    }

    @Override
    public void onResume() {
        viewModel.onResume();
        super.onResume();
    }
}
