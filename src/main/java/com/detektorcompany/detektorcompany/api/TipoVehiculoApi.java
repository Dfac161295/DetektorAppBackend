package com.detektorcompany.detektorcompany.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.detektorcompany.detektorcompany.model.TipoVehiculo;
import com.detektorcompany.detektorcompany.service.TipoVehiculoService;

@RestController
@RequestMapping("/tipoVehiculo")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TipoVehiculoApi {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private TipoVehiculoService service;

	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<TipoVehiculo>> getAll(){
		logger.info(" Entro a metodo getAll() ");
		return new ResponseEntity<List<TipoVehiculo>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOne/{dbid}")
	public ResponseEntity<TipoVehiculo> getOne(@PathVariable("dbid") Integer id){
		logger.info(" Entro a metodo getOne");
		TipoVehiculo p = new TipoVehiculo();
		p.setDbid_(id);
		return new ResponseEntity<TipoVehiculo> (service.find(p),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<TipoVehiculo> create(@RequestBody TipoVehiculo obj){
		logger.info(" Entro a metodo create() ");
		return new ResponseEntity<TipoVehiculo> (service.create(obj),HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<TipoVehiculo> update(@RequestBody TipoVehiculo obj){
		logger.info(" Entro a metodo update() ");
		return new ResponseEntity<TipoVehiculo> (service.update(obj),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{dbid}")
	public ResponseEntity<String> delete(@PathVariable("dbid") Integer id){
		logger.info(" Entro a metodo delete() ");
		String message = "";
		TipoVehiculo p = new TipoVehiculo();
		p.setDbid_(id);
		
		try {
			service.delete(p);
			message = "Registro eliminado correctamente";
		} catch (Exception e) {
			message = "Hubo un error al eliminar el registro, para mas informacion puede ver el log.";
			logger.info("Error al eliminar registro >> " + e);
		}
		
		return new ResponseEntity<String> (message,HttpStatus.OK);
	}
	

}
