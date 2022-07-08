package modelo;

public class Hora {
	private int horas;
	private int minutos;
	private int segundos;
	
	public Hora() {
		horas=0;
		minutos=0;
		segundos=0;
	}
	
	public Hora(int h, int m, int s) {
		if(valida(h,m,s)==true) {
			this.horas=h;
			this.minutos=m;
			this.segundos=s;
		}else {
			this.horas=0;
			this.minutos=0;
			this.segundos=0;
		}
	}
	
	public Hora(Hora h) {
		this.horas=h.horas;
		this.minutos=h.minutos;
		this.segundos=h.segundos;
	}
	
	private static boolean valida(int h, int m, int s) {
		if((h<24 && h>=0) && (m<60 && m>=0) && (s<60 && s>=0)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public int getHoras() {
		return horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}
	
	
	public void setHora(int hora, int minuto, int segundo) {
		if(valida(hora,minuto,segundo)==true) {
			this.horas=hora;
			this.minutos=minuto;
			this.segundos=segundo;
		}
	}
	
	public int aSegundos() {
		return (((this.horas*60)+this.minutos)*60)+this.segundos;
	}
	
	public void deSegundos(int s) {
		int seg = s%60;
		int resto = s/60;
		int min = resto%60;
		int hora = resto/60;
		
		if(hora>24) {
			int diferencia=hora/24;
			hora=hora-(diferencia*24);
		}
		
		this.horas=hora;
		this.minutos=min;
		this.segundos=seg;
	}

	public int segundosEntre(Hora hora) {
		return (((this.horas-hora.horas)*60)+(this.minutos-hora.minutos)*60)+(this.segundos-hora.segundos);
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}
	
	

}
