package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	private Integer numQuarto;
	private Date checkin;
	private Date checkout;
	
	public Reservas() {
		
	}

	public Reservas(Integer numQuarto, Date checkin, Date checkout) {
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	private static SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {	
		//TRANSFORMANDO A DATA EM MILSSEGUNDOS PARA CALCULAR A DISTACIA DE UMA DATA A OUTRA (USAR LONG)
		long calculoDuracao = checkout.getTime() - checkin.getTime();
		
		return TimeUnit.DAYS.convert(calculoDuracao, TimeUnit.MILLISECONDS);	
	}
	
	public void atualizacaoDatas(Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Reserva: \nNumero do Quarto: " + numQuarto +
				"\nData de Entrada: " + formatacaoData.format(checkin) + 
				"\nData de Saida: " + formatacaoData.format(checkout)+
				"\nDuração: " + duracao() + " Noites";
	}
	
}
