package zalho.com.br.ilhasguide.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrepereira on 12/06/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;
    private List<String> titulos;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        this.fragments = new ArrayList<>();
        this.titulos = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment, String titulo) {
        fragments.add(fragment);
        titulos.add(titulo);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }
}
