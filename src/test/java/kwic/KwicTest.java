package kwic;

import java.util.Collections;

import org.junit.Test;

import edu.utd.sa.kwic.AlphabeticShift;
import edu.utd.sa.kwic.CircularShift;
import edu.utd.sa.kwic.CircularShiftInterface;
import edu.utd.sa.kwic.LineStorage;
import edu.utd.sa.kwic.LineStorageInterface;

public class KwicTest {

	@Test
	public void LineStorageTest()
	{
		LineStorageInterface ls = new LineStorage() ;
		ls.setchar(1, 3, 5, 'h');
		assert(ls.CharAt(1, 3, 5)== 'h');
		assert(ls.CharAt(1, 3, 6)== ' ');
		assert(ls.words(1)==1);
		assert(ls.words(3)==0);		
	}
	
	@Test
	public void CircularShiftTest()
	{
		LineStorage ls = new LineStorage() ;
		ls.setchar(1, 1, 1, 'h');
		ls.setchar(1, 1, 2, 'o');
		ls.setchar(1, 1, 3, 'w');
		ls.setchar(1, 2, 1, 'a');
		ls.setchar(1, 2, 2, 'r');
		ls.setchar(1, 2, 3, 'e');
		CircularShiftInterface cs = new CircularShift();
		cs.setup(ls, 1);
		assert(cs.csCharAt(1, 1, 1)== 'h');
		assert(cs.csCharAt(1, 1, 2)== 'o');
		assert(cs.csCharAt(1, 1, 3)== 'w');
		assert(cs.csCharAt(2, 1, 1)== 'a');
		assert(cs.csCharAt(2, 1, 2)== 'r');
		assert(cs.csCharAt(2, 1, 3)== 'e');
		assert(cs.csCharAt(2, 2, 1)== 'h');
		assert(cs.csCharAt(2, 2, 2)== 'o');
		assert(cs.csCharAt(2, 2, 3)== 'w');

	
	}

	@Test
	public void AlphabeticShiftTest()
	{
		LineStorage ls = new LineStorage() ;
		ls.setchar(1, 1, 1, 'h');
		ls.setchar(1, 1, 2, 'o');
		ls.setchar(1, 1, 3, 'w');
		ls.setchar(1, 2, 1, 'a');
		ls.setchar(1, 2, 2, 'r');
		ls.setchar(1, 2, 3, 'e');
		CircularShiftInterface cs = new CircularShift();
		cs.setup(ls, 1);
AlphabeticShift as = new AlphabeticShift();
as.alpha(Collections.singletonList(cs));

	
	}

}
