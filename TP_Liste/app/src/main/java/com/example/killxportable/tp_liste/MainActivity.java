package com.example.killxportable.tp_liste;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //private ListView MaListe;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // MaListe = (ListView) findViewById(R.id.maliste);

        ArrayList<AndroidVersion> androidList = new ArrayList<AndroidVersion>();
        initList(androidList);
        AndroidAdapter adapter = new AndroidAdapter(this,R.layout.ll_layoutlinear,androidList);
        final ListView list = (ListView) findViewById(R.id.maliste);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                AndroidVersion selectedItem = (AndroidVersion)adapter.getItemAtPosition(position);
                Log.v("ListPersonnalisée", "Element selectionné : " + selectedItem.getVersionName());
                //Vous pouvez faire un TOAST
            }
        });

        //Travailler avec les ressources du projet
        //Votre objet ressources
        //Resources res = getResources();

        //Tableau des chaine de caractère provenant du tableau défini dans string.xml
        //String[] MesValeurs = res.getStringArray(R.array.montableau);

        //Remplir l'adapteur
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MesValeurs);

        //Lier données a la liste
        //MaListe.setAdapter(adapter);
    }

    private void initList(ArrayList<AndroidVersion> androidList){
        AndroidVersion version= new AndroidVersion();
        version.setVersionName("CupCake");
        version.setVersionNumber("1.5");
        androidList.add(version);

        version.setVersionName("KitKat");
        version.setVersionNumber("2.5");
        androidList.add(version);

        version.setVersionName("Oreo");
        version.setVersionNumber("3.5");
        androidList.add(version);

        version.setVersionName("Jelly Bean");
        version.setVersionNumber("4.5");
        androidList.add(version);
    }
}
