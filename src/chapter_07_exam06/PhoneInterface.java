package chapter_07_exam06;

import java.util.ArrayList;

public interface PhoneInterface<Phone> {
	
	public boolean insertPhone(Phone phone);
	
	public boolean deletePhone(Phone phone);
	
	public ArrayList<Phone> listPhone();
	
	public boolean updatePhone(Phone phone);
	
	public Phone searchPhone(Phone phone);
	
}
