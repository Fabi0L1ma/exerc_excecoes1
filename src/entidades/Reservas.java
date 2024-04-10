package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public Reservas() {
		
	}

	public Reservas(Integer numQuarto, Date checkin, Date checkout) {
		this.numQuarto = numQuarto;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}
	
	private static SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duracao() {	
		//TRANSFORMANDO A DATA EM MILSSEGUNDOS PARA CALCULAR A DISTACIA DE UMA DATA A OUTRA (USAR LONG)
		long calculoDuracao = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(calculoDuracao, TimeUnit.MILLISECONDS);	
	}
	
	public String atualizacaoDatas(Date checkIn, Date checkOut) {
		
		Date dataAtual = new Date();
		
		// ESTE METODO QUE CONFERE SE A DATA SAIDA E A DATA ENTRADA É ANTERIOR A DATA ATUAL
		if(checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
			return "Erro na Reserva: As Datas da Reserva para Atualização Deve ser Datas Futuras";
		}
		
		if(!checkOut.after(checkIn)) { 
			return "Erro na Reserva: A Data de Check-Out Deve Ser Após a Data de Check-In";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}

	@Override
	public String toString() {
		return "Reserva: \nNumero do Quarto: " + numQuarto +
				"\nData de Entrada: " + formatacaoData.format(checkIn) + 
				"\nData de Saida: " + formatacaoData.format(checkOut)+
				"\nDuração: " + duracao() + " Noites";
	}
	
}
