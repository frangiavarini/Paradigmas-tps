package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

 
	private static final String queueIsEmptyError = "Queue is empty";


  @Test public void test01QueueShouldBeEmptyWhenCreated() {
	assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( queueWithOneElement().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", queueWithOneElement().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueWithOneElement();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = queueWithOneElement();
    assertEquals("Something" , queue.take() );
  }
  
  @Test public void test06QueueBehavesFIFO() {
    Queue queue = newQueue();
    String firstAddedObject = firstAddedObject();
    String secondAddedObject = secondaddedObject();

    addFirstAndSecond(queue, firstAddedObject, secondAddedObject);

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty());
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = newQueue();
    String firstAddedObject = firstAddedObject();
    String secondAddedObject = secondaddedObject();

    addFirstAndSecond(queue, firstAddedObject, secondAddedObject);

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueWithOneElement();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( "First" ).add( "Second" ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = newQueue();  
    assertThrowsLike(()-> queue.take(), queueIsEmptyError );
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = newQueue();
    queue.add( "Something" );
    queue.take();
    assertThrowsLike(()-> queue.take(), queueIsEmptyError );
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = newQueue();
    assertThrowsLike(()->  queue.head(), queueIsEmptyError );
  }
  
  private Queue newQueue() {
		Queue queue = new Queue();
		return queue;
	}
  
  private Queue queueWithOneElement() {
		return new Queue().add( "Something" );
	}
  
  private void assertThrowsLike(Executable executable,String message) {
		assertEquals(message, 
				assertThrows(Error.class,executable).getMessage());
	}
  
	private String firstAddedObject() {
		String firstAddedObject = "First";
		return firstAddedObject;
	}
	
	private String secondaddedObject() {
		String secondAddedObject = "Second";
		return secondAddedObject;
	}
	
	private void addFirstAndSecond(Queue queue, String firstAddedObject, String secondAddedObject) {
		queue.add( firstAddedObject );
	    queue.add( secondAddedObject );
	}
	

}