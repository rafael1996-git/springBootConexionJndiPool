package com.ine.cartografia.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ine.cartografia.dao.IServiceDao;
import com.ine.cartografia.entity.Usuario;
@CrossOrigin(origins = "*", methods = { RequestMethod.GET})
@RestController()
public class Controlador {
	private final Logger logger = LoggerFactory.getLogger(Controlador.class);
	/**
	 * Metodo que brinda el servicio de la consulta de Cp con parametros clave_entidad tipo GET
	 * 
	 * EXECUTE DEPLOY mvn wildfly:deploy  -P serverLocal
	 * 
	 * http://localhost:8080/api/lista/
	 * 
	 * 
	 * @param /
	 * @param /lista 
	 * @return retorna la lista 
	 * @throws Exception si no logra obtener la conexion
	 */
	@Autowired
	private IServiceDao Consulta;
	  
	   @GetMapping("/lista")
	   public List<Usuario> passParametersWithModelAndView(HttpServletRequest request) throws  Exception{
		   List<Usuario> lista = Consulta.GetAll();
		   logger.debug("consulta "+lista);
		    return  lista;
		}
	   @GetMapping("/")
		public List<Usuario> index(HttpServletRequest request) throws  Exception{
		   List<Usuario> lista = Consulta.GetAll();
		   logger.debug("consulta "+lista);
			return lista;
		}
}
