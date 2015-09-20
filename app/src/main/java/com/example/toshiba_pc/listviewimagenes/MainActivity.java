package com.example.toshiba_pc.listviewimagenes;

import android.app.ListActivity;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity_list);
        String[] columnas = new String[]{"_id", "imagen", "textoSuperior", "textoInferior"};
        MatrixCursor cursor = new MatrixCursor(columnas);
        cursor.addRow(new Object[]{"0", R.drawable.cha, "LOS 3 CHANCHITOS", "Cuento para ninos 3-10 anos."});
        cursor.addRow(new Object[]{"1", R.drawable.bella, "BELLA DURMIENTE", "Cuento para ninos 6-8 anos."});
        cursor.addRow(new Object[]{"2", R.drawable.images, "LA BELLA Y LA BESTIA", "Cuento para ninos 5-9 anos."});
        cursor.addRow(new Object[]{"3", R.drawable.pinocho1, "PINOCHO", "Cuento para ninos 3-12 anos."});
        cursor.addRow(new Object[]{"4", R.drawable.sirena, "SIRENITA", "Cuento para ninos 7-15 anos."});

        String[] desdeEstasColumnas = {"imagen", "textoSuperior", "textoInferior"};
        int[] aEstasViews = {R.id.imageView_imagen, R.id.textView_superior, R.id.textView_inferior};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_main, cursor, desdeEstasColumnas, aEstasViews, 0);

        ListView listado = getListView();
        listado.setAdapter(adapter);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

}