package br.com.local.listaplanetasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Conteúdo que será inserido na ListView
    String nomePlanetas[] = {"Sapiens: Uma Breve História da Humanidade", "Homo Deus", "Princípios Matemáticos da Filosofia Natural",
            "Palido ponto azul: uma visão do futuro da humanidade no espaço", "O Banquete",
            "Crítica da Razão Pura", "Uma Breve História do Tempo", "O Universo Numa Casca de Noz",
            "A Teoria da Relatividade Especial e Geral", "Por uma Nova Liberdade: O Manifesto Libertário",
            "Discurso do Método", "A Origem das Espécies", "Astrofísica Para Apressados", "1984",
            "Cem Anos de Solidão", "Dom Casmurro", "Laranja Mecânica", "O Diário de Anne Frank",
            "Os Miseráveis", "Crime e Castigo"};

    int imgPlanetas[] = {R.drawable.sapiens, R.drawable.homo_deus,
            R.drawable.principia, R.drawable.palido_ponto_azul, R.drawable.o_banquete,
            R.drawable.critica_da_razao_pura, R.drawable.uma_breve_historia_do_tempo,
            R.drawable.o_universo_numa_casca_de_noz, R.drawable.a_teoria_da_relatividade_especial_e_geral,
            R.drawable.o_manifesto_libertario, R.drawable.discurso_do_metodo, R.drawable.a_origem_das_especies,
            R.drawable.astrofisica_para_apressados, R.drawable.go1984, R.drawable.cem_anos_de_solidao,
            R.drawable.dom_casmurro, R.drawable.laranja_mecanica, R.drawable.o_diario_de_anne_frank,
            R.drawable.os_miseraveis, R.drawable.crime_e_castigo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarando a listView java com o XML
        listView = findViewById(R.id.listaPlanetas);

        //Criar o adaptador para instânciar o modelo layout a listView
        CustomAdapter adapter = new CustomAdapter();

        //Neste momento será feita a implementação da lista
        listView.setAdapter(adapter);

        //Implementar o click no item da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              Intent intent = new Intent(getApplicationContext(),VisualizaPlanetas_Activity.class);
              //É necessário utilizar o intent para passar os valores para outra activity
                //Implementar o putExtra

                intent.putExtra("nomePlanetas",nomePlanetas[i]);
                intent.putExtra("imgPlanetas",imgPlanetas[i]);

                startActivity(intent);

            }
        });
    }

    //Criar o objeto ou a classe CustomAdapter extendendo o BaseAdapter
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imgPlanetas.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Método que irá instânciar o modelo
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            TextView txtNomePlanetas;
            ImageView imagemPlanetas;

            View carregaView = getLayoutInflater().inflate(R.layout.modelo_planetas_layout,null);

            txtNomePlanetas = carregaView.findViewById(R.id.txtListaPlaneta);
            imagemPlanetas = carregaView.findViewById(R.id.imgListaPlaneta);

            txtNomePlanetas.setText(nomePlanetas[i]);
            imagemPlanetas.setImageResource(imgPlanetas[i]);


            return carregaView;
        }
    }

}