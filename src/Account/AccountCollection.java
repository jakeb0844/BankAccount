package Account;

import java.io.Serializable;

import Storage.PackageCollection;


public class AccountCollection extends PackageCollection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	public AccountCollection(){
		super();
	}
	
	
	
	public void addAccount(Account a)
	{
		super.addElement(a);
		
	}
	
	public Account getAccount(int i)
	{
		return (Account)super.getElement(i);
	}
	
}
