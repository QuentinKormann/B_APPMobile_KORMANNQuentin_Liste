package com.example.killxportable.tp_liste;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {

    
    private final Context context;
    private final ArrayList<AndroidVersion> AndroidVersionList;
    private final Resources res;
    private final int viewRes;

    public AndroidAdapter (Context context, int textViewResourceld, ArrayList<AndroidVersion> versions)
    {
        super(context, textViewResourceld, versions);
        this.AndroidVersionList = versions;
        this.context = context;
        this.res = context.getResources();
        this.viewRes = textViewResourceld;
    }

    static class ViewHolder
    {
        TextView title;
        TextView description;
    }

    @Override //Il faut implémenter getView ici
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false); //cf. jeu du pendu et explications effectuée en cours…
            holder = new ViewHolder();
            holder.title= (TextView) view.findViewById(R.id.title);
            holder.description = (TextView) view.findViewById(R.id.tv_version);
            view.setTag(holder);
        } else {
            holder= (ViewHolder) view.getTag();
        }
        final AndroidVersion androidVersion = AndroidVersionList.get(position);
        if (androidVersion != null) {
            final String versionName = String.format("Nom de la version : %s", androidVersion.getVersionName());
            holder.title.setText(versionName);
            final String versionNumber = String.format("Numéro de la version : %s", androidVersion.getVersionNumber());
            holder.description.setText(versionNumber);
        }
        return view;
    }

    //Nombre d’éléments de la liste
    public int getCount() {
        return AndroidVersionList.size();
    }
}
