package dao;

import java.io.Serializable;
import java.util.List;

import excepciones.BusinessException;


public class DaoGenerico <T, ID extends Serializable> 
implements InterfaceDaoGenerico<T,ID> {
	
	@Override
	public void grabar(T objeto) throws BusinessException
	{
		throw new RuntimeException();
	
	}
	
	@Override
	public void actualizar (T objeto) throws BusinessException
	{
		throw new RuntimeException();
	
	}
	@Override

	public void borrar (T objeto) throws BusinessException
	{
		throw new RuntimeException();
	
	}
	@Override

	public void borrar (ID id) throws BusinessException
	{
		throw new RuntimeException();
	
	}
	@Override

	public T buscarPorId (ID id) throws BusinessException
	{
		throw new RuntimeException();
	
	}
	@Override

	public List<T>buscarTodos () throws BusinessException
	{
		throw new RuntimeException();
	
	}
	@Override
	public void grabarOActualizar(T objeto) throws BusinessException
	{
		throw new RuntimeException();
	
	}

}
