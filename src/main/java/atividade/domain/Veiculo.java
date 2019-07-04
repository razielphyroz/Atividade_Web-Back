package atividade.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idveiculo")
	private Long idVeiculo;
	
	@Column(name="marca", nullable=false)
	@NotBlank(message="A marca é obrigatória!")
	private String marca;
	
	@Column(name="modelo", nullable=false)
	@NotBlank(message="O modelo é obrigatório!")
	private String modelo;
	
	@Column(name="ano", nullable=false)
	@Min(value=2010, message="O ano do veículo não pode ser inferior à 2010.") //Validação de idade máxima do veículo
	@NotNull(message="O ano é obrigatório! (Min 2010)")
	private int ano;
	
	@Column(name="cor", nullable=false)
	@NotBlank(message="A cor é obrigatória!")
	private String cor;
	
	@Size(message = "A placa deve conter 7 digitos. (Não usar traços)", max = 7, min = 7)
	@Column(name="placa", length = 7, nullable=false, unique=true) //Validação do padrão e exclusividade da placa.
	@NotBlank(message="A placa é obrigatória!")
	private String placa;
	
	@Column(name="quilometragem", nullable=false)
	@NotNull(message="A quilometragem é obrigatória!")
	private int quilometragem;
	
	@Column(name="combustivel", nullable=false)
	@NotBlank(message="O tipo de combustível é obrigatório!")
	private String combustivel;
	
	@Column(name="valordiaria", nullable=false)
	@NotNull(message="O valor da diária é obrigatório!")
	private float valorDiaria;
	
	@Column(name="tipo", nullable=false)
	@NotBlank(message="O tipo do carro é obrigatório!")
	private String tipo;
	
	
//-----------------------------------------------------------------------------------------------------------------------------

	
	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
