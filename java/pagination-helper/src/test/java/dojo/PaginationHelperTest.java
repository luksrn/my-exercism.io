package dojo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Baseado em:
 
	PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
	helper.pageCount(); //should == 2
	helper.itemCount(); //should == 6
	helper.pageItemCount( 0 ); //should == 4
	helper.pageItemCount(1); // last page - should == 2
	helper.pageItemCount(2); // should == -1 since the page is invalid
	
	// pageIndex takes an item index and returns the page that it belongs on
	helper.pageIndex(5); //should == 1 (zero based index)
	helper.pageIndex(2); //should == 0
	helper.pageIndex(20); //should == -1
	helper.pageIndex(-10); //should == -1
	
 */
public class PaginationHelperTest {
	
	PaginationHelper instance;
	
	@Before
	public void setup() {
		instance = new PaginationHelper(6, 4);
	 
	}
	
	@Test
	public void testPageCount(){
		assertThat(  instance.pageCount() , is(2));		
	}
	
	@Test
	public void testItemCount(){
		assertThat(  instance.itemCount() , is(6));
	}
	
	@Test
	public void testePageIndexExistenteItem() {
		assertThat( instance.pageIndex(2), is(0));
		assertThat( instance.pageIndex(5), is(1));
	}
	
	@Test
	public void testePageIndexNaoExisteItem() {
		assertThat( instance.pageIndex(20), is(-1));
		assertThat( instance.pageIndex(-10), is(-1));
	}
	
	@Test
	public void testPageItemCountNaoExite(){
		assertThat( instance.pageItemCount(2), is(-1));
		assertThat( instance.pageItemCount(-2), is(-1));
	}
	
	@Test
	public void testePageItemCount() {
		assertThat( instance.pageItemCount(0), is(4));
		assertThat( instance.pageItemCount(1), is(2));
	}
	
}
