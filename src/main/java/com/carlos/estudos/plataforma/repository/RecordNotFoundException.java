package com.carlos.estudos.plataforma.repository;

@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException {
	public RecordNotFoundException(String message) {
		super(message);
	}
}
