package pe.com.tpp.maestros.controller;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import pe.com.tpp.maestros.model.Puerto;
import pe.com.tpp.maestros.model.response.PuertoResponse;
import pe.com.tpp.maestros.service.IPuertoService;
import pe.com.tpp.maestros.util.Constants;
import pe.com.tpp.maestros.util.ErrorHttp;
import pe.com.tpp.maestros.util.TimeLoggerAgent;
import pe.com.tpp.maestros.util.TimeRecord;

@CrossOrigin(origins = "*", maxAge = 3500, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/v1/maestros")
@ApiResponse(responseCode = "401", headers = {
		@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorHttp.class)), description = "Authentication Failure")
@ApiResponse(responseCode = "400", headers = {
		@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorHttp.class)), description = "Hay un elemento incorrecto")
@ApiResponse(responseCode = "404", headers = {
		@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorHttp.class)), description = "Hay un elemento incorrecto")
@ApiResponse(responseCode = "500", headers = {
		@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorHttp.class)), description = "Hay un elemento incorrecto")
@SecurityRequirement(name = "TPP")
public class PuertoController {

	@Autowired
	private IPuertoService puertoService;

	static final String entidadCadena = "/puerto/";

	@Autowired
	private TimeRecord timeRecord;

	@Autowired
	private TimeLoggerAgent timeLoggerAgent;

	@ApiResponse(responseCode = "200", headers = {
			@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = PuertoResponse.class)))
	@GetMapping(path = "/puerto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PuertoResponse> listarTodo(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {

		// PARA LOG DE ENVENTOS
		String uuid = UUID.randomUUID().toString();
		MDC.put(Constants.CORRELATION_ID_MDC, uuid);
		timeRecord.setCorrelationId(uuid);
		timeRecord.setType(Constants.CODE_INFO_LOG);
		timeRecord.setEndPoint("/puerto/pageNo=" + pageNo + "/pageSize=" + pageSize);
		timeRecord.setStartTime(System.currentTimeMillis());
		// PARA LOG DE ENVENTOS

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		ResponseEntity<PuertoResponse> objListado;
		objListado = puertoService.buscarTodos(paging);

		// PARA LOG DE ENVENTOS
		timeRecord.setStatus(Constants.CODE_OK_200);
		timeRecord.setEndTime(System.currentTimeMillis());
		timeLoggerAgent.logService(timeRecord);
		// PARA LOG DE ENVENTOS
		return objListado;
	}

	@ApiResponse(responseCode = "200", headers = {
			@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = PuertoResponse.class)))
	@GetMapping(path = "/puerto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PuertoResponse> listarPorId(@PathVariable Integer id) {
		// PARA LOG DE ENVENTOS
		String uuid = UUID.randomUUID().toString();
		MDC.put(Constants.CORRELATION_ID_MDC, uuid);
		timeRecord.setCorrelationId(uuid);
		timeRecord.setType(Constants.CODE_INFO_LOG);
		timeRecord.setEndPoint(entidadCadena + id.toString());
		timeRecord.setStartTime(System.currentTimeMillis());
		// PARA LOG DE ENVENTOS

		ResponseEntity<PuertoResponse> objListado = null;
		objListado = puertoService.buscarPorId(id);

		// PARA LOG DE ENVENTOS
		timeRecord.setStatus(Constants.CODE_OK_200);
		timeRecord.setEndTime(System.currentTimeMillis());
		timeLoggerAgent.logService(timeRecord);
		// PARA LOG DE ENVENTOS
		return objListado;
	}

	@ApiResponse(responseCode = "200", headers = {
			@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = PuertoResponse.class)))
	@DeleteMapping(path = "/puerto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PuertoResponse> eliminarPorId(@PathVariable Integer id) {

		// PARA LOG DE ENVENTOS
		String uuid = UUID.randomUUID().toString();
		MDC.put(Constants.CORRELATION_ID_MDC, uuid);
		timeRecord.setCorrelationId(uuid);
		timeRecord.setType(Constants.CODE_INFO_LOG);
		timeRecord.setEndPoint(entidadCadena + id.toString());
		timeRecord.setStartTime(System.currentTimeMillis());
		// PARA LOG DE ENVENTOS

		ResponseEntity<PuertoResponse> encontrado = puertoService.eliminar(id);

		// PARA LOG DE ENVENTOS
		timeRecord.setStatus(Constants.CODE_OK_200);
		timeRecord.setEndTime(System.currentTimeMillis());
		timeLoggerAgent.logService(timeRecord);
		// PARA LOG DE ENVENTOS
		return encontrado;
	}

	@ApiResponse(responseCode = "200", headers = {
			@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = PuertoResponse.class)))
	@PutMapping(path = "/puerto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PuertoResponse> editarPorId(@RequestBody Puerto mEntidad, @PathVariable Integer id) {

		// PARA LOG DE ENVENTOS
		String uuid = UUID.randomUUID().toString();
		MDC.put(Constants.CORRELATION_ID_MDC, uuid);
		timeRecord.setCorrelationId(uuid);
		timeRecord.setType(Constants.CODE_INFO_LOG);
		timeRecord.setEndPoint(entidadCadena + "PUT" + id.toString());
		timeRecord.setStartTime(System.currentTimeMillis());
		// PARA LOG DE ENVENTOS

		ResponseEntity<PuertoResponse> encontrado = puertoService.buscarPorId(id);
		if (encontrado != null)
			puertoService.actualizar(mEntidad, id);

		// PARA LOG DE ENVENTOS
		timeRecord.setStatus(Constants.CODE_OK_200);
		timeRecord.setEndTime(System.currentTimeMillis());
		timeLoggerAgent.logService(timeRecord);
		// PARA LOG DE ENVENTOS
		return encontrado;
	}

	@ApiResponse(responseCode = "200", headers = {
			@Header(name = "Access-Control-Allow-Origin", schema = @Schema(type = "String")) }, content = @Content(mediaType = "application/json", schema = @Schema(implementation = PuertoResponse.class)))
	@PostMapping(path = "/puerto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PuertoResponse> guardar(@RequestBody Puerto mEntidad) {
		// PARA LOG DE ENVENTOS
		String uuid = UUID.randomUUID().toString();
		MDC.put(Constants.CORRELATION_ID_MDC, uuid);
		timeRecord.setCorrelationId(uuid);
		timeRecord.setType(Constants.CODE_INFO_LOG);
		timeRecord.setEndPoint(entidadCadena + "POST");
		timeRecord.setStartTime(System.currentTimeMillis());
		// PARA LOG DE ENVENTOS

		ResponseEntity<PuertoResponse> resultado = puertoService.crear(mEntidad);

		// PARA LOG DE ENVENTOS
		timeRecord.setStatus(Constants.CODE_OK_200);
		timeRecord.setEndTime(System.currentTimeMillis());
		timeLoggerAgent.logService(timeRecord);
		// PARA LOG DE ENVENTOS
		return resultado;
	}
}
