package com.example;

import com.example.entities.Mercado;
import com.example.entities.Tienda;
import com.example.repositories.MercadoRepository;
import com.example.repositories.TiendaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(App.class, args);

		MercadoRepository mercadoRepo = context.getBean(MercadoRepository.class);

		Mercado mer1 = new Mercado(null, "Veracruz","descripcion",916547548,"veracruz@veracruz.com","Alcorcon","G92009639",10,true);
		Mercado mer2 = new Mercado(null, "Colón","descripcion",916442187,"colon@colon.com","Alcorcon","F59030725",12,false);
		Mercado mer3 = new Mercado(null, "Mayesi","descripcion",916215973,"mayesi@mayesi.com","Alcorcon","B73062730",12,true);
		Mercado mer4 = new Mercado(null, "Valderas","descripcion",916732119,"valderas@valderas.com","Alcorcon","C53597465",10,true);
		Mercado mer5 = new Mercado(null, "Ondarreta","descripcion",916824381,"ondarreta@ondarreta.es","Alcorcon","G93074197",12,true);
		Mercado mer6= new Mercado (null,"Rio Genil","descripción",916921634,"riogenil@riogenil.com","Mostoles","M63739057",10,true);
		Mercado mer7= new Mercado(null,"Constitución","descripción",916810092,"constitucion@constitucion.com","Mostoles","M49043921",10,true);
		Mercado mer8= new Mercado(null,"Cuatrocaminos","descripción",916821691,"cuartocaminos@cuartocaminos.es","Mostoles","M40518306",14,true);
		Mercado mer9= new Mercado(null,"Plaza del Turia","descripción",916910309,"turia@delturia.com","Mostoles","M05800276",12,true);
		Mercado mer10= new Mercado(null,"Centro Iviasa","descripción",916852190,"iviasa@iviasa.com","Mostoles","M64943832",12,false);

		mercadoRepo.saveAll(List.of(mer1,mer2,mer3,mer4,mer5,mer6,mer7,mer8,mer9,mer10));

		TiendaRepository tiendaRepo = context.getBean(TiendaRepository.class);

		var tien1 = new Tienda(null,"Muñoz","descripcion",916509348,"munoz@munoz.es",3,10, LocalTime.of(9,0),LocalTime.of(20,0),mer1);
		var tien2 = new Tienda(null,"Jose Luis","descripcion",916401122,"joseluis@gmail.com",2,9,LocalTime.of(10,0), LocalTime.of(20,0),mer1);
		var tien3 = new Tienda(null,"Hnos. Sanz","descripcion",916940205,"sanz@munoz.es",3,7,LocalTime.of(9,0),LocalTime.of(20,0),mer1);
		var tien4 = new Tienda(null,"Sara","descripcion",916780905,"sara@munoz.es",3,7,LocalTime.of(9,0),LocalTime.of(21,0),mer1);
		var tien5 = new Tienda(null,"Carlos","descripcion",916503729,"carlos@munoz.es",3,6,LocalTime.of(9,0),LocalTime.of(20,0),mer1);
		var tien6 = new Tienda(null, "Isabel","descripcion",918653420,"correo@correo.org",3,5,LocalTime.of(10,0), LocalTime.of(19,0),mer1);

		tiendaRepo.saveAll(List.of(tien1,tien2,tien3,tien4,tien5,tien6));
	}
}



