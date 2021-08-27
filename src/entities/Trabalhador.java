package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador level;
	private Double salarioBase;
	
	private List<HoraContrato> contratos = new ArrayList<>();
	private Departamento departamento;
	
	public Trabalhador() {
		
	}
	public Trabalhador(String nome, NivelTrabalhador level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NivelTrabalhador getLevel() {
		return level;
	}
	public void setLevel(NivelTrabalhador level) {
		this.level = level;
	}	
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<HoraContrato> getContratos() {
		return contratos;
	}
	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double entradas(Integer ano, Integer mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(HoraContrato hC : contratos) {
			cal.setTime(hC.getData());
			int hCAno = cal.get(Calendar.YEAR);
			int hCMes = 1 + cal.get(Calendar.MONTH);
			if(ano == hCAno && mes == hCMes) {
				soma += hC.valorTotal();
			}
		}		
		return soma;
	}
}
