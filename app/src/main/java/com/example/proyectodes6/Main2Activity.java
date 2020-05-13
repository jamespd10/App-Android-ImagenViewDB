package com.example.proyectodes6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Base64;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Fragment_Descripcion.OnFragmentInteractionListener
    ,Fragment_Ventajas.OnFragmentInteractionListener, Fragment_Actividad.OnFragmentInteractionListener, Fragment_ExperUTP.OnFragmentInteractionListener
    ,Fragment_EjemExito.OnFragmentInteractionListener, Fragment_Creditos.OnFragmentInteractionListener {

    RequestQueue requestQueue;
    TextView txtPrincipal;
    ImageView imgPrincipal;
    int imagen;
    String frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contactenos: estudiante@utp.ac.pa", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*
         *************************
         *************************
         * CODIGO ESCRITO POR JAMES
         * ************************
         * ************************
         */

        txtPrincipal = (TextView)findViewById(R.id.txtPrincipal);
        imgPrincipal = (ImageView)findViewById(R.id.imgPrincipal);
        imagen = R.drawable.novedadb;
        frag ="bienvenido";

        buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V111", imagen, frag);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment=null;
        boolean FragmentTransaction = false;

        if (id == R.id.nav_descripcion) {

            fragment = new Fragment_Descripcion();
            FragmentTransaction = true;
            imagen = R.drawable.ic_menu_camera;
            frag="Descripción";
            buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V111", imagen, frag);
            //fm.beginTransaction().replace(R.id.drawer_layout,new Fragment_ExperUTP()).commit();

            // Handle the camera action

            if(FragmentTransaction){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main2, fragment)
                        .commit();

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
            }
        }  if (id == R.id.nav_ventajas) {

            fragment = new Fragment_Ventajas();
            FragmentTransaction = true;
            imagen = R.drawable.ic_menu_camera;
            frag="Ventajas";
            buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V112", imagen, frag);

            if(FragmentTransaction){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main2, fragment)
                        .commit();

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
            }

        }  if (id == R.id.nav_actividad) {

            fragment = new Fragment_Actividad();
            FragmentTransaction = true;
            imagen = R.drawable.ic_menu_camera;
            frag="actividad";
            buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V113", imagen, frag);

            if(FragmentTransaction){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main2, fragment)
                        .commit();

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
            }


        }  if (id == R.id.nav_exper) {

            fragment = new Fragment_ExperUTP();
            FragmentTransaction = true;
            imagen = R.drawable.ic_menu_camera;
            frag="Experiencia UTP";
            buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V114", imagen, frag);

            if(FragmentTransaction){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main2, fragment)
                        .commit();

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
            }


        }  if (id == R.id.nav_ejemplos) {

            fragment = new Fragment_EjemExito();
            FragmentTransaction = true;
            imagen = R.drawable.ic_menu_camera;
            frag="Ejemplos de Exito";
            buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V115", imagen, frag);

            if(FragmentTransaction){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main2, fragment)
                        .commit();

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
            }


        }  if (id == R.id.nav_creditos) {

            fragment = new Fragment_Creditos();
            FragmentTransaction = true;
            imagen = R.drawable.ic_menu_camera;
            frag="Créditos";
            buscar("http://192.168.43.200:8080/des5/consulta.php?codigo=V116", imagen, frag);

            if(FragmentTransaction){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main2, fragment)
                        .commit();

                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
            }


        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*
    *************************
    *************************
    * CODIGO ESCRITO POR JAMES
    * ************************
    * ************************
     */
    public void buscar(String URL, final int imagen, final String frag){
        int im;
        im = imagen;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for(int g=0; g<response.length(); g++) {
                    try{
                        jsonObject = response.getJSONObject(g);
                        txtPrincipal.setText(jsonObject.getString("biografia"));
                        //byte[] bytecode = Base64.decode(jsonObject.getString("imagen"),Base64.DEFAULT);
                        //Bitmap imag = BitmapFactory.decodeByteArray(bytecode,0,bytecode.length);
                        //imgPrincipal.setImageBitmap(imag);
                        imgPrincipal.setImageResource(imagen);
                        Picasso.with(getApplicationContext()).load("192.168.1.103:8080/Des5/2-PROYECTO/Contenido - Material/1.2/Desarrollador.png").error(R.mipmap.ic_launcher).fit().centerInside().into(imgPrincipal);
                        Toast.makeText(getApplicationContext(),frag,Toast.LENGTH_LONG).show();
                    }
                    catch(JSONException e){
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de conexion",Toast.LENGTH_LONG).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
