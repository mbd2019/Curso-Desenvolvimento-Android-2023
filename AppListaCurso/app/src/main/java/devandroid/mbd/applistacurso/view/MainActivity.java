package devandroid.mbd.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import devandroid.mbd.applistacurso.R;
import devandroid.mbd.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        // Atribuir conteúdo, dados, valores para o objeto
        // Conforme o seu modelo, template
        pessoa.setPrimeiroNome("Marcos");
        pessoa.setSobreNome("Dantas");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("16-9999-9999");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Marta");
        outraPessoa.setSobreNome("Dantas");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("16-8888-8888");

        int parada=0;
    }
}