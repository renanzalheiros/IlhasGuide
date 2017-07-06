package zalho.com.br.ilhasguide.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.SupportMapFragment;

import zalho.com.br.ilhasguide.R;
import zalho.com.br.ilhasguide.view.adapter.ViewPagerAdapter;
import zalho.com.br.ilhasguide.view.fragments.MapaFragment;
import zalho.com.br.ilhasguide.view.fragments.MeusFavoritosFragment;
import zalho.com.br.ilhasguide.view.fragments.PontosTuristicosFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager_main_activity);
        configurarViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_main_activity);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        final PontosTuristicosFragment pontosTuristicosFragment = new PontosTuristicosFragment();
        final MeusFavoritosFragment meusFavoritosFragment = new MeusFavoritosFragment();

        viewPagerAdapter.addFragment(pontosTuristicosFragment, "Pontos turisticos");
        viewPagerAdapter.addFragment(meusFavoritosFragment, "Meus favoritos");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                switch (i){
                    case 0:
                        layoutLoading();
                        pontosTuristicosFragment.onResume();
                        layoutLoadingDismiss();
                        break;
                    case 1:
                        layoutLoading();
                        meusFavoritosFragment.onResume();
                        layoutLoadingDismiss();
                        break;
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        viewPager.setAdapter(viewPagerAdapter);
    }

    public void layoutLoading(){
        RelativeLayout progressBar = (RelativeLayout) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.GONE);
    }

    public void layoutLoadingDismiss(){
        RelativeLayout progressBar = (RelativeLayout) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        viewPager.setVisibility(View.VISIBLE);
    }

    public void vaiParaMapa(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new MapaFragment()).addToBackStack("Main")
                .commit();
    }
}
