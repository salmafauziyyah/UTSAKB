package com.example.salmafauziyyah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.salmafauziyyah.R;
//19-mei-2019,10116596-salmafauziyyah
public class KontakFragment extends Fragment {
    ImageView imgCall, imgSm, imgEmail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.f_kontak, container, false);
        imgCall = (ImageView) view.findViewById(R.id.gmbrTelp);
        imgEmail = (ImageView) view.findViewById(R.id.gmbrEmail);
        imgSm = (ImageView) view.findViewById(R.id.gmbrIg);

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String NomerHp = "083112646979";
                Intent intentpanggil = new Intent(Intent.ACTION_DIAL);
                intentpanggil.setData(Uri.parse("tel:"+NomerHp));
                startActivity(intentpanggil);
            }
        });
        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"salmafauziyyah1@gmail.com"});
                try {
                    startActivity(Intent.createChooser(intent, "Ingin Mengirim Email ?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    //do something else
                }
            }
        });
        imgSm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String Instagram = "https://www.instagram.com/salmafyh/";
                Intent bukaIg = new Intent(Intent.ACTION_VIEW);
                bukaIg.setData(Uri.parse(Instagram));
                startActivity(bukaIg);
            }
        });
        return view;
    }
}
