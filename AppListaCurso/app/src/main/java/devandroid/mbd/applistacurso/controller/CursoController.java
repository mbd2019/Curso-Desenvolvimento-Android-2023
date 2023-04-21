package devandroid.mbd.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.mbd.applistacurso.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaCursos(){

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("PHP"));
        listCursos.add(new Curso("Java EE"));
        listCursos.add(new Curso("Fluter"));
        listCursos.add(new Curso("Dart"));

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size(); i++) {

            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getNomeDoCurso());
        }
        return dados;
    }
}
