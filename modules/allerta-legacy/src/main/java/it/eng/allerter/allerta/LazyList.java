package it.eng.allerter.allerta;


import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class LazyList<T> extends AbstractList<T> {

	//LazyLoadingInterface<T> lazyInterface;

	//	@Override
	//	public Object get(int index) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

	//	@Override
	//	public int size() {
	//		// TODO Auto-generated method stub
	//		return 0;
	//	}

	//	private IDataProvider dataAdapter;
	private int totalResultsNumber;
	private int pageSize = 10;
	private int bufferSize = 30;

	/** cache of loadedData items */
	private Map<Integer,T> loadedData;

	/**
	 * 
	 * @param pageSize, the number of rows to be considered as "a page"
	 * @param totalResultsNumber, the total number of rows as result of the database query. 
	 */
	public LazyList(int pageSize, int totalResultsNumber)
	{
		//this.lazyInterface = dataAdapter;
		this.totalResultsNumber = totalResultsNumber;
		this.pageSize = pageSize;
		this.bufferSize = pageSize * 3;
		loadedData = new HashMap<Integer,T>();
	}

//	@Override
//	public List<Volontario> get(int i)
//	{
//		if (!loadedData.containsKey(i))
//		{
//			clearMap();
//
//			int startRow = getStartRow(i);
//
//			int numElementToFind = bufferSize;
//			if ((startRow + numElementToFind) > totalResultsNumber)
//				numElementToFind = totalResultsNumber - startRow;
//
////			List results = dataAdapter.getBufferedData(startRow, numElementToFind);
//			List<Volontario> results = volontarioEjb.getBufferedData(startRow, numElementToFind, false, false, null);
////			for (int j = 0; j < results.size(); j++)
////				loadedData.put((startRow + j), results.get(j));
//			loadedData.put((startRow + j), results.get(j));
//		}
//		return loadedData.get(i);
//
//	}
	@Override
	  public T get(int i)
	  {
	    if (!loadedData.containsKey(i))
	    {
	      clearMap();

	      int startRow = getStartRow(i);

	      int numElementToFind = bufferSize;
	      if ((startRow + numElementToFind) > totalResultsNumber)
	        numElementToFind = totalResultsNumber - startRow;

	      List<T> results = getData(startRow, numElementToFind);
	      for (int j = 0; j < results.size(); j++)
	        loadedData.put((startRow + j), (T) results.get(j));
	    }
	    return loadedData.get(i);

	}

	public List<T> getData(int startRow, int numElementToFind) {
		return null;
	}

	/**
	 * clears the map except the first element that MUST be kept
	 */
	private void clearMap()
	{
		T firstElement = loadedData.get(0);
		loadedData.clear();
		loadedData.put(0, firstElement);
	}

	/**
	 * Calculates the index of the previous page's first element
	 * @param i, the current row index
	 * @return the index of the previous page's first element
	 */
	private int getStartRow(int i)
	{
		int currentPage = (i / pageSize) + 1;

		int firstIndexOfCurrentPage = pageSize * (currentPage - 1);

		int firstIndexOfPreviusPage = firstIndexOfCurrentPage - (bufferSize / 3);

		if (firstIndexOfPreviusPage < 0)
			firstIndexOfPreviusPage = 0;

		return firstIndexOfPreviusPage;
	}

	@Override
	public int size()
	{
		return totalResultsNumber;
	}

	public void setNumResults(int numResults)
	{
		this.totalResultsNumber = numResults;
	}

	@Override
	public void clear()
	{
		loadedData.clear();
	}
}
