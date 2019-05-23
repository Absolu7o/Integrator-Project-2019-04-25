package model;
// Generated 12/05/2019 21:50:56 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = ":NomeTabela:", schema = ":NomeSchema:")
public class :NomeClass: implements java.io.Serializable {

    private :TipoVariaveisCampo: :NomeVariaveisCampo:; //String, Integer, Character, Date, BigDecimal, Classe(Campo FK)
	
	//Tabela FK - Ex: Tabela 'requestproduct'(Tabela FK) tem FK para 'product'
    private Set<:ObjetoTabelaFK:> :NomeObjeto: = new HashSet<:ObjetoTabelaFK:>(0);

    public :NomeClass:() {
    }

    public :NomeClass:(int code) {
        this.code = code;
    }

    public :NomeClass:(int code, :Variaveis:) {
        this.code = code;
		this.:Variaveis: = :Variaveis:;
    }

	//Notacoes para metodo 'get'
	
	//Campo PK
    @Id
    @Column(name = "code", unique = true, nullable = false)
    public int getCode() {
        return this.code;
    }

	//Campo FK
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name=":NomeCampo:")

	
	//Campos Comuns
	//Campo Varchar > Variavel String
    @Column(name = ":NomeCampo:", length = :TamanhoCampo:)
	
	//Campo Char > Variavel Character
    @Column(name = ":NomeCampo:", length = :TamanhoCampo:)
	
	//Campo Decimal > Variavel BigDecimal
    @Column(name=":NomeCampo:", precision=:TamanhoCampo:)
	
	//Campo Integer > Variavel Integer
    @Column(name=":NomeCampo:")
	
	//Campo TimeStamp > Variavel Date
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name=":NomeCampo:", precision=29)

	//Associativa com PK Compartilhada
	//Tabela com a PK Compartilhada
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	
	//Tabela apontada pela PK Compartilhada (Cria Objeto da Classe)
	@OneToOne(fetch=FetchType.LAZY, mappedBy=":NomeTabela:")

	//Tipo Set - private Set<....
	//Tabela apontada por FK
    @OneToMany(fetch = FetchType.LAZY, mappedBy = ":NomeTabela:")
	

    
}
