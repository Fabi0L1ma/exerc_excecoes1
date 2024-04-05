package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int numQuarto = sc.nextInt();
		
		System.out.print("Data Entrada: ");
		Date checkIn = formatacaoData.parse(sc.next());
		
		System.out.print("Data Saida: ");
		Date checkOut = formatacaoData.parse(sc.next());
		
		if(!checkOut.after(checkIn)) { // O TIPO DATA TEM ESTE METODO QUE CONFERE SE UMA DATA SAIDA É DEPOIS QUE A DATA ENTRADA
			System.out.println("Erro na Reserva: A Data de Check-Out Deve Ser Após a Data de Check-In");
			
		}else {
			Reservas reserva = new Reservas(numQuarto, checkIn, checkOut);
			System.out.println("\n" + reserva + "\n");
			
			System.out.println("Dados Atualizados: da Reserva: ");
			
			System.out.print("Data de Entrda: ");
			checkIn = formatacaoData.parse(sc.next());
			
			System.out.print("Data de Saida: ");
			checkOut = formatacaoData.parse(sc.next());
			
			Date dataAtual = new Date();
			
			// ESTE METODO QUE CONFERE SE A DATA SAIDA E A DATA ENTRADA É ANTERIOR A DATA ATUAL
			if(checkIn.before(dataAtual) || checkOut.before(dataAtual)) {
				System.out.println("Erro na Reserva: As Datas da Reserva para Atualização Deve ser Datas Futuras");
				
			}else if(!checkOut.after(checkIn)) { 
				System.out.println("Erro na Reserva: A Data de Check-Out Deve Ser Após a Data de Check-In");
				
			}else {
				reserva.atualizacaoDatas(checkIn, checkOut);
				
				System.out.println("\n" + reserva + "\n");	
			}
			
		}
		
		sc.close();
	}

}
