package mx.unam.unica.tienda2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import mx.unam.unica.tienda2.R;

public class BuscarFragment extends Fragment {
    Toolbar toolbarMain;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buscar,container,false);
        toolbarMain = v.findViewById(R.id.toolbarMain);
           return v;
    }
}
