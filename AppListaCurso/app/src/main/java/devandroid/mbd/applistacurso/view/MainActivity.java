package devandroid.mbd.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import devandroid.mbd.applistacurso.R;
import devandroid.mbd.applistacurso.controller.CursoController;
import devandroid.mbd.applistacurso.controller.PessoaController;
import devandroid.mbd.applistacurso.model.Curso;
import devandroid.mbd.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;
    Pessoa pessoa;
    List<Curso> listaDeCursos;

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

        controller = new PessoaController(MainActivity.this);

        cursoController = new CursoController();
        listaDeCursos = cursoController.getListaCursos();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenomeAluno = findViewById(R.id.editSobrenomeAluno);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefone = findViewById(R.id.editTelefone);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenomeAluno.setText(pessoa.getSobreNome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefone.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenomeAluno.setText("");
                editCursoDesejado.setText("");
                editTelefone.setText("");

                controller.limpar();
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

                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());
    }
}