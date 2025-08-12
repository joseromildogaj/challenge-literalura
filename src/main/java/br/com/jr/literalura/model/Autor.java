package br.com.jr.literalura.model;

import br.com.jr.literalura.dto.AutorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;
    private String dataFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros;

//    public Autor(String nome, String dataNascimento, String dataFalecimento, List<Livro> livros) {
//        this.nome = nome;
//        this.dataNascimento = dataNascimento;
//        this.dataFalecimento = dataFalecimento;
//        this.livros = livros;
//    }

    public Autor(AutorDTO autorDTO) {
        this.nome = autorDTO.nome();
        this.dataNascimento = autorDTO.dataNascimento();
        this.dataFalecimento = autorDTO.dataFalecimento();
    }

    public List<AutorDTO> getAutores(Autor autor) {
        List<AutorDTO> autores = new ArrayList<>();
        autores.add(new AutorDTO(autor));
        return autores;
    }

    public Autor() {}

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getNome() {
        return nome;
    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public String getDataNascimento() {
        return dataNascimento;
    }

//    public void setDataNascimento(String dataNascimento) {
//        this.dataNascimento = dataNascimento;
//    }

    public String getDataFalecimento() {
        return dataFalecimento;
    }

//    public void setDataFalecimento(String dataFalecimento) {
//        this.dataFalecimento = dataFalecimento;
//    }

//    public List<Livro> getLivros() {
//        return livros;
//    }

//    public void setLivros(List<Livro> livros) {
//        this.livros = livros;
//    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Data de nascimento: %s
                Data de falecimento: %s
                Livros: %s
                """.formatted(nome, dataNascimento, dataFalecimento, livros);
    }
}
