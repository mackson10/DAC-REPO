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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "volumes")
public class Volume implements Serializable {

    private Long id;
    
    private String siglaEvento;
    private int numeroEvento;
    private String cidadeEvento;
    private String dataInicioEvento;
    private String descricaoPortugues;
    private String descricaoIngles;

    public Volume() {}
    
    public Volume(    
        String siglaEvento,
        int numeroEvento,
        String cidadeEvento,
        String dataInicioEvento,
        String descricaoPortugues,
        String descricaoIngles
    ) {
        this.siglaEvento = siglaEvento;
        this.numeroEvento = numeroEvento;
        this.cidadeEvento = cidadeEvento;
        this.dataInicioEvento = dataInicioEvento;
        this.descricaoPortugues = descricaoPortugues;
        this.descricaoIngles = descricaoIngles;
    }
    
    private Set<Artigo> artigos;

    @OrderBy("ordemVolume")
    @OneToMany(mappedBy="volume")
    public Set<Artigo> getArtigos() {
        return artigos;
    }
    public void setArtigos(Set<Artigo> artigos) {
        this.artigos = artigos;
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
    
    @Column(name = "SIGLA_EVENTO", length = 32)
    public String getSiglaEvento(){
        return siglaEvento;
    }
    public void setSiglaEvento(String siglaEvento){
        this.siglaEvento = siglaEvento;
    }
    
    @Column(name = "NUMERO_EVENTO")
    public int getNumeroEvento(){
        return numeroEvento;
    }
    public void setNumeroEvento(int numeroEvento){
        this.numeroEvento = numeroEvento;
    }
        
    @Column(name = "CIDADE_EVENTO", length = 64)
    public String getCidadeEvento(){
        return cidadeEvento;
    }
    public void setCidadeEvento(String cidadeEvento){
        this.cidadeEvento = cidadeEvento;
    }
            
    @Column(name = "DATA_INICIO_EVENTO")
    public String getDataInicioEvento(){
        return dataInicioEvento;
    }
    public void setDataInicioEvento(String dataInicioEvento){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(dataInicioEvento == null) dataInicioEvento = "0000-01-01";
            Date convertedCurrentDate = sdf.parse(dataInicioEvento);
            String date = sdf.format(convertedCurrentDate);
            this.dataInicioEvento = date;
        } catch (Throwable e) {
            throw new Error("Data inválida, formato deve seguir: ANO-MÊS-DIA ");
        }
    }
    
    @Column(name = "DESCRICAO_PORTUGUES", length = 2048)
    public String getDescricaoPortugues(){
        return descricaoPortugues;
    }
    public void setDescricaoPortugues(String descricaoPortugues){
        this.descricaoPortugues = descricaoPortugues;
    }
    
    @Column(name = "DESCRICAO_INGLES", length = 2048)
    public String getDescricaoIngles(){
        return descricaoIngles;
    }
    public void setDescricaoIngles(String descricaoIngles){
        this.descricaoIngles = descricaoIngles;
    }

}