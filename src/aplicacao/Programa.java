package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reservas;
import excecoes.DominioExcecoes;

public class Programa {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do Quarto: ");
			int numQuarto = sc.nextInt();
			
			System.out.print("Data Entrada: ");
			Date checkIn = formatacaoData.parse(sc.next());
			
			System.out.print("Data Saida: ");
			Date checkOut = formatacaoData.parse(sc.next());
			
			Reservas reserva = new Reservas(numQuarto, checkIn, checkOut);
			
			System.out.println("\n" + reserva + "\n");
			
			System.out.println("Dados Atualizados da Reserva: ");
			
			System.out.print("Data de Entrda: ");
			checkIn = formatacaoData.parse(sc.next());
			
			System.out.print("Data de Saida: ");
			checkOut = formatacaoData.parse(sc.next());
			
			reserva.atualizacaoDatas(checkIn, checkOut);
			
			System.out.println("\n" + reserva + "\n");	
				
		}catch(ParseException e) {
			System.out.println("Formato de Data Invalida!");
			
		}catch(DominioExcecoes e) {
			System.out.println("Erro em Reserva: " + e.getMessage());
			
		}catch(RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}
		
		sc.close();
	}

}
