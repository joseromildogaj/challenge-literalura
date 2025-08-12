package br.com.jr.literalura.model;

import br.com.jr.literalura.dto.AutorDTO;
import br.com.jr.literalura.dto.LivroDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private List<String> idiomas;
    private Integer numeroDownloads;

//    public Livro(String titulo, Autor autor, List<String> idiomas, Integer numeroDownloads) {
//        this.titulo = titulo;
//        this.autor = autor;
//        this.idiomas = idiomas;
//        this.numeroDownloads = numeroDownloads;
//    }

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.titulo();
        this.autor = new Autor(livroDTO.autores().getFirst());
        this.idiomas = livroDTO.idiomas();
        this.numeroDownloads = livroDTO.numeroDownloads();
    }

    public List<AutorDTO> getAutores() {
        List<AutorDTO> autores = new ArrayList<>();
        autores.add(new AutorDTO(this.autor));
        return autores;
    }

    public Livro() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitulo() {
        return titulo;
    }

//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//    }
//
//    public Autor getAutor() {
//        return autor;
//    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

//    public void setIdiomas(List<String> idiomas) {
//        this.idiomas = idiomas;
//    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

//    public void setNumeroDownloads(Integer numeroDownloads) {
//        this.numeroDownloads = numeroDownloads;
//    }

    @Override
    public String toString() {
        return """
                Título: %s
                Autores: %s
                Idioma: %s
                Numero downloads: %s
                """.formatted(titulo, autor, idiomas, numeroDownloads);
    }
}
