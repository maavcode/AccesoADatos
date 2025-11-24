package dao;

import java.io.Serializable;
import java.util.List;

import excepciones.BusinessException;

public interface InterfaceDaoGenerico<T, ID extends Serializable> {

	public void grabar(T objeto) throws BusinessException;

	public void actualizar(T objeto) throws BusinessException;

	public void borrar(T objeto) throws BusinessException;

	public void borrar(ID id) throws BusinessException;

	public T buscarPorId(ID id) throws BusinessException;

	public List<T> buscarTodos() throws BusinessException;

	public void grabarOActualizar(T objeto) throws BusinessException;

}
