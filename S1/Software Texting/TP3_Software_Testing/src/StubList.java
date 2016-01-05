import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;


public class StubList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList mockedList = mock(LinkedList.class);
		when(mockedList.get(0)).thenReturn("first");
		System.out.println(mockedList.get(0));		
		System.out.println(mockedList.get(999));
	}

}
  