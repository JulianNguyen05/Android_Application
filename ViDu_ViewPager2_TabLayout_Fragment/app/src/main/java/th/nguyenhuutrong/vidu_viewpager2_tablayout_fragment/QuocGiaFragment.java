package th.nguyenhuutrong.vidu_viewpager2_tablayout_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class QuocGiaFragment extends Fragment {
    QuocGia quocGia;

    public QuocGiaFragment(QuocGia _QuocGia) {
        quocGia = _QuocGia;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewFrg = inflater.inflate(R.layout.fragment_quoc_gia, container, false);

        TextView txtCountryName = viewFrg.findViewById(R.id.txtCountryName);
        TextView txtDanSo = viewFrg.findViewById(R.id.txtPopulation);
        ImageView imgCountryFlag = viewFrg.findViewById(R.id.imgCountryFlag);

        txtCountryName.setText(quocGia.getCountryName());
        txtDanSo.setText(String.valueOf(quocGia.getPopulation()));
        int resID = viewFrg.getResources().getIdentifier(quocGia.getCountryFlag(), "mipmap", viewFrg.getContext().getPackageName());
        imgCountryFlag.setImageResource(resID);


        return  viewFrg;
    }
}