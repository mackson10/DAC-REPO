/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mac
 */
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "artigos")
public class Artigo implements Serializable {

    public enum SiglaIdioma {
        pt, en, es;
    }

    private Long id;
    
    private int ordemVolume;
    private SiglaIdioma idioma;
    private String tituloOriginal;
    private String tituloIngles;
    private String resumoOriginal;
    private String resumoIngles;    
    private String palavrasChaveOriginal;
    private String palavrasChaveIngles;
    private int numeroPaginas;

    
    public Artigo() {}
    
    public Artigo(
        int ordemVolume,
        SiglaIdioma idioma,
        String tituloOriginal,
        String tituloIngles,
        String resumoOriginal,
        String resumoIngles,
        String palavrasChaveOriginal,
        String palavrasChaveIngles,
        int numeroPaginas
    ) {
        this.ordemVolume = ordemVolume;
        this.idioma = idioma;
        this.tituloOriginal = tituloOriginal;
        this.tituloIngles = tituloIngles;
        this.resumoOriginal = resumoOriginal;
        this.resumoIngles = resumoIngles;
        this.palavrasChaveOriginal = palavrasChaveOriginal;
        this.palavrasChaveIngles = palavrasChaveIngles;
        this.numeroPaginas = numeroPaginas;
    }

    private Volume volume;
    
    @ManyToOne
    @JoinColumn(name="ID_VOLUME", nullable=false)
    public Volume getVolume() {
        return volume;
    }
    public void setVolume(Volume volume) {
        this.volume = volume;
    }
    
    private Set<Autor> autores;
    
    @OrderBy("ordemArtigo")
    @OneToMany(mappedBy="artigo")
    public Set<Autor> getAutores() {
        return autores;
    }
    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }


    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
         this.id = id;
    }

    @Column(name = "ORDEM_VOLUME")
    public int getOrdemVolume(){
        return ordemVolume;
    }
    public void setOrdemVolume(int ordemVolume){
        this.ordemVolume = ordemVolume;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "IDIOMA")
    public SiglaIdioma getIdioma(){
        return idioma;
    }
    public void setIdioma(SiglaIdioma idioma){
        this.idioma = idioma;
    }

    @Column(name = "TITULO_ORIGINAL", length = 256)
    public String getTituloOriginal(){
        return tituloOriginal;
    }
    public void setTituloOriginal(String tituloOriginal){
        this.tituloOriginal = tituloOriginal;
    }
    
    @Column(name = "TITULO_INGLES", length = 256)
    public String getTituloIngles(){
        return tituloIngles;
    }
    public void setTituloIngles(String tituloIngles){
        this.tituloIngles = tituloIngles;
    }

    @Column(name = "RESUMO_ORIGINAL", length = 2048)
    public String getResumoOriginal(){
        return resumoOriginal;
    }
    public void setResumoOriginal(String resumoOriginal){
        this.resumoOriginal = resumoOriginal;
    }

    @Column(name = "RESUMO_INGLES", length = 2048)
    public String getResumoIngles(){
        return resumoIngles;
    }
    public void setResumoIngles(String resumoIngles){
        this.resumoIngles = resumoIngles;
    }

    @Column(name = "PALAVRAS_CHAVE_ORIGINAL", length = 256)
    public String getPalavrasChaveOriginal(){
        return palavrasChaveOriginal;
    }
    public void setPalavrasChaveOriginal(String palavrasChaveOriginal){
        this.palavrasChaveOriginal = palavrasChaveOriginal;
    }

    @Column(name = "PALAVRAS_CHAVE_INGLES", length = 256)
    public String getPalavrasChaveIngles(){
        return palavrasChaveIngles;
    }
    public void setPalavrasChaveIngles(String palavrasChaveIngles){
        this.palavrasChaveIngles = palavrasChaveIngles;
    }

    @Column(name = "NUMERO_PAGINAS")
    public int getNumeroPaginas(){
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas){
        this.numeroPaginas = numeroPaginas;
    }
}
