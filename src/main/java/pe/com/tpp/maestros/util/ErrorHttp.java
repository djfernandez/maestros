package pe.com.tpp.maestros.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorHttp {
	@JsonProperty("timestamp")
	String timestamp;
	@JsonProperty("status")
	String status;
	@JsonProperty("error")
	String error;
	@JsonProperty("message")
	String message;
	@JsonProperty("path")
	String path;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
