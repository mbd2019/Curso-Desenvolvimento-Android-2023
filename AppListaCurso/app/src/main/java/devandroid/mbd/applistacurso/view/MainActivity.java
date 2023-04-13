package devandroid.mbd.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.mbd.applistacurso.R;
import devandroid.mbd.applistacurso.controller.PessoaController;
import devandroid.mbd.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    PessoaController controller;
    Pessoa pessoa;
    Pessoa outraPessoa;
    String dadosPessoa;
    String dadosOutraPessoa;

    EditText editPrimeiroNome;
    EditText editSobrenomeAluno;
    EditText editCursoDesejado;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();
        pessoa = new Pessoa();
        outraPessoa = new Pessoa();

        outraPessoa.setPrimeiroNome("Marta");
        outraPessoa.setSobreNome("Dantas");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("16-8888-8888");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenomeAluno = findViewById(R.id.editSobrenomeAluno);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenomeAluno.setText(pessoa.getSobreNome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenomeAluno.setText("");
                editCursoDesejado.setText("");
                editTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenomeAluno.getText().toString());
                pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo com sucesso. " + pessoa.toString(), Toast.LENGTH_SHORT).show();

                listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome",pessoa.getSobreNome());
                listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
                listaVip.apply();

                controller.salvar(pessoa);
            }
        });

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += " Curso desejado: ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());
    }
}