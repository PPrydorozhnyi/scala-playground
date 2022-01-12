package exercises

trait MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def map[C](myTransformer: MyTransformer[A, C]): MyList[C]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def flatMap[C](myTransformer: MyTransformer[A, MyList[C]]): MyList[C]
  def ++[B >: A](list: MyList[B]): MyList[B]

}

object EmptyList extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException // returns nothing. will throw an exception
  // NotImplementedError

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new CLinkedList[B](element, this)

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = this

  override def flatMap[C](myTransformer: MyTransformer[Nothing, MyList[C]]): MyList[C] = this

  override def map[C](myTransformer: MyTransformer[Nothing, C]): MyList[C] = this

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class CLinkedList[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = this

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new CLinkedList(element, this)

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h))
      new CLinkedList[A](h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def flatMap[C](myTransformer: MyTransformer[A, MyList[C]]): MyList[C] = {
    myTransformer.transform(h) ++ t.flatMap(myTransformer)
  }

  override def map[C](myTransformer: MyTransformer[A, C]): MyList[C] = {
    new CLinkedList(myTransformer.transform(h), t.map(myTransformer))
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = new CLinkedList[B](h, t ++ list)
}

trait MyPredicate[-T] {
  def test(valueToTest: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}
