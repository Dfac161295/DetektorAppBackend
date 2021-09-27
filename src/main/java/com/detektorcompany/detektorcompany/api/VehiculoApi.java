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

import com.detektorcompany.detektorcompany.model.Propietario;
import com.detektorcompany.detektorcompany.model.TipoVehiculo;
import com.detektorcompany.detektorcompany.model.Vehiculo;
import com.detektorcompany.detektorcompany.model.VehiculoModel;
import com.detektorcompany.detektorcompany.service.PropietarioService;
import com.detektorcompany.detektorcompany.service.TipoVehiculoService;
import com.detektorcompany.detektorcompany.service.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class VehiculoApi {


	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private PropietarioService servicePropietario;
	
	@Autowired
	private TipoVehiculoService serviceTipoVehiculo;
	
	@Autowired
	private VehiculoService service;

	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Vehiculo>> getAll(){
		logger.info(" Entro a metodo getAll() ");
		return new ResponseEntity<List<Vehiculo>>(service.findAll(),HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/getOne/{placa}")
	public ResponseEntity<Vehiculo> getOne(@PathVariable("placa") String placa){
		logger.info(" Entro a metodo getOne");
		Vehiculo p = new Vehiculo();
		p.setPlaca(placa);
		return new ResponseEntity<Vehiculo> (service.find(p),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllVehiculesAvailables")
	public ResponseEntity<List<Vehiculo>> getAllVehiculesAvailable(){
		logger.info("Entro a metodo getAllVehiculesAvailable() ");
		return new ResponseEntity<List<Vehiculo>>(service.findAllVehiculesAvailable(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllVehiculesByPropietaryId/{dbid}")
	public ResponseEntity<List<Vehiculo>> getAllVehiculesByPropietaryId(@PathVariable("dbid") Integer dbid){
		logger.info("Entro a metodo getAllVehiculesByPropietaryId");
		return new ResponseEntity<List<Vehiculo>>(service.findAllVehiculesByIdPropietary(dbid),HttpStatus.OK);
	}
	
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<Vehiculo> create(@RequestBody VehiculoModel obj){
		logger.info(" Entro a metodo create() ");
		
		Propietario p = new Propietario();
		p.setDbid_(obj.getDbid_propietario());
		
		TipoVehiculo tv = new TipoVehiculo();
		tv.setDbid_(obj.getDbid_tipo_vehiculo());
		
		Propietario p2   = servicePropietario.find(p);
		TipoVehiculo tv2 = serviceTipoVehiculo.find(tv);
		
		if(p2 != null && tv2 != null) {
			Vehiculo v = new Vehiculo(obj.getPlaca(),p2,tv2,obj.getVin(),obj.getMarca(),obj.getCilindrada(),obj.getColor(),obj.getChasis(),obj.getModelo());
			return new ResponseEntity<Vehiculo> (service.create(v),HttpStatus.OK);
		}else {
			return new ResponseEntity<Vehiculo> (new Vehiculo(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Vehiculo> update(@RequestBody VehiculoModel obj){
		logger.info(" Entro a metodo update() ");
		
		Propietario p = new Propietario();
		p.setDbid_(obj.getDbid_propietario());
		
		TipoVehiculo tv = new TipoVehiculo();
		tv.setDbid_(obj.getDbid_tipo_vehiculo());
		
		Propietario p2   = servicePropietario.find(p);
		TipoVehiculo tv2 = serviceTipoVehiculo.find(tv);
		

		if(p2 != null && tv2 != null) {
			Vehiculo v = new Vehiculo(obj.getPlaca(),p2,tv2,obj.getVin(),obj.getMarca(),obj.getCilindrada(),obj.getColor(),obj.getChasis(),obj.getModelo());
			return new ResponseEntity<Vehiculo> (service.update(v),HttpStatus.OK);
		}else {
			return new ResponseEntity<Vehiculo> (new Vehiculo(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	@DeleteMapping(value = "/delete/{placa}")
	public ResponseEntity<String> delete(@PathVariable("placa") String placa){
		logger.info(" Entro a metodo delete() ");
		String message = "";
		Vehiculo p = new Vehiculo();
		p.setPlaca(placa);
		
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
