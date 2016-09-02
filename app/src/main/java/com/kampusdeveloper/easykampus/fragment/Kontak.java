package com.kampusdeveloper.easykampus.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kampusdeveloper.easykampus.R;
import com.kampusdeveloper.easykampus.adapter.CustomListAdapter;


public class Kontak extends Fragment {
    private TextView klik_telp, klik_wa;
    private ListView list;
    String[] itemname ={
            "Achmad Hindasyah, S.Si., M.Si","Ahmad Fikri Z, M.Kom","Achmad Bisri, S.Kom",
            "Achmad Udin Z, M.Kom","Agung Perdananto, S.Kom","Ahmad Musyafa, S.Kom",
            "Alvano Yulian, M.Si","Alvino Octaviano, M.Kom","Anis Mirza, M.Kom",
            "Ardianto Moenir, M.M","Ari Mulyoto","Ari Syarifudin, S.Kom",
            "Aries Saifudin, S.Kom","Asip Suyadi, MH","Atang Susila, Ir, M.Eng",
            "Bagas Setiyaki W, S.Kom","Bobby Reza, M.Kom","Bobi Agustian, S.Kom",
            "Bodi Santoso, MT","Budi Aprianto S.Kom","Drs. Dede Sahrul B, M.Si",
            "Dede Supriyadi, M.Kom","Dedin Fathudin, S.Kom","Dena Wulandari, M.Si",
            "Devi Yunita, S.Kom","Dimas Abisono P, S.Kom","Elfi Fauziah, S.Si, M.Pd",
            "Endar Nirmala, MT","Entis Sutrisna, S.Kom","Evy Nurmiati, MSi",
            "Fajar Agung Nugroho, S.Kom", "Fajar Septian, S.Kom","Farida Nurlaila, S.Kom",
            "Fatah Rohmani, S.Si","Fathurrohim, S.Kom", "Fitriyanti, S.Kom",
            "Hadi Zakaria, MM, M.Kom","Hendra Bayu, S.Kom","Hendri Ardiyansyah",
            "Heri Haerudin, S.Kom", "Hersanto, S.Kom","Hiram Sulistio S, S.Kom",
            "Irfan K, S.Kom","Jaka Sutresna, S.Kom","Jamaludin, S.Ag., M.Ag",
            "Joko Priambodo, M.Kom","Joko Riyanto, S.Kom","Joko Trianto, M.Kom",
            "Kecitaan Harefa, S.Kom","Khaerul Ma mur", "Kussigit Santosa, Ir, MT",
            "M Feizal, S.Kom, M.Kom","M. Bagoes Satria J, S.Kom","M. Saefudin, S.Kom. MMSi",
            "Maulana Ardiyansyah, S.Kom","Muhamad Meky Frindo, S.Kom","Muhamad Yasser Arafat, S.Kom",
            "Munawaroh, S.Kom","Nardiono , S.Kom", "Narkim N, ST, M.Kom",
            "Neneng Misliyah, S.Pd","Niki Ratama, S.Kom","Normalisa, M.Kom",
            "Nur Rofiq, M.Kom", "Nurhasanah, S.Kom","Nurjaya, M.Kom",
            "Perani Rosyani, S.Kom","Petricia Octavia, S.Kom","Putu Budayasa, MT",
            "Rengga, M.Kom", "Resti Amalia, S.Kom","Rina Rachmatika, S.Kom",
            "Riswal Hanafi S, S.Si, M.Si","Samsoni, S.Kom", "Saprudin, S.Kom",
            "Sartika Lina Mulani Sitio","Shandi Noris, S.Kom","Sholihin, S.Kom, MM",
            "Sofa Sofiana, S.Kom", "Sofiyan Hadi, M.Ag","Sri Mulyati, M.Ag",
            "Surip Widodo, Ir,. MIT","Surtikanti, S.Kom","Susanna Dwi Yulianti K. S.Kom",
            "Suyatno, S.Kom, MMSi", "Teti Desyani, S.Kom","Thoyyibah T, S.Kom, M.Kom",
            "Tita Puspita S, S.Pd, M.Pd","Unggul Utan Sufandi, M.Kom","Wasis, S.Kom, M.Kom",
            "Yono Cahyono, S.Kom","Yudi Kurniawan, S.Kom","Yudi Winartono, S.Kom, M.Kom",
            "Yulianti, S.Kom"
    };

    String[] telp ={
            "085210931222","08118333433","085778191945","085782229531","085959675786","085814311468",
            "08129958696","081786274001","081284810715","0811830557","08179131130","081293812467",
            "08158012019","081297677747","081386077015","085719966311","02170632355","085697592072",
            "02518616786","081387124655","082122371674","081284963948","085719889659","081316837040",
            "087775400894","08812762779","081327020058","081319520514","08121042049","08159804592",
            "087884702807","087712736086","085697582621","081289757365","081310296825","085218562646",
            "087778597991","085883434069","085710098519","082122677328","085959702768","087884551130",
            "08892354218","081388994453","081318266572","085693344606","085782355589","089673389151",
            "081370365956","085642523264","081281963243","081380605995","087889681222","08128765554",
            "","085774478810","083811613443","08993979903","085719862426","081906421779","08881100159",
            "081294507444","081281183388","085694424977","08988161476","089651764377","087876716180",
            "08131159961","0817707041","08567385256","085695544357","081284300898","082114085749",
            "087809582782","083893323436","085945400620","085695570188","081510115039","085697474131",
            "08158179261","081213357600","08129751369","081315226063","081295187087","0811887350",
            "083895411941","0813820388482","081213968286","08159927963","085693343444","08892608582",
            "02192285849","085269618800","083870892018"
    };

    Integer[] imgid={
            R.drawable.ahmad, R.drawable.fikri, R.drawable.unpam,R.drawable.udin, R.drawable.agung,  R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,
            R.drawable.unpam,R.drawable.unpam,R.drawable.unpam,R.drawable.unpam
    };

    public Kontak() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kontak, container, false);

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), itemname,telp, imgid);
        list=(ListView)v.findViewById(R.id.lv_kontak);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                final String selectTelp = telp[+position];
                //Toast.makeText(getContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_kontak);
                dialog.setCancelable(true);
                dialog.setTitle(Slecteditem);
                //set up text
                TextView text = (TextView) dialog.findViewById(R.id.TextView01);
                text.setText(selectTelp);

                //set up image view
                ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
                img.setImageResource(imgid[+position]);

                klik_telp = (TextView) dialog.findViewById(R.id.tv_telp);
                klik_telp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + selectTelp));
                        startActivity(intent);
                    }
                });

                klik_wa = (TextView)dialog.findViewById(R.id.tv_pesan);
                klik_wa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse("smsto:" + selectTelp);
                        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                        i.setPackage("com.whatsapp");
                        startActivity(Intent.createChooser(i, ""));                    }
                });
                //now that the dialog is set up, it's time to show it
                dialog.show();


            }
        });

        return v;
    }
}
