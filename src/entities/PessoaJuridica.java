package entities;

public class PessoaJuridica extends Pessoa{
	
	private Integer numeroFuncionarios;
	

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public Double taxa() {
		if (numeroFuncionarios > 10) {
			return super.getRendaAnual() * 0.14;
		}
		else
			return super.getRendaAnual() * 0.16;
	}
}
