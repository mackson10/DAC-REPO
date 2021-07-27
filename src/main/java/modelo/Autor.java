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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {

    public enum SiglaPaisOrigem {
        BR, PT, US, FR, UK, ES;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static final Pattern VALID_ORCID_REGEX
            = Pattern.compile("^(?:orcid.org\\/)?(\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{3}(?:\\d|X))$", Pattern.CASE_INSENSITIVE);

    public static boolean validateORCID(String orcidStr) {
        Matcher matcher = VALID_ORCID_REGEX.matcher(orcidStr);
        return matcher.find();
    }

    private Long id;

    private int ordemArtigo;
    private String email;
    private String primeiroNome;
    private String nomeDoMeio;
    private String sobrenome;
    private String afiliacao;
    private String afiliacaoIngles;
    private SiglaPaisOrigem paisOrigem;
    private String registroORCID;

    public Autor() {
    }
    
    public Autor(
        int ordemArtigo,
        String email,
        String primeiroNome,
        String nomeDoMeio,
        String sobrenome,
        String afiliacao,
        String afiliacaoIngles,
        SiglaPaisOrigem paisOrigem,
        String registroORCID
    ) {
        this.ordemArtigo = ordemArtigo;
        this.email = email;
        this.primeiroNome = primeiroNome;
        this.nomeDoMeio = nomeDoMeio;
        this.sobrenome = sobrenome;
        this.afiliacao = afiliacao;
        this.afiliacaoIngles = afiliacaoIngles;
        this.paisOrigem = paisOrigem;
        this.registroORCID = registroORCID;
    }

    private Artigo artigo;

    @ManyToOne
    @JoinColumn(name = "ID_ARTIGO", nullable = false)
    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
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

    @Column(name = "ORDEM_ARTIGO")
    public int getOrdemArtigo() {
        return ordemArtigo;
    }

    public void setOrdemArtigo(int ordemArtigo) {
        this.ordemArtigo = ordemArtigo;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validateEmail(email)) {
            throw new Error("Email inválido!!");
        }

        this.email = email;
    }

    @Column(name = "PRIMEIRO_NOME", length = 64)
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    @Column(name = "NOME_DO_MEIO", length = 64)
    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    @Column(name = "SOBRENOME", length = 64)
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Column(name = "AFILIACAO", length = 256)
    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    @Column(name = "AFILIACAO_INGLES", length = 256)
    public String getAfiliacaoIngles() {
        return afiliacaoIngles;
    }

    public void setAfiliacaoIngles(String afiliacaoIngles) {
        this.afiliacaoIngles = afiliacaoIngles;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "PAIS_ORIGEM")
    public SiglaPaisOrigem getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(SiglaPaisOrigem paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    @Column(name = "REGISTRO_ORCID")
    public String getRegistroORCID() {
        return registroORCID;
    }

    public void setRegistroORCID(String registroORCID) {
        if (!validateORCID(registroORCID)) {
            throw new Error("ORCID inválido!");
        }
        this.registroORCID = registroORCID;
    }

}
