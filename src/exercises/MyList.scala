package exercises

//todo refactor
trait MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

}

object EmptyList extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException // returns nothing. will throw an exception
  // NotImplementedError

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new CLinkedList[B](element, this)
}

class CLinkedList[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = this

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new CLinkedList(element, this)
}
